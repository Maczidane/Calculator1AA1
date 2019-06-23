package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LenghtActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private Spinner spinnerFrom, spinnerTo;

    private TextView textViewResult;

    private Button buttonClear;

    private Button buttonSolve;


    private static final String[] paths = {"To", "Meter", "Kilometer", "Centimeter", "Millimeter", "Mile", "Yard", "Foot", "Inch", "Angstrom"};

    private static final String[] path = {"From", "Meter", "Kilometer", "Centimeter", "Millimeter", "Mile", "Yard", "Foot", "Inch", "Angstrom"};

    private EditText editTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenght);
        toolbar = findViewById(R.id.toolbar_all);

        buttonClear = findViewById(R.id.btn_clear);

        buttonSolve = findViewById(R.id.btn_solve);

        editTextValue = findViewById(R.id.edit_value);
        textViewResult = findViewById(R.id.TitleAnswer);


        spinnerTo = findViewById(R.id.simpleSpinnerTo);

        ArrayAdapter<String> to = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paths);
        to.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerTo.setAdapter(to);


        spinnerFrom = findViewById(R.id.simpleSpinnerFrom);

        ArrayAdapter<String> from = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, path);
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
        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        // Whatever you want to happen when the first item gets selected
                        break;
                    case 1:
                        // Whatever you want to happen when the second item gets selected
                        break;
                    case 2:
                        // Whatever you want to happen when the thrid item gets selected
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle("Length");


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextValue.setText("");
                textViewResult.setText("0.0");


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
                } else {
                    if (temp1.equals("Meter")) {
                        if (temp2.equals("Kilometer")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Kilometer(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Centimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 100;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Centimeter(s)");


                        } else if (temp2.equals("Millimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1000;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Millimeter(s)");

                        } else if (temp2.equals("Mile")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1609.344;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Mile(s)");

                        } else if (temp2.equals("Yard")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1.094;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Yard(s)");


                        } else if (temp2.equals("Foot")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 3.281;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Foot(s)");

                        } else if (temp2.equals("Inch")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 39.37;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Inch(s)");

                        } else if (temp2.equals("Angstrom")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 12.7182818285;

                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Angstrom(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Meter to Meter .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("Kilometer")) {
                        if (temp2.equals("Meter")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Meter(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Centimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 100000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Centimeter(s)");


                        } else if (temp2.equals("Millimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8.71828182846;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Millimeter(s)");

                        } else if (temp2.equals("Mile")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1.609;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Mile(s)");

                        } else if (temp2.equals("Yard")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1093.613;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Yard(s)");


                        } else if (temp2.equals("Foot")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 3280.84;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Foot(s)");

                        } else if (temp2.equals("Inch")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 39370.079;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Inch(s)");

                        } else if (temp2.equals("Angstrom")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a *  15.7182818285;


                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Angstrom(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Kilometer to Kilometer .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("Centimeter")) {
                        if (temp2.equals("Meter")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 100;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Meter(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Kilometer")) {

                            //TODO: Where i lastly stopped


                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 100000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Kilometer(s)");


                        } else if (temp2.equals("Millimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 10;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Millimeter(s)");

                        } else if (temp2.equals("Mile")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 160934.4;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Mile(s)");

                        } else if (temp2.equals("Yard")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 91.44;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Yard(s)");


                        } else if (temp2.equals("Foot")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 30.48;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Foot(s)");

                        } else if (temp2.equals("Inch")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 2.54;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Inch(s)");

                        } else if (temp2.equals("Angstrom")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 10.7182818285;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Angstrom(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Centimeter to Centimeter.Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }


                    }
                    else if (temp1.equals("Millimeter")) {
                        if (temp2.equals("Meter")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Meter(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Kilometer")) {

                            //TODO: Where i lastly stopped


                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Kilometer(s)");


                        } else if (temp2.equals("Centimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 10;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Centimeter(s)");

                        } else if (temp2.equals("Mile")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 10.373715462;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Mile(s)");

                        } else if (temp2.equals("Yard")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 914.4;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Yard(s)");


                        } else if (temp2.equals("Foot")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 304.8;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Foot(s)");

                        } else if (temp2.equals("Inch")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 2.54;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Inch(s)");

                        } else if (temp2.equals("Angstrom")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 9.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Angstrom(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Centimeter to Centimeter.Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }


                    }
                    else if (temp1.equals("Mile")) {
                        if (temp2.equals("Meter")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1609.344;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Meter(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Kilometer")) {

                            //TODO: Where i lastly stopped


                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1.609;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Kilometer(s)");


                        } else if (temp2.equals("Centimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 160934.4;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Centimeter(s)");

                        } else if (temp2.equals("Millimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 10.373715462;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Millimeter(s)");

                        } else if (temp2.equals("Yard")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1760;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Yard(s)");


                        } else if (temp2.equals("Foot")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 5280;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Foot(s)");

                        } else if (temp2.equals("Inch")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 63360;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Inch(s)");

                        } else if (temp2.equals("Angstrom")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 17.373715462;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Angstrom(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Mile to Mile.Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }


                    }
                    else if (temp1.equals("Yard")) {
                        if (temp2.equals("Meter")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1.094;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Meter(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Kilometer")) {

                            //TODO: Where i lastly stopped


                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1093.613;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Kilometer(s)");


                        } else if (temp2.equals("Centimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 91.44;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Centimeter(s)");

                        } else if (temp2.equals("Millimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 914.4;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Millimeter(s)");

                        } else if (temp2.equals("Mile")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1760;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Mile(s)");


                        } else if (temp2.equals("Foot")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 3;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Foot(s)");

                        } else if (temp2.equals("Inch")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 36;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Inch(s)");

                        } else if (temp2.equals("Angstrom")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 33.8559690394;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Angstrom(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Mile to Mile.Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }


                    }
                    else if (temp1.equals("Inch")) {
                        if (temp2.equals("Meter")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 39.37;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Meter(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Kilometer")) {

                            //TODO: Where i lastly stopped


                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 39370.079;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Kilometer(s)");


                        } else if (temp2.equals("Centimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 2.54;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Centimeter(s)");

                        } else if (temp2.equals("Millimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 25.4
                                    ;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Millimeter(s)");

                        } else if (temp2.equals("Mile")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 100;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Mile(s)");


                        } else if (temp2.equals("Foot")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 12;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Foot(s)");

                        } else if (temp2.equals("Yard")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 36;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Yard(s)");

                        } else if (temp2.equals("Angstrom")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 14.9044358443;

                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Angstrom(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Inch to Inch.Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }


                    }
                    else if (temp1.equals("Foot")) {
                        if (temp2.equals("Meter")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 3;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Meter(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Kilometer")) {

                            //TODO: Where i lastly stopped


                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 3280.84;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Kilometer(s)");


                        } else if (temp2.equals("Centimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 30.48;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Centimeter(s)");

                        } else if (temp2.equals("Millimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 304.8
                                    ;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Millimeter(s)");

                        } else if (temp2.equals("Mile")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 5280;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Mile(s)");


                        } else if (temp2.equals("Inch")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 12;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Inch(s)");

                        } else if (temp2.equals("Yard")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 3;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Yard(s)");

                        } else if (temp2.equals("Angstrom")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 17.2853230131;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Angstrom(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Foot to Foot .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }


                    }

                    else if (temp1.equals("Angstrom")) {
                        if (temp2.equals("Meter")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / Math.exp(1)+10;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Meter(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Kilometer")) {

                            //TODO: Where i lastly stopped


                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 15.7182818285;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Kilometer(s)");


                        } else if (temp2.equals("Centimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / Math.exp(1)+8;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Centimeter(s)");

                        } else if (temp2.equals("Millimeter")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 9.71828182846
                                    ;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Millimeter(s)");

                        } else if (temp2.equals("Mile")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 17.373715462;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Mile(s)");


                        } else if (temp2.equals("Inch")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 14.9044358443;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Inch(s)");

                        } else if (temp2.equals("Yard")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 33.8559690394;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Yard(s)");

                        } else if (temp2.equals("Foot")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 17.2853230131;


                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Foot(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Angstrom to Angstrom .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }



                    }
                }

            }
        });

    }
}
