package com.example.arnav.moneymanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ExpenseActivity extends AppCompatActivity {

    Spinner expense_category_spinner;
    Spinner expense_payment_spinner;
    ArrayAdapter<CharSequence> expense_category_adapter;
    ArrayAdapter<CharSequence> expense_payment_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

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
    }
}
