package com.example.akanshugupta9.forgetitnot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by akanshugupta9 on 13/4/17.
 */

public class EventCustormAdapter extends BaseAdapter {
    Context context;
    Event[] events;
    private static LayoutInflater inflater=null;
    public EventCustormAdapter(MainActivity mainActivity, Event[] events) {
        // TODO Auto-generated constructor stub
        this.events=events;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return events.length;
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
        TextView title;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.event_list, null);
        holder.sn=(TextView) rowView.findViewById(R.id.sr_no);
        holder.title=(TextView) rowView.findViewById(R.id.title);
        holder.sn.setText(Integer.toString(events[position].srNo));
        holder.title.setText(events[position].title);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(context,TriggersActivity.class);
                intent.putExtra("SR_NO", holder.sn.getText());
                context.startActivity(intent);
            }
        });
        return rowView;
    }

}