package com.software.akbar.repeatingfundamentals.Lesson4;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.software.akbar.repeatingfundamentals.DatePicker;
import com.software.akbar.repeatingfundamentals.ExerciseFragment;
import com.software.akbar.repeatingfundamentals.R;
import com.software.akbar.repeatingfundamentals.TimePicker;

/**
 * A simple {@link Fragment} subclass.
 */
public class Exercise_4_1 extends ExerciseFragment {

    EditText testView;
    Spinner spinner;
    TextView timeDateView;

    public Exercise_4_1() {
        this.exerciseNumber = "4.1";
        this.exerciseTitle = "Using Keyboards, Input Controls, Alerts, and Pickers";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_4_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Init views
        testView =view.findViewById(R.id.experimentEditText);
        spinner = view.findViewById(R.id.spinner);
        timeDateView = view.findViewById(R.id.timeDateView);

        //Init clickable
        view.findViewById(R.id.showButton).setOnClickListener(this::showClick);
        view.findViewById(R.id.calendarButton).setOnClickListener(this::onCalendarClick);
        view.findViewById(R.id.timeButton).setOnClickListener(this::onTimeClick);
        RadioGroup radioGroup =  view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this::onRadioClick);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onSpinnerItemSelected(parent, view, position, id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.spinner_items, android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.practice_ex_4_2_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getActivity(), "You selected " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }

    private void onRadioClick(RadioGroup radioGroup, int i) {
        RadioButton clickedRadio = radioGroup.findViewById(i);
        Toast.makeText(getActivity(), "You have clicked " + clickedRadio.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public void showClick(View view) {
    }

    public void onSpinnerItemSelected(AdapterView<?> parent, View view, int position, long id) {

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

        switch (position){
            case 0:

                alert.setTitle("Number Keyboard");
                alert.setMessage("Number Keyboard available only!");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        testView.setInputType(InputType.TYPE_CLASS_NUMBER);
                    }
                });
                alert.setNegativeButton("Cancel" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        parent.setSelection(1);
                    }
                });
                alert.show();

                break;
            case 1:
                testView.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
        }


    }

    public void onCalendarClick(View view) {

        DatePicker datePicker = new DatePicker();
        datePicker.setOnDateSetListener(this::processDate);
        datePicker.show(getActivity().getSupportFragmentManager(),"datePicker");
    }

    public void onTimeClick(View view) {
        TimePicker timePicker = new TimePicker();
        timePicker.setOnTimeSet(this::processTime);
        timePicker.show(getActivity().getSupportFragmentManager(), "timePicker");
    }

    private void processDate(int year, int month, int day) {
        String yearStr = Integer.toString(year);
        String monthStr = Integer.toString(month);
        String dayStr = Integer.toString(day);

        timeDateView.append(yearStr + "/" + monthStr + "/" + dayStr + " ");
    }

    private void processTime(int hour, int minute) {
        String hourStr  = Integer.toString(hour);
        String minuteStr  = Integer.toString(minute);

        timeDateView.append(hourStr + ":" + minuteStr + " ");
    }

}
