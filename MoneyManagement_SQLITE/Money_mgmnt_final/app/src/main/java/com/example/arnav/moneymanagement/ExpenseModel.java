package com.example.arnav.moneymanagement;

/**
 * Created by Pooja Ajit on 28-05-2017.
 */

class ExpenseModel {

//    public ExpenseModel(String date1 , String category1) {
//    }


    public String getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(String expense_date) {
        this.expense_date = expense_date;
    }

    public String getExpense_category() {
        return expense_category;
    }

    public void setExpense_category(String expense_category) {
        this.expense_category = expense_category;
    }

    public String getExpense_amount() {
        return expense_amount;
    }

    public void setExpense_amount(String expense_amount) {
        this.expense_amount = expense_amount;
    }

    public String getExpense_payment() {
        return expense_payment;
    }

    public void setExpense_payment(String expense_payment) {
        this.expense_payment = expense_payment;
    }

    public String getExpense_notes() {
        return expense_notes;
    }

    public void setExpense_notes(String expense_notes) {
        this.expense_notes = expense_notes;
    }

    public String expense_date = "";
    public String expense_category = "";
    public String expense_amount = "";
    public String expense_payment = "";
    public String expense_notes = "";


}
