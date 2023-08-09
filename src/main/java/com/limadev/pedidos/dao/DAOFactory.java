package com.limadev.pedidos.dao;

import com.limadev.pedidos.dao.impl.EstoqueDAOJDBC;
import com.limadev.pedidos.dao.impl.IngredienteDAOJDBC;
import com.limadev.pedidos.dao.impl.ItemDAOJDBC;
import com.limadev.pedidos.dao.impl.LancheDAOJDBC;
import com.limadev.pedidos.db.DB;

public class DAOFactory {
	public static ItemDAO createItemDao() {
		return new ItemDAOJDBC(DB.getConnection());
	}
	
	public static LancheDAO createLancheDao() {
		return new LancheDAOJDBC(DB.getConnection());
	}
	public static IngredienteDAO createIngredienteDao() {
		return new IngredienteDAOJDBC(DB.getConnection());
	}
	public static EstoqueDAO createEstoqueDao() {
		return new EstoqueDAOJDBC(DB.getConnection());
	}

}
