package com.example.tablesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    NumbersRvAdapter numbersRvAdapter;

    public void generateNumRV(int tableNum) {
        ArrayList<String> tables = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            tables.add(Integer.toString(i * tableNum));
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NumbersRvAdapter(this, tables));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekbar = findViewById(R.id.seekBar);
        int max = 20;
        int min = 0;
        int startPos = 10;
        seekbar.setMax(max);
        seekbar.setProgress(startPos);

        generateNumRV(startPos);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int tableNum;
                if (progress < min) {
                    tableNum = min;
                    seekbar.setProgress(tableNum);
                } else {
                    tableNum = progress;
                }
                Log.d("Seek", "Value :" + tableNum);
                generateNumRV(tableNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}