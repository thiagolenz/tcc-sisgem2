package br.com.sisgem.enums;

public enum Ecargo {

	Administrador("Administrador"), Vendedor("Vendedor"), Estoque("Estoque");
	
	
	private String situacaoLabel;

	private Ecargo(String situacaoLabel) {
		this.setSituacaoLabel(situacaoLabel);
	}

	public String getSituacaoLabel() {
		return situacaoLabel;
	}

	public void setSituacaoLabel(String situacaoLabel) {
		this.situacaoLabel = situacaoLabel;
	}
	
}
