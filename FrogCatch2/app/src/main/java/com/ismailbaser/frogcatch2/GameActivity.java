package com.ismailbaser.frogcatch2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView viewname, viewscore, viewhighscore, viewtimer,viewmod;
    ImageView viewfrog00, viewfrog01,viewfrog02, viewfrog10, viewfrog11, viewfrog12, viewfrog20, viewfrog21, viewfrog22,
            viewfrog100, viewfrog101, viewfrog102, viewfrog110, viewfrog111, viewfrog112, viewfrog120, viewfrog121, viewfrog122;
    ImageView[] imageArray1;
    ImageView[] imageArray2;
    Handler handler;
    Runnable runnable, runnable2;
    int modint;
    int score;
    int a;
    int a2=-2;
    int i=-1;
    SharedPreferences sharedPreferences;
    String userName, savedName, gameMod;
    int savedHighScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        viewname=findViewById(R.id.viewName);
        viewhighscore=findViewById(R.id.viewHighScore);
        viewmod=findViewById(R.id.viewMod);
        viewscore=findViewById(R.id.viewScore);
        viewtimer=findViewById(R.id.viewTimer);

        //******FROGS-1
        viewfrog00=findViewById(R.id.viewfrog00);
        viewfrog01=findViewById(R.id.viewfrog01);
        viewfrog02=findViewById(R.id.viewfrog02);

        viewfrog10=findViewById(R.id.viewfrog10);
        viewfrog11=findViewById(R.id.viewfrog11);
        viewfrog12=findViewById(R.id.viewfrog12);

        viewfrog20=findViewById(R.id.viewfrog20);
        viewfrog21=findViewById(R.id.viewfrog21);
        viewfrog22=findViewById(R.id.viewfrog22);
        //******
        //******FROGS-2
        viewfrog100=findViewById(R.id.viewfrog100);
        viewfrog101=findViewById(R.id.viewfrog101);
        viewfrog102=findViewById(R.id.viewfrog102);

        viewfrog110=findViewById(R.id.viewfrog110);
        viewfrog111=findViewById(R.id.viewfrog111);
        viewfrog112=findViewById(R.id.viewfrog112);

        viewfrog120=findViewById(R.id.viewfrog120);
        viewfrog121=findViewById(R.id.viewfrog121);
        viewfrog122=findViewById(R.id.viewfrog122);
        //******
        imageArray1=new ImageView[]{viewfrog00, viewfrog01,viewfrog02, viewfrog10, viewfrog11, viewfrog12, viewfrog20, viewfrog21, viewfrog22};
        imageArray2=new ImageView[]{viewfrog100, viewfrog101, viewfrog102, viewfrog110, viewfrog111, viewfrog112, viewfrog120, viewfrog121, viewfrog122};
        hideImages();
        Intent intent=getIntent();
        userName=intent.getStringExtra("userName");
        gameMod=intent.getStringExtra("mod");
        viewname.setText("Merhaba "+userName);
        viewmod.setText("Mod: "+gameMod);
        viewtimer=findViewById(R.id.viewTimer);

        score=0;

        if (gameMod.toString().equals("Difficult")){
            modint=500;

        }
        else if(gameMod.toString().equals("Mid")){
            modint=750;

        }
        else if(gameMod.toString().equals("Easy")){
            modint=1000;

        }
        else if(gameMod.toString().equals("Very difficult")){
            modint=250;

        }
        new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                viewtimer.setText("Time : "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                viewtimer.setText("Time off");
                handler.removeCallbacks(runnable);
                handler.removeCallbacks(runnable2);

                for (ImageView image:imageArray1){

                    image.setVisibility(View.INVISIBLE);
                }
                for (ImageView image:imageArray2){

                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert=new AlertDialog.Builder(GameActivity.this);
                alert.setTitle("Restart");
                alert.setMessage("Are you sure to restart game?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=getIntent();
                        finish();
                        startActivity(intent);

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(GameActivity.this,"Game fnished", Toast.LENGTH_SHORT);
                        Intent intent = new Intent(GameActivity.this, MainActivity.class);
                        finish();
                        startActivity(intent);

                    }
                });
                alert.show();

            }
        }.start();
    }


    public void addScore(View view){

        score+=1;
        viewscore.setText("Score: "+score);


    }
    public void hideImages(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image:imageArray2){
                    image.setVisibility(View.INVISIBLE);
                }
                for (ImageView image:imageArray1){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random=new Random();
                a = random.nextInt(9);

                if (a != a2) {
                    a2 = a;
                    i = a;
                }
                else{
                    a = (random.nextInt(9) + 1) % 8;
                    a2=a;
                    i=a;
                }

                imageArray2[i].setVisibility(View.VISIBLE);
                runnable2=new Runnable() {
                    @Override
                    public void run() {
                        imageArray2[i].setVisibility(View.INVISIBLE);
                        imageArray1[i].setVisibility(View.VISIBLE);

                    }
                };
                handler.postDelayed(runnable2, modint-200);

                handler.postDelayed(runnable, modint);

            }
        };
        handler.post(runnable);
    }
}