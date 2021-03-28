package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginDatabase extends AppCompatActivity {

    EditText e1, e2;
    Button bt1;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_database);

        db = new DbHelper(this);
        e1 = (EditText) findViewById(R.id.editTextTextPersonName);
        e2 = (EditText) findViewById(R.id.editTextTextPassword);
        bt1 = (Button) findViewById(R.id.button);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginDatabase.this, LoggedIn.class);
                startActivity(i);
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean ChkemailPassword = db.emailPassword(email, password);
                if (ChkemailPassword == true)
                    Toast.makeText(getApplicationContext(), "Successfully Logged In", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Wrong Email and Password", Toast.LENGTH_SHORT).show();

            }
        });
    }
}