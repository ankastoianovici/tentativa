package com.example.licenta;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;





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

        CustomAdapter adapter=new CustomAdapter(getActivity(), names, images);
        gv.setAdapter(adapter);

            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                   // int selectedImage = images[position]; // Get the selected image
                    //ImageView imageView = rootView.findViewById(R.id.button4);
                    imageView.setImageResource(R.drawable.analizorclor);
                  //  dismiss();
                }


            });

            return rootView;
        }


}
