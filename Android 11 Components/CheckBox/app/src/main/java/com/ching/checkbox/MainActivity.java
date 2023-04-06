package com.ching.checkbox;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

    Button ok;
    TextView result;
    ImageView image;
    CheckBox male;
    CheckBox female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok = findViewById(R.id.buttonOK);
        result = findViewById(R.id.textView);
        image = findViewById(R.id.imageSample);

        male = findViewById(R.id.checkBoxMale);
        female = findViewById(R.id.checkBoxFemale);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (male.isChecked())
                {
                    result.setText("Male");
                    female.setChecked(false);
                }
                else
                {
                    result.setText("What is your gender?");
                }
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (female.isChecked())
                {
                    result.setText("Female");
                    male.setChecked(false);
                }
                else
                {
                    result.setText("What is your gender?");
                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
    }
}