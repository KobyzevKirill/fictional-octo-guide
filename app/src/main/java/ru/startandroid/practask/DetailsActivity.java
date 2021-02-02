package ru.startandroid.practask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    TextView tvTitle;
    TextView tvDescription;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvTitle = findViewById(R.id.tvTitleDetail);
        tvDescription = findViewById(R.id.tvDescriptionDetail);
        image = findViewById(R.id.imageDetail);

        tvTitle.setText(getIntent().getStringExtra("Title"));
        tvDescription.setText(getIntent().getStringExtra("Description"));
        Picasso.get()
                .load(getIntent().getStringExtra("ImageUrl"))
                .fit()
                .into(image);
    }
}