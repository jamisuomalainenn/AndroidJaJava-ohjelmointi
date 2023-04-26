package com.example.androidkehitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class TaxiActivity extends AppCompatActivity {
private Button hintaBtn;
private Switch pyhapvSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi);

        // Tässä valitaan kilometrien määrä
        NumberPicker mtkPicker = findViewById(R.id.matkaPicker);
        mtkPicker.setMinValue(0);
        mtkPicker.setMaxValue(150);
        mtkPicker.setValue(0);

        mtkPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
            }
        });
        // Tässä valitaan matkustajien määrä
        NumberPicker mtksPicker = findViewById(R.id.matkustajaPicker);
        mtksPicker.setMinValue(1);
        mtksPicker.setMaxValue(8);
        mtksPicker.setValue(1);

        mtkPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
            }
        });


        hintaBtn = (Button) findViewById(R.id.hintaButton);
        pyhapvSwitch = (Switch) findViewById(R.id.pyhaSwitch);

        hintaBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Tässä lasketaan hinta matkustajien ja kilometrien perusteella, sitten se tulostetaan kun nappia painetaan.
                int matka = mtkPicker.getValue();
                double hinta;

                // Tämä tarkistaa matkustajien määrän
                int matkustajat = mtksPicker.getValue();
                //jos matkustajia on 1-4, hinta on 1.9€/km

                if (matkustajat >= 1 && matkustajat <= 4) {
                    hinta = matka * 1.9;

                //jos taas matkustajia on 5-8, hinta on 2.5€/km
                } else {
                    hinta = matka * 2.5;
                }

                //Tässä tarkistetaan onko pyhaSwitch -kytkin aktiivinen ja lisätään aloitusmaksu sen mukaan.
                if (pyhapvSwitch.isChecked()) {
                    hinta += 7.5;
                } else {
                    hinta += 4.5;
                }

                // Näytetään hinta käyttäjälle
                TextView hintaTextView = findViewById(R.id.hintaText);
                hintaTextView.setText(String.format("%.2f €", hinta));
            }
        });


    }
}