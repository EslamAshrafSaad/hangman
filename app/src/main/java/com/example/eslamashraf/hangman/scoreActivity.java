package com.example.eslamashraf.hangman;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class scoreActivity extends AppCompatActivity {
    SqlLite c ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        c = new SqlLite(getApplicationContext());

        Cursor r = c.selectQuery();
        String mails[] = new String[r.getCount()];
        String score[] = new String[r.getCount()];
        String tempScore, tempMail;

        for(int i = 0; i < mails.length ; i++)
        {
            r.moveToNext();
            mails[i] = r.getString(2);
            score[i] = r.getString(4);

        }


        //***********************************
        for (int i = 0; i < mails.length; i++) {
            for (int j = i+1; j < mails.length; j++) {

                if(Integer.parseInt(score[i])<Integer.parseInt(score[j])) {
                    tempScore=score[i];
                    score[i]=score[j];
                    score[j]=tempScore;
                    //************
                    tempMail=mails[i];
                    mails[i]=mails[j];
                    mails[j]=tempMail;


                }
            }}

        String countScor[]=new String[r.getCount()];
        for(int i=0;i< mails.length;i++){

            countScor[i]=Integer.toString(i+1);
        }

//***************************************************

        MyAdabter x = new MyAdabter(this, mails, score,countScor);

        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(x);
    }
}
