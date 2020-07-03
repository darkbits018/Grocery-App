package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private EditText edInput;
    private Button btnSubmit;
    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        edInput = findViewById(R.id.edItem);
        btnSubmit = findViewById(R.id.btnSubmit);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnSubmit.setOnClickListener(view -> {
            String itemname = edInput.getText().toString();
            Item item = new Item(0,itemname);
            AppDatabase.getInstance(this).itemDAO().InsertItem(item);

            display();

        });
    }
    void  display(){
        items = (ArrayList<Item>) AppDatabase.getInstance(this).itemDAO().getAllItems();
        adapter = new Adapter(items);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}