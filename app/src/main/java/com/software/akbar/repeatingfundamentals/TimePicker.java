package com.software.akbar.repeatingfundamentals;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private OnTimeSetListener mOnTimeSet;

    public interface OnTimeSetListener {
        void onTimeSet(int hour, int minute);
    }

    public TimePicker() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(getContext(), this, hour, minute, true);
    }

    public void setOnTimeSet(OnTimeSetListener OnTimeSet) {
        this.mOnTimeSet = OnTimeSet;
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {

        if(this.mOnTimeSet == null) return;

        this.mOnTimeSet.onTimeSet(hourOfDay, minute);
    }
}
