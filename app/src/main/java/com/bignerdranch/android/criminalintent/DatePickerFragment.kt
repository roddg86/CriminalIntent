package com.bignerdranch.android.criminalintent

import android.app.DatePickerDialog
import android.app.Dialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import java.util.*
import java.util.Calendar.*

private const val ARG_DATE = "date"

class DatePickerFragment : DialogFragment() {
    /* Создание интерфейса обратного вызова */
    interface Callbacks {
        fun onDateSelected(date: Date)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val date = arguments?.getSerializable(ARG_DATE) as Date
        val calendar = getInstance()
        calendar.time = date
        val calendarHour = calendar.get(HOUR_OF_DAY)
        val calendarMinute = calendar.get(MINUTE)

        val dateListener =
            DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, month: Int, day: Int ->
                val resultDate: Date =
                    GregorianCalendar(year, month, day, calendarHour, calendarMinute).time

                targetFragment?.let { fragment ->
                    (fragment as Callbacks).onDateSelected(resultDate)
                }
            }

        val initialYear = calendar.get(YEAR)
        val initialMonth = calendar.get(MONTH)
        val initialDay = calendar.get(DAY_OF_MONTH)

        return DatePickerDialog(
            requireContext(),
            dateListener,
            initialYear,
            initialMonth,
            initialDay
        )
    }

    companion object {
        fun newInstance(date: Date): DatePickerFragment {
            val args = Bundle().apply {
                putSerializable(ARG_DATE, date)
            }
            return DatePickerFragment().apply {
                arguments = args
            }
        }
    }
}