package com.example.licenta;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/*public class AddAlarmsAnalog extends DialogFragment {

    private ListView listView;
    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_alarms_analog, container, false);

        // Initialize the ListView and ArrayList objects
        listView = view.findViewById(R.id.listview);
        itemList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);


        // Set the click listener for the button
        Button buttonAdd = view.findViewById(R.id.salvare);
        buttonAdd.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                // Get the reference to the EditText control and its contents
                EditText myEditText = view.findViewById(R.id.node_edit_text);
                String editTextValue = myEditText.getText().toString();
                EditText myEditText1 = view.findViewById(R.id.name_alarma_text);
                String editTextValue1 = myEditText.getText().toString();
                // Add a new item to the ArrayList and notify the adapter that the data set has changed
                String itemString = editTextValue + " " + editTextValue1;
                itemList.add(itemString);
                adapter.notifyDataSetChanged();
            }

        });
        return view;
    }
}*/

public class AddAlarmsAnalog extends DialogFragment {

    private ListView listView;
    private ArrayList<String> itemList;
    private List_Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_alarms_analog, container, false);

        // Initialize the ListView and ArrayList objects
        listView = view.findViewById(R.id.listview);
        itemList = new ArrayList<String>();
        adapter = new List_Adapter(getActivity(), itemList);
        listView.setAdapter(adapter);

        // Set the click listener for the button
        Button buttonAdd = view.findViewById(R.id.salvare);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the reference to the EditText control and its contents
                EditText myEditText = view.findViewById(R.id.node_edit_text);
                String editTextValue = myEditText.getText().toString();
                EditText myEditText1 = view.findViewById(R.id.name_alarma_text);
                String editTextValue1 = myEditText1.getText().toString();
                // Add a new item to the ArrayList and notify the adapter that the data set has changed
                String itemString = editTextValue + " " + editTextValue1;
                itemList.add(itemString);
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}