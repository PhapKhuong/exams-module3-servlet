package com.bean;

public class Payment {
    private int payId;
    private String payName;

    public Payment() {
    }

    public Payment(int payId, String payName) {
        this.payId = payId;
        this.payName = payName;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }
}
