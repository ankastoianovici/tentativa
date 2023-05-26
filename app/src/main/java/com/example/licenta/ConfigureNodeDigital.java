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
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.Spinner;


public class ConfigureNodeDigital extends DialogFragment {

    private Spinner spinner;
    private FrameLayout frameValue,frameBitwise;
    Button next, cancel;
    CheckBox checkbox0, checkbox1,checkbox2;
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
//----------------------------------------------------------------------------------------------------------------------------
        checkbox0 = view.findViewById(R.id.bit0);
        checkbox1 = view.findViewById(R.id.bit1);
        checkbox2 = view.findViewById(R.id.bit2);

        checkbox0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCheckboxClick(checkbox0);
            }
        });

        checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCheckboxClick(checkbox1);
            }
        });

        checkbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCheckboxClick(checkbox2);
            }
        });
//------------------------------------------------------------------------------
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

    private void handleCheckboxClick(CheckBox clickedCheckbox) {
        if (clickedCheckbox.isChecked()) {
            // Uncheck all checkboxes except the clicked one
            checkbox1.setChecked(clickedCheckbox == checkbox1);
            checkbox2.setChecked(clickedCheckbox == checkbox2);
            checkbox0.setChecked(clickedCheckbox == checkbox0);

            // Disable all checkboxes except the clicked one
            checkbox1.setEnabled(clickedCheckbox == checkbox1);
            checkbox2.setEnabled(clickedCheckbox == checkbox2);
            checkbox0.setEnabled(clickedCheckbox == checkbox0);
        } else {
            // Allow unchecking the clicked checkbox
            clickedCheckbox.setChecked(false);

            // Enable all checkboxes
            checkbox1.setEnabled(true);
            checkbox2.setEnabled(true);
            checkbox0.setEnabled(true);
        }
    }
}