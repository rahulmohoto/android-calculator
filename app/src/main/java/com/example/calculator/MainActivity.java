package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button addBtn,subBtn,mulBtn,advBtn,divBtn,historyBtn;
    private EditText text1,text2;
    private TextView text3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.num1_edit);
        text2 = findViewById(R.id.num2_edit);

        text3 = findViewById(R.id.res_view);

        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        advBtn = findViewById(R.id.advBtn);
        divBtn = findViewById(R.id.divBtn);
        historyBtn = findViewById(R.id.historyBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(text1.getText().toString().isEmpty() || text2.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(),"invalid",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Float result = Float.parseFloat(text1.getText().toString()) + Float.parseFloat(text2.getText().toString());
                    //Log.i("result is : ", Integer.toString(result));
                    text3.setText(Float.toString(result));
                    insertData(text1.getText().toString(),text2.getText().toString(),"+",text3.getText().toString());
                }

            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().toString().isEmpty() || text2.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "invalid", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Float result = Float.parseFloat(text1.getText().toString()) - Float.parseFloat(text2.getText().toString());
                    //Log.i("result is : ", Integer.toString(result));
                    text3.setText(Float.toString(result));
                    insertData(text1.getText().toString(),text2.getText().toString(),"-",text3.getText().toString());
                }
            }
        });

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().toString().isEmpty() || text2.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "invalid", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Float result = Float.parseFloat(text1.getText().toString()) * Float.parseFloat(text2.getText().toString());
                    //Log.i("result is : ", Integer.toString(result));
                    text3.setText(Float.toString(result));
                    insertData(text1.getText().toString(),text2.getText().toString(),"*",text3.getText().toString());
                }
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().toString().isEmpty() || text2.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "invalid", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Float result = Float.parseFloat(text1.getText().toString()) / Float.parseFloat(text2.getText().toString());
                    //Log.i("result is : ", Integer.toString(result));
                    text3.setText(Float.toString(result));
                    insertData(text1.getText().toString(),text2.getText().toString(),"/",text3.getText().toString());
                }
            }
        });

        advBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHistory();
            }
        });

    }

    private void openHistory() {
        Intent intent = new Intent(this, history.class);
        startActivity(intent);
    }

    private void insertData(String num1,String num2,String op,String result) {
        BackgroundTask bg = new BackgroundTask(this);
        bg.execute(num1,num2,op,result);

    }

    public void openActivity2(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
