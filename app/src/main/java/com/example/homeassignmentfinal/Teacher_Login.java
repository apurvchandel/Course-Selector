package com.example.homeassignmentfinal;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Teacher_Login extends AppCompatActivity {

    LoginDB mydb;
    PaymentDB mypdb;
    CourseDB myCdb;
    Button AccShow,AccDel,PayShow,PayDel,CourShow,CourDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__login);
        mydb = new LoginDB(this);
        myCdb = new CourseDB(this);
        mypdb = new PaymentDB(this);
        AccShow = findViewById(R.id.button11);
        AccDel = findViewById(R.id.button12);
        PayShow = findViewById(R.id.button13);
        PayDel = findViewById(R.id.button14);
        CourShow = findViewById(R.id.button15);
        CourDel = findViewById(R.id.button16);
        AccShow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = mydb.getAllData();
                        if (res.getCount() == 0) {
// show message
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuilder buffer = new StringBuilder();
                        while (res.moveToNext()) {
                            buffer.append("ID : ").append(res.getString(1)).append("\n");
                            buffer.append("Password : ").append(res.getString(2)).append("\n");
                        }
// Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
        AccDel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer i = mydb.deleteData();
                        if (i > 0) {
                            Toast.makeText(Teacher_Login.this, "Data Cleared", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Teacher_Login.this, "Error", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
        CourShow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor show = myCdb.getalldata();
                        if (show.getCount() == 0) {
// show message
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuilder buffer = new StringBuilder();
                        while (show.moveToNext()) {
                            buffer.append("Name : ").append(show.getString(0)).append("\n");
                            buffer.append("Roll Number : ").append(show.getString(1)).append("\n");
                            buffer.append("Main Course : ").append(show.getString(2)).append("\n");
                            buffer.append("Optional Course : ").append(show.getString(3)).append("\n");
                        }
// Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
        CourDel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer isdel =myCdb.deleteall();
                        if (isdel > 0) {
                            Toast.makeText(Teacher_Login.this, "Data Cleared", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Teacher_Login.this, "Error", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
        PayDel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer i = mypdb.deleteData();
                        if (i > 0) {
                            Toast.makeText(Teacher_Login.this, "Data Cleared", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Teacher_Login.this, "Error", Toast.LENGTH_LONG).show();
                        }
                    }
                }

        );
        PayShow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = mypdb.getalldata();
                        if (res.getCount() == 0) {
// show message
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuilder buffer = new StringBuilder();
                        while (res.moveToNext()) {
                            buffer.append("Name : ").append(res.getString(0)).append("\n");
                            buffer.append("Roll Number : ").append(res.getString(1)).append("\n");
                            buffer.append("Payment Status : ").append(res.getString(2)).append("\n");
                        }
// Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );

    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
