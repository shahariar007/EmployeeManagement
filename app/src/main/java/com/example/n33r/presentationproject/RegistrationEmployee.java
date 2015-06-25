package com.example.n33r.presentationproject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class RegistrationEmployee extends Activity {

    EditText mname,mphone,memail,mbirthday,mnid,msalary;
    Button mregistration;
    Emplyee emplyee;


    String sname,sphone,semail,sbirthday,snid,ssalary;
    Calendar myCalendar;

    DatePickerDialog.OnDateSetListener onDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_employee);
        mname=(EditText)findViewById(R.id.ename);
        mphone=(EditText)findViewById(R.id.ephone);
        memail=(EditText)findViewById(R.id.eemail);
        mbirthday=(EditText)findViewById(R.id.ebirthday);
        mnid=(EditText)findViewById(R.id.enid);
        msalary=(EditText)findViewById(R.id.esalary);

        //Datepicker
        myCalendar=Calendar.getInstance();
        onDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,monthOfYear);
                myCalendar.set(Calendar.DATE,dayOfMonth);
                String myformat="dd-MM-yy";
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat(myformat, Locale.US);
                mbirthday.setText(simpleDateFormat.format(myCalendar.getTime()));

            }
        };
        mbirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(RegistrationEmployee.this, onDateSetListener, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        mregistration=(Button)findViewById(R.id.eregistration);

        mregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname=mname.getText().toString();
                sphone=mphone.getText().toString();
                semail=mphone.getText().toString();
                sbirthday=mbirthday.getText().toString();
                snid=mnid.getText().toString();
                ssalary=msalary.getText().toString();
                emplyee=new Emplyee(sname,sphone,semail,sbirthday,snid,ssalary);
                DatabaseHelper databaseHelper=new DatabaseHelper(getBaseContext());
                databaseHelper.insertemplyee(emplyee);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
               }
        });


       }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration_employee, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
