package com.example.homeassignmentfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Payment extends AppCompatActivity {
    public  PaymentDB mypdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        mypdb = new PaymentDB(this);
        final Spinner spinner = findViewById(R.id.spinner);
        final EditText name = findViewById(R.id.editText4);
        final EditText roll = findViewById(R.id.editText6);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.spinner,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(name.getText().toString().equals("") || roll.getText().toString().equals(""))
                {
                    Toast.makeText(Payment.this, "Please Enter Details", Toast.LENGTH_SHORT).show();
                    name.getText().clear();roll.getText().clear();
                    spinner.setSelection(0);
                }
                else {

                    if (parent.getItemAtPosition(position).equals("Choose Option")) {
                        //do nothing
                    } else {
                        String selected = parent.getItemAtPosition(position).toString();
                        //                    Toast.makeText(Payment.this, "Selected : "+ selected, Toast.LENGTH_SHORT).show();
                        if (selected.equals("Not Paid")) {
                            boolean isinserted = mypdb.insertdata(name.getText().toString(), roll.getText().toString(), "Not Paid");
                            if (isinserted) {
                                Toast.makeText(Payment.this, "Please Pay The Fees", Toast.LENGTH_SHORT).show();
                            }
                            name.getText().clear();
                            roll.getText().clear();
                            spinner.setSelection(0);
                            Intent i = new Intent(Payment.this,MainActivity.class);
                            startActivity(i);
                        } else if (selected.equals("Paid")) {
                            boolean isinserted = mypdb.insertdata(name.getText().toString(), roll.getText().toString(), "Paid");
                            if (isinserted) {
                                Toast.makeText(Payment.this, "Thanks", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Payment.this, Courses.class);
                                String strn = name.getText().toString(),strr=roll.getText().toString();
                                i.putExtra("Name",strn);
                                i.putExtra("Roll",strr);
                                startActivity(i);
                            }
                            name.getText().clear();
                            roll.getText().clear();
                            spinner.setSelection(0);
                        } else {
                            Toast.makeText(Payment.this, "Please Make A Choice", Toast.LENGTH_SHORT).show();
                        }
//                       name.getText().clear();
//                       roll.getText().clear();
//                       spinner.setSelection(0);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }
}

