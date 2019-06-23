package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


public class StartActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        imageView = findViewById(R.id.imageView);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent w = new Intent(getApplicationContext(), BasicCalculatorActivity.class);
                startActivity(w);
            }

        };

        Handler handler = new Handler();

        handler.postDelayed(runnable,1000);
    }
}
