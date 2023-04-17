package com.example.licenta;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Players extends DialogFragment {


    GridView gv;
    String[] names={"Analizor clor", "Bazin empty","Bazin ful","Bazin half", "Boil 1","Boiler","Button1 off", "Button1 off p",
            "Analizor clor", "Bazin empty","Bazin ful","Bazin half", "Boil 1","Boiler","Button1 off", "Button1 off p",
            "Analizor clor", "Bazin empty","Bazin ful","Bazin half", "Boil 1","Boiler","Button1 off", "Button1 off p"};
    int images[]={R.drawable.analizorclor,R.drawable.bazinempty,R.drawable.bazinful,
            R.drawable.bazinhalf,R.drawable.boil1,R.drawable.boiler,R.drawable.button1_off,
            R.drawable.button1_off_p,R.drawable.analizorclor,R.drawable.bazinempty,R.drawable.bazinful,
            R.drawable.bazinhalf,R.drawable.boil1,R.drawable.boiler,R.drawable.button1_off,
            R.drawable.button1_off_p,R.drawable.analizorclor,R.drawable.bazinempty,R.drawable.bazinful,
            R.drawable.bazinhalf,R.drawable.boil1,R.drawable.boiler,R.drawable.button1_off,
            R.drawable.button1_off_p};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.player, null);
        gv=rootView.findViewById(R.id.gridView1);
        getDialog().setTitle("ASD");

        CustomAdapter adapter=new CustomAdapter(getActivity(), names, images);
        gv.setAdapter(adapter);


        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), names[position], Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }


}
