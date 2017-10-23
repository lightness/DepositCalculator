package com.example.uladzimir.myapplication;


public class DepositParams {

    private Double sum = 0D;
    private Integer days = 0;
    private Integer capitalizationMonths = 12;
    private Double percent = 0D;

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getCapitalizationMonths() {
        return capitalizationMonths;
    }

    public void setCapitalizationMonths(Integer capitalizationMonths) {
        this.capitalizationMonths = capitalizationMonths;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }
}
