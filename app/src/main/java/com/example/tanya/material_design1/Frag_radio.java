package com.example.tanya.material_design1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Frag_radio extends Fragment
{
    RadioGroup radioGroup;
    RadioButton radioButton;

    public Frag_radio() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.fragment_frag_radio, container, false);

        radioGroup = (RadioGroup)view.findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                radioButton = (RadioButton)view.findViewById(i);
                String res = radioButton.getText().toString();

                Toast.makeText(getActivity(),res, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
