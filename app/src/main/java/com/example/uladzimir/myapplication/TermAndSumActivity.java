package com.example.uladzimir.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;


public class TermAndSumActivity extends MyActivity {

    private EditText inputDays;
    private EditText inputSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_and_sum);

        this.initUi();

        this.reflectToUi();
    }

    public void onClickNext(View v){
        Intent intent = new Intent(this, DepositDetailsActivity.class);

        this.serializeParams(intent);

        startActivity(intent);
    }

    protected void reflectToUi() {
        this.inputDays.setText(String.format(Locale.getDefault(), "%d" , this.depositParams.getDays()));
        this.inputSum.setText(String.format(Locale.getDefault(), "%f" , this.depositParams.getSum()));
    }

    protected void initUi() {
        final DepositParams depositParams = this.depositParams;

        this.inputDays = (EditText)findViewById(R.id.input_days);
        this.inputDays.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Integer value;

                try {
                    value = Integer.parseInt(s.toString());
                }
                catch (NumberFormatException e) {
                    value = 0;
                }

                depositParams.setDays(value);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        this.inputSum = (EditText)findViewById(R.id.input_sum);
        this.inputSum.addTextChangedListener(new TextWatcher() {
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

                depositParams.setSum(value);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}
