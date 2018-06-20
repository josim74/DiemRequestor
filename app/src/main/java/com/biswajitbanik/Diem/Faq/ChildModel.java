package com.biswajitbanik.Diem.Faq;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Omar Faruq on 6/11/2018.
 */

@SuppressLint("ParcelCreator")
public class ChildModel implements Parcelable {

    private String mText;


    public ChildModel(String mText) {
        this.mText = mText;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
