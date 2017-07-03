package com.example.arnav.moneymanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
    @desc This class is for CreatepasswordActivity. where user can
    Create a passcode  to secure the application.
    @author: Gourish Hegde email: gourish.hegde@st.ovgu.de
    @Date:: 03/06/2017
 */

public class CreatepasswordActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createpassword);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);

        //Adding Onclick listener Event for the Button.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();

                if(text1.equals("") || text2.equals("") ) {
                    //Show an Error message
                    Toast.makeText(CreatepasswordActivity.this, "No Password Entered", Toast.LENGTH_SHORT).show();
                }else {

                    //Comparing if both the entered and re entered passwords are matching.
                    if(text1.equals(text2)) {
                        SharedPreferences settings = getSharedPreferences("PREFS", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("password", text1);
                        editor.apply();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(CreatepasswordActivity.this, "Password Doesnot Match", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });

    }
}
