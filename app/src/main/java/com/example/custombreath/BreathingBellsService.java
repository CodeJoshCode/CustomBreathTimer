package com.example.custombreath;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class BreathingBellsService extends Service {
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public BreathingBellsService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.synthetic_bell_sound);
        mediaPlayer.setLooping(true); // Set looping
        mediaPlayer.setVolume(100, 100);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        // breath sequence values
        float inhale = intent.getFloatExtra("inhale", 4);
        float inhale_hold = intent.getFloatExtra("inhale", 4);
        float exhale = intent.getFloatExtra("inhale", 4);
        float exhale_hold = intent.getFloatExtra("inhale", 4);

        // play bell sound
        mediaPlayer.start();

        return startId;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }
    @Override
    public void onLowMemory() {
    }


}