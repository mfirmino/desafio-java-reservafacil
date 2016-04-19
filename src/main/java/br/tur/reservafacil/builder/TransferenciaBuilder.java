package br.tur.reservafacil.builder;

import java.math.BigDecimal;
import java.util.Calendar;

import br.tur.reservafacil.modelo.TipoTransferencia;
import br.tur.reservafacil.modelo.Transferencia;
import br.tur.reservafacil.utils.CalendarUtils;
import br.tur.reservafacil.utils.StringFormatUtils;

/**
 * Classe responsável pela construção do objeto Transferencia já realizando
 * todas suas validações e cálculo de taxa conforme o tipo.
 *
 * @author mfirmino
 *
 */
public class TransferenciaBuilder {
	
	private static final String REGEX_CONTA_CORRENTE = "^(\\d{5}-\\d{1})$";
	
	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valor;
	private BigDecimal taxa;	
	private Calendar dataAgendamento;	
	private TipoTransferencia tipo;
	
	public Transferencia constroi() throws Exception {
		validaCamposObrigatorios();
		validaContaCorrentes();
		this.taxa = tipo.getTipoTaxa().calcularTaxa(this.valor, this.dataAgendamento);
		return new Transferencia(contaOrigem, contaDestino, valor, taxa, dataAgendamento, tipo);
	}

	public TransferenciaBuilder deContaOrigem(String contaOrigem) throws Exception{
		if(contaOrigem == null || !isContaCorrenteValida(contaOrigem)){
			throw new Exception("Conta de Origem inválida. Deve-se obedecer o padrão (XXXXX-X)");
		}
		this.contaOrigem = contaOrigem;
		return this;
	}
	
	public TransferenciaBuilder paraContaDestino(String contaDestino) throws Exception{
		if(contaDestino == null || !isContaCorrenteValida(contaDestino)){
			throw new Exception("Conta de Destino inválida. Deve-se obedecer o padrão (XXXXX-X)");
		}
		this.contaDestino = contaDestino;
		return this;
	}
	
	public TransferenciaBuilder comValor(BigDecimal valor) throws Exception{
		if(valor == null || BigDecimal.ZERO.compareTo(valor) >= 0){
			throw new Exception("Valor de Transferência inválido.");
		}
		this.valor = valor;
		return this;
	}
	
	public TransferenciaBuilder naData(Calendar dataAgendamento) throws Exception{
		Calendar dataAtual = Calendar.getInstance();
		if (dataAgendamento == null || CalendarUtils.isBefore(dataAgendamento, dataAtual)){
			throw new Exception("Data de Agendamento inválida.");
		}
		this.dataAgendamento = dataAgendamento;
		return this;
	}
	
	public TransferenciaBuilder doTipo(TipoTransferencia tipo){
		this.tipo = tipo;
		return this;
	}
	
	/**
	 * Método responsável pela validação dos campos para criação do objeto Transferência.
	 * Em caso de alguma inconsistência, será lançado uma exceção.
	 */
	private void validaCamposObrigatorios() throws Exception {
		if(this.contaOrigem == null){
			throw new Exception("Conta de Origem é obrigatória. Deve-se obedecer o padrão (XXXXX-X)");
		} else if(this.contaDestino == null) {
			throw new Exception("Conta de Destino é obrigatória. Deve-se obedecer o padrão (XXXXX-X)");
		} else if(this.valor == null){
			throw new Exception("Valor de Transferência é obrigatório.");
		} else if(this.dataAgendamento == null){
			throw new Exception("Data de Agendamento é obrigatória.");
		} else if(this.tipo == null){
			throw new Exception("Tipo de Transferência é obrigatório.");
		}
	}
	
	/**
	 * Método responsável pela validação das Contas Correntes. A conta de origem e a de destino não podem
	 * ser iguais.
	 */
	private void validaContaCorrentes() throws Exception {
		if(this.contaOrigem.equals(this.contaDestino)){
			throw new Exception("Conta de Origem deve ser diferente da Conta de Destino.");
		}
	}
	
	/**
	 * Método responsável pela validação do formato da conta corrente que deve obedecer o
	 * padrão (XXXXX-X).
	 * 
	 * @param contaCorrente
	 * @return
	 */
	private boolean isContaCorrenteValida(String contaCorrente){
		return StringFormatUtils.validarFormato(REGEX_CONTA_CORRENTE, contaCorrente);
	}
	
}
