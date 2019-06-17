package com.software.akbar.repeatingfundamentals;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class LessonsRecyclerAdapter extends RecyclerView.Adapter<LessonsRecyclerAdapter.LessonHolder> {

    String[] mLessons;

    OnLessonClickListener mOnLessonClickListener;

    interface OnLessonClickListener {
        void onLessonClick(int position);
    }

    public LessonsRecyclerAdapter(String[] lessons){
        this.mLessons = lessons;
    }

    public void setOnLessonClickListener(OnLessonClickListener onLessonClickListener) {
        this.mOnLessonClickListener = onLessonClickListener;
    }

    @NonNull
    @Override
    public LessonHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exercise_recycle_layout, viewGroup, true);

        return new LessonHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonHolder lessonHolder, int i) {
        lessonHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return mLessons.length;
    }

    public class LessonHolder extends RecyclerView.ViewHolder {

        TextView mLessonTextView;

        public LessonHolder(@NonNull View itemView) {
            super(itemView);
            mLessonTextView = itemView.findViewById(R.id.exerciseRecyclerText);
        }

        public void bind(int lessonPosition) {
            this.mLessonTextView.setText(mLessons[lessonPosition]);

            if(mOnLessonClickListener == null) return;

            this.itemView.setOnClickListener(v -> mOnLessonClickListener.onLessonClick(lessonPosition));
        }
    }
}
