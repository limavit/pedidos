package com.limadev.pedidos.dao;

import java.util.List;

import com.limadev.pedidos.entities.Estoque;


public interface EstoqueDAO {
	void insert(Estoque obj);
	void update(Estoque obj, Integer quantity);
	void removeItemInEstoque(Integer id);
	Estoque findByName(String name);
	List<Estoque> findAll();

}
