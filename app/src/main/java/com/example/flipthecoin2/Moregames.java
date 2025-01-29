package com.example.flipthecoin2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class Moregames extends AppCompatActivity {

    GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moregames);

        gridView=findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(this));
    }
}
