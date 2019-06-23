package com.example.calculator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.calculator.AgeCalculatorActivity.hideKeyboard;

public class LogicCalculatorActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private DrawerLayout mDrawerLayout;

    private Spinner spinnerFrom;

    private TextView textViewResult;

    private Button buttonClear;

    private Button buttonSolve;


    private static final String[] paths = {"From", "DEC", "HEX", "BIN", "OCT",};
    private static final String[] path = {"From", "DEC", "HEX", "BIN", "OCT",};

    private Spinner spinnerTo;

    private EditText editTextValue;

    float another;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_calculator);

        toolbar = findViewById(R.id.toolbar_age);

        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        buttonClear = findViewById(R.id.btn_clear);

        buttonSolve = findViewById(R.id.btn_solve);

        editTextValue = findViewById(R.id.edit_value);
        textViewResult = findViewById(R.id.TitleAnswer);

        spinnerTo = findViewById(R.id.simpleSpinnerTo);

        ArrayAdapter<String> to = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paths);
        to.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerTo.setAdapter(to);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });

        spinnerFrom = findViewById(R.id.simpleSpinnerFrom);

        toolbar.setTitle("Base Calculator");

        ArrayAdapter<String> from = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paths);
        from.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //Setting the ArrayAdapter data on the Spinner

        spinnerFrom.setAdapter(from);


        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextValue.setText("");
                textViewResult.setText("0.0");


            }
        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                hideKeyboard(LogicCalculatorActivity.this);
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


        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp1 = spinnerFrom.getSelectedItem().toString();
                String temp2 = spinnerTo.getSelectedItem().toString();
                String value = editTextValue.getText().toString();




                if (temp1.equals("From") || temp2.equals("To")) {

                    Toast.makeText(getApplicationContext(), "Please choose a From and To", Toast.LENGTH_LONG).show();

                } else if (value.equals("")) {
                    editTextValue.setText("");
                    editTextValue.setError("Please enter a value to convert");
                    editTextValue.setFocusable(true);
                }


                else {

                    if (temp1.equals("DEC")) {
                        if (!value.contains("."))
                        {
                            value = value +".0";
                            another = Float.valueOf(value);


                        }


                        if (temp2.equals("HEX")) {

                            Double d = Double.parseDouble(value);

                            long lng = Double.doubleToLongBits(d);

                            String t = Float.toHexString(another);

                            //long y = Integer.parseInt(value,16);
                            textViewResult.setText(t);

                        } else if (temp2.equals("BIN")) {




                            int y = Float.floatToIntBits(another);
                            textViewResult.setText(String.valueOf(y));

                        } else if (temp2.equals("OCT")) {

                            int x = Float.floatToIntBits(another);

                            String y = Integer.toOctalString(x);
                            textViewResult.setText(y);

                        } else {
                            Toast.makeText(getApplicationContext(), "Cannot convert from DEC to DEC", Toast.LENGTH_SHORT).show();
                            textViewResult.setText("");
                        }


                    }
                    else if (temp1.equals("HEX")) {

                        if (TestHex(value))
                        {
                            if (temp2.equals("DEC")) {

                                textViewResult.setText(Integer.parseInt(value, 16));

                            } else if (temp2.equals("BIN")) {


                                String y = Integer.toHexString(Integer.parseInt(value));
                                textViewResult.setText(y);

                            } else if (temp2.equals("OCT")) {


                                String y = Integer.toOctalString(Integer.parseInt(value));
                                textViewResult.setText(y);

                            } else {
                                Toast.makeText(getApplicationContext(), "Cannot convert from HEX to HEX", Toast.LENGTH_SHORT).show();
                                textViewResult.setText("");
                            }
                        }
                        else{

                            Toast.makeText(getApplicationContext(),"The value entered is no a valid HEX number .Please change value entered",Toast.LENGTH_SHORT).show();
                        }




                    }
                    else if (temp1.equals("BIN")) {

                        if (value.matches("[01]+") && !value.startsWith("0")) {

                            if (temp2.equals("HEX")) {


                                int y = Integer.parseInt(value, 16);
                                textViewResult.setText(String.valueOf(y));

                            } else if (temp2.equals("DEC")) {


                                int y = Integer.parseInt(value, 2);
                                textViewResult.setText(String.valueOf(y));

                            } else if (temp2.equals("OCT")) {


                                int bnum = Integer.parseInt(value, 2);
                                String ostr = Integer.toOctalString(bnum);
                                textViewResult.setText(ostr);

                            } else {
                                Toast.makeText(getApplicationContext(), "Cannot convert from BIN to BIN", Toast.LENGTH_SHORT).show();
                                textViewResult.setText("");
                            }

                        }else{
                            Toast.makeText(getApplicationContext(),"The value entered is no a  valid BIN number .Please change value entered",Toast.LENGTH_SHORT).show();

                        }


                    }
                    else if (temp1.equals("OCT")) {

                        try {

                            if (temp2.equals("HEX")) {


                                String hex_num;
                                int decnum;

                                decnum = Integer.parseInt(value, 8);
                                hex_num = Integer.toHexString(decnum);


                                textViewResult.setText(hex_num);

                            } else if (temp2.equals("DEC")) {


                                int decimal = Integer.parseInt(value, 8);
                                textViewResult.setText(String.valueOf(decimal));

                            } else if (temp2.equals("BIN")) {

                                int i = Integer.parseInt(value, 8);
                                String binary = Integer.toBinaryString(i);
                                textViewResult.setText(binary);

                            } else {
                                Toast.makeText(getApplicationContext(), "Cannot convert from OCT to OCT", Toast.LENGTH_SHORT).show();
                                textViewResult.setText("");
                            }

                        }catch (NumberFormatException e)
                        {
                            Toast.makeText(getApplicationContext(),"The value entered is no a  valid OCT number .Please change value entered",Toast.LENGTH_SHORT).show();
                        }
                    }


                }

            }

        });


    }

    private boolean TestHex(String value) {
        boolean ret;
        try {
            int t = Integer.parseInt(value, 16);
            ret = true;
        } catch (NumberFormatException e) {
            ret = false;
        }
        return (ret);
    }


}












