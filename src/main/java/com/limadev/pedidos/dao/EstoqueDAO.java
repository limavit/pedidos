package com.limadev.pedidos.dao;

import java.util.List;

import com.limadev.pedidos.entities.Estoque;


public interface EstoqueDAO {
	void insert(Estoque obj);
	void update(Integer codEstoque, Integer newQuantity);	
	Estoque findById(Integer id);
	List<Estoque> findAll();

}
