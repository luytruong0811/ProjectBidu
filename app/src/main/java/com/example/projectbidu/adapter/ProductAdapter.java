package com.example.projectbidu.adapter;

import android.annotation.SuppressLint;

import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectbidu.R;
import com.example.projectbidu.model.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;



public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHodel> {

    private final List<Product> products;
    private final List<Product> productList;
    private final ItemClickListener itemClickListener;


    public ProductAdapter(List<Product> products, ItemClickListener itemClickListener) {
        this.products = products;
        productList = new ArrayList<>(products);
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ProductViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent,false);
        return new ProductViewHodel(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProductViewHodel holder, int position) {
        Product product =products.get(position);
        if(product == null ) {
        }
        else {
            holder.imageViewProduct.setImageResource(product.getImageProduct());
            if(product.isLike()) {
                holder.imageCheckLike.setImageResource(R.drawable.ic_favorite_icon);
            } else {
                holder.imageCheckLike.setImageResource(R.drawable.ic_favorite_icon__stroke_);
            }
            if(!product.isProductNew()) {
                holder.tvNew.setVisibility(View.GONE);
            }
            if(product.getSale() == null) {
                holder.tvProductSale.setVisibility(View.GONE);
            } else {
                holder.tvProductSale.setText(product.getSale()+"%");
            }
            holder.tvProductName.setText(product.getTitle());
            if(product.getSalePrice()==null) {
                holder.tvProductSalePrice.setText("");
            } else {
                holder.tvProductSalePrice.setText(setLineText(product.getSalePrice()));
            }
            holder.tvProductPrice.setText(setUnline(product.getPrice()));
            holder.imageCheckLike.setOnClickListener(v-> itemClickListener.onClick(product));
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHodel extends RecyclerView.ViewHolder {
        private final ImageView imageViewProduct;
        private final ImageView imageCheckLike;
        private final TextView tvNew;
        private final TextView tvProductSale;
        private final TextView tvProductName;
        private final TextView tvProductSalePrice;
        private final TextView tvProductPrice;
        public ProductViewHodel(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.imageProduct);
            imageCheckLike = itemView.findViewById(R.id.imageCheckLike);
            tvNew = itemView.findViewById(R.id.tvNew);
            tvProductSale =itemView.findViewById(R.id.tvProcductsale);
            tvProductName = itemView.findViewById(R.id.tvNameProduct);
            tvProductSalePrice = itemView.findViewById(R.id.tvSaleprice);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
        }
    }

    public Filter getFilter() {
        return filter;
    }

    private Filter filter =new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Product> filteredList =new ArrayList<>();
            if(constraint == null ||constraint.length()==0 ||constraint.toString().equals("All")) {
                filteredList.addAll(productList);
            }else {
                String filterPattern =constraint.toString();
                for(Product item : productList){
                    if(item.getCategory().equals(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults filterResults =new FilterResults();
            filterResults.values =filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            products.clear();
            products.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public SpannableString setUnline(Long myText){
        String tam = formatMoney(myText);
        SpannableString spannableString=new SpannableString(tam);
        spannableString.setSpan(new UnderlineSpan(), tam.length()-1, tam.length(), 0);
        return spannableString;
    }
    public SpannableString setLineText(Long myText){
        String tam = formatMoney(myText);
        SpannableString spannableString=new SpannableString(tam);
        spannableString.setSpan(new UnderlineSpan(), tam.length()-1, tam.length(), 0);
        spannableString.setSpan(new StrikethroughSpan(), 0, tam.length(), 0);
        return spannableString;
    }
    public String formatMoney(Long myText){
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(myText)+" đ";
    }

    public void setListDataChange(List<Product> product) {
        Log.d("AAA",products.toString());
        products.clear();
        products.addAll(product);
        Log.d("AAA",products.toString());
        notifyDataSetChanged();
    }

    public void updateUIposition(Product product) {
        Log.d("AAA",products.toString()+"");
        int position = products.indexOf(product);
        Log.d("AAA",position+"");
        notifyItemChanged(position);
    }
    public interface ItemClickListener {
        void onClick(Product product);
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
