package application.dao;

import application.dao.impl.EnderecoDaoJdbc;
import application.db.DbConfig;

public class DaoFactory {

	public static EnderecoDao createEnderecoDao() {
		return new EnderecoDaoJdbc(DbConfig.getConnection());
	}

}
