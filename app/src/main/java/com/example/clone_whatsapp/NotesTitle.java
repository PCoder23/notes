package com.example.clone_whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class NotesTitle extends AppCompatActivity {
    Button add;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    ArrayList<MyData> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Intent intent = getIntent();
        String title1=intent.getStringExtra("title1");
        String NotesText=intent.getStringExtra("NotesText");
        ArrayList<MyData> data= (ArrayList<MyData>) intent.getSerializableExtra("data");
        add = (Button)findViewById(R.id.add);


        recyclerView=findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(NotesTitle.this);
        adapter = new RecyclerAdapter(NotesTitle.this,data);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NotesTitle.this, Notes.class);
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });
        add.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(NotesTitle.this,title1,Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }
}