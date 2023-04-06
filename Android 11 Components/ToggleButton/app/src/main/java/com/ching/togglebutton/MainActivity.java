package com.ching.togglebutton;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button ok;
    TextView result;
    ImageView image;
    ToggleButton toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok = findViewById(R.id.buttonOK);
        result = findViewById(R.id.textView);
        image = findViewById(R.id.imageSample);

        toggle = findViewById(R.id.toggleButtonShow);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (toggle.isChecked())
                {
                    image.setVisibility(View.INVISIBLE);
                    result.setText("image is hidden");
                }
                else
                {
                    image.setVisibility(View.VISIBLE);
                    result.setText("image is showed ");
                }
            }
        });
    }
}



