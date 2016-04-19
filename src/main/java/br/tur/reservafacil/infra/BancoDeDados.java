package br.tur.reservafacil.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe responsável pela criação e remoção das tabelas envolvidas no sistema.
 *
 * @author mfirmino
 *
 */
public class BancoDeDados {
	
	public static void criaBanco() throws SQLException {
		Connection c = new ConnectionFactory().getConnection();
		PreparedStatement st1 = c.prepareStatement("drop table transferencia if exists");
		st1.execute();

		PreparedStatement st11 = c.prepareStatement("create table transferencia (id int identity, contaOrigem varchar(7), contaDestino varchar(7), valor double, taxa double, dataAgendamento datetime, tipo varchar(1))");
		st11.execute();
		
		c.close();
	}
	
	public static void removeBanco() throws SQLException {
		Connection c = new ConnectionFactory().getConnection();
		PreparedStatement st1 = c.prepareStatement("drop table transferencia if exists");
		st1.execute();
		
		c.close();
	}
}
