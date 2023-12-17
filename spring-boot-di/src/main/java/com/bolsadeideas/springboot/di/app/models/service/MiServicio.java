package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.stereotype.Service;

//@Component
@Service	//es una fachada de @Componente, creada para que sea una etiqueta más descriptiva, no hay diferencia entre usar uno o otro
public class MiServicio {
	public String operacion() {
		return "Ejecutando proceso...";
	}
}
