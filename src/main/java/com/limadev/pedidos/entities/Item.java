package com.limadev.pedidos.entities;

import com.limadev.pedidos.entities.enums.Tipo;

public class Item {
	private Integer id;
	private String name;
	private Tipo tipo;
	public Item(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Item(String name, Tipo tipo) {		
		this.name = name;
		this.tipo = tipo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id: " + getName() + 
				" \tNome: "  + getName() + "\n";
	}


}
