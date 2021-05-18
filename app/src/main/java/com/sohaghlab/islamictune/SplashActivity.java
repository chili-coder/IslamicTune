package com.sohaghlab.islamictune;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    Animation topAnim,bottomAnim;

    TextView title,sub1,sub2,sub3;
    ImageView logo;

    private static int SPLASH_SCREEN_DALLY=3500;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);



        logo =findViewById(R.id.logoSp);
        title=findViewById(R.id.tittleSp);
        sub1=findViewById(R.id.sub1Sp);
        sub2=findViewById(R.id.sub2Sp);
        sub3=findViewById(R.id.sub3Sp);

        //set animation

        logo.setAnimation(topAnim);
        title.setAnimation(topAnim);

        sub1.setAnimation(bottomAnim);
        sub2.setAnimation(bottomAnim);
        sub3.setAnimation(bottomAnim);



//splash screen
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){

                Intent splashEndIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(splashEndIntent);
                finish();

            }

        },SPLASH_SCREEN_DALLY);







    }







}