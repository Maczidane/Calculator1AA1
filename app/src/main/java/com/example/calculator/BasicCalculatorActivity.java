package com.example.calculator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static com.example.calculator.AgeCalculatorActivity.hideKeyboard;

public class BasicCalculatorActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private TextView calculation, answer;

    private DrawerLayout mDrawerLayout;

    String sCalculator = "", sAnswer = "", number_one = "", current_operator = "", prev_ans = "";
    double Result = 0.0, numberOne = 0.0, temp = 0.0;

    NumberFormat format, longFormate;


    Boolean dot_present = false, number_allow = true, root_present = false, invert_allow = true, power_present = false;
    Boolean factorial_present = false, constant_present = false, function_present = false, value_inverted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);


        toolbar = findViewById(R.id.toolbar_age);

        calculation = findViewById(R.id.calculator);
        calculation.setMovementMethod(new ScrollingMovementMethod());



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

        toolbar.setTitle("Basic Calculator");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                hideKeyboard(BasicCalculatorActivity.this);
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

        answer = findViewById(R.id.answer);

        format = new DecimalFormat("#.####");
        longFormate = new DecimalFormat("0.#E0");

    }


    public void onClickNumber(View v) {

        if (number_allow) {
            Button bn = (Button) v;
            sCalculator += bn.getText();
            number_one += bn.getText();
            numberOne = Double.parseDouble(number_one);




                switch (current_operator) {
                    case "":
                        temp = Result + numberOne;
                        sAnswer = format.format(temp).toString();
                        break;
                    case "+":
                        temp = Result + numberOne;
                        sAnswer = format.format(temp).toString();
                        break;
                    case "-":
                        temp = Result - numberOne;
                        sAnswer = format.format(temp).toString();
                        break;
                    case "x":
                        temp = Result * numberOne;
                        sAnswer = format.format(temp).toString();
                        break;
                    case "/":
                        try {
                            temp = Result / numberOne;
                            sAnswer = format.format(temp).toString();
                        } catch (Exception e) {
                            sAnswer = e.getMessage();
                        }

                        break;

                }
                updateCalculator();
            }

    }

    public void onClickOperator(View v) {
        Button ob = (Button) v;
        if (sAnswer != "") {


            if (current_operator != "") {
                char c = getCharfromLast(sCalculator, 2);

                if (c == '+' || c == '-' || c == 'x' || c == '/') {

                    sCalculator = sCalculator.substring(0, sCalculator.length() - 3);
                }

            }

            sCalculator = sCalculator + "\n" + ob.getText() + " ";
            number_one = "";
            Result = temp;
            current_operator = ob.getText().toString();
            updateCalculator();

            dot_present = false;
            number_allow = true;
        }

    }

    private char getCharfromLast(String sCalculator, int i) {
        char c = sCalculator.charAt(sCalculator.length() - i);
        return c;
    }


    public void onClickDot(View v) {
        if (!dot_present) {
            if (number_one.length() == 0) {
                number_one = "0.";
                sCalculator = "0.";
                sAnswer = "0.";
                dot_present = true;
                updateCalculator();
            } else {
                number_one += ".";
                sCalculator += ".";
                sAnswer += ".";
                dot_present = true;
                updateCalculator();
            }
        }
    }


    public void onClickClear(View v) {
        sCalculator = "";
        sAnswer = "";
        current_operator = "";
        number_one = "";
        Result = 0.0;
        prev_ans = "";
        numberOne = 0.0;
        temp = 0.0;
        updateCalculator();
        dot_present = false;
        number_allow = true;

    }

    public void onClickEqual(View v) {

        showResults();
    }

    public void showResults() {
        if (sAnswer != "" && sAnswer != prev_ans) {
            sCalculator += "\n" + sAnswer + "\n------" +
                    "-----\n" + sAnswer + " ";
            number_one = "";
            numberOne = 0.0;
            Result = temp;
            //temp = 0.0;
            prev_ans = sAnswer;
            updateCalculator();

            dot_present = true;
            number_allow = false;
        }
    }

    public void updateCalculator() {
        calculation.setText(sCalculator);
        answer.setText(sAnswer);

    }
    public void cleardata() {
        sCalculator = "";
        sAnswer = "";
        current_operator = "";
        number_one = "";
        //number_two = "";
        prev_ans = "";
        Result = 0.0;
        numberOne = 0.0;
        //numberTwo = 0.0;
        temp = 0.0;
        updateCalculator();
        dot_present = false;
        number_allow = true;
        root_present = false;
        invert_allow = true;
        power_present = false;
        factorial_present = false;
        function_present = false;
        constant_present = false;
        value_inverted = false;
    }

    public void onDotClick(View view) {
        //create boolean dot_present check if dot is present or not.
        if (!dot_present) {
            //check length of numberone
            if (number_one.length() == 0) {
                number_one = "0.";
                sCalculator += "0.";
                sAnswer = "0.";
                dot_present = true;
                updateCalculator();
            } else {
                number_one += ".";
                sCalculator += ".";
                sAnswer += ".";
                dot_present = true;
                updateCalculator();
            }
        }

    }
    public void onClickDelete(View view) {

        if (sAnswer != "") {
            if (getCharfromLast(sCalculator, 1) != ' ') {
                if (number_one.length() < 2 && current_operator != "") {
                    number_one = "";
                    temp = Result;
                    sAnswer = format.format(Result).toString();
                    sCalculator = removechar(sCalculator, 1);
                    updateCalculator();
                } else {
                    switch (current_operator) {
                        case "":
                            if (value_inverted) {
                                sAnswer = sAnswer.substring(1, sAnswer.length());
                                sCalculator = sCalculator.substring(1, sAnswer.length());
                                updateCalculator();
                            }
                            if (sCalculator.length() < 2) {
                                cleardata();
                            } else {
                                if (getCharfromLast(sCalculator, 1) == '.') {
                                    dot_present = false;
                                }
                                number_one = removechar(number_one, 1);
                                numberOne = Double.parseDouble(number_one);
                                temp = numberOne;
                                sCalculator = number_one;
                                sAnswer = number_one;
                                updateCalculator();
                            }
                            break;

                        case "+":
                            if (value_inverted) {
                                numberOne = numberOne * (-1);
                                number_one = format.format(numberOne).toString();
                                temp = Result + numberOne;
                                sAnswer = format.format(temp).toString();
                                removeUtilChar(sCalculator, ' ');
                                sCalculator += number_one;
                                updateCalculator();
                                value_inverted = value_inverted ? false : true;
                            }
                            if (getCharfromLast(sCalculator, 1) == '.') {
                                dot_present = false;
                            }
                            number_one = removechar(number_one, 1);
                            if (number_one.length() == 1 && number_one == ".") {
                                numberOne = Double.parseDouble(number_one);
                            }
                            numberOne = Double.parseDouble(number_one);
                            temp = Result + numberOne;
                            sAnswer = format.format(temp).toString();
                            sCalculator = removechar(sCalculator, 1);
                            updateCalculator();
                            break;

                        case "-":
                            if (value_inverted) {
                                numberOne = numberOne * (-1);
                                number_one = format.format(numberOne).toString();
                                temp = Result - numberOne;
                                sAnswer = format.format(temp).toString();
                                removeUtilChar(sCalculator, ' ');
                                sCalculator += number_one;
                                updateCalculator();
                                value_inverted = value_inverted ? false : true;
                            }
                            if (getCharfromLast(sCalculator, 1) == '.') {
                                dot_present = false;
                            }
                            number_one = removechar(number_one, 1);
                            if (number_one.length() == 1 && number_one == ".") {
                                numberOne = Double.parseDouble(number_one);
                            }
                            numberOne = Double.parseDouble(number_one);
                            temp = Result - numberOne;
                            sAnswer = format.format(temp).toString();
                            sCalculator = removechar(sCalculator, 1);
                            updateCalculator();
                            break;

                        case "x":
                            if (value_inverted) {
                                numberOne = numberOne * (-1);
                                number_one = format.format(numberOne).toString();
                                temp = Result * numberOne;
                                sAnswer = format.format(temp).toString();
                                removeUtilChar(sCalculator, ' ');
                                sCalculator += number_one;
                                updateCalculator();
                                value_inverted = value_inverted ? false : true;
                            }
                            if (getCharfromLast (sCalculator, 1) == '.') {
                                dot_present = false;
                            }
                            number_one = removechar(number_one, 1);
                            if (number_one.length() == 1 && number_one == ".") {
                                numberOne = Double.parseDouble(number_one);
                            }
                            numberOne = Double.parseDouble(number_one);
                            temp = Result * numberOne;
                            sAnswer = format.format(temp).toString();
                            sCalculator = removechar(sCalculator, 1);
                            updateCalculator();
                            break;

                        case "/":
                            try {
                                if (value_inverted) {
                                    numberOne = numberOne * (-1);
                                    number_one = format.format(numberOne).toString();
                                    temp = Result / numberOne;
                                    sAnswer = format.format(temp).toString();
                                    removeUtilChar(sCalculator, ' ');
                                    sCalculator += number_one;
                                    updateCalculator();
                                    value_inverted = value_inverted ? false : true;
                                }
                                if (getCharfromLast(sCalculator, 1) == '.') {
                                    dot_present = false;
                                }
                                number_one = removechar(number_one, 1);
                                if (number_one.length() == 1 && number_one == ".") {
                                    numberOne = Double.parseDouble(number_one);
                                }
                                numberOne = Double.parseDouble(number_one);
                                temp = Result / numberOne;
                                sAnswer = format.format(temp).toString();
                                sCalculator = removechar(sCalculator, 1);
                            } catch (Exception e) {
                                sAnswer = e.getMessage();
                            }
                            updateCalculator();
                            break;
                    }
                }
            }
        }
    }


    public void onModuloClick(View view) {
        if (sAnswer != "" && getCharfromLast(sCalculator, 1) != ' ') {
            sCalculator += "% ";

            switch (current_operator) {
                case "":
                    temp = temp / 100;
                    break;
                case "+":
                    temp = Result + ((Result * numberOne) / 100);
                    break;
                case "-":
                    temp = Result - ((Result * numberOne) / 100);
                    break;
                case "/":
                    try {
                        temp = Result / (numberOne / 100);

                    } catch (Exception e) {
                        sAnswer = e.getMessage();
                    }

                    break;
                case "x":
                    temp = Result * (numberOne / 100);
                    break;
            }
            sAnswer = format.format(temp).toString();
            if (sAnswer.length() > 9) {
                sAnswer = longFormate.format(temp).toString();
            }
            Result = temp;
            //updateCalculator();

            showResults();
        }

    }

    public void onPLusClick(View view) {
        if (sAnswer != "" && getCharfromLast(sCalculator, 1) !=  ' ')
        {
            numberOne = numberOne * (-1);
            number_one = format.format(numberOne).toString();
            switch (current_operator)
            {
                case "":

                    temp = numberOne;
                    sCalculator = number_one;
                    break;
                case "+":

                    temp = Result+numberOne;
                    removeUtilChar(sCalculator, ' ');
                    sCalculator += number_one;
                    break;
                case "-":

                    temp = Result-numberOne;
                    removeUtilChar(sCalculator, ' ');
                    sCalculator += number_one;
                    break;
                case "x":

                    temp = Result-numberOne;
                    removeUtilChar(sCalculator, ' ');
                    sCalculator += number_one;
                    break;
                case "/":

                    try {

                        temp = Result/numberOne;
                        removeUtilChar(sCalculator, ' ');
                        sCalculator += number_one;

                    }catch (Exception e){
                        sAnswer = e.getMessage();
                    }

                    break;

            }

            sAnswer = format.format(temp).toString();
            updateCalculator();
        }

    }

    private void removeUtilChar(String str, char c) {
        char o = getCharfromLast(str, 1);
        if (o != c)
        {
            str = removechar(str, 1);
            sCalculator = str;
            updateCalculator();
            removeUtilChar(str,c);
            
        }


    }

    private String   removechar(String str, int i) {

        char c = str.charAt(str.length() - i);
        if (c == '.' && !dot_present)
        {
            dot_present = false;

        }

        if ( c == ' ')
        {
            return str.substring(0, str.length() - (i - 1));

        }

        return str.substring(0, str.length() - i);
    }
}