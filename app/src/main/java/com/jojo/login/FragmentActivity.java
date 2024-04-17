package com.jojo.login;

import android.app.PendingIntent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn1=findViewById(R.id.button1);
        Button btn2=findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFragment(v);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFragment(v);
            }
        });

    }



    // method for displaying the appropriate
    // fragment according to the clicked button
    public void selectFragment(View view) {

        // creating object for Fragment
        Fragment fr;

        // displaying first fragment
        // if button1 is clicked
        if(view == findViewById(R.id.button1)) {
            fr = new FragmentOne();
        }

        // displaying second fragment
        // if button2 is clicked
        else {
            fr = new FragmentTwo();
        }

//        getFragmentManager() is deprecated
//        FragmentManager fm = getFragmentManager();
        //Use getSupportFragmentManager() instead
        FragmentManager fm = getSupportFragmentManager();

        // fragment transaction to add or replace
        // fragments while activity is running
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_section, fr);
        // making a commit after the transaction
        // to assure that the change is effective
        fragmentTransaction.commit();
    }
}
