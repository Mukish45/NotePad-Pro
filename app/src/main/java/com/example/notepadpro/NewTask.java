package com.example.notepadpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewTask extends AppCompatActivity {

    private Button entertask;
    EditText newTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        entertask = (Button) findViewById(R.id.entertask);
        newTask = (EditText) findViewById(R.id.newTask);

        entertask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String note = newTask.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SecondPage.class);
                intent.putExtra("message_key", note);
                startActivity(intent);



                Context context = getApplicationContext();
                CharSequence text = "Task Added Successfully!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}

