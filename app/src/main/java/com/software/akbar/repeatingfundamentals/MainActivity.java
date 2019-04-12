package com.software.akbar.repeatingfundamentals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    public static final String LESSON_NUMBER = "lesson_number";

    RecyclerView lessonsRecycler;

    private String[] mExercises = {
                                      "Lesson 1",
                                      "Lesson 2",
                                      "Lesson 4",
                                      "Lesson 5"
                                   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lessonsRecycler = findViewById(R.id.lessonsRecycle);

        LessonsRecyclerAdapter lessonsRecyclerAdapter = new LessonsRecyclerAdapter(mExercises);

        lessonsRecyclerAdapter.setOnLessonClickListener(this::onExerciseItemClick);

        lessonsRecycler.setAdapter(lessonsRecyclerAdapter);

        lessonsRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    void onExerciseItemClick(int position){

        switch (position){
            case 0:
                startLessonActivity(LessonActivity.LESSON1);
                break;
            case 1:
                startLessonActivity(LessonActivity.LESSON2);
                break;
            case 2:
                startLessonActivity(LessonActivity.LESSON4);
                break;
            case 3:
                startLessonActivity(LessonActivity.LESSON5);
                break;
        }
    }

    private void startLessonActivity(int lessonNumber) {

        //Is lessonNumber is one of pre defined constants, if not it will generate error
        boolean isLessonConstant = lessonNumber >= LessonActivity.LESSON1 && lessonNumber <= LessonActivity.LESSON12;
        assert  isLessonConstant; //doesn't work

        Intent activityIntent = new Intent(this, LessonActivity.class);
        activityIntent.putExtra(LESSON_NUMBER, lessonNumber);

        startActivity(activityIntent);
    }

}
