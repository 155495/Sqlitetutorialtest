package com.bivin.sqlitetutorialtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name,phonenum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn=findViewById(R.id.button);
        Button add=findViewById(R.id.btnsubmit);
        Button btnviewSingle=findViewById(R.id.btnviewSingle);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        name=(EditText) findViewById(R.id.name);
        phonenum=(EditText) findViewById(R.id.phone);
        final String[] n = new String[1];
        final String[] p = new String[1];


        final DatabaseHandler databaseHandler=new DatabaseHandler(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n[0] =name.getText().toString();
                p[0] =phonenum.getText().toString();
                if(n[0].equals("")&& p[0].equals("")){
                    Log.d("Error: ", "in if statement ..");
                    Toast.makeText(getApplicationContext(),"Please fill All Fields",Toast.LENGTH_SHORT).show();
                }
                else{

                    Log.d("Insert: ", "Inserting ..");
                    databaseHandler.addContact(new Contact(n[0], p[0]));
                    Toast.makeText(getApplicationContext(),"Successfully Added",Toast.LENGTH_SHORT).show();
                    name.setText("");
                    phonenum.setText("");
                }

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ListAllDetailsActivity.class);
                startActivity(intent);
            }
        });

        /*DatabaseHandler databaseHandler=new DatabaseHandler(this);
        Log.d("Insert: ", "Inserting ..");
        databaseHandler.addContact(new Contact("Ravi", "9100000000"));
        databaseHandler.addContact(new Contact("Srinivas", "9199999999"));
        databaseHandler.addContact(new Contact("Tommy", "9522222222"));
        databaseHandler.addContact(new Contact("Karthik", "9533333333"));*/



       /* Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = databaseHandler.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: "+cn.getId()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhonenumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
*/

       btnviewSingle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getApplicationContext(),DisplayOneActivity.class);
               startActivity(intent);
           }
       });
    }
}
