package com.example.clone_whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class Notes extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        ArrayList<MyData> data = (ArrayList<MyData>)getIntent().getSerializableExtra("data");

        recyclerView=findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(Notes.this);
        adapter = new RecyclerAdapter(Notes.this,data);

    }
}