package br.tur.reservafacil.taxa;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Classe respons�vel pelo c�lculo da taxa seguindo a seguinte regra:
 * �- Opera��es�do�tipo�A�tem�uma�taxa�de�$2�mais�3%�do�valor�da�transfer�ncia;
 *
 * @author mfirmino
 *
 */
public class TaxaTipoA extends TemplateTaxa {

	private BigDecimal taxaFixa = new BigDecimal(2);
	private BigDecimal porcentagemValorTransferencia = new BigDecimal("0.03");

	@Override
	public BigDecimal calcularTaxaEspecifica(BigDecimal valorTransferencia, Calendar dataAgendamento) throws Exception {
		return taxaFixa.add(valorTransferencia.multiply(porcentagemValorTransferencia));
	}
	
	

}
