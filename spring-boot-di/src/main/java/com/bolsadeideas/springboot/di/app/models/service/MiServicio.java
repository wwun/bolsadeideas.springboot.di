package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Component
//@Service("miServicioSimple")	//es una fachada de @Componente, creada para que sea una etiqueta más descriptiva, no hay diferencia entre usar uno o otro
//@Primary	//este es el servicio por defecto, porque hay dos clases implementando IServicio y con el mismo nombre de método que se está usando en IndexController (método 1 para definir cuál tiene priori)
public class MiServicio implements IServicio{
	
	@Override
	public String operacion() {
		return "Ejecutando proceso simple...";
	}
}
