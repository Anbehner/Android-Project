package com.example.arnav.moneymanagement;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by Pooja Ajit on 28-05-2017.
 */

class IncomeModel {

//    public IncomeModel(String date , String category) {
//    }


    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String payment) {
        Payment = payment;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String Date = "";
    public String Category = "";
    public String Amount = "";
    public String Payment = "";
    public String Notes = "";


}
