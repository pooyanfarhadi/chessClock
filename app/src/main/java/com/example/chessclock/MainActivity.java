package com.example.chessclock;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {








    private Button topbtn;
    private Button bottonbtn;
    private Button Stop;
    private Button reset;
    private Button pause;

    public long wTimer;
    public long bTimer;
    public static CountDownTimer w;
    public static CountDownTimer b;
    public boolean TimerrunningW;
    public boolean TimerrunningB ;

    TextView copyRight ;


   public static long RemainTimeW = 300000;
   public static long RemainTimeB = 300000;

   PopupWindow popUpReset;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //intent $$$$$$$$$$$$$$$$$
        Intent intent = getIntent();
        String choose = intent.getStringExtra("key");
        long longchoose = Long.parseLong(choose);

        RemainTimeB=longchoose;
        RemainTimeW=longchoose;



        //$$$$$$$$$$$$$$$$$$$
        copyRight=findViewById(R.id.Copyright);
        reset=findViewById(R.id.reset);
        pause=findViewById(R.id.pause);
        topbtn = findViewById(R.id.topbtn);
        bottonbtn = findViewById(R.id.bottonbtn);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.tik);
        final MediaPlayer finish = MediaPlayer.create(this, R.raw.fin);
        topbtn.setText("00:00");
        topbtn.setTextSize(TypedValue.COMPLEX_UNIT_SP,100);
        bottonbtn.setText("00:00");
        bottonbtn.setTextSize(TypedValue.COMPLEX_UNIT_SP,100);

        // کلیک روی pause
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TimerrunningW == true || TimerrunningB == true){
                    bottonbtn.setBackgroundColor(Color.rgb(128,128,128));
                    topbtn.setBackgroundColor(Color.rgb(128,128,128));
                w.cancel();
                b.cancel();
                RemainTimeW=wTimer;
                RemainTimeB=bTimer;}


            }
        });


        /// کلیک روی W
        topbtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                mp.start();


                if(TimerrunningW==true ){
                    topbtn.setBackgroundColor(Color.rgb(128,128,128));
                    bottonbtn.setBackgroundColor(Color.rgb(3,169,244));



                w.cancel();
                    RemainTimeW=wTimer;

                }

                b = new CountDownTimer(RemainTimeB, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int minutes = (int) (millisUntilFinished / 60);
                        int second = (int) (millisUntilFinished / 1000);
                        second = second % 60;
                        bottonbtn.setText( + minutes / 1000 + ":" + second);
                        bottonbtn.setTextSize(TypedValue.COMPLEX_UNIT_SP,100);

                        bTimer = millisUntilFinished;
                    }

                    public void onFinish() {
                        finish.start();
                        bottonbtn.setText("Flaged!");
                        bottonbtn.setTextSize(TypedValue.COMPLEX_UNIT_SP,80);
                    }

                }.start();
                TimerrunningB = true;


            }

        });




        //// کلیک روی b

        bottonbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mp.start();
                if (TimerrunningB==true){
                    topbtn.setBackgroundColor(Color.rgb(3,169,244));
                    bottonbtn.setBackgroundColor(Color.rgb(128,128,128));


                b.cancel();

                    RemainTimeB=bTimer;}


                w = new CountDownTimer(RemainTimeW, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int minutes = (int) (millisUntilFinished / 60);
                        int second = (int) (millisUntilFinished / 1000);
                        second = second % 60;
                        topbtn.setText( + minutes / 1000 + ":" + second);
                        topbtn.setTextSize(TypedValue.COMPLEX_UNIT_SP,100);
                        wTimer = millisUntilFinished;
                    }

                    public void onFinish() {
                        finish.start();
                        topbtn.setText("Flaged!");
                        topbtn.setTextSize(TypedValue.COMPLEX_UNIT_SP,80);
                    }

                }.start();
                TimerrunningW = true;

            }

        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                        RemainTimeB = 300000;
                        RemainTimeW = 300000;
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);


                    }
                });


            }

    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this, First_Activity.class);
        startActivity(intent);

    }


}