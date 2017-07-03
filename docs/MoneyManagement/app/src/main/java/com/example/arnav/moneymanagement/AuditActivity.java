package com.example.arnav.moneymanagement;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;

/**
    @desc This class is for AuditActivity.
    @author: Gourish Hegde email: gourish.hegde@st.ovgu.de
    @Date:: 20/06/2017
 */

public class AuditActivity extends AppCompatActivity {

    String password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences settings1=getSharedPreferences("PREFS",0);
        password1=settings1.getString("password1", "");

        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                //condition for checking whether to go to splash or Main Activity.
                if(password1.equals("Hello")) {
                    Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        },2000);
    }
}
