package com.bivin.sqlitetutorialtest;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayOneActivity extends AppCompatActivity {
    Button first;
    Button last;
    Button next;
    Button previous;
    TextView txtDisplayAll;
    DatabaseHandler dbh=new DatabaseHandler(this);
    Contact cnt;

    int b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_one);
        final ArrayList<Contact>  cnts= dbh.getAllContacts();
        final int a=cnts.size();
        first=findViewById(R.id.btnfirst);
        last=findViewById(R.id.btnlast);
        next=findViewById(R.id.btnnext);
        previous=findViewById(R.id.btnprevious);

        txtDisplayAll=findViewById(R.id.txtdisplayAll);




        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previous.setEnabled(false);
                next.setEnabled(true);
                if(!cnts.isEmpty()){
                    txtDisplayAll.setText(cnts.get(0).getName());
                    b=1;


                }
            }
        });

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previous.setEnabled(true);
                if(!cnts.isEmpty()){
                    txtDisplayAll.setText(cnts.get(a-1).getName());
                    b=a-2;
                    next.setEnabled(false);
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previous.setEnabled(true);

                if (b==a-1){
                    next.setEnabled(false);

                }
               if(b<=a-1){

                   txtDisplayAll.setText(cnts.get(b).getName());
                   b++;
                   Log.d("value of b", String.valueOf(b));
               }
               else {
                   b=0;
               }

            }
        });


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setEnabled(true);
                if(b==0){
                   // b=1;
                    previous.setEnabled(false);

                }
                if(b>=0&&b<=a-1){
                    txtDisplayAll.setText(cnts.get(b).getName());
                    if(b!=0){
                        b--;
                    }
                    else {
                        b=0;
                    }

                }
                else {
                    b=a-1;
                }

            }
        });

    }
}
