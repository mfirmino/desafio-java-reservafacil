package br.tur.reservafacil.taxa;

import java.math.BigDecimal;
import java.util.Calendar;

import br.tur.reservafacil.utils.CalendarUtils;

/**
 * Classe responsável pelo cálculo da taxa seguindo a seguinte regra:
 *   Operações do tipo C tem uma taxa regressiva conforme a data de agendamento:
 *     - maior que 30 dias da data de cadastro ­ 1.2%;
 *     - até 30 dias da data de cadastro ­ 2.1%;
 *     - até 25 dias da data de cadastro ­ 4.3%;
 *     - até 20 dias da data de cadastro ­ 5.4%;
 *     - até 15 dias da data de cadastro ­ 6.7%;
 *     - até 10 dias da data de cadastro ­ 7.4%;
 *     - até  5 dias da data de cadastro ­ 8.3;
 *
 * @author mfirmino
 *
 */
public class TaxaTipoC extends TemplateTaxa {

	@Override
	public BigDecimal calcularTaxaEspecifica(BigDecimal valorTransferencia, Calendar dataAgendamento) throws Exception {
		Calendar dataAtual = Calendar.getInstance();
		if (CalendarUtils.daysBetween(dataAtual, dataAgendamento) <= 5){
			return getValorPorcentagem(valorTransferencia, new BigDecimal("0.083"));
		} else if (CalendarUtils.daysBetween(dataAtual, dataAgendamento) <= 10) {
			return getValorPorcentagem(valorTransferencia, new BigDecimal("0.074"));
		} else if (CalendarUtils.daysBetween(dataAtual, dataAgendamento) <= 15){
			return getValorPorcentagem(valorTransferencia, new BigDecimal("0.067"));
		} else if (CalendarUtils.daysBetween(dataAtual, dataAgendamento) <= 20){
			return getValorPorcentagem(valorTransferencia, new BigDecimal("0.054"));
		} else if (CalendarUtils.daysBetween(dataAtual, dataAgendamento) <= 25){
			return getValorPorcentagem(valorTransferencia, new BigDecimal("0.043"));
		} else if (CalendarUtils.daysBetween(dataAtual, dataAgendamento) <= 30){
			return getValorPorcentagem(valorTransferencia, new BigDecimal("0.021"));
		} 
		return getValorPorcentagem(valorTransferencia, new BigDecimal("0.012"));
	}

	/**
	 * Método responsável pelo cálculo do valor da porcentagem.
	 *
	 * @param valorTransferencia - Valor total da transferência
	 * @param porcentagem - porcentagem desejada entre 0 e 1
	 * @return BigDecimal
	 */
	private BigDecimal getValorPorcentagem(BigDecimal valorTransferencia, BigDecimal porcentagem){
		return valorTransferencia.multiply(porcentagem);
	}
	
}
