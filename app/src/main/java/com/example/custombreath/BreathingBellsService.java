package com.example.custombreath;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

// this class is a pipeline thread for running meditation sequences
// the messages hold BreathSequence instances
// which run bells after delays given by the breath time values (inhale, exhale, holds)
// when the bell/breath sequence completes, another should begin if there is one
// problem is, it needs to wait before continuing...
// we could add a timers that waits the total of the breathsequence values before
// finishing? Or we could run it in a separate thread and sleep this one for
// the total breathsequence values...
// this service should do all it's work in a separate class, a HandlerThread implementation
// that's where the media player should be.

// make this a singleton
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
        // create thread to execute music playing on
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