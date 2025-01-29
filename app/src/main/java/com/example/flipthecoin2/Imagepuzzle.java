package com.example.flipthecoin2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Imagepuzzle extends AppCompatActivity implements Runnable, View.OnTouchListener {
    PuzzleLayout puzzleLayout;
    TextView tvTips;
    ImageView ivTips;
//  Button next;
    int squareRootNum = 2;
    int drawableId = R.mipmap.pic_02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagepuzzle);
        ivTips = (ImageView) findViewById(R.id.iv_tips);
        ivTips.setImageResource(drawableId);
        tvTips = (TextView) findViewById(R.id.tv_tips);
//      next = findViewById(R.id.next);
        tvTips.setOnTouchListener(this);
        puzzleLayout = (PuzzleLayout) findViewById(R.id.activity_swipe_card);
        puzzleLayout.setImage(drawableId, squareRootNum);
        puzzleLayout.setOnCompleteCallback(new PuzzleLayout.OnCompleteCallback() {
            @Override
            public void onComplete() {
                Toast.makeText(Imagepuzzle.this, R.string.next, Toast.LENGTH_LONG).show();
                puzzleLayout.postDelayed(Imagepuzzle.this, 800);
            }
        });
//        next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                squareRootNum++;
//                drawableId++;
//                if (squareRootNum > 11) {
//                    Toast.makeText(Imagepuzzle.this, R.string.complete, Toast.LENGTH_SHORT).show();
//                    showDialog();
//                } else {
//                    ivTips.setImageResource(drawableId);
//                    puzzleLayout.setImage(drawableId, squareRootNum);
//                }
//            }
//        });
    }

    @Override
    public void run() {
        squareRootNum++;
        drawableId++;
        if (squareRootNum > 9) {
            Toast.makeText(Imagepuzzle.this, R.string.complete, Toast.LENGTH_SHORT).show();
            showDialog();
        } else {
            ivTips.setImageResource(drawableId);
            puzzleLayout.setImage(drawableId, squareRootNum);
        }
    }

    private void showDialog() {
        new AlertDialog.Builder(Imagepuzzle.this)
                .setTitle(R.string.success)
                .setMessage(R.string.restart)
                .setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                squareRootNum = 2;
                                drawableId = R.mipmap.pic_02;
                                ivTips.setImageResource(drawableId);
                                puzzleLayout.setImage(drawableId, squareRootNum);
                            }
                        }).setNegativeButton(R.string.exit,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ivTips.setVisibility(View.VISIBLE);
                break;
            default:
                ivTips.setVisibility(View.GONE);
        }
        return true;
    }
}