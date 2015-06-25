package com.example.n33r.presentationproject;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Emplyee> emplyees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =(ListView)findViewById(R.id.employeeList);
        DatabaseHelper databaseHelper=new DatabaseHelper(this);
        emplyees=databaseHelper.getAllEmployee();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        listView.setAdapter(adapter);
        for(Emplyee e:emplyees)
        {
            adapter.add(e.getName());
            adapter.notifyDataSetChanged();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Emplyee emplyee=emplyees.get(position);
                Intent intent=new Intent(getApplicationContext(),ShowEmplyee.class);
                intent.putExtra("Id",emplyee.getId());
                intent.putExtra("Name",emplyee.getName());
                intent.putExtra("Phone",emplyee.getPhone());
                intent.putExtra("Email",emplyee.getEmail());
                intent.putExtra("birthday",emplyee.getBirthday());
                intent.putExtra("nid",emplyee.getNid());
                intent.putExtra("salary",emplyee.getSalary());
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        else if(id==R.id.addEmployee)
        {
            Intent intent=new Intent(getApplicationContext(),RegistrationEmployee.class);
            startActivity(intent);
            overridePendingTransition(R.anim.abc_slide_in_top,R.anim.abc_slide_in_bottom);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
