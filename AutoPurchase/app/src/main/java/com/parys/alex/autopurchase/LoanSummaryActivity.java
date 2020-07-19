package com.parys.alex.autopurchase;

/**
 * Created by apary on 10/9/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoanSummaryActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lonesummary_layout);
        TextView monthlyPayET = (TextView) findViewById(R.id.textView2);
        TextView loanReportET = (TextView) findViewById(R.id.textView3);

        // PASS DATA
        Intent intent = getIntent();

        String report;
        report = intent.getStringExtra("LoanReport");

        String monthlyPay;
        monthlyPay = intent.getStringExtra("MonthlyPayment");
        monthlyPayET.setText(monthlyPay);
        loanReportET.setText(report);
    }

    public void goDataEntry(View view) {
        finish();
    }
}
