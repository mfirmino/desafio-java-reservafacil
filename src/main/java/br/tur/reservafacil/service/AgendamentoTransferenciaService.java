package br.tur.reservafacil.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import br.tur.reservafacil.builder.TransferenciaBuilder;
import br.tur.reservafacil.dao.TransferenciaDAO;
import br.tur.reservafacil.modelo.TipoTransferencia;
import br.tur.reservafacil.modelo.Transferencia;

/**
 * Classe respons�vel por disponibilizar os servi�os referente ao agendamento de Transferencias.
 * 
 * OBS: N�o foquei em fazer inje��o de dependencias para o DAO pois pelo que entendi, n�o � o objetivo da prova.
 * @author mfirmino
 */
public class AgendamentoTransferenciaService {

	private TransferenciaDAO dao = new TransferenciaDAO();
	
	/**
	 * M�todo respons�vel por realizar um agendamento de transfer�ncia de acordo com
	 * os par�metros de entrada.
	 * 
	 * @param contaOrigem - Conta Corrente de Origem da Transfer�ncia. Padr�o (XXXXX-X)
	 * @param contaDestino - Conta Corrente de Destino da Transfer�ncia. Padr�o (XXXXX-X)
	 * @param valor - Valor da transfer�ncia desejada
	 * @param dataAgendamento - Data de agendamento da Transfer�ncia.
	 * @param tipoTransferencia - Tipo da Transfer�ncia. (A,B,C ou D)
	 * @throws Exception
	 */
	public void agendarTransferencia(String contaOrigem, String contaDestino, BigDecimal valor,
			Calendar dataAgendamento, TipoTransferencia tipoTransferencia) throws Exception {
		Transferencia transferencia = new TransferenciaBuilder()
										.deContaOrigem(contaOrigem)
										.paraContaDestino(contaDestino)
										.comValor(valor)
										.naData(dataAgendamento)
										.doTipo(tipoTransferencia)
										.constroi();
		getDao().adiciona(transferencia);
	}

	/**
	 * M�todo respons�vel por retornar todas as transfer�ncias agendadas.
	 *
	 * @return List<Transferencia>
	 * @throws Exception
	 */
	public List<Transferencia> obterTodasTransferenciasAgendadas() throws Exception {
		return getDao().lista();
	}
	
	public TransferenciaDAO getDao() {
		return dao;
	}
}
