package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class CombinationsActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private EditText editTextC, editTextK;

    private Button buttonSolve, buttonClear;

    private TextView textViewAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinations);


        editTextC = findViewById(R.id.c);

        editTextK = findViewById(R.id.K);

        buttonClear = findViewById(R.id.btn_clear);

        buttonSolve = findViewById(R.id.btn_solve);

        textViewAnswer = findViewById(R.id.answer);


        toolbar = findViewById(R.id.toolbar_age);

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
        toolbar.setTitle("Combination");

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(CombinationsActivity.this);
                editTextC.setText("");
                editTextK.setText("");
                textViewAnswer.setText("00");
            }
        });


        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(CombinationsActivity.this);
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


            BigInteger answer,result;

            result = factorial(K1).multiply( factorial(C1-K1));

            answer = factorial(C1).divide(result);


            String Answer = String.valueOf(answer);

            textViewAnswer.setText(Answer);


        }
    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();
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
