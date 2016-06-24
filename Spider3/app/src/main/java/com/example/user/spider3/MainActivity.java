package com.example.user.spider3;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.net.ContentHandlerFactory;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    public ImageView imgview;
    public Spinner spinner;
    public Button slide;
    public String spinn;
    public TextView timer;
    private SensorManager mSensorManager;
    private Sensor mProximity;
    public Button enablebutton;
    public Button disablebutton;
    public static int j=0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgview = (ImageView) findViewById(R.id.imageview);
        spinner = (Spinner) findViewById(R.id.spin);
        timer=(TextView)findViewById(R.id.timer);
        enablebutton=(Button)findViewById(R.id.enable);
        disablebutton=(Button)findViewById(R.id.disable);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void slideclick(View view) {



        final int[] args = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6};
        final long starttime=SystemClock.uptimeMillis();
        final Handler h = new Handler();

        Runnable r = new Runnable() {
            int i = 0;
            long timeInMilliseconds = 0L;
            long timeSwapBuff = 0L;
            long updatedtime = 0L;
            @Override
            public void run() {
                imgview.setImageResource(args[i]);
                timeInMilliseconds = SystemClock.uptimeMillis() - starttime;
                updatedtime = timeSwapBuff + timeInMilliseconds;
                int secs = (int) (updatedtime / 1000);
                int mins = secs / 60;
                secs = secs % 60;
                int milliseconds = (int) (updatedtime % 1000);
                timer.setText(String.format("%d:%s:%s", mins, String.format("%02d", secs), String.format("%03d", milliseconds)));
                i++;
                if (i > 5) {
                    return;
                }
                h.postDelayed(this,3000);

            }
        };
       h.post(r);


    }


    public void playclick(View view) {
        spinn = String.valueOf(spinner.getSelectedItem());
        Intent i = new Intent(this, playaudio.class);
        i.putExtra("musicname", spinn);
        this.startService(i);

    }

    public void stopclick(View view) {
        Intent i = new Intent(this, playaudio.class);
        this.stopService(i);
    }


    public void enable(View view) {
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);

        enablebutton.setEnabled(false);
        disablebutton.setEnabled(true);
    }


    public void disable(View view) {
        mSensorManager.unregisterListener(this);
        enablebutton.setEnabled(true);
        disablebutton.setEnabled(false);

    }
    public void onSensorChanged(SensorEvent event) {

        int [] args={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6};
        if (event.values[0] == 0 && j<6) {
            imgview.setImageResource(args[j]);
            j++;
        }
        else if(j<6) {
            imgview.setImageResource(args[j]);

        }
        else
        imgview.setImageResource(args[5]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}

