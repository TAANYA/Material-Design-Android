package com.example.tanya.material_design1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Frag_check extends Fragment
{
    CheckBox cb1, cb2, cb3, cb4;
    Button btnsbm;
    private StringBuilder result;

    public Frag_check()
    {}

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_frag_check, container, false);

        cb1 = (CheckBox)view.findViewById(R.id.c1);
        cb2 = (CheckBox)view.findViewById(R.id.c2);
        cb3 = (CheckBox)view.findViewById(R.id.c3);
        cb4 = (CheckBox)view.findViewById(R.id.c4);
        btnsbm = (Button)view.findViewById(R.id.button);

        result = new StringBuilder();
        result.append("Selected courses are :");

        btnsbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                if(cb1.isChecked())
                {
                    result.append("\nAndroid");
                }

                if(cb2.isChecked())
                {
                    result.append("\nMachine Learning");
                }

                if(cb3.isChecked())
                {
                    result.append("\nInternet Of Things");
                }

                if(cb4.isChecked())
                {
                    result.append("\nCloud");
                }

                Toast.makeText(getActivity(), result.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
