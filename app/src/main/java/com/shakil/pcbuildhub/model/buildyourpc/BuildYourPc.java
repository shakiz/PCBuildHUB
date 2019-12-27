package com.shakil.pcbuildhub.model.buildyourpc;

public class BuildYourPc {
    public String Title;
    public String PostDate;
    public String Category;
    public int TotalAmount;

    public BuildYourPc(String title, String postDate, String category, int totalAmount) {
        Title = title;
        PostDate = postDate;
        Category = category;
        TotalAmount = totalAmount;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPostDate() {
        return PostDate;
    }

    public void setPostDate(String postDate) {
        PostDate = postDate;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        TotalAmount = totalAmount;
    }
}
