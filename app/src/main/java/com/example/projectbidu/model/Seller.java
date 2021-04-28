package com.example.projectbidu.model;

public class Seller {
    private String userName;
    private int imageSeller;
    private int rankSeller;
    private String hasTag;

    public Seller(String userName, int imageSeller, int rankSeller, String hasTag) {
        this.userName = userName;
        this.imageSeller = imageSeller;
        this.rankSeller = rankSeller;
        this.hasTag = hasTag;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getImageSeller() {
        return imageSeller;
    }

    public void setImageSeller(int imageSeller) {
        this.imageSeller = imageSeller;
    }

    public int getRankSeller() {
        return rankSeller;
    }

    public void setRankSeller(int rankSeller) {
        this.rankSeller = rankSeller;
    }

    public String getHasTag() {
        return hasTag;
    }

    public void setHasTag(String hasTag) {
        this.hasTag = hasTag;
    }
}
