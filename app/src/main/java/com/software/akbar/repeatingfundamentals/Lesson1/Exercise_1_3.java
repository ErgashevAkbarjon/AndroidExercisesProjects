package com.software.akbar.repeatingfundamentals.Lesson1;


import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.software.akbar.repeatingfundamentals.ExerciseFragment;
import com.software.akbar.repeatingfundamentals.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Exercise_1_3 extends ExerciseFragment {


    public Exercise_1_3() {
        // Required empty public constructor
        this.exerciseNumber = "1.3";
        this.exerciseTitle = "Working with TextView Elements";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_1_3, container, false);
    }

}
