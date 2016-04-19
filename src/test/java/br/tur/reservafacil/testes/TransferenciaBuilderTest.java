package br.tur.reservafacil.testes;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.tur.reservafacil.builder.TransferenciaBuilder;
import br.tur.reservafacil.modelo.TipoTransferencia;
import br.tur.reservafacil.modelo.Transferencia;
import br.tur.reservafacil.utils.CalendarUtils;

public class TransferenciaBuilderTest {

	private static final String CONTA_CORRENTE_ORIGEM_VALIDA = "12345-1";
	private static final String CONTA_CORRENTE_DESTINO_VALIDA = "54325-5";
	private static final BigDecimal VALOR_TRANSFERENCIA_VALIDO = new BigDecimal("10000");
	private static final Calendar DATA_AGENDAMENTO_VALIDA = CalendarUtils.newCalendar(2016, 10, 3);

	private static final String CONTA_CORRENTE_ORIGEM_INVALIDA = "12345-12";
	private static final String CONTA_CORRENTE_DESTINO_INVALIDA = "5432-5";
	private static final BigDecimal VALOR_TRANSFERENCIA_INVALIDO = BigDecimal.ZERO;
	private static final Calendar DATA_AGENDAMENTO_INVALIDA = CalendarUtils.newCalendar(2015, 10, 3);

