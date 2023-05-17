package com.example.licenta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Alarms extends Fragment {
    private TextView textView;
//-----------------------------------------------------------------
   /* private List<String> dataList = new ArrayList<>();

    // Method to add data to the list
    public void addDataToList(String data) {
        dataList.add(data);
    }*/
    //-----------------------------------------------------------------------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_alarms, container, false);






        return view;
    }



}