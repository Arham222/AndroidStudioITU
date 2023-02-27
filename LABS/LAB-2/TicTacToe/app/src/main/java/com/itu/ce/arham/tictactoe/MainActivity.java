package com.itu.ce.arham.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button b,b2,b3,b4,b5,b6,b7,b8,b9,reset;
    boolean active = true;
    boolean turn = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b =  (Button) findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);
        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);
        b9 = (Button)findViewById(R.id.button9);
        reset = (Button)findViewById(R.id.button10);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.setText("_");
                b2.setText("_");
                b3.setText("_");
                b4.setText("_");
                b5.setText("_");
                b6.setText("_");
                b7.setText("_");
                b8.setText("_");
                b9.setText("_");
//                getResult();
                active = true;


                }



        });

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(active) {
                        b.setText("X");
                        getResult();
                        active = !active;
                    }
                    else {
                        b.setText("0");
                        getResult();
                        active = !active;
                    }
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (active) {
                        b2.setText("X");
                        getResult();
                        active = !active;
                    }
                    else {
                        b2.setText("0");
                        getResult();
                        active = !active;
                    }
                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (active) {
                        b3.setText("X");
                        getResult();
                        active = !active;
                    }

                    else

                {
                    b3.setText("0");
                    getResult();
                    active = !active;
                }
            }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(active) {
                        b4.setText("X");
                        getResult();
                        active = !active;
                    }
                    else{
                        b4.setText("0");
                        getResult();
                        active = !active;
                    }

                }
            });
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (active) {
                        b5.setText("X");
                        getResult();
                        active = !active;
                    } else {
                        b4.setText("0");
                        getResult();
                        active = !active;
                    }
                }
            });
            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(active) {
                        b6.setText("X");
                        getResult();
                        active = !active;
                    }
                    else{
                        b6.setText("0");
                        getResult();
                        active = !active;
                    }
                }
            });
            b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(active) {
                        b7.setText("X");
                        getResult();
                        active = !active;
                    }
                    else{
                        b7.setText("0");
                        getResult();
                        active = !active;
                    }
                }
            });
            b8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(active) {
                        b8.setText("X");
                        getResult();
                        active = !active;
                    }
                    else{
                        b8.setText("0");
                        getResult();
                        active = !active;
                    }
                }
            });
            b9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(active) {
                        b9.setText("X");
                        getResult();
                        active = !active;
                    }
                    else{
                        b9.setText("0");
                        getResult();
                        active = !active;
                    }
                }
            });
        }
        void getResult() {
            if (b.getText() == "X" && b2.getText() == "X" && b3.getText() == "X"){
                Toast.makeText(this, "Player 1 win", Toast.LENGTH_SHORT).show();



            } else if (b.getText() == "X" && b4.getText() == "X" && b7.getText() == "X") {
                Toast.makeText(this, "Player 1 win", Toast.LENGTH_SHORT).show();

            } else if (b.getText() == "X" && b5.getText() == "X" && b9.getText() == "X"){
                Toast.makeText(this, "Player 1 win", Toast.LENGTH_SHORT).show();

            }

            else if (b2.getText() == "X" && b5.getText() == "X" && b8.getText() == "X"){
                Toast.makeText(this, "Player 1 win", Toast.LENGTH_SHORT).show();

            }
            else if (b3.getText() == "X" && b6.getText() == "X" && b9.getText() == "X"){
                Toast.makeText(this, "Player 1 win", Toast.LENGTH_SHORT).show();

            }
            else if (b3.getText() == "X" && b5.getText() == "X" && b7.getText() == "X"){
                Toast.makeText(this, "Player 1 win", Toast.LENGTH_SHORT).show();

            }
            else if (b4.getText() == "X" && b5.getText() == "X" && b6.getText() == "X"){
                Toast.makeText(this, "Player 1 win", Toast.LENGTH_SHORT).show();

            }
            else if (b7.getText() == "X" && b8.getText() == "X" && b9.getText() == "X"){
                Toast.makeText(this, "Player 1 win", Toast.LENGTH_SHORT).show();

            }
//            else if(b.getText() != "_" && b2.getText() != "_" && b3.getText() != "_" && b4.getText() != "_" && b5.getText() != "_" && b6.getText() != "_" && b7.getText() != "_" && b8.getText() != "_" && b8.getText() != "_" ){
//                Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
//            }

            ////////////////////////////////////////////////////////////////////////////

            if (b.getText() == "0" && b2.getText() == "0" && b3.getText() == "0"){
                Toast.makeText(this, "Player 2 win", Toast.LENGTH_SHORT).show();



            } else if (b.getText() == "0" && b4.getText() == "0" && b7.getText() == "0") {
                Toast.makeText(this, "Player 2 win", Toast.LENGTH_SHORT).show();

            } else if (b.getText() == "0" && b5.getText() == "0" && b9.getText() == "0"){
                Toast.makeText(this, "Player 2 win", Toast.LENGTH_SHORT).show();

            }

            else if (b2.getText() == "0" && b5.getText() == "0" && b8.getText() == "0"){
                Toast.makeText(this, "Player 2 win", Toast.LENGTH_SHORT).show();

            }
            else if (b3.getText() == "0" && b6.getText() == "0" && b9.getText() == "0"){
                Toast.makeText(this, "Player 2 win", Toast.LENGTH_SHORT).show();

            }
            else if (b3.getText() == "0" && b5.getText() == "0" && b7.getText() == "0"){
                Toast.makeText(this, "Player 2 win", Toast.LENGTH_SHORT).show();

            }
            else if (b4.getText() == "0" && b5.getText() == "0" && b6.getText() == "0"){
                Toast.makeText(this, "Player 2 win", Toast.LENGTH_SHORT).show();

            }
            else if (b7.getText() == "0" && b8.getText() == "0" && b9.getText() == "0"){
                Toast.makeText(this, "Player 2 win", Toast.LENGTH_SHORT).show();

            }
            else if(!b.getText().equals("_") && !b2.getText().equals("_") && !b3.getText().equals("_") && !b4.getText().equals("_") && !b5.getText().equals("_") && !b6.getText().equals("_") && !b7.getText().equals("_") && !b8.getText().equals("_") && !b9.getText().equals("_")){
                Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
            }
        }

















    }
