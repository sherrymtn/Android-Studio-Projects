package com.ching.radiobuttons;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button ok;
    TextView result;
    ImageView image;
    RadioGroup radioGroup;
    RadioButton apple;
    RadioButton guava;
    RadioButton mango;
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok = findViewById(R.id.buttonOK);
        result = findViewById(R.id.textView);
        image = findViewById(R.id.imageSample);

        radioGroup = findViewById(R.id.rgroup);
        apple = findViewById(R.id.apple);
        guava = findViewById(R.id.guava);
        mango = findViewById(R.id.mango);

        linear = findViewById(R.id.linear);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (apple.isChecked()) 
                {
                    linear.setBackgroundColor(Color.RED);
                } 
                else if (guava.isChecked()) 
                {
                    linear.setBackgroundColor(Color.GREEN);
                } else if (mango.isChecked())
                {
                    linear.setBackgroundColor(Color.YELLOW);
                }


            }
        });

        
        
        
        
        
        
        
    }
}