package com.example.licenta;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.net.Inet4Address;


public class Runtime extends Fragment {

    Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_runtime, container, false);

        button = rootView.findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent=new Intent(getContext(),PlayersFragment.class);
                startActivity(intent);*/

                /*PlayersFragment playersFragment=new PlayersFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,playersFragment).commit();*/

                PlayersFragment newFragment = new PlayersFragment();
                newFragment.show(getChildFragmentManager(), "dff");


            }
        });

        return rootView;
    }


}