package com.example.licenta;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
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
    private FrameLayout frameValue,frameBitwise;
    private Button button, back;
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

        spinner = view.findViewById(R.id.set_value);
        frameValue = view.findViewById(R.id.value_frame);
        frameBitwise = view.findViewById(R.id.bitwise_frame);

        editText1 = view.findViewById(R.id.node_edit_text);
        editText2 = view.findViewById(R.id.name_alarma_text);
        editText3 = view.findViewById(R.id.name_message_text);
        spinner = view.findViewById(R.id.mode_spinner);
        button = view.findViewById(R.id.finish_button);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, new String[]{"Bigger", "Lower"});
        spinner.setAdapter(adapter1);


        back=view.findViewById(R.id.back_button);
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
                if (!itemList.contains(itemString)) {
                    //nume alarma duplicat
                    itemList.add(itemString);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Duplicate Item");
                    builder.setMessage("The item already exists in the list.");
                    builder.setPositiveButton("OK", null);
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                Collections.reverse(itemList); // Reverse the ArrayList
                adapter.notifyDataSetChanged(); // Update the ListView
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }

        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get selected item from spinner
                String selectedItem = spinner.getSelectedItem().toString();

                for (String item : itemList) {
                    // Split the item string into value1 and value2
                    String[] values = item.split(" ");
                    int value1 = Integer.parseInt(values[0]);
                    int value2 = Integer.parseInt(values[1]);

                    // Check if value1 is greater than value2
                    boolean isFirstBigger = value1 > value2;
                    boolean isFirstLower = value1 < value2;

                    // Calculate result and message based on selected item
                    boolean result;
                    String message = null;

                    if (selectedItem.equals("Bigger")) {
                        result = isFirstBigger;
                        message = "Bigger Alarm ON";
                    } else if (selectedItem.equals("Lower")) {
                        result = isFirstLower;
                        message = "Lower Alarm ON";
                    } else {
                        result = false; // Set the result to false if the alarm is not on
                        message = "Alarm OFF";
                        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                    }

                    // Send notification and display toast message only if the alarm is on
                    if (result!=false) {
                        sendNotification(getContext(), "Alarm Notification", message);
                        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                        //Alarms otherFragment = (Alarms) getActivity().getSupportFragmentManager().findFragmentByTag("OtherFragmentTag");
                        //if (otherFragment != null) {
                        //    otherFragment.addDataToList(item);
                        //}
                    }
                }


            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                if (selectedItem.equals("Value")) {
                    frameValue.setVisibility(View.VISIBLE);
                    frameBitwise.setVisibility(View.GONE);
                    // Uncheck the checkbox when "Digital" is selected

                } else if (selectedItem.equals("BITWISE")) {
                    frameValue.setVisibility(View.GONE);
                    frameBitwise.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().setCanceledOnTouchOutside(false);
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