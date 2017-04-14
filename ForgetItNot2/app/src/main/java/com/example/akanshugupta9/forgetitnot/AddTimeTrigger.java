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
import android.widget.TextView;
import android.widget.TimePicker;

import static android.R.id.button1;
import static android.R.id.message;

/**
 * Created by akanshugupta9 on 13/4/17.
 */

public class AddTimeTrigger extends Activity {
    EditText hoursEt, minEt;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_trigger_activity);

        hoursEt=(EditText)findViewById(R.id.hours);
        minEt=(EditText)findViewById(R.id.minutes);
        button1=(Button)findViewById(R.id.add_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String hour=hoursEt.getText().toString();
                String min=minEt.getText().toString();
                String message=""+hour+min;
                Intent intent=new Intent();
                intent.putExtra("MESSAGE",message);
                intent.putExtra("HOUR",hour);
                intent.putExtra("MIN",min);
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
