package com.ching.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    private ArrayList<String> countryNameList = new ArrayList<>();
    private ArrayList<String> detailList = new ArrayList<>();
    private ArrayList<Integer> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        countryNameList.add("Philippines");
        countryNameList.add("Indonesia");
        countryNameList.add("Vietnam");
        countryNameList.add("Taiwan");
        countryNameList.add("Malaysia");

        detailList.add("This is the Philippines");
        detailList.add("This is the Indonesia");
        detailList.add("This is the Vietnam");
        detailList.add("This is the Taiwan");
        detailList.add("This is the Malaysia");

        imageList.add(R.drawable.ph);
        imageList.add(R.drawable.indonesia);
        imageList.add(R.drawable.viet);
        imageList.add(R.drawable.taiwan);
        imageList.add(R.drawable.malaysia);

        adapter = new RecyclerAdapter(countryNameList, detailList, imageList, MainActivity.this);
        recyclerView.setAdapter(adapter);

    }
}