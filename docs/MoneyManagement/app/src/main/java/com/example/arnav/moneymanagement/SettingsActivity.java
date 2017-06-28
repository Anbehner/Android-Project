package com.example.arnav.moneymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.CheckBox;

public class SettingsActivity extends AppCompatActivity {
    String password1;
    private CheckBox check1;
    private CheckBox check2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences settings1=getSharedPreferences("PREFS",0);
        password1=settings1.getString("password1", "");
        addListenerToCheckBox();
        addListenerToCheckBox1();
    }

    public void addListenerToCheckBox(){
        check1=(CheckBox)findViewById(R.id.checkBox1);
        check1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(((CheckBox)v).isChecked()){
                            SharedPreferences settings1 = getSharedPreferences("PREFS", 0);
                            SharedPreferences.Editor editor = settings1.edit();
                            editor.putString("password1", "Hello");
                            editor.apply();
                            Intent mynewIntent = new Intent(SettingsActivity.this, SplashActivity.class);
                            SettingsActivity.this.startActivity(mynewIntent);
                        }else{
                            SharedPreferences settings1 = getSharedPreferences("PREFS", 0);
                            SharedPreferences.Editor editor = settings1.edit();
                            editor.putString("password1", "Hi");
                            editor.apply();

                        }

                    }
                }
        );
    }


    public void addListenerToCheckBox1(){
        check2=(CheckBox)findViewById(R.id.checkBox2);
        check2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(((CheckBox)v).isChecked()){
                            SharedPreferences settings1 = getSharedPreferences("PREFS", 0);
                            SharedPreferences.Editor editor = settings1.edit();
                            editor.putString("password1", "Hi");
                            editor.apply();
                            Intent myDisableIntent = new Intent(SettingsActivity.this, MainActivity.class);
                            SettingsActivity.this.startActivity(myDisableIntent);
                        }else{
                            SharedPreferences settings1 = getSharedPreferences("PREFS", 0);
                            SharedPreferences.Editor editor = settings1.edit();
                            editor.putString("password1", "Hi");
                            editor.apply();
                        }

                    }
                }
        );
    }
/*
    public void SettingsActivity(View view) {

        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }
    */


    public void IncomefilterActivity(View view) {

        Intent intent = new Intent(this, IncomefilterActivity.class);
        startActivity(intent);

    }

    public void ExpensefilterActivity(View view) {

        Intent intent = new Intent(this, ExpensefilterActivity.class);
        startActivity(intent);

    }
}

