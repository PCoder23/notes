package com.example.clone_whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

public class NotesTitle extends AppCompatActivity {
    EditText title1;
    Button enter;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_title);
        title1 = (EditText)findViewById(R.id.title1);
        enter = (Button)findViewById(R.id.enter);
        text = (TextView)findViewById(R.id.text1);
        enter.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         text.setText(title1.getText());
                                     }
                                 }
        );


    }
}