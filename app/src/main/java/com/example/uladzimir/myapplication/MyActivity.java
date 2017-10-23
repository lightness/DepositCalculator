package com.example.uladzimir.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public abstract class MyActivity extends AppCompatActivity {

    protected DepositParams depositParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.deserializeParams();
    }

    protected void deserializeParams() {
        Intent intent = getIntent();

        this.depositParams = new DepositParams();
        this.depositParams.setSum(intent.getDoubleExtra(Constants.SUM, 0));
        this.depositParams.setDays(intent.getIntExtra(Constants.DAYS, 0));
        this.depositParams.setPercent(intent.getDoubleExtra(Constants.PERCENT, 0));
        this.depositParams.setCapitalizationMonths(intent.getIntExtra(Constants.CAPITALIZATION, 12));

        System.out.println("====> Sum" + this.depositParams.getSum());
        System.out.println("====> DAys" + this.depositParams.getDays());
        System.out.println("====> Percent" + this.depositParams.getPercent());
        System.out.println("====> capitalization" + this.depositParams.getCapitalizationMonths());
    }

    protected void serializeParams(Intent intent) {
        intent.putExtra(Constants.SUM, this.depositParams.getSum());
        intent.putExtra(Constants.DAYS, this.depositParams.getDays());
        intent.putExtra(Constants.PERCENT, this.depositParams.getPercent());
        intent.putExtra(Constants.CAPITALIZATION, this.depositParams.getCapitalizationMonths());

        System.out.println("<=== Sum" + this.depositParams.getSum());
        System.out.println("<=== DAys" + this.depositParams.getDays());
        System.out.println("<=== Percent" + this.depositParams.getPercent());
        System.out.println("<=== capitalization" + this.depositParams.getCapitalizationMonths());
    }

    protected abstract void reflectToUi();

}
