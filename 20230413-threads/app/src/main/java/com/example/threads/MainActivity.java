package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnProcessar;
    private TextView txtStatus;

    public ProgressBar pgbProgresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProcessar = findViewById(R.id.btnProcessar);
        txtStatus = findViewById(R.id.txtStatus);
        pgbProgresso = findViewById(R.id.pgbProgresso);
        btnProcessar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        btnProcessar.setEnabled(false);
        txtStatus.setText(R.string.processando);
        pgbProgresso.setVisibility(View.VISIBLE);
        pgbProgresso.setMax(15);
        pgbProgresso.setProgress(0);
        executarAlgoDemorado();
    }

    public void executarAlgoDemorado()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(15000);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtStatus.setText(R.string.finalizado);
                        pgbProgresso.setVisibility(View.INVISIBLE);
                        btnProcessar.setEnabled(true);

                    }
                });
            }
        }).start();

    }
}