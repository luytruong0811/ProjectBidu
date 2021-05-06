package com.example.projectbidu.Product;

public class Product {
    private final int idProduct;
    private final int imageProduct;
    private boolean like;
    private final String title;
    private final String category;
    private final String price;
    private final String salePrice;
    private final boolean productNew;
    private final Long sale;

    public Product(int idProduct, int imageProduct, boolean like, String title, String category, String price, String salePrice, boolean productNew, Long sale) {
        this.idProduct = idProduct;
        this.imageProduct = imageProduct;
        this.like = like;
        this.title = title;
        this.category = category;
        this.price = price;
        this.salePrice = salePrice;
        this.productNew = productNew;
        this.sale = sale;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getImageProduct() {
        return imageProduct;
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

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public boolean isProductNew() {
        return productNew;
    }

    public Long getSale() {
        return sale;
    }
}
