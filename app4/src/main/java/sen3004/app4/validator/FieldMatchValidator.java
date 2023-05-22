package sen3004.app4.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sen3004.app4.model.FormData;

@Component
public class FieldMatchValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return FormData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		FormData formData = (FormData)target;
		if(formData.getTextField2().equals(formData.getTextField3())== false)
			errors.rejectValue("textField3", "my.custom.err");
		
	}

	
}
