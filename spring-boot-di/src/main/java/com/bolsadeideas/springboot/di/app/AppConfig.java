package com.bolsadeideas.springboot.di.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;

//3era forma de registrar componentes, si las clases que implementan IServicio no tuvieran @Component o @Service ni @Primary
@Configuration	//configura la clase para qe sea administrada por spring
public class AppConfig {

	@Bean("miServicioSimple")
	@Primary
	public IServicio registrarMiServicio() {// a esto lo llama spring al iniciar, lo qe retorna será administrado por spring
		return new MiServicio();
	}
	
	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComlejo() {// a esto lo llama spring al iniciar, lo qe retorna será administrado por spring
		return new MiServicioComplejo();
	}
}
