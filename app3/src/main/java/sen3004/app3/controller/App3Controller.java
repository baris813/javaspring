package sen3004.app3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import sen3004.app3.model.Person;
import sen3004.app3.model.FormData;

@Controller
public class App3Controller {

	@GetMapping({ "/display-form", "/form.html" })
	public ModelAndView displayForm() {
		ModelAndView mv = new ModelAndView("form");
		mv.addObject("formValues", new FormData());

		return mv;
	}

	@PostMapping("/send-form")
	public ModelAndView processForm(@ModelAttribute("formValues") FormData formData) {
		ModelAndView mv = new ModelAndView("form-result");
		mv.addObject("formValues", formData);

		return mv;
	}

	@GetMapping("/person-data.html")
	public ModelAndView displayPersonForm() {
		ModelAndView mv = new ModelAndView("person-form");
		mv.addObject("person", new Person());

		return mv;
	}

	@PostMapping("/send-person-data")
	public ModelAndView processPersonForm(@ModelAttribute Person person) {
		ModelAndView mv = new ModelAndView("person-form-result");
		mv.addObject("person", person);

		return mv;
	}

}
