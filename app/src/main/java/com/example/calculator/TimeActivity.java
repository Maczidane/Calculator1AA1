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

public class TimeActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private Spinner spinnerFrom, spinnerTo;

    private TextView textViewResult;

    private Button buttonClear;

    private Button buttonSolve;


    private static final String[] paths = {"To", "Second", "Millisecond", "Microsecond", "Hour", "Minute"};

    private static final String[] path = {"From", "Second", "Millisecond", "Microsecond", "Hour", "Minute"};

    private EditText editTextValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);


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
        toolbar.setTitle("Time");


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
                    if (temp1.equals("Second")) {
                        if (temp2.equals("Minute")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 60;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Second(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Hour")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 3600;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Hour(s)");


                        } else if (temp2.equals("Millisecond")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * Math.exp(1) + 6;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Millisecond(s)");

                        } else if (temp2.equals("Microsecond")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Millisecond(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Second to Second .Please choose a To", Toast.LENGTH_LONG).show();
                            editTextValue.setText("");

                        }

                    }
                    else if (temp1.equals("Hour")) {
                        if (temp2.equals("Second")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 3600;
                            Double c = b * 5 / 9;
                            String r = String.valueOf(c);
                            textViewResult.setText(r + " Hour(s)");
                            //Toast.makeText(TimeActivity.this,r+"°C",Toast.LENGTH_SHORT).show();
                        }
                        else if (temp2.equals("Minute")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 60;


                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Minute(s)");
                        } else if (temp2.equals("Millisecond")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 15.5139863996;


                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Millisecond(s)");
                        } else if (temp2.equals("Microsecond")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 18.7858145825;


                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Microsecond(s)");
                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Hour to Hour .Please choose a To", Toast.LENGTH_LONG).show();
                            editTextValue.setText("");

                        }

                    }
                    else if (temp1.equals("Minute")) {
                        if (temp2.equals("Second")) {

                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = (a * 60);
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Second(s)");
                        } else if (temp2.equals("Hour")) {

                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = (a / 60);


                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Hour(s)");


                        } else if (temp2.equals("Millisecond")) {

                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = (a * 23.3096909708);


                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Millisecond(s)");


                        } else if (temp2.equals("Microsecond")) {

                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = (a * 60000);


                            String r = String.valueOf(b);
                            textViewResult.setText(r + "Millisecond(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Minute to Minute.Please choose a To", Toast.LENGTH_LONG).show();
                            editTextValue.setText("");

                        }




                    }

                    else if (temp1.equals("Millisecond")) {
                        if (temp2.equals("Second")) {

                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = (a * 1000);
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Second(s)");
                        } else if (temp2.equals("Hour")) {

                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = (a /15.7858145825);


                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Hour(s)");


                        } else if (temp2.equals("Minute")) {

                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = (a / 60000);


                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Minute(s)");


                        } else if (temp2.equals("Microsecond")) {

                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = (a * 1000);


                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Microsecond(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Millisecond to Millisecond.Please choose a To", Toast.LENGTH_LONG).show();
                            editTextValue.setText("");

                        }
                    }
                    else if (temp1.equals("Microsecond")) {
                        if (temp2.equals("Second")) {

                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = (a /   8.71828182846);
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Second(s)");
                        } else if (temp2.equals("Hour")) {

                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = (a /35.6006019562);





                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Hour(s)");


                        } else if (temp2.equals("Minute")) {

                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = (a / 23.3096909708);


                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Minute(s)");


                        } else if (temp2.equals("Millisecond")) {

                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = (a / 1000);


                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Millisecond(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Microsecond to Microsecond.Please choose a To", Toast.LENGTH_LONG).show();
                            editTextValue.setText("");

                        }
                    }
                }

            }
        });

    }
}
