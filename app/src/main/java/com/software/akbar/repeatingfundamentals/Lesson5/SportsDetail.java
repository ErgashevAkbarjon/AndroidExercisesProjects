package com.software.akbar.repeatingfundamentals.Lesson5;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.software.akbar.repeatingfundamentals.ExerciseFragment;
import com.software.akbar.repeatingfundamentals.LessonActivity;
import com.software.akbar.repeatingfundamentals.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SportsDetail extends ExerciseFragment {

    private String mNews;
    private int mNewsPhotoRes;

    ImageView sportPhoto;

    public SportsDetail() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sports_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sportPhoto = view.findViewById(R.id.detailNewsPhoto);
        TextView sportNews = view.findViewById(R.id.detailNewsText);

//        Glide.with(view.getContext()).load(this.mNewsPhotoRes).into(sportPhoto);
//        Glide.with(sportPhoto).load(this.mNewsPhotoRes).into(sportPhoto);
        sportPhoto.setImageBitmap(Sport.drawableToBitmap(getContext().getResources(),this.mNewsPhotoRes));

        sportNews.setText(this.mNews);
    }

    public void setNews(String news) {
        this.mNews = news;
    }

    public void setNewsPhotoRes(int newsPhotoRes) {
        this.mNewsPhotoRes = newsPhotoRes;
    }
}
