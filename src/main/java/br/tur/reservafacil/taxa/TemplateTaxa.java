package br.tur.reservafacil.taxa;

import java.math.BigDecimal;
import java.util.Calendar;

import br.tur.reservafacil.utils.CalendarUtils;

/**
 * Classe abstrata responsável pela padronização de validação dos campos para calculo da taxa e
 * definição do método que será o responsável por conter a lógica específica de cada tipo de taxa.
 *
 * @author mfirmino
 *
 */
public abstract class TemplateTaxa implements TipoTaxa {
	
	public BigDecimal calcularTaxa(BigDecimal valorTransferencia, Calendar dataAgendamento) throws Exception {
		if(!valorTransferenciaValido(valorTransferencia) || !dataAgendamentoValido(dataAgendamento)){
			throw new Exception("Parâmetros para cálculo da taxa inválidos.");
		}
		return calcularTaxaEspecifica(valorTransferencia, dataAgendamento);
	}

	/**
	 * Método responsável pela validação da data de agendamento.
	 * A data deve ser maior que a data atual do sistema (Data de Cadastro).
	 *
	 * @param dataAgendamento
	 * @return
	 */
	private boolean dataAgendamentoValido(Calendar dataAgendamento) {
		Calendar dataAtual = Calendar.getInstance();
		if (dataAgendamento != null && CalendarUtils.isAfter(dataAgendamento, dataAtual)){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Método responsável pela validação do valor de Transferência.
	 * O valor não pode ser negativo ou igual a 0.
	 * @param valorTransferencia
	 * @return
	 */
	private boolean valorTransferenciaValido(BigDecimal valorTransferencia) {
		if(valorTransferencia != null && BigDecimal.ZERO.compareTo(valorTransferencia) == -1){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public abstract BigDecimal calcularTaxaEspecifica(BigDecimal valorTransferencia, Calendar dataAgendamento) throws Exception;
	
}
