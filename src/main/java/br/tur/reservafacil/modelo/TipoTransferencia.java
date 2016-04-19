package br.tur.reservafacil.modelo;

import br.tur.reservafacil.taxa.TaxaTipoA;
import br.tur.reservafacil.taxa.TaxaTipoB;
import br.tur.reservafacil.taxa.TaxaTipoC;
import br.tur.reservafacil.taxa.TaxaTipoD;
import br.tur.reservafacil.taxa.TipoTaxa;

public enum TipoTransferencia {
	A(new TaxaTipoA()),
	B(new TaxaTipoB()),
	C(new TaxaTipoC()),
	D(new TaxaTipoD());
	
	private final TipoTaxa tipoTaxa;
	
	TipoTransferencia(TipoTaxa tipoTaxa) {
		this.tipoTaxa = tipoTaxa;
	}
	
	public TipoTaxa getTipoTaxa(){
		return tipoTaxa;
	}
}
