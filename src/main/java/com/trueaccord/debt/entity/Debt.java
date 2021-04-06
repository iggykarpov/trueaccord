package com.trueaccord.debt.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Debt {

    Integer id;
    Double amount;
    @JsonProperty("is_in_payment_plan")
    Boolean isInPaymentPlan;
    @JsonProperty("remaining_amount")
    Double remainingAmount;
    @JsonProperty("next_payment_due_date")
    String nextPaymentDueDate;

    public Boolean getInPaymentPlan() {
        return isInPaymentPlan;
    }

    public void setInPaymentPlan(Boolean inPaymentPlan) {
        isInPaymentPlan = inPaymentPlan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }


    public String getNextPaymentDueDate() {
        return nextPaymentDueDate;
    }

    public void setNextPaymentDueDate(String nextPaymentDueDate) {
        this.nextPaymentDueDate = nextPaymentDueDate;
    }

    public Debt() {

    }
    public Debt(Integer id, Double amount) {
        this.id = id;
        this.amount = amount;
    }
}
