package com.limadev.pedidos.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.limadev.pedidos.dao.ItemDAO;
import com.limadev.pedidos.entities.Item;

public class ItemDAOJDBC implements ItemDAO{
	private Connection conn;

	public ItemDAOJDBC(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public void insert(Item obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Item obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
