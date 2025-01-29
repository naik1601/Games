package com.example.flipthecoin2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class wheeloffortune3 extends AppCompatActivity {
    Button spin;
    TextView wheelgame3;
    ImageView wheel3;
    String[] sectors={"Sagittarius","Scorpio","Libra","Virgo","Leo","Cancer","Gemini","Taurus","Aries","Pisces","Aquarius","Capricon"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheeloffortune3);
        spin = findViewById(R.id.spin1);
        wheelgame3 = findViewById(R.id.game);
        wheel3 = findViewById(R.id.wheel);

        Collections.reverse(Arrays.asList(sectors));

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
                wheel3.startAnimation(rotateAnimation);

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
        wheelgame3.setText(res);
    }
}