package com.example.licenta;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ConfigureNodeAnalog extends DialogFragment {
    Button next,cancel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_configure_node_analog, container, false);

        next=view.findViewById(R.id.next_button);
        cancel=view.findViewById(R.id.cancel_button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fa-l sa mearga mai bine ca nu face deloc ce trebuie
                //getActivity().finish();
                AddAlarmsAnalog newFragment = new AddAlarmsAnalog();
                newFragment.show(getChildFragmentManager(),"start");
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }

        });
        return view;
    }
}