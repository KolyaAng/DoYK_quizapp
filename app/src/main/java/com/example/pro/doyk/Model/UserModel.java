package com.example.pro.doyk.Model;

public class UserModel {
    private String displayName;
    private String email;
    private long createdAt;
    public int totalScoreMarks = 3;

    private String mRecipientId;

    public UserModel() {
    }

    public UserModel(String displayName, String email,long createdAt,int totalScoreMarks) {
        this.displayName = displayName;
        this.email = email;
        this.createdAt = createdAt;
        this.totalScoreMarks = totalScoreMarks;
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



