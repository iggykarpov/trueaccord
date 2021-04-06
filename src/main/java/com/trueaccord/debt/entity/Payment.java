package com.trueaccord.debt.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Payment {
    @JsonProperty("payment_plan_id")
    Integer paymentPlanId;
    Double amount;
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Integer getPaymentPlanId() {
        return paymentPlanId;
    }

    public void setPaymentPlanId(Integer paymentPlanId) {
        this.paymentPlanId = paymentPlanId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Payment() {

    }
    public Payment(Integer paymentPlanId, Double amount, String date) {
        this.paymentPlanId = paymentPlanId;
        this.amount = amount;
        this.date = date;
    }
}
