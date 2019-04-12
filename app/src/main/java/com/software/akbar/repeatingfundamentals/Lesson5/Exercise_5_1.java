package com.software.akbar.repeatingfundamentals.Lesson5;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.software.akbar.repeatingfundamentals.ExerciseFragment;
import com.software.akbar.repeatingfundamentals.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Exercise_5_1 extends ExerciseFragment {

    TextView countView1;
    TextView countView2;

    private final String SCORE1 = "1";
    private final String SCORE2 = "2";

    public Exercise_5_1() {
        this.exerciseNumber = "5.1";
        this.exerciseTitle = "Drawables, Styles, and Themes";
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.ex_5_1_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int nightMode = AppCompatDelegate.getDefaultNightMode();

        if(nightMode == AppCompatDelegate.MODE_NIGHT_NO){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            item.setTitle(R.string.day_mode);
            this.onCreate(null);
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            item.setTitle(R.string.night_mode);
            this.onCreate(null);
        }

        return true;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SCORE1, Integer.parseInt(countView1.getText().toString()));
        outState.putInt(SCORE2, Integer.parseInt(countView2.getText().toString()));
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_5_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.plusButton1).setOnClickListener(this::onPlusClick);
        view.findViewById(R.id.minusButton1).setOnClickListener(this::onMinusClick);
        view.findViewById(R.id.plusButton2).setOnClickListener(this::onPlusClick);
        view.findViewById(R.id.minusButton2).setOnClickListener(this::onMinusClick);

        countView1 = view.findViewById(R.id.countView1);
        countView2 = view.findViewById(R.id.countView2);

        if(savedInstanceState != null){

            int score1 = savedInstanceState.getInt(SCORE1);
            int score2 = savedInstanceState.getInt(SCORE2);

            countView1.setText(String.valueOf(score1));
            countView2.setText(String.valueOf(score2));
        }
    }

    private void onPlusClick(View view) {
        switch (view.getId()){
            case R.id.plusButton1:
                increaseCountOn(countView1);
                break;
            case R.id.plusButton2:
                increaseCountOn(countView2);
                break;
        }
    }

    private void increaseCountOn(TextView countView) {
        countOn(countView, true);
    }

    private void onMinusClick(View view) {
        switch (view.getId()){
            case R.id.minusButton1:
                decreaseCountOn(countView1);
                break;
            case R.id.minusButton2:
                decreaseCountOn(countView2);
                break;
        }
    }


    private void decreaseCountOn(TextView countView) {
        countOn(countView, false);
    }

    private void countOn(TextView countView, boolean toIncrease) {
        int counter = Integer.parseInt(countView.getText().toString());
        if (toIncrease) {
            counter++;
        } else {
            counter--;
        }
        countView.setText(String.valueOf(counter));
    }

}
