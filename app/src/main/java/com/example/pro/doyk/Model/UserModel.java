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

//    public int getCompMarksI() {
//        return compMarksI;
//    }
//
//    public void setCompMarksI(int compMarksI) {
//        this.compMarksI = compMarksI;
//    }
//
//    public int getCompMarksE() {
//        return compMarksE;
//    }
//
//    public void setCompMarksE(int compMarksE) {
//        this.compMarksE = compMarksE;
//    }
//
//    public int getHardwareMarksB() {
//        return hardwareMarksB;
//    }
//
//    public void setHardwareMarksB(int hardwareMarksB) {
//        this.hardwareMarksB = hardwareMarksB;
//    }
//
//    public int getHardwareMarksI() {
//        return hardwareMarksI;
//    }
//
//    public void setHardwareMarksI(int hardwareMarksI) {
//        this.hardwareMarksI = hardwareMarksI;
//    }
//
//    public int getHardwareMarksE() {
//        return hardwareMarksE;
//    }
//
//    public void setHardwareMarksE(int hardwareMarksE) {
//        this.hardwareMarksE = hardwareMarksE;
//    }
//
//    public int getOsMarksB() {
//        return osMarksB;
//    }
//
//    public void setOsMarksB(int osMarksB) {
//        this.osMarksB = osMarksB;
//    }
//
//    public int getOsMarksI() {
//        return osMarksI;
//    }
//
//    public void setOsMarksI(int osMarksI) {
//        this.osMarksI = osMarksI;
//    }
//
//    public int getOsMarksE() {
//        return osMarksE;
//    }
//
//    public void setOsMarksE(int osMarksE) {
//        this.osMarksE = osMarksE;
//    }
//
//    public int getFinalMarks() {
//        return finalMarks;
//    }
//
//    public void setFinalMarks(int finalMarks) {
//        this.finalMarks = finalMarks;
//    }

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



