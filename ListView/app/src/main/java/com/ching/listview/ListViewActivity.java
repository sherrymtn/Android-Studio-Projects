package com.ching.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    String countryList[];
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.viewList);
        countryList = getResources().getStringArray(R.array.countries);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countryList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String countryName = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "You selected " + countryName, Toast.LENGTH_SHORT).show();
            }
        });




    }
}