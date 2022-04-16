package com.example.chessclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First_Activity extends AppCompatActivity {
    Button mins3btn;
    Button mins5btn;
    Button mins10btn;
    Button mins15btn;
    Button mins25btn;
    Button Desiredbtn;
    public static String choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mins3btn = findViewById(R.id.min3);
        mins3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = "150000";
                Intent intent = new Intent(First_Activity.this, MainActivity.class);
                intent.putExtra("key", choose);
                startActivity(intent);
                startActivity(new Intent(First_Activity.this, MainActivity.class));

            }
        });


        mins5btn = findViewById(R.id.min5);
        mins5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = "300000";
                Intent intent = new Intent(First_Activity.this, MainActivity.class);
                intent.putExtra("key", choose);
                startActivity(intent);
                startActivity(new Intent(First_Activity.this, MainActivity.class));


            }
        });


        mins10btn = findViewById(R.id.min10);
        mins10btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = "600000";
                Intent intent = new Intent(First_Activity.this, MainActivity.class);
                intent.putExtra("key", choose);
                startActivity(intent);
                startActivity(new Intent(First_Activity.this, MainActivity.class));


            }
        });

        mins15btn = findViewById(R.id.min15);
        mins15btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = "900000";
                Intent intent = new Intent(First_Activity.this, MainActivity.class);
                intent.putExtra("key", choose);
                startActivity(intent);
                startActivity(new Intent(First_Activity.this, MainActivity.class));

            }
        });
        mins25btn = findViewById(R.id.min25);
        mins25btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = "1500000";
                Intent intent = new Intent(First_Activity.this, MainActivity.class);
                intent.putExtra("key", choose);
                startActivity(intent);
                startActivity(new Intent(First_Activity.this, MainActivity.class));


            }
        });


        Desiredbtn = findViewById(R.id.Desired);


    }


}