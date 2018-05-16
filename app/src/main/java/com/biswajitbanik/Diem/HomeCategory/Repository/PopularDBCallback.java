package com.biswajitbanik.Diem.HomeCategory.Repository;

import java.util.List;

/**
 * Created by Omar Faruq on 5/15/2018.
 */

public interface PopularDBCallback {

    public void getPopularList(List<CategoryModel> categoryModels);
    public void getRecentJob(List<RecentJobModel> recentJobModels);
}
