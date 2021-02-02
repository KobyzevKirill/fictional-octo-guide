package ru.startandroid.practask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.startandroid.practask.api.ClientAPI;
import ru.startandroid.practask.api.InterfaceAPI;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private InterfaceAPI interfaceAPI;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        interfaceAPI = ClientAPI.getClient().create(InterfaceAPI.class);

        Call<List<Article>> call = interfaceAPI.getArticles();
        call.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if (!response.isSuccessful()) {
                    Log.e(TAG, "onBadResponse: " + response.code());
                    return;
                }
                adapter = new MyAdapter(response.body(), context);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }
}