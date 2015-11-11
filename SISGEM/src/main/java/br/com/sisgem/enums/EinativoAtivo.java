package br.com.sisgem.enums;

public enum EinativoAtivo {

	Ativo("Ativo"), Inativo("Inativo");
	
	private String situacaoLabel;

	private EinativoAtivo(String situacaoLabel) {
		this.setSituacaoLabel(situacaoLabel);
	}

	public String getSituacaoLabel() {
		return situacaoLabel;
	}

	public void setSituacaoLabel(String situacaoLabel) {
		this.situacaoLabel = situacaoLabel;
	}
	
}
