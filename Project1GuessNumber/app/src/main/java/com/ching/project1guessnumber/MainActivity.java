package com.ching.project1guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private RadioButton rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.startbutton);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);

                if (!rb2.isChecked() && !rb3.isChecked() && !rb4.isChecked()) {
                    Snackbar.make(view, "Please select the number of digits first!",
                            Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    if (rb2.isChecked()) {
                        intent.putExtra("two", true);
                    }
                    if (rb3.isChecked()) {
                        intent.putExtra("three", true);
                    }
                    if (rb4.isChecked()) {
                        intent.putExtra("four", true);
                    }

                    startActivity(intent);
                }
            }
        });
    }
}