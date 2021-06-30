package com.example.ejemploempleado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumeroEmpleado, editTextApellido, editTextOficio, editTextSalario, editTextComision;
    TextView  textViewDatosEmpleado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editTextNumeroEmpleado = (EditText) findViewById(R.id.editTextNumeroEmpleado);
        this.editTextApellido = (EditText) findViewById(R.id.editTextApellido);
        this.editTextOficio = (EditText)  findViewById(R.id.editTextOficio);
        this.editTextSalario = (EditText)  findViewById(R.id.editTextSalario);
        this.editTextComision = (EditText)  findViewById(R.id.editTextComision);
        this.textViewDatosEmpleado = (TextView) findViewById(R.id.textViewDatosEmpleado);

    }

    public void mandarDatos(View view) {
        //Recojo el valor de los radio button que ha seleccionado el usuario.
        //Si es indiferente, bloqueo los checks.

        //recojo los valores de los edtiText
        String numeroEmpleado = this.editTextNumeroEmpleado.getText().toString();
        String apellido = this.editTextApellido.getText().toString();
        String oficio= this.editTextOficio.getText().toString();
        double salario=0.0;
        double comision = 0.0;
        String mensaje="";

        if (numeroEmpleado.isEmpty()) {
            mensaje = mensaje + "  el número empleado; ";
        }

        if (apellido.isEmpty()) {
            mensaje = mensaje + "  el apellido; ";
        }
        if (oficio.isEmpty()) {
            mensaje = mensaje + "  el oficio; ";
        }
        if (this.editTextSalario.getText().toString().equals("") ) {
            mensaje = mensaje + "  el salario; ";
        }
        if (this.editTextComision.getText().toString().equals("") ) {
            mensaje = mensaje + "  la comisión; ";
        }
        if (this.editTextComision.getText().toString().equals("")) {
            comision = 0.0;
        }
        if (this.editTextSalario.getText().toString().equals("")) {
            salario=0.0;

        } else {
            salario= Double.parseDouble(this.editTextSalario.getText().toString());
        }
        if (this.editTextComision.getText().toString().equals("")) {
             comision = 0.0;

        }
            else {
                comision= Double.parseDouble(this.editTextComision.getText().toString());
            }


        if (numeroEmpleado.isEmpty() || apellido.isEmpty() || oficio.isEmpty()|| salario==0.0 || comision ==0.0 ) {
            esconderTeclado();
            Toast.makeText(this, "Introduce  " + mensaje + "  huevón", Toast.LENGTH_LONG).show();
        } else {
            Empleado dataEmpleado = new Empleado (numeroEmpleado, apellido, oficio, salario, comision);

            Intent i = new Intent(this, Ventana2.class);

            Bundle bundle = new Bundle();
            bundle.putSerializable("datoempleado", dataEmpleado);
            i.putExtras(bundle);
            startActivity(i);
        }


    }

    /**
     * Esconde el teclado
     */

    public void esconderTeclado() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * Shows the soft keyboard

    public void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }  */
}