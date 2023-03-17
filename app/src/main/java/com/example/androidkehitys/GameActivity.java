package com.example.androidkehitys;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private ImageButton button;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;

    Random rand = new Random();
    int randomNr = rand.nextInt(4);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        diamondGame();

    }

    protected void diamondGame() {
        ImageButton button = (ImageButton) findViewById(R.id.imageView3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (randomNr == 0) {
                    button.setImageResource(R.drawable.star);
                }
                else {
                    button.setImageResource(R.drawable.ranta);
                }

                Log.d("BUTTONS", "User tapped the animation");
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roundanimation);
                button.startAnimation(hyperspaceJumpAnimation);
            }
        });
        ImageButton button2 = (ImageButton) findViewById(R.id.imageView4);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (randomNr == 1) {
                    button2.setImageResource(R.drawable.star);
                }
                else {
                    button2.setImageResource(R.drawable.ranta);
                }
                Log.d("BUTTONS", "User tapped the animation");
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roundanimation);
                button2.startAnimation(hyperspaceJumpAnimation);
            }
        });
        ImageButton button3 = (ImageButton) findViewById(R.id.imageView5);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (randomNr == 2) {
                    button3.setImageResource(R.drawable.star);
                }
                else {
                    button3.setImageResource(R.drawable.ranta);
                }
                Log.d("BUTTONS", "User tapped the animation");
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roundanimation);
                button3.startAnimation(hyperspaceJumpAnimation);
            }
        });
        ImageButton button4 = (ImageButton) findViewById(R.id.imageView6);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (randomNr == 3) {
                    button4.setImageResource(R.drawable.star);
                }
                else {
                    button4.setImageResource(R.drawable.ranta);
                }
                Log.d("BUTTONS", "User tapped the animation");
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roundanimation);
                button4.startAnimation(hyperspaceJumpAnimation);
            }
        });
    }
}