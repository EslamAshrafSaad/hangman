package com.example.eslamashraf.hangman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    SqlLite table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        table = new SqlLite(getApplicationContext());
        Button button= findViewById(R.id.signIn22);
        final EditText email=findViewById(R.id.Email22);
        final EditText pass=findViewById(R.id.passWord22);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passsword=pass.getText().toString();
                String mail=email.getText().toString();
                mail=mail.trim();
                Cursor r=table.selectQueryWhere(mail,passsword);
                if(r.getCount()>0) {
                    r.moveToNext();
                   // Toast.makeText(SignInActivity.this, r.getString(0).toString(), Toast.LENGTH_SHORT).show();
                    String s = r.getString(0).toString()+" "+r.getString(1).toString();
                    Intent intent=new Intent(SignInActivity.this,MenuActivity.class);
                    SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("name",s);
                    editor.putString("mail",r.getString(2).toString());
                    editor.putString("coins",r.getString(5).toString());
                    editor.putString("score",r.getString(4).toString());
                    editor.commit();
                    Toast.makeText(SignInActivity.this,"Welcome "+s,Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(intent);
                }else{
                    Toast.makeText(SignInActivity.this,"Invalid mail or password!",Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button button1=findViewById(R.id.dont);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignInActivity.this,RegisterActivity.class);
         startActivity(intent);
            }
        });

    }
}
