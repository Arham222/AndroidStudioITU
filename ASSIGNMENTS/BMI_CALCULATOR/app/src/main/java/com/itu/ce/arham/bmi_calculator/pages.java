package com.itu.ce.arham.bmi_calculator;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class pages extends Activity{
    Button metric;
    Button imperial;

    TextView Inches;
    TextView Pounds;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_page);

        metric = findViewById(R.id.btn_metric);
        imperial = findViewById(R.id.btn_imperial);
        Inches = findViewById(R.id.textcenti);
        Pounds = findViewById(R.id.textkilo);
//        txtcen = findViewById(R.id.textcenti);




        metric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("SYSTEM", "METRIC");
                editor.apply();

                Intent intent = new Intent(pages.this,MainActivity.class);
                startActivity(intent);
            }
        });

        imperial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("SYSTEM", "IMPERIAL");
                editor.apply();

                Intent intent = new Intent(pages.this,MainActivity.class);

//                setContentView(R.layout.activity_main);
//                Inches.setText("Inches");
//                Pounds.setText("Pounds");
                startActivity(intent);


            }
        });

    }
}
