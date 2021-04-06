package com.trueaccord.debt.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class PaymentPlan {
    Integer id;
    @JsonProperty("debt_id")
    Integer debtId;
    @JsonProperty("amount_to_pay")
    Double amountToPay;
    @JsonProperty("installment_frequency")
    String installmentFrequency; //TODO make this INSTALLMENT_FREQUENCY enum
    @JsonProperty("installment_amount")
    Double installmentAmount;
    @JsonProperty("start_date")
    String startDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDebtId() {
        return debtId;
    }

    public void setDebtId(Integer debtId) {
        this.debtId = debtId;
    }
    public Double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(Double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public String getInstallmentFrequency() {
        return installmentFrequency;
    }

    public void setInstallmentFrequency(String installmentFrequency) {
        this.installmentFrequency = installmentFrequency;
    }

    public Double getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(Double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public PaymentPlan() {

    }
    public PaymentPlan(Integer id, Integer debtId, Double amountToPay, String installmentFrequency, Double installmentAmount, String startDate) {
        this.id = id;
        this.debtId = debtId;
        this.amountToPay = amountToPay;
        this.installmentFrequency = installmentFrequency;
        this.installmentAmount = installmentAmount;
        this.startDate = startDate;
    }
}
