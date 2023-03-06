package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtHome;
    TextView txtWelcome;
    RelativeLayout relativeLayout;

    Animation textAnimation,layoutAnimation;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       txtHome.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
       txtWelcome.animate().translationX(3000).setDuration(3000).setStartDelay(3100);
       relativeLayout.animate().translationY(2000).setDuration(2000).setStartDelay(2000);
        relativeLayout.animate().translationX(2300).setDuration(2000).setStartDelay(2050);

      //  textAnimation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.fall_down);
        //layoutAnimation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_to_top);

        txtWelcome = findViewById(R.id.txtWelcome);
        txtHome = findViewById(R.id.txtHome);
        relativeLayout= findViewById(R.id.relMain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.VISIBLE);
                relativeLayout.setAnimation(layoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        txtHome.setVisibility(View .VISIBLE);
                        txtWelcome.setVisibility(View.VISIBLE);

                        txtWelcome.setAnimation(textAnimation);
                        txtHome.setAnimation(textAnimation);

                    }
                },800);

            }
        } ,500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

            }
        },7000);

    }
}