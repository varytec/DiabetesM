/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Diabetes;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author User
 */
@ManagedBean
@ViewScoped
public class ControlMB implements Serializable {
    
    private Diabetes diabetes;
     private List<Diabetes> control;
    

    /**
     * Creates a new instance of CollectorMB
     */
    @PostConstruct
    public void init() {
        diabetes = new Diabetes();
        control = new ArrayList<>();
         
    }
     
    public void createNew() {
        if(control.contains(diabetes)) {
            FacesMessage msg = new FacesMessage("Registrado", "Ya esta registrado este campo");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } 
        else {
            control.add(diabetes);
            diabetes = new Diabetes();
        }
    }
     
    public String reinit() {
        diabetes = new Diabetes();
         
        return null;
    }
 
    public Diabetes getDiabetes() {
        return diabetes;
    }
 
    public List<Diabetes> getBooks() {
        return control;
    }
}
