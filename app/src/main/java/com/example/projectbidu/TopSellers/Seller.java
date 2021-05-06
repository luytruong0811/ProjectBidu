package com.example.projectbidu.TopSellers;

public class Seller {
    private final int idSeller;
    private final String userName;
    private final int imageSeller;
    private final int rankSeller;
    private final String category;

    public Seller(int idSeller, String userName, int imageSeller, int rankSeller, String category) {
        this.idSeller = idSeller;
        this.userName = userName;
        this.imageSeller = imageSeller;
        this.rankSeller = rankSeller;
        this.category = category;
    }

    public int getIdSeller() {
        return idSeller;
    }

    public String getUserName() {
        return userName;
    }

    public int getImageSeller() {
        return imageSeller;
    }

    public int getRankSeller() {
        return rankSeller;
    }

    public String getCategory() {
        return category;
    }


}
