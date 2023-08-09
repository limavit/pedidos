package com.limadev.pedidos.entities;

import java.util.List;

public class Lanche extends Item{
	private List<Ingrediente> ingredientes;

	public Lanche(Integer id, String name ) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	public Lanche(String name, String tipo) {
		super(name, tipo);
	}

	public void addIngrediente(Ingrediente ingrediente) {
		ingredientes.add(ingrediente);
	}
	public void removeIngrediente(Ingrediente ingrediente) {
		ingredientes.remove(ingrediente);
	}

	
	

}
