package com.example.pro.doyk.Model;

public class UserModel {
    private String displayName;
    private String email;
    private long createdAt;
    public int catPhisMarks = 0;
    public int catGeoMarks = 0;
    public int catRelMarks = 0;
    public int catHisMarks = 0;
    public int catBioMarks = 0;
    public int catCinMarks = 0;
    public int catArtMarks = 0;
    public int catLinMarks = 0;
    public int catSpoMarks = 0;
    public int catTecMarks = 0;
    public int catLitMarks = 0;
    public int catAllMarks = 0;
    public int totalScoreMarks = 0;


    private String mRecipientId;

    public UserModel() {
    }

    public UserModel(String displayName, String email,long createdAt, int catPhisMarks, int catGeoMarks,
                     int catRelMarks, int catHisMarks, int catBioMarks, int catCinMarks, int catArtMarks,
                     int catLinMarks, int catSpoMarks, int catTecMarks, int catLitMarks, int catAllMarks,
                     int totalScoreMarks) {
        this.displayName = displayName;
        this.email = email;
        this.createdAt = createdAt;
        this.catPhisMarks = catPhisMarks;
        this.catGeoMarks = catGeoMarks;
        this.catRelMarks = catRelMarks;
        this.catHisMarks = catHisMarks;
        this.catBioMarks = catBioMarks;
        this.catCinMarks = catCinMarks;
        this.catArtMarks = catArtMarks;
        this.catLinMarks = catLinMarks;
        this.catSpoMarks = catSpoMarks;
        this.catTecMarks = catTecMarks;
        this.catLitMarks = catLitMarks;
        this.catAllMarks = catAllMarks;
        this.totalScoreMarks = totalScoreMarks;
    }

    public int getCatPhisMarks() {
        return catPhisMarks;
    }

    public int getCatGeoMarks() {
        return catGeoMarks;
    }

    public int getCatRelMarks() {
        return catRelMarks;
    }

    public int getCatHisMarks() {
        return catHisMarks;
    }

    public int getCatBioMarks() {
        return catBioMarks;
    }

    public int getCatCinMarks() {
        return catCinMarks;
    }

    public int getCatArtMarks() {
        return catArtMarks;
    }

    public int getCatLinMarks() {
        return catLinMarks;
    }

    public int getCatSpoMarks() {
        return catSpoMarks;
    }

    public int getCatTecMarks() {
        return catTecMarks;
    }

    public int getCatLitMarks() {
        return catLitMarks;
    }

    public int getCatAllMarks() {
        return catAllMarks;
    }

    public int getTotalScoreMarks() {
        return totalScoreMarks;
    }

    public void setTotalScoreMarks(int totalScoreMarks) {
        this.totalScoreMarks = totalScoreMarks;
    }


    public long getCreatedAt() {
        return createdAt;
    }

    private String getUserEmail() {
        //Log.e("user email  ", userEmail);
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRecipientId() {
        return mRecipientId;
    }

    public void setRecipientId(String recipientId) {
        this.mRecipientId = recipientId;
    }
}



