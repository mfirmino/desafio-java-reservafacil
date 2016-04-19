package br.tur.reservafacil.taxa;

import java.math.BigDecimal;
import java.util.Calendar;

import br.tur.reservafacil.modelo.TipoTransferencia;

/**
 * Classe responsável pelo cálculo da taxa seguindo a seguinte regra:
 *  Operações do tipo D tem a taxa igual a A, B ou C dependendo do valor da transferência:
 *    - Valores até $25.000 seguem a taxação tipo A;
 *    - Valores de $25.001 até $120.000 seguem a taxação tipo B;
 *    - Valores maiores que $120.000 seguem a taxação tipo C.
 *
 * @author mfirmino
 *
 */
public class TaxaTipoD extends TemplateTaxa {

	BigDecimal valorLimiteTaxacaoTipoA = new BigDecimal(25000);
	BigDecimal valorLimiteTaxacaoTipoB = new BigDecimal(120000);
	
	@Override
	public BigDecimal calcularTaxaEspecifica(BigDecimal valorTransferencia, Calendar dataAgendamento) throws Exception {
		if (valorTransferencia.compareTo(valorLimiteTaxacaoTipoA) == -1 
				|| valorTransferencia.compareTo(valorLimiteTaxacaoTipoA) == 0){
			return TipoTransferencia.A.getTipoTaxa().calcularTaxa(valorTransferencia, dataAgendamento);
		} else if (valorTransferencia.compareTo(valorLimiteTaxacaoTipoB) == -1
				|| valorTransferencia.compareTo(valorLimiteTaxacaoTipoB) == 0){
			return TipoTransferencia.B.getTipoTaxa().calcularTaxa(valorTransferencia, dataAgendamento);
		} 
		
		return TipoTransferencia.C.getTipoTaxa().calcularTaxa(valorTransferencia, dataAgendamento);
	}

}
