package com.example.jmachahuay.lesson5;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop, btnRestart;
    Chronometer chronometer = null;
    TextView txtChronometer, txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        actionButtons();
    }

    private void actionButtons() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chronometer == null) {
                    chronometer = new Chronometer(getResources().getString(R.string.startChronometer), txtTitle, txtChronometer);
                    new Thread(chronometer).start();
                    btnStart.setText(getResources().getString(R.string.btnStop));
                } else {
                    chronometer.pause();
                    if (btnStart.getText().equals(getResources().getString(R.string.btnStop))) {
                        btnStart.setText(getResources().getString(R.string.continueChronometer));
                    } else {
                        btnStart.setText(getResources().getString(R.string.btnStop));
                    }
                }
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btnStart.getText().equals(getResources().getString(R.string.continueChronometer))) {
                    btnStart.setText(getResources().getString(R.string.btnStop));
                }
                chronometer.restart();
            }
        });
    }

    private void initComponents() {
        btnStart = (Button)findViewById(R.id.btnStart);
        btnRestart = (Button)findViewById(R.id.btnRestart);
        txtChronometer = (TextView)findViewById(R.id.txtChronometer);
        txtTitle = (TextView)findViewById(R.id.txtTitle);
    }

    public class Chronometer implements Runnable {
        private TextView chrono, title;
        private String titleChrono;
        private int seconds, minutes, hours;
        private Handler writeUI;
        private boolean stopped;
        private String output;
        private volatile boolean running = true;

        public Chronometer(String strTitle, TextView tvTitle, TextView tvChrono) {
            titleChrono = strTitle;
            chrono = tvChrono;
            title = tvTitle;
            seconds = 0;
            minutes = 0;
            hours = 0;
            writeUI = new Handler();
            stopped = false;
            output = "";
        }

        @Override
        public void run() {
            try {
                while (running) {
                    Thread.sleep(1000);
                    output = "";
                    if (!stopped) {
                        seconds++;
                        if (seconds == 60) {
                            seconds = 0;
                            minutes++;
                        }
                        if (minutes == 60) {
                            minutes = 0;
                            hours++;
                        }

                        if (hours <= 9) {
                            output += "0";
                        }
                        output += hours;
                        output += "hours";
                        output += ":";
                        if (minutes <= 9) {
                            output += "0";
                        }
                        output += minutes;
                        output += ":";
                        if (seconds <= 9) {
                            output += "0";
                        }
                        output += seconds;
                        try {
                            writeUI.post(new Runnable() {
                                @Override
                                public void run() {
                                    title.setText(titleChrono);
                                    chrono.setText(output);
                                }
                            });
                        } catch (Exception e) {
                            running = false;
                            throw new Error("Error message: " + e.getMessage());
                        }

                    }
                }
            } catch (InterruptedException e) {
                running = false;
                throw new Error("Error message: " + e.getMessage());
            }
        }

        public void restart() {
            seconds = 0;
            minutes = 0;
            hours = 0;
            stopped = false;
        }

        public void pause() {
            stopped = !stopped;
        }

    }
}
