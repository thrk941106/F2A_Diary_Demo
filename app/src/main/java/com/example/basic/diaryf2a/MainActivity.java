package com.example.basic.diaryf2a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showListAct(View view) {
        Intent i = new Intent(MainActivity.this, ListAct.class);
        startActivity(i);
    }
    public void showInsAct(View view) {
        Intent i = new Intent(MainActivity.this, InsAct.class);
        startActivity(i);
    }
}
