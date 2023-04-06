package com.ching.listandviews;


import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button ok;
    TextView result;
    ImageView image;
    LinearLayout linear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok = findViewById(R.id.buttonOK);
        result = findViewById(R.id.textView);
        image = findViewById(R.id.imageSample);
        linear = findViewById(R.id.Constrait);


    }
}


