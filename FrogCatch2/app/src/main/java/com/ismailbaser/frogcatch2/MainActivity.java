package com.ismailbaser.frogcatch2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    TextView txtName;
    RadioGroup radioGroup;
    String gameMod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName=findViewById(R.id.txtName);
        radioGroup=findViewById(R.id.radioGroup);
        gameMod="Easy";
    }

    public void  checkButton(View view){
        int radioId=radioGroup.getCheckedRadioButtonId();
       RadioButton radioButton=findViewById(radioId);
        gameMod=radioButton.getText().toString();
        Toast.makeText(MainActivity.this,"Game Mod: "+gameMod,Toast.LENGTH_SHORT).show();

    }
    public void onplayGame(View view){

        if (txtName.getText().toString().matches("")) {
            Toast.makeText(this, "Opps!! Name can not be emty...", Toast.LENGTH_LONG).show();

        }
        else{
            intent = new Intent(MainActivity.this,GameActivity.class);
            intent.putExtra("userName", txtName.getText().toString());
            intent.putExtra("mod",gameMod);

            startActivity(intent);
        }}

}