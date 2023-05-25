package com.example.licenta;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ConfigureObject  extends DialogFragment {
    private Spinner spinner;
    private FrameLayout frameDigital,frameAnalog;
    ImageView on_button,off_button, alarm_button,symbol_button, alarm_button1;
    Button cancel,next;



    int images[]={R.drawable.analizorclor,R.drawable.bazinempty,R.drawable.bazinful,
            R.drawable.bazinhalf,R.drawable.boil1,R.drawable.boiler,R.drawable.button1_off,
            R.drawable.button1_off_p,R.drawable.analizorclor,R.drawable.bazinempty,R.drawable.bazinful,
            R.drawable.bazinhalf,R.drawable.boil1,R.drawable.boiler,R.drawable.button1_off,
            R.drawable.button1_off_p,R.drawable.analizorclor,R.drawable.bazinempty,R.drawable.bazinful,
            R.drawable.bazinhalf,R.drawable.boil1,R.drawable.boiler,R.drawable.button1_off,
            R.drawable.button1_off_p,R.drawable.analizorclor,R.drawable.bazinempty,R.drawable.bazinful,
            R.drawable.bazinhalf,R.drawable.boil1,R.drawable.boiler,R.drawable.button1_off,
            R.drawable.button1_off_p,R.drawable.analizorclor,R.drawable.bazinempty,R.drawable.bazinful,
            R.drawable.bazinhalf,R.drawable.boil1,R.drawable.boiler,R.drawable.button1_off,
            R.drawable.button1_off_p};


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_configure_object, container, false);
        //read variables
        spinner = view.findViewById(R.id.node_type_spinner);
        frameDigital = view.findViewById(R.id.digital_frame);
        frameAnalog = view.findViewById(R.id.analog_frame);
        on_button=view.findViewById(R.id.on_button);
        off_button=view.findViewById(R.id.off_button);
        alarm_button=view.findViewById(R.id.alarm_button);
        symbol_button=view.findViewById(R.id.symbol_button);
        alarm_button1=view.findViewById(R.id.alarm_button_analog);
        cancel=view.findViewById(R.id.cancel_button);
        next=view.findViewById(R.id.next_button);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if (selectedItem.equals("Digital")) {
                    frameDigital.setVisibility(View.VISIBLE);
                    frameAnalog.setVisibility(View.GONE);
                    // Uncheck the checkbox when "Digital" is selected

                } else if (selectedItem.equals("Analog")) {
                    frameDigital.setVisibility(View.GONE);
                    frameAnalog.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
        on_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = LayoutInflater.from(getContext()).inflate(R.layout.player, null);
                GridView gridView = view.findViewById(R.id.gridView1);
                CustomAdapter adapter=new CustomAdapter(getActivity(), images);
                gridView.setAdapter(adapter);
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int selectedImage = images[position];
                        //button.setBackgroundResource(selectedImage);
                        on_button.setImageResource(selectedImage);
                        dialog.dismiss();
                    }
                });
            }
        });
        off_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = LayoutInflater.from(getContext()).inflate(R.layout.player, null);
                GridView gridView = view.findViewById(R.id.gridView1);
                CustomAdapter adapter=new CustomAdapter(getActivity(), images);
                gridView.setAdapter(adapter);
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int selectedImage = images[position];
                        //button.setBackgroundResource(selectedImage);
                        off_button.setImageResource(selectedImage);
                        dialog.dismiss();
                    }
                });
            }
        });
        alarm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = LayoutInflater.from(getContext()).inflate(R.layout.player, null);
                GridView gridView = view.findViewById(R.id.gridView1);
                CustomAdapter adapter=new CustomAdapter(getActivity(), images);
                gridView.setAdapter(adapter);
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int selectedImage = images[position];
                        //button.setBackgroundResource(selectedImage);
                        alarm_button.setImageResource(selectedImage);
                        dialog.dismiss();
                    }
                });
            }
        });
        symbol_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = LayoutInflater.from(getContext()).inflate(R.layout.player, null);
                GridView gridView = view.findViewById(R.id.gridView1);
                CustomAdapter adapter=new CustomAdapter(getActivity(), images);
                gridView.setAdapter(adapter);
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int selectedImage = images[position];
                        //button.setBackgroundResource(selectedImage);
                        symbol_button.setImageResource(selectedImage);
                        dialog.dismiss();
                    }
                });
            }
        });
        alarm_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = LayoutInflater.from(getContext()).inflate(R.layout.player, null);
                GridView gridView = view.findViewById(R.id.gridView1);
                CustomAdapter adapter=new CustomAdapter(getActivity(), images);
                gridView.setAdapter(adapter);
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int selectedImage = images[position];
                        //button.setBackgroundResource(selectedImage);
                        alarm_button1.setImageResource(selectedImage);
                        dialog.dismiss();
                    }
                });
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
                String mode = spinner.getSelectedItem().toString(); // get the selected mode from the spinner
                if(mode.equals("Analog")) {
                    ConfigureNodeAnalog newFragment = new ConfigureNodeAnalog();
                    newFragment.show(getChildFragmentManager(), "start");
                } else if(mode.equals("Digital")) {
                    ConfigureNodeDigital newFragment = new ConfigureNodeDigital();
                    newFragment.show(getChildFragmentManager(), "start");
                }
            }
        });


        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().setCanceledOnTouchOutside(false);
    }

    public void dismissDialog() {
        dismiss();
    }

}