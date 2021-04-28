package com.example.projectbidu.adapter;

import android.content.Context;
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

public class AdapterSellers extends RecyclerView.Adapter<AdapterSellers.SellerViewhodel> {
    private List<Seller> mListSellers;


    public AdapterSellers(List<Seller> mListSellers) {
        this.mListSellers = mListSellers;
    }

    @NonNull
    @Override
    public SellerViewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_seller_top, parent,false);
        return new SellerViewhodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SellerViewhodel holder, int position) {
        Seller seller = mListSellers.get(position);
        holder.imageSeller.setImageResource(seller.getImageSeller());
        holder.tvRanking.setText(String.valueOf(seller.getRankSeller()));
        holder.tvUserSeller.setText(seller.getUserName());
        holder.tvHasTag.setText(seller.getHasTag());
        //bien thien......?
        //
    }

    @Override
    public int getItemCount() {
        return mListSellers.size();
    }

    public class SellerViewhodel extends RecyclerView.ViewHolder {
        private TextView tvRanking;
        private TextView tvBienThien;
        private TextView tvUserSeller;
        private TextView tvHasTag;
        private ImageView imageRank;
        private ImageView imageSeller;
        public SellerViewhodel(@NonNull View itemView) {
            super(itemView);
            tvRanking = itemView.findViewById(R.id.tvRanking);
            tvBienThien = itemView.findViewById(R.id.tvBienThien);
            tvUserSeller = itemView.findViewById(R.id.tvNameSeller);
            tvHasTag = itemView.findViewById(R.id.tvHastag);
            imageRank = itemView.findViewById(R.id.imageRank);
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
