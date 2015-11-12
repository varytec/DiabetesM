/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validadores;
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
@FacesValidator(value="validadorCategoria")
public class ValidadorCategoria implements Validator{
 @Override
 public void validate(FacesContext context,UIComponent component,Object value)
         throws ValidatorException{

  if(component.getAttributes().get("values")==null)
   throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
           "Configuración no valida, faltan la lista de valores ",null));
  if(component.getAttributes().get("valorMissing")==null)
   throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
           "Configuración no valida, faltan el valor missing",null));

  String s=(String)component.getAttributes().get("values");
  String valorMissing=(String)component.getAttributes().get("valorMissing");
  if(!s.contains("|")){
  }else{
   StringTokenizer st=new StringTokenizer(s,"|");
   while(st.hasMoreTokens()){
    String v="";
    if(value!=null)
     try{
      v=(String)value;
     }catch(Exception e){
      v=((Integer)value).toString();
     }

    String x=st.nextToken();

    if(v.equalsIgnoreCase(x))
     return;
   }
   if(value==null)
    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Valores permitidos : "+s,null));
  }
  if(!valorMissing.contains("|")){
   if(((Integer)value).toString().equalsIgnoreCase(valorMissing)){
    return;
   }
   throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
           "Valor "+value+" no permitido : "+s,null));
  }else{
   StringTokenizer stvm=new StringTokenizer(valorMissing,"|");
   while(stvm.hasMoreTokens()){
    String vm=stvm.nextToken();
    if(((Integer)value).toString().equalsIgnoreCase(vm))
     return;
   }
   throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
           "Valor "+value+" no permitido : "+s,null));
  }
 }
}
