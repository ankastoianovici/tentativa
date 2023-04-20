package com.example.licenta;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class PlayersFragment extends DialogFragment{


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
                // Inflate the custom layout
                View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.alertdialog, null);

                // Build the dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(dialogView);
                builder.setTitle("Custom Dialog Title");

                TextView textView = view.findViewById(R.id.nume1);
                Button button=dialogView.findViewById(R.id.colect);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle the button click event
                        Toast.makeText(getActivity(), "Button clicked", Toast.LENGTH_SHORT).show();

                    }
                });

                // Create and show the dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        return rootView;
    }


}