package com.example.licenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button connectBtn= findViewById(R.id.button2);
        // serverUriTextField = findViewById(R.id.serverTf);
        connectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                //StrictMode.setThreadPolicy(policy);
                //serverUri = serverUriTextField.getText().toString();
                openActivity();
               /* try {
                    myClient = createClient(serverUri);
                    myClient.connect();
                    openActivity();
                } catch (Exception e) {
                    error = e.toString();
                    showAlert("Error", "Failed to connect");
                }*/
            }
        });
    }

    private void openActivity() {
        Intent intent = new Intent(getApplicationContext(), Citire.class);
        startActivity(intent);

    }
}
