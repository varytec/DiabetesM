/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Diabetes;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sessionBeans.DiabetesSB;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class DiabetesMB implements Serializable{

    
    private Diabetes diabetes;
    private String usuario;
   
     
    /**
     * Creates a new instance of DiabetesMB
     */
    public DiabetesMB() {
        diabetes= new Diabetes();
    }

    public Diabetes getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Diabetes diabetes) {
        this.diabetes = diabetes;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String guardarTarjetaDiabetes() {
     int resultado = DiabetesSB.guardarTarjeta(diabetes);
  if (resultado == DiabetesSB.ENTIDAD_EXISTENTE) {
   FacesContext context = FacesContext.getCurrentInstance();
   context.addMessage(null, new FacesMessage(
           FacesMessage.SEVERITY_WARN,
           "Error, ya existe un registro con el mismo expediente.",
           null));
   
  }else{
   FacesContext context = FacesContext.getCurrentInstance();
   context.addMessage(null, new FacesMessage(
           FacesMessage.SEVERITY_INFO,
           "Guardado con exito",
           null));
  
  }
  reset();
  return null;
 }

 public String reset() {
  diabetes = new Diabetes();
 
  return null;
 }

    
    
    
}
