package ru.startandroid.practask;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Article> articlesList;
    private Context parentContext;

    public MyAdapter(List<Article> articlesList, Context context) {
        this.articlesList = articlesList;
        parentContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article item = articlesList.get(position);

        holder.tvTitle.setText(item.getTitle());
        holder.tvDescription.setText(item.getDescription());
        Picasso.get()
                .load(item.getImageUrl())
                .resize(220,220)
                .into(holder.image);

        holder.lLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentContext, DetailsActivity.class);
                intent.putExtra("ImageUrl", item.getImageUrl());
                intent.putExtra("Title", item.getTitle());
                intent.putExtra("Description", item.getDescription());

                parentContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView tvTitle;
        TextView tvDescription;
        LinearLayout lLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            image = itemView.findViewById(R.id.image);
            lLayout = itemView.findViewById(R.id.lLayout);
        }
    }
}
