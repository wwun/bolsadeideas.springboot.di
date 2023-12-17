package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {
	//private MiServicio servicio = new MiServicio(); //para desacoplar, se hace uso de Autowired
	
	@Autowired
	//@Qualifier("miServicioComplejo")	//este es otro método para definir cuál de los dos servicios que implementan IServicio se va a utilizar. Por defecto está MiServicio y en este caso se quiere implementar MiServicioCompl
	private IServicio servicio;	//private MiServicio servicio;
			
	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}

}
