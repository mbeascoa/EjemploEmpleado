package com.example.ejemploempleado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;



public class Ventana2 extends AppCompatActivity {


    TextView mostrarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);



        Intent inta = getIntent();
        Empleado empleadodata = (Empleado) inta.getSerializableExtra("datoempleado");
        String num=empleadodata.getIdEmpleado();
        String ape=empleadodata.getApellido();
        String ofi=empleadodata.getOficio();
        double sal=empleadodata.getSalario();
        double com=empleadodata.getComision();
        double salbruto = sal+com;
        double salneto= salbruto*0.85;
        String salbrutostr = String.valueOf(salbruto);
        String salnetostr = String.valueOf(salneto);

        mostrarDatos = findViewById(R.id.textViewDatosEmpleado);
        this.mostrarDatos.setText(Html.fromHtml(" <BR/> <BR/>  ------------------ <BR/>  " + "  Número Empleado : " +num+ "    "
                        +" Apellido :  " + ape+ "<BR/>" + "<BR/>" +  "OFICIO : " + ofi + "<BR/>" + "<BR/>" +  " SALARIO BRUTO : $" + salbrutostr +
                        "<BR/> <BR/> SALARIO NETO =:   "+
                        salnetostr +" <BR/> <BR/>  ------------------  ")
                , TextView.BufferType.SPANNABLE);

    }

    public void cerrarVentana2 (View view) {
        finish();
    }
}