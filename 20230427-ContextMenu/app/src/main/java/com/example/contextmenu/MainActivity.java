package com.example.contextmenu;

import static com.example.contextmenu.R.*;
//import static com.example.activiti.R.*;
import static com.example.contextmenu.R.id.txtContador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, ActionMode.Callback {

    private TextView txtContador;
    private boolean actionModeActive;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        txtContador = findViewById(id.txtContador);
        txtContador.setText("0");
        txtContador.setOnLongClickListener(this);
    }



    @Override
    public boolean onLongClick(View v) {
        if(!actionModeActive){
            startActionMode(this);
            actionModeActive = true;
        }
        return true;
    }

    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        if (menuItem.getItemId() == id.act_ant){
            count--;
            txtContador.setText(String.valueOf(count));
            actionMode.finish();
        } else if (menuItem.getItemId() == id.act_prox) {
            count++;
            txtContador.setText(String.valueOf(count));
            actionMode.finish();
        }
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {
        actionModeActive = false;
    }
}