package com.daviteq.demospinner;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Spinner spListValues;
    private Button btnShow;
    private Dialog dialog;
    private ArrayList<String> val;
    ArrayAdapter<String> arr = null;

//    private String[] val = new String[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spListValues = findViewById(R.id.spListValues);
        btnShow = findViewById(R.id.showDialog);

        try {

            SharedPreferences sharePref = getSharedPreferences("PREFS",0);
            Set<String> set = sharePref.getStringSet("listValues",null);

            val = new ArrayList<>();

            val.addAll(set);
//            for (int i = 0; i < set.size(); i++){
//                val.add(set[i]);
//            }
//            String valuesString = sharePref.getString("listValues","");
//            String[] itemList =  valuesString.split(",");
//            List<String> listValues = new ArrayList<>();
//
//            for (int i = 0; i < itemList.length; i++){
//                listValues.addAll(Collections.singleton(itemList[i]));
//            }
//
//            for (int i = 0; i < listValues.size(); i++){
//                val = new ArrayList<>();
//                val.addAll(Collections.singleton(listValues.get(i)));
//            }
//
            arr = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, val);
            spListValues.setAdapter(arr);

        } catch (Exception e){
            Log.w("Exception", e.toString());
        }

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddValuesActivity.class);
                startActivity(intent);
//                dialog = new Dialog(MainActivity.this);
//                dialog.setContentView(R.layout.dialog_add);
//                final EditText edtValues = dialog.findViewById(R.id.edtValues);
//                Button btnAdd = dialog.findViewById(R.id.btnAdd);
//
//                Button btnBack = dialog.findViewById(R.id.btnBack);
//
//                btnBack.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(MainActivity.this,"Successfully",Toast.LENGTH_SHORT).show();
//                        dialog.dismiss();
//                    }
//                });
//
//                btnAdd.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String values = edtValues.getText().toString();
//                        listValues.addAll(Collections.singleton(values));
//                        edtValues.setText("");
//                        arr.notifyDataSetChanged();
//                    }
//                });
//
//                dialog.show();
            }
        });

        this.spListValues.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                arr.remove((String) spListValues.getSelectedItem());
                arr.notifyDataSetChanged();
                return true;
            }
        });

        this.spListValues.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(MainActivity.this,"values: "+spListValues.getSelectedItem(),Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

//    public void dataAddAdapter(List<String> values){
//        adapter.addAll(values);
//        adapter.notifyDataSetChanged();
//    }
}
