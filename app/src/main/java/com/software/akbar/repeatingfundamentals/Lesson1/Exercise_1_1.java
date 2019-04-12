package com.software.akbar.repeatingfundamentals.Lesson1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.software.akbar.repeatingfundamentals.ExerciseFragment;
import com.software.akbar.repeatingfundamentals.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Exercise_1_1 extends ExerciseFragment {


    public Exercise_1_1() {
        // Required empty public constructor
        this.exerciseNumber = "1.1";
        this.exerciseTitle = "Hello World!";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exercise_1_1, container, false);
    }

}
