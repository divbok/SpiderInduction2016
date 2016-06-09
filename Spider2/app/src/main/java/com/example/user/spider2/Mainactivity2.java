package com.example.user.spider2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Mainactivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity2);
        Bundle maindata=getIntent().getExtras();
        String name=maindata.getString("name");
        TextView thanks=(TextView)findViewById(R.id.thanks);
        thanks.setText("Thank you " +name+" ");
        thanks.append("for your response");

    }

    public void back(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }


}
