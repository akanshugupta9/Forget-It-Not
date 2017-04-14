package com.example.akanshugupta9.forgetitnot;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import static android.R.id.button1;

/**
 * Created by akanshugupta9 on 13/4/17.
 */

public class AddTimeRangeTrigger extends Activity {

    EditText hoursEt1, minEt1, hoursEt2, minEt2;
    Button button1;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_range_trigger_activity);

        hoursEt1=(EditText)findViewById(R.id.hours1);
        minEt1=(EditText)findViewById(R.id.minutes1);
        hoursEt2=(EditText)findViewById(R.id.hours2);
        minEt2=(EditText)findViewById(R.id.minutes2);
        button1=(Button)findViewById(R.id.add_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String hour1=hoursEt1.getText().toString();
                String min1=minEt1.getText().toString();
                String hour2=hoursEt2.getText().toString();
                String min2=minEt2.getText().toString();
                String message=""+hour1+min1+hour2+min2;
                Intent intent=new Intent();
                intent.putExtra("MESSAGE",message);
                intent.putExtra("HOUR1",hour1);
                intent.putExtra("MIN1",min1);
                intent.putExtra("HOUR2",hour2);
                intent.putExtra("MIN2",min2);
                setResult(2,intent);
                finish();//finishing activity
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("MESSAGE","");
        setResult(2,intent);
        finish();//finishing activity
        super.onBackPressed();
    }

}