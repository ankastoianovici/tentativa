package com.example.licenta;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;


public class ConfigureNodeDigital extends DialogFragment {

    private Spinner spinner;
    private FrameLayout frameValue,frameBitwise;
    Button next, cancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_configure_node_digital, container, false);

        spinner = view.findViewById(R.id.set_value);
        frameValue = view.findViewById(R.id.value_frame);
        frameBitwise = view.findViewById(R.id.bitwise_frame);
        next=view.findViewById(R.id.next_button);
        cancel=view.findViewById(R.id.cancel_button);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if (selectedItem.equals("Value")) {
                    frameValue.setVisibility(View.VISIBLE);
                    frameBitwise.setVisibility(View.GONE);
                    // Uncheck the checkbox when "Digital" is selected

                } else if (selectedItem.equals("BITWISE")) {
                    frameValue.setVisibility(View.GONE);
                    frameBitwise.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }

        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fa-l sa mearga mai bine ca nu face deloc ce trebuie
                //getActivity().finish();
                AddAlarmsAnalog newFragment = new AddAlarmsAnalog();
                newFragment.show(getChildFragmentManager(),"start");
            }
        });
        return  view;
    }
}