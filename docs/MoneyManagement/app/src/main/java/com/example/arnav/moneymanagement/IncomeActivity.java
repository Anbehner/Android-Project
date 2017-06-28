package com.example.arnav.moneymanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.DatePicker;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.TextView;
import android.app.Dialog;

public class IncomeActivity extends AppCompatActivity {
    DatabaseHelper  myDb;
    EditText editAmount,editNotes,editDate;
    Button btnAddIncome;
    Button btnViewAll;
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
        myDb=new DatabaseHelper(this);

        income_category_spinner = (Spinner)findViewById(R.id.IncomeCategory);
        income_category_adapter = ArrayAdapter.createFromResource(this, R.array.income_category_list, android.R.layout.simple_spinner_item);
        income_category_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        income_category_spinner.setAdapter(income_category_adapter);

        income_payment_spinner = (Spinner)findViewById(R.id.IncomeTypes);
        income_payment_adapter = ArrayAdapter.createFromResource(this, R.array.income_payment_list, android.R.layout.simple_spinner_item);
        income_payment_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        income_payment_spinner.setAdapter(income_payment_adapter);

        dateView = (TextView) findViewById(R.id.IncomeDate);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        editAmount=(EditText)findViewById(R.id.IncomeAmount);
        dateView=(TextView)findViewById(R.id.IncomeDate);
        editAmount=(EditText)findViewById(R.id.IncomeAmount);
        income_payment_spinner = (Spinner)findViewById(R.id.IncomeTypes);
        income_category_spinner = (Spinner)findViewById(R.id.IncomeCategory);
        editNotes=(EditText) findViewById(R.id.IncomeNotes);
        btnAddIncome=(Button)findViewById(R.id.IncomeButton);
        btnViewAll=(Button)findViewById(R.id.button_viewdata);

        AddData();
        viewAll();
    }

    public  void AddData(){
        btnAddIncome.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(income_category_spinner.getSelectedItem().toString().length()!=0 && income_payment_spinner.getSelectedItem().toString().length()!=0 && editAmount.getText().toString().length()!=0) {
                            boolean isInserted = myDb.insertIncomeData(
                                    income_category_spinner.getSelectedItem().toString(),
                                    income_payment_spinner.getSelectedItem().toString(),
                                    editAmount.getText().toString(),
                                    editNotes.getText().toString(),
                                    dateView.getText().toString());
                                    editAmount.setText("");
                                    editNotes.setText("");
                                    Intent myIntent = new Intent(IncomeActivity.this, MainActivity.class);
                                    IncomeActivity.this.startActivity(myIntent);
                        }else{
                                    showMessage("Please Select Category and Payment and Add Amount !!","");
                             }

                    }
                }
        );
    }

    public void viewAll() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllIncomeData();
                        if(res.getCount() == 0) {
                            // show message to shw the Data
                            showMessage("No Data Found !!","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Category:  "+" "+ res.getString(0)+"\n");
                            buffer.append("Payment :  "+" "+ res.getString(1)+"\n");
                            buffer.append("Amount  :  "+" "+ res.getString(2)+" "+"EUR"+"\n");
                            buffer.append("Notes   :  "+" "+ res.getString(3)+"\n");
                            buffer.append("Date    :  "+" "+ res.getString(4)+"\n\n");
                        }

                        // Show all data
                        showMessage("Income Overview",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
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
