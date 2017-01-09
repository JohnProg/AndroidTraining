package com.example.jmachahuay.lesson1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnGoToFirstExercise, btnGoToSecondExercise, btnGoToThirdExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoToFirstExercise = (Button) findViewById(R.id.btnGoToFirstExercise);
        btnGoToSecondExercise = (Button) findViewById(R.id.btnGoToSecondExercise);
        btnGoToThirdExercise = (Button) findViewById(R.id.btnGoToThirdExercise);

        btnGoToFirstExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exercise1Activity.class);
                startActivity(intent);
            }
        });

        btnGoToSecondExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exercise2Activity.class);
                startActivity(intent);
            }
        });

        btnGoToThirdExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exercise3Activity.class);
                startActivity(intent);
            }
        });
    }
}
