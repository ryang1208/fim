package com.huaxin.fim.entity.entity;


public class BasicDeposit {

    private String date;

    private String investerId;

    private int brokerId;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInvesterId() {
        return investerId;
    }

    public void setInvesterId(String investerId) {
        this.investerId = investerId;
    }

    public int getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(int brokerId) {
        this.brokerId = brokerId;
    }

}
