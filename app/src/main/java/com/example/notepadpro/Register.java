package com.example.notepadpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    TextView username;
    TextView useremail;
    TextView pass;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        username = (TextView) findViewById(R.id.name);
        useremail = (TextView) findViewById(R.id.email);
        pass = (TextView) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }
    public void registerUser(){
        String name = username.getText().toString().trim();
        String mail = useremail.getText().toString().trim();
        String password = pass.getText().toString().trim();

        if (name.isEmpty()){
            username.setError("Name is required!!!!");
            username.requestFocus();
            return;
        }
        if(mail.isEmpty()){
            useremail.setError("Mail is required!!!");
            useremail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            useremail.setError("Please provide valid Email ID");
            useremail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            pass.setError("Password is required!!!");
            pass.requestFocus();
            return;
        }
        if(password.length() < 8){
            pass.setError("Minimum password length should be 8 characters!!!");
            pass.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            User user = new User(name, mail);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(View.GONE);

                                            }else{
                                                Toast.makeText(Register.this, "Registration unsuccessful! Try Again!", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(View.GONE);
                                            }
                                        }
                                    });
                        }
                        else{
                            Toast.makeText(Register.this, "Oh! Registration unsuccessful! Try Again!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}