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


import java.math.BigInteger;

public class PermutationsActivity extends AppCompatActivity {


    private Toolbar toolbar;

    private EditText editTextC, editTextK;

    private Button buttonSolve, buttonClear;

    private TextView textViewAnswer;


    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permutations);

        editTextC = findViewById(R.id.c);

        editTextK = findViewById(R.id.K);

        buttonClear = findViewById(R.id.btn_clear);

        buttonSolve = findViewById(R.id.btn_solve);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        textViewAnswer = findViewById(R.id.answer);



        toolbar = findViewById(R.id.toolbar_age);

        setSupportActionBar(toolbar);



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle("Permutation");


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                hideKeyboard(PermutationsActivity.this);
                Intent intent;
                switch (id) {
                    case R.id.nav_basic_calc:
                        intent  = new Intent(getApplicationContext(), BasicCalculatorActivity.class);
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


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(PermutationsActivity.this);
                editTextC.setText("");
                editTextK.setText("");
                textViewAnswer.setText("00");
            }
        });


        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(PermutationsActivity.this);
                solveEquation();
            }
        });


    }

    private void solveEquation() {

        String c = editTextC.getText().toString();
        String k = editTextK.getText().toString();
        if (c.equals("")) {
            editTextC.setText("");
            editTextK.setText("");
            editTextC.setFocusable(true);
            editTextC.setError("Please enter the Value of C");

        } else if (k.equals("")) {

            editTextC.setText("");
            editTextK.setText("");
            editTextK.setError("Please enter the Value of K");
            editTextK.setFocusable(true);


        } else {

            int C1 = Integer.valueOf(c);
            int K1 = Integer.valueOf(k);




            BigInteger answer;

            answer = factorial(C1).divide(factorial(C1-K1));

            //double answer = (factorial(C1)/ ( factorial(C1-K1)));

            String Answer = String.valueOf(answer);

            textViewAnswer.setText(Answer);


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


    public double factorialFirst(int x) {
        int i, fact = 1;
        int number = x;//It is the number to calculate factorial
        for (i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;

    }

    public BigInteger factorial(int x) {
        int i;
        BigInteger fact = new BigInteger("1"); // Or BigInteger.ONE
        int number = x;//It is the number to calculate factorial
        for (i = 1; i <= number; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}
