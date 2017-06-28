package com.example.arnav.moneymanagement;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ExpenseActivity extends AppCompatActivity {
    DatabaseHelper  myDb;
    EditText editExpenseAmount,editExpenseNotes,editExpenseDate;
    Button btnAddExpense;
    Button btnViewExpense;

    Spinner expense_category_spinner;
    Spinner expense_payment_spinner;
    ArrayAdapter<CharSequence> expense_category_adapter;
    ArrayAdapter<CharSequence> expense_payment_adapter;

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        myDb=new DatabaseHelper(this);

        expense_category_spinner = (Spinner)findViewById(R.id.ExpenseCategory);

        expense_category_adapter = ArrayAdapter.createFromResource(this, R.array.expense_category_list, android.R.layout.simple_spinner_item);
        expense_category_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        expense_category_spinner.setAdapter(expense_category_adapter);
        expense_category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
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
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dateView = (TextView) findViewById(R.id.ExpenseDate);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        editExpenseAmount=(EditText)findViewById(R.id.ExpenseAmount);
        dateView=(TextView)findViewById(R.id.ExpenseDate);
        expense_payment_spinner = (Spinner)findViewById(R.id.ExpenseTypes);
        expense_category_spinner = (Spinner)findViewById(R.id.ExpenseCategory);
        editExpenseNotes=(EditText) findViewById(R.id.editText2);
        btnAddExpense=(Button)findViewById(R.id.ExpenseButton);
        btnViewExpense=(Button)findViewById(R.id.button_viewExpensedata);
        AddData();
        viewAll();

    }

    public  void AddData(){
        btnAddExpense.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertExpenseData(
                                expense_category_spinner.getSelectedItem().toString(),
                                expense_payment_spinner.getSelectedItem().toString(),
                                editExpenseAmount.getText().toString(),
                                editExpenseNotes.getText().toString(),
                                dateView.getText().toString());
                        editExpenseAmount.setText("");
                        editExpenseNotes.setText("");

                        Intent myexpenseIntent = new Intent(ExpenseActivity.this, MainActivity.class);
                        ExpenseActivity.this.startActivity(myexpenseIntent);

                    }
                }
        );
    }

    public void viewAll() {
        btnViewExpense.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllExpenseData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Category :"+ res.getString(0)+"\n");
                            buffer.append("Payment :"+ res.getString(1)+"\n");
                            buffer.append("Amount :"+ res.getString(2)+ "EUR"+"\n");
                            buffer.append("Notes :"+ res.getString(3)+"\n");
                            buffer.append("Date :"+ res.getString(4)+"\n\n");
                        }

                        // Show all data
                        showMessage("Expense Overview",buffer.toString());
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
