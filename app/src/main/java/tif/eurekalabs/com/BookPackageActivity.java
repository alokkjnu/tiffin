package tif.eurekalabs.com;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;

public class BookPackageActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;

    AppCompatButton btnCheckout;

    AppCompatEditText etStartDate;
    AppCompatEditText etEndDate;
    AppCompatEditText etBreakfastTimeSlot;
    AppCompatEditText etLunchTimeSlot;
    AppCompatEditText etDinnerTimeSlot;

    TextView tvBreakfastPrice;
    TextView tvLunchPrice;
    TextView tvDinnerPrice;

    CheckBox cbBreakfast;
    CheckBox cbLunch;
    CheckBox cbDinner;

    String[] listBreakfastTimes = {
            "7:00 - 7:30", "7:30 - 8:00", "8:00 - 8:30", "8:30 - 9:00", "9:00 - 9:30"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_package);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        btnCheckout = (AppCompatButton) findViewById(R.id.btn_checkout);

        etEndDate = (AppCompatEditText) findViewById(R.id.et_enddate);
        etStartDate = (AppCompatEditText) findViewById(R.id.et_startdate);
        etBreakfastTimeSlot = (AppCompatEditText) findViewById(R.id.et_breakfast_timeslot);
        etLunchTimeSlot = (AppCompatEditText) findViewById(R.id.et_lunch_timeslot);
        etDinnerTimeSlot = (AppCompatEditText) findViewById(R.id.et_dinner_timeslot);

        tvBreakfastPrice = (TextView) findViewById(R.id.tv_breakfast_price);
        tvLunchPrice = (TextView) findViewById(R.id.tv_lunch_price);
        tvDinnerPrice = (TextView) findViewById(R.id.tv_dinner_price);

        cbBreakfast = (CheckBox) findViewById(R.id.cb_breakfast);
        cbLunch = (CheckBox) findViewById(R.id.cb_lunch);
        cbDinner = (CheckBox) findViewById(R.id.cb_dinner);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.ic_back_white));

        etStartDate.setOnClickListener(this);
        etBreakfastTimeSlot.setOnClickListener(this);
        etLunchTimeSlot.setOnClickListener(this);
        etDinnerTimeSlot.setOnClickListener(this);

        btnCheckout.setOnClickListener(this);

        cbBreakfast.setOnClickListener(this);
        cbLunch.setOnClickListener(this);
        cbDinner.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_startdate:
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.DialogTheme,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                etStartDate.setText(dayOfMonth + " / " + (monthOfYear + 1) + " / " + year);
                                c.set(year, monthOfYear, dayOfMonth);
                                c.add(Calendar.MONTH, 1);
                                etEndDate.setText(c.get(Calendar.DAY_OF_MONTH) + " / " + (c.get(Calendar.MONTH) + 1) + " / " + c.get(Calendar.YEAR));

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
                break;
            case R.id.et_breakfast_timeslot:
                showTimeSlotsDialog(listBreakfastTimes, etBreakfastTimeSlot);
                break;
            case R.id.et_lunch_timeslot:
                showTimeSlotsDialog(listBreakfastTimes, etLunchTimeSlot);
                break;
            case R.id.et_dinner_timeslot:
                showTimeSlotsDialog(listBreakfastTimes, etDinnerTimeSlot);
                break;
            case R.id.btn_checkout:
                break;
            case R.id.cb_breakfast:
                if (cbBreakfast.isChecked()) {

                } else {

                }
                break;
            case R.id.cb_lunch:
                if (cbLunch.isChecked()) {

                } else {

                }
                break;
            case R.id.cb_dinner:
                if (cbDinner.isChecked()) {

                } else {

                }
                break;
        }
    }

    private void showTimeSlotsDialog(final String[] list, final AppCompatEditText editText) {
        final Dialog dialog = new Dialog(BookPackageActivity.this);
        dialog.setContentView(R.layout.dialog_time_slots);
        dialog.setTitle("Custom Dialog");

        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        ListView lv_time = (ListView) dialog.findViewById(R.id.lv_time);
        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this,
                R.layout.list_item_time_slots, list);
        lv_time.setAdapter(adapter);
        lv_time.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                editText.setText(list[position]);
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
