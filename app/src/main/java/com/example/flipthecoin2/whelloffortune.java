package com.example.flipthecoin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class whelloffortune extends AppCompatActivity {
    Button spin,change;
    TextView wheelgame;
    ImageView wheel;
    String[] sectors={"Give treat to your friend","Slap a stranger","Plan tour with your family","Explore new places","Bring a pet","Watch a horror movie","Plan a ride","Watch a series","Play a football match","Go for a nightout","Go for a trek with strangers","Eat a raw egg"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whelloffortune);
        spin = findViewById(R.id.spin1);
        wheelgame = findViewById(R.id.game);
        wheel = findViewById(R.id.wheelimage1);
        change=findViewById(R.id.theme);

        Collections.reverse(Arrays.asList(sectors));

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openthemeactivity();
            }
        });

        spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rr= new Random();
                final int degree=rr.nextInt(360);
                RotateAnimation rotateAnimation = new RotateAnimation(0,degree+720, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(3600);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {


                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Calculatepoint(degree);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                wheel.startAnimation(rotateAnimation);

            }
        });

    }
    public void Calculatepoint(int degree){
        int initialPoint=0;
        int endPoint=30;
        String res=null;
        int i=0;
        do {
            if (degree > initialPoint && degree < endPoint)
            {
                res = sectors[i];
            }
            initialPoint += 30;
            endPoint += 30;
            i++;
        }while (res == null);
        wheelgame.setText(res);
    }
    public void openthemeactivity (){
        Intent intent= new Intent(this,Wheeltheme.class);
        startActivity(intent);

    }

}
