package com.software.akbar.repeatingfundamentals.Lesson2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.software.akbar.repeatingfundamentals.ExerciseFragment;
import com.software.akbar.repeatingfundamentals.LessonActivity;
import com.software.akbar.repeatingfundamentals.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Exercise_2_1_2 extends ExerciseFragment {

    private static OnMessageListener mOnMessageListener;

    EditText replyText;
    TextView messageView;

    public Exercise_2_1_2() {
        this.exerciseNumber = "2.1.2";
        this.exerciseTitle = "Create and Start Activities";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_2_1_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        replyText = view.findViewById(R.id.replyText);
        messageView = view.findViewById(R.id.messageView);
        view.findViewById(R.id.replyButton).setOnClickListener(this::onReplyClick);

        Exercise_2_1.setOnMessageListener(new OnMessageListener() {
            @Override
            public void receiveMessage(String message) {
                showMessage(message);
            }

            @Override
            public int getTabPosition() {
                return tabPosition;
            }
        });
    }

    public static void setOnMessageListener(OnMessageListener onReplyListener) {
        mOnMessageListener = onReplyListener;
    }

    private void showMessage(String s) {
        messageView.setText(s);
    }

    public void onReplyClick(View view) {
        String reply = replyText.getText().toString();

        replyText.setText("");

        if(mOnMessageListener == null) return;

        mOnMessageListener.receiveMessage(reply);

        if(getActivity() instanceof LessonActivity){
            LessonActivity hostActivity = (LessonActivity) getActivity();

            hostActivity.setCurrentTab(mOnMessageListener.getTabPosition());
        }
    }


}
