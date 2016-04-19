package br.tur.reservafacil.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.tur.reservafacil.infra.ConnectionFactory;
import br.tur.reservafacil.modelo.TipoTransferencia;
import br.tur.reservafacil.modelo.Transferencia;

/**
 * Classe respons�vel pelo agrupamento de consultas e opera��es na tabela de Transfer�ncia da base de dados.
 * 
 * OBS: foi feito em JDBC puro, pois como a descri��o do desafio informa, a persist�ncia em base de dados �
 * opcional e n�o � o foco da avalia��o.
 *
 * @author mfirmino
 *
 */
public class TransferenciaDAO {
	
	private Connection connection;
	
	public TransferenciaDAO() {
	}

	/**
	 * M�todo respons�vel pela grava��o dos dados de transfer�ncia na base de dados.
	 *
	 * @param tranferencia
	 */
	public void adiciona(Transferencia tranferencia) {
		String sql = "insert into transferencia (contaOrigem, contaDestino, valor, taxa, dataAgendamento, tipo) values (?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement(sql);
			stmt.setString(1, tranferencia.getContaOrigem());
			stmt.setString(2, tranferencia.getContaDestino());
			stmt.setDouble(3, tranferencia.getValor().doubleValue());
			stmt.setDouble(4, tranferencia.getTaxa().doubleValue());
			stmt.setDate(5, new Date(tranferencia.getDataAgendamento().getTimeInMillis()));
			stmt.setString(6, tranferencia.getTipo().name());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * M�todo respons�vel pelo retorno de uma lista de todos os dados existentes na tabela Transferencia.
	 *
	 * @return List<Transferencia>
	 */
	public List<Transferencia> lista() {
		try {
			List<Transferencia> transferencias = new ArrayList<Transferencia>();
			PreparedStatement stmt = getConnection().prepareStatement("select * from transferencia");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				transferencias.add(populaTransferencia(rs));
			}

			rs.close();
			stmt.close();
			return transferencias;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * M�todo respons�vel por retornar uma instancia da classe Transferencia com dados oriundos
	 * dos banco de dados.
	 * @param rs - ResultSet
	 * @return Transferencia
	 * @throws SQLException
	 */
	private Transferencia populaTransferencia(ResultSet rs) throws SQLException {
		Transferencia transferencia = new Transferencia();

		transferencia.setId(rs.getInt("id"));
		transferencia.setContaOrigem(rs.getString("contaOrigem"));
		transferencia.setContaDestino(rs.getString("contaDestino"));
		transferencia.setValor(new BigDecimal(rs.getDouble("valor")));
		transferencia.setTaxa(new BigDecimal(rs.getDouble("taxa")));

		Date data = rs.getDate("dataAgendamento");
		if (data != null) {
			Calendar dataAgendamento = Calendar.getInstance();
			dataAgendamento.setTime(data);
			transferencia.setDataAgendamento(dataAgendamento);
		}
		
		transferencia.setTipo(Enum.valueOf(TipoTransferencia.class, rs.getString("tipo")));
		
		return transferencia;
	}

	/**
	 * M�todo respons�vel pelo retorno da conex�o com o banco de dados.
	 *
	 * @return Connection
	 */
	public Connection getConnection() {
		try {
			if(connection == null || connection.isClosed()){
				this.connection = new ConnectionFactory().getConnection();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return connection;
	}
	
}
