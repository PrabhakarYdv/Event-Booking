package com.prabhakar.eventbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button preview_btn;
    private TextView firstName;
    private TextView lastName;
    private TextView email;
    private TextView number;
    private EditText seat;
    private EditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        preview_btn = findViewById(R.id.preview_btn);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id._email_);
        number = findViewById(R.id._phone_);
        seat=findViewById(R.id.noOfSeats);
        date=findViewById(R.id.DateOfShow);

        getDetails();
        preview_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivty.class);
                PreferenceHelper.getSharedPreferences(SecondActivity.this);
                PreferenceHelper.writeToPreference(seat.getText().toString(),"seats");
                PreferenceHelper.writeToPreference(date.getText().toString(),"date");
                startActivity(intent);
            }
        });
    }

    private void getDetails() {
        String value_firstName = PreferenceHelper.getFromPreferences("firstName");
        String value_lastName = PreferenceHelper.getFromPreferences("lastName");
        String value_email = PreferenceHelper.getFromPreferences("email");
        String value_phoneNumber = PreferenceHelper.getFromPreferences("phoneNumber");
        firstName.setText(value_firstName+" ");
        lastName.setText(value_lastName);
        email.setText(value_email);
        number.setText(value_phoneNumber);
    }
}