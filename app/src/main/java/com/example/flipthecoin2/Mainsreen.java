package com.example.flipthecoin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Mainsreen extends AppCompatActivity {
    TextView fliptitle,stonetitle,wheeltitle,puzzletitle;
    ImageView flipmainimage,stonemainimage,whelloffortuneimage,puzzleimage;
    Animation topAnim1,bottomAnim2,bottomAnim3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsreen);

        fliptitle=findViewById(R.id.title1);
        stonetitle=findViewById(R.id.title2);
        wheeltitle=findViewById(R.id.title4);
        puzzletitle=findViewById(R.id.title5);

        flipmainimage=findViewById(R.id.flipimageView2);
        stonemainimage=findViewById(R.id.stonepaperimageView3);
        whelloffortuneimage=findViewById(R.id.wheeloffortune);
        puzzleimage=findViewById(R.id.puzzle);
        topAnim1= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim2=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        bottomAnim3=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        flipmainimage.setAnimation(topAnim1);
        stonemainimage.setAnimation(bottomAnim2);
        whelloffortuneimage.setAnimation(bottomAnim3);
        puzzleimage.setAnimation(bottomAnim3);


        fliptitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        stonetitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStonepaperScissor();
            }
        });

        wheeltitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfortune();
            }
        });

        puzzletitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPuzzleActivity();
            }
        });

        flipmainimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();

            }

        });
        stonemainimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStonepaperScissor();

            }

        });
        whelloffortuneimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfortune();

            }

        });
        puzzleimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPuzzleActivity();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.feedback,menu);
        return true;

    }
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){

            case R.id.feedbackmainscreen:
                Toast.makeText(this, "Feedback is selected", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(this,Feedback.class);
                startActivity(intent1);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void openMainActivity (){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);

    }
    public void openStonepaperScissor  () {
        Intent intent = new Intent(this, stonepaper.class);
        startActivity(intent);
    }
    public void  openfortune  () {
        Intent intent = new Intent(this, whelloffortune.class);
        startActivity(intent);
    }
    public void  openPuzzleActivity  () {
        Intent intent = new Intent(this, mainImagepuzzlescreen.class);
        startActivity(intent);
    }

}
