package com.example.custombreath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button breathActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        breathActivityButton = findViewById(R.id.breath_activity_button);

        // TODO: create intent, start service to play bell audio at intervals
        breathActivityButton.setOnClickListener(view -> {

        });
    }
}