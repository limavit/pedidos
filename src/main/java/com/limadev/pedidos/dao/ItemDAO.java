package com.limadev.pedidos.dao;

import java.util.List;

import com.limadev.pedidos.entities.Item;

public interface ItemDAO {
	void insert(Item obj);
	void update(Item obj);
	void deleteById(Integer id);
	List<Item> findAll();

}
