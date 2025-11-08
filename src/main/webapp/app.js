Ext.application({
    extend: 'SistemaOs.Application',

    name: 'SistemaOs',

    requires: [
        'SistemaOs.*',
		'SistemaOs.view.cliente.Cliente',
		'SistemaOs.view.main.MainInicial',
    ],

    mainView: 'SistemaOs.view.main.MainInicial'
});