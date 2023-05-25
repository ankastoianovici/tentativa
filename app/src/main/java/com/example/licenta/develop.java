package com.example.licenta;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class develop extends Fragment {

    Button button,openButton;
    private TextView selectedImageTextView;


    int images[]={R.drawable.curbastanga,R.drawable.curbadreapta,R.drawable.liniepunctata};

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_develop, container, false);


        ImageView imageView = rootView.findViewById(R.id.imageView);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();

        button = rootView.findViewById(R.id.add);
        openButton=rootView.findViewById(R.id.openButton);
        selectedImageTextView = rootView.findViewById(R.id.selectedImageTextView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigureObject newFragment = new ConfigureObject();
                newFragment.show(getChildFragmentManager(), "dff");
            }
        });


        openButton.setOnClickListener(new View.OnClickListener() {
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

                        selectedImageTextView.setText(String.valueOf(selectedImage));
                        dialog.dismiss();
                    }
                });
            }
        });



        return rootView;
    }
}