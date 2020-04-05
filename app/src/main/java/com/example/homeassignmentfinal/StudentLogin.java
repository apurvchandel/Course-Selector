package com.example.homeassignmentfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentLogin extends AppCompatActivity {
    EditText eid,ep;
    Button SI;
    TextView SU;
    LoginDB mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        mydb = new LoginDB(this);
        SI = findViewById(R.id.button);
        eid = findViewById(R.id.editText2);
        ep = findViewById(R.id.editText3);
        SU = findViewById(R.id.signu);
        final String id = eid.getText().toString();
        final String pass = ep.getText().toString();
        SU.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(StudentLogin.this,Activity_SignUp.class);
                        startActivity(i);
                    }
                }
        );
        SI.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(eid.getText().toString().equals("") || ep.getText().toString().equals(""))
                        {
                            Toast.makeText(StudentLogin.this,"Empty Input",Toast.LENGTH_LONG).show();
                            eid.getText().clear();ep.getText().clear();

                        }
                        else
                        {
                            Cursor ispre = mydb.SearchData(id);
                            Cursor isprep = mydb.SearchData(pass);
                            if(ispre.getCount()!=0 && isprep.getCount()!=0)
                            {
                                Toast.makeText(StudentLogin.this,"Login Complete",Toast.LENGTH_LONG).show();
                                Intent i = new Intent(StudentLogin.this,Payment.class);
                                startActivity(i);
                                eid.getText().clear();ep.getText().clear();
                            }
                            else
                            {
                                Toast.makeText(StudentLogin.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                                eid.getText().clear();ep.getText().clear();
                            }

                        }
                    }
                }
        );
    }

}
