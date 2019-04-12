package com.software.akbar.repeatingfundamentals.Lesson5;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;
import com.software.akbar.repeatingfundamentals.ExerciseFragment;
import com.software.akbar.repeatingfundamentals.R;

import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 */
public class Network_practice extends ExerciseFragment {

    TextView responseView;
    AsyncHttpClient client;
    EditText urlEdit;

    private String urlForTest = "http://192.168.43.246/anettest";
//
    public Network_practice() {
        this.exerciseNumber = "Net";
        this.exerciseTitle = "Net";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_network_practice, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        client = new AsyncHttpClient();
        urlEdit = view.findViewById(R.id.urlEdit);
        responseView = view.findViewById(R.id.responseView);
        view.findViewById(R.id.sendRequestButton).setOnClickListener(this::onSendRequest);

    }

    private void onSendRequest(View view) {
        String url = urlEdit.getText().toString();

        if(url.isEmpty()) return;

        url = "http://" + url;
        responseView.setText("");
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                responseView.setText("Failure!!!");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                responseView.setText(responseString);
                client.cancelAllRequests(true);
            }
        });


    }
}
