package com.jojo.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewActivity extends AppCompatActivity implements View.OnClickListener {

// declaring objects of Button class
private Button start, stop;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
        });

        // assigning ID of startButton
        // to the object start
        start = findViewById( R.id.startButton );

        // assigning ID of stopButton
        // to the object stop
        stop = findViewById( R.id.stopButton );

        // declaring listeners for the
        // buttons to make them respond
        // correctly according to the process
        start.setOnClickListener( this );
        stop.setOnClickListener( this );
        }

public void onClick(View view) {

        // process to be performed
        // if start button is clicked
        if(view == start){

        // starting the service
        startService(new Intent( this, NewService.class ) );
        }

        // process to be performed
        // if stop button is clicked
        else if (view == stop){

        // stopping the service
        stopService(new Intent( this, NewService.class ) );

        }
        }
        }



