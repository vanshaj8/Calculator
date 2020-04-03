package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.calculator.R.*;

public class MainActivity extends AppCompatActivity {
    private boolean isoppressed =false;
    private double firstnumber =0;
    private int secondnumberindex =0;
    private  char currentop;
    private  boolean isdot=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.mylayout);
        final TextView calculatorScreen = findViewById(R.id.calculatorScreen);
        final Button n0 = findViewById(R.id.n0);
        final Button n1 = findViewById(R.id.n1);
        final Button n2 = findViewById(R.id.n2);
        final Button n3 = findViewById(R.id.n3);
        final Button n4 = findViewById(R.id.n4);
        final Button n5 = findViewById(R.id.n5);
        final Button n6 = findViewById(R.id.n6);
        final Button n7 = findViewById(R.id.n7);
        final Button n8 = findViewById(R.id.n8);
        final Button n9 = findViewById(R.id.n9);
        final Button n_dot = findViewById(R.id.n_dot);
        final Button n_divide = findViewById(R.id.n_divide);
        final Button n_add = findViewById(R.id.n_add);
        final Button n_equal = findViewById(R.id.n_equal);
        final Button n_multiply = findViewById(R.id.n_multiply);
        final Button n_subtract = findViewById(R.id.n_subtract);

        final View.OnClickListener calculatorListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int Id = v.getId();

                switch (Id) {
                    case R.id.n0:
                        calculatorScreen.append("0");
                        break;
                    case R.id.n1:
                        calculatorScreen.append("1");
                        break;
                    case R.id.n2:
                        calculatorScreen.append("2");
                        break;
                    case R.id.n3:
                        calculatorScreen.append("3");
                        break;
                    case R.id.n4:
                        calculatorScreen.append("4");
                        break;
                    case R.id.n5:
                        calculatorScreen.append("5");
                        break;
                    case R.id.n6:
                        calculatorScreen.append("6");
                        break;
                    case R.id.n7:
                        calculatorScreen.append("7");
                        break;
                    case R.id.n8:
                        calculatorScreen.append("8");
                        break;
                    case R.id.n9:
                        calculatorScreen.append("9");
                        break;
                    case R.id.n_add:
                        String screncontent = calculatorScreen.getText().toString();
                        firstnumber=Double.parseDouble(screncontent);
                        secondnumberindex=screncontent.length()+1;
                        calculatorScreen.append("+");
                        isoppressed=true;
                        isdot=false;
                        currentop='+';

                        break;
                    case R.id.n_divide:
                        screncontent = calculatorScreen.getText().toString();
                        firstnumber=Double.parseDouble(screncontent);
                        secondnumberindex=screncontent.length()+1;
                        calculatorScreen.append("/");
                        isoppressed=true;
                        isdot=false;
                        currentop='/';
                        break;
                    case R.id.n_dot:
                        if(!isdot)
                        {
                            calculatorScreen.append(".");
                            isdot=true;
                        }
                        break;
                    case R.id.n_equal:
                        if(isoppressed)
                        {
                            isoppressed=false;
                            String screencontent = calculatorScreen.getText().toString();
                            String secondnumberString = screencontent.substring(secondnumberindex, screencontent.length());
                            double secondnumber = Double.parseDouble(secondnumberString);
                            if (currentop == '+') {
                                secondnumber += firstnumber;

                            } else if (currentop == '-') {
                                secondnumber = firstnumber - secondnumber;
                            } else if (currentop == '*') {
                                secondnumber *= firstnumber;
                            } else if (currentop == '/') {
                                secondnumber = (double) firstnumber / secondnumber;
                            }
                            String result = String.valueOf(secondnumber);
                            if (result.endsWith(".0"))
                            {
                                result = result.substring(0, result.length() - 2);
                            }
                            calculatorScreen.setText(result);
                        }
                        break;
                    case R.id.n_multiply:
                        screncontent = calculatorScreen.getText().toString();
                        firstnumber=Double.parseDouble(screncontent);
                        secondnumberindex=screncontent.length()+1;
                        calculatorScreen.append("*");
                        isoppressed=true;
                        isdot=false;
                        currentop='*';
                        break;
                    case R.id.n_subtract:
                        screncontent = calculatorScreen.getText().toString();
                        firstnumber=Double.parseDouble(screncontent);
                        secondnumberindex=screncontent.length()+1;
                        calculatorScreen.append("-");
                        isoppressed=true;
                        isdot=false;
                        currentop='-';
                        break;


                }
            }
        };
        n0.setOnClickListener(calculatorListner);
        n1.setOnClickListener(calculatorListner);
        n2.setOnClickListener(calculatorListner);
        n3.setOnClickListener(calculatorListner);
        n4.setOnClickListener(calculatorListner);
        n5.setOnClickListener(calculatorListner);
        n6.setOnClickListener(calculatorListner);
        n7.setOnClickListener(calculatorListner);
        n8.setOnClickListener(calculatorListner);
        n9.setOnClickListener(calculatorListner);
        n_add.setOnClickListener(calculatorListner);
        n_divide.setOnClickListener(calculatorListner);
        n_dot.setOnClickListener(calculatorListner);
        n_equal.setOnClickListener(calculatorListner);
        n_multiply.setOnClickListener(calculatorListner);
        n_subtract.setOnClickListener(calculatorListner);

        final Button delete = findViewById(R.id.del);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String displayed_elements= calculatorScreen.getText().toString();
                int length=displayed_elements.length();
                if(length>0)
                {
                    displayed_elements=displayed_elements.substring(0,length-1);
                    calculatorScreen.setText(displayed_elements);
                }
            }
        });

        final Button clear_screen = findViewById(R.id.clear);
        clear_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorScreen.setText("");
                isdot=false;
                isoppressed=false;
            }
        });

    }
}