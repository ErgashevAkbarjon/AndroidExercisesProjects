package com.software.akbar.repeatingfundamentals.Lesson2;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.software.akbar.repeatingfundamentals.ExerciseFragment;
import com.software.akbar.repeatingfundamentals.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Exercise_2_3 extends ExerciseFragment {

    EditText webTextView;
    EditText locationTextView;
    EditText shareTextView;

    public Exercise_2_3(){
        this.exerciseNumber = "2.3";
        this.exerciseTitle = "Implicit intents";
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_2_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Setting buttons onClicks
        view.findViewById(R.id.webButton).setOnClickListener(this::onWebClick);
        view.findViewById(R.id.locationButton).setOnClickListener(this::onLocationClick);
        view.findViewById(R.id.shareButton).setOnClickListener(this::onShareClick);

        webTextView = view.findViewById(R.id.webText);
        locationTextView = view.findViewById(R.id.locationText);
        shareTextView = view.findViewById(R.id.shareText);

    }


    private void onWebClick(View view) {
        String uriText = webTextView.getText().toString();
        Uri webUri = Uri.parse("http://"+uriText);

        Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);

        startActivity(webIntent);
    }

    private void onLocationClick(View view) {
        String locationText = locationTextView.getText().toString();
        Uri locationUri = Uri.parse("geo:0,0?q="+locationText);

        Intent locationIntent = new Intent(Intent.ACTION_VIEW, locationUri);

        startActivity(locationIntent);
    }

    private void onShareClick(View view) {
        String shareText = shareTextView.getText().toString();

        ShareCompat.IntentBuilder
                .from(getActivity())
                .setChooserTitle("Choose App to share")
                .setType("text/plain")
                .setText(shareText)
                .startChooser();
    }
}
