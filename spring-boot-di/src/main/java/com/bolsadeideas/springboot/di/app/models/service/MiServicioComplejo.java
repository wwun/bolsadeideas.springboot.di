package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Component
//@Service("miServicioComplejo")	//es una fachada de @Componente, creada para que sea una etiqueta más descriptiva, no hay diferencia entre usar uno o otro
public class MiServicioComplejo implements IServicio{
	
	@Override
	public String operacion() {
		return "Ejecutando proceso complicado...";
	}
}
