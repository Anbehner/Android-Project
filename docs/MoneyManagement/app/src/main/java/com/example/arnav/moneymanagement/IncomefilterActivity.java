package com.example.arnav.moneymanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import android.widget.DatePicker;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.TextView;
import android.app.Dialog;

public class IncomefilterActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Button btnIncomeFilter;
    Spinner income_categoryFilter_spinner;
    Spinner income_paymentFilter_spinner;
    ArrayAdapter<CharSequence> income_categoryFilter_adapter;
    ArrayAdapter<CharSequence> income_paymentFilter_adapter;

    private DatePicker datePicker;
    private Calendar calendar;
    private Calendar calendar1;
    private TextView dateView;
    private TextView dateview1;
    private int year, month, day;
    private int yeartill, monthtill, daytill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incomefilter);
        myDb = new DatabaseHelper(this);
        income_categoryFilter_spinner = (Spinner) findViewById(R.id.IncomeCategory_Filter);

        income_categoryFilter_adapter = ArrayAdapter.createFromResource(this, R.array.income_category_list, android.R.layout.simple_spinner_item);
        income_categoryFilter_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        income_categoryFilter_spinner.setAdapter(income_categoryFilter_adapter);
        income_categoryFilter_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        income_paymentFilter_spinner = (Spinner) findViewById(R.id.IncomeTypes_Filter);
        income_paymentFilter_adapter = ArrayAdapter.createFromResource(this, R.array.income_payment_list, android.R.layout.simple_spinner_item);
        income_paymentFilter_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        income_paymentFilter_spinner.setAdapter(income_paymentFilter_adapter);
        income_paymentFilter_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dateView = (TextView) findViewById(R.id.IncomeDate_Filter);
        dateview1 = (TextView) findViewById(R.id.IncomeDate_Filter1);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        calendar1 = Calendar.getInstance();
        yeartill = calendar1.get(Calendar.YEAR);

        monthtill = calendar1.get(Calendar.MONTH);
        daytill = calendar1.get(Calendar.DAY_OF_MONTH);



        showDate(year, month + 1, day);
        showTillDate(yeartill, monthtill + 1, daytill);


        dateView = (TextView) findViewById(R.id.IncomeDate_Filter);
        dateview1 = (TextView) findViewById(R.id.IncomeDate_Filter1);

        income_paymentFilter_spinner = (Spinner) findViewById(R.id.IncomeTypes_Filter);
        income_categoryFilter_spinner = (Spinner) findViewById(R.id.IncomeCategory_Filter);
        btnIncomeFilter = (Button) findViewById(R.id.button_viewdata1);
        //showMessage("dateView",dateView.getText().toString());
        viewAllincomeFilter();

    }


    public void viewAllincomeFilter() {
        btnIncomeFilter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllIncomeDatafilter(income_categoryFilter_spinner.getSelectedItem().toString(), dateView.getText().toString(),
                                dateview1.getText().toString(), income_paymentFilter_spinner.getSelectedItem().toString());
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        //showMessage("dateView",dateView.getText().toString());

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Category :" + res.getString(0) + "\n");
                            buffer.append("Payment :" + res.getString(1) + "\n");
                            buffer.append("Amount :" + res.getString(2) + " EUR" + "\n");
                            buffer.append("Notes :" + res.getString(3) + "\n");
                            buffer.append("Date :" + res.getString(4) + "\n\n");
                        }

                        // Show all data
                        showMessage("Income Filter Overview", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        /*Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();*/
    }

    @SuppressWarnings("deprecation")
    public void setDate1(View view) {
        showDialog(100);
        /*Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();*/
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }else if (id == 100) {
            return new DatePickerDialog(this,
                    myDateListener1, yeartill, monthtill, daytill);
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
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    private DatePickerDialog.OnDateSetListener myDateListener1 = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showTillDate(arg1, arg2 + 1, arg3);
                }
            };
    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));

    }


    private void showTillDate(int year, int month, int day) {
        dateview1.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));


    }
}