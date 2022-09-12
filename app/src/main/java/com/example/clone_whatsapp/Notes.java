package com.example.clone_whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Notes extends AppCompatActivity {
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


        enter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(Notes.this,title1.getText().toString(),Toast.LENGTH_LONG).show();
                return true;
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         if (data.isEmpty()){
                                         Intent intent = new Intent(Notes.this, NotesTitle.class);
                                         data.add(new MyData(title1.getText().toString(),NotesText.getText().toString()));
                                         intent.putExtra("data",data);
                                         startActivity(intent);
                                         }else{
                                             Intent i =getIntent();
                                             Intent intent = new Intent(Notes.this, NotesTitle.class);
                                             data= (ArrayList<MyData>)i.getSerializableExtra("data");
                                             data.add(new MyData(title1.getText().toString(),NotesText.getText().toString()));
                                             intent.putExtra("data",data);
                                             startActivity(intent);
                                         }
                                     }
            }
        );


    }
}