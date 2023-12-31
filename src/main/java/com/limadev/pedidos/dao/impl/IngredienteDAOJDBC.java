package com.limadev.pedidos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.limadev.pedidos.dao.IngredienteDAO;
import com.limadev.pedidos.db.DB;
import com.limadev.pedidos.db.DbException;
import com.limadev.pedidos.entities.Ingrediente;

public class IngredienteDAOJDBC implements IngredienteDAO {
	private Connection conn;

	public IngredienteDAOJDBC(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public void insert(Ingrediente obj) {
		PreparedStatement st = null;
		String sql = "INSERT INTO t_item (Name, tipo) VALUES (?,?)";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, obj.getName());
			st.setString(2, obj.getTipo().toString());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Ingrediente obj, String newName) {
		PreparedStatement st = null;
		String sql = "UPDATE t_item SET name = ? WHERE name = ?";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, newName);
			st.setString(2, obj.getName());

			int rowsAffected = st.executeUpdate();
			if (rowsAffected == 0) {
				throw new DbException("Item não existe");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		String sql = "DELETE FROM t_item WHERE id = ?";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);

			int rowsAffected = st.executeUpdate();
			if (rowsAffected == 0) {
				throw new DbException("Item não existe");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public List<Ingrediente> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, tipo FROM t_item WHERE tipo = 'INGREDIENTE'";
		List<Ingrediente> ingredientes = new ArrayList<>();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Ingrediente ing = instanciateIngrediente(rs);

				ingredientes.add(ing);

			}
			return ingredientes;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	public Ingrediente findByName(String name) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT id, name FROM t_item WHERE name = ?";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			if (rs.next()) {
				Ingrediente ing = instanciateIngrediente(rs);
				return ing;
			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	private Ingrediente instanciateIngrediente(ResultSet rs) throws SQLException {
		Ingrediente obj = new Ingrediente(1, " ");
		obj.setId(rs.getInt("id"));
		obj.setName(rs.getString("name"));
		obj.setTipo(rs.getString("tipo"));
		return obj;
	}

	@Override
	public Integer countId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Integer cont = 0;
		String sql = "SELECT id FROM t_item WHERE id = ?";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				cont = rs.getInt("id");
				
				return cont;
			}else {
			return cont;
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
