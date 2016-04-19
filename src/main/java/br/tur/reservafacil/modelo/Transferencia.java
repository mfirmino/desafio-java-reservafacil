package br.tur.reservafacil.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Transferencia {

	private Integer id;
	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valor;
	private BigDecimal taxa;	
	private Calendar dataAgendamento;	
	private TipoTransferencia tipo;

	public Transferencia(){
		
	}
	
	public Transferencia(String contaOrigem, String contaDestino, BigDecimal valor, BigDecimal taxa,
			Calendar dataAgendamento, TipoTransferencia tipo) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.taxa = taxa;
		this.dataAgendamento = dataAgendamento;
		this.tipo = tipo;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public Calendar getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Calendar dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public TipoTransferencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransferencia tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Transferencia)) {
			return false;
		}
		Transferencia castOther = (Transferencia) other;
		return new EqualsBuilder().append(id, castOther.id).append(contaOrigem, castOther.contaOrigem)
				.append(contaDestino, castOther.contaDestino).append(valor, castOther.valor)
				.append(taxa, castOther.taxa).append(dataAgendamento, castOther.dataAgendamento)
				.append(tipo, castOther.tipo).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(contaOrigem).append(contaDestino).append(valor).append(taxa)
				.append(dataAgendamento).append(tipo).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("contaOrigem", contaOrigem)
				.append("contaDestino", contaDestino).append("valor", valor).append("taxa", taxa)
				.append("dataAgendamento", dataAgendamento).append("tipo", tipo).toString();
	}

}
