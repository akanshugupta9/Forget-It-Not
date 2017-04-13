package com.example.akanshugupta9.forgetitnot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.data;
import static android.R.id.button1;
import static android.R.id.message;

/**
 * Created by akanshugupta9 on 13/4/17.
 */

public class TriggersActivity extends Activity {

    TextView srNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triggers_activity);

        srNo=(TextView)findViewById(R.id.sr_no);
        srNo.setText(getIntent().getStringExtra("SR_NO"));
    }

    public void timeTrigger(View v){
        Intent intent=new Intent(TriggersActivity.this,AddTimeTrigger.class);
        startActivityForResult(intent, 1);
    }

    public void timeRangeTrigger(View v){
        Intent intent=new Intent(TriggersActivity.this,AddTimeRangeTrigger.class);
        startActivityForResult(intent, 2);
    }

    public void locationTrigger(View v){
        Intent intent=new Intent(TriggersActivity.this,AddLocationTrigger.class);
        startActivityForResult(intent, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==1)
        {
            String message=data.getStringExtra("MESSAGE");
            Toast.makeText(this, "1 "+message, Toast.LENGTH_SHORT).show();
        }else if(requestCode==2){
            String message=data.getStringExtra("MESSAGE");
            Toast.makeText(this, "2 "+message, Toast.LENGTH_SHORT).show();
        }else if(requestCode==3){
            String message=data.getStringExtra("MESSAGE");
            Toast.makeText(this, "3 "+message, Toast.LENGTH_SHORT).show();
        }
    }

}
