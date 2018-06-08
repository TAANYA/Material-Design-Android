package com.example.tanya.material_design1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Frag_recycler extends Fragment
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<List_recycler> listItems;
    ImageView imageView;

    String[] urls = {"https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg","https://images.pexels.com/photos/87452/flowers-background-butterflies-beautiful-87452.jpeg"};

    public Frag_recycler()
    { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_recycler, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItems = new ArrayList<>();

        for(int i = 0; i <=10; i++)
        {
             List_recycler listItem = new List_recycler("heading" + (i+1), "dummy text is displayed",urls[i%2]);

             listItems.add(listItem);

        }

        adapter = new Adapter_recycler(listItems , getActivity());
        recyclerView.setAdapter(adapter);


            return view;
    }
}
