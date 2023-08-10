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
			
			//ingredienteDao.insert(new Ingrediente("ALFACE", "INGREDIENTE"));
			
			//int tela;

			//System.out.println("Para Cadastrar ingrediente(1), produto(2)");
			//tela = sc.nextInt();
			//String nameIngrediente;
			estoqueDao.insert(new Estoque("ALFACE", 10 , 2));//coloquei uma data aleatória a regra está no controller
			System.out.println("Id 1: " + ingredienteDao.countId(1));
			System.out.println("Id 10: " + ingredienteDao.countId(10));
			List<Ingrediente> ingredientes = ingredienteDao.findAll();
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
