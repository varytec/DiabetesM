/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validadores;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 * Valida si el dato es un numero real, si esta dentro del rango cerrado
 * especificado o si corresponde al valor missing asignado, el valor missing
 * debe estar fuera del rango asignado y se valida primero
 *
 * @author rogelio.montero
 */
@FacesValidator(value="validadorNumeroReal")
public class ValidadorNumeroReal implements Validator{
 @Override
 public void validate(FacesContext context,UIComponent component,Object value)
         throws ValidatorException{

  Double valorMissing=(-1.0);
  Double min=0.0;
  Double max=500.0;

  if(component.getAttributes().get("valorMissing")!=null)
   try{
    valorMissing=Double.valueOf((String)component.getAttributes().get(
            "valorMissing"));
   }catch(RuntimeException re){
    valorMissing=(-1.0);
   }
  if(component.getAttributes().get("min")!=null)
   try{
    min=Double.valueOf((String)component.getAttributes().get(
            "min"));
   }catch(RuntimeException re){
    min=0.0;
   }
  if(component.getAttributes().get("max")!=null)
   try{
    max=Double.valueOf((String)component.getAttributes().get(
            "max"));
   }catch(RuntimeException re){
    max=500.0;
   }
  
  if(min<=valorMissing && valorMissing<=max){
   throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
           "Configuracion invalida, el valor missing '"+valorMissing+"' esta entre el rango ["+min+" - "+max+"]",
           null));
  }

  //Si el numero es null mostramos el error con el valor missing disponible

  if(value==null)
   throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
           "Numero vacio, utilizar el valor missing asignado:"+valorMissing,
           null));
  Double numero;

  try{

   if(value.getClass().equals(Double.class))
    numero=(Double)value;
   else
    numero=Double.valueOf((String)value);

  }catch(Exception re){
   //El valor no representa un numero real
   throw new ValidatorException(
           new FacesMessage(FacesMessage.SEVERITY_ERROR,
           "El valor '"+value+"' no es un numero real",null));
  }
  //Si el numero es diferente al valor missing entonces es un numero valido
  
  if(!numero.equals(valorMissing))
   //si no es el valor missing debe validarse que este en el rango asignado
   if(min>numero||numero>max)
    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "El numero '"+numero+"' fuera del rango ["+min+" - "+max+"]",null));

 }
}
