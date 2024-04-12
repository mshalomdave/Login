package com.jojo.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailField, passwordField;
    private TextView errorText;

    //Login Application

    /*Login Application
    By A student
    */


    //OnCreate Method that works like a main method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initialized the views
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        errorText = findViewById(R.id.errorText);

        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(this);

        Button registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(this);
    }

/*This method is for the purpose of going to the Next Activity called
Register Activity
 */
    private void gotoRegister() {
        Intent intent=new Intent(MainActivity.this,TestActivity.class);
        startActivity(intent);
//        finish();
    }

    private void validateInput() {
        String email = emailField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();


        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailField.setError("Invalid email address");
//            showError("Invalid email address");
            return;
        }

        if (password.isEmpty() || password.length() < 8) {
            passwordField.setError("Password must be at least 8 characters");
//            showError("Password must be at least 8 characters");
            return;
        }

        clearError();
        onSuccess(email);
    }

    private void showError(String message) {
        errorText.setVisibility(View.VISIBLE);
        errorText.setText(message);
    }

    private void clearError() {
        errorText.setVisibility(View.GONE);
    }

    private void onSuccess(String email) {
        //For example navigating to ProfileActivity
        Intent intent=new Intent(MainActivity.this,NextActivity.class);
        intent.putExtra("email",email);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.loginButton) {
            //Login Button code
            validateInput();
        }else{
            //Another Activity Button code
            Intent intent=new Intent(MainActivity.this,NewActivity.class);
            startActivity(intent);
        }

    }

}