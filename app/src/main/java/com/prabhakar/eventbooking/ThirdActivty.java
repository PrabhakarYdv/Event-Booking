package com.prabhakar.eventbooking;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivty extends AppCompatActivity {
    private Button preview_btn;
    private TextView firstName;
    private TextView lastName;
    private TextView email;
    private TextView number;
    private TextView seats;
    private TextView date;
    private Button confirm_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_activty);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id._email_);
        number = findViewById(R.id._phone_);
        seats = findViewById(R.id._seats_);
        date = findViewById(R.id._date_);
        confirm_btn = findViewById(R.id.confirm_btn);
        getFinalDetails();
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ThirdActivty.this).setTitle("Booking Successful")
                        .setMessage("Congratulations !! Event is confirmed on this date " +
                                date.getText().toString() +"."+ "\n" +
                                "Thank You for Booking !!")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
    }


    private void getFinalDetails() {
        String value_firstName = PreferenceHelper.getFromPreferences("firstName");
        String value_lastName = PreferenceHelper.getFromPreferences("lastName");
        String value_email = PreferenceHelper.getFromPreferences("email");
        String value_phoneNumber = PreferenceHelper.getFromPreferences("phoneNumber");
        String value_seats = PreferenceHelper.getFromPreferences("seats");
        String value_date = PreferenceHelper.getFromPreferences("date");
        firstName.setText(value_firstName + " ");
        lastName.setText(value_lastName);
        email.setText(value_email);
        number.setText(value_phoneNumber);
        seats.setText(value_seats);
        date.setText(value_date);

    }
}