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

public class WeightActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private Spinner spinnerFrom, spinnerTo;

    private TextView textViewResult;

    private Button buttonClear;

    private Button buttonSolve;


    private static final String[] paths = {"To", "Kilogram", "Gram", "Pound", "Ounce", "Milligram", "Poundal", "Ton"};

    private static final String[] path = {"From",  "Kilogram", "Gram", "Pound", "Ounce", "Milligram", "Poundal", "Ton"};

    private EditText editTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
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
        toolbar.setTitle("Weight");


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
                    if (temp1.equals("Kilogram")) {
                        if (temp2.equals("Gram")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Gram(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Pound")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 2.205
                                    ;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Pound(s)");


                        } else if (temp2.equals("Ounce")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 35.274;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Ounce(s)");

                        } else if (temp2.equals("Milligram")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Milligram(s)");

                        }  else if (temp2.equals("Ton")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Ton(s)");

                        } else if (temp2.equals("Poundal")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 70.9888484236;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Poundal(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Kilogram to Kilogram .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("Gram")) {
                        if (temp2.equals("Kilogram")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Gram(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Pound")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 453.592
                                    ;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Pound(s)");


                        } else if (temp2.equals("Ounce")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 28.35;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Ounce(s)");

                        } else if (temp2.equals("Milligram")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Milligram(s)");

                        }  else if (temp2.equals("Ton")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8.71828182846;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Ton(s)");

                        } else if (temp2.equals("Poundal")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 0.0709888484;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Poundal(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Gram to Gram .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("Pound")) {
                        if (temp2.equals("Gram")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 2204.623;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Gram(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Kilogram")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 2.205
                                    ;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Kilogram(s)");


                        } else if (temp2.equals("Ounce")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 35.274;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Ounce(s)");

                        } else if (temp2.equals("Milligram")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 16;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Milligram(s)");

                        }  else if (temp2.equals("Ton")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 2204.623
                                    ;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Ton(s)");

                        } else if (temp2.equals("Poundal")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 32.2;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Poundal(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Pound to Pound .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("Ounce")) {
                        if (temp2.equals("Gram")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 28.35;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Gram(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Pound")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 16;
                                    ;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Pound(s)");


                        } else if (temp2.equals("Kilogram")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a /35.274
                                    ;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Kilogram(s)");

                        } else if (temp2.equals("Milligram")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a *  28349.523;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Milligram(s)");

                        }  else if (temp2.equals("Ton")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 35273.962;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Ton(s)");

                        } else if (temp2.equals("Poundal")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 39.37;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Poundal(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Ouch to Ouch .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("Milligram")) {
                        if (temp2.equals("Gram")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Gram(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Pound")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 453592.37
                                    ;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Pound(s)");


                        } else if (temp2.equals("Ounce")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a /28349.523;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Ounce(s)");

                        } else if (temp2.equals("Kilogram")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Kilogram(s)");

                        }  else if (temp2.equals("Ton")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 11.7182818285;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Ton(s)");

                        } else if (temp2.equals("Poundal")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 14.2967565064;

                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Poundal(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Milligram to Milligram .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("Ton")) {
                        if (temp2.equals("Gram")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Gram(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Pound")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 2204.623
                                    ;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Pound(s)");


                        } else if (temp2.equals("Ounce")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 35273.962;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Ounce(s)");

                        } else if (temp2.equals("Milligram")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 11.7182818285;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Milligram(s)");

                        }  else if (temp2.equals("Kilogram")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a *1000;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Kilogram(s)");

                        } else if (temp2.equals("Poundal")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 70988.8484236;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Poundal(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Ton to Ton .Please choose a To", Toast.LENGTH_LONG).show();
                            editTextValue.setText("");

                        }

                    }
                    else if (temp1.equals("Poundal")) {
                        if (temp2.equals("Gram")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 14.0867195652;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Gram(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Pound")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 0.0310559006;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Pound(s)");


                        } else if (temp2.equals("Ounce")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 0.4968944099;

                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Ounce(s)");

                        } else if (temp2.equals("Milligram")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 14086.719565204;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Milligram(s)");

                        }  else if (temp2.equals("Ton")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * -1.17078357107;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Ton(s)");

                        } else if (temp2.equals("Kilogram")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 0.0140867196;
                            String r = String.valueOf(b);
                            textViewResult.setText(a + " Kilogram(s)");

                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Poundal to Poundal .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }

                }

            }
        });

    }
}