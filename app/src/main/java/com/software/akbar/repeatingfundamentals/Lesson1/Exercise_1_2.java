package com.software.akbar.repeatingfundamentals.Lesson1;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.software.akbar.repeatingfundamentals.ExerciseFragment;
import com.software.akbar.repeatingfundamentals.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Exercise_1_2 extends ExerciseFragment {

    TextView textView;

    public Exercise_1_2() {
        // Required empty public constructor
        this.exerciseNumber = "1.2";
        this.exerciseTitle = "Make Your First Interactive UI";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exercise_1_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //setting buttons onClick
        view.findViewById(R.id.fragmentToastButton).setOnClickListener(this::toastClick);
        view.findViewById(R.id.fragmentCountButton).setOnClickListener(this::countClick);

        textView = view.findViewById(R.id.fragmentCountView);
    }

    public void toastClick(View view){
        Toast.makeText(getContext(), "Hello toast!", Toast.LENGTH_SHORT).show();
    }

    public void countClick(View view){
        int currentValue = Integer.parseInt(textView.getText().toString());
        currentValue++;
        textView.setText(Integer.toString(currentValue));
    }

}
