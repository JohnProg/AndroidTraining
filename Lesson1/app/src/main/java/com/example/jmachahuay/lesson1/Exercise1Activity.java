package com.example.jmachahuay.lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exercise1Activity extends AppCompatActivity {

    EditText edtMonthNumber;
    TextView txtMonthName;
    Button btnShowMonth;
    String [] monthArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        edtMonthNumber = (EditText) findViewById(R.id.edtMonthNumber);
        txtMonthName = (TextView) findViewById(R.id.txtMonthName);
        btnShowMonth = (Button) findViewById(R.id.btnShowMonth);

        monthArray = getResources().getStringArray(R.array.monthArray);

        btnShowMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monthText = edtMonthNumber.getText().toString();

                try {
                    int txtNumberOfMonth = Integer.parseInt(monthText);

                    if (txtNumberOfMonth >= 0 && txtNumberOfMonth <= 11){
                        txtMonthName.setText(monthArray[txtNumberOfMonth - 1]);
                    } else {
                        txtMonthName.setText(R.string.txtValidMonthNumber);
                    }
                }
                catch (NumberFormatException ex) {
                    txtMonthName.setText(R.string.txtValidNumber);
                }
            }
        });
    }
}
