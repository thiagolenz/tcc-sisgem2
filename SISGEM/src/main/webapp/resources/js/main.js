function disableButtons() {
	deleteButton.disable();
	updateButton.disable();
}

function enableButtons() {
	updateButton.enable();
	deleteButton.enable();
}

function unselectRows() {
	disableButtons();
	dataTable.unselectAllRows();
}

function disableButtonAdicionais(){
	matrizButton.disable();
	empresaFaturarButton.disable();
}

function enableButtonsAdicionais(){
	empresaFaturarButton.enable();
	matriz.enable();
}


	