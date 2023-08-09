package com.limadev.pedidos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.limadev.pedidos.dao.EstoqueDAO;
import com.limadev.pedidos.db.DB;
import com.limadev.pedidos.db.DbException;
import com.limadev.pedidos.entities.Estoque;

public class EstoqueDAOJDBC implements EstoqueDAO{
	private Connection conn;
	

	public EstoqueDAOJDBC(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public void insert(Estoque obj) {
		PreparedStatement st = null;
		String sql = "INSERT INTO t_estoque(name, quantity, lastUpdate, item_fk) VALUES (?,?,NOW(),?)";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, obj.getName());
			st.setInt(2, obj.getQuantity());
			st.setInt(3, obj.getFk());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Estoque obj, Integer quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItemInEstoque(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Estoque findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estoque> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	private boolean findfk(Estoque obj) {
		// verificar se existe FK com o objeto passado
		return false;
	}

}
