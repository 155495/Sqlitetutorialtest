package com.bivin.sqlitetutorialtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ListAllDetailsActivity.class);
                startActivity(intent);
            }
        });

        DatabaseHandler databaseHandler=new DatabaseHandler(this);
        Log.d("Insert: ", "Inserting ..");
        databaseHandler.addContact(new Contact("Ravi", "9100000000"));
        databaseHandler.addContact(new Contact("Srinivas", "9199999999"));
        databaseHandler.addContact(new Contact("Tommy", "9522222222"));
        databaseHandler.addContact(new Contact("Karthik", "9533333333"));



        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = databaseHandler.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: "+cn.getId()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhonenumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }


    }
}
