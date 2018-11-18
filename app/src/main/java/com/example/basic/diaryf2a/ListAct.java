package com.example.basic.diaryf2a;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class ListAct extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        loadDB();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDB();
    }

    public void onClickList(View view) {
        Intent i = new Intent(ListAct.this, DiaryViewAct.class);
        i.putExtra("id","1");
        startActivity(i);
    }


    public void loadDB(){

        //deleteDatabase("test.db");
        SQLiteDatabase db = openOrCreateDatabase(
                "test.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS Diary "
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, date DATETIME DEFAULT (datetime('now','localtime')), title TEXT NOT NULL, main TEXT)");


        Cursor c = db.rawQuery("SELECT * FROM Diary;", null);
        startManagingCursor(c);

        ListAdapter adapt = new SimpleCursorAdapter(
                this,
                R.layout.listing,
                c,
                new String[]{"date", "title"},
                new int[]{R.id.list_view_date, R.id.list_view_title}, 0
        );

        setListAdapter(adapt);

        if(db != null){
            db.close();
        }
    }
}

