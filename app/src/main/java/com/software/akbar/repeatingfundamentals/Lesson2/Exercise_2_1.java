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
public class Exercise_2_1 extends ExerciseFragment {

    private static OnMessageListener mOnMessageListener;

    EditText messageTxt;
    TextView replyView;


    public Exercise_2_1() {
        this.exerciseNumber = "2.1";
        this.exerciseTitle = "Create and Start Activities";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_2_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        messageTxt = view.findViewById(R.id.messageText);
        replyView = view.findViewById(R.id.replyView);
        view.findViewById(R.id.sendButton).setOnClickListener(this::onSendClick);

        Exercise_2_1_2.setOnMessageListener(new OnMessageListener() {
            @Override
            public void receiveMessage(String message) {
                showReply(message);
            }

            @Override
            public int getTabPosition() {
                return tabPosition;
            }
        });
    }

    private void showReply(String s) {
        replyView.setText(s);
    }

    public static void setOnMessageListener(OnMessageListener onMessageListener) {
        mOnMessageListener = onMessageListener;
    }

    public void onSendClick(View view) {
        String msg = messageTxt.getText().toString();

        messageTxt.setText("");

        if(mOnMessageListener == null) return;

        mOnMessageListener.receiveMessage(msg);

        if(getActivity() instanceof LessonActivity){
            LessonActivity hostActivity = (LessonActivity) getActivity();

            hostActivity.setCurrentTab(mOnMessageListener.getTabPosition());
        }
    }


}