	@Test
	public void testeCriacaoTransferenciaComSucesso() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);

		Transferencia transferencia = new TransferenciaBuilder()
				.deContaOrigem(CONTA_CORRENTE_ORIGEM_VALIDA)
				.paraContaDestino(CONTA_CORRENTE_DESTINO_VALIDA)
				.comValor(VALOR_TRANSFERENCIA_VALIDO)
				.naData(DATA_AGENDAMENTO_VALIDA)
				.doTipo(TipoTransferencia.B)
				.constroi();

		Assert.assertTrue(valorEsperado.doubleValue() == transferencia.getTaxa().doubleValue());
	}

	@Test(expected=Exception.class)
	public void testeCriacaoTransferenciaComContaOrigemEDestinoIguais() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);

		Transferencia transferencia = new TransferenciaBuilder()
				.deContaOrigem(CONTA_CORRENTE_ORIGEM_VALIDA)
				.paraContaDestino(CONTA_CORRENTE_ORIGEM_VALIDA)
				.comValor(VALOR_TRANSFERENCIA_VALIDO)
				.naData(DATA_AGENDAMENTO_VALIDA)
				.doTipo(TipoTransferencia.B)
				.constroi();

		Assert.assertTrue(valorEsperado.doubleValue() == transferencia.getTaxa().doubleValue());
	}

	@Test(expected=Exception.class)
	public void testeCriacaoTransferenciaComContaOrigemInvalida() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);

		Transferencia transferencia = new TransferenciaBuilder()
				.deContaOrigem(CONTA_CORRENTE_ORIGEM_INVALIDA)
				.paraContaDestino(CONTA_CORRENTE_DESTINO_VALIDA)
				.comValor(VALOR_TRANSFERENCIA_VALIDO)
				.naData(DATA_AGENDAMENTO_VALIDA)
				.doTipo(TipoTransferencia.B)
				.constroi();

		Assert.assertTrue(valorEsperado.doubleValue() == transferencia.getTaxa().doubleValue());
	}

	@Test(expected=Exception.class)
	public void testeCriacaoTransferenciaComContaDestinoInvalida() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);

		Transferencia transferencia = new TransferenciaBuilder()
				.deContaOrigem(CONTA_CORRENTE_ORIGEM_VALIDA)
				.paraContaDestino(CONTA_CORRENTE_DESTINO_INVALIDA)
				.comValor(VALOR_TRANSFERENCIA_VALIDO)
				.naData(DATA_AGENDAMENTO_VALIDA)
				.doTipo(TipoTransferencia.B)
				.constroi();

		Assert.assertTrue(valorEsperado.doubleValue() == transferencia.getTaxa().doubleValue());
	}

	@Test(expected=Exception.class)
	public void testeCriacaoTransferenciaComValorInvalido() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);

		Transferencia transferencia = new TransferenciaBuilder()
				.deContaOrigem(CONTA_CORRENTE_ORIGEM_VALIDA)
				.paraContaDestino(CONTA_CORRENTE_DESTINO_VALIDA)
				.comValor(VALOR_TRANSFERENCIA_INVALIDO)
				.naData(DATA_AGENDAMENTO_VALIDA)
				.doTipo(TipoTransferencia.B)
				.constroi();

		Assert.assertTrue(valorEsperado.doubleValue() == transferencia.getTaxa().doubleValue());
	}

	@Test(expected=Exception.class)
	public void testeCriacaoTransferenciaComDataAgendamentoInvalida() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);

		Transferencia transferencia = new TransferenciaBuilder()
				.deContaOrigem(CONTA_CORRENTE_ORIGEM_VALIDA)
				.paraContaDestino(CONTA_CORRENTE_DESTINO_VALIDA)
				.comValor(VALOR_TRANSFERENCIA_VALIDO)
				.naData(DATA_AGENDAMENTO_INVALIDA)
				.doTipo(TipoTransferencia.B)
				.constroi();

		Assert.assertTrue(valorEsperado.doubleValue() == transferencia.getTaxa().doubleValue());
	}

	@Test(expected=Exception.class)
	public void testeCriacaoTransferenciaComContaOrigemNula() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);

		Transferencia transferencia = new TransferenciaBuilder()
				.paraContaDestino(CONTA_CORRENTE_DESTINO_VALIDA)
				.comValor(VALOR_TRANSFERENCIA_VALIDO)
				.naData(DATA_AGENDAMENTO_VALIDA)
				.doTipo(TipoTransferencia.B)
				.constroi();

		Assert.assertTrue(valorEsperado.doubleValue() == transferencia.getTaxa().doubleValue());
	}

	@Test(expected=Exception.class)
	public void testeCriacaoTransferenciaComContaDestinoNula() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);

		Transferencia transferencia = new TransferenciaBuilder()
				.deContaOrigem(CONTA_CORRENTE_ORIGEM_VALIDA)
				.comValor(VALOR_TRANSFERENCIA_VALIDO)
				.naData(DATA_AGENDAMENTO_VALIDA)
				.doTipo(TipoTransferencia.B)
				.constroi();

		Assert.assertTrue(valorEsperado.doubleValue() == transferencia.getTaxa().doubleValue());
	}

	@Test(expected=Exception.class)
	public void testeCriacaoTransferenciaComValorNulo() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);

		Transferencia transferencia = new TransferenciaBuilder()
				.deContaOrigem(CONTA_CORRENTE_ORIGEM_VALIDA)
				.paraContaDestino(CONTA_CORRENTE_DESTINO_VALIDA)
				.naData(DATA_AGENDAMENTO_VALIDA)
				.doTipo(TipoTransferencia.B)
				.constroi();

		Assert.assertTrue(valorEsperado.doubleValue() == transferencia.getTaxa().doubleValue());
	}

	@Test(expected=Exception.class)
	public void testeCriacaoTransferenciaComDataAgendamentoNula() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);

		Transferencia transferencia = new TransferenciaBuilder()
				.deContaOrigem(CONTA_CORRENTE_ORIGEM_VALIDA)
				.paraContaDestino(CONTA_CORRENTE_DESTINO_VALIDA)
				.comValor(VALOR_TRANSFERENCIA_VALIDO)
				.doTipo(TipoTransferencia.B)
				.constroi();

		Assert.assertTrue(valorEsperado.doubleValue() == transferencia.getTaxa().doubleValue());
	}

	@Test(expected=Exception.class)
	public void testeCriacaoTransferenciaComTipoNulo() throws Exception{
		BigDecimal valorEsperado = new BigDecimal(8);

		Transferencia transferencia = new TransferenciaBuilder()
				.deContaOrigem(CONTA_CORRENTE_ORIGEM_VALIDA)
				.paraContaDestino(CONTA_CORRENTE_DESTINO_VALIDA)
				.comValor(VALOR_TRANSFERENCIA_VALIDO)
				.naData(DATA_AGENDAMENTO_VALIDA)
				.constroi();

		Assert.assertTrue(valorEsperado.doubleValue() == transferencia.getTaxa().doubleValue());
	}
}
