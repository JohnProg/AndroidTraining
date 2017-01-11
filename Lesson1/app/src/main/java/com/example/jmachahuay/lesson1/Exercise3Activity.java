package com.example.jmachahuay.lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Exercise3Activity extends AppCompatActivity {

    EditText edtNumberOfLines;
    TextView txtLines;
    Button btnCalculateNumberOfLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);

        edtNumberOfLines = (EditText) findViewById(R.id.edtNumberOfLines);
        txtLines = (TextView) findViewById(R.id.txtLines);
        btnCalculateNumberOfLine = (Button) findViewById(R.id.btnCalculateNumberOfLine);

        btnCalculateNumberOfLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberOfLinesText = edtNumberOfLines.getText().toString();

                try {
                    int txtNumberOfLines = Integer.parseInt(numberOfLinesText);

                    txtLines.setText("");
                    for (int i=0; i<txtNumberOfLines; i++){
                        txtLines.append("Line " + (i+1) + "\n");
                    }
                }
                catch (NumberFormatException ex) {
                    Toast.makeText(Exercise3Activity.this, getResources().getString(R.string.txtValidNumber), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
