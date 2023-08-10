package com.limadev.pedidos.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import com.limadev.pedidos.dao.DAOFactory;
import com.limadev.pedidos.dao.EstoqueDAO;
import com.limadev.pedidos.dao.IngredienteDAO;
import com.limadev.pedidos.db.DB;
import com.limadev.pedidos.db.DbException;
import com.limadev.pedidos.entities.Estoque;

public class EstoqueDAOJDBC implements EstoqueDAO {
	private Connection conn;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private LocalDateTime now = LocalDateTime.now();
	java.util.Date dataUtil = new java.util.Date();
	java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

	public EstoqueDAOJDBC(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public void insert(Estoque obj) {
		PreparedStatement st = null;
		String sql = "INSERT INTO t_estoque(name, quantity, lastUpdate, item_fk) VALUES (?,?,current_timestamp(),?)";
		IngredienteDAO ingredienteDao = DAOFactory.createIngredienteDao();
		Integer cont = ingredienteDao.countId(obj.getFk());
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, obj.getName());
			st.setInt(2, obj.getQuantity());
			// st.setDate(3, (Date) obj.getLastUpdate());
			if (cont > 0) {
				st.setInt(3, obj.getFk());
			} else {
				throw new DbException("Item não encontrado.");
			}
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Estoque obj, Integer quantity) {
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

}
