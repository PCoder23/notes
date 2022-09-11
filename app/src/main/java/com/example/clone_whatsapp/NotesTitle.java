package com.example.clone_whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesTitle extends AppCompatActivity {
    EditText title1;
    EditText NotesText;
    Button enter;
    ArrayList<MyData> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_title);
        title1 = (EditText)findViewById(R.id.title1);
        NotesText = (EditText)findViewById(R.id.NotesText);
        enter = (Button)findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         data.add(new MyData(title1.getText().toString(),NotesText.getText().toString()));
                                     }
                                 }
        );


    }
}