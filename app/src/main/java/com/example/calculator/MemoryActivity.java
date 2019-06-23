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

public class MemoryActivity extends AppCompatActivity {


    private Toolbar toolbar;

    private Spinner spinnerFrom, spinnerTo;

    private TextView textViewResult;

    private Button buttonClear;

    private Button buttonSolve;


    private static final String[] paths = {"To", "Bit", "Byte", "KiloByte", "MegaByte", "GigaByte", "KiloBit", "MegaBit", "GigaBit"};

    private static final String[] path = {"From", "Bit", "Byte", "KiloByte", "MegaByte", "GigaByte", "KiloBit", "MegaBit", "GigaBit"};

    private EditText editTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
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
        toolbar.setTitle("Memory");


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
                    if (temp1.equals("Bit")) {
                        if (temp2.equals("Byte")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Byte(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("KiloByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloByte(s)");


                        } else if (temp2.equals("MegaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / Math.exp(8) + 6;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaByte(s)");


                        } else if (temp2.equals("GigaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / Math.exp(8) + 9;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaByte(s)");


                        } else if (temp2.equals("KiloBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloBit(s)");


                        } else if (temp2.equals("MegaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / Math.exp(1) + 6;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaBit(s)");


                        } else if (temp2.equals("GigaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / Math.exp(1) + 9;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaBit(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Bit to Bit .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("Byte")) {
                        if (temp2.equals("Bit")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Bit(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("KiloByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloByte(s)");


                        } else if (temp2.equals("MegaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaByte(s)");


                        } else if (temp2.equals("GigaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 11.7182818285;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaByte(s)");


                        } else if (temp2.equals("KiloBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 125;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloBit(s)");


                        } else if (temp2.equals("MegaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 125000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaBit(s)");


                        } else if (temp2.equals("GigaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 11.3978522856;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaBit(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from Byte to Byte .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("KiloBit")) {
                        if (temp2.equals("Byte")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 125;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Byte(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("KiloByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloByte(s)");


                        } else if (temp2.equals("MegaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaByte(s)");


                        } else if (temp2.equals("GigaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 27.7462546277;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaByte(s)");


                        } else if (temp2.equals("Bit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Bit(s)");


                        } else if (temp2.equals("MegaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaBit(s)");


                        } else if (temp2.equals("GigaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaBit(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from KiloBit to KiloBit .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("MegaByte")) {
                        if (temp2.equals("Byte")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Byte(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("KiloByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloByte(s)");


                        } else if (temp2.equals("Bit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 27.7462546277;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Bit(s)");


                        } else if (temp2.equals("GigaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaByte(s)");


                        } else if (temp2.equals("KiloBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloBit(s)");


                        } else if (temp2.equals("MegaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a *8;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaBit(s)");


                        } else if (temp2.equals("GigaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 125;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaBit(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from MegaByte to MegaByte .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("GigaByte")) {
                        if (temp2.equals("Byte")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 11.7182818285;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Byte(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("KiloByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloByte(s)");


                        } else if (temp2.equals("MegaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaByte(s)");


                        } else if (temp2.equals("Bit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 27.7462546277;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Bit(s)");


                        } else if (temp2.equals("KiloBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloBit(s)");


                        } else if (temp2.equals("MegaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaBit(s)");


                        } else if (temp2.equals("GigaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 125;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaBit(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from GigaByte to GigaByte .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("KiloByte")) {
                        if (temp2.equals("Byte")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Byte(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("Bit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Bit(s)");


                        } else if (temp2.equals("MegaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaByte(s)");


                        } else if (temp2.equals("GigaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaByte(s)");


                        } else if (temp2.equals("KiloBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloBit(s)");


                        } else if (temp2.equals("MegaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 125;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaBit(s)");


                        } else if (temp2.equals("GigaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 125000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaBit(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from KiloByte to KiloByte .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("GigaBit")) {
                        if (temp2.equals("Byte")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 9.39785228557;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Byte(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("KiloByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 125000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloByte(s)");


                        } else if (temp2.equals("MegaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 125;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaByte(s)");


                        } else if (temp2.equals("GigaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaByte(s)");


                        } else if (temp2.equals("KiloBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloBit(s)");


                        } else if (temp2.equals("MegaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaBit(s)");


                        } else if (temp2.equals("Bit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 11.7182818285;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Bit(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from GigaBit to GigaBit .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }
                    else if (temp1.equals("MegaBit")) {
                        if (temp2.equals("Byte")) {
                            Double a;

                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 125000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Byte(s)");
                            //Toast.makeText(TemperatureActivity.this,r+"°F",Toast.LENGTH_SHORT).show();

                        } else if (temp2.equals("KiloByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 125;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloByte(s)");


                        } else if (temp2.equals("MegaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " MegaByte(s)");


                        } else if (temp2.equals("GigaByte")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 8000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaByte(s)");


                        } else if (temp2.equals("KiloBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " KiloBit(s)");


                        } else if (temp2.equals("Bit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a * 8.71828182846;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " Bit(s)");


                        } else if (temp2.equals("GigaBit")) {
                            Double a;
                            a = Double.parseDouble(String.valueOf(editTextValue.getText()));
                            Double b = a / 1000;
                            String r = String.valueOf(b);
                            textViewResult.setText(r + " GigaBit(s)");


                        } else {
                            Toast.makeText(getApplicationContext(), "You cannot convert from MegaBit to MegaBit .Please choose a To", Toast.LENGTH_LONG).show();
                            textViewResult.setText("");

                        }

                    }


                }

            }
        });

    }
}