package com.example.clone_whatsapp;


import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    Context context;
    ArrayList<MyData> data;
    RecyclerAdapter(Context context, ArrayList<MyData> data){
        this.context = context;
        this.data=data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_layout,parent,false);
    return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
    MyData curData= data.get(position);
    holder.title2.setText(curData.getTitle());
    holder.NotesText2.setText(curData.getText());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView title2;
        TextView NotesText2;
        public RecyclerViewHolder(@NonNull View view) {
            super(view);
            title2 = view.findViewById(R.id.title2);
            NotesText2 = view.findViewById(R.id.NotesText2);
        }
    }
}
