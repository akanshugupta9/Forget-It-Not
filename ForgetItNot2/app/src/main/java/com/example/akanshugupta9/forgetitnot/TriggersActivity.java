package com.example.akanshugupta9.forgetitnot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.data;
import static android.R.id.button1;
import static android.R.id.message;
import static com.example.akanshugupta9.forgetitnot.MainActivity.events;

/**
 * Created by akanshugupta9 on 13/4/17.
 */

public class TriggersActivity extends Activity {

    TextView srNoTv;
    ListView lv;
    String srNoS;
    DBHelper mydb;
    public static Trigger[] triggers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triggers_activity);

        srNoS=getIntent().getStringExtra("SR_NO");
        mydb = new DBHelper(this);

        triggers=mydb.getTriggers(srNoS);

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new TriggerCustomAdapter(this, triggers));

        srNoTv=(TextView)findViewById(R.id.sr_no);
        srNoTv.setText(srNoS);
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
            String hour=data.getStringExtra("HOUR");
            String min=data.getStringExtra("MIN");
            String message=data.getStringExtra("MESSAGE");
            if(!message.equals("")){
                if(mydb.insertTimeTrigger(srNoS, hour, min)){
                    Toast.makeText(this, "Trigger inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Trigger failed", Toast.LENGTH_SHORT).show();
                }
            }
        }else if(requestCode==2){
            String hour1=data.getStringExtra("HOUR1");
            String min1=data.getStringExtra("MIN1");
            String hour2=data.getStringExtra("HOUR2");
            String min2=data.getStringExtra("MIN2");
            String message=data.getStringExtra("MESSAGE");
            if(!message.equals("")){
                if(mydb.insertTimeRangeTrigger(srNoS, hour1, min1, hour2, min2)){
                    Toast.makeText(this, "Trigger inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Trigger failed", Toast.LENGTH_SHORT).show();
                }
            }
        }else if(requestCode==3){
            String longi=data.getStringExtra("LONG");
            String lati=data.getStringExtra("LAT");
            String rad=data.getStringExtra("RAD");
            String message=data.getStringExtra("MESSAGE");
            if(!message.equals("")){
                if(mydb.insertLocationTrigger(srNoS, longi, lati, rad)){
                    Toast.makeText(this, "Trigger inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Trigger failed", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
