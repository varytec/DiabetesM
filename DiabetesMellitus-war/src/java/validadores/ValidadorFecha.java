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
@FacesValidator("validadorFecha")
public class ValidadorFecha implements Validator{
 private static final int RANGO_FECHAS=1;
 private static final int RANGO_VALORES=2;
 private static final int VALORES=3;
 private static final int FOLIO=4;
 private int type;
 @Override
 public void validate(FacesContext context,UIComponent component,Object value)
         throws ValidatorException{

  SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
  Date start=null;
  Date end=null;

  try{
   if(component.getAttributes().get("startDate")==null)
    start=f.parse("01/01/1900");
   else
    start=f.parse((String)component.getAttributes().get("startDate"));
   if(component.getAttributes().get("endDate")==null)
    end=new Date();
   else
    end=f.parse((String)component.getAttributes().get("endDate"));
  }catch(ParseException pe){
   throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
           "Configuracion de rango '"+f.format(start)+"'-'"+f.format(end)+"'",
           null));

  }



  Date testDate=null;
  testDate=(Date)value;

  try{
   if(start.before(testDate)&&testDate.before(end)){
   }else
    throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Fecha fuera del rango ["+f.format(start)+"] - ["+f.format(end)+"]",
            null));
  }catch(NullPointerException npe){
  }

 }
}
