package com.ismailbaser.frogcatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    TextView viewname, viewscore, viewhighscore, viewtimer,viewmod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        viewname=findViewById(R.id.viewName);
        viewhighscore=findViewById(R.id.viewHighScore);
        viewmod=findViewById(R.id.viewMod);
        viewscore=findViewById(R.id.viewScore);
        viewtimer=findViewById(R.id.viewTimer);
        Intent intent=getIntent();
       viewname.setText(intent.getStringExtra("userName"));
       viewmod.setText(intent.getStringExtra("mod"));


    }
    public void addScore(View view){



    }
}