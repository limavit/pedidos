package com.limadev.pedidos.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
		if (verificaExistencia(obj)) {
			throw new DbException("Este item já existe, favor inserir outro. Ou atualizar existente.");
		}
		String sql = "INSERT INTO t_estoque(name, quantity, lastUpdate, item_fk) VALUES (?,?,current_timestamp(),?)";
		IngredienteDAO ingredienteDao = DAOFactory.createIngredienteDao();
		Integer cont = ingredienteDao.countId(obj.getFk());
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, obj.getName().toUpperCase());
			st.setInt(2, obj.getQuantity());
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

	private boolean verificaExistencia(Estoque obj) {
		
		
		if (findByName(obj.getName()) != null) {
			return true;
		}
		
		return false;
	}

	@Override
	public void update(Integer codEstoque, Integer newQuantity) {
		PreparedStatement st = null;
		String sql = "UPDATE t_estoque SET quantity = ? WHERE codEstoque = ?";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, newQuantity);
			st.setInt(2, codEstoque);
			int rowsAffected = st.executeUpdate();
			System.out.println("Codigo: " + codEstoque);
			System.out.println("Nova quantidade: " + newQuantity);
			if (rowsAffected == 0) {
				throw new DbException("Código não encontrado no estoque");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Estoque findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT name, quantity, lastUpdate, item_fk FROM t_estoque WHERE codEstoque = ?";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Estoque est = instanciateEstoque(rs);
				return est;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	public Estoque findByName(String name) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT name, quantity, lastUpdate, item_fk FROM t_estoque WHERE name = ?";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Estoque est = instanciateEstoque(rs);
				return est;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Estoque> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT name, quantity, lastUpdate, item_fk FROM t_estoque";
		List<Estoque> estoques = new ArrayList<>();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				Estoque estoque = instanciateEstoque(rs);
				estoques.add(estoque);
			}
			return estoques;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	private Estoque instanciateEstoque(ResultSet rs) throws SQLException{
		Estoque obj = new Estoque(null, 0, null, 0);
		obj.setName(rs.getString("name"));
		obj.setQuantity(rs.getInt("quantity"));
		obj.setLastUpDate(rs.getString("lastUpdate"));
		obj.setFk(rs.getInt("item_fk"));
		return obj;
	}

}
