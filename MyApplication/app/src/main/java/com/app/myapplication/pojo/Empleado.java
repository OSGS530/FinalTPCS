package com.app.myapplication.pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Empleado {
    @SerializedName("clave")
    @Expose
    private String clave;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("direccion")
    @Expose
    private String direccion;

    @SerializedName("telefono")
    @Expose
    private String telefono;


    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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


}
