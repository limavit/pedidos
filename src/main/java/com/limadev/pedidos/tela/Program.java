package com.limadev.pedidos.tela;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.limadev.pedidos.dao.DAOFactory;
import com.limadev.pedidos.dao.EstoqueDAO;
import com.limadev.pedidos.dao.IngredienteDAO;
import com.limadev.pedidos.entities.Estoque;
import com.limadev.pedidos.entities.Ingrediente;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println("Cadastros: ");
			IngredienteDAO ingredienteDao = DAOFactory.createIngredienteDao();
			EstoqueDAO estoqueDao = DAOFactory.createEstoqueDao();
			
			//java.util.Date dataUtil = new java.util.Date();
			//java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			//System.out.println(dataSql);
			
			//ingredienteDao.insert(new Ingrediente("PAO", "INGREDIENTE"));
			estoqueDao.insert(new Estoque("pao", 0, 7));
			
			//int tela;

			//System.out.println("Para Cadastrar ingrediente(1), produto(2)");
			//tela = sc.nextInt();
			//String nameIngrediente;
			/*
			System.out.println("Id 1: " + ingredienteDao.countId(1));
			System.out.println("Id 10: " + ingredienteDao.countId(10));
			List<Ingrediente> ingredientes = ingredienteDao.findAll();
			Estoque estoque = estoqueDao.findById(4);
			System.out.println("Nome: " + estoque.getName());
			System.out.println("Quantidade: " + estoque.getQuantity());
			System.out.println("Ultima atualizacao: " + estoque.getLastUpdate());
			System.out.println("id do item: " + estoque.getFk());
			estoqueDao.update(4, 50);
			System.out.println("Nome: " + estoque.getName());
			System.out.println("Quantidade: " + estoque.getQuantity());
			System.out.println("Ultima atualizacao: " + estoque.getLastUpdate());
			System.out.println("id do item: " + estoque.getFk());
			List<Estoque> estoques = estoqueDao.findAll();
			for (Estoque estoque2 : estoques) {
				System.out.println("Name: " + estoque2.getName() + "\t Quantidade: " + estoque2.getQuantity() + "\t Ultima atualização: " + estoque2.getLastUpdate() + "\t Id do item: " + estoque2.getFk());
			}
			


			
			 * while (tela == 1) {
			 * 
			 * System.out.println("Insira o nome do ingrediente..."); nameIngrediente =
			 * sc.next().toLowerCase();
			 * 
			 * Ingrediente newIngrediente = new Ingrediente(nameIngrediente);
			 * ingredienteDao.insert(newIngrediente); ingredientes.add(newIngrediente);
			 * System.out.println("Vamos atualizar o ingrediente...");
			 * 
			 * System.out.println("Digite o nome do ingrediente que deseja Buscar"); String
			 * nomeBuscaIngrediente = sc.next().toLowerCase(); Ingrediente buscaIngrediente
			 * = ingredienteDao.findByName(nomeBuscaIngrediente);
			 * System.out.println("Digite o novo nome...."); String updateNameIngrediente =
			 * sc.next(); ingredienteDao.update(buscaIngrediente, updateNameIngrediente);
			 * System.out.println("Id: " + buscaIngrediente.getId());
			 * System.out.println("Name: " + buscaIngrediente.getName());
			 * 
			 * 
			 * System.out.println("Deseja incluir outro ingrediente? Sim (1) Não (3) ");
			 * tela = sc.nextInt();
			 * 
			 * 
			 * 
			 * }
			 
			

			System.out.println("Ingredientes cadastrados: ");
			for (Ingrediente ingrediente : ingredientes) {
				System.out.println("Id: " + ingrediente.getId() + "\t Nome: " + ingrediente.getName() + "\t Tipo: " + ingrediente.getTipo());
			}*/
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		

		sc.close();

	}

}
