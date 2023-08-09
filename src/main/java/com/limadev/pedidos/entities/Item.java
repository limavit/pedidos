package com.limadev.pedidos.entities;


public class Item {
	private Integer id;
	private String name;
	private String tipo;
	public Item(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Item(String name, String tipo) {		
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
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id: " + getName() + 
				" \tNome: "  + getName() + "\n";
	}


}
