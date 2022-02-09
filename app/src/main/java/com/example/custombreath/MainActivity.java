package com.example.custombreath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    // button to start the breathing activity
    private Button breathActivityButton;
    // breath sequence sliders
    private Slider inhaleSlider;
    private Slider inhaleHoldSlider;
    private Slider exhaleSlider;
    private Slider exhaleHoldSlider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        breathActivityButton = findViewById(R.id.breath_activity_button);
        inhaleSlider = findViewById(R.id.inhale_slider);
        inhaleHoldSlider = findViewById(R.id.inhale_hold_slider);
        exhaleSlider = findViewById(R.id.exhale_slider);
        exhaleHoldSlider = findViewById(R.id.exhale_hold_slider);
        Intent breathingIntent = new Intent(getApplicationContext(), BreathingBellsService.class);
        startService(breathingIntent);

        // TODO: create intent, start service to play bell audio at intervals
        // Todo: add animation to button press
        // actually for now lets just start the service for breathing here on this activity
        // actually, we need to run this on our pipeline thread
        breathActivityButton.setOnClickListener(view -> {
            // add values from sliders to intent
            Intent breathSequenceIntent = new Intent(getApplicationContext(), BreathingBellsService.class);
            // TODO: change this to add BreathActivity instead of all values individually
            // these always have values within bounds set in the xml
            breathSequenceIntent.putExtra("inhale", inhaleSlider.getValue());
            breathSequenceIntent.putExtra("inhale_hold", inhaleHoldSlider.getValue());
            breathSequenceIntent.putExtra("exhale", exhaleSlider.getValue());
            breathSequenceIntent.putExtra("exhale_hold", exhaleHoldSlider.getValue());

            // should launching an service be try catch
            //
        });
    }
}