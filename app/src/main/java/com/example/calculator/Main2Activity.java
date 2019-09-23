package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button sinBtn,cosBtn,sqrtBtn,tanBtn,sqrBtn,logBtn,clrBtn;
    private EditText text1;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sinBtn = findViewById(R.id.sinBtn);
        cosBtn = findViewById(R.id.cosBtn);
        tanBtn = findViewById(R.id.tanBtn);
        sqrtBtn = findViewById(R.id.sqrtBtn);
        sqrBtn = findViewById(R.id.sqrBtn);
        logBtn = findViewById(R.id.logBtn);
        clrBtn = findViewById(R.id.clrBtn);

        text1 = findViewById(R.id.num1_edit);
        result = findViewById(R.id.res_view);

        sinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "INVALID", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    double number = Double.parseDouble(text1.getText().toString());
                    result.setText(Double.toString(Math.sin(Math.toRadians(number))));
                }
            }
        });

        cosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "INVALID", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    double number = Double.parseDouble(text1.getText().toString());
                    result.setText(Double.toString(Math.cos(Math.toRadians(number))));
                }
            }
        });

        tanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "INVALID", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    double number = Double.parseDouble(text1.getText().toString());
                    result.setText(Double.toString(Math.tan(Math.toRadians(number))));
                }
            }
        });

        sqrtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "INVALID", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    double number = Double.parseDouble(text1.getText().toString());
                    result.setText(Double.toString(Math.sqrt(number)));
                }
            }
        });

        sqrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "INVALID", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    double number = Double.parseDouble(text1.getText().toString());
                    result.setText(Double.toString(Math.pow(number,2)));
                }
            }
        });

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text1.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(),"INVALID",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    double number = Double.parseDouble(text1.getText().toString());
                    result.setText(Double.toString(Math.log10(number)));
                }
            }
        });

        clrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(null);
                text1.setText(null);
                result.setHint("Result");
            }
        });


    }

}
