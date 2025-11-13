Ext.application({
    extend: 'SistemaOs.Application',

    name: 'SistemaOs',

    requires: [
        'SistemaOs.*',
		'SistemaOs.view.main.MainInicial',
		'SistemaOs.view.cliente.Cliente',
		'SistemaOs.view.estoque.ListagemEstoque',
		'SistemaOs.view.os.ListagemOs',
		'SistemaOs.view.cliente.ListagemCliente'
    ],

    mainView: 'SistemaOs.view.main.MainInicial'
});