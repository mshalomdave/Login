package com.jojo.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SharedActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button b1,b2,b3;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        //Incase we don't want to press the set button b2,
        // we can add this code here and it checks and sets if
        //anything was stored
        if(sharedpreferences.contains(Name)){
            String user_n=sharedpreferences.getString(Name,null);
            ed1.setText(user_n);
        }
        if(sharedpreferences.contains(Phone)){
            String user_p=sharedpreferences.getString(Phone,null);
            ed2.setText(user_p);
        }
        if(sharedpreferences.contains(Email)){
            String user_e=sharedpreferences.getString(Email,null);
            ed3.setText(user_e);
        }else{
            Toast.makeText(SharedActivity.this, "Nothing found", Toast.LENGTH_SHORT).show();
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = ed1.getText().toString();
                String ph  = ed2.getText().toString();
                String e  = ed3.getText().toString();

//                Login
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name, n);
                editor.putString(Phone, ph);
                editor.putString(Email, e);
                editor.commit();


                Toast.makeText(SharedActivity.this,"Successfully saved the information.",Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sharedpreferences.contains(Name)){
                    String user_n=sharedpreferences.getString(Name,null);
                    ed1.setText(user_n);
                }
                if(sharedpreferences.contains(Phone)){
                    String user_p=sharedpreferences.getString(Phone,null);
                    ed2.setText(user_p);
                }
                if(sharedpreferences.contains(Email)){
                    String user_e=sharedpreferences.getString(Email,null);
                    ed3.setText(user_e);
                }else{
                    Toast.makeText(SharedActivity.this, "Nothing found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.commit();
            }
        });

    }

}