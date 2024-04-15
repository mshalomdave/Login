package com.jojo.login;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BroadcastActivity extends AppCompatActivity {

    public static final String CUSTOM_INTENT = "com.jojo.login.CUSTOM_INTENT";
    MyReceiver myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_broadcast);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button button=findViewById(R.id.button2);

        //Initialize my Receiver
        myReceiver=new MyReceiver();

        //Register receiver
        registerReceiver(myReceiver,new IntentFilter(CUSTOM_INTENT));
//      Button for sending broadcast Intent
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcastIntent(v);
            }
        });
    }

    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction(CUSTOM_INTENT);
        sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Unregister receiver on close of activity
        unregisterReceiver(myReceiver);
    }
}