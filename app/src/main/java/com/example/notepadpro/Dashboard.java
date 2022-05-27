package com.example.notepadpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    private Button nextpgbtn;
    EditText editTextTextPersonName;
    EditText editTextTextPassword;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        nextpgbtn = (Button) findViewById(R.id.nextpgbtn);
        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
        register = (Button) findViewById(R.id.register);

        nextpgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextTextPersonName.getText().toString().equals("mukish") && editTextTextPassword.getText().toString().equals("password")){
                    Context context = getApplicationContext();
                    CharSequence text = "Login Successful!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    openActivity2();
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "Login Failed!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }


            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });

    }

    public void openActivity2(){
        Intent intent = new Intent(this, SecondPage.class);
        startActivity(intent);
    }

    public void openRegister(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}