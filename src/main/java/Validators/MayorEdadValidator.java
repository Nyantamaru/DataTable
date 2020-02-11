
package Validators;
import javax.faces.application.FacesMessage;
import javax.faces.validator.Validator;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="MayorEdadValidator")
public class MayorEdadValidator implements Validator {
 
  @Override
  public void validate(FacesContext context, UIComponent toValidate, Object value)
    throws  ValidatorException{
     
      String texto= String.valueOf(value);
      int edad = Integer.parseInt(texto);
      
      if(edad < 18){
      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"edad no permitida","debe ser mayor a 18 anios ");
      throw new ValidatorException(msg);
      }
      
  } 
    
}
