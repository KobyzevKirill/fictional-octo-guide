package ru.startandroid.practask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<RecyclerItem> listItems;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        listItems = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            listItems.add(new RecyclerItem("Title " + (i + 1), "Some description of item " + (i + 1)));
        }

        adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }
}