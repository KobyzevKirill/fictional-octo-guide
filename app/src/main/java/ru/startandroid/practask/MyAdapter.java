package ru.startandroid.practask;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<RecyclerItem> listItems;
    private Context parentContext;

    public MyAdapter(List<RecyclerItem> listItems, Context context) {
        this.listItems = listItems;
        parentContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parentContext).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerItem item = listItems.get(position);

        holder.tvTitle.setText(item.getTitle());
        holder.tvDescription.setText(item.getDescription());

        holder.rLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentContext, DetailsActivity.class);
                intent.putExtra("Title", item.getTitle());
                intent.putExtra("Description", item.getDescription());

                parentContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDescription;
        RelativeLayout rLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            rLayout = itemView.findViewById(R.id.rLayout);
        }
    }
}
