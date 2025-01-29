package com.example.flipthecoin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainImagepuzzlescreen extends AppCompatActivity {
    Button puzzleplay,checklevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_imagepuzzlescreen);

        puzzleplay=findViewById(R.id.Imageplay);
        checklevel=findViewById(R.id.Levels);

        puzzleplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagepuzzle();
            }
        });
        checklevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlevel();
            }
        });


    }

    public void openImagepuzzle(){
        Intent intent= new Intent(this,Imagepuzzle.class);
        startActivity(intent);
    }
    public void openlevel(){
        Intent intent= new Intent(this,Moregames.class);
        startActivity(intent);
    }
}