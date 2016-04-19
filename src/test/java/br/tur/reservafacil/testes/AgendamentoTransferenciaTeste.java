package br.tur.reservafacil.testes;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.tur.reservafacil.infra.BancoDeDados;
import br.tur.reservafacil.modelo.TipoTransferencia;
import br.tur.reservafacil.modelo.Transferencia;
import br.tur.reservafacil.service.AgendamentoTransferenciaService;
import br.tur.reservafacil.utils.CalendarUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AgendamentoTransferenciaTeste {
	
	private static final String CONTA_CORRENTE_ORIGEM_VALIDA = "12345-1";
	private static final String CONTA_CORRENTE_DESTINO_VALIDA = "54325-5";
	private static final BigDecimal VALOR_TRANSFERENCIA_VALIDO = new BigDecimal("10000");
	private static final Calendar DATA_AGENDAMENTO_VALIDA = CalendarUtils.newCalendar(2016, 10, 3);

	private static final String CONTA_CORRENTE_ORIGEM_INVALIDA = "12345-12";
	private static final Calendar DATA_AGENDAMENTO_INVALIDA = CalendarUtils.newCalendar(2015, 10, 3);
	
	@BeforeClass
	public static void iniciaBanco() throws SQLException{
		BancoDeDados.criaBanco();
	}

	@AfterClass
	public static void removeBanco() throws SQLException {
		BancoDeDados.removeBanco();
	}
	
	@Test
	public void passo1_testeAgendamentoDeTransferenciaComSucesso() throws Exception {
		AgendamentoTransferenciaService service = new AgendamentoTransferenciaService();
		service.agendarTransferencia(CONTA_CORRENTE_ORIGEM_VALIDA,CONTA_CORRENTE_DESTINO_VALIDA,
				VALOR_TRANSFERENCIA_VALIDO, DATA_AGENDAMENTO_VALIDA, TipoTransferencia.B);
	}
	
	@Test
	public void passo2_testeObterListaDeTransferencias() throws Exception{
		AgendamentoTransferenciaService service = new AgendamentoTransferenciaService();
		List<Transferencia> lista = service.obterTodasTransferenciasAgendadas();
		Assert.assertTrue(lista != null && !lista.isEmpty());
	}
	
	@Test(expected=Exception.class)
	public void passo3_testeAgendamentoDeTransferenciaSemSucesso() throws Exception {
		AgendamentoTransferenciaService service = new AgendamentoTransferenciaService();
		service.agendarTransferencia(CONTA_CORRENTE_ORIGEM_INVALIDA,CONTA_CORRENTE_DESTINO_VALIDA,
				VALOR_TRANSFERENCIA_VALIDO, DATA_AGENDAMENTO_INVALIDA, TipoTransferencia.B);
	}
	
}
