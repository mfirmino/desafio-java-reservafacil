package br.tur.reservafacil.testes;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.tur.reservafacil.taxa.TaxaTipoA;
import br.tur.reservafacil.utils.CalendarUtils;
import br.tur.reservafacil.utils.StringFormatUtils;

public class TaxaTipoATest {

	private static final BigDecimal VALOR_TRANSFERENCIA_VALIDO = new BigDecimal("10000");
	private static final Calendar DATA_AGENDAMENTO_VALIDA = CalendarUtils.newCalendar(2016, 10, 3);
	
	private static final BigDecimal VALOR_TRANSFERENCIA_INVALIDO = new BigDecimal("-10000");
	private static final Calendar DATA_AGENDAMENTO_INVALIDA = CalendarUtils.newCalendar(2015, 10, 3);
	
	private static final BigDecimal VALOR_TRANSFERENCIA_NULO = null;
	private static final Calendar DATA_AGENDAMENTO_NULA = null;
	
	@Test
	public void calculoTaxaComSucesso() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(302);
		
		TaxaTipoA tipoA = new TaxaTipoA();
		BigDecimal valorCalculado = tipoA.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, DATA_AGENDAMENTO_VALIDA);
		
		Assert.assertTrue(valorEsperado.doubleValue() == valorCalculado.doubleValue());
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComValorNulo() throws Exception{
		TaxaTipoA tipoA = new TaxaTipoA();
		BigDecimal valorCalculado = tipoA.calcularTaxa(VALOR_TRANSFERENCIA_NULO, DATA_AGENDAMENTO_VALIDA);
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComDataAgendamentoNula() throws Exception {
		TaxaTipoA tipoA = new TaxaTipoA();
		BigDecimal valorCalculado = tipoA.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, DATA_AGENDAMENTO_NULA);
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComValorInvalido() throws Exception {
		TaxaTipoA tipoA = new TaxaTipoA();
		BigDecimal valorCalculado = tipoA.calcularTaxa(VALOR_TRANSFERENCIA_INVALIDO, DATA_AGENDAMENTO_VALIDA);
	}
	
	@Test(expected=Exception.class)
	public void calculoTaxaComDataAgendamentoInvalida() throws Exception {
		TaxaTipoA tipoA = new TaxaTipoA();
		BigDecimal valorCalculado = tipoA.calcularTaxa(VALOR_TRANSFERENCIA_VALIDO, DATA_AGENDAMENTO_INVALIDA);
	}
	
}