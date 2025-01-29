package com.example.flipthecoin2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button,button2,button3; MediaPlayer player;
    Animation topAnim1,bottomAnim2,bottomAnim3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       topAnim1= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim2=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
       // button.setAnimation(topAnim1);
        //button2.setAnimation(bottomAnim2);
        button=(Button) findViewById(R.id.button);
        topAnim1= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        button.setAnimation(topAnim1);
        button2=(Button) findViewById(R.id.button2);
        bottomAnim2=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        button2.setAnimation(bottomAnim2);

                button3=(Button) findViewById(R.id.button3);
        bottomAnim3=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        button3.setAnimation(bottomAnim3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,changeimagesource.class));
            }
        });

       // button2.setOnClickListener(new View.OnClickListener() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openFlipActivity();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMoregames();
            }
        });
        MediaPlayer player=MediaPlayer.create(this,R.raw.game);
        player.setLooping(true);
        player.start();
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.activity_main_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.ChangeCoin:
                Toast.makeText(this, "ChangeCoin is selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.EnglandCoin:
                Toast.makeText(this, "England COin is selected", Toast.LENGTH_SHORT).show();
                Intent intent4=new Intent(this,Flip.class);
                startActivity(intent4);
                return true;
            case R.id.AmericanCoin:
                Toast.makeText(this, "AmericanCoin is selected", Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(this,flip2.class);
                startActivity(intent2);
                return true;
            case R.id.AustralianCoin:
                Toast.makeText(this, "AustralianCoin is selected", Toast.LENGTH_SHORT).show();
                Intent intent3=new Intent(this,flip3.class);
                startActivity(intent3);
                return true;
//            case R.id.Help:
//                Toast.makeText(this, "Help is selected", Toast.LENGTH_SHORT).show();
//                Intent intent7=new Intent(this,Mainsreen.class);
//                startActivity(intent7);
//                return true;
//            case R.id.FeedBack:
//                Toast.makeText(this, "Feedback is selected", Toast.LENGTH_SHORT).show();
//                Intent intent1=new Intent(this,Feedback.class);
//                startActivity(intent1);
//                return true;
//            case R.id.Logout:
//                Toast.makeText(this, "Logout is selected", Toast.LENGTH_SHORT).show();

            //case R.id.subitem1:
               // Toast.makeText(this, "SubItem 1 is selected", Toast.LENGTH_SHORT).show();
           // case R.id.subitem2:
               // Toast.makeText(this, "SubItem 2 is selected", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
    public void openFlipActivity(){
        Intent intent= new Intent(this,Flip1.class);
        startActivity(intent);
        MediaPlayer player=MediaPlayer.create(this,R.raw.click1);
        player.setLooping(true);
        player.start();
    }

    public void openMoregames(){
        Intent intent= new Intent(this,Oneonone.class);
        startActivity(intent);

    }


}
