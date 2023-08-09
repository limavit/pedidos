package com.limadev.pedidos.entities;

import com.limadev.pedidos.entities.enums.Tipo;

public class Ingrediente extends Item{

	public Ingrediente(Integer id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	public Ingrediente(String name, Tipo tipo) {
		super(name,tipo);
		// TODO Auto-generated constructor stub
	}

	
	

}
