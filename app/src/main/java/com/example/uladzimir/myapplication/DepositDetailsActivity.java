package com.example.uladzimir.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.ParseException;
import java.util.Locale;


public class DepositDetailsActivity extends MyActivity {

    private EditText inputPercent;
    private RadioButton radioEveryMonth;
    private RadioButton radioEveryThreeMonths;
    private RadioButton radioTwiceAYear;
    private RadioButton radioOnceAYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit_details);

        this.initUi();

        this.reflectToUi();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_cap_everyMonth:
                if (checked) {
                    this.depositParams.setCapitalizationMonths(Constants.EVERY_MONTH);
                }

                break;
            case R.id.radio_cap_everyThreeMonths:
                if (checked) {
                    this.depositParams.setCapitalizationMonths(Constants.EVERY_QUARTER);
                }

                break;
            case R.id.radio_cap_twiceAYear:
                if (checked) {
                    this.depositParams.setCapitalizationMonths(Constants.TWICE_A_YEAR);
                }

                break;
            case R.id.radio_cap_onceAYear:
                if (checked) {
                    this.depositParams.setCapitalizationMonths(Constants.ONCE_A_YEAR);
                }

                break;
        }
    }

    protected void reflectToUi() {
        this.inputPercent.setText(String.format(Locale.getDefault(), "%f", this.depositParams.getPercent()));

        this.radioEveryMonth.setChecked(Constants.EVERY_MONTH.equals(this.depositParams.getCapitalizationMonths()));
        this.radioEveryThreeMonths.setChecked(Constants.EVERY_QUARTER.equals(this.depositParams.getCapitalizationMonths()));
        this.radioTwiceAYear.setChecked(Constants.TWICE_A_YEAR.equals(this.depositParams.getCapitalizationMonths()));
        this.radioOnceAYear.setChecked(Constants.ONCE_A_YEAR.equals(this.depositParams.getCapitalizationMonths()));
    }

    protected void initUi() {
        final DepositParams depositParams = this.depositParams;

        this.radioEveryMonth = (RadioButton) findViewById(R.id.radio_cap_everyMonth);
        this.radioEveryThreeMonths = (RadioButton) findViewById(R.id.radio_cap_everyThreeMonths);
        this.radioTwiceAYear = (RadioButton) findViewById(R.id.radio_cap_twiceAYear);
        this.radioOnceAYear = (RadioButton) findViewById(R.id.radio_cap_onceAYear);

        this.inputPercent = (EditText) findViewById(R.id.inputPercent);
        this.inputPercent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Double value;

                try {
                    value = Double.parseDouble(s.toString());
                }
                catch (NumberFormatException e) {
                    value = 0D;
                }

                depositParams.setPercent(value);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public void onClickCalculateDeposit(View v) {
        Intent intent = new Intent(this, ResultActivity.class);

        this.serializeParams(intent);

        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, TermAndSumActivity.class);

        this.serializeParams(intent);

        startActivity(intent);
    }
}
