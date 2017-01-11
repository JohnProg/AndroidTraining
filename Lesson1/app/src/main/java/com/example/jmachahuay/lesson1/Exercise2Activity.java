package com.example.jmachahuay.lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exercise2Activity extends AppCompatActivity {

    EditText firstNumber, secondNumber, operator;
    TextView txtResult;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        firstNumber = (EditText) findViewById(R.id.edtFirstNumber);
        secondNumber = (EditText) findViewById(R.id.edtSecondNumber);
        operator = (EditText) findViewById(R.id.edtOperator);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumberText = firstNumber.getText().toString(),
                        secondNumberText = secondNumber.getText().toString(),
                        operatorText = operator.getText().toString();
                Double result;

                try {
                    Double  txtFirstNumber = Double.parseDouble(firstNumberText),
                        txtSecondNumber = Double.parseDouble(secondNumberText);

                    switch (operatorText) {
                        case "+":
                            result = txtFirstNumber + txtSecondNumber;
                            break;
                        case "-":
                            result = txtFirstNumber - txtSecondNumber;
                            break;
                        case "*":
                            result = txtFirstNumber * txtSecondNumber;
                            break;
                        case "/":
                            result = txtFirstNumber / txtSecondNumber;
                            break;
                        default:
                            result = null;
                            break;
                    }

                    if (result != null) {
                        txtResult.setText(Double.toString(result));
                    } else {
                        txtResult.setText(R.string.txtValidOperator);
                    }
                }
                catch (NumberFormatException ex) {
                    txtResult.setText(R.string.txtValidNumber);
                }
            }
        });
    }
}
