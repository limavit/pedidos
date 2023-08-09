package com.limadev.pedidos.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.limadev.pedidos.dao.LancheDAO;
import com.limadev.pedidos.entities.Lanche;

public class LancheDAOJDBC implements LancheDAO{
	private Connection conn;

	public LancheDAOJDBC(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public void insert(Lanche obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Lanche obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Lanche> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
