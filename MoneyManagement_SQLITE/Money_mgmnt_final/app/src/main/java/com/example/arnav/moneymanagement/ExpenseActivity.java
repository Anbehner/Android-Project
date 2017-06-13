package com.example.arnav.moneymanagement;

import android.content.Intent;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class ExpenseActivity extends AppCompatActivity {

    Spinner expense_category_spinner;
    Spinner expense_payment_spinner;
    ArrayAdapter<CharSequence> expense_category_adapter;
    ArrayAdapter<CharSequence> expense_payment_adapter;

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    Button ExpenseButton;
    ExpenseModel expenseModel ;

    TextView textView7;
    String expense_category_selected = "";
    String expense_payment_selected = "";
    EditText ExpenseAmount,ExpenseNotes,ExpenseDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        final DatabaseHandler db = new DatabaseHandler();

        expense_category_spinner = (Spinner)findViewById(R.id.ExpenseCategory);
        textView7 = (TextView)findViewById(R.id.textView7);
        ExpenseButton = (Button)findViewById(R.id.ExpenseButton);
        ExpenseAmount = (EditText)findViewById(R.id.ExpenseAmount);
        ExpenseNotes = (EditText)findViewById(R.id.ExpenseNotes);
        ExpenseDate = (EditText)findViewById(R.id.ExpenseDate);

        expense_category_adapter = ArrayAdapter.createFromResource(this, R.array.expense_category_list, android.R.layout.simple_spinner_item);
        expense_category_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        expense_category_spinner.setAdapter(expense_category_adapter);
        expense_category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                expense_category_selected = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        expense_payment_spinner = (Spinner)findViewById(R.id.ExpenseTypes);
        expense_payment_adapter = ArrayAdapter.createFromResource(this, R.array.expense_payment_list, android.R.layout.simple_spinner_item);
        expense_payment_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        expense_payment_spinner.setAdapter(expense_payment_adapter);
        expense_payment_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                expense_payment_selected = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
       // showDate(year, month+1, day);


        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                    String d = formatter2.format(Calendar.getInstance().getTime());
                    Log.d("d=",""+d);
                    ArrayList<ExpenseModel> result = db.getExpense(d);
                    Log.d("result=",""+result);

                }catch(Exception e){
                    Log.d("exp=",""+e.toString());
                }

            }
        });


        ExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                expenseModel = new ExpenseModel();
                expenseModel.setExpense_date(ExpenseDate.getText().toString());
                expenseModel.setExpense_category(expense_category_selected);
                expenseModel.setExpense_amount(ExpenseAmount.getText().toString());
                expenseModel.setExpense_payment(expense_payment_selected);

                db.addExpense(expenseModel);
                Toast.makeText(ExpenseActivity.this, "Expense Added successfully", Toast.LENGTH_SHORT).show();

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
                 //   showDate(arg1, arg2+1, arg3);
                }
            };

//    private void showDate(int year, int month, int day) {
//        dateView.setText(new StringBuilder().append(day).append("/")
//                .append(month).append("/").append(year));
//    }
    }

