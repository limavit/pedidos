package com.limadev.pedidos.dao;

import java.util.List;

import com.limadev.pedidos.entities.Ingrediente;

public interface IngredienteDAO {
	void insert(Ingrediente obj);
	void update(Ingrediente obj, String newName);
	void deleteById(Integer id);
	Ingrediente findByName(String name);
	List<Ingrediente> findAll();

}
