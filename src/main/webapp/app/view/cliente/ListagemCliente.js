Ext.define('SistemaOs.view.cliente.ListagemCliente', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.listagem-cliente',
	
	columns: [{
		text: 'Id',
		dataIndex: 'id',
		width: 50
	}, {
		text: 'Nome',
		dataIndex: 'nome',
		width: 250
	}, {
		text: 'Telefone',
		dataIndex: 'telefone',
		width: 150
	}, {
		text: 'Rua',
		dataIndex: 'rua',
		width: 500
	}, {
		text: 'Bairro',
		dataIndex: 'bairro',
		width: 300
	}, {
		text: 'Numero',
		dataIndex: 'numero',
		width: 100
	}, {
		text: 'Complemento',
		dataIndex: 'complemento',
		width: 300
	}]
});
