package br.tur.reservafacil.testes;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.tur.reservafacil.taxa.TaxaTipoB;
import br.tur.reservafacil.utils.CalendarUtils;

public class TaxaTipoBTest {

	private static final BigDecimal VALOR_TRANSFERENCIA_VALIDO = new BigDecimal("10000");
	private static final Calendar DATA_AGENDAMENTO_VALIDA = CalendarUtils.newCalendar(2016, 10, 3);
	
	private static final BigDecimal VALOR_TRANSFERENCIA_INVALIDO = new BigDecimal("-10000");
	private static final Calendar DATA_AGENDAMENTO_INVALIDA = CalendarUtils.newCalendar(2015, 10, 3);
	
	private static final BigDecimal VALOR_TRANSFERENCIA_NULO = null;
	private static final Calendar DATA_AGENDAMENTO_NULA = null;
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoMenorQue30Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(10);
		
		Calendar dataMenorQue30Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataMenorQue30Dias.add(Calendar.DATE, 29);
		
		TaxaTipoB tipoB = new TaxaTipoB();
		BigDecimal valorCalculado = tipoB.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataMenorQue30Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoPara30Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(10);
		
		Calendar dataFuturaEm30Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm30Dias.add(Calendar.DATE, 30);
		
		TaxaTipoB tipoB = new TaxaTipoB();
		BigDecimal valorCalculado = tipoB.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm30Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoMaiorQue30Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);
		
		Calendar dataFuturaEm31Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm31Dias.add(Calendar.DATE, 31);
		
		TaxaTipoB tipoB = new TaxaTipoB();
		BigDecimal valorCalculado = tipoB.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm31Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComValorNulo() throws Exception{
		TaxaTipoB tipoB = new TaxaTipoB();
		BigDecimal valorCalculado = tipoB.calcularTaxa(VALOR_TRANSFERENCIA_NULO, DATA_AGENDAMENTO_VALIDA);
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComDataAgendamentoNula() throws Exception {
		TaxaTipoB tipoB = new TaxaTipoB();
		BigDecimal valorCalculado = tipoB.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, DATA_AGENDAMENTO_NULA);
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComValorInvalido() throws Exception {
		TaxaTipoB tipoB = new TaxaTipoB();
		BigDecimal valorCalculado = tipoB.calcularTaxa(VALOR_TRANSFERENCIA_INVALIDO, DATA_AGENDAMENTO_VALIDA);
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComDataAgendamentoInvalida() throws Exception {
		TaxaTipoB tipoB = new TaxaTipoB();
		BigDecimal valorCalculado = tipoB.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, DATA_AGENDAMENTO_INVALIDA);
	}
}
