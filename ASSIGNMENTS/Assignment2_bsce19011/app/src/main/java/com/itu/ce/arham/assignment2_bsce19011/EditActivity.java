package com.itu.ce.arham.assignment2_bsce19011;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.Set;


public class EditActivity extends AppCompatActivity {

    private String noteText;
    private File noteFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newedit);

        Intent intent = getIntent();
        noteText = intent.getStringExtra("noteText");

        EditText et = findViewById(R.id.editTextTextMultiLine2);
        et.setText(noteText);

        String fileName = intent.getStringExtra("fileName"); // retrieve file name extra
        Log.d("EditActivity", "Note file path: " + getFilesDir() + "/" + fileName);

        noteFile = new File(getFilesDir(), fileName);
        Log.d("NoteFile", noteFile.getAbsolutePath());


        Button back = findViewById(R.id.btn_back);
        Button deleteBtn = findViewById(R.id.btn_delete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean deleted = noteFile.delete();
                if (deleted) {
                    Toast.makeText(getApplicationContext(), "Note deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Failed to delete note", Toast.LENGTH_LONG).show();
                }
                finish();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
