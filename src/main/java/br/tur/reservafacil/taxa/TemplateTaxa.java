package br.tur.reservafacil.taxa;

import java.math.BigDecimal;
import java.util.Calendar;

import br.tur.reservafacil.utils.CalendarUtils;

/**
 * Classe abstrata respons�vel pela padroniza��o de valida��o dos campos para calculo da taxa e
 * defini��o do m�todo que ser� o respons�vel por conter a l�gica espec�fica de cada tipo de taxa.
 *
 * @author mfirmino
 *
 */
public abstract class TemplateTaxa implements TipoTaxa {
	
	public BigDecimal calcularTaxa(BigDecimal valorTransferencia, Calendar dataAgendamento) throws Exception {
		if(!valorTransferenciaValido(valorTransferencia) || !dataAgendamentoValido(dataAgendamento)){
			throw new Exception("Par�metros para c�lculo da taxa inv�lidos.");
		}
		return calcularTaxaEspecifica(valorTransferencia, dataAgendamento);
	}

	/**
	 * M�todo respons�vel pela valida��o da data de agendamento.
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
	 * M�todo respons�vel pela valida��o do valor de Transfer�ncia.
	 * O valor n�o pode ser negativo ou igual a 0.
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
