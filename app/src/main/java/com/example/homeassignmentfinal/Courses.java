package com.example.homeassignmentfinal;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Courses extends AppCompatActivity {
    CheckBox dmgt,itw2,daa,os,se,dppl;
    RadioGroup Elective;
    RadioButton selected_elective;
    int selected_id;
    String Main_Courses = "", Elective_Courses;
    Button regt,exit,button8;
    CourseDB myCdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        myCdb = new CourseDB(this);
        regt = findViewById(R.id.register);
        dmgt = findViewById(R.id.dmgt);
        itw2 = findViewById(R.id.itw2);
        daa = findViewById(R.id.daa);
        os = findViewById(R.id.os);
        dppl = findViewById(R.id.dppl);
        se = findViewById(R.id.se);
        regt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(daa.isChecked()){
                            Main_Courses=Main_Courses+" DAA";
                        }
                        if(se.isChecked()){
                            Main_Courses=Main_Courses+" SE";
                        }
                        if(os.isChecked()){
                            Main_Courses = Main_Courses + " OS";
                        }
                        if(dppl.isChecked()){
                            Main_Courses = Main_Courses + " DPPL";
                        }
                        if(dmgt.isChecked()){
                            Main_Courses = Main_Courses + " DMGT";
                        }
                        if(itw2.isChecked()){
                            Main_Courses = Main_Courses+" ITW2";
                        }
                        Elective = findViewById(R.id.electives);
                        selected_id = Elective.getCheckedRadioButtonId();
                        selected_elective = findViewById(selected_id);
                        Elective_Courses = selected_elective.getText().toString();
                        Bundle extn = getIntent().getExtras();
                        Bundle extr = getIntent().getExtras();
                        String Name = extn.getString("Name"),Roll = extr.getString("Roll");
                        boolean isinserted = myCdb.insertdata(Name ,Roll ,Main_Courses,Elective_Courses);
                        if(isinserted) {
                            Toast.makeText(Courses.this, "Main Courses: " + Main_Courses + "\nElective Course: " + Elective_Courses, Toast.LENGTH_SHORT).show();
                            Main_Courses = "";
                            Elective_Courses = "";
                            os.clearAnimation();se.clearAnimation();
                            Intent i = new Intent(Courses.this,MainActivity.class);
                            startActivity(i);
                        }
                    }
                }
        );
    }

}
