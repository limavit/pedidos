package com.limadev.pedidos.tela;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.limadev.pedidos.dao.DAOFactory;
import com.limadev.pedidos.dao.IngredienteDAO;
import com.limadev.pedidos.entities.Ingrediente;
import com.limadev.pedidos.entities.enums.Tipo;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cadastros: ");
		IngredienteDAO ingredienteDao = DAOFactory.createIngredienteDao();
		int tela;

		System.out.println("Para Cadastrar ingrediente(1), produto(2)");
		tela = sc.nextInt();
		String nameIngrediente;
		List<Ingrediente> ingredientes = ingredienteDao.findAll();
		Ingrediente ing1 = new Ingrediente("Teste", Tipo.INGREDIENTE);
		System.out.println(Tipo.INGREDIENTE.toString());
		ingredienteDao.insert(ing1);


		/*
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
		 */

		System.out.println("Ingredientes cadastrados: ");
		for (Ingrediente ingrediente : ingredientes) {
			System.out.println("Id: " + ingrediente.getId() + "\t Nome: " + ingrediente.getName());
		}

		sc.close();

	}

}
