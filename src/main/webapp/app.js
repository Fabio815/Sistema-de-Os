Ext.application({
    extend: 'SistemaOs.Application',

    name: 'SistemaOs',

    requires: [
        'SistemaOs.*',
		'SistemaOs.view.cliente.Cliente',
		'SistemaOs.view.main.MainInicial',
		'SistemaOs.view.estoque.ListagemEstoque',
		'SistemaOs.view.os.ListagemOs'
    ],

    mainView: 'SistemaOs.view.main.MainInicial'
});