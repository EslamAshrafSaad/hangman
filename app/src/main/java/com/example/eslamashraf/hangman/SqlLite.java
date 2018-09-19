package com.example.eslamashraf.hangman;

/**
 * Created by Eslam Ashraf on 2018-04-16.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlLite extends SQLiteOpenHelper
{


    public SqlLite(Context context) {
        super(context, "World", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Data_Base ( first VARCHAR(70),last VARCHAR(11),email VARCHAR(70)PRIMARY KEY,password VARCHAR(70),score VARCHAR(70),coins VARCHAR(70));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion>oldVersion)
        {
            db.execSQL("DROP TABLE Data_Base");
        }
    }
    public boolean save (String first ,String last , String email, String password)
    {
        try
        {
            SQLiteDatabase x = this.getWritableDatabase();
            x.execSQL("INSERT INTO Data_Base VALUES ('"+first+"','"+last+"','"+email+"','"+password+"','0','50')");

            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    } public boolean updateScoreAndCoins (String mail ,String score ,String coins)
    {
        try
        {
            SQLiteDatabase x = this.getWritableDatabase();
            x.execSQL("UPDATE Data_Base SET score ='"+score+"'WHERE email='"+mail+"'");
            x.execSQL("UPDATE Data_Base SET coins ='"+coins+"'WHERE email='"+mail+"'");

            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public Cursor selectQueryWhere(String con,String con1)
    {
        SQLiteDatabase  myDB = this.getReadableDatabase();
        return myDB.rawQuery("SELECT * FROM Data_Base WHERE email ='"+con+"' AND password ='"+con1+"'", null );
    }
    public Cursor selectWhere(String con)
    {
        SQLiteDatabase  myDB = this.getReadableDatabase();
        return myDB.rawQuery("SELECT * FROM Data_Base WHERE email ='"+con+"'", null );
    }
    public Cursor score(String con)
    {
    SQLiteDatabase  myDB = this.getReadableDatabase();
    return myDB.rawQuery("SELECT score FROM Data_Base WHERE email ='"+con+"'", null );
    }
    public Cursor selectQuery()
    {
        SQLiteDatabase  myDB = this.getReadableDatabase();
        return myDB.rawQuery("SELECT * FROM Data_Base", null );
    }
    public Cursor selectDistinct()
    {
        SQLiteDatabase  myDB = this.getReadableDatabase();
        return myDB.rawQuery("SELECT DISTINCT last FROM Data_Base", null );
    }
    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Data_Base");
        db.close();
    }
}

