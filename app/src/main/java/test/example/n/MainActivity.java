package test.example.n;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {

    TextView txtHeight,txtWeight;
    Spinner spDay, spMonth, spYear;
    String[] months = {"","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    String[] days = {"","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
            "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"
            , "27", "28", "29", "30", "31"};
    String[] years = {"","1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958",
            "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
            "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980",
            "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991",
            "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013",
            "2014", "2015", "2016"};
    ArrayAdapter<String> adapter1;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        txtHeight = findViewById(R.id.txtHeight);
        txtWeight = findViewById(R.id.txtWeight);
        spDay = findViewById(R.id.spDay);
        spMonth = findViewById(R.id.spMonth);
        spYear = findViewById(R.id.spYear);
    }

    private void addEvents() {
        txtHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectHeight();
            }
        });
        txtWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectWeight();
            }
        });
//        btnDOB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                selectDOB();
//            }
//        });
        loadDataDOB();
    }

    private void selectHeight() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.height_dialog);
        dialog.show();

        Button confirm = dialog.findViewById(R.id.btnConfirmHeight);
        Button cancel = dialog.findViewById(R.id.btnCancelHeight);

        final NumberPicker heightPicker = dialog.findViewById(R.id.npHeight);
        heightPicker.setMaxValue(200);
        heightPicker.setMinValue(100);
        heightPicker.setWrapSelectorWheel(true); //lặp liên tục
        heightPicker.setOnValueChangedListener(this);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHeight.setText(String.valueOf(heightPicker.getValue()));
                dialog.dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void selectWeight() {
        final Dialog dialog1 = new Dialog(MainActivity.this);
        dialog1.setContentView(R.layout.weight_dialog);
        dialog1.show();

        Button confirm1 = dialog1.findViewById(R.id.btnConfirmWeight);
        Button cancel1 = dialog1.findViewById(R.id.btnCancelWeight);

        final NumberPicker weightPicker = dialog1.findViewById(R.id.npWeight);
        weightPicker.setMaxValue(150);
        weightPicker.setMinValue(30);
        weightPicker.setWrapSelectorWheel(true);
        weightPicker.setOnValueChangedListener(this);

        confirm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtWeight.setText(String.valueOf(weightPicker.getValue()));
                dialog1.dismiss();
            }
        });

        cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {

    }

    private void loadDataDOB() {
        adapter1 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, days);
        spDay.setAdapter(adapter1);

        adapter2 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, months);
        spMonth.setAdapter(adapter2);

        adapter3 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, years);
        spYear.setAdapter(adapter3);
    }
}

//    private void selectDOB() {
//        //        Calendar calendar = Calendar.getInstance();
//        ////        calendar.setTimeInMillis(System.currentTimeMillis());
//        //        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        //        int year = calendar.get(Calendar.YEAR);
//        //        int month  = calendar.get(Calendar.MONTH);
//        //        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        //
//        //
//        //
//        //        DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
//        //            @Override
//        //            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//        //                calendar.set(Calendar.YEAR,i);
//        //                calendar.set(Calendar.MONTH,i1);
//        //                calendar.set(Calendar.DAY_OF_MONTH,i2);
//        //                btnDOB.setText(dateFormat.format(calendar.getTime()));
//        //            }
//        //        };
//        //
//        final Dialog dialog2 = new Dialog(MainActivity.this);
//        dialog2.setContentView(R.layout.dateofbirth_dialog);
//        dialog2.show();
//
//        Button confirm2 = findViewById(R.id.btnConfirmDOB);
//        Button cancel2 = findViewById(R.id.btnCancelDOB);

//        //day value
//        final NumberPicker dayPicker = dialog2.findViewById(R.id.npDay);
//        dayPicker.setMaxValue(31);
//        dayPicker.setMinValue(1);
//        dayPicker.setWrapSelectorWheel(true);
//        dayPicker.setOnValueChangedListener(this);
//
//        //month value
//        final NumberPicker monthPicker = dialog2.findViewById(R.id.npMonth);
//        monthPicker.setMaxValue(12);
//        monthPicker.setMinValue(1);
//        monthPicker.setWrapSelectorWheel(true);
//        monthPicker.setOnValueChangedListener(this);
//
//        //year value
//        final NumberPicker yearPicker = dialog2.findViewById(R.id.npYear);
//        yearPicker.setMaxValue(1930);
//        yearPicker.setMinValue(2013);
//        yearPicker.setWrapSelectorWheel(true);
//        yearPicker.setOnValueChangedListener(this);
//

//        //
//        //        final Calendar newCalendar = Calendar.getInstance();
//        ////        final DatePickerDialog  datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//        ////            public void onDateSet(DatePicker view, int year, int month, int day) {
//        ////                Calendar newDate = Calendar.getInstance();
//        ////                newDate.set(year, month, day);
//        ////            }
//        ////        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
//        //
//        //
//        //        final DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
//        //                callBack,
//        //                calendar.get(Calendar.YEAR),
//        //                calendar.get(Calendar.MONTH),
//        //                calendar.get(Calendar.DAY_OF_MONTH));
//        //        datePickerDialog.show();
//        //
//                confirm2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
////                        btnDOB.setText(dayPicker+"-" + monthPicker + "-" + yearPicker);
//                    }
//                });
//
//                cancel2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
////                        dialog2.dismiss();
//                    }
//                });
//            }
//    }



