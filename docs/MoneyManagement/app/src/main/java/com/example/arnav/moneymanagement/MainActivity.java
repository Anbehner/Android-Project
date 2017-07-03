package com.example.arnav.moneymanagement;

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

/**
    @desc This class is for Main Activity.
    @author: Gourish Hegde email: gourish.hegde@st.ovgu.de
    @Date:: 01/06/2017
 */

public class MainActivity extends AppCompatActivity {
    DatabaseHelper  myDatabase;
    Button btnViewIncome1;
    Button btnViewExpense1;
    Button btnViewTotalincome1;
    Button btnViewTotalExpense1;
    Button btnViewoverallbalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabase=new DatabaseHelper(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnViewIncome1=(Button)findViewById(R.id.btnViewIncomeoverview);
        btnViewExpense1=(Button)findViewById(R.id.btnViewExpenseoverview);
        btnViewTotalincome1=(Button)findViewById(R.id.btnViewtotalincome);
        btnViewTotalExpense1=(Button)findViewById(R.id.btnViewtotalexpense);
        btnViewoverallbalance=(Button)findViewById(R.id.btnViewtotalamount);

        //Calling View income and View Expense Methods.
        viewIncome();
        viewExpense();
        viewtotalIncome();
        viewtotalExpense();
        viewoverallBalance();

    }

    /**
     * @Name: viewIncome
      * @Fetches the Income transactions from the database and displays it on the screen.
      * @params None
      * @return None
     */
    public void viewIncome() {
        btnViewIncome1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor resincome = myDatabase.getAllIncomeData();
                        if(resincome.getCount() == 0) {
                            // shows Error message
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

                        // Show all income transaction  data
                        showIncomeMessage("Income Overview",buffer1.toString());
                    }
                }
        );
    }

    /**
     * @Name: viewExpense
      * @Fetches the Expense transactions from the database and displays it on the screen.
      * @params None
      * @return None
     */

    public void viewExpense() {
        btnViewExpense1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor resexpense = myDatabase.getAllExpenseData();
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

                        // Show all Expense Transaction data
                        showExpenseMessage("Expense Overview",buffer1.toString());
                    }
                }
        );
    }

    /**
     * @Name: viewtotalIncome
      * @Fetches the Total Income Balance from the database and displays it on the screen.
      * @params None
      * @return None
     */

    public void viewtotalIncome() {
        btnViewTotalincome1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor resincome = myDatabase.getAllincomeAmount();
                        if (resincome.getCount() == 0) {
                            // showS the Error message
                            showIncomeMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer_totalincome = new StringBuffer();
                        while (resincome.moveToNext()) {

                            buffer_totalincome.append("Total Income Amount :" + resincome.getString(0) + " EUR" + "\n");

                        }


                        // Shows the Total available income amount in transaction database.
                        showIncomeMessage("Total Available Income", buffer_totalincome.toString());
                    }
                }
        );
    }

    /**
     * @Name: viewoverallBalance
      * @Fetches the Overall Balance from the database and displays it on the screen.
      * @params None
      * @return None
     */

    public void viewoverallBalance() {
        btnViewoverallbalance.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Cursor resincome = myDatabase.getAllincomeAmount();
                        if (resincome.getCount() == 0) {
                            // shows the Error message
                            showIncomeMessage("Error", "Nothing found");
                            return;
                        }

                        Cursor resexpense = myDatabase.getAllexpenseAmount();
                        if (resexpense.getCount() == 0) {
                            // show Error message
                            showIncomeMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer_overallincome = new StringBuffer();
                        StringBuffer buffer_overallexpense = new StringBuffer();
                        while (resincome.moveToNext()) {
                            buffer_overallincome.append(resincome.getString(0));
                        }
                        while (resexpense.moveToNext()) {
                            buffer_overallexpense.append(resexpense.getString(0));
                        }
                        if(buffer_overallexpense.toString().length()<21 && buffer_overallincome.toString().length()<21){
                            double result1 = Float.valueOf(buffer_overallincome.toString());
                            double result2 = Float.valueOf(buffer_overallexpense.toString());
                            double Total = result1 - result2;
                            String OverallAmount = String.valueOf(Total);

                            //Show the total Available balance.
                            showIncomeMessage("Total Available Balance", OverallAmount +" "+"EUR");
                        }else{

                            showIncomeMessage("Error:","Overall amount is huge!!");
                        }
                    }
                }
        );
    }

    /**
     * @Name: viewtotalExpense
      * @Fetches the Total Expense Balance from the database and displays it on the screen.
      * @params None
      * @return None
     */

    public void viewtotalExpense() {
        btnViewTotalExpense1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor resincome = myDatabase.getAllexpenseAmount();
                        if (resincome.getCount() == 0) {
                            // show Error message
                            showIncomeMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer_totalexpense = new StringBuffer();
                        while (resincome.moveToNext()) {

                            buffer_totalexpense.append("Total Expense Amount :" + resincome.getString(0) + " EUR" + "\n");

                        }

                        // Show all Expense data
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

        //navigate to the Income Activity Screen.
        Intent intent = new Intent(this, IncomeActivity.class);
        startActivity(intent);

    }

    public void ExpensesActivity(View view) {

        //navigate to the Expense Activity Screen.
        Intent intent = new Intent(this, ExpenseActivity.class);
        startActivity(intent);

    }
}
