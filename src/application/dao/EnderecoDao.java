package application.dao;

import application.entities.Endereco;

public interface EnderecoDao {

	Endereco findByCep(String cep);
	Endereco findById(int id);
	void save(Endereco end);
	void delete(long id);
}
