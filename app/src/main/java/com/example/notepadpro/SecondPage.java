package com.example.notepadpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class SecondPage extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    TextView notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        notes = (TextView) findViewById(R.id.notes);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewTask();
            }
        });

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        notes.setText(str);

    }
    public void openNewTask(){
        Intent intent = new Intent(this, NewTask.class);
        startActivity(intent);
    }
}