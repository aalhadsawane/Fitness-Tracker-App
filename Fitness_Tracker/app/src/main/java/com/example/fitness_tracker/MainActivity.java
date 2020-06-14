package com.example.fitness_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText name = (EditText) findViewById(R.id.name);
    EditText age = (EditText) findViewById(R.id.age);
    EditText calories = (EditText) findViewById(R.id.cal);
    Button edit = (Button) findViewById(R.id.btnedit);

    DatabaseReference databaseUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseUsers = FirebaseDatabase.getInstance().getReference("users");

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!name.isEnabled()) {
                    name.setEnabled(true);
                    age.setEnabled(true);
                    calories.setEnabled(true);
                    edit.setText("Save");
                }else{
                    addUser();
                    name.setEnabled(false);
                    age.setEnabled(false);
                    calories.setEnabled(false);
                    edit.setText("Edit");
                }
            }
        });
    }

    public void addUser(){
        String namE = name.getText().toString().trim();
        String agE = age.getText().toString().trim();
        String calorieS = calories.getText().toString().trim();

        if(!TextUtils.isEmpty(namE) && !TextUtils.isEmpty(agE) && !TextUtils.isEmpty(calorieS)){

            String id = databaseUsers.push().getKey();
            User user = new User(namE, agE, calorieS);
            databaseUsers.child(id).setValue(user);

            Toast.makeText(this, "User added successfully", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "You must fill all fields", Toast.LENGTH_LONG).show();
        }


    }
}
