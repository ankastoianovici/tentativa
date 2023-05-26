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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class develop extends Fragment {

    Button button,openButton;
    private ImageView selectedImageTextView;


    //Problema e ca nu-mi place deloc cum arata meniul cu linii
    int images[]={R.drawable.dottedline,R.drawable.dottedline2,R.drawable.dottedline3,
            R.drawable.dottedline4,R.drawable.dottedline5,R.drawable.dottedline6,
            R.drawable.line,R.drawable.line2,R.drawable.line3,
            R.drawable.line4,R.drawable.line5,R.drawable.line6,};

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
                View view = LayoutInflater.from(getContext()).inflate(R.layout.legenda, null);
                GridView gridView = view.findViewById(R.id.gridView2);
                CustomAdapter adapter=new CustomAdapter(getActivity(), images);
                gridView.setAdapter(adapter);
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        int selectedImage = images[position];
                        selectedImageTextView.setImageResource(Integer.parseInt(String.valueOf(selectedImage)));
                        dialog.dismiss();

                    }
                });
            }
        });
        selectedImageTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Create PopupMenu
                PopupMenu popupMenu = new PopupMenu(getContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.image_options_menu, popupMenu.getMenu());

                // Set a click listener for menu items
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Handle menu item click events
                        switch (item.getItemId()) {
                            case R.id.menu_delete:
                                // Delete the image
                                ViewGroup parent = (ViewGroup) v.getParent();
                                parent.removeView(v);
                                return true;
                            default:
                                return false;
                        }
                    }
                });

                popupMenu.show();
                return true; // Indicates that the long click event is consumed
            }
        });



        return rootView;
    }
}