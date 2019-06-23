package com.example.calculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static android.widget.Toast.LENGTH_SHORT;

public class AgeCalculatorActivity extends AppCompatActivity {
    TextView textView_days;
    TextView textView_years;
    TextView textView_months;

    Button buttonAgeSolve;

    Button buttonClear;

    TextView textView_months_birth;
    TextView textView_days_birth;
    EditText edittextDateOfBirth;
    DatePickerDialog picker;
    DatePickerDialog pickerTodaysDate;

    EditText edittextTodayDate;

    DrawerLayout mDrawerLayout;

    TextView textViewAnswer;

    final Calendar myCalendar = Calendar.getInstance();


    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        final Calendar myCalendar = Calendar.getInstance();

        toolbar = findViewById(R.id.toolbar_age);

        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });


        textView_days = findViewById(R.id.txtTitle_3_Value);
        textView_months = findViewById(R.id.txtTitle_2_Value);
        textView_years = findViewById(R.id.txtTitleValue);

        buttonClear = findViewById(R.id.btn_clear);

        ;

        buttonAgeSolve = findViewById(R.id.btn_solve);

        edittextDateOfBirth = findViewById(R.id.edit_input_date_of_birth);
        edittextTodayDate = findViewById(R.id.edit_lower_todays_date);

        edittextTodayDate.setFocusable(false);
        edittextDateOfBirth.setFocusable(false);


        textView_months_birth = findViewById(R.id.txtTitleValue_months);
        textView_days_birth = findViewById(R.id.txtTitle_2_Value_days);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                hideKeyboard(AgeCalculatorActivity.this);
                Intent intent;
                switch (id) {
                    case R.id.nav_basic_calc:
                        intent = new Intent(getApplicationContext(), BasicCalculatorActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_age:
                        intent = new Intent(getApplicationContext(), AgeCalculatorActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_log:
                        intent = new Intent(getApplicationContext(), LogCalculatorActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_sci_calc:
                        intent = new Intent(getApplicationContext(), BasicCalculator2Activity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_unit:
                        intent = new Intent(getApplicationContext(), UnitCalculatorActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_base:
                        intent = new Intent(getApplicationContext(), LogicCalculatorActivity.class);
                        startActivity(intent);
                        break;


                    case R.id.nav_factor_equation:
                        intent = new Intent(getApplicationContext(), FactorialActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_val:
                        intent = new Intent(getApplicationContext(), ValDisActivity.class);
                        startActivity(intent);
                        break;


                    case R.id.nav_permutation:
                        intent = new Intent(getApplicationContext(), PermutationsActivity.class);

                        startActivity(intent);
                        break;

                    case R.id.nav_combination:
                        intent = new Intent(getApplicationContext(), CombinationsActivity.class);

                        startActivity(intent);

                        break;

                }
                return true;
            }
        });

        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);

        edittextDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker.show();
            }
        });
        // date picker dialog
        picker = new DatePickerDialog(AgeCalculatorActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        edittextDateOfBirth.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);

        //getting the actual date from phone
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        String dateToday = sdf.format(myCalendar.getTime());

        edittextTodayDate.setText(dateToday);

        toolbar.setTitle("Age Calculator");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));


        //Enabling user to actually correct the date on phone if automatic date is incorrect

        pickerTodaysDate = new DatePickerDialog(AgeCalculatorActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        edittextTodayDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);


        edittextTodayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerTodaysDate.show();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittextDateOfBirth.setText("");
                edittextTodayDate.setText("");
                hideKeyboard(AgeCalculatorActivity.this);
            }
        });

        buttonAgeSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(AgeCalculatorActivity.this);
                solveAge();
            }
        });


    }

    @SuppressLint("WrongConstant")
    private void solveAge() {

        String DateofBirth = edittextDateOfBirth.getText().toString();
        String TodaysDate = edittextTodayDate.getText().toString();


        String split1[] = TodaysDate.split("/");
        StringBuilder stringBuilder1 = new StringBuilder();
        String yearToday1 = stringBuilder1.append(split1[2]).toString();


        String split2[] = DateofBirth.split("/");
        StringBuilder stringBuilder2 = new StringBuilder();
        String yearToday2 = stringBuilder2.append(split2[2]).toString();

        if (DateofBirth.equals("") || TodaysDate.equals("")) {
            return;
        }



        if (DateofBirth.equals("")) {
            edittextTodayDate.setText("");
            edittextDateOfBirth.setFocusable(true);
            edittextDateOfBirth.setText("");
            Toast.makeText(getApplicationContext(), "Please choose a date of birth", LENGTH_SHORT).show();

            edittextDateOfBirth.setError("Please choose a date of birth");
        } else {
            if (TodaysDate.equals("")) {
                //getting the actual date from phone
                String myFormat = "dd/MM/yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                String dateToday = sdf.format(myCalendar.getTime());

                edittextTodayDate.setText(dateToday);

            }


            //getting the values with regex
            String split[] = TodaysDate.split("/");

            //Using string builder to convert Array to string
            StringBuilder stringBuilder = new StringBuilder();

            String yearToday = stringBuilder.append(split[2]).toString();
            String[] dateParts = TodaysDate.split("/");
            String monthToday = dateParts[1];
            String dayToday = dateParts[0];


            String splitDate[] = DateofBirth.split("/");

            StringBuilder stringBuilderDate = new StringBuilder();


            String yearDate = stringBuilderDate.append(splitDate[2]).toString();


            String monthDate = splitDate[1];
            String dayDate = splitDate[0];

            //TODO: CALCULATE THE AGE AND NEXT DAY OF BIRTH
            //TODO: text

            int months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


            int year1 = Integer.valueOf(yearDate);

            //Assigning the values to the values gotten from the user and setting them to use your algorithm
            int cur_day = Integer.valueOf(dayDate);
            int cur_month = Integer.valueOf(monthDate);
            int cur_year = year1;

            int birth_day = Integer.valueOf(dayToday);
            int birth_month = Integer.valueOf(monthToday);
            int birth_year = Integer.valueOf(yearToday);

            int tpm = 0;
            int tpy = 0;

            if (birth_day > cur_day) {
                cur_month -= 1;
                tpm = 1;
                int temp_month = ((birth_month - 2) + 12) % 12;
                cur_day += months[temp_month];
            }
            if (birth_month > cur_month) {
                cur_year -= 1;
                tpy = 1;
                cur_month += 12;
            }

            //Here am setting the texts which display the age to the values calculated
            textView_days.setText(String.valueOf(cur_day - birth_day));
            textView_months.setText(String.valueOf(cur_month - birth_month));
            textView_years.setText(String.valueOf(cur_year - birth_year));


            //TODO: CALCULATE NEXT DAY OF BIRTH


            //Setting the values of the old calculated age to integer variables
            int day_1 = cur_day - birth_day;
            int month_1 = cur_month - birth_month;
            int year_1 = cur_year - birth_year;
            if (day_1 < 0 || month_1 < 0 || year1 < 0) {

                Toast.makeText(getApplicationContext(), "Birth Date should be before of Current date", LENGTH_SHORT).show();
                return;
            }


            Calendar now = Calendar.getInstance();
            cur_month += tpm;
            now.set(cur_year + tpy, birth_month, birth_day);

            int add = 0;
            if (birth_month == 2 && birth_day == 29) {
                while (now.get(1) % 400 != 0 && (now.get(1) % 100 == 0 || now.get(1) % 4 != 0)) {
                    now.add(1, 1);
                    add += 12;
                }
            }

            int Next_birth_day = 16;
            int Next_birth_month = 06;
            int Cur_day = 06;
            int Cur_month = 06;


            if (Next_birth_day < Cur_day) {
                Next_birth_month -= 1;
                Next_birth_day += 31;
            }
            if (Next_birth_month < Cur_month) {
                Next_birth_month += 12;
            }
            int birth_month_result = add + Next_birth_month - Cur_month;
            int Next_birth_day_result = Next_birth_day - Cur_day;


            textView_days_birth.setText(String.valueOf(Next_birth_day_result));
            textView_months_birth.setText(String.valueOf(birth_month_result));


        }
    }


    //This method the actual date from the phone
    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittextDateOfBirth.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
