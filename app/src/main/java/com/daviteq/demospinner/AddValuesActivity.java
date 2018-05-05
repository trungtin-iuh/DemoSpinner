package com.daviteq.demospinner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddValuesActivity extends AppCompatActivity {

    private EditText edtValues;
    private Button btnAdd,btnBack;

    private List<String> listValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_values);

        initView();

        processAddValues();

        processBack();
    }

    private void processBack() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddValuesActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void processAddValues() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listValues = new ArrayList<>();
                String value = edtValues.getText().toString();
//                listValues.addAll(Collections.singleton(value));

//                Set<String> set = new HashSet<String>();
//                set.addAll(listValues);
//                StringBuilder sb = new StringBuilder();
//
//                for (String s : listValues){
//                    sb.append(s);
//                    sb.append(",");
//                }



                SharedPreferences sharePref = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = sharePref.edit();
                Set<String> set = new HashSet<String>();
//                Set<String> set = sharePref.getStringSet("listValues", new HashSet<String>());
                set.addAll(Collections.singleton(value));
                editor.putStringSet("listValues",set);
                editor.apply();

                edtValues.setText("");

            }
        });
    }

    private void initView() {
        edtValues = findViewById(R.id.edtValues);
        btnAdd = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnBack);
    }
}
