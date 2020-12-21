/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.uv.dao.Persona;
//import org.uv.dao.PersonaDAO;

/**
 *
 * @author gusky
 */
@ManagedBean
@SessionScoped
public class IndexBean {
    private Persona pojo;
    RestClient rest = new RestClient();
    private List<Persona> consulta;
    
    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean() {
        pojo = new Persona();
    }
    
    public void ingresar(){
        rest.postJson(pojo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nuevo","Registro Exitoso"));
        pojo = new Persona();
    }
    public void mostrar(){
        consulta = rest.getJson(consulta);
        System.out.println(consulta.get(0).getNombre());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nuevo","Registro Exitoso"));
        pojo=new Persona();
    }
    
    public void eliminar(){
        rest.deleteJson(pojo.getClave());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Eliminar", "Registro eliminado"));
        pojo=new Persona();
    }
    
    public void actualizar(){
        rest.putJson(pojo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Actualizar", "Registro actualizado"));
        pojo=new Persona();
    }   
   
    public Persona getPojo() {
        return pojo;
    }

    public void setPojo(Persona pojo) {
        this.pojo = pojo;
    }

//    public PersonaDAO getDao() {
//        return dao;
//    }
//
//    public void setDao(PersonaDAO dao) {
//        this.dao = dao;
//    }

    public List<Persona> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Persona> consulta) {
        this.consulta = consulta;
    }
    
    
    
}
