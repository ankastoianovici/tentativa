package com.example.licenta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Alarms extends Fragment {
    private TextView textView;

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_alarms, container, false);
        Bundle bundle = getArguments();
        String comparisonResult = bundle.getString("comparisonResult");

        // Display the comparisonResult in a TextView
        textView = view.findViewById(R.id.result_textview);
        textView.setText(comparisonResult);

        return view;
    }



}