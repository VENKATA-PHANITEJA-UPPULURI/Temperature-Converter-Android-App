 package com.example.temp_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

 public class MainActivity extends AppCompatActivity {
    EditText celcius,kelvin,fahrenheit;
    Button submit,clear;
    CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        celcius=findViewById(R.id.celcius_input);
        kelvin=findViewById(R.id.kelvin_input);
        fahrenheit=findViewById(R.id.fahreheit_input);
        submit=findViewById(R.id.submit_button);
        clear=findViewById(R.id.clear_Button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celciusvalue=celcius.getText().toString();
                String kelvinvalue=kelvin.getText().toString();
                String fahrenheitvalue=fahrenheit.getText().toString();
                if(celciusvalue.length()!=0){
                    double fahrenheitconv=((Double.parseDouble(celciusvalue)*9)/5)+32;
                    double kelvinconv=Double.parseDouble(celciusvalue)+273;
                    kelvin.setText(String.valueOf(kelvinconv));
                    fahrenheit.setText(String.valueOf(fahrenheitconv));
                }
                else if(kelvinvalue.length()!=0){
                    double celciusconv=Double.parseDouble(kelvinvalue)-273;
                    double fahrenheitconv=(((Double.parseDouble(kelvinvalue)-273)
                            *9)/5)+32;
                    celcius.setText(String.valueOf(celciusconv));
                    fahrenheit.setText(String.valueOf(fahrenheitconv));
                }
                else if(fahrenheitvalue.length()!=0){
                    double kelvinconv=(Double.parseDouble(fahrenheitvalue) - 32) * 5/9 + 273;
                    double celciusconv=((Double.parseDouble(fahrenheitvalue)) - 32) * 5/9;
                    kelvin.setText(String.valueOf(kelvinconv));
                    celcius.setText(String.valueOf(celciusconv));
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                celcius.setText("");
                kelvin.setText("");
                fahrenheit.setText("");
            }
        });
    }
}