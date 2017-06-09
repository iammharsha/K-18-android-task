package com.example.harsha.ktask;





import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import static android.R.attr.duration;
import static android.R.attr.onClick;
import static android.R.attr.y;
import static com.example.harsha.ktask.R.id.dob;
import static com.example.harsha.ktask.R.id.text;
import static com.example.harsha.ktask.R.id.text_dob;

public class MainActivity extends AppCompatActivity {

    private final int DATE_PICKER_ID=0;
    private int year,day,month;
    private String name;
    private String reg;
    private String gender="";
    private String email;
    private String number;
    private String text_dob;
    private String occupation;
    Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = (Spinner) findViewById(R.id.text_gender);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int pos, long id) {
                if(pos==0)
                {
                    gender="";
                    //Toast.makeText(MainActivity.this,"Please Enter Gender",Toast.LENGTH_SHORT).show();
                    return;
                }
                gender=parent.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,"Please Enter Gender",Toast.LENGTH_SHORT).show();
            }


        });


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
                    Intent intent=new Intent(MainActivity.this,Display.class);
                    intent.putExtra("nameText",name);
                    intent.putExtra("regText",reg);
                    intent.putExtra("genText",gender);
                    intent.putExtra("dobText",text_dob);
                    intent.putExtra("emailText",email);
                    intent.putExtra("phoneNumber",number);
                    intent.putExtra("occText",occupation);
                    startActivity(intent);


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
            nme.setError("Please Enter Name");
            return false;
        }

        EditText regno=(EditText) findViewById(R.id.text_reg);
        reg=regno.getText().toString();
        if(reg.matches(""))
        {
            regno.setError("Please Enter Register No.");
            return false;
        }


        if(gender.matches(""))
        {
            Toast.makeText(MainActivity.this,"Please Select Gender",Toast.LENGTH_SHORT).show();
            return false;
        }

        EditText dob=(EditText) findViewById(R.id.text_dob);
        text_dob=dob.getText().toString();
        if(text_dob.matches(""))
        {
            dob.setError("Please Enter D.O.B.");
            return false;
        }

        EditText emailId=(EditText) findViewById(R.id.text_email);
        email=emailId.getText().toString();
        if(email.matches(""))
        {
            emailId.setError("Please Enter E-Mail ID");
            return false;
        }

        EditText phone=(EditText) findViewById(R.id.text_number);
        number=phone.getText().toString();
        if(number.matches(""))
        {
            phone.setError("Please Enter Phone Number");
            return false;
        }


        EditText occ=(EditText) findViewById(R.id.text_occupation);
        occupation=occ.getText().toString();
        if(occupation.matches(""))
        {
            phone.setError("Please Enter Occupation");
            return false;
        }

        return true;
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
            month = selectedMonth+1;
            day   = selectedDay;


            EditText dob = (EditText) findViewById(R.id.text_dob);

            if(day<10)
            {
                text_dob="0"+day+"/";
            }
            else
            {
                text_dob=day+"/";
            }
            if(month<10)
            {
                text_dob=text_dob+"0"+month+"/";
            }
            else
            {
                text_dob=text_dob+month+"/";
            }
            text_dob=text_dob+year;
            dob.setText(text_dob);


        }
    };



}
