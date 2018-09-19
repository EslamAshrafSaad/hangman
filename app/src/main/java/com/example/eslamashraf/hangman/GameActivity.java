package com.example.eslamashraf.hangman;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    SqlLite table;
    char[] name;
    int win,lose=0,num,coins,score,count1=0;
    Random r,de;
    TextView category,txtCoins,txtScore;
    String names[],oldScore;
    ImageView hang;
    int delCount=5;
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    Map<Character,Button> buttonMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        hang= findViewById(R.id.imageView);
        category= (TextView)findViewById(R.id.textView8);
        category.setText(getIntent().getStringExtra("category"));
        names= new String[getIntent().getStringArrayExtra("words").length];
        names=getIntent().getStringArrayExtra("words");
        table = new SqlLite(getApplicationContext());
        Cursor rr=table.selectWhere(sharedPreferences.getString("mail","0"));
        if(rr.getCount()>0) {
            rr.moveToNext();
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("coins",rr.getString(5).toString());
            oldScore=rr.getString(4).toString();
            editor.commit();
        }
        coins=getIntent().getIntExtra("coins",Integer.parseInt(sharedPreferences.getString("coins","0")));
        score=getIntent().getIntExtra("score",0);
        txtCoins=findViewById(R.id.textView10);
        txtCoins.setText(Integer.toString(coins)+" $");
        txtScore=findViewById(R.id.time);
        txtScore.setText("Score ( "+Integer.toString(score)+" )");
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear);
        r= new Random();
        num=r.nextInt(names.length);
        for (int counter =0;counter<names[num].length();counter++)
        {
            TextView valueTV = new TextView(this);
            valueTV.setText("#");
            valueTV.setId(counter);
            valueTV.setTextSize(20);
            valueTV.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ((LinearLayout) linearLayout).addView(valueTV);
        }
        name = names[num].toCharArray();
        //////////////////////////////////////////
        win=name.length;
        for (int ii=0;ii<name.length;ii++)
        {
            if(name[ii]==' ')
            {
                TextView textView=findViewById(ii);
                textView.setText(" ");
                win--;
            }
        }
        final Button a = findViewById(R.id.a);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               buttonClick(a,'A','a');
            }
        });
        final Button b = findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(b,'B','b');

            }
        });
        final Button c = findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(c,'C','c');
            }
        });
        final Button d = findViewById(R.id.d);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(d,'D','d');
            }
        });
        final Button e = findViewById(R.id.e);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(e,'E','e');
            }
        });
        final Button f = findViewById(R.id.f);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(f,'F','f');
            }
        });
        final Button g = findViewById(R.id.g);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(g,'G','g');
            }
        });
        final Button h = findViewById(R.id.h);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(h,'H','h');
            }
        });
        final Button i = findViewById(R.id.i);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(i,'I','i');
            }
        });
        final Button j = findViewById(R.id.j);
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(j,'J','j');
            }
        });
        final Button k = findViewById(R.id.k);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(k,'K','k');
            }
        });
        final Button l = findViewById(R.id.l);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(l,'L','l');
            }
        });
        final Button m = findViewById(R.id.m);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(m,'M','m');
            }
        });
        final Button n = findViewById(R.id.n);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(n,'N','n');
            }
        });
        final Button o = findViewById(R.id.o);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(o,'O','o');
            }
        });
        final Button p = findViewById(R.id.p);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(p,'P','p');
            }
        });
        final Button q = findViewById(R.id.q);
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(q,'Q','q');
            }
        });
        final Button r = findViewById(R.id.r);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(r,'R','r');
            }
        });
        final Button s = findViewById(R.id.s);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(s,'S','s');
            }
        });
        final Button t = findViewById(R.id.t);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(t,'T','t');
            }
        });
        final Button u = findViewById(R.id.u);
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClick(u,'U','u');
            }
        });
        final Button V = findViewById(R.id.v);
        V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(V,'V','v');
            }
        });
        final Button w = findViewById(R.id.w);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(w,'W','w');
            }
        });
        final Button x = findViewById(R.id.x);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(x,'X','x');
            }
        });
        final Button y = findViewById(R.id.y);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(y,'Y','y');
            }
        });
        final Button z = findViewById(R.id.z);
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonClick(z,'Z','z');
            }
        });
        buttonMap=new HashMap<Character, Button>();
        buttonMap.put('a',a);
        buttonMap.put('b',b);
        buttonMap.put('c',c);
        buttonMap.put('d',d);
        buttonMap.put('e',e);
        buttonMap.put('f',f);
        buttonMap.put('g',g);
        buttonMap.put('h',h);
        buttonMap.put('i',i);
        buttonMap.put('j',j);
        buttonMap.put('k',k);
        buttonMap.put('l',l);
        buttonMap.put('m',m);
        buttonMap.put('n',n);
        buttonMap.put('o',o);
        buttonMap.put('p',p);
        buttonMap.put('q',q);
        buttonMap.put('r',r);
        buttonMap.put('s',s);
        buttonMap.put('t',t);
        buttonMap.put('u',u);
        buttonMap.put('v',V);
        buttonMap.put('w',w);
        buttonMap.put('x',x);
        buttonMap.put('y',y);
        buttonMap.put('z',z);
        ImageView solve = findViewById(R.id.show);
        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(coins>=30)
              {
                  coins-=30;
                  ShowDialogWin(names[num]);
              }
              else
              {
                  Toast.makeText(GameActivity.this,"No Coins Enough",Toast.LENGTH_SHORT).show();
              }
            }
        });
        ImageView del=findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(delCount>0)
                {
                    delCount--;
                    if(coins>=5) {
                    de= new Random();
                    coins-=5;
                    txtCoins=findViewById(R.id.textView10);
                    txtCoins.setText(String.valueOf(coins)+" $");
                    int rand=de.nextInt(26);
                    while (true)
                    {
                        char c1='a';
                        c1+=rand;
                        char c2=c1;
                        c2-=32;
                        if(!names[num].contains(String.valueOf(c2))&&!names[num].contains(String.valueOf(c1))&&buttonMap.get(c1).isEnabled())
                       {
                           buttonMap.get(c1).setEnabled(false);
                           buttonMap.get(c1).setVisibility(View.INVISIBLE);
                           break;
                       }
                       else {
                           if(rand==25)
                               rand=0;
                           else rand++;
                       }

                    }
                }
                else{
                    Toast.makeText(GameActivity.this, "No Coins Enough", Toast.LENGTH_SHORT).show();
                }
                }
                else{
                    Toast.makeText(GameActivity.this, "You can delete 5 characters only", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ImageView find=findViewById(R.id.find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(coins>=10) {
                   de = new Random();
                   int bbb = names[num].length();
                   int rand = de.nextInt(bbb);
                   char[] chars=names[num].toCharArray();
                   coins-=10;
                   txtCoins=findViewById(R.id.textView10);
                   txtCoins.setText(String.valueOf(coins)+" $");
                   while (true) {
                  if ((chars[rand] == 'a'||chars[rand] == 'A')&&a.isEnabled()) {
                          buttonClick(a, 'A', 'a');
                          break;

                  } else if ((chars[rand] == 'b'||chars[rand] == 'B')&&b.isEnabled()) {

                          buttonClick(b, 'B', 'b');
                          break;

                  } else if ((chars[rand] == 'c'||chars[rand] == 'C')&&c.isEnabled()) {

                          buttonClick(c, 'C', 'c');
                          break;
                  }
                  else if ((chars[rand] == 'd'||chars[rand] == 'D')&&d.isEnabled()) {

                          buttonClick(d, 'D', 'd');
                          break;
                  }else if ((chars[rand] == 'e'||chars[rand] == 'E')&&e.isEnabled()) {

                          buttonClick(e, 'E', 'e');
                          break;
                  }else if ((chars[rand] == 'f'||chars[rand] == 'F')&&f.isEnabled()) {

                          buttonClick(f, 'F', 'f');
                          break;
                  }else if ((chars[rand] == 'g'||chars[rand] == 'G')&&g.isEnabled()) {

                          buttonClick(g, 'G', 'g');
                          break;
                  }else if ((chars[rand] == 'h'||chars[rand] == 'H')&&h.isEnabled()) {

                          buttonClick(h, 'H', 'h');
                          break;
                  }else if ((chars[rand] == 'i'||chars[rand] == 'I')&&i.isEnabled()) {

                          buttonClick(i, 'I', 'i');
                          break;
                  }else if ((chars[rand] == 'j'||chars[rand] == 'J')&&j.isEnabled()) {

                          buttonClick(j, 'J', 'j');
                          break;
                  }else if ((chars[rand] == 'k'||chars[rand] == 'K')&&k.isEnabled()) {

                          buttonClick(k, 'K', 'k');
                          break;
                  }else if ((chars[rand] == 'l'||chars[rand] == 'L')&&l.isEnabled()) {

                          buttonClick(l, 'L', 'l');
                          break;
                  }else if ((chars[rand] == 'm'||chars[rand] == 'M')&&m.isEnabled()) {

                          buttonClick(m, 'M', 'm');
                          break;
                  }else if ((chars[rand] == 'n'||chars[rand] == 'N')&&n.isEnabled()) {

                          buttonClick(n, 'N', 'n');
                          break;
                  }else if ((chars[rand] == 'o'||chars[rand] == 'O')&&o.isEnabled()) {

                          buttonClick(o, 'O', 'o');
                          break;
                  }else if ((chars[rand] == 'p'||chars[rand] == 'P')&&p.isEnabled()) {

                          buttonClick(p, 'P', 'p');
                          break;
                  }else if ((chars[rand] == 'q'||chars[rand] == 'Q')&&q.isEnabled()) {

                          buttonClick(q, 'Q', 'q');
                          break;
                  }else if ((chars[rand] == 'r'||chars[rand] == 'R')&&r.isEnabled()) {

                          buttonClick(r, 'R', 'r');
                          break;
                  }else if ((chars[rand] == 's'||chars[rand] == 'S')&&s.isEnabled()) {

                          buttonClick(s, 'S', 's');
                          break;
                  }else if ((chars[rand] == 't'||chars[rand] == 'T')&&t.isEnabled()) {

                      buttonClick(t, 'T', 't');
                      break;
                  }else if ((chars[rand] == 'u'||chars[rand] == 'U')&&u.isEnabled()) {

                      buttonClick(u, 'U', 'u');
                      break;
                  }else if ((chars[rand] == 'v'||chars[rand] == 'V')&&V.isEnabled()) {

                      buttonClick(V, 'V', 'v');
                      break;
                  }else if ((chars[rand] == 'w'||chars[rand] == 'W')&&w.isEnabled()) {

                      buttonClick(w, 'W', 'w');
                      break;
                  }else if ((chars[rand] == 'x'||chars[rand] == 'X')&&x.isEnabled()) {

                      buttonClick(x, 'X', 'x');
                      break;
                  }else if ((chars[rand] == 'y'||chars[rand] == 'Y')&&y.isEnabled()) {

                      buttonClick(y, 'Y', 'y');
                      break;
                  }else if ((chars[rand] == 'z'||chars[rand] == 'Z')&&z.isEnabled()) {

                      buttonClick(z, 'Z', 'z');
                      break;
                  }
                  else
                  {
                      if(rand==names[num].length()-1)
                      {
                          rand=0;
                      }
                      else{
                          rand++;
                      }
                  }

              }
               }else{
                   Toast.makeText(GameActivity.this, "No Coins Enough", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    void Draw(int test)
    {
        if(test==win)
        {
            lose++;
            if(lose==1)
                hang.setImageResource(R.drawable.head);
            else if(lose==2)
                hang.setImageResource(R.drawable.body);
            else if(lose==3)
                hang.setImageResource(R.drawable.hand);
            else if(lose==4)
                hang.setImageResource(R.drawable.leg);
        }

    }
    void ShowDialogWin(String movieTitle)
    {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(GameActivity.this);

        View view = LayoutInflater.from(GameActivity.this).inflate(R.layout.win_lose, null);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText("You Win");
        TextView Mtitle = (TextView) view.findViewById(R.id.MovieTitle);
        Mtitle.setText(movieTitle);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent= new Intent(GameActivity.this,GameActivity.class);
                intent.putExtra("score",score);
                intent.putExtra("coins",coins);
                intent.putExtra("category",category.getText());
                intent.putExtra("words",names);

                startActivity(intent);
                GameActivity.this.finish();
            }
        });
        builder.setView(view);
        builder.setCancelable(false);
        builder.show();

        ////////////////////////////////////
        txtCoins=findViewById(R.id.textView10);
        coins +=5;
        String x=Integer.toString(coins);
        txtCoins.setText(x+" $");
        ///////////////////////////////////////

    }
    void ShowDialogLose(String movieTitle)
    {
        SqlLite ccc= new SqlLite(getApplicationContext());
        SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        if(score>Integer.parseInt(oldScore))
        {ccc.updateScoreAndCoins(sharedPreferences.getString("mail",""),String.valueOf(score),String.valueOf(coins));}
        else
        {ccc.updateScoreAndCoins(sharedPreferences.getString("mail",""),oldScore,String.valueOf(coins));}

        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(GameActivity.this);

        View view = LayoutInflater.from(GameActivity.this).inflate(R.layout.win_lose, null);

        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText("You Lose");
        TextView Mtitle = (TextView) view.findViewById(R.id.MovieTitle);
        Mtitle.setText(movieTitle);

        builder.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent= new Intent(GameActivity.this,GameActivity.class);
                intent.putExtra("category",category.getText());
                intent.putExtra("words",names);
                startActivity(intent);
                GameActivity.this.finish();
            }
        });
        builder.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent= new Intent(GameActivity.this,MenuActivity.class);
                startActivity(intent);
                GameActivity.this.finish();
            }
        });
        builder.setView(view);
        builder.setCancelable(false);
        builder.show();

    }
    void buttonClick(Button a,char upper,char lower)
    {
        a.setEnabled(false);
        a.setVisibility(View.INVISIBLE);
        int test=win;
        count1=0;
        for (int ii=0;ii<name.length;ii++)
        {
            if(name[ii]==upper)
            {
                TextView textView=findViewById(ii);
                textView.setText(String.valueOf(upper));
                win--;
                count1++;
                if (count1==1){
                    score +=5;
                    String x=Integer.toString(score);
                    txtScore.setText("Score( "+x+" )");
                }
            }
            else  if(name[ii]==lower)
            {
                TextView textView=findViewById(ii);
                textView.setText(String.valueOf(lower));
                win--;
                count1++;
                if (count1==1){
                    score +=5;
                    String x=Integer.toString(score);
                    txtScore.setText("Score( "+x+" )");
                }
            }
        }

        Draw(test);
        if(win==0)
        {
            ShowDialogWin(names[num]);
        }
        if(lose==5)
        {
            ShowDialogLose(names[num]);
        }
    }
    void set_map()
    {

    }
}
