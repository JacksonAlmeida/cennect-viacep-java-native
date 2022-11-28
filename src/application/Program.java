package application;

import java.io.IOException;
import java.util.Scanner;

import application.dao.EnderecoDao;
import application.dao.impl.EnderecoDaoJdbc;
import application.db.DbConfig;
import application.entities.Endereco;
import application.services.CepServices;

public class Program {

	public static void main(String[] args) {

		EnderecoDao add = new EnderecoDaoJdbc(DbConfig.getConnection());

		Scanner sc = new Scanner(System.in);

		CepServices cepServices = new CepServices();

		System.out.println("--------------Buscar CEP-------------");

		System.out.print("Insira o seu CEP: ");
		String cep = sc.nextLine();
		try {
			Endereco end = cepServices.buscarCep(cep);
			System.out.println(end);
			System.out.print("Digite o número da sua casa: ");
			String home = sc.nextLine();
			if (home != null) {
				end.setHome(home);
				System.out.println(end);
				System.out.print("Deseja salvar esse novo endereço ? yes ou no: ");
				String resp = sc.nextLine();
				if (resp.equals("no")) {
					System.out.println("endereço não foi salvo");
				} else {
					if (resp.equals("yes")) {
						add.save(end);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		sc.close();
	}

}
