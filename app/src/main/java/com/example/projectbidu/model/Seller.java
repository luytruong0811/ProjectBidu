package com.example.projectbidu.model;

public class Seller {
    private final int idSeller;
    private final String userName;
    private final int imageSeller;
    private final int rankSeller;
    private final String category;
    private final String hasTag;

    public Seller(int idSeller, String userName, int imageSeller, int rankSeller, String category, String hasTag) {
        this.idSeller = idSeller;
        this.userName = userName;
        this.imageSeller = imageSeller;
        this.rankSeller = rankSeller;
        this.category = category;
        this.hasTag = hasTag;
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

    public int getIdSeller() {
        return idSeller;
    }
}
