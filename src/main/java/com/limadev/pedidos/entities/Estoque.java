package com.limadev.pedidos.entities;

import java.util.Date;

public class Estoque {
	private String name;
	private int quantity;
	private Date lastUpdate;
	private int fk;
	
	public Estoque(String name, int quantity, Date lastUpdate, int fk) {
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
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public int getFk() {
		return fk;
	}
	public void setFk(int fk) {
		this.fk = fk;
	}
	
	

}
