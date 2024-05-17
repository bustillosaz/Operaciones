package com.zbadev.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText etnumero1, etnumero2;
    Spinner spoperaciones;
    Button btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnumero1=findViewById(R.id.etNumero1);
        etnumero2=findViewById(R.id.etNumero2);
        spoperaciones=findViewById(R.id.spOperaciones);

        String[] operaciones= {"SUMA", "RESTA", "MULTIPLICACION", "DIVISION"};
        ArrayAdapter<String> adaptador= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operaciones);
        spoperaciones.setAdapter(adaptador);
    }

    public void MostrarResultado(View v){
        Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
        int numero1 = Integer.parseInt(etnumero1.getText().toString());
        int numero2 = Integer.parseInt(etnumero2.getText().toString());
        String operaciones = spoperaciones.getSelectedItem().toString();
        intent.putExtra("numero1",numero1);
        intent.putExtra("numero2",numero2);
        intent.putExtra("operacion", operaciones);

        startActivity(intent);
    }
}