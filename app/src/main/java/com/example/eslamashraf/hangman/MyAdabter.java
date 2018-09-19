package com.example.eslamashraf.hangman;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * Created by Eslam Ashraf on 2018-03-22.
 */

public class MyAdabter extends BaseAdapter {
    LayoutInflater inflater=null;
    String [] mails;
    String [] scores;
    String []counterScore;

    public MyAdabter()
    {
    }

    public MyAdabter(Activity a, String mails[], String scores[],String counterScore[])
    {
        this.mails = mails;
        this.scores = scores;
        this.counterScore=counterScore;
        inflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return this.mails.length;
    }

    @Override
    public Object getItem(int i)
    {
        return i;
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View vi = view;

        if(view==null)
            vi = inflater.inflate(R.layout.score_raw, null);

        TextView text = (TextView) vi.findViewById(R.id.textViewMail);
        text.setText(mails[i]);

        text = (TextView) vi.findViewById(R.id.textViewScore);
        text.setText(scores[i]);

        text=(TextView)vi.findViewById(R.id.countSore);
        text.setText(counterScore[i]);
        return vi;
    }
}
