package com.example.calculator;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.calculator.PermutationsActivity.hideKeyboard;


public class ValDisActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textViewDis;

    private TextView textViewVat;
    private TextView textViewTitle;

    RadioButton radioButtonVat;
    RadioButton radioButtonDis;

    RadioGroup radioGroup;

    DrawerLayout mDrawerLayout;

    private EditText editTextOri;

    private EditText editTextPerc;

    Button buttonSolve;

    Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_val_dis);

        toolbar = findViewById(R.id.toolbar_age);

        buttonClear = findViewById(R.id.btn_clear);

        radioGroup = findViewById(R.id.radioGroup);
        textViewTitle = findViewById(R.id.Title);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        buttonSolve = findViewById(R.id.btn_solve);

        editTextOri = findViewById(R.id.edit_text_original);
        editTextPerc = findViewById(R.id.edit_text_discount);


        radioButtonDis = findViewById(R.id.radioButtonDiscount);

        radioButtonVat = findViewById(R.id.radioButtonVat);

       //radioButtonVat.setChecked(true);



        textViewDis = findViewById(R.id.dis_value);

        textViewVat = findViewById(R.id.vat_value);

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextOri.setText("");
                editTextPerc.setText("");
            }
        });

        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(ValDisActivity.this);
                solveEquation();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioButtonVat.isChecked()) {

                    textViewTitle.setText("Total Vat:");
                }
                if (radioButtonDis.isChecked())
                {
                    textViewTitle.setText("Total Discount:");
                }
                textViewDis.setText("");
                textViewVat.setText("");
            }
        });

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });

        toolbar.setTitle("Vat/Discount Calculator");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                hideKeyboard(ValDisActivity.this);
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

    }

    private void solveEquation() {
        String ori = editTextOri.getText().toString();
        String pec = editTextPerc.getText().toString();

        if (ori.equals(""))
        {
            editTextPerc.setText("");
            editTextOri.setText("");
            editTextOri.setError("Please enter the original amount");
            editTextOri.setFocusable(true);
            Toast.makeText(getApplicationContext(),"Original amount cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else if(pec.equals(""))
        {
            editTextPerc.setText("");
            editTextOri.setText("");
            editTextOri.setError("Please enter a percentage discount");
            editTextOri.setFocusable(true);
            Toast.makeText(getApplicationContext(),"Percentage discount cannot be empty", Toast.LENGTH_SHORT).show();
        }

        else{

            if (radioButtonVat.isChecked())
            {
                int x = Integer.valueOf(ori);
                int y = Integer.valueOf(pec);

                if (x >= 0 && y <= 100) {

                   double Vat = (x * y) /100;
                   String vat = String.valueOf(Vat);
                   textViewVat.setText(vat);

                   double Amount =  x + Vat;

                   String amount = String.valueOf(Amount);

                   textViewDis.setText(amount);


                }
                else {

                    Toast.makeText(this, "Vat must be in between 0 to 100 %",
                            Toast.LENGTH_LONG).show();
                }
            }

            else{

               int x1 = Integer.valueOf(ori);
                int y1 = Integer.valueOf(pec);

                if (x1 >= 0 && y1 <= 100) {
                    double savedprice = (y1 / 100.0) * x1;
                    double finalprice = x1 - savedprice;

                    String svdPrice = String.valueOf(savedprice);
                    textViewVat.setText(svdPrice);

                    String disprice = String.valueOf(finalprice);
                    textViewDis.setText(disprice);
                }
                 else {

                    Toast.makeText(this, "Discount must be in between 0 to 100 %",
                            Toast.LENGTH_LONG).show();
                }

            }



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
}
