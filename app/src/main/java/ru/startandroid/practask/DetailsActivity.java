package ru.startandroid.practask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView tvTitle;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvTitle = findViewById(R.id.tvTitleDetail);
        tvDescription = findViewById(R.id.tvDescriptionDetail);

        tvTitle.setText(getIntent().getStringExtra("Title"));
        tvDescription.setText(getIntent().getStringExtra("Description"));
    }
}