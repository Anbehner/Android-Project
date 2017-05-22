package com.example.arnav.moneymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import android.widget.DatePicker;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.TextView;
import android.app.Dialog;

public class IncomeActivity extends AppCompatActivity {

    Spinner income_category_spinner;
    Spinner income_payment_spinner;
    ArrayAdapter<CharSequence> income_category_adapter;
    ArrayAdapter<CharSequence> income_payment_adapter;

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        income_category_spinner = (Spinner)findViewById(R.id.IncomeCategory);

        income_category_adapter = ArrayAdapter.createFromResource(this, R.array.income_category_list, android.R.layout.simple_spinner_item);
        income_category_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        income_category_spinner.setAdapter(income_category_adapter);
        income_category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        income_payment_spinner = (Spinner)findViewById(R.id.IncomeTypes);
        income_payment_adapter = ArrayAdapter.createFromResource(this, R.array.income_payment_list, android.R.layout.simple_spinner_item);
        income_payment_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        income_payment_spinner.setAdapter(income_payment_adapter);
        income_payment_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dateView = (TextView) findViewById(R.id.IncomeDate);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
    }


    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

}
