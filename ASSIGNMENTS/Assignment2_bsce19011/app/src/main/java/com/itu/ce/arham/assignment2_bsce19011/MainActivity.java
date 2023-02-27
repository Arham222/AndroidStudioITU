package com.itu.ce.arham.assignment2_bsce19011;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
public class MainActivity extends AppCompatActivity {

    ImageButton btnnotes;
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = findViewById(R.id.linearll);
        btnnotes = findViewById(R.id.notebtn);

        // set click listener for add note button
        btnnotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });

        // load existing notes
        loadNotes();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // reload notes when activity is resumed
        loadNotes();
    }

    private void loadNotes() {
        // clear existing notes from linear layout
        l.removeAllViews();

        // read all note files from internal storage directory
        File[] files = getFilesDir().listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                Log.d("File", file.getAbsolutePath());
                if (file.getName().startsWith("note_")) {
                    try {
                        FileInputStream fis = openFileInput(file.getName());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                        String noteText = reader.readLine();
                        reader.close();
                        fis.close();

                        TextView tv = new TextView(getApplicationContext());
                        tv.setText(noteText);
                        tv.setPadding(50, 50, 50, 50);
                        l.addView(tv);
                        tv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String noteText = ((TextView) view).getText().toString();

                                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                                intent.putExtra("noteText", noteText);
                                intent.putExtra("fileName", file.getName());
                                startActivity(intent);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}