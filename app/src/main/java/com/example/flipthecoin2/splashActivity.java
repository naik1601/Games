package com.example.flipthecoin2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class splashActivity extends AppCompatActivity {


    LottieAnimationView lottieAnimationView;
    LottieAnimationView lottieAnimationView1;
    LottieAnimationView lottieAnimationView2;
    private TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        appName=findViewById(R.id.app_name);
        lottieAnimationView = findViewById(R.id.lottie);
        lottieAnimationView1 = findViewById(R.id.lottie1);
        lottieAnimationView2 = findViewById(R.id.lottie2);


        lottieAnimationView.animate().setDuration(6000);
        lottieAnimationView1.animate().setDuration(6000);
        lottieAnimationView2.animate().setDuration(6000);


        Typeface typeface = ResourcesCompat.getFont(this,R.font.ubuntu_bold);
        appName.setTypeface(typeface);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.myanim);
        appName.setAnimation(anim);

        new Thread(){

            @Override
            public void run()
            {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



                Intent intent = new Intent(splashActivity.this,Mainsreen.class);
                startActivity(intent);
                splashActivity.this.finish();


            }

        }.start();

    }
}
