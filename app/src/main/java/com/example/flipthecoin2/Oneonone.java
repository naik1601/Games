package com.example.flipthecoin2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Oneonone extends AppCompatActivity {
    public static final Random RANDOM = new Random();
    private ImageView coin;
    TextView humanscoretxt, machinescoretxt;
    private Button headbtn,tailbtn,reset;
    int HumanScore,ComputerScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneonone);
        coin = (ImageView) findViewById(R.id.coin);
        headbtn = findViewById(R.id.choicehead);
        tailbtn = findViewById(R.id.choicetails);
        humanscoretxt = findViewById(R.id.humanscoretxt);
        machinescoretxt = findViewById(R.id.machinescoretxt);
        reset=findViewById(R.id.resetscore);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HumanScore=0;
                ComputerScore=0;
                humanscoretxt.setText("Humanscore:"+Integer.toString(HumanScore));
                machinescoretxt.setText("Machinescore:"+Integer.toString(ComputerScore));


            }
        });

        headbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1 is heads


            flipCoin(1);
            }
        });
        tailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 0 is Tails
            flipCoin(0);
            }
        });

    }



    private void flipCoin(final int humanselecion) {
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
                float randomvar = RANDOM.nextFloat();
                float computerselection = RANDOM.nextFloat();

//                float randomvar = RANDOM.nextFloat();
//                if(randomvar > 0.5f && humanselecion == 1){
//                    coin.setImageResource(R.drawable.america1);
//                    HumanScore += 1;
//                }else{
//                    coin.setImageResource(R.drawable.america2);
//
//                }
                // heads and human selected head and computer selected heads
                if(randomvar > 0.5f && humanselecion == 1 && computerselection > 0.5f){
                    coin.setImageResource(R.drawable.india1final);
                    HumanScore += 1;
                    ComputerScore +=1;
                    if(HumanScore < 0){
                        HumanScore =0;
                    }
                    if(ComputerScore < 0){
                        ComputerScore=0;
                    }
                    humanscoretxt.setText("Human Score:"+HumanScore);
                    machinescoretxt.setText("Machine Score: "+ComputerScore);
                    Toast.makeText(Oneonone.this, "Heads and human selected head and computer selected heads", Toast.LENGTH_LONG).show();


                }
//                heads and human selected tails and computer selcted tails
                else if(randomvar > 0.5f && humanselecion == 0 && computerselection < 0.5f){
                    coin.setImageResource(R.drawable.india1final);
                    HumanScore -= 1;
                    ComputerScore -=1;
                    if(HumanScore < 0){
                        HumanScore =0;
                    }
                    if(ComputerScore < 0){
                        ComputerScore=0;
                    }
                    humanscoretxt.setText("Human Score:"+HumanScore);
                    machinescoretxt.setText("Machine Score: "+ComputerScore);
                    Toast.makeText(Oneonone.this, "OOps!! your point will be deducted because its Heads and human selected tails and computer selcted tails", Toast.LENGTH_LONG).show();
                }
                //heads and human selcted heads but computer selcted tails
                else if(randomvar > 0.5f && humanselecion == 1 && computerselection < 0.5f){
                    coin.setImageResource(R.drawable.india1final);
                    HumanScore += 1;
//                   ComputerScore -=1;
                    if(HumanScore < 0){
                        HumanScore =0;
                    }
                    if(ComputerScore < 0){
                        ComputerScore=0;
                    }
                    humanscoretxt.setText("Human Score:"+HumanScore);
                    machinescoretxt.setText("Machine Score: "+ComputerScore);
                    Toast.makeText(Oneonone.this, "Heads and human selcted heads but computer selcted tails", Toast.LENGTH_LONG).show();
                }
                //heads and human selected tails but computer selcted heads
                else if(randomvar > 0.5f && humanselecion == 0 && computerselection > 0.5f){
                    coin.setImageResource(R.drawable.india1final);
//                    HumanScore -= 1;
                    ComputerScore +=1;
                    if(HumanScore < 0){
                        HumanScore =0;
                    }
                    if(ComputerScore < 0){
                        ComputerScore=0;
                    }
                    humanscoretxt.setText("Human Score:"+HumanScore);
                    machinescoretxt.setText("Machine Score: "+ComputerScore);
                    Toast.makeText(Oneonone.this, "Heads and human selected tails but computer selcted heads", Toast.LENGTH_LONG).show();

                }

                // Tails and human selected head and computer selceted heads
                else if(randomvar < 0.5f && humanselecion == 1 && computerselection > 0.5f){
                    coin.setImageResource(R.drawable.indiatwofinal);
                    HumanScore -= 1;
                    ComputerScore -=1;
                    if(HumanScore < 0){
                        HumanScore =0;
                    }
                    if(ComputerScore < 0){
                        ComputerScore=0;
                    }
                    humanscoretxt.setText("Human Score:"+HumanScore);
                    machinescoretxt.setText("Machine Score: "+ComputerScore);
                    Toast.makeText(Oneonone.this, "Ooops!! your point will be  deducted Because its Tails and human selected head and computer selceted heads ", Toast.LENGTH_LONG).show();
             }
                //Taisl and human selected tails computer selected tails
                else if(randomvar < 0.5f && humanselecion == 0 && computerselection < 0.5f){
                    coin.setImageResource(R.drawable.indiatwofinal);
                    HumanScore += 1;
                    ComputerScore +=1;
                    if(HumanScore < 0){
                        HumanScore =0;
                    }
                    if(ComputerScore < 0){
                        ComputerScore=0;
                    }
                    humanscoretxt.setText("Human Score:"+HumanScore);
                    machinescoretxt.setText("Machine Score: "+ComputerScore);
                    Toast.makeText(Oneonone.this, "Tails and human selected tails computer selected tails", Toast.LENGTH_LONG).show();
                }
                //Tails and human selected heads computer selected tails
                else if(randomvar < 0.5f && humanselecion == 1 && computerselection < 0.5f){
                    coin.setImageResource(R.drawable.indiatwofinal);
//                    HumanScore -= 1;
                    ComputerScore +=1;
                    if(HumanScore < 0){
                        HumanScore =0;
                    }
                    if(ComputerScore < 0){
                        ComputerScore=0;
                    }
                    humanscoretxt.setText("Human Score:"+HumanScore);
                    machinescoretxt.setText("Machine Score: "+ComputerScore);
                    Toast.makeText(Oneonone.this, "Tails and human selected heads computer selected tails", Toast.LENGTH_LONG).show();
                }
                //Tails and human selceted tails computer selected heads
                else if(randomvar < 0.5f && humanselecion == 0 && computerselection > 0.5f){
                    coin.setImageResource(R.drawable.indiatwofinal);
                    HumanScore += 1;
//                    ComputerScore -=1;
                    if(HumanScore < 0){
                        HumanScore =0;
                    }
                    if(ComputerScore < 0){
                        ComputerScore=0;
                    }
                    humanscoretxt.setText("Human Score:"+HumanScore);
                    machinescoretxt.setText("Machine Score: "+ComputerScore);
                    Toast.makeText(Oneonone.this, "Tails and human selceted tails computer selected heads", Toast.LENGTH_LONG).show();
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

}


