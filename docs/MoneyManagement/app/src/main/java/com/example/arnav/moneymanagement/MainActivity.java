package com.example.arnav.moneymanagement;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper  gourish;
    Button btnViewIncome1;
    Button btnViewExpense1;
    Button btnViewTotalincome1;
    Button btnViewTotalExpense1;
    Button btnViewoverallbalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gourish=new DatabaseHelper(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnViewIncome1=(Button)findViewById(R.id.btnViewIncomeoverview);
        btnViewExpense1=(Button)findViewById(R.id.btnViewExpenseoverview);

        btnViewTotalincome1=(Button)findViewById(R.id.btnViewtotalincome);
        btnViewTotalExpense1=(Button)findViewById(R.id.btnViewtotalexpense);

        btnViewoverallbalance=(Button)findViewById(R.id.btnViewtotalamount);


        viewIncome();
        viewExpense();
        viewtotalIncome();
        viewtotalExpense();
        viewoverallBalance();

    }

    public void viewIncome() {
        btnViewIncome1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor resincome = gourish.getAllIncomeData();
                        if(resincome.getCount() == 0) {
                            // show message
                            showIncomeMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer1 = new StringBuffer();
                        while (resincome.moveToNext()) {
                            buffer1.append("Category :"+ resincome.getString(0)+"\n");
                            buffer1.append("Payment :"+ resincome.getString(1)+"\n");
                            buffer1.append("Amount :"+ resincome.getString(2)+ " EUR"+"\n");
                            buffer1.append("Notes :"+ resincome.getString(3)+"\n");
                            buffer1.append("Date :"+ resincome.getString(4)+"\n\n");
                        }

                        // Show all data
                        showIncomeMessage("Income Overview",buffer1.toString());
                    }
                }
        );
    }

    public void viewExpense() {
        btnViewExpense1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor resexpense = gourish.getAllExpenseData();
                        if(resexpense.getCount() == 0) {
                            // show message
                            showExpenseMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer1 = new StringBuffer();
                        while (resexpense.moveToNext()) {
                            buffer1.append("Category :"+ resexpense.getString(0)+"\n");
                            buffer1.append("Payment :"+ resexpense.getString(1)+"\n");
                            buffer1.append("Amount :"+ resexpense.getString(2)+ " EUR"+"\n");
                            buffer1.append("Notes :"+ resexpense.getString(3)+"\n");
                            buffer1.append("Date :"+ resexpense.getString(4)+"\n\n");
                        }

                        // Show all data
                        showExpenseMessage("Expense Overview",buffer1.toString());
                    }
                }
        );
    }

    public void viewtotalIncome() {
        btnViewTotalincome1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor resincome = gourish.getAllincomeAmount();
                        if (resincome.getCount() == 0) {
                            // show message
                            showIncomeMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer_totalincome = new StringBuffer();
                        while (resincome.moveToNext()) {

                            buffer_totalincome.append("Total Income Amount :" + resincome.getString(0) + " EUR" + "\n");

                        }


                        // Show all data
                        showIncomeMessage("Total Available Income", buffer_totalincome.toString());
                    }
                }
        );
    }



    public void viewoverallBalance() {
        btnViewoverallbalance.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Cursor resincome = gourish.getAllincomeAmount();
                        if (resincome.getCount() == 0) {
                            // show message
                            showIncomeMessage("Error", "Nothing found");
                            return;
                        }


                        Cursor resexpense = gourish.getAllexpenseAmount();
                        if (resexpense.getCount() == 0) {
                            // show message
                            showIncomeMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer_overallincome = new StringBuffer();
                        StringBuffer buffer_overallexpense = new StringBuffer();
                        while (resincome.moveToNext()) {
                           // buffer_overallincome.append("Total Overall income Amount :" + resincome.getString(0) + " EUR" + "\n");
                            buffer_overallincome.append(resincome.getString(0));
                        }


                        //Integer result1 = Integer.valueOf(buffer_overallincome.toString());
                        while (resexpense.moveToNext()) {
                            // buffer_overallincome.append("Total Overall income Amount :" + resincome.getString(0) + " EUR" + "\n");
                            buffer_overallexpense.append(resexpense.getString(0));
                        }
                        //Integer result2 = Integer.valueOf(buffer_overallexpense.toString());
                        //int result1;
                        //int result2;
                        if(buffer_overallexpense.toString().length()<12 && buffer_overallincome.toString().length()<12){
                            Float result1 = Float.valueOf(buffer_overallincome.toString());
                            Float result2 = Float.valueOf(buffer_overallexpense.toString());
                            float Total = result1 - result2;
                            String OverallAmount = String.valueOf(Total);
                            showIncomeMessage("Total Available Balance", OverallAmount +" "+"EUR");
                        }else{

                            showIncomeMessage("Total Available Balance","Entered Amount is Out of Int Range");
                        }

                        //String q = resincome.getString(0);
                        //String r = resexpense.getString(0);
                        //Integer result1 = Integer.valueOf(q);
                        //Integer result2 = Integer.valueOf(r);

                       // if(result1<2147483647 && result1>0 ) {
                       //     int Total = result1 - result2;
                       //     String OverallAmount = String.valueOf(Total);

                            // Show all data
                          //  showIncomeMessage("Total Available Balance", OverallAmount +" "+"EUR");
                       // }else{
                       //     showIncomeMessage("Total Available Balance","Entered Amount is Out of Int Range");
                       // }
                    }
                }
        );
    }



    public void viewtotalExpense() {
        btnViewTotalExpense1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor resincome = gourish.getAllexpenseAmount();
                        if (resincome.getCount() == 0) {
                            // show message
                            showIncomeMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer_totalexpense = new StringBuffer();
                        while (resincome.moveToNext()) {

                            buffer_totalexpense.append("Total Expense Amount :" + resincome.getString(0) + " EUR" + "\n");

                        }

                        // Show all data
                        showIncomeMessage("Total Expense Amount", buffer_totalexpense.toString());
                    }
                }
        );
    }








    public void showIncomeMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    public void showExpenseMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void IncomeActivity(View view) {

        Intent intent = new Intent(this, IncomeActivity.class);
        startActivity(intent);

    }

    public void ExpensesActivity(View view) {

        Intent intent = new Intent(this, ExpenseActivity.class);
        startActivity(intent);

    }
}
