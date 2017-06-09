package com.example.harsha.ktask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Display extends AppCompatActivity {

    private String dob;
    private String name;
    private String reg;
    private String email;
    private String number;
    private String gender;
    private String occupation;
    private TextView nameView;
    private TextView regView;
    private TextView genderView;
    private TextView dobView;
    private TextView emailView;
    private TextView phoneView;
    private TextView occupationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent=getIntent();
        name=intent.getStringExtra("nameText");
        reg=intent.getStringExtra("regText");
        gender=intent.getStringExtra("genText");
        dob=intent.getStringExtra("dobText");
        email=intent.getStringExtra("emailText");
        number=intent.getStringExtra("phoneNumber");
        occupation=intent.getStringExtra("occText");

        nameView=(TextView) findViewById(R.id.name);
        nameView.setText(name);

        regView=(TextView) findViewById(R.id.reg);
        regView.setText(reg);

        genderView=(TextView) findViewById(R.id.gender);
        genderView.setText(gender);

        dobView=(TextView) findViewById(R.id.dob);
        dobView.setText(dob);

        emailView=(TextView) findViewById(R.id.email);
        emailView.setText(email);

        phoneView=(TextView) findViewById(R.id.phone);
        phoneView.setText(number);

        occupationView=(TextView) findViewById(R.id.occupation);
        occupationView.setText(occupation);

    }
}
