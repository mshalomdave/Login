package com.jojo.login;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LinkifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_linkify);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textView = findViewById(R.id.result);
        textView.setText("TutorialsPoint.com originated from the idea that there exists a class of readers who respond better to online content and prefer to learn new skills at their ow...");
        Linkify.addLinks(textView, Linkify.WEB_URLS);

        TextView textView2 = findViewById(R.id.result2);
        textView2.setText("You can reach out to us at hello@tutorialspoint.com");
        Linkify.addLinks(textView2, Linkify.EMAIL_ADDRESSES);

        TextView textView3 = findViewById(R.id.result3);
        textView3.setText("Feel free to also call us on 0772345678");
        Linkify.addLinks(textView3, Linkify.PHONE_NUMBERS);

        TextView textView4 = findViewById(R.id.result4);
        textView4.setText("TutorialsPoint.com is a great resorce and you can reach out to them at hello@tutorialspoint.com and call them on 0772345678");
        Linkify.addLinks(textView4, Linkify.ALL);

    }
}