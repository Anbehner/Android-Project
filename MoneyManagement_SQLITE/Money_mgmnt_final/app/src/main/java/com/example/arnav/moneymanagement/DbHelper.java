package com.example.arnav.moneymanagement;

/**
 * Created by Pooja Ajit on 01-06-2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper  {


    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "moneyManagement";


    // Contacts table name
    private static final String TABLE_INCOME = "income";
    private static final String TABLE_EXPENSE = "expense";


    // incoms Table Columns names
    private static final String KEY_DATE = "date";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_PAYMENT = "payment";
    private static final String KEY_NOTES = "notes";

    //expense table column names
    private static final String KEY_DATE1 = "expense_date";
    private static final String KEY_CATEGORY1 = "expense_category";
    private static final String KEY_AMOUNT1 = "expense_amount";
    private static final String KEY_PAYMENT1 = "expense_payment";
    private static final String KEY_NOTES1 = "expense_notes";

    String CREATE_INCOME_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_INCOME + " ("
            + KEY_DATE + " VARCHAR," + KEY_CATEGORY + " VARCHAR," + KEY_AMOUNT + " VARCHAR," + KEY_PAYMENT + " VARCHAR," + KEY_NOTES + " VARCHAR" + ");";

    String CREATE_EXPENSE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_EXPENSE + " ("
            + KEY_DATE1 + " VARCHAR," + KEY_CATEGORY1 + " VARCHAR," + KEY_AMOUNT1 + " VARCHAR," + KEY_PAYMENT1 + " VARCHAR," + KEY_NOTES1 + " VARCHAR" + ");";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_INCOME_TABLE);
        db.execSQL(CREATE_EXPENSE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
