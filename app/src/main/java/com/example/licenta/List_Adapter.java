package com.example.licenta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class List_Adapter extends ArrayAdapter<String> {

    public List_Adapter(Context context, ArrayList<String> itemList) {
        super(context, R.layout.item_list, itemList);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }

        TextView itemTextView = itemView.findViewById(R.id.item_text);
        itemTextView.setText(getItem(position));

        Button deleteButton = itemView.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(getItem(position));
                notifyDataSetChanged();
            }
        });

        return itemView;
    }
}
