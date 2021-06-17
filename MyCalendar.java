package com.example.attendence;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.format.DateFormat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyCalendar extends DialogFragment {
    Calendar calendar = Calendar.getInstance();


    public interface OnCalendarOkClickListner{
        void onClick(int year,int month,int day);
    }
    public OnCalendarOkClickListner onCalenderOkClickListner;

    public void setOnCalenderOkClickListner(OnCalendarOkClickListner onCalenderOkClickListner) {
        this.onCalenderOkClickListner = onCalenderOkClickListner;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return new DatePickerDialog(getActivity(),(((view, year, month, dayOfMonth) -> {
            onCalenderOkClickListner.onClick(year,month,dayOfMonth);
        })),calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
    }
    void setDate(int year,int month,int day)
    {
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,day);
    }
     String getDate()
    {
        return DateFormat.format("dd.MM.yyyy",calendar).toString();
    }
}
