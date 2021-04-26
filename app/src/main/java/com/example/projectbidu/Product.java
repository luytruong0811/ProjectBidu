package com.example.projectbidu;

public class Product {
    private int imageProduct;
    private boolean like;
    private String title;
    private long price;
    private long salePrice;
    private boolean productNew;
    private int sale;

    public Product(int imageProduct, boolean like, String title, long price, long salePrice, boolean productNew, int sale) {
        this.imageProduct = imageProduct;
        this.like = like;
        this.title = title;
        this.price = price;
        this.salePrice = salePrice;
        this.productNew = productNew;
        this.sale = sale;
    }

    public int getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(int imageProduct) {
        this.imageProduct = imageProduct;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(long salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isProductNew() {
        return productNew;
    }

    public void setProductNew(boolean productNew) {
        this.productNew = productNew;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }
}
