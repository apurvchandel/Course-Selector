package com.example.homeassignmentfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Activity_SignUp extends AppCompatActivity {
    LoginDB mydb;
    EditText usrid,usrp;
    Button Sign,ViewAll,Clear;
    TextView SignUPV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__sign_up);
        mydb = new LoginDB(this);
        final EditText usrid = findViewById(R.id.editText);
        final EditText usrp = findViewById(R.id.editText5);
        Sign = findViewById(R.id.button2);
        SignUPV = findViewById(R.id.textView2);
        SignUPV.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Activity_SignUp.this, MainActivity.class);
                        startActivity(i);
                    }
                }
        );
        Sign.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String Str;
                        Str = "Fields Are Empty";
                        if (usrid.getText().toString().equals("") || usrp.getText().toString().equals("")) {
                            Toast.makeText(Activity_SignUp.this, Str, Toast.LENGTH_LONG).show();
                        } else {
                            boolean isInserted = mydb.insertData(usrid.getText().toString(), usrp.getText().toString());
                            if (isInserted)
                                Toast.makeText(Activity_SignUp.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(Activity_SignUp.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                        usrid.getText().clear();
                        usrp.getText().clear();
                    }
                }
        );



    }

}
