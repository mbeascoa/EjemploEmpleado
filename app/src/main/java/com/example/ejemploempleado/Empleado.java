package com.example.ejemploempleado;

import java.io.Serializable;

public class Empleado implements Serializable {


    private String idEmpleado;
    private String apellido;
    private String oficio;
    private double salario;
    private double comision;


    public Empleado(){

    }

    public Empleado(String idEmpleado, String apellido, String oficio, double salario, double comision) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.oficio = oficio;
        this.salario = salario;
        this.comision = comision;
    }

    public String getIdEmpleado() {
        return this.idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return this.oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getComision() {
        return this.comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }


}
