package com.example.user.spider3;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;

import java.io.IOException;

public class playaudio extends Service {
    private MediaPlayer mp;
    private String musicname;
    public playaudio() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void onCreate()
    {
        super.onCreate();
    }
    public int onStartCommand(Intent intent,int flags,int startId)
    {   musicname=intent.getExtras().getString("musicname");
        if(musicname.equals("galliyan"))
        {mp=MediaPlayer.create(this,R.raw.galliyan);}
        if(musicname.equals("feedthedada"))
        {mp=MediaPlayer.create(this,R.raw.feed);}
        if(musicname.equals("mastmagan"))
        {mp=MediaPlayer.create(this,R.raw.mast);}
        try
        {
            mp.prepare();
        }
        catch (IllegalStateException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        mp.start();
        return super.onStartCommand(intent,flags,startId);
    }
    public void onDestroy()
    {
        mp.release();
        super.onDestroy();
    }
}

