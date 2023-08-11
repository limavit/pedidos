package com.limadev.pedidos.entities;

public class Estoque {
	private String name;
	private int quantity;
	private String lastUpdate;
	private int fk;
	
	public Estoque(String name, int quantity, String lastUpdate, int fk) {
		this.name = name;
		this.quantity = quantity;
		this.lastUpdate = lastUpdate;
		this.fk = fk;
	}
	public Estoque(String name, int quantity, int fk) {
		this.name = name;
		this.quantity = quantity;
		this.fk = fk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpDate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public int getFk() {
		return fk;
	}
	public void setFk(int fk) {
		this.fk = fk;
	}
	
	

}
