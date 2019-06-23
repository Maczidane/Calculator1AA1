package com.example.calculator;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.example.calculator.AgeCalculatorActivity.hideKeyboard;

public class UnitCalculatorActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private DrawerLayout mDrawerLayout;

    private CardView cardViewTime, cardViewLength,cardViewMemory,cardViewVolume, cardViewAngle,cardViewWeight,cardViewTemperature,cardViewArea;

    private TextView textViewLength, textViewWeight, textViewMemory, textViewVolume,textViewAngle,textViewTime,textViewTemperature,textViewArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_calculator);



        toolbar = findViewById(R.id.toolbar_age);
        textViewAngle = findViewById(R.id.textViewBasic_4);
        textViewArea = findViewById(R.id.textViewBasic_2);
        textViewLength = findViewById(R.id.textViewBasic_1);
        textViewTemperature = findViewById(R.id.textViewBasic_8);
        textViewWeight = findViewById(R.id.textViewBasic_3);
        textViewMemory = findViewById(R.id.textViewBasic_7);
        textViewTime = findViewById(R.id.textViewBasic_6);
        textViewVolume = findViewById(R.id.textViewBasic_5);

        cardViewMemory = findViewById(R.id.CardViewBasic_7);

        cardViewMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MemoryActivity.class);
                startActivity(intent);
            }
        });

        textViewMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MemoryActivity.class);
                startActivity(intent);
            }
        });

        cardViewWeight = findViewById(R.id.CardViewBasic_3);

        cardViewVolume = findViewById(R.id.CardViewBasic_5);



        cardViewArea = findViewById(R.id.CardViewBasic_2);

        cardViewAngle = findViewById(R.id.CardViewBasic_4);

        cardViewAngle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AngleActivity.class);
                startActivity(intent);
            }
        });

        textViewAngle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AngleActivity.class);
                startActivity(intent);
            }
        });

        cardViewArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AreaActivity.class);
                startActivity(intent);
            }
        });
        textViewArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AreaActivity.class);
                startActivity(intent);
            }
        });

        cardViewWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WeightActivity.class);
                startActivity(intent);
            }
        });
        textViewWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WeightActivity.class);
                startActivity(intent);
            }
        });

        cardViewLength = findViewById(R.id.CardViewBasic_1);

        textViewLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LenghtActivity.class);
                startActivity(intent);
            }
        });

        cardViewLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LenghtActivity.class);
                startActivity(intent);
            }
        });


        cardViewTemperature = findViewById(R.id.CardViewBasic_8);

        cardViewTime = findViewById(R.id.CardViewBasic_6);

        cardViewVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),VolumeActivity.class);
                startActivity(intent);
            }
        });
        textViewVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),VolumeActivity.class);
                startActivity(intent);
            }
        });



        cardViewTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(getApplicationContext(),TemperatureActivity.class);
                startActivity(t);
            }
        });

        cardViewTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(getApplicationContext(),TimeActivity.class);
                startActivity(t);
            }
        });


        textViewTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(getApplicationContext(),TemperatureActivity.class);
                startActivity(t);

            }
        });
        textViewTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(getApplicationContext(),TimeActivity.class);
                startActivity(t);
            }
        });



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

        toolbar.setTitle("Unit Calculator");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                hideKeyboard(UnitCalculatorActivity.this);
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
}
