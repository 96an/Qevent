package com.example.qevent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class EventDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);


        Intent intent=getIntent();
        TextView tvT= (TextView) findViewById(R.id.txt_title);
        TextView tvD= (TextView) findViewById(R.id.txt_date);
        TextView tvM= (TextView) findViewById(R.id.txt_month);
        TextView tvB= (TextView) findViewById(R.id.txt_body);
        tvT.setText(intent.getStringExtra("title"));
        tvD.setText(intent.getStringExtra("date" + "month"));
        tvB.setText(intent.getStringExtra("body"));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

}
