package com.example.projectbidu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.ViewHodel> {
    private Context context;
    private List<Category> mList;

    public AdapterCategory(Context context) {
        this.context = context;
    }

    public void setData(List<Category> mList){
        this.mList=mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_category, parent,false);
        return new ViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        Category category = mList.get(position);
        holder.title.setText(category.getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder {
        private TextView title;
        public ViewHodel(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTittle);
        }
    }
}
