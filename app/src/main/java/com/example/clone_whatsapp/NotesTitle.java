package com.example.clone_whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
//        Intent intent = getIntent();
//        String title1=intent.getStringExtra("title1");
//        String NotesText=intent.getStringExtra("NotesText");
//        ArrayList<MyData> data= (ArrayList<MyData>) intent.getSerializableExtra("data");
        add = (Button)findViewById(R.id.add);

        recyclerView=findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(NotesTitle.this);



        RequestQueue req = Volley.newRequestQueue(this);
        String url = "https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=98ff46b12d584a0abf812d41fdf42d50";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("status").equals("ok")){

                        JSONArray jsonArray = response.getJSONArray("articles");

                        for(int i=0 ; i<jsonArray.length() ; i++){

                            JSONObject item = jsonArray.getJSONObject(i);
                            MyData md = new MyData(item.getString("title"),item.getString("description"));

                            data.add(md);
                        }

                        adapter.notifyDataSetChanged();

                    }
                } catch (JSONException e) {
                    Toast.makeText(NotesTitle.this, "Error in "+e ,Toast.LENGTH_SHORT).show();
                    Log.d("errrr1",e.toString());
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(NotesTitle.this, "Error in" + error,Toast.LENGTH_SHORT).show();
                        Log.d("errrr11",error.toString());
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String> headers = new HashMap<String, String>();
                headers.put("User-Agent", "Mozilla/5.0");
                return headers;
            }
        };

        req.add(jsonObjectRequest);


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
                Toast.makeText(NotesTitle.this,"title1",Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }
}