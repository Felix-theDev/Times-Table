package com.company.timestable;
/** A Timetable app
 * @author Felix Ogbonnaya
 * @since 2020-03-02
 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.myList);
        final SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(10);


        updateList(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar timeSeekBar, int i, boolean b) {
                int min = 1;
                int value;

                if(i<min){
                    value = min;
                    seekBar.setProgress(min);
                } else {
                    value = i;
                }
               value = seekBar.getProgress();
               updateList(value);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    public void updateList(int value){
        ArrayList<String> product = new ArrayList<>();

        Log.i("INFO", "Value is " + value);
         int first = value * 2;
        Log.i("INFO", "First is " + first);
         int second = value * 3;
        Log.i("INFO", "Second is " + second);

        for(int j = 1; j<= 30; j++){
            product.add(Integer.toString(j * value));
        }
//         product.add(Integer.toString(first));
//         product.add(Integer.toString(second));

         ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, product);
        listView.setAdapter(arrayAdapter);
    }

}
