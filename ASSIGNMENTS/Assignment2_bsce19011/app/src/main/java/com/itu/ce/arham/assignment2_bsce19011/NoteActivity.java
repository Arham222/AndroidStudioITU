package com.itu.ce.arham.assignment2_bsce19011;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;


public class NoteActivity extends AppCompatActivity {

    EditText editText;
    Button savebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newnote);

        editText = findViewById(R.id.editTextTextMultiLine2);
        savebtn = findViewById(R.id.btn_back);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noteText = editText.getText().toString();

                if (!noteText.isEmpty()) {
                    String fileName = "note_" + System.currentTimeMillis() + ".txt";
                    try {
                        FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                        fos.write(noteText.getBytes());
                        fos.close();
                        Toast.makeText(getApplicationContext(), "Note saved", Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(NoteActivity.this, MainActivity.class);
                        intent.putExtra("fileName", fileName);
                        startActivity(intent);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Note is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}