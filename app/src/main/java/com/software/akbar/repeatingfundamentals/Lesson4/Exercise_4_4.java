package com.software.akbar.repeatingfundamentals.Lesson4;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.software.akbar.repeatingfundamentals.ExerciseFragment;
import com.software.akbar.repeatingfundamentals.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Exercise_4_4 extends ExerciseFragment {

    RecyclerView recyclerView;
    ArrayList<String> mRecyclerWords;
    WordsRecyclerAdapter mRecyclerAdapter;

    public Exercise_4_4(){
        this.exerciseNumber = "4.4";
        this.exerciseTitle = "4.4";
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_4_4, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.floatButton).setOnClickListener(this::onFloatClick);

        recyclerView = view.findViewById(R.id.recyclerView);

        mRecyclerWords = new ArrayList<>();

        mRecyclerAdapter = new WordsRecyclerAdapter(mRecyclerWords);

        recyclerView.setAdapter(mRecyclerAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void onFloatClick(View view) {

        int lastItem = mRecyclerAdapter.getItemCount();

        mRecyclerAdapter.insertItem("Word" + lastItem);

        recyclerView.smoothScrollToPosition(lastItem);
    }

}
