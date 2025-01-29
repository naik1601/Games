package com.example.flipthecoin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Wheeltheme extends AppCompatActivity {
    ImageView wheel2,wheel3,wheel4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheeltheme);
        wheel2=findViewById(R.id.wheelfinal2);
        wheel3=findViewById(R.id.wheelfinal3);
        wheel4=findViewById(R.id.wheelfinal4);

        wheel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openwheel2();
            }
        });

        wheel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openwheel3();
            }
        });

        wheel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openwheel4();
            }
        });
    }

    public void openwheel2(){
        Intent intent= new Intent(this,whelloffortune2.class);
        startActivity(intent);
    }
    public void openwheel3(){
        Intent intent= new Intent(this,wheeloffortune3.class);
        startActivity(intent);
    }
    public void openwheel4(){
        Intent intent= new Intent(this,wheeloffortune4.class);
        startActivity(intent);
    }
}