package com.bivin.sqlitetutorialtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListAllDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_details);

        DatabaseHandler dbs=new DatabaseHandler(getApplicationContext());

        ArrayList<Contact> Cnts=dbs.getAllContacts();

        ListAdapter ls=new ListAdapter(this,Cnts);
        ListView listView=findViewById(R.id.listview);
        listView.setAdapter(ls);

    }
}
