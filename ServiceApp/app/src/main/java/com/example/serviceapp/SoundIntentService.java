package com.example.serviceapp;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class SoundIntentService extends IntentService {
MediaPlayer mp;
Boolean flag;
    public SoundIntentService() {
        super("SoundIntentService");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flag=false;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            flag=true;
            int i=0;
            while (flag) {
                try {
                    mp = MediaPlayer.create(this, R.raw.abyss);
                    mp.start();
                    Log.i("Service", "Timer" + i + ", thread number:" + Thread.currentThread().getId());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}