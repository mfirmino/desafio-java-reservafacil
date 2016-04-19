package br.tur.reservafacil.infra;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe respons�vel pela configura��o e conex�o com a base de dados.
 *
 * @author mfirmino
 *
 */
public class ConnectionFactory {

	
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		
		return DriverManager.getConnection("jdbc:hsqldb:file:transf.db","SA", "");
	}

}
