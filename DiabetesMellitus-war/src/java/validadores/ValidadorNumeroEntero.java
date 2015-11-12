/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validadores;
//import com.sun.msv.verifier.regexp.StringToken;
import java.util.StringTokenizer;
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
@FacesValidator(value="validadorNumeroEntero")
public class ValidadorNumeroEntero implements Validator{
 @Override
 public void validate(FacesContext context,UIComponent component,Object value)
         throws ValidatorException{

  Integer numero;
  try{

   if(value.getClass().equals(Integer.class))
    numero=(Integer)value;
   else
    numero=Integer.valueOf((String)value);

  }catch(Exception re){
   //El valor no representa un numero real
   throw new ValidatorException(
           new FacesMessage(FacesMessage.SEVERITY_ERROR,
           "El valor '"+value+"' no es un numero entero",null));
  }

  String vm=(String)component.getAttributes().get("valorMissing");
  if(vm.contains("|")){
   StringTokenizer st=new StringTokenizer(vm,"|");
   while(st.hasMoreTokens())
    if(numero.toString().equalsIgnoreCase(st.nextToken()))
     return;
  }else{
   if(numero.equals(Integer.valueOf((String)component.getAttributes().get(
           "valorMissing")))){
    return;
   }
  }



//  Integer valorMissing=(-1);
  Integer min=0;
  Integer max=500;
//
//  if(component.getAttributes().get("valorMissing")!=null)
//   try{
//    valorMissing=Integer.valueOf((String)component.getAttributes().get(
//            "valorMissing"));
//   }catch(RuntimeException re){
//    valorMissing=(-1);
//   }
  if(component.getAttributes().get("min")!=null)
   try{
    min=Integer.valueOf((String)component.getAttributes().get(
            "min"));
   }catch(RuntimeException re){
    min=0;
   }
  if(component.getAttributes().get("max")!=null)
   try{
    max=Integer.valueOf((String)component.getAttributes().get(
            "max"));
   }catch(RuntimeException re){
    max=500;
   }
//
//  if(min<=valorMissing&&valorMissing<=max)
//   throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
//           "Configuracion invalida, el valor missing '"+valorMissing+
//           "' esta entre el rango ["+min+" - "+max+"]",
//           null));

  //Si el numero es null mostramos el error con el valor missing disponible

  if(value==null)
   throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
           "Numero vacio, utilizar el valor missing asignado:"+
           (String)component.getAttributes().get("valorMissing"),
           null));

  //Si el numero es diferente al valor missing entonces es un numero valido

  
   //si no es el valor missing debe validarse que este en el rango asignado
   if(min>numero||numero>max)
    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "El numero '"+numero+"' fuera del rango ["+min+" - "+max+"]",null));
 }
}
