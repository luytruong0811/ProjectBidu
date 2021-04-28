package com.example.projectbidu.model;

public class Product {
    private int imageProduct;
    private boolean like;
    private String title;
    private String category;
    private Long price;
    private Long salePrice;
    private boolean productNew;
    private Long sale;

    public Product(int imageProduct, boolean like, String title, String category, Long price, Long salePrice, boolean productNew, Long sale) {
        this.imageProduct = imageProduct;
        this.like = like;
        this.title = title;
        this.category = category;
        this.price = price;
        this.salePrice = salePrice;
        this.productNew = productNew;
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Product{" +
                "imageProduct=" + imageProduct +
                ", like=" + like +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", salePrice=" + salePrice +
                ", productNew=" + productNew +
                ", sale=" + sale +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isProductNew() {
        return productNew;
    }

    public void setProductNew(boolean productNew) {
        this.productNew = productNew;
    }

    public Long getSale() {
        return sale;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }
}