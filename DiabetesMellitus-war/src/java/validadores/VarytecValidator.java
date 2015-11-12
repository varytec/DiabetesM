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
@FacesValidator("varytecValidator")
public class VarytecValidator implements Validator{
 private static final int RANGO_FECHAS=1;
 private static final int RANGO_VALORES=2;
 private static final int VALORES=3;
 private static final int FOLIO=4;
 private int type;
 @Override
 public void validate(FacesContext context,UIComponent component,Object value)
         throws ValidatorException{
  if(component.getAttributes().get("startDate")!=null||component.getAttributes().
          get("endDate")!=null)
   type=RANGO_FECHAS;
  else
   if(component.getAttributes().get("minValue")!=null||component.getAttributes().
           get("maxValue")!=null)
    type=RANGO_VALORES;
   else
    if(component.getAttributes().get("values")!=null)
     type=VALORES;
    else
     if(component.getAttributes().get("folio")!=null)
      type=FOLIO;
     else
      return;

  switch(type){
   case RANGO_FECHAS:
    SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
    Date start;
    Date end;
    try{
     start=f.parse((String)component.getAttributes().get("startDate"));
     end=f.parse((String)component.getAttributes().get("endDate"));
    }catch(ParseException pe){
     start=null;
     end=null;
    }
    if(start==null||end==null)
     return; // Let required="true" handle.
    else{
     Date testDate=null;

     testDate=(Date)value;
     try{
      if(start.before(testDate)&&testDate.before(end))
       return;
      else
       throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
               "Fecha fuera del rango "+f.format(start)+"-"+f.format(end),null));
     }catch(NullPointerException npe){
      return;
     }
    }
   case RANGO_VALORES:
    double min=Double.valueOf((String)component.getAttributes().get("minValue")).
            doubleValue();
    double max=Double.valueOf((String)component.getAttributes().get("maxValue")).
            doubleValue();
    if(min>max){
     double t=min;
     min=max;
     max=t;
    }
    if(value==null||((String)value).equals(""))
     return;
    double val=0;
    try{
     val=Double.valueOf((String)value);
    }catch(Exception e){
     throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
             "Introducir un valor numerico dentro del rango ["+min+","+max+"]",
             null));
    }
    if(min<=val&&val<=max)
     return;
    else
     throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
             "Valor fuera del rango ["+min+","+max+"]",null));

   case VALORES:
    String s=(String)component.getAttributes().get("values");
    if(!s.contains("|")){
    }else{
     StringTokenizer st=new StringTokenizer(s,"|");
     while(st.hasMoreTokens()){
      String v=(String)value;
      String x=st.nextToken();
      if(v.equalsIgnoreCase(x))
       return;
     }
     throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
             "Valor no permitido : "+s,null));
    }
   case FOLIO:
    String folio=(String)value;

    String tipofolio=(String)component.getAttributes().get("folio");

    if(tipofolio.equalsIgnoreCase("reclutamientoMenor"))
     if(!folio.matches(
             "(H|C|T)([0-9][0-9][1-9]|[0-9][1-9][0-9]|[1-9][0-9][0-9])([0-9][1-9]|[1-9][0-9])(V|N|A)"))
      throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
              "Folio inválido : "+folio,null));
    if(tipofolio.equalsIgnoreCase("seguimientoMenor"))
     if(!folio.matches(
             "(H|C|T)([0-9][0-9][1-9]|[0-9][1-9][0-9]|[1-9][0-9][0-9])([0-9][1-9]|[1-9][0-9])(V|N|A)([0-9]{6})(A|B|C|D|E|F|G|H|I|J)"))
      throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
              "Folio inválido : "+folio,null));
    if(tipofolio.equalsIgnoreCase("muestra"))
     if(!folio.matches(
             "(H|C|T)([0-9][0-9][1-9]|[0-9][1-9][0-9]|[1-9][0-9][0-9])([0-9][1-9]|[1-9][0-9])(V|N|A)([0-9]{6})(A|B|C|D|E|F|G|H|I|J)[1|2|3|4]"))
      throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
              "Folio inválido : "+folio,null));
  }
 }
}
