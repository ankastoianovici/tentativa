package com.example.licenta;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddAlarmsAnalog extends DialogFragment {

    private ListView listView;
    private ArrayList<String> itemList;
    private List_Adapter adapter;
    private EditText editText1, editText2, editText3;
    private Spinner spinner;
    private Button button;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_alarms_analog, container, false);

        // Initialize the ListView and ArrayList objects
        listView = view.findViewById(R.id.listview);
        itemList = new ArrayList<String>();
        adapter = new List_Adapter(getActivity(), itemList);
        listView.setAdapter(adapter);

        editText1 = view.findViewById(R.id.node_edit_text);
        editText2 = view.findViewById(R.id.name_alarma_text);
        editText3 = view.findViewById(R.id.name_message_text);
        spinner = view.findViewById(R.id.mode_spinner);
        button = view.findViewById(R.id.finish_button);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, new String[]{"Bigger", "Lower", "Between"});
        spinner.setAdapter(adapter1);


        Button buttonAdd = view.findViewById(R.id.salvare);
        Button cancel = view.findViewById(R.id.cancel_button);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reverse the order of the ArrayList and set it to the adapter
                Collections.reverse(itemList);
                listView.setAdapter(adapter);
                EditText editText1 = view.findViewById(R.id.node_edit_text);
                String editTextValue = editText1.getText().toString();
                EditText editText2 = view.findViewById(R.id.name_alarma_text);
                String editTextValue1 = editText2.getText().toString();
                EditText editText3 = view.findViewById(R.id.name_message_text);
                String editTextValue2 = editText3.getText().toString();
                // Add a new item to the ArrayList and notify the adapter that the data set has changed
                String itemString = editTextValue + " " + editTextValue1;
                itemList.add(itemString);
                Collections.reverse(itemList); // Reverse the ArrayList
                adapter.notifyDataSetChanged(); // Update the ListView
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }

        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get values from EditTexts
                //varianta asta nu mergea pentru ca sus aveam string si aici salvam in int, se bateau cap in cap
                //int value1 = Integer.parseInt(editText1.getText().toString());
                //int value2 = Integer.parseInt(editText2.getText().toString());
                for (String item : itemList) {
                    // Split the item string into value1, value2 and value 3
                    String[] values = item.split(" ");
                    int value1 = Integer.parseInt(values[0]);
                    int value2 = Integer.parseInt(values[1]);
                    int value3 = Integer.parseInt(values[2]);

                    // Get selected item from spinner
                    String selectedItem = spinner.getSelectedItem().toString();

                    // Check if value1 is greater than value2
                    boolean isFirstBigger = value1 > value2;
                    boolean isFirstLower = value1 < value2;
                    //Check if value1 is greater than value2 and also less than value3
                    boolean isBetween = value1 > value2 && value1 < value3;

                    // Calculate result based on selected item
                    boolean result;
                    String message = null;
                    if (selectedItem.equals("Bigger")) {
                        message = "Bigger Alarma ON";
                        result = isFirstBigger;

                    }
                    else if (selectedItem.equals("Lower")) {
                        message = "Lower Alarma ON";
                        result = isFirstLower;
                    }
                    //asta nu merge
                    else if (selectedItem.equals("Between")) {
                        message = "Between Alarma ON";
                        result = isBetween;
                    } else {
                        message = "Alarma OFF";
                        result = false; // Set the result to false if the alarm is not on
                    }

                    // Display result using toast
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                    if (result) {
                        // Build and send the notification
                        sendNotification(getContext(), "Alarm Notification", message);
                    }
                }
            }
        });

        return view;
    }

    private void sendNotification(Context context, String notification_title, String message) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = "channel_id";
        String channelName = "Channel Name";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.baseline_circle_notifications_24)
                .setContentTitle("Alarm Notification")
                .setContentText(message)
                .setAutoCancel(true);

        notificationManager.notify(0, builder.build());
    }


}