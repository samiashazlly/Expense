package com.samia.expense;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<ItemInfo> data = Collections.emptyList();

    public RecyclerViewAdapter(Context context, List<ItemInfo> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemInfo current = data.get(position);
        holder.title.setText(current.getTitle());
        holder.description.setText(current.getDescription());
        holder.icon.setImageResource(current.getItemId());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        TextView description;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.item_title);
            description = (TextView)itemView.findViewById(R.id.item_description);
            icon = (ImageView)itemView.findViewById(R.id.item_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"item clicked at "+ getAdapterPosition(),Toast.LENGTH_SHORT).show();
        }
    }
}
