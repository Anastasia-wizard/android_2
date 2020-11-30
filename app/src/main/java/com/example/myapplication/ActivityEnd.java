package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.myapplication.R.id.resultDesk;

public class ActivityEnd extends AppCompatActivity {
    private TextView resultDesk;
    private String ResultString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        //ResultString = getIntent().getStringExtra("answer");
        resultDesk = findViewById(R.id.resultDesk);


    }

    public TextView getResultDesk() {
        Intent intent = new Intent(ActivityEnd.this, MainActivity.class);
        intent.getStringArrayListExtra("finish");
        startActivity(intent);
        return resultDesk;
    }
}
