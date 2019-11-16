package com.example.crud_recetario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Enombre,Eingredientes,Ecategoria;
    Button guardar,recetario ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Enombre= (EditText)findViewById(R.id.et_nombre);
        Eingredientes= (EditText)findViewById(R.id.et_ingredientes);
        Ecategoria= (EditText)findViewById(R.id.et_categoria);

        guardar=(Button)findViewById(R.id.guardar);
        recetario=(Button)findViewById(R.id.recetario);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB db = new DB(getApplicationContext(),null,null,1);
                String nombre = Enombre.getText().toString();
                String ingredientes = Eingredientes.getText().toString();
                String categoria = Ecategoria.getText().toString();

                String mensaje = db.guardar(nombre, ingredientes, categoria);
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });
        recetario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent ventana = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(ventana);
            }
        });
    }
}
