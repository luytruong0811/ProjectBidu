package com.example.projectbidu.model;

public class Seller {
    private int idSeller;
    private String userName;
    private int imageSeller;
    private int rankSeller;
    private String category;
    private String hasTag;

    public Seller(int idSeller, String userName, int imageSeller, int rankSeller, String category, String hasTag) {
        this.idSeller = idSeller;
        this.userName = userName;
        this.imageSeller = imageSeller;
        this.rankSeller = rankSeller;
        this.category = category;
        this.hasTag = hasTag;
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

    public String getHasTag() {
        return hasTag;
    }
}
