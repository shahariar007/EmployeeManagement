package com.example.n33r.presentationproject;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ShowEmplyee extends AppCompatActivity {

    EditText shname,shphone,shemail,shbirthday,shnid,shsalary;
    Button deletebtn,updatebtn;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_emplyee);
        final Intent intent=getIntent();
        shname=(EditText)findViewById(R.id.showname);
        shphone=(EditText)findViewById(R.id.showphone);
        shemail=(EditText)findViewById(R.id.showemail);
        shbirthday=(EditText)findViewById(R.id.showbirthday);
        shnid=(EditText)findViewById(R.id.shownid);
        shsalary=(EditText)findViewById(R.id.showsalary);

        shname.setText(intent.getStringExtra("Name"));
        shname.setEnabled(false);

        shphone.setText(intent.getStringExtra("Phone"));
        shphone.setEnabled(false);

        shemail.setText(intent.getStringExtra("Email"));
        shemail.setEnabled(false);

        shbirthday.setText(intent.getStringExtra("birthday"));
        shbirthday.setEnabled(false);

        shnid.setText(intent.getStringExtra("nid"));
        shnid.setEnabled(false);

        shsalary.setText(intent.getStringExtra("salary"));
        shsalary.setEnabled(false);

        deletebtn=(Button)findViewById(R.id.delete);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              databaseHelper=new DatabaseHelper(getApplicationContext());
                databaseHelper.delete(intent.getStringExtra("Id"));
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        updatebtn=(Button)findViewById(R.id.update);
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((Button)v).getText().toString().equalsIgnoreCase("update")) {
                    shname.setEnabled(true);
                    shphone.setEnabled(true);
                    shemail.setEnabled(true);
                    shbirthday.setEnabled(true);
                    shnid.setEnabled(true);
                    shsalary.setEnabled(true);
                    updatebtn.setText("Save");
                }
                else {
                    databaseHelper = new DatabaseHelper(getApplicationContext());
                    ContentValues values = new ContentValues();
                    values.put(DatabaseHelper.KEY_NAME,shname.getText().toString());
                    values.put(DatabaseHelper.KEY_SALARY,shsalary.getText().toString());
                    values.put(DatabaseHelper.KEY_NID, shnid.getText().toString());
                    values.put(DatabaseHelper.KEY_BIRTHDAY,shbirthday.getText().toString());
                    values.put(DatabaseHelper.KEY_PHONE, shphone.getText().toString());
                    values.put(DatabaseHelper.KEY_EMAIL, shemail.getText().toString());
                    databaseHelper.update(intent.getStringExtra("Id"), values);
                    Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                    overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
                    finish();
                }
       }
        });






    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_emplyee, menu);
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
