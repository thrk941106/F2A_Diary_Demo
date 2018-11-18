package com.example.basic.diaryf2a;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class DiaryViewAct extends AppCompatActivity {
    TextView tv;
    TextView tv2;
    TextView tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_view);
        loadDB();
    }
    @Override
    protected void onResume() {
        super.onResume();
        loadDB();
    }
    public void loadDB(){

        //deleteDatabase("test.db");
        SQLiteDatabase db = openOrCreateDatabase(
                "test.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null
        );
        Intent i =getIntent();
        String s = i.getStringExtra("id");

        Cursor c = db.rawQuery("SELECT * FROM Diary WHERE _id="+s+";", null);
        c.moveToNext();

        String title = c.getString(2);
        String date = c.getString(1);
        String main = c.getString(3);

        Log.d("d","##################################################"+title);
        tv = (TextView) findViewById(R.id.SHOW_TITLE_Text);
        tv.setText(title);

        tv2 = (TextView) findViewById(R.id.SHOW_DATE_Text);
        tv2.setText(date);

        tv3 = (TextView)findViewById(R.id.SHOW_MAIN_Text);
        tv3.setText(main);

        if(db != null){
            db.close();
        }
    }
}
