package com.example.eslamashraf.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    SqlLite table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        table = new SqlLite(getApplicationContext());
        Button signup = findViewById(R.id.signUp22);
        final EditText first=findViewById(R.id.firstName);
        final EditText last=findViewById(R.id.lastName);
        final EditText email=findViewById(R.id.Email);
        final EditText pass=findViewById(R.id.passWord);
        final EditText conpass=findViewById(R.id.confirmPassWord);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String fname=first.getText().toString();
                 String lname=last.getText().toString();
                 String mail=email.getText().toString();
                 String passsword=pass.getText().toString();
                 String cpassword=conpass.getText().toString();
                if(!passsword.equals(cpassword))
                {
                    Toast.makeText(RegisterActivity.this,"Passwords are not equal!",Toast.LENGTH_SHORT).show();

                }
                else if(!mail.contains(".com")||!mail.contains("@"))
                {
                    Toast.makeText(RegisterActivity.this,"Please Enter A Valid Mail!",Toast.LENGTH_SHORT).show();

                }
                else if(fname.length()<1)
                {
                    Toast.makeText(RegisterActivity.this,"Please Enter A Valid First Name!",Toast.LENGTH_SHORT).show();

                }else if(lname.length()<1)
                {
                    Toast.makeText(RegisterActivity.this,"Please Enter A Valid Last Name!",Toast.LENGTH_SHORT).show();

                }else if(passsword.length()<8)
                {
                    Toast.makeText(RegisterActivity.this,"Password must be 8 characters or more!",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    mail=mail.trim();
                    if(table.save(fname,lname,mail,passsword))
                    {
                        Intent intent=new Intent(RegisterActivity.this,SignInActivity.class);
                        finish();
                        startActivity(intent);
                        Toast.makeText(RegisterActivity.this,"Congratulations you have been signed up :)",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"This mail already exist",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}
