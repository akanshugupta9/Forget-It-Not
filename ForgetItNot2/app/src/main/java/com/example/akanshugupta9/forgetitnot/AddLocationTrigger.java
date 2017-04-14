package com.example.akanshugupta9.forgetitnot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.message;

/**
 * Created by akanshugupta9 on 13/4/17.
 */

public class AddLocationTrigger extends Activity {
    EditText longEt, latEt, radEt;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_trigger_activity);

        longEt=(EditText)findViewById(R.id.longitude);
        latEt=(EditText)findViewById(R.id.latitude);
        radEt=(EditText)findViewById(R.id.radius);
        button1=(Button)findViewById(R.id.add_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String longi=longEt.getText().toString();
                String lati=latEt.getText().toString();
                String rad=radEt.getText().toString();
                String message=longi+lati+rad;
                Intent intent=new Intent();
                intent.putExtra("MESSAGE",message);
                intent.putExtra("LONG",longi);
                intent.putExtra("LAT",lati);
                intent.putExtra("RAD",rad);
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
