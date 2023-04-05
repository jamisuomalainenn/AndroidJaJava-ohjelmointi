package com.example.androidkehitys;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private ImageView button;
    private ImageView button2;
    private ImageView button3;
    private ImageView button4;

    Random rand = new Random();
    int randomNr = rand.nextInt(4);

    private TextView textView;
    private TextView voitto;
    private Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textView = findViewById(R.id.textView5);
        voitto = findViewById(R.id.victory); {
            voitto.setVisibility(View.INVISIBLE);
        }
        playAgain = findViewById(R.id.retry);
        diamondGame();

    }

    protected void diamondGame() {
        ImageButton button = (ImageButton) findViewById(R.id.imageView3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (randomNr == 0) {
                    button.setImageResource(R.drawable.star);
                    //button2.setVisibility(View.INVISIBLE);
                    //button3.setVisibility(View.INVISIBLE);
                    //button4.setVisibility(View.INVISIBLE);
                    voitto.setVisibility(View.VISIBLE);
                }
                else {
                    button.setVisibility(View.INVISIBLE);
                }

                Log.d("BUTTONS", "User tapped the animation");
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roundanimation);
                button.startAnimation(hyperspaceJumpAnimation);
                int currentValue = Integer.parseInt(textView.getText().toString());
                int newValue = currentValue + 1;
                textView.setText(Integer.toString(newValue));
                if (currentValue == 4) {
                    finish();
                }

            }
        });
        ImageButton button2 = (ImageButton) findViewById(R.id.imageView4);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (randomNr == 1) {
                    button2.setImageResource(R.drawable.star);
                    //button.setVisibility(View.INVISIBLE);
                    //button3.setVisibility(View.INVISIBLE);
                    //button4.setVisibility(View.INVISIBLE);
                    voitto.setVisibility(View.VISIBLE);
                }
                else {
                    button2.setVisibility(View.INVISIBLE);
                }
                Log.d("BUTTONS", "User tapped the animation");
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roundanimation);
                button2.startAnimation(hyperspaceJumpAnimation);

                int currentValue = Integer.parseInt(textView.getText().toString());
                int newValue = currentValue + 1;
                textView.setText(Integer.toString(newValue));
                if (currentValue == 4) {
                    finish();
                }
            }
        });
        ImageButton button3 = (ImageButton) findViewById(R.id.imageView5);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (randomNr == 2) {
                    button3.setImageResource(R.drawable.star);
                    //button2.setVisibility(View.INVISIBLE);
                    //button.setVisibility(View.INVISIBLE);
                    //button4.setVisibility(View.INVISIBLE);
                    voitto.setVisibility(View.VISIBLE);
                }
                else {
                    button3.setVisibility(View.INVISIBLE);
                }
                Log.d("BUTTONS", "User tapped the animation");
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roundanimation);
                button3.startAnimation(hyperspaceJumpAnimation);
                int currentValue = Integer.parseInt(textView.getText().toString());
                int newValue = currentValue + 1;
                textView.setText(Integer.toString(newValue));
                if (currentValue == 4) {
                    finish();
                }
            }
        });
        ImageButton button4 = (ImageButton) findViewById(R.id.imageView6);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (randomNr == 3) {
                    button4.setImageResource(R.drawable.star);
                    //button2.setVisibility(View.INVISIBLE);
                    //button3.setVisibility(View.INVISIBLE);
                    //button.setVisibility(View.INVISIBLE);
                    voitto.setVisibility(View.VISIBLE);
                }
                else {
                    button4.setVisibility(View.INVISIBLE);
                }
                Log.d("BUTTONS", "User tapped the animation");
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roundanimation);
                button4.startAnimation(hyperspaceJumpAnimation);
                int currentValue = Integer.parseInt(textView.getText().toString());
                int newValue = currentValue + 1;
                textView.setText(Integer.toString(newValue));
                if (currentValue == 4) {
                    finish();
                }
            }
        });

    }
}