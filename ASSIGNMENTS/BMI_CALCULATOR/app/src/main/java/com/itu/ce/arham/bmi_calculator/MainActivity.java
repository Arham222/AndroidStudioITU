package com.itu.ce.arham.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button sett_btn;
    Button calculate;

    EditText height_text;
    EditText weight_text;

    TextView output_BMI;
    TextView output_weigh;
    double height;
    double weight;
    double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String system = sharedPref.getString("SYSTEM", "");
        if (system.equals("METRIC")) {
            setContentView(R.layout.activity_main);
        } else if (system.equals("IMPERIAL")) {
            setContentView(R.layout.activity_share);
        }
        else if (system.equals("")){
            setContentView(R.layout.activity_main);
        }



        sett_btn = findViewById(R.id.setting_button);
        height_text = findViewById(R.id.editheight);
        weight_text = findViewById(R.id.editweight);
        calculate = findViewById(R.id.button_calculate);
        output_BMI = findViewById(R.id.outputbmi);
        output_weigh = findViewById(R.id.outputweight);
        sett_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,pages.class);
                startActivity(intent);


            }



        });


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightstr = height_text.getText().toString();
                height = Double.parseDouble(heightstr);
//                height = height/100;
                String weightstr = weight_text.getText().toString();
                weight = Double.parseDouble(weightstr);


                if (system.equals("METRIC")) {
                    bmi =  (weight) / Math.pow(height/100, 2);;
                    DecimalFormat df = new DecimalFormat("#.#");
                    bmi = Double.parseDouble(df.format(bmi));


                    output_BMI.setText(Double.toString(bmi));
                    if(bmi <= 18.5){
                        output_weigh.setText("Under Weight");

                    }
                    else if(bmi >= 18.5 && bmi <=24.9){
                        output_weigh.setText("Normal Weight");

                    }
                    else if(bmi >= 25 && bmi <=29.9){
                        output_weigh.setText("Over Weight");
                    }
                    else{
                        output_weigh.setText("Obesity");
                    }
                }
                else {


                    bmi = (weight*703) / Math.pow(height, 2);
                    DecimalFormat df = new DecimalFormat("#.#");
                    bmi = Double.parseDouble(df.format(bmi));


                    output_BMI.setText(Double.toString(bmi));


                    if (bmi <= 18.5) {
                        output_weigh.setText("Under Weight");

                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        output_weigh.setText("Normal Weight");

                    } else if (bmi >= 25 && bmi <= 29.9) {
                        output_weigh.setText("Over Weight");
                    } else {
                        output_weigh.setText("Obesity");
                    }
                }





            }
        });



    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("SYSTEM", "METRIC");
        editor.apply();
    }
}