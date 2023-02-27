package com.itu.ce.arham.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView tvTemp;
    TextView humidity;
    TextView flt;
    TextView maxTemp;
    TextView minTemp;
    TextView visibility;
    TextView windspeed;
    TextView winddirection;
    TextView sunrisetime;
    TextView sunsettime;


    double temperature;
    double feellike;
    double temp_min;
    double temp_max;
    double humidityss;
    double winds;
    double sun_rise_time;
    double sun_set_time;

    double vbide;
    double wind_directui;
    EditText txtcity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button weather;
        weather = findViewById(R.id.btnweather);
        tvTemp = findViewById(R.id.txtcurrenttemp);
        humidity = findViewById(R.id.txthumidity);
        flt = findViewById(R.id.txtflt);
        maxTemp = findViewById(R.id.txtmaxtemp);
        minTemp = findViewById(R.id.textmintemp);
        visibility = findViewById(R.id.textvisibility);
        windspeed = findViewById(R.id.textwindspeed);
        winddirection = findViewById(R.id.txtwinddirect);
        sunrisetime = findViewById(R.id.textsunrise);
        sunsettime = findViewById(R.id.textsunset);
        txtcity = findViewById(R.id.txtcity);
        weather.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String mycity = txtcity.getText().toString();


                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        char[] data = new char[5000];
                        try {
                            URL u = new URL("https://api.openweathermap.org/data/2.5/weather?q="+mycity+"&appid=ecbec2699a44fe043635a4ccbbdb4ed1");
                            InputStream i =u.openStream();
                            BufferedReader b =new BufferedReader(new InputStreamReader(i));
                            int count = b.read(data);
                            String response = new String(data,0,count);
                            Log.d("*********","********"+response);

                            JSONObject j = new JSONObject(response);
                            JSONObject main = j.getJSONObject("main");
                            JSONObject hour = j.getJSONObject("wind");
                            JSONObject sysd = j.getJSONObject("sys");
//                            JSONObject dfg = j.getJSONObject("response");
//                            JSONObject vb = j.getJSONObject("visibility");

                            temperature = main.getDouble("temp");
                            feellike = main.getDouble("feels_like");
                            humidityss = main.getDouble("humidity");
                            temp_max = main.getDouble("temp_max");
                            temp_min = main.getDouble("temp_min");
                            winds = hour.getDouble("speed");
                            sun_rise_time = sysd.getDouble("sunrise");
                            sun_set_time = sysd.getDouble("sunset");
                            vbide = j.getDouble("visibility");
                            wind_directui = j.getDouble("dt");


                            temperature = temperature - 273.15;
                            feellike = feellike - 273.15;
                            temp_max = temp_max - 273.15;
                            temp_min = temp_min - 273.15;

                            feellike = Double.parseDouble(new DecimalFormat("##.####").format(feellike));
                            temp_max = Double.parseDouble(new DecimalFormat("##.####").format(temp_max));
                            temp_min = Double.parseDouble(new DecimalFormat("##.####").format(temp_min));
                            temperature = Double.parseDouble(new DecimalFormat("##.####").format(temperature));
                            sun_rise_time = Double.parseDouble(new DecimalFormat("##.####").format(sun_rise_time));
                            sun_set_time = Double.parseDouble(new DecimalFormat("##.####").format(sun_set_time));
                            wind_directui = Double.parseDouble(new DecimalFormat("##.####").format(wind_directui));

                            Log.d("********","*******TEMPERATURE = "+temperature);
                            //tvTemp.setText(""+temperature);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvTemp.setText(""+temperature);







//                                    visibility.setText(""+vbide);
//
                                }
                            });
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    humidity.setText(""+humidityss);
                                }
                            });
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    flt.setText(""+feellike);
                                }
                            });
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    maxTemp.setText(""+temp_max);
                                }
                            });
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    minTemp.setText(""+temp_min);
                                }
                            });
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    windspeed.setText(""+winds);
                                }
                            });
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    sunrisetime.setText(""+sun_rise_time);
                                }
                            });
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    sunsettime.setText(""+sun_set_time);
                                }
                            });
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    winddirection.setText(""+wind_directui);
                                }
                            });
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    visibility.setText(""+vbide);
                                }
                            });

                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }

                    }
                };
                Thread t = new Thread(r);
                t.start();








            }
        });


    }
}