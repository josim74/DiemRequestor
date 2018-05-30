package com.biswajitbanik.Diem.Task.Repository;

import java.util.List;

/**
 * Created by Omar Faruq on 5/22/2018.
 */

public class QuestionModel {

    private String mTitle;
    private String mQuestion;
    private String mExample;
    private int mTotalCharInAns;
    private List<String> mObjectives;
    private boolean hasPicture;


    public QuestionModel(String mTitle, String mQuestion, String mExample, int mTotalCharInAns, List<String> mObjectives, boolean hasPicture) {
        this.mTitle = mTitle;
        this.mQuestion = mQuestion;
        this.mExample = mExample;
        this.mTotalCharInAns = mTotalCharInAns;
        this.mObjectives = mObjectives;
        this.hasPicture = hasPicture;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public String getmExample() {
        return mExample;
    }

    public void setmExample(String mExample) {
        this.mExample = mExample;
    }

    public int getmTotalCharInAns() {
        return mTotalCharInAns;
    }

    public void setmTotalCharInAns(int mTotalCharInAns) {
        this.mTotalCharInAns = mTotalCharInAns;
    }

    public List<String> getmObjectives() {
        return mObjectives;
    }

    public void setmObjectives(List<String> mObjectives) {
        this.mObjectives = mObjectives;
    }

    public boolean isHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(boolean hasPicture) {
        this.hasPicture = hasPicture;
    }
}
