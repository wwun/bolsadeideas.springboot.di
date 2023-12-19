package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//@RequestScope	//cambia el componente y deja de ser singleton por defecto y va a durar lo que dura una petición, cada usuario va a tener una factura distinta
@SessionScope	//dura lo que dura una sesión incluyendo time out o se si se envalida la sesión, debe implementar serializable
public class Factura implements Serializable{ //implementa serializable porque se está usando sessionScope

	private static final long serialVersionUID = 946004357128146951L;	//se debe generar al implementar serializable

	@Value("${factura.descripcion}")
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;
	
	@PostConstruct	//se ejecuta después de que se haya creado el objeto y se haya inyectado la dependencia
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Isaac"));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	@PreDestroy	//esta etiqueta no  se ejecuta cuando se trabaja con @SessionScope sino con @RequestScope
	public void destruir() {
		System.out.println("Factura destruida: ".concat("descripcion"));
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ItemFactura> getItems() {
		return items;
	}
	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
}
