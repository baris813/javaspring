package sen3004.app5.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import sen3004.app5.model.Person;
import sen3004.app5.service.App5Service;

@Controller
public class App5Controller {

	@Autowired
	private App5Service service;

	@GetMapping({ "/display-form", "form.html" })
	public ModelAndView displayForm() {
		ModelAndView mv = new ModelAndView("form");
		mv.addObject("person", new Person());

		return mv;
	}

	@PostMapping("/send-form-data")
	public ModelAndView processForm(@Valid @ModelAttribute Person person, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("person", person);

		if (result.hasErrors())
			mv.setViewName("form");
		else {
			mv.setViewName("person-list");
			service.create(person);
			mv.addObject("persons", service.findAll());
		}

		return mv;
	}

	@GetMapping({ "/list-persons", "list.html" })
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("person-list");
		mv.addObject("persons", service.findAll());
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable long id) {
		ModelAndView mv = new ModelAndView("person-list");
		service.delete(id);
		mv.addObject("persons", service.findAll());
			
		return mv;
	}

}
