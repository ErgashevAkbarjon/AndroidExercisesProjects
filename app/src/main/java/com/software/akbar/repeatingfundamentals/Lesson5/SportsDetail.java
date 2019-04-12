package com.software.akbar.repeatingfundamentals.Lesson5;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.software.akbar.repeatingfundamentals.ExerciseFragment;
import com.software.akbar.repeatingfundamentals.LessonActivity;
import com.software.akbar.repeatingfundamentals.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SportsDetail extends ExerciseFragment {

    private String mNews;
    private Bitmap mNewsPhoto;

    public SportsDetail() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sports_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LessonActivity hostActivity = (LessonActivity) getActivity();
        if(hostActivity == null) return;

        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_BACK){
                    hostActivity.swapBackCurrentFragment();
                }
                return false;
            }
        });
    }

    public void setNews(String news) {
        this.mNews = news;
    }

    public void setNewsPhoto(Bitmap newsPhoto) {
        this.mNewsPhoto = newsPhoto;
    }
}
