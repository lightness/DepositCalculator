package com.example.uladzimir.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;


public class ResultActivity extends MyActivity {

    private Double result;
    private Double gain;

    private TextView txtResult;
    private TextView txtGain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        this.txtResult = (TextView) findViewById(R.id.txt_result);
        this.txtGain = (TextView) findViewById(R.id.txt_gain);

        this.calculate();

        this.reflectToUi();
    }

    protected void calculate() {
        Integer capitalizationDays = this.depositParams.getCapitalizationMonths() * Constants.DAYS_IN_MONTH;
        Double capitalizationNumber = Math.floor(this.depositParams.getDays() / capitalizationDays);

        this.result = this.depositParams.getSum() * Math.pow(1 + this.depositParams.getPercent() * capitalizationDays / (100 * Constants.DAYS_IN_YEAR), capitalizationNumber);
        this.gain = (this.result - this.depositParams.getSum()) / this.depositParams.getSum();
    }

    @Override
    protected void reflectToUi() {
        this.txtResult.setText(String.format(Locale.getDefault(), "%f", this.result));
        this.txtGain.setText(String.format(Locale.getDefault(), "%.2f%%%n", this.gain * 100));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, DepositDetailsActivity.class);

        this.serializeParams(intent);

        startActivity(intent);
    }
}
