package com.bivin.sqlitetutorialtest;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bivin on 2/25/2018.
 */

public class ListAdapter extends ArrayAdapter<Contact> {
    public ListAdapter(@NonNull Context context, ArrayList<Contact> contacts) {
        super(context,0,contacts);
    }
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Contact cont=getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listdetails, parent, false);

            TextView textViewTitle = (TextView) convertView.findViewById(R.id.id);
            TextView textViewDate = (TextView) convertView.findViewById(R.id.name);
            TextView textViewLocation = (TextView) convertView.findViewById(R.id.phonenum);

            textViewTitle.setText(""+cont.getId());
            textViewDate.setText(cont.getName());
            textViewLocation.setText(cont.getPhonenumber());
        }
        return  convertView;
    }

}
