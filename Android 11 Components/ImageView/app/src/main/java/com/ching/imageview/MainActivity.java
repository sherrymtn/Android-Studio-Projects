package com.ching.imageview;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

    EditText name;
    Button ok;
    TextView result;
    String username;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        ok = findViewById(R.id.buttonOK);
        result = findViewById(R.id.textView);
        image = findViewById(R.id.imageSample);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                image.setImageResource(R.drawable.java);


            }
        });
    }
}