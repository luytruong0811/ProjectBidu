package com.example.projectbidu.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectbidu.R;
import com.example.projectbidu.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHodel> {
    private List<Category> categories;
    private ItemClickListener itemClickListener;

    int row_index = 0;


    public CategoryAdapter(List<Category> categories, ItemClickListener itemClickListener) {
        this.categories = categories;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_category, parent,false);
        return new CategoryViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHodel holder, int position) {
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

    public class CategoryViewHodel extends RecyclerView.ViewHolder {
        private TextView title;

        public CategoryViewHodel(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTittle);

        }

    }
    public  interface  ItemClickListener {
        void getDataItemClick(Category category);
    }
    
}
