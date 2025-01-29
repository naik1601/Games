package com.example.flipthecoin2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class stonepaper extends AppCompatActivity {
    TextView tv_score;
    ImageView iv_ComputerChoice1,iv_HumanChoice1;
    Button b_stone1,b_scissor1,b_paper1,reset1;
    int HumanScore,ComputerScore=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stonepaper);
        tv_score=findViewById(R.id.tv_score);
        iv_ComputerChoice1=findViewById(R.id.iv_ComputerChoice);
        iv_HumanChoice1=findViewById(R.id.iv_HumanChoice);
        b_stone1=findViewById(R.id.b_stone);
        b_scissor1=findViewById(R.id.b_scissor);
        b_paper1=findViewById(R.id.b_paper);
        reset1=findViewById(R.id.reset);

        b_stone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice1.setImageResource(R.drawable.stonefinal);
               String message= play_turn("stone");
                Toast.makeText(stonepaper.this,message,Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human:"+Integer.toString(HumanScore)+"Computer:"+Integer.toString(ComputerScore));



            }
        });
        b_scissor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice1.setImageResource(R.drawable.scissorfinal);
                String message=play_turn("scissor");
                Toast.makeText(stonepaper.this,message,Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human:"+Integer.toString(HumanScore)+"Computer:"+Integer.toString(ComputerScore));


            }
        });
        b_paper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice1.setImageResource(R.drawable.paperfinal);
                String message=  play_turn("paper");
                Toast.makeText(stonepaper.this,message,Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human:"+Integer.toString(HumanScore)+"Computer:"+Integer.toString(ComputerScore));


            }
        });
        reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HumanScore=0;
                ComputerScore=0;
                tv_score.setText("score Human:"+Integer.toString(HumanScore)+"Computer:"+Integer.toString(ComputerScore));

            }
        });
    }
    public String play_turn(String player_choice){
        String computer_choice="";
        Random r = new Random();
        int computer_choice_number=r.nextInt(3)+1;
        if(computer_choice_number == 1){
            computer_choice="stone";
        }
        else
            if(computer_choice_number==2){
                computer_choice="scissor";
            }
            else
                if (computer_choice_number==3){
                    computer_choice="paper";
                }
       if (computer_choice=="stone"){
           iv_ComputerChoice1.setImageResource(R.drawable.stonefinal);
       }else
       if (computer_choice=="scissor"){
           iv_ComputerChoice1.setImageResource(R.drawable.scissorfinal);
       }else
       if (computer_choice=="paper"){
           iv_ComputerChoice1.setImageResource(R.drawable.paperfinal);
       }
       if (computer_choice==player_choice){
           return "Draw nobody won!";
       }
       else if(player_choice == "stone" && computer_choice == "scissor"){
               HumanScore++;
               return "Stone crushes scissors you won!";
           }
       else if(player_choice=="stone" && computer_choice=="paper"){
               ComputerScore++;
               return "Paper covers rock computer won!";
           }
       else if(player_choice=="scissor" && computer_choice=="stone")
       {
               ComputerScore++;
               return "Stone crushes scissors computer won!";
           }
       else if(player_choice=="scissor" && computer_choice=="paper")
       {
               HumanScore++;
               return "Scissors cut papers you won!";
           }
           else if(player_choice=="paper" && computer_choice=="stone")
           {
               HumanScore++;
               return "Rock crushes scissors you won!";
           }
           else if(player_choice=="paper"&& computer_choice=="scissor")
           {
               ComputerScore++;
               return "scissors cut paper computer won!";
           }
           else return "Not sure";
    }
}
