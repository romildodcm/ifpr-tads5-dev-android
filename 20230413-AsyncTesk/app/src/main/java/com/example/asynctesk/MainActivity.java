package com.example.asynctesk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        ProcessarTask task = new ProcessarTask(btnProcessar, txtStatus, pgbProgresso);
        pgbProgresso.setMax(10);
        task.execute(pgbProgresso.getMax());
    }
}