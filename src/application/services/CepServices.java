package application.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import application.entities.Endereco;

public class CepServices {

	static final String URL = "http://viacep.com.br/ws/";
	static final int CODE = 200;

	public CepServices() {

	}

	public Endereco buscarCep(String cep) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Endereco end = new Endereco();
		String endUri = URL + cep + "/json";
		URL uri = new URL(endUri);
		HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

			JsonNode line = mapper.readTree(br);
			end.setCep(line.get("cep").asText());
			end.setBairro(line.get("bairro").asText());
			end.setLogradouro(line.get("logradouro").asText());
			return end;
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}

}
