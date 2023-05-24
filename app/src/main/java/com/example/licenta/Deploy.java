package com.example.licenta;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;


public class Deploy extends Fragment {


    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_deploy, container, false);

        button = rootView.findViewById(R.id.alarmlist);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); // Set the duration of each animation cycle
        anim.setStartOffset(20); // Delay before animation starts
        anim.setRepeatMode(Animation.REVERSE); // Animation reverses after completing
        anim.setRepeatCount(Animation.INFINITE); // Repeat animation indefinitely
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button.startAnimation(anim);
            }

        });
        return rootView;
    }

}