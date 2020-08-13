package com.belajar.androidstylingexercises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveToNumberOne(View view) {
        startActivity(new Intent(this, BasicActivity.class));
    }

    public void moveToNumberTwo(View view) {
        startActivity(new Intent(this, NormalActivity.class));
    }

    public void moveToNumberThree(View view) {
        startActivity(new Intent(this, Norma2Activity.class));
    }

    public void moveToNumberFour(View view) {
    }
}