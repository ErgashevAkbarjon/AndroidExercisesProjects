package com.software.akbar.repeatingfundamentals;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LessonsRecyclerAdapter extends RecyclerView.Adapter<LessonsRecyclerAdapter.ViewHolder> {

    private String[] mLessons;

    private OnLessonClickListener mOnLessonClickListener = null;

    interface OnLessonClickListener{
        void OnLessonClick(int position);
    }

    public LessonsRecyclerAdapter(String[] lessons){
        this.mLessons = lessons;
    }

    public void setOnLessonClickListener(OnLessonClickListener onLessonClickListener) {
        this.mOnLessonClickListener = onLessonClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exercise_recycle_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        String currentLesson = mLessons[i];

        viewHolder.lessonView.setText(currentLesson);

        if(this.mOnLessonClickListener == null) return;

        final int position = i;

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnLessonClickListener.OnLessonClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLessons.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView lessonView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lessonView = itemView.findViewById(R.id.exerciseRecyclerText);
        }
    }



}
