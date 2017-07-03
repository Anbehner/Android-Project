package com.example.arnav.moneymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
    @desc This class is for Expense Filter Activity. where user can
    Filter Income  transactions.
    @author: Gourish Hegde email: gourish.hegde@st.ovgu.de
    @Date:: 03/06/2017
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME ="Money.db";
    public static final String INCOME_TABLE_NAME ="Income_table";
    public static final String EXPENSE_TABLE_NAME ="Expense_table";
    public static final String COL_1 ="Category";
    public static final String COL_2 ="Payment";
    public static final String COL_3 ="Amount";
    public static final String COL_4 ="Notes";
    public static final String COL_5 ="Date";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1 );
        SQLiteDatabase db=this.getWritableDatabase();
    }

    /**
     * @Name: onCreate
      * @Desc Creates Income and Expense tables in Database.
      * @param SQLiteDatabase db
      * @return None
     */

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + INCOME_TABLE_NAME +" (Category TEXT,Payment TEXT,Amount INTEGER,Notes TEXT,Date TEXT)");
        db.execSQL("create table " + EXPENSE_TABLE_NAME +" (Category TEXT,Payment TEXT,Amount INTEGER,Notes TEXT,Date TEXT)");

    }

    /**
     * @Name: onUpgrade
      * @Desc Drops Income and Expense tables in Database.
      * @param SQLiteDatabase db
      * @return None
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+INCOME_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+EXPENSE_TABLE_NAME);
        onCreate(db);

    }

    /**
     * @Name: insertIncomeData
      * @Desc inserts Income Transactions data in to Income  table in Database.
      * @params String category,String payment,String amount,String notes,String date
      * @return bool- True or false.
     */

    public boolean insertIncomeData(String category,String payment,String amount,String notes,String date){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,category);
        contentValues.put(COL_2,payment);
        contentValues.put(COL_3,amount);
        contentValues.put(COL_4,notes);
        contentValues.put(COL_5,date);
        long result=db.insert(INCOME_TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else return true;

    }

    /**
     * @Name: getAllIncomeData
      * @Desc Fetches Income Transactions data From Income  table in Database.
      * @params None
      * @return Cursor res
     */

    public Cursor getAllIncomeData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+INCOME_TABLE_NAME,null);
        return res;
    }

    /**
     * @Name: getAllIncomeDatafilter
      * @Desc Fetches Filtered Income Transactions data From Income  table in Database.
      * @params String filtercategory,String filterdate,String filterTodate,String filterpayment
      * @return Cursor findEntry
     */

    public Cursor getAllIncomeDatafilter(String filtercategory,String filterdate,String filterTodate,String filterpayment) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db1 = this.getReadableDatabase();
        Cursor findEntry=null;
        if(filtercategory.length()!=0 && filterdate.length()!=0 && filterTodate.length()!=0 && filterpayment.length()!=0 ) {
            findEntry = db.query("Income_table", null, "Category=? AND Date BETWEEN ? AND ? AND  Payment=?", new String[]{filtercategory, filterdate,filterTodate, filterpayment}, null, null, null);
        }else if (filterdate.length()!=0 && filterTodate.length()!=0 && filtercategory.length()==0 && filterpayment.length()==0){
            findEntry = db.query("Income_table", null, "Date BETWEEN ? AND ?", new String[]{filterdate, filterTodate}, null, null, null);
        }else if (filtercategory.length()!=0 && filterdate.length()!=0 && filterTodate.length()!=0 && filterpayment.length()==0){
            findEntry = db.query("Income_table", null, "Category=? AND Date BETWEEN ? AND ?", new String[]{filtercategory, filterdate,filterTodate}, null, null, null);
        }else if (filtercategory.length()!=0 && filterdate.length()==0 && filterTodate.length()!=0 && filterpayment.length()!=0){
            findEntry = db.query("Income_table", null, "Category=? AND Payment=?", new String[]{filtercategory, filterpayment}, null, null, null);
        }else if (filtercategory.length()==0 && filterdate.length()!=0 && filterTodate.length()!=0 && filterpayment.length()!=0){
            findEntry = db.query("Income_table", null, "Date BETWEEN ? AND ? AND Payment=?", new String[]{filterdate,filterTodate, filterpayment}, null, null, null);
        }
        return findEntry;
    }

    /**
     * @Name: getAllincomeAmount
      * @Desc Fetches the total sum of income transaction amount from database.
      * @params None
      * @return Cursor resamount
     */

    public Cursor getAllincomeAmount() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resamount = db.rawQuery("select SUM(Amount) from "+INCOME_TABLE_NAME,null);
        return resamount;
    }

    /**
     * @Name: getAllexpenseAmount
      * @Desc Fetches the total sum of expense transaction amount from database.
      * @params None
      * @return Cursor resExpenseamount
     */

    public Cursor getAllexpenseAmount() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resExpenseamount = db.rawQuery("select SUM(Amount) from "+EXPENSE_TABLE_NAME,null);
        return resExpenseamount;
    }

    /**
     * @Name: insertExpenseData
      * @Desc inserts Expense Transactions data in to Expense  table in Database.
      * @params String category,String payment,String amount,String notes,String date
      * @return bool- True or false.
     */

    public boolean insertExpenseData(String category,String payment,String amount,String notes,String date){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,category);
        contentValues.put(COL_2,payment);
        contentValues.put(COL_3,amount);
        contentValues.put(COL_4,notes);
        contentValues.put(COL_5,date);
        long result=db.insert(EXPENSE_TABLE_NAME,null,contentValues);

        if(result==-1)
            return false;
        else return true;

    }

    /**
     * @Name: getAllExpenseData
      * @Desc Fetches Expense Transactions data From Expense  table in Database.
      * @params None
      * @return Cursor res
     */

    public Cursor getAllExpenseData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+EXPENSE_TABLE_NAME,null);
        return res;

    }

    /**
     * @Name: getAllExpenseDatafilter
      * @Desc Fetches Filtered Expense Transactions data From Expense  table in Database.
      * @params String filterExpensecategory,String filterExpensedate,String filterexpenseTodate,String filterExpensepayment
      * @return Cursor findExpenseEntry
     */

    public Cursor getAllExpenseDatafilter(String filterExpensecategory,String filterExpensedate,String filterexpenseTodate,String filterExpensepayment) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db1 = this.getReadableDatabase();
        Cursor findExpenseEntry=null;

        if(filterExpensecategory.length()!=0 && filterExpensedate.length()!=0 && filterexpenseTodate.length()!=0 && filterExpensepayment.length()!=0 ) {
            findExpenseEntry = db.query("Expense_table", null, "Category=? AND Date BETWEEN ? AND ? AND Payment=?", new String[]{filterExpensecategory, filterExpensedate,filterexpenseTodate, filterExpensepayment}, null, null, null);
        }else if (filterExpensedate.length()!=0 && filterexpenseTodate.length()!=0 && filterExpensecategory.length()==0 && filterExpensepayment.length()==0){
            findExpenseEntry = db.query("Expense_table", null, "Date BETWEEN ? AND ?", new String[]{filterExpensedate,filterexpenseTodate}, null, null, null);
        }else if (filterExpensecategory.length()!=0 && filterExpensedate.length()!=0 && filterexpenseTodate.length()!=0 && filterExpensepayment.length()==0){
            findExpenseEntry = db.query("Expense_table", null, "Category=? AND Date BETWEEN ? AND ?", new String[]{filterExpensecategory, filterExpensedate,filterexpenseTodate}, null, null, null);
        }else if (filterExpensecategory.length()!=0 && filterExpensedate.length()==0 && filterexpenseTodate.length()==0 && filterExpensepayment.length()!=0){
            findExpenseEntry = db.query("Expense_table", null, "Category=? AND Payment=?", new String[]{filterExpensecategory, filterExpensepayment}, null, null, null);
        }else if (filterExpensecategory.length()==0 && filterExpensedate.length()!=0 && filterexpenseTodate.length()!=0 && filterExpensepayment.length()!=0){
            findExpenseEntry = db.query("Expense_table", null, "Date BETWEEN ? AND ? AND Payment=?", new String[]{filterExpensedate,filterexpenseTodate, filterExpensepayment}, null, null, null);
        }
        return findExpenseEntry;

    }

}
