package com.itu.ce.arham.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText et;
    SharedPreferences pref;
    Button mg;

    @Override
    protected void onResume() {
        super.onResume();
        et = findViewById(R.id.editTextTextPersonName);

        Log.d("***********", "****ON RESUME CALLED");//print the log in the log

        try {
            FileInputStream fin = openFileInput("merilocalfile.txt");//INPUT the file which we use to store
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));//buffer read read the code from input
            String txt = br.readLine();//this is the readline to read every line from the file
            et.setText(txt);
        } catch (Exception e) {//catch exception handling
            e.printStackTrace();
        }
        ////////////////////////////////////////////////////////////////////////////////
//        SharedPreferences pref = getSharedPreferences("myowndata", MODE_PRIVATE);
//        String txt = pref.getString("mydata", "nahi mila");
//        et.setText(txt);
        //////////////////////////////////////////////////////////////////////////////////
    }

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///////////////////////////////////////////////////////////
//        et = findViewById(R.id.editTextTextPersonName);
        ////////////////////////////////////////////////////////////
        mg = findViewById(R.id.reset);//for button read by id from xml
        ///////////////////////////////////////////////////////////////
//        pref = getSharedPreferences("myowndata", MODE_PRIVATE);
//        String txt = pref.getString("mydata", "nahi mila");
//        et.setText(txt);
        ////////////////////////////////////////////////////////////////

        mg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                et=findViewById(R.id.editTextTextPersonName);
                et.setText("");//set the text empty
            }
        });


//        try {
//            InputStream in = getResources().openRawResource(R.raw.mydata);
//            BufferedReader br = new BufferedReader(new InputStreamReader(in));
//            String str = br.readLine();
//            Log.d("********","data from the file is read Chutti kroo");
//
//        }
//        catch(Exception e){
//            e.printStackTrace();
//
//        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        /////////////////////////////////////////////////////////////////////////////
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putString("mydata", et.getText().toString());
//        editor.commit();
//        Log.d("***********", "****ON PAUSE CALLED");
//        //////////////////////////////////////////////////////////////////////////
        try {
            FileOutputStream fos = openFileOutput("merilocalfile.txt", MODE_PRIVATE);//output file store in this
            fos.write("Sir please mere se asan viva liya kre".toString().getBytes());//get byte byte file from output
            fos.close();//close the file
        }
        catch(Exception e)//exception handling
        {
            e.printStackTrace();
        }

    }
}