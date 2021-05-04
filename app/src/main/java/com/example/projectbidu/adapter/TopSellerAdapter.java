package com.example.projectbidu.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectbidu.R;
import com.example.projectbidu.model.Seller;

import java.util.List;

public class TopSellerAdapter extends RecyclerView.Adapter<TopSellerAdapter.SellerViewhodel> {
    private final List<Seller> sellers;

    public TopSellerAdapter(List<Seller> mListSellers) {
        this.sellers = mListSellers;
    }

    @NonNull
    @Override
    public SellerViewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_seller_top, parent,false);
        return new SellerViewhodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SellerViewhodel holder, int position) {
        Seller seller = sellers.get(position);
        holder.imageSeller.setImageResource(seller.getImageSeller());
        holder.tvRanking.setText(String.valueOf(seller.getRankSeller()));
        holder.tvUserSeller.setText(seller.getUserName());
        holder.tvHasTag.setText(seller.getHasTag());
    }

    @Override
    public int getItemCount() {
        return sellers.size();
    }

    public class SellerViewhodel extends RecyclerView.ViewHolder {
        private final TextView tvRanking;
        private final TextView tvUserSeller;
        private final TextView tvHasTag;
        private final ImageView imageSeller;
        public SellerViewhodel(@NonNull View itemView) {
            super(itemView);
            tvRanking = itemView.findViewById(R.id.tvRanking);
            TextView tvChange = itemView.findViewById(R.id.tv_change);
            tvUserSeller = itemView.findViewById(R.id.tvNameSeller);
            tvHasTag = itemView.findViewById(R.id.tvHastag);
            ImageView imageRank = itemView.findViewById(R.id.imageRank);
            imageSeller = itemView.findViewById(R.id.imageViewSeller);
        }
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
