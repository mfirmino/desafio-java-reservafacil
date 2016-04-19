package br.tur.reservafacil.testes;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.tur.reservafacil.taxa.TaxaTipoD;
import br.tur.reservafacil.utils.CalendarUtils;

public class TaxaTipoDTest {

	private static final BigDecimal VALOR_TRANSFERENCIA_10000 = new BigDecimal("10000");
	private static final BigDecimal VALOR_TRANSFERENCIA_25000 = new BigDecimal("25000");
	private static final BigDecimal VALOR_TRANSFERENCIA_25001 = new BigDecimal("25001");
	private static final BigDecimal VALOR_TRANSFERENCIA_120000 = new BigDecimal("120000");
	private static final BigDecimal VALOR_TRANSFERENCIA_120001 = new BigDecimal("120001");
	
	private static final Calendar DATA_AGENDAMENTO_VALIDA = CalendarUtils.newCalendar(2016, 10, 3);
	
	private static final BigDecimal VALOR_TRANSFERENCIA_INVALIDO = new BigDecimal("-10000");
	private static final Calendar DATA_AGENDAMENTO_INVALIDA = CalendarUtils.newCalendar(2015, 10, 3);
	
	private static final BigDecimal VALOR_TRANSFERENCIA_NULO = null;
	private static final Calendar DATA_AGENDAMENTO_NULA = null;
	
	@Test
	public void calculoTaxaComSucessoParaValorAte25000() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(302);
		
		TaxaTipoD tipoD = new TaxaTipoD();
		BigDecimal valorCalculado = tipoD.calcularTaxa(VALOR_TRANSFERENCIA_10000, DATA_AGENDAMENTO_VALIDA);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoParaValorDe25000() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(752);
		
		TaxaTipoD tipoD = new TaxaTipoD();
		BigDecimal valorCalculado = tipoD.calcularTaxa(VALOR_TRANSFERENCIA_25000, DATA_AGENDAMENTO_VALIDA);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoParaValorEntre25000e120000() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(10);
		
		Calendar dataFuturaEm30Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm30Dias.add(Calendar.DATE, 30);
		
		TaxaTipoD tipoD = new TaxaTipoD();
		BigDecimal valorCalculado = tipoD.calcularTaxa(VALOR_TRANSFERENCIA_25001, dataFuturaEm30Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoParaValorDe120000() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);
		
		Calendar dataFuturaEm60Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm60Dias.add(Calendar.DATE, 60);
		
		TaxaTipoD tipoD = new TaxaTipoD();
		BigDecimal valorCalculado = tipoD.calcularTaxa(VALOR_TRANSFERENCIA_120000, dataFuturaEm60Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoParaValorMaiorQue120000() throws Exception{
		BigDecimal valorEsperado = new BigDecimal("1440.012");
		
		Calendar dataFuturaEm60Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm60Dias.add(Calendar.DATE, 60);
		
		TaxaTipoD tipoD = new TaxaTipoD();
		BigDecimal valorCalculado = tipoD.calcularTaxa(VALOR_TRANSFERENCIA_120001, dataFuturaEm60Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComValorNulo() throws Exception{
		TaxaTipoD tipoD = new TaxaTipoD();
		BigDecimal valorCalculado = tipoD.calcularTaxa(VALOR_TRANSFERENCIA_NULO, DATA_AGENDAMENTO_VALIDA);
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComDataAgendamentoNula() throws Exception {
		TaxaTipoD tipoD = new TaxaTipoD();
		BigDecimal valorCalculado = tipoD.calcularTaxa(VALOR_TRANSFERENCIA_25000, DATA_AGENDAMENTO_NULA);
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComValorInvalido() throws Exception {
		TaxaTipoD tipoD = new TaxaTipoD();
		BigDecimal valorCalculado = tipoD.calcularTaxa(VALOR_TRANSFERENCIA_INVALIDO, DATA_AGENDAMENTO_VALIDA);
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComDataAgendamentoInvalida() throws Exception {
		TaxaTipoD tipoD = new TaxaTipoD();
		BigDecimal valorCalculado = tipoD.calcularTaxa(VALOR_TRANSFERENCIA_25000, DATA_AGENDAMENTO_INVALIDA);
	}
}
