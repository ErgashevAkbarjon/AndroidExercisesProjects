package com.software.akbar.repeatingfundamentals;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

public class ExerciseFragment extends Fragment {

    protected String exerciseNumber;
    protected String exerciseTitle;
    protected int tabPosition;

    public String getExerciseNumber() {
        return exerciseNumber;
    }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setTabPosition(int position) {
        this.tabPosition = position;
    }

    public int getTabPosition() {
        return this.tabPosition;
    }
}

