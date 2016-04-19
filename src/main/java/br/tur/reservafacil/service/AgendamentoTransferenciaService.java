package br.tur.reservafacil.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import br.tur.reservafacil.builder.TransferenciaBuilder;
import br.tur.reservafacil.dao.TransferenciaDAO;
import br.tur.reservafacil.modelo.TipoTransferencia;
import br.tur.reservafacil.modelo.Transferencia;

/**
 * Classe responsável por disponibilizar os serviços referente ao agendamento de Transferencias.
 * 
 * OBS: Não foquei em fazer injeção de dependencias para o DAO pois pelo que entendi, não é o objetivo da prova.
 * @author mfirmino
 */
public class AgendamentoTransferenciaService {

	private TransferenciaDAO dao = new TransferenciaDAO();
	
	/**
	 * Método responsável por realizar um agendamento de transferência de acordo com
	 * os parâmetros de entrada.
	 * 
	 * @param contaOrigem - Conta Corrente de Origem da Transferência. Padrão (XXXXX-X)
	 * @param contaDestino - Conta Corrente de Destino da Transferência. Padrão (XXXXX-X)
	 * @param valor - Valor da transferência desejada
	 * @param dataAgendamento - Data de agendamento da Transferência.
	 * @param tipoTransferencia - Tipo da Transferência. (A,B,C ou D)
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
	 * Método responsável por retornar todas as transferências agendadas.
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
