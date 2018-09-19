package com.example.eslamashraf.hangman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_register);
        Button sign= findViewById(R.id.signIn11);
        Button reg= findViewById(R.id.signUP11);
        Button out= findViewById(R.id.button4);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SignRegisterActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SignRegisterActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
                Intent intent= new Intent(SignRegisterActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
