package com.trueaccord.debt.admin;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trueaccord.debt.entity.Debt;
import com.trueaccord.debt.entity.Payment;
import com.trueaccord.debt.entity.PaymentPlan;
import com.trueaccord.debt.util.DebtUtils;
import com.trueaccord.debt.util.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//TODO use Lombock - remove getters and setters from all classes

@SpringBootApplication
public class DebtAdminConsoleApp
  implements CommandLineRunner {

    final static String PAYMENT_PLANS_URL = "https://my-json-server.typicode.com/druska/trueaccord-mock-payments-api/payment_plans";
    final static String DEBTS_URL = "https://my-json-server.typicode.com/druska/trueaccord-mock-payments-api/debts";
    final static String PAYMENTS_URL = "https://my-json-server.typicode.com/druska/trueaccord-mock-payments-api/payments";


/* TODO
    @Autowired
*/
    DebtUtils debtUtils = new DebtUtils();

    private static Logger LOG = LoggerFactory
      .getLogger(DebtAdminConsoleApp.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(DebtAdminConsoleApp.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    static String getDebtsJSON() throws IOException {
        return HttpClient.get(DEBTS_URL);
    }

    static String getPaymentPlansJSON() throws IOException {
        return HttpClient.get(PAYMENT_PLANS_URL);
    }

    static String getPaymentsJSON() throws IOException {
        return HttpClient.get(PAYMENTS_URL);
    }

    @Override
    public void run(String... args) throws IOException, ParseException {
        LOG.info("EXECUTING : command line runner");

        ObjectMapper objectMapper = new ObjectMapper();
        List<Debt> debtsList = objectMapper.readValue(getDebtsJSON(), new TypeReference<List<Debt>>(){});
        List<PaymentPlan> paymentPlansList = objectMapper.readValue(getPaymentPlansJSON(), new TypeReference<List<PaymentPlan>>(){});
        List<Payment> paymentsList = objectMapper.readValue(getPaymentsJSON(), new TypeReference<List<Payment>>(){});

        System.out.println("********************************** APPLICATION OUTPUT **********************************");

        System.out.println("********** DEBTS");
        objectMapper = new ObjectMapper();
        for(Debt d: debtsList) {
            d.setRemainingAmount(d.getAmount());
            debtUtils.adjustDebtAgainstPaymentPlan(d, paymentPlansList, paymentsList);
            System.out.println(objectMapper.writeValueAsString(d));
        }
        System.out.println("********** PAYMENT PLANS");
        for(PaymentPlan pp: paymentPlansList) {
            System.out.println(objectMapper.writeValueAsString(pp));
        }
        System.out.println("********** PAYMENTS");
        for(Payment p: paymentsList) {
            System.out.println(objectMapper.writeValueAsString(p));
        }
    }

/*    //TODO switch to Streams API or too trivial?
    private void adjustDebtAgainstPaymentPlan(Debt debt, List<PaymentPlan> paymentPlansList,  List<Payment> paymentsList) throws ParseException {
        List<Payment> planPayments = new ArrayList<>();
        for(PaymentPlan pp: paymentPlansList) {
            if(pp.getDebtId() == debt.getId()) {
                debt.setInPaymentPlan(true);
                debt.setRemainingAmount(pp.getAmountToPay());

                for(Payment p: paymentsList) {
                    if(p.getPaymentPlanId() == pp.getId()) {
                        planPayments.add(p);
                    }
                }
                debt.setNextPaymentDueDate(calculateNextPaymentDueDate(pp, planPayments));
            }
        }
    }

    *//*
    Add a new field to the Debt object output: "next_payment_due_date",
        containing the ISO 8601 UTC date (i.e. “2019-09-07”) of when the next payment is due
        or null if there is no payment plan or if the debt has been paid off.
    The next_payment_due_date can be calculated by using the payment plan start_date and installment_frequency.
        It should be the next installment date after the latest payment, even if this date is in the past.
        The next_payment_due_date should be null if there is no payment plan or if the debt has been paid off.
    Payments made on days outside the expected payment schedule still go toward paying off the remaining_amount, but do not change/delay the payment schedule.
     *//*
    private String calculateNextPaymentDueDate(PaymentPlan pp, List<Payment> planPayments) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date latestPaymentDate = calculateLatestPaymentDate(planPayments);
        Date planStartDate = sdf.parse(pp.getStartDate());
        Date nextPaymentDueDate = planStartDate;

        if(planStartDate.compareTo(latestPaymentDate) >= 0) {
            nextPaymentDueDate = planStartDate;
        }
        else {
            int days =  0;
            switch(pp.getInstallmentFrequency()) {
                case "WEEKLY":
                    days = 7;
                    break;
                case "BI_WEEKLY":
                    days = 14;
                    break;
                default:
                    break;
            }
            Calendar c = Calendar.getInstance();
            c.setTime(nextPaymentDueDate);
            while(nextPaymentDueDate.compareTo(latestPaymentDate) <= 0) {
                c.add(Calendar.DATE, days);
                nextPaymentDueDate = c.getTime();
            }
        }

        return sdf.format(nextPaymentDueDate);
    }

    private Date calculateLatestPaymentDate(List<Payment> planPayments) throws ParseException {
        if(planPayments == null || planPayments.size() == 0) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date latestPaymentDate = sdf.parse(planPayments.get(0).getDate());
        Date paymentDate;
        for(Payment p: planPayments) {
            paymentDate = sdf.parse(p.getDate());
            int result = paymentDate.compareTo(latestPaymentDate);
            if (result > 0) {
                latestPaymentDate = paymentDate;
            }
        }
        return latestPaymentDate;
    }*/
}