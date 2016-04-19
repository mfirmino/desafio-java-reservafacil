package br.tur.reservafacil.taxa;

import java.math.BigDecimal;
import java.util.Calendar;

public interface TipoTaxa {
	
	BigDecimal calcularTaxa(BigDecimal valorTransferencia, Calendar dataAgendamento) throws Exception;
	
}
