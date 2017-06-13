package com.example.arnav.moneymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.TextView;
import android.app.Dialog;

public class IncomeActivity extends AppCompatActivity {

    Spinner income_category_spinner;
    Spinner income_payment_spinner;
    ArrayAdapter<CharSequence> income_category_adapter;
    ArrayAdapter<CharSequence> income_payment_adapter;


    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    Button addIncome;
    IncomeModel incomeModel ;
    String categorySelected ="",income_payment_selected="" ;

    TextView textView7;
    EditText income_notes,income_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        final DatabaseHandler db = new DatabaseHandler();

        income_category_spinner = (Spinner)findViewById(R.id.IncomeCategory);
        addIncome = (Button)findViewById(R.id.IncomeButton);
        income_notes = (EditText)findViewById(R.id.IncomeNotes);
        income_amount = (EditText)findViewById(R.id.IncomeAmount);

        textView7 = (TextView)findViewById(R.id.textView7);

        income_category_adapter = ArrayAdapter.createFromResource(this, R.array.income_category_list, android.R.layout.simple_spinner_item);
        income_category_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        income_category_spinner.setAdapter(income_category_adapter);
        income_category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                categorySelected = parent.getItemAtPosition(position).toString();
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

                income_payment_selected = parent.getItemAtPosition(position).toString();
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

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    SimpleDateFormat formatter2 = new SimpleDateFormat("d/M/yyyy");
                    String d = formatter2.format(Calendar.getInstance().getTime());
                    ArrayList<IncomeModel> result = db.getIncome(d);
                    Log.d("result=",""+result.toString());

                }catch(Exception e){
                    Log.d("exp=",""+e.toString());
                }

            }
        });


        addIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                incomeModel = new IncomeModel();
                incomeModel.setDate(dateView.getText().toString());
                incomeModel.setCategory(categorySelected);
                incomeModel.setAmount(income_amount.getText().toString());
                incomeModel.setPayment(income_payment_selected);
                incomeModel.setNotes(income_notes.getText().toString());

                db.addIncome(incomeModel);

                Toast.makeText(IncomeActivity.this, "Income Added successfully", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
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
