package com.example.androidkehitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public static final String TAG ="MainActivity";
    private Button testBtn;
    private TextView helloText;
    private Button playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Button button = (Button) findViewById(R.id.button);
        helloText = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (helloText.getVisibility() == View.VISIBLE) {
                    helloText.setVisibility(View.INVISIBLE);
                } else {
                    helloText.setVisibility(View.VISIBLE);
                }


            }

        });
        playBtn = (Button) findViewById(R.id.game_button);
        playBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "Play game button clicked");


                Intent i = new Intent(MainActivity.this, GameActivity.class);
                startActivity(i);
            }
        });

    }



    private void init() {
        Log.i(TAG, "Tämä on lokitekstiä!!!");
    }
}
