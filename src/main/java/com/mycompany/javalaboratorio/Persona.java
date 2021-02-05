/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javalaboratorio;

import java.util.Date;

/**
 *
 * @author nelsonsolorzano
 */
public class Persona {
      private String identificacion;
    private String nombre;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;
    private String genero;
    private String estadoCivil;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Persona{\n" + "identificacion=" + identificacion + ", \nnombre=" + nombre + 
                ", \nfechaNacimiento=" + fechaNacimiento + ", \ndireccion=" + direccion 
                + ", \ntelefono=" + telefono + ", \nemail=" + email + ", \ngenero=" 
                + genero + ", \nestadoCivil=" + estadoCivil +"\n"+ '}';
    }
}
