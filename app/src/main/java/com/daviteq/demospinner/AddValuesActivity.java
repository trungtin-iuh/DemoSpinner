package com.daviteq.demospinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Collections;

public class AddValuesActivity extends AppCompatActivity {

    private EditText edtValues;
    private Button btnAdd,btnBack;

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
                String value = edtValues.getText().toString();
                Add add = new Add();
                add.setValues(new String[]{value});
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
