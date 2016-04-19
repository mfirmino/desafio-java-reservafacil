package br.tur.reservafacil.taxa;

import java.math.BigDecimal;
import java.util.Calendar;

import br.tur.reservafacil.utils.CalendarUtils;

/**
 * Classe responsável pelo cálculo da taxa seguindo a seguinte regra:
 *   Operações do tipo B tem uma taxa de:
 *      $10 para pedidos com agendamento até 30 dias da data de cadastro
 *      $8 para os demais
 *
 * @author mfirmino
 *
 */
public class TaxaTipoB extends TemplateTaxa {

	private BigDecimal taxaFixaMenor30Dias = new BigDecimal(10);
	private BigDecimal taxaFixaMaior30Dias = new BigDecimal(8);
	
	@Override
	public BigDecimal calcularTaxaEspecifica(BigDecimal valorTransferencia, Calendar dataAgendamento) throws Exception {
		Calendar trintaDiasFuturos = Calendar.getInstance();
		trintaDiasFuturos.add(Calendar.DATE, 30);
		trintaDiasFuturos = CalendarUtils.getDateWithoutHours(trintaDiasFuturos);
		
		if(CalendarUtils.isBefore(dataAgendamento, trintaDiasFuturos)
				|| CalendarUtils.isEquals(dataAgendamento, trintaDiasFuturos)){
			return taxaFixaMenor30Dias;
		}
		return taxaFixaMaior30Dias;
	}

	

}
