package com.biswajitbanik.Diem.Faq;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Omar Faruq on 6/11/2018.
 */

public class FaqGroup extends ExpandableGroup<ChildModel> {
    public FaqGroup(String title, List<ChildModel> items) {
        super(title, items);
    }
}
