package com.example.user.spider2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

                public void onClick(View view)
                {
                    EditText name=(EditText)findViewById(R.id.name);
                    EditText roll=(EditText)findViewById(R.id.roll);
                    CheckBox a=(CheckBox)findViewById(R.id.tronix);
                    CheckBox b=(CheckBox)findViewById(R.id.algos);
                    CheckBox c=(CheckBox)findViewById(R.id.webdev);
                    CheckBox d=(CheckBox)findViewById(R.id.appdev);
                    String na,ro;
                    na=name.getText().toString();
                    ro=roll.getText().toString();
                    if(na.matches(""))
                    {
                        Toast.makeText(this,"Name is not filled",Toast.LENGTH_SHORT).show();

                }
                     else if(ro.matches(""))
                     {
                         Toast.makeText(this,"Roll is not filled",Toast.LENGTH_SHORT).show();
                     }
                    else if(a.isChecked()==false&&b.isChecked()==false&&c.isChecked()==false&&d.isChecked()==false)
                    {
                        Toast.makeText(this,"You didn't fill any choices",Toast.LENGTH_SHORT).show();
                }
                    else
                    {
                        Intent intent=new Intent(this,Mainactivity2.class);
                        intent.putExtra("name",na);
                        startActivity(intent);
                    }


    }


}
