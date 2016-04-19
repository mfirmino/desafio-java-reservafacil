package br.tur.reservafacil.testes;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.tur.reservafacil.taxa.TaxaTipoC;
import br.tur.reservafacil.utils.CalendarUtils;

public class TaxaTipoCTest {

	private static final BigDecimal VALOR_TRANSFERENCIA_VALIDO = new BigDecimal("10000");
	private static final Calendar DATA_AGENDAMENTO_VALIDA = CalendarUtils.newCalendar(2016, 10, 3);
	
	private static final BigDecimal VALOR_TRANSFERENCIA_INVALIDO = new BigDecimal("-10000");
	private static final Calendar DATA_AGENDAMENTO_INVALIDA = CalendarUtils.newCalendar(2015, 10, 3);
	
	private static final BigDecimal VALOR_TRANSFERENCIA_NULO = null;
	private static final Calendar DATA_AGENDAMENTO_NULA = null;
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoMaiorQue30Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(120);
		
		Calendar dataFuturaEm31Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm31Dias.add(Calendar.DATE, 31);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm31Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoPara30Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(210);
		
		Calendar dataFuturaEm30Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm30Dias.add(Calendar.DATE, 30);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm30Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoEntre25e30Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(210);
		
		Calendar dataFuturaEm27Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm27Dias.add(Calendar.DATE, 27);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm27Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoPara25Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(430);
		
		Calendar dataFuturaEm25Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm25Dias.add(Calendar.DATE, 25);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm25Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoEntre20e25Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(430);
		
		Calendar dataFuturaEm22Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm22Dias.add(Calendar.DATE, 22);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm22Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoPara20Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(540);
		
		Calendar dataFuturaEm20Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm20Dias.add(Calendar.DATE, 20);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm20Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoEntre15e20Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(540);
		
		Calendar dataFuturaEm16Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm16Dias.add(Calendar.DATE, 16);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm16Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoPara15Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(670);
		
		Calendar dataFuturaEm15Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm15Dias.add(Calendar.DATE, 15);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm15Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoEntre10e15Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(670);
		
		Calendar dataFuturaEm11Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm11Dias.add(Calendar.DATE, 11);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm11Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoPara10Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(740);
		
		Calendar dataFuturaEm10Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm10Dias.add(Calendar.DATE, 10);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm10Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoEntre5e10Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(740);
		
		Calendar dataFuturaEm9Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm9Dias.add(Calendar.DATE, 9);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm9Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoPara5Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(830);
		
		Calendar dataFuturaEm5Dias = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm5Dias.add(Calendar.DATE, 5);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm5Dias);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test
	public void calculoTaxaComSucessoEDataAgendamentoEntre1e5Dias() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(830);
		
		Calendar dataFuturaEm1Dia = CalendarUtils.getDateWithoutHours(Calendar.getInstance());
		dataFuturaEm1Dia.add(Calendar.DATE, 1);
		
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, dataFuturaEm1Dia);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComValorNulo() throws Exception{
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_NULO, DATA_AGENDAMENTO_VALIDA);
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComDataAgendamentoNula() throws Exception {
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, DATA_AGENDAMENTO_NULA);
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComValorInvalido() throws Exception {
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_INVALIDO, DATA_AGENDAMENTO_VALIDA);
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComDataAgendamentoInvalida() throws Exception {
		TaxaTipoC tipoC = new TaxaTipoC();
		BigDecimal valorCalculado = tipoC.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, DATA_AGENDAMENTO_INVALIDA);
	}
}
