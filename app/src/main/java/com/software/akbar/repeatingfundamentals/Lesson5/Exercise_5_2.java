package com.software.akbar.repeatingfundamentals.Lesson5;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.software.akbar.repeatingfundamentals.ExerciseFragment;
import com.software.akbar.repeatingfundamentals.Lesson1.Exercise_1_1;
import com.software.akbar.repeatingfundamentals.LessonActivity;
import com.software.akbar.repeatingfundamentals.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class Exercise_5_2 extends ExerciseFragment {

    private ArrayList<Sport> mSports;

    public Exercise_5_2() {
        this.exerciseNumber = "5.2";
        this.exerciseTitle = "Material Design: Lists, Cards and Colors";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_5_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView sportRecycler = view.findViewById(R.id.sportsRecycler);

        mSports = getSports();

        SportsAdapter sportsAdapter = new SportsAdapter(getActivity(), mSports);
        sportsAdapter.setOnSportClickListener(this::onSportClick);


        sportRecycler.setAdapter(sportsAdapter);
        sportRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP|ItemTouchHelper.DOWN|ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT,
                                                                                             ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                int from = viewHolder.getAdapterPosition();
                int to = viewHolder1.getAdapterPosition();

                Collections.swap(mSports, from, to);

                recyclerView.getAdapter().notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                int currentPosition = viewHolder.getLayoutPosition();
                mSports.remove(currentPosition);
                sportRecycler.getAdapter().notifyItemRemoved(currentPosition);
            }
        });

        touchHelper.attachToRecyclerView(sportRecycler);

    }

    private void onSportClick(Sport sport) {
        LessonActivity hostActivity = (LessonActivity) getActivity();

        if(hostActivity == null) return;

        int thisFragmentPosition = this.tabPosition;

        SportsDetail sportsDetailFragment = new SportsDetail();

        sportsDetailFragment.setNews(sport.getNews());
        sportsDetailFragment.setNewsPhoto(sport.getImage());

        hostActivity.swapCurrentFragmentTo(sportsDetailFragment, thisFragmentPosition);
    }

    private ArrayList<Sport> getSports() {
        ArrayList<Sport> sports = new ArrayList<>();

        sports.add(new Sport(getActivity(),"Basketball", "Here is some news!", R.drawable.img_basketball));
        sports.add(new Sport(getActivity(),"Football", "Here is some news!", R.drawable.img_soccer));
        sports.add(new Sport(getActivity(),"Cycling", "Here is some news!", R.drawable.img_cycling));
        sports.add(new Sport(getActivity(),"Badminton", "Here is some news!", R.drawable.img_badminton));
        sports.add(new Sport(getActivity(),"Bowling", "Here is some news!", R.drawable.img_bowling));
        sports.add(new Sport(getActivity(),"Baseball", "Here is some news!", R.drawable.img_baseball));
        sports.add(new Sport(getActivity(),"Golf", "Here is some news!", R.drawable.img_golf));
        sports.add(new Sport(getActivity(),"Running", "Here is some news!", R.drawable.img_running));
        sports.add(new Sport(getActivity(),"Swimming", "Here is some news!", R.drawable.img_swimming));
        sports.add(new Sport(getActivity(),"Table tennis", "Here is some news!", R.drawable.img_tabletennis));
        sports.add(new Sport(getActivity(),"Tennis", "Here is some news!", R.drawable.img_tennis));

        return sports;
    }
}
