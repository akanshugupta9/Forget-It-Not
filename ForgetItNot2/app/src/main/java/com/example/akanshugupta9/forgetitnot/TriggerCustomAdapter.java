package com.example.akanshugupta9.forgetitnot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import static com.example.akanshugupta9.forgetitnot.MainActivity.events;

/**
 * Created by akanshugupta9 on 14/4/17.
 */

public class TriggerCustomAdapter extends BaseAdapter {
    Context context;
    Trigger[] triggers;
    private static LayoutInflater inflater=null;
    public TriggerCustomAdapter(TriggersActivity triggersActivity, Trigger[] triggers) {
        // TODO Auto-generated constructor stub
        this.triggers=triggers;
        context=triggersActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return triggers.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView sn;
        TextView type, textView1, textView2, textView3;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.trigger_list, null);
        holder.sn=(TextView) rowView.findViewById(R.id.sr_no);
        holder.type=(TextView) rowView.findViewById(R.id.type);
        holder.textView1=(TextView) rowView.findViewById(R.id.textView1);
        holder.textView2=(TextView) rowView.findViewById(R.id.textView2);
        holder.textView3=(TextView) rowView.findViewById(R.id.textView3);
        holder.sn.setText(Integer.toString(triggers[position].srNo));
        holder.type.setText(Integer.toString(triggers[position].type));
        if(triggers[position].type==0){
            holder.textView1.setText(Double.toString(triggers[position].longitude));
            holder.textView2.setText(Double.toString(triggers[position].latitude));
            holder.textView3.setText(Integer.toString(triggers[position].radius));
        }else if(triggers[position].type==1){
            holder.textView1.setText(Integer.toString(triggers[position].hour1));
            holder.textView2.setText(Integer.toString(triggers[position].min1));
            holder.textView3.setText(triggers[position].days);
        }else if(triggers[position].type==2){
            holder.textView1.setText(""+triggers[position].hour1+triggers[position].min1);
            holder.textView2.setText(""+triggers[position].hour2+triggers[position].min2);
            holder.textView3.setText(triggers[position].days);
        }
        /*rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(context,TriggersActivity.class);
                intent.putExtra("SR_NO", holder.sn.getText());
                context.startActivity(intent);
            }
        });*/
        return rowView;
    }

}