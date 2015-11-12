/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validadores;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 *
 * @author rogelio.montero
 */
@FacesValidator("validadorEnteroTexto")
public class ValidadorEnteroTexto implements Validator{
 /**
  * Lanza excepcion si el texto es nulo, vacio, tamaño mayor al maximo(255
  * default) El mensaje avisa del error y muestra el valor missing permitido
  * (NHD default)
  * @param context
  * @param component
  * @param value
  * @throws ValidatorException
  */
 @Override
 public void validate(FacesContext context,UIComponent component,Object value)
         throws ValidatorException{
  //Si no se tiene este atributo, la variable valorMissing tiene valor null
  String valorMissing=(String)component.getAttributes().get("valorMissing");
  if(valorMissing==null)
   valorMissing="NHD";

  Integer maximo=Integer.valueOf((String)component.getAttributes().get("max"));
  Integer minimo=Integer.valueOf((String)component.getAttributes().get("min"));
  if(maximo==null)
   maximo=255;
  if(minimo==null)
   minimo=0;
  try{
   if(((String)value).equalsIgnoreCase(valorMissing))
    return;
   Integer texto=Integer.parseInt((String)value);
   if(value==null)
    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Texto nulo, utilizar el valor missing asignado:"+valorMissing,null));
   if(texto<minimo)
    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "El valor no puede ser menor a "+minimo,null));
   if(texto>maximo)
    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "El valor no puede ser mayor a "+maximo,null));
  }catch(NumberFormatException nfe){
   throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
           "El valor "+((String)value)+" no tiene un formato valido",
           null));
  }
 }
}
