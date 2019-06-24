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
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.calculator.AgeCalculatorActivity.hideKeyboard;

public class LogicCalculatorActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Toolbar toolbar;

    private DrawerLayout mDrawerLayout;

    private Spinner spinnerFrom;

    private TextView textViewResult;

    private Button buttonClear;

    private Button buttonSolve;

    /* renamed from: a */
    private Button f22a;
    /* renamed from: b */
    private Button f23b;
    /* renamed from: c */
    private Button f24c;
    /* renamed from: d */
    private Button f25d;
    private ImageButton delete;
    private Button dot;
    int dotcheck;
    /* renamed from: e */
    private Button f26e;
    private Button eight;
    /* renamed from: f */
    private Button f27f;
    private Button five;
    private Button four;
    private int fractionsLength;
    private EditText input;
    private int inputbase;








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



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });

        toolbar.setTitle("Base Calculator");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onClick(View v) {

    }
}












