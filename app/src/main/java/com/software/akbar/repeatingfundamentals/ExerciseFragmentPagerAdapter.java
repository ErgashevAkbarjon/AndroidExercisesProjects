package com.software.akbar.repeatingfundamentals;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ExerciseFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private ExerciseFragment mExerciseFragments[];
    private ExerciseFragment mChangedFragment;

    public ExerciseFragmentPagerAdapter(FragmentManager fm, ExerciseFragment[] exerciseFragments){
        super(fm);
        this.mExerciseFragments = exerciseFragments.clone();
    }

    @Override
    public int getCount() {
        return this.mExerciseFragments.length;
    }

    @Override
    public Fragment getItem(int i) {
        return this.mExerciseFragments[i];
    }

    @Override
    public int getItemPosition(@NonNull Object object) {

        boolean changedFragmentExists = mChangedFragment != null;
        boolean sameObjectAsCurrent = object.getClass().equals(mChangedFragment.getClass());

        if(changedFragmentExists && sameObjectAsCurrent){
            return POSITION_NONE;
        }

        return super.getItemPosition(object);
    }


    public void swapFragment(ExerciseFragment newFragment, int currentPosition){
        if(this.mExerciseFragments == null) return;

        mChangedFragment = mExerciseFragments[currentPosition];

        this.mExerciseFragments[currentPosition] = newFragment;

        notifyDataSetChanged();
    }

    public boolean swapFragmentBack() {
        if(this.mChangedFragment == null) return false;

        int changedFragmentPosition = mChangedFragment.getTabPosition();
        ExerciseFragment temp =  mExerciseFragments[changedFragmentPosition];

        this.mExerciseFragments[changedFragmentPosition] = mChangedFragment;
        mChangedFragment = temp;

        notifyDataSetChanged();
        return true;
    }
}
