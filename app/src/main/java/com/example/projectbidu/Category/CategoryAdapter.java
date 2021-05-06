package com.example.projectbidu.Category;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectbidu.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private final List<Category> categories;
    private final ItemClickListener itemClickListener;

    int row_index = 0;


    public CategoryAdapter(List<Category> categories, ItemClickListener itemClickListener) {
        this.categories = categories;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_category, parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.title.setText(category.getTitle());
        holder.itemView.setOnClickListener(v->{
            row_index = position;
            notifyDataSetChanged();
            itemClickListener.getDataItemClick(category);
        });

        if (row_index==position) {
            holder.title.setBackgroundResource(R.drawable.customer_button_selected);
            holder.title.setTextColor(Color.WHITE);
        } else {
            holder.title.setBackgroundResource(R.drawable.customer_button);
            holder.title.setTextColor(Color.parseColor("#9A9A9A"));
        }
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTittle);

        }

    }
    public  interface  ItemClickListener {
        void getDataItemClick(Category category);
    }
    
}
