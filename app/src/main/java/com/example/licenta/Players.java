package com.example.licenta;

import static com.example.licenta.R.id.button4;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Arrays;

public class Players extends DialogFragment {


    GridView gv;
    Button button;
    ImageView imageView;
    String[] names={"Analizor clor", "Bazin empty","Bazin ful","Bazin half", "Boil 1","Boiler","Button1 off", "Button1 off p",
            "Analizor clor", "Bazin empty","Bazin ful","Bazin half", "Boil 1","Boiler","Button1 off", "Button1 off p",
            "Analizor clor", "Bazin empty","Bazin ful","Bazin half", "Boil 1","Boiler","Button1 off", "Button1 off p",
            "Analizor clor", "Bazin empty","Bazin ful","Bazin half", "Boil 1","Boiler","Button1 off", "Button1 off p",
            "Analizor clor", "Bazin empty","Bazin ful","Bazin half", "Boil 1","Boiler","Button1 off", "Button1 off p"};
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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.player, null);
        gv=rootView.findViewById(R.id.gridView1);
        imageView = rootView.findViewById(R.id.button4);
        getDialog().setTitle("ASD");

        CustomAdapter adapter=new CustomAdapter(getActivity(), names, images);
        gv.setAdapter(adapter);



       /* gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("MissingInflatedId")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(getActivity(), names[position], Toast.LENGTH_SHORT).show();
                // Retrieve the selected image from the adapter
                int selectedImage = images[position];

                // Initialize the ImageView object and set its image resource to the selected image
                imageView = rootView.findViewById(R.id.button4);
                imageView.setImageResource(selectedImage);

                // Display a Toast message to indicate which image was selected
                Toast.makeText(getActivity(), names[position], Toast.LENGTH_SHORT).show();

            }



        });*/


        //imageView = rootView.findViewById(R.id.selected_image);
        //imageView.setImageResource(R.drawable.default_image);

            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int selectedImage = images[position];
                    // Set the image resource of the ImageView to the selected image
                    //nefunctional
                    imageView.setImageResource(selectedImage);
                }
            });



            return rootView;
        }





}
