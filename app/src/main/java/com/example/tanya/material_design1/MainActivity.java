package com.example.tanya.material_design1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{
    ListView listView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> list = new ArrayList<>();
        list.add("Radio Button Demo");
        list.add("Check Box Demo");
        list.add("Recycler View Demo");
        list.add("Test Demo");
        list.add("Test test Demo");
        list.add("Test test test Demo");
        list.add("Test test test test Demo");


        listView = (ListView)findViewById(R.id.listview);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.listview_layout,list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(MainActivity.this, "You have clicked " + list.get(i) , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });



    }
}
