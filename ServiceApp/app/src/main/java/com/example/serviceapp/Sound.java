package com.example.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class Sound extends Service {
    boolean flag;
    MediaPlayer mp;
    public Sound() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        flag=true;
        int i=0;
        while (flag){
            try{
                mp=MediaPlayer.create(this,R.raw.abyss);
                mp.start();
                Log.i("Service","Timer"+i+", thread number:"+Thread.currentThread().getId());
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flag=false;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}