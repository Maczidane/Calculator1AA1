package com.example.calculator;

import android.app.Activity;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LogCalculatorActivity extends AppCompatActivity {
    private TextView textViewValue;

    private EditText editTextEnterValue;

    private EditText editTextBase;

    private Button buttonCompute;

    private Button buttonClear;

    private Toolbar toolbar;

    private DrawerLayout mDrawerLayout;


    private TextView textViewAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_calculator);

        buttonClear = findViewById(R.id.btn_clear);


        buttonCompute = findViewById(R.id.btn_solve);

        editTextBase = findViewById(R.id.edit_text_base);

        editTextEnterValue = findViewById(R.id.edit_text_value);


        toolbar = findViewById(R.id.toolbar_age);

        textViewAnswer = findViewById(R.id.log_value);

        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);




        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });

        toolbar.setTitle("Log Calculator");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                hideKeyboard(LogCalculatorActivity.this);
                Intent intent;
                switch (id) {
                    case R.id.nav_basic_calc:
                        intent  = new Intent(getApplicationContext(), BasicCalculator2Activity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_age:
                        intent  = new Intent(getApplicationContext(), AgeCalculatorActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_log:
                        intent  = new Intent(getApplicationContext(), LogCalculatorActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_sci_calc:
                        intent = new Intent(getApplicationContext(), BasicCalculatorActivity.class);
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





        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                editTextBase.setText("");
                editTextEnterValue.setText("");
            }
        });


        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                hideKeyboard(LogCalculatorActivity.this);
               solveBase();
            }
        });

    }

    private void solveBase() {

        String value = editTextEnterValue.getText().toString();
        String base = editTextBase.getText().toString();
        if (value.equals("") )
        {
            Toast.makeText(getApplicationContext(),"Value of x  cannot be empty.Please enter a value", Toast.LENGTH_SHORT).show();
            editTextEnterValue.setFocusable(true);
            editTextEnterValue.setError("Value of x  cannot be empty.Please enter a value");
        }
        else if ( base.equals(""))
        {
            editTextBase.setFocusable(true);
            editTextBase.setError("Base cannot be empty.Please enter a value");
            Toast.makeText(getApplicationContext(),"Base cannot be empty.Please enter a value", Toast.LENGTH_SHORT).show();


        }

        else {
            int x = Integer.valueOf(value);
            int y = Integer.valueOf(base);
            logOfBase(y,x);
        }

    }



    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
        {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    public void  logOfBase(int base, int num)
    {
        double z = Math.log(num) / Math.log(base);
        String answer = String.valueOf(z);
        textViewAnswer.setText(answer);


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
