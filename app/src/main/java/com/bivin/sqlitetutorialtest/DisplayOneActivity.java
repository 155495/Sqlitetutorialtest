package com.bivin.sqlitetutorialtest;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayOneActivity extends AppCompatActivity {
Button first;
TextView txtDisplayAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_one);

        first=findViewById(R.id.btnfirst);
        txtDisplayAll=findViewById(R.id.txtdisplayAll);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
