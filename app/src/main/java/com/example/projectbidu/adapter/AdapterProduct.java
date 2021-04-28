package com.example.projectbidu.adapter;

import android.content.Context;

import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectbidu.R;
import com.example.projectbidu.model.Product;

import java.text.DecimalFormat;
import java.util.List;



public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ProductViewHodel> {

    private List<Product> mListProduct;
    private ItemClickListener itemClickListener;


    public AdapterProduct(List<Product> mListProduct,ItemClickListener itemClickListener) {
        this.mListProduct = mListProduct;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ProductViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent,false);
        return new ProductViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHodel holder, int position) {
        Product product =mListProduct.get(position);
        if(product == null )
            return;
        else{
            holder.imageViewProduct.setImageResource(product.getImageProduct());
            if(product.isLike()){
                holder.imageCheckLike.setImageResource(R.drawable.ic_favorite_icon);
            }else{
                holder.imageCheckLike.setImageResource(R.drawable.ic_favorite_icon__stroke_);
            }
            if(!product.isProductNew()){
                holder.tvNew.setVisibility(View.GONE);
            }
            if(product.getSale() == null){
                holder.tvProductSale.setVisibility(View.GONE);
            }else{
                holder.tvProductSale.setText(product.getSale()+"%");
            }
            holder.tvProductName.setText(product.getTitle());
            if(product.getSalePrice()==null){
                holder.tvProductSalePrice.setText("");
            }else {
                holder.tvProductSalePrice.setText(setLineText(product.getPrice()));
            }
            holder.tvProductPrice.setText(setUnline(product.getPrice()));
            holder.imageCheckLike.setOnClickListener(v->{
                itemClickListener.onClick(position);
            });
        }
    }

    @Override
    public int getItemCount() {
        return mListProduct.size();
    }

    public class ProductViewHodel extends RecyclerView.ViewHolder {
        private ImageView imageViewProduct;
        private ImageView imageCheckLike;
        private TextView tvNew;
        private TextView tvProductSale;
        private TextView tvProductName;
        private TextView tvProductSalePrice;
        private TextView tvProductPrice;
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
    public interface ItemClickListener {
        void onClick(int position);
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
