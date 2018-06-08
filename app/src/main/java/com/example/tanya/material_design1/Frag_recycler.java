package com.example.tanya.material_design1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Frag_recycler extends Fragment implements Update_list
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<List_recycler> listItems;
    ImageView imageView;
    ArrayList<Superheroes> superheroes = new ArrayList<>();


    String[] heads = {"Superman","Batman","Spiderman","Wonderwoman","Ironman","Captain America","Cyborg","Thor","Hulk","Aquaman","Dr. Strange"};
    String[] descs = {"DC","DC","Marvel","DC","Marvel","Marvel","DC","Marvel","Marvel","DC","Marvel"};
    String[] urls = {"https://i.redd.it/pam6h9kglowy.jpg","https://i.ytimg.com/vi/SmFt46MElm4/maxresdefault.jpg"};

    public Frag_recycler()
    { }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        superheroes = new ArrayList<>();
     Superheroes s;

        for(int i=0; i<heads.length; i++)
        {
            s = new Superheroes(heads[i],descs[i] ,(descs[i].equalsIgnoreCase("DC")?urls[0]:urls[1]));

            superheroes.add(s);
        }
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

        adapter = new Adapter_recycler(superheroes , getActivity(),this);
        recyclerView.setAdapter(adapter);

            return view;
    }

    @Override
    public void updateList(String head, String desc)
    {
        Log.i("Testtt", "updateList: " + head + " " +desc);
        Superheroes heroes = new Superheroes(head,desc,(desc.equalsIgnoreCase("DC")?urls[0]:urls[1]));
        superheroes.add(heroes);
        adapter.notifyDataSetChanged();
    }
}
