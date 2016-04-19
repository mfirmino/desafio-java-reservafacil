package br.tur.reservafacil.testes;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.tur.reservafacil.dao.TransferenciaDAO;
import br.tur.reservafacil.infra.BancoDeDados;
import br.tur.reservafacil.modelo.TipoTransferencia;
import br.tur.reservafacil.modelo.Transferencia;

public class TransferenciaDAOTeste {
	
	private static final String CONTA_ORIGEM_VALIDA = "12345-6";
	private static final String CONTA_DESTINO_VALIDA = "12345-6";
	private static final BigDecimal VALOR_CALCULO = new BigDecimal("10000");
	private static final BigDecimal TAXA_PROV = new BigDecimal("10");
	private static final Calendar DATA_AGENDAMENTO_VALIDA = Calendar.getInstance();
	
	@BeforeClass
	public static void iniciaBanco() throws SQLException{
		BancoDeDados.criaBanco();
	}

	@AfterClass
	public static void removeBanco() throws SQLException {
		BancoDeDados.removeBanco();
	}
	
	@Test
	public void testeSimplesDeInsercao() {
		Transferencia transf = new Transferencia(CONTA_ORIGEM_VALIDA, CONTA_DESTINO_VALIDA,
				VALOR_CALCULO, TAXA_PROV, DATA_AGENDAMENTO_VALIDA, TipoTransferencia.A);
		
		TransferenciaDAO dao = new TransferenciaDAO();
		dao.adiciona(transf);
	}
	
	@Test
	public void testeConsultaListaTransferencias(){
		TransferenciaDAO dao = new TransferenciaDAO();
		List<Transferencia> lista = dao.lista();
		Assert.assertTrue(lista != null && !lista.isEmpty());
	}
	
}
