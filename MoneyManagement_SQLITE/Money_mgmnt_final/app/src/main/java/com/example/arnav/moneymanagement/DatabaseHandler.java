package com.example.arnav.moneymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Pooja Ajit on 28-05-2017.
 */

public class DatabaseHandler {

    private static final String DATABASE_NAME = "moneyManagement";

    // Contacts table name
    private static final String TABLE_INCOME = "income";
    private static final String TABLE_EXPENSE = "expense";

    // income Table Columns names
    private static final String KEY_DATE = "date";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_PAYMENT = "payment";
    private static final String KEY_NOTES = "notes";


    private static final String KEY_DATE1 = "expense_date";
    private static final String KEY_CATEGORY1 = "expense_category";
    private static final String KEY_AMOUNT1 = "expense_amount";
    private static final String KEY_PAYMENT1 = "expense_payment";
    private static final String KEY_NOTES1 = "expense_notes";


    //add new income

    public void addIncome(IncomeModel incomeModel) {

        ContentValues values = new ContentValues();
        values.put(KEY_DATE, incomeModel.getDate()); // Date
        values.put(KEY_CATEGORY, incomeModel.getCategory()); // Category
        values.put(KEY_AMOUNT, incomeModel.getAmount()); // amount
        values.put(KEY_PAYMENT, incomeModel.getPayment()); // payment
        values.put(KEY_NOTES, incomeModel.getNotes()); // notes

        // Inserting Row
        DbAdapter.getDbAdapterInstance().insert(TABLE_INCOME, null, values);

    }

    //add new expense

    public void addExpense(ExpenseModel expenseModel) {

        ContentValues values = new ContentValues();
        values.put(KEY_DATE1, expenseModel.getExpense_date()); // Date
        values.put(KEY_CATEGORY1, expenseModel.getExpense_category()); // Catagory
        values.put(KEY_AMOUNT1, expenseModel.getExpense_amount()); // Amount
        values.put(KEY_PAYMENT1, expenseModel.getExpense_payment()); // Payment
        values.put(KEY_NOTES1, expenseModel.getExpense_notes()); // Notes

        // Inserting Row
        DbAdapter.getDbAdapterInstance().insert(TABLE_EXPENSE, null, values);

    }

    //retrieve data

    public ArrayList<IncomeModel> getIncome(String date) {

        String selectQuery = "SELECT  * FROM " + TABLE_INCOME + " WHERE "
                + KEY_DATE + " = '" + date + "'";

        Cursor cursor = DbAdapter.getDbAdapterInstance().rawQuery(selectQuery, null);

        ArrayList<IncomeModel> incomeList = new ArrayList();


        String[] columnnames = cursor.getColumnNames();
        Log.d("columnnames=",""+columnnames);

        String response = null;
            if (cursor != null && cursor.getCount() > 0) {
               if (cursor.moveToFirst()){
                   do {
                       IncomeModel incomeModel = new IncomeModel();
                       incomeModel.setDate(cursor.getString(cursor.getColumnIndexOrThrow(KEY_DATE)));
                       incomeModel.setCategory(cursor.getString(cursor.getColumnIndexOrThrow(KEY_CATEGORY)));
                       incomeModel.setAmount(cursor.getString(cursor.getColumnIndexOrThrow(KEY_AMOUNT)));
                       incomeModel.setPayment(cursor.getString(cursor.getColumnIndexOrThrow(KEY_PAYMENT)));
                       incomeModel.setNotes(cursor.getString(cursor.getColumnIndexOrThrow(KEY_NOTES)));

                       incomeList.add(incomeModel);

                   }while (cursor.moveToNext());
               }

                cursor.close();
            }

        //IncomeModel incomeModel = new IncomeModel(cursor.getString(0), cursor.getString(1));
        // return contact
        return incomeList;
    }

    //retrieve data

    public ArrayList<ExpenseModel> getExpense(String date1) {

        String selectQuery = "SELECT  * FROM " + TABLE_EXPENSE + " WHERE "
                + KEY_DATE1 + " = '" + date1 + "'";

        Cursor cursor = DbAdapter.getDbAdapterInstance().rawQuery(selectQuery, null);

        ArrayList<ExpenseModel> expenseList = new ArrayList();

        String[] columnnames = cursor.getColumnNames();

        Log.d("columnnames=",""+columnnames);
        String response = null;
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()){

                do {
                    ExpenseModel expenseModel = new ExpenseModel();
                    expenseModel.setExpense_date(cursor.getString(cursor.getColumnIndexOrThrow(KEY_DATE1)));
                    expenseModel.setExpense_category(cursor.getString(cursor.getColumnIndexOrThrow(KEY_CATEGORY1)));
                    expenseModel.setExpense_amount(cursor.getString(cursor.getColumnIndexOrThrow(KEY_AMOUNT1)));
                    expenseModel.setExpense_payment(cursor.getString(cursor.getColumnIndexOrThrow(KEY_PAYMENT1)));
                    expenseModel.setExpense_notes(cursor.getString(cursor.getColumnIndexOrThrow(KEY_NOTES1)));

                    expenseList.add(expenseModel);

                }while (cursor.moveToNext());
            }

            cursor.close();
        }

        //ExpenseModel expenseModel = new ExpenseModel(cursor.getString(0), cursor.getString(1));
        // return contact
        return expenseList;
    }
}