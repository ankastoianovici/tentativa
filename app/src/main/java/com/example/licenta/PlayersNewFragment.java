package com.example.licenta;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class PlayersNewFragment extends DialogFragment {
    private AlertDialog alertDialog;

        private Spinner spinner;
        private FrameLayout frameDigital;
        private FrameLayout frameAnalog;
        private FrameLayout frame_alarma;
        private FrameLayout frame_alarma1;
        private CheckBox myCheckbox,myCheckbox1;
        Button button;

        @SuppressLint("MissingInflatedId")
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.new_alert_dialog, container, false);

            spinner = view.findViewById(R.id.tip_nod_spinner);
            frameDigital = view.findViewById(R.id.frame_digital);
            frameAnalog = view.findViewById(R.id.frame_analog);
            frame_alarma = view.findViewById(R.id.frame_alarma);
            frame_alarma1 = view.findViewById(R.id.frame_alarma1);
            myCheckbox = view.findViewById(R.id.checkBox);
            myCheckbox1 = view.findViewById(R.id.checkBox1);
            button=view.findViewById(R.id.button4);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selectedItem = parent.getItemAtPosition(position).toString();
                    if (selectedItem.equals("Digital")) {

                        frameDigital.setVisibility(View.VISIBLE);
                        frameAnalog.setVisibility(View.GONE);

                        myCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {
                                    frame_alarma.setVisibility(View.VISIBLE);
                                }
                                else {
                                    frame_alarma.setVisibility(View.GONE);

                                }

                            }
                        });


                    } else if (selectedItem.equals("Analog")) {

                        frameDigital.setVisibility(View.GONE);
                        frameAnalog.setVisibility(View.VISIBLE);

                        myCheckbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {
                                    frame_alarma1.setVisibility(View.VISIBLE);

                                }
                                else {
                                    frame_alarma1.setVisibility(View.GONE);
                                }

                            }
                        });


                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // Do nothing
                    View view = inflater.inflate(R.layout.new_alert_dialog, container, false);
                    frame_alarma1.setVisibility(View.GONE);
                    frame_alarma.setVisibility(View.GONE);
                }
            });


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Button clicked", Toast.LENGTH_SHORT).show();
                    Players newFragment = new Players();
                    newFragment.show(getChildFragmentManager(), "dff");
                }
            });
            return view;
        }

}