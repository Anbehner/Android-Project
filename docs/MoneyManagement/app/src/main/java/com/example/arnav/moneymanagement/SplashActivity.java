package com.example.arnav.moneymanagement;

/**
 * Created by GOURISH on 6/14/2017.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
    @desc This class is for SplashActivity.
    @author: Gourish Hegde email: gourish.hegde@st.ovgu.de
    @Date:: 14/06/2017
 */

public class SplashActivity extends AppCompatActivity {

    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences settings=getSharedPreferences("PREFS",0);
        password=settings.getString("password", "");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(password.equals("")) {
                    //Navigation to the Create password Activity.
                    Intent intent = new Intent(getApplicationContext(), CreatepasswordActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    //Navigation to the Enter password Activity.
                    Intent intent = new Intent(getApplicationContext(),EnterPasswordActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

        },2000);
    }


}

