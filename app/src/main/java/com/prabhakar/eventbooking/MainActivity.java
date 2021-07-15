package com.prabhakar.eventbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button next_btn;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText phone;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next_btn = findViewById(R.id.next_btn);
        firstName = findViewById(R.id.firstName_box);
        lastName = findViewById(R.id.lastName_box);
        email = findViewById(R.id.email_box);
        phone = findViewById(R.id.phoneNumber_box);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                PreferenceHelper.getSharedPreferences(MainActivity.this);
//                name = firstName.getText().toString() + " " + lastName.getText().toString();
                PreferenceHelper.writeToPreference(firstName.getText().toString(),"firstName");
                PreferenceHelper.writeToPreference(lastName.getText().toString(),"lastName");
                PreferenceHelper.writeToPreference(email.getText().toString(),"email");
                PreferenceHelper.writeToPreference( phone.getText().toString(),"phoneNumber");
                startActivity(intent);
            }
        });
    }
}