package com.example.flipthecoin2;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;


public class customFlip extends AppCompatActivity {
    public static final Random RANDOM = new Random();
    private ImageView coin;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_flip);
        SharedPreferences customimg= getSharedPreferences("custom_coin", 0);
        String frontimage = customimg.getString("front_side", "false");
        loadImageFromStorage(frontimage);
        coin = (ImageView) findViewById(R.id.coin);


        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipCoin();
            }
        });
    }
    private void flipCoin() {
        MediaPlayer player=MediaPlayer.create(this,R.raw.rolling);
        player.setLooping(true);
        player.start();
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000);
        fadeOut.setFillAfter(true);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                SharedPreferences customimg= getSharedPreferences("custom_coin", 0);
                String frontimage ="/data/data/com.example.flipthecoin2/app_imageDir";
                //coin.setImageResource(RANDOM.nextFloat() > 0.5f ? loadImageFromStorage(frontimage); : R.drawable.aus2);
                if(RANDOM.nextInt() > 0.5f){
                    loadImageFromStorage(frontimage);
                }else{
                    loadImageFromStorage2(frontimage);
                }
                Animation fadeIn = new AlphaAnimation(0, 1);
                fadeIn.setInterpolator(new DecelerateInterpolator());
                fadeIn.setDuration(3000);
                fadeIn.setFillAfter(true);

                coin.startAnimation(fadeIn);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        coin.startAnimation(fadeOut);
    }
    private void loadImageFromStorage(String path)
    {

        try {
            File f=new File(path, "frontside.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView img=(ImageView)findViewById(R.id.coin);
            img.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }
    private void loadImageFromStorage2(String path)
    {

        try {
            File f=new File(path, "backside.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView img=(ImageView)findViewById(R.id.coin);
            img.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}
