package com.ismailbaser.frogcatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onplayGame(View view){
        intent=new Intent(MainActivity.this,GameActivity.class);
        intent.putExtra("userName","Ismail");
        intent.putExtra("mod","Kolay");

        startActivity(intent);
    }
}