package com.software.akbar.repeatingfundamentals;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private OnDateSetListener mOnDateSetListener;

    public interface OnDateSetListener{
        void onDateSet(int year, int month, int day);
    }

    public DatePicker() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getContext(), this, year, month, day);
    }

    public void setOnDateSetListener(OnDateSetListener onDateSetListener) {
        this.mOnDateSetListener = onDateSetListener;
    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {

        if(this.mOnDateSetListener == null) return;

        this.mOnDateSetListener.onDateSet(year, month, dayOfMonth);
    }
}
