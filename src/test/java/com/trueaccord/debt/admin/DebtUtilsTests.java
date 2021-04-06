package com.trueaccord.debt.admin;

import com.trueaccord.debt.entity.Debt;
import com.trueaccord.debt.entity.Payment;
import com.trueaccord.debt.entity.PaymentPlan;
import com.trueaccord.debt.util.DebtUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = DebtAdminConsoleApp.class)
class DebtUtilsTests {

	DebtUtils debtUtils = new DebtUtils();
	Debt debt = new Debt(0, 123.46);
	Payment payment1 = new Payment(0, 51.25, "2020-09-29");
	Payment payment2 = new Payment(0, 51.25, "2020-10-29");
	List<Payment> paymentsList = new ArrayList<>();
	PaymentPlan paymentPlan = new PaymentPlan(0, 0, 102.5, "WEEKLY", 51.25, "2020-09-28");
	List<PaymentPlan> paymentPlansList = new ArrayList<>();

	@Test
	void adjustDebtAgainstPaymentPlan() throws ParseException {
		paymentsList.add(payment1);
		paymentsList.add(payment2);
		paymentPlansList.add(paymentPlan);
		debtUtils.adjustDebtAgainstPaymentPlan(debt, paymentPlansList, paymentsList);
		Assert.assertEquals(debt.getNextPaymentDueDate(), "2020-11-02");
	}

}
