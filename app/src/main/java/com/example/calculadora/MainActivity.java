package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.nio.file.SecureDirectoryStream;


public class MainActivity extends AppCompatActivity {

    float numero1, numero2;
    EditText num1, num2;
    private RegistroViewModel mViewModel;
    Spinner dropdown;
    String res;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get the spinner from the xml.
        dropdown = findViewById(R.id.spinner);
        num1 = findViewById(R.id.editText_1);
        num2 = findViewById(R.id.editText_2);
        final TextView resultado = findViewById(R.id.textView_resultado);
        Button calcular = findViewById(R.id.button_1);

        String[] items = new String[]{"+", "-", "/", "*"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("resultado");
                num1.setText("");
                num2.setText("");
            }
        });
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if(!num1.getText().toString().isEmpty() && !num2.getText().toString().isEmpty()){
                    numero1 = Float.valueOf(num1.getText().toString());
                    numero2 = Float.valueOf(num2.getText().toString());
                    if(id == 0){
                        res = String.valueOf(numero1 + numero2);
                    }else if (id == 1){
                        res = String.valueOf(numero1 - numero2);
                    }else if(id ==2){
                        res = String.valueOf(numero1 / numero2);
                    }else if(id == 3){
                        res = String.valueOf(numero1 * numero2);
                    }
                    mViewModel = ViewModelProviders.of(MainActivity.this).get(RegistroViewModel.class);
                    //mViewModel.insertarRegistro(new RegistroEntity(res));
                    resultado.setText(res);
                }
                System.out.println("QQQQQQQQQQQQQQQQQQQQQQ--------------PICASTE EN:");
                System.out.println(id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
