package com.example.user.spider1sttask;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    private static int c = 0;
    private TextView t;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView)findViewById(R.id.t);
        t.setText(String.valueOf(c));


    }

    public void hit(View view) {

        c++;
        t.setText(String.valueOf(c));


    }


}
}

