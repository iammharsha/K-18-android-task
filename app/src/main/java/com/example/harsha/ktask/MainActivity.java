package com.example.harsha.ktask;





import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import static android.R.attr.duration;
import static android.R.attr.onClick;


public class MainActivity extends AppCompatActivity {

    private final int DATE_PICKER_ID=0;
    private int year,day,month;
    private String name;
    private String reg;
    private String email;
    private String number;
    private String text_dob;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText dob = (EditText) findViewById(R.id.text_dob);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDate(v);
            }
        });


        Button submit=(Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                if(validate())
                {

                }


            }

        });


    }

    public boolean validate()
    {
        EditText nme=(EditText) findViewById(R.id.text_name);
        name=nme.getText().toString();
        if(name.matches(""))
        {
            toast("Name");
            return false;
        }

        EditText regno=(EditText) findViewById(R.id.text_reg);
        reg=regno.getText().toString();
        if(reg.matches(""))
        {
            toast("Register No.");
            return false;
        }

        if(year==0 || day==0||month==0)
        {
            toast("D.O.B.");
            return false;
        }

        EditText emailid=(EditText) findViewById(R.id.text_email);
        email=emailid.getText().toString();
        if(email.matches(""))
        {
            toast("E-Mail ID");
            return false;
        }

        EditText phone=(EditText) findViewById(R.id.text_number);
        number=phone.getText().toString();
        if(number.matches(""))
        {
            toast("Phone Number");
            return false;
        }

        return true;
    }

    public void toast(String s)
    {
        Toast.makeText(this.getApplicationContext(),"Please Enter "+s, Toast.LENGTH_LONG).show();

    }





    public void SelectDate(View v) {

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);


        showDialog(DATE_PICKER_ID);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_PICKER_ID:

                // open datepicker dialog.
                // set date picker for current date
                // add pickerListener listner to date picker
                return new DatePickerDialog(this, pickerListener, year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year  = selectedYear;
            month = selectedMonth;
            day   = selectedDay;


            EditText dob = (EditText) findViewById(R.id.text_dob);

            dob.setText(day+"/"+month+"/"+year);


        }
    };



}
