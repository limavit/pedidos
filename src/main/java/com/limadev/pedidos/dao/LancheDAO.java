package com.limadev.pedidos.dao;

import java.util.List;

import com.limadev.pedidos.entities.Lanche;

public interface LancheDAO {
	void insert(Lanche obj);
	void update(Lanche obj);
	void deleteById(Integer id);
	List<Lanche> findAll();

}
