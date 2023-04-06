package com.ching.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<String> text = new ArrayList<>();
    ArrayList<Integer> image = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView= findViewById((R.id.gridView));
        fillArray();
        GridAdapter adapter = new GridAdapter(this, text, image);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "That's a " + text.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fillArray()
    {
        text.add("Cheetah");
        text.add("Dolphin");
        text.add("Eagle");
        text.add("Fox");
        text.add("Giraffe");
        text.add("Goat");
        text.add("Hemingway");
        text.add("Lion");
        text.add("Troupe");
        text.add("Pig");
        text.add("Turtle");


        image.add(R.drawable.cheetah);
        image.add(R.drawable.dolphin);
        image.add(R.drawable.eagle);
        image.add(R.drawable.fox);
        image.add(R.drawable.giraffe);
        image.add(R.drawable.goat);
        image.add(R.drawable.hemingway);
        image.add(R.drawable.lion);
        image.add(R.drawable.mix);
        image.add(R.drawable.pig);
        image.add(R.drawable.turtle);









    }
}