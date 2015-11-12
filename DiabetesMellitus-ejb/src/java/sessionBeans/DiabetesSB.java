/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;


import entidades.Diabetes;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateful
@LocalBean
public class DiabetesSB {

 public static int EXITO = 1;
 public static int ENTIDAD_EXISTENTE = 0;

   
 @PersistenceContext(unitName = "DiabetesMellitus-ejbPU")
 private EntityManager em;

 public Diabetes obtenerTarjetaPorExpediente(int expediente) {
  Query q = em.createNamedQuery("Diabetes.findById");
  q.setParameter("f", expediente);
  List<Diabetes> rm = q.getResultList();
  if (rm.isEmpty()) {
   return null;
  } else {
   return rm.get(0);
  }
 }

 public int guardarTarjeta(Diabetes r) {
  System.out.println("Guardando " + r.getP05expediente());
  Diabetes rm = obtenerTarjetaPorExpediente(r.getP05expediente());
  if (rm == null) {
   em.persist(r);
   return EXITO;
  } else {
   return ENTIDAD_EXISTENTE;
  }
 }
 
 public List<Diabetes> obtenerSeguimientosMenores(){
  
  Query q=em.createNamedQuery("Diabetes.findAll");
  
  return q.getResultList();
 }
}
