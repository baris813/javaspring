package sen3004.app4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import sen3004.app4.model.FormData;
import sen3004.app4.validator.FieldMatchValidator;

@Controller
public class App4Controller {

	@Autowired
	FieldMatchValidator fmv;
	
	@GetMapping({ "/display-form", "/form.html" })
	public ModelAndView displayForm() {
		ModelAndView mv = new ModelAndView("form");
		mv.addObject("formData", new FormData());

		return mv;
	}

	@PostMapping("/send-form-data")
	public ModelAndView processForm(@Valid @ModelAttribute FormData formData, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("formData", formData);
		
		fmv.validate(formData, result);
		
		if(result.hasErrors())
			mv.setViewName("form");
		else
			mv.setViewName("form-result");

		return mv;
	}

}
