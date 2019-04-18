package com.software.akbar.repeatingfundamentals;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.software.akbar.repeatingfundamentals.Lesson1.Exercise_1_1;
import com.software.akbar.repeatingfundamentals.Lesson1.Exercise_1_2;
import com.software.akbar.repeatingfundamentals.Lesson1.Exercise_1_3;

import com.software.akbar.repeatingfundamentals.Lesson2.Exercise_2_1;
import com.software.akbar.repeatingfundamentals.Lesson2.Exercise_2_1_2;
import com.software.akbar.repeatingfundamentals.Lesson2.Exercise_2_3;
import com.software.akbar.repeatingfundamentals.Lesson4.Exercise_4_1;
import com.software.akbar.repeatingfundamentals.Lesson4.Exercise_4_4;
import com.software.akbar.repeatingfundamentals.Lesson5.Exercise_5_1;
import com.software.akbar.repeatingfundamentals.Lesson5.Exercise_5_2;
import com.software.akbar.repeatingfundamentals.Lesson5.Network_practice;

public class LessonActivity extends AppCompatActivity {

    public static final int LESSON1 = 1;
    public static final int LESSON2 = 2;
    public static final int LESSON3 = 3;
    public static final int LESSON4 = 4;
    public static final int LESSON5 = 5;
    public static final int LESSON6 = 6;
    public static final int LESSON7 = 7;
    public static final int LESSON8 = 8;
    public static final int LESSON9 = 9;
    public static final int LESSON10 = 10;
    public static final int LESSON11 = 11;
    public static final int LESSON12 = 12;

    private ViewPager viewPager;
    ExerciseFragment[] exerciseFragments;
    ExerciseFragmentPagerAdapter exerciseFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        //gets lesson number from intent
        int lesson_number = getIntent().getIntExtra(MainActivity.LESSON_NUMBER, 0);

        //gets all fragments with exercises
        exerciseFragments = this.getExerciseFragments(lesson_number);

        if(exerciseFragments == null) return;

        //init custom toolbar
        Toolbar toolbar = findViewById(R.id.lessonToolbar);
        setSupportActionBar(toolbar);

        //init tab layout
        TabLayout tabLayout = findViewById(R.id.lessonTabLayout);
        //setting tabs and tab titles
        addTabsToLayout(tabLayout, exerciseFragments);

        //init ViewPager's adapter
        exerciseFragmentPagerAdapter = new ExerciseFragmentPagerAdapter(getSupportFragmentManager(), exerciseFragments);

        //init ViewPager
        viewPager = findViewById(R.id.lessonViewPager);
        viewPager.setAdapter(exerciseFragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //on tab click
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    @Override
    public void onBackPressed() {
        boolean hadSwaped = exerciseFragmentPagerAdapter.swapFragmentBack();

        if(!hadSwaped) super.onBackPressed();
    }

    public void swapCurrentFragmentTo(ExerciseFragment newFragment, int currentPosition){
        if(exerciseFragmentPagerAdapter == null) return;

        exerciseFragmentPagerAdapter.swapFragment(newFragment, currentPosition);
    }

    public void swapBackCurrentFragment(){
        exerciseFragmentPagerAdapter.swapFragmentBack();
    }

    public void setCurrentTab(int tabPosition){
        viewPager.setCurrentItem(tabPosition);
    }

    private ExerciseFragment[] getExerciseFragments(int lesson_number) {
        switch (lesson_number){
            case LESSON1:
                return new ExerciseFragment[]{new Exercise_1_1(), new Exercise_1_2(), new Exercise_1_3()};

            case LESSON2:
                return new ExerciseFragment[]{new Exercise_2_1(), new Exercise_2_1_2(), new Exercise_2_3()};

            case LESSON4:
                return new ExerciseFragment[]{new Exercise_4_1(), new Exercise_4_4()};

            case LESSON5:
                return new ExerciseFragment[]{new Exercise_5_1(), new Exercise_5_2(), new Network_practice()};

            default:
                return null;
        }

    }

    private void addTabsToLayout(TabLayout tabLayout, ExerciseFragment[] exerciseFragments) {
        for(int i = 0; i < exerciseFragments.length; i++){
            tabLayout.addTab(tabLayout.newTab().setText(exerciseFragments[i].getExerciseNumber()));
            exerciseFragments[i].setTabPosition(i);
        }

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

}
