
package beans;
import clases.*;

import java.util.*;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;



@Named(value = "personaBean")
@RequestScoped
public class personaBean implements Serializable {

    
    private Persona persona = new Persona();
    private static  List<Persona> lstPersonas = new ArrayList();
            
    public personaBean() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        personaBean.lstPersonas = lstPersonas;
    }

    public void agregarPersona(){
    personaBean.lstPersonas.add(this.persona);
    }

 
    public void eliminarPersona(Persona per){
    personaBean.lstPersonas.remove(per);
    
    }
    public void validar(FacesContext context, 
            UIComponent toValidate, Object value){
   context = FacesContext.getCurrentInstance();
   String texto = (String)value;
   
   
   if(!texto.equalsIgnoreCase("M") && !texto.equalsIgnoreCase("F")){
       ((UIInput)toValidate).setValid(false); 
       context.addMessage(toValidate.getClientId(context),new FacesMessage("Sexo no valido"));
   } 
       
    }
}
