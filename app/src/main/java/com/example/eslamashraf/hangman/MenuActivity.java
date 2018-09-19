package com.example.eslamashraf.hangman;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    ImageView voice;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);

        View view = LayoutInflater.from(MenuActivity.this).inflate(R.layout.win_lose, null);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText("Are You Want To Exit");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(true);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setView(view);
        builder.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final TextView textViewWelcome= findViewById(R.id.welcome);

        SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
       // Toast.makeText(MenuActivity.this,sharedPreferences.getString("name","").toString(),Toast.LENGTH_SHORT).show();
        textViewWelcome.setText("Welcome "+sharedPreferences.getString("name","").toString());
        Button play= findViewById(R.id.button);
        Button help= findViewById(R.id.button2);
        Button score= findViewById(R.id.button4);
        Button signIn= findViewById(R.id.button3);
        ImageView exit = (ImageView) findViewById(R.id.imageView);
       // mediaPlayer.start();
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);

                View view = LayoutInflater.from(MenuActivity.this).inflate(R.layout.win_lose, null);

                TextView title = (TextView) view.findViewById(R.id.title);
                title.setText("Are You Want To Exit");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        moveTaskToBack(true);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setView(view);
                builder.show();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(textViewWelcome.getText().length()>8)
              {
                  Intent intent= new Intent(MenuActivity.this,PlayActivity.class);
                startActivity(intent);
              }
                else
              {
                  AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);

                  View view = LayoutInflater.from(MenuActivity.this).inflate(R.layout.win_lose, null);

                  TextView title = (TextView) view.findViewById(R.id.title);
                  title.setText("You should sign in to play ");
                  builder.setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {
                          Intent intent= new Intent(MenuActivity.this,SignInActivity.class);
                          startActivity(intent);
                      }
                  });
                  builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {

                      }
                  });
                  builder.setView(view);
                  builder.show();
              }
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,HelpActivity.class);
                startActivity(intent);
            }
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuActivity.this,scoreActivity.class);
                startActivity(intent);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MenuActivity.this,SignRegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
