package com.ching.project1guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private TextView textViewLast, textViewRight, textViewHint;
    private Button buttonConfirm;
    private EditText editTextGuess;

    boolean twoDigits, threeDigits, fourDigits;
    Random r = new Random();
    int random;
    int remainingRight = 10;

    ArrayList<Integer> guessList = new ArrayList<>();
    int userAttempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textViewHint = findViewById(R.id.textViewHint);
        textViewRight = findViewById(R.id.textViewRight);
        textViewLast = findViewById(R.id.textViewLast);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        editTextGuess = findViewById(R.id.editTextGuess);

        twoDigits = getIntent().getBooleanExtra("two", false);
        threeDigits = getIntent().getBooleanExtra("three", false);
        fourDigits = getIntent().getBooleanExtra("four", false);

        if (twoDigits)
        {
            random = r.nextInt(90) + 10;
        }
        if (threeDigits)
        {
            random = r.nextInt(900) + 100;
        }
        if (fourDigits)
        {
            random = r.nextInt(9000) + 1000;
        }

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = editTextGuess.getText().toString();
                if (guess.equals(""))
                {
                    Toast.makeText(GameActivity.this, "Please enter a guess",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    textViewLast.setVisibility(View.VISIBLE);
                    textViewRight.setVisibility(View.VISIBLE);
                    textViewHint.setVisibility(View.VISIBLE);

                    userAttempts++;
                    remainingRight--;

                    int userGuess = Integer.parseInt(guess);
                    guessList.add(userGuess);

                    textViewLast.setText("Last guess number: " + guess);
                    textViewRight.setText("Remaining guess: " + remainingRight);

                    if (userGuess == random)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                        builder.setTitle("Guess the Number Game");
                        builder.setCancelable(false);
                        builder.setMessage("CONGRATULATIONS. The Guess Number was " + random
                                + "\n\n You took " + userAttempts
                                + " to guess it right. \n\n Your guesses: " + guessList
                                + "\n\n Would you like to play again?");

                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });

                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        });

                        builder.create().show();


                    }
                    if (userGuess > random)
                    {
                        textViewHint.setText("Decrease the number");
                    }
                    else
                    {
                        textViewHint.setText("Increase the number");
                    }


                    if (remainingRight == 0)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                        builder.setTitle("Guess the Number Game");
                        builder.setCancelable(false);
                        builder.setMessage("SORRY, no more guesses remaining. The Guess Number was " + random
                                + "\n\n You took " + userAttempts
                                + ". \n\n Your guesses: " + guessList
                                + "\n\n Would you like to play again?");

                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });

                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        });

                        builder.create().show();
                    }

                    editTextGuess.setText("");



                }
            }
        });





    }
}