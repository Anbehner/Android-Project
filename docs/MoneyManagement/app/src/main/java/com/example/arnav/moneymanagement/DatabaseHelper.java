package com.example.arnav.moneymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

/**
 * Created by GOURISH on 6/14/2017.
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


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + INCOME_TABLE_NAME +" (Category TEXT,Payment TEXT,Amount INTEGER,Notes TEXT,Date TEXT)");
        db.execSQL("create table " + EXPENSE_TABLE_NAME +" (Category TEXT,Payment TEXT,Amount INTEGER,Notes TEXT,Date TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+INCOME_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+EXPENSE_TABLE_NAME);
        onCreate(db);

    }
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
    public Cursor getAllIncomeData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+INCOME_TABLE_NAME,null);
        return res;
    }


    public Cursor getAllIncomeDatafilter(String filtercategory,String filterdate,String filterTodate,String filterpayment) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db1 = this.getReadableDatabase();
        String a = "Rent";
        Cursor findEntry=null;

        if(filtercategory.length()!=0 && filterdate.length()!=0 && filterTodate.length()!=0 && filterpayment.length()!=0 ) {
             //findEntry = db.query("Income_table", null, "Category=? AND Date=? AND Payment=?", new String[]{filtercategory, filterdate, filterpayment}, null, null, null);
            findEntry = db.query("Income_table", null, "Category=? AND Date BETWEEN ? AND ? AND  Payment=?", new String[]{filtercategory, filterdate,filterTodate, filterpayment}, null, null, null);

        }else if (filterdate.length()!=0 && filterTodate.length()!=0 && filtercategory.length()==0 && filterpayment.length()==0){
            //findEntry = db.query("Income_table", null, "Date=?", new String[]{filterdate}, null, null, null);
            findEntry = db.query("Income_table", null, "Date BETWEEN ? AND ?", new String[]{filterdate, filterTodate}, null, null, null);

        }else if (filtercategory.length()!=0 && filterdate.length()!=0 && filterTodate.length()!=0 && filterpayment.length()==0){
            //findEntry = db.query("Income_table", null, "Category=? AND Date=?", new String[]{filtercategory, filterdate}, null, null, null);
            findEntry = db.query("Income_table", null, "Category=? AND Date BETWEEN ? AND ?", new String[]{filtercategory, filterdate,filterTodate}, null, null, null);

        }else if (filtercategory.length()!=0 && filterdate.length()==0 && filterTodate.length()!=0 && filterpayment.length()!=0){
            findEntry = db.query("Income_table", null, "Category=? AND Payment=?", new String[]{filtercategory, filterpayment}, null, null, null);

        }else if (filtercategory.length()==0 && filterdate.length()!=0 && filterTodate.length()!=0 && filterpayment.length()!=0){
            //findEntry = db.query("Income_table", null, "Date=? AND Payment=?", new String[]{filterdate, filterpayment}, null, null, null);
            findEntry = db.query("Income_table", null, "Date BETWEEN ? AND ? AND Payment=?", new String[]{filterdate,filterTodate, filterpayment}, null, null, null);

        }
        return findEntry;

    }

    public Cursor getAllincomeAmount() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resamount = db.rawQuery("select SUM(Amount) from "+INCOME_TABLE_NAME,null);
        return resamount;

    }

    public Cursor getAllexpenseAmount() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resExpenseamount = db.rawQuery("select SUM(Amount) from "+EXPENSE_TABLE_NAME,null);
        return resExpenseamount;

    }


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
    public Cursor getAllExpenseData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+EXPENSE_TABLE_NAME,null);
        return res;

    }

    public Cursor getAllExpenseDatafilter(String filterExpensecategory,String filterExpensedate,String filterexpenseTodate,String filterExpensepayment) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db1 = this.getReadableDatabase();
        //String[] columns ={"Category", "Date"};
        //String Query="SELECT Category,Date FROM Income_table";
        //Cursor res = db1.rawQuery(Query,null)
        String a = "Rent";
        Cursor findExpenseEntry=null;

        // Cursor res = db.rawQuery("select * from "+INCOME_TABLE_NAME + "WHERE COL_1 == 'Salary'",null);
        //Cursor res = db.rawQuery("select * from "+INCOME_TABLE_NAME,null);
        //Cursor res1 = db1.query("Income_table",new String [] {COL_1}, "Category = \'Salary\'", null, null, null, null);
        //Cursor res = db1.rawQuery("select * from " + INCOME_TABLE_NAME + "WHERE Category=? AND Payment=?", new String[]{"Salary","CreditCard"});
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
