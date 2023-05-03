package com.example.licenta;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Deploy extends Fragment {


    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_deploy, container, false);

        button = rootView.findViewById(R.id.alarmlist);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//nu merge sa se deschida aici
                Alarms fragment = new Alarms();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


            }
        });
        return rootView;
    }

}