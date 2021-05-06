package com.example.projectbidu.Hastag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectbidu.R;

import java.util.List;

public class HasTagAdapter extends RecyclerView.Adapter<HasTagAdapter.HasTagViewHolder> {
    private List<HasTag> hasTags;

    public HasTagAdapter(List<HasTag> value) {
        this.hasTags = value;
    }

    @NonNull
    @Override
    public HasTagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hastag, parent,false);
        return new HasTagViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HasTagViewHolder holder, int position) {
        HasTag hasTag = hasTags.get(position);

        if(hasTag==null) {
            return;
        } else {
            holder.tvHasTag.setText(hasTag.getHasTag());
        }

    }

    @Override
    public int getItemCount() {
        return hasTags.size();
    }

    public class HasTagViewHolder extends RecyclerView.ViewHolder {
        private TextView tvHasTag;
        public HasTagViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHasTag = (TextView) itemView.findViewById(R.id.tv_has_tag);
        }
    }
}
