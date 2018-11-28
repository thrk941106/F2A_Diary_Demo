// 일기 쓰는 액티비티
package com.example.basic.diaryf2a;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins);
    }

    public void onClickButton(View v) {
        EditText txt = null;
        txt = (EditText)findViewById(R.id.CREATE_TITLE_editText);
        String TITLE = txt.getText().toString();
        txt = (EditText)findViewById(R.id.CREATE_MAIN_editText);       // editText2에는 반드시 숫자를 입력할 것, 숫자입력이 아니면 에러!
        String MAIN  = txt.getText().toString();

        String sql = "INSERT INTO Diary (title, main) VALUES ('" + TITLE + "','" +MAIN+"');";

        SQLiteDatabase db = openOrCreateDatabase(
                "test.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,
                null
        );

        db.execSQL(sql);

        finish(); //Call this when your activity is done and should be closed.
    }
}
