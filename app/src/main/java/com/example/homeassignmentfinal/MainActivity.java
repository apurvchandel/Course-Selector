package com.example.homeassignmentfinal;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Student, Teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student = findViewById(R.id.button9);
        Teacher = findViewById(R.id.button10);
        Student.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent I = new Intent(MainActivity.this,StudentLogin.class);
                        startActivity(I);
                    }
                }
        );

        Teacher.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this,Teacher_Login.class);
                        startActivity(i);
                    }
                }
        );
    }

}
