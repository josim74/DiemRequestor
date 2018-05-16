package com.biswajitbanik.Diem.Location.ViewModel;

/**
 * Created by Omar Faruq on 5/14/2018.
 */

public interface LocationViewModel {
    void hideList();

    void refreshList();

    void showList();

    void setSearchBtnTxt(String text);

    void setSearchEditText(String text);

    void searchETLostFocus();

    void drawMap(double latitude, double longitude);

    String getSearchBtnText();

    void openHomeActivity();

    void hideKeypad();
}
