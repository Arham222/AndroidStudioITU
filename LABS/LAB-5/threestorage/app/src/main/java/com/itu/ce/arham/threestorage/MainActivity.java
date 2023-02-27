package com.itu.ce.arham.threestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {

    char [] a;
    String h = new String("Data Written Successfully");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = new char[20480 * 1024];
        for (int i = 0; i < a.length; i++) {
            a[i] = 'b';
        }
        String data = new String(a);

        Button internal, external, cache;

        internal = findViewById(R.id.btninternal);
        external = findViewById(R.id.btnexternal);
        cache = findViewById(R.id.btncache);

        external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                    File myphoto = new File(dir, "myselfie.txt");
                    FileWriter fm = new FileWriter(myphoto);
                    fm.write(h);
                    fm.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });






        cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File dir = getCacheDir();
                    File f = new File(dir, "mycachefile.txt");
                    FileWriter fm = new FileWriter(f);
                    for (int i = 0; i < 5; i++)
                        fm.write(data);
                    fm.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });




        internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            File dir = getFilesDir();
                            File InternalFile = new File(dir, "myinternalfile.txt");
                            FileWriter fn = new FileWriter(InternalFile);
                            for (int i = 0; i < 10; i++)
                                fn.write(data);
                            fn.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                });
                t.start();
//                    File dir = getFilesDir();
//                    File InternalFile = new File(dir, "myinternalfile.txt");
//                    FileWriter fn = new FileWriter(InternalFile);
//                    for(int i=0;i<10;i++)
//                        fn.write(data);
//                    fn.close();
            }


        });
    }

    }