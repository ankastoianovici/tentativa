package com.example.licenta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class develop extends Fragment {

    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_runtime, container, false);

        button = rootView.findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent=new Intent(getContext(),PlayersFragment.class);
                startActivity(intent);*/

                /*PlayersFragment playersFragment=new PlayersFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,playersFragment).commit();*/

                PlayersNewFragment newFragment = new PlayersNewFragment();
                newFragment.show(getChildFragmentManager(), "dff");


            }
        });

        return rootView;
    }
}