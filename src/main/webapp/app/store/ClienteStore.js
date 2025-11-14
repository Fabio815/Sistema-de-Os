Ext.define('SistemaOs.store.ClienteStore', {
	extend: 'Ext.data.Store',
	alias: 'widget.cliente-store',
	
	/*model: 'SistemaOs.model.ClienteModel',
	
	proxy: {
		type: 'ajax',
		url: 'http://localhost:8080/sistema-os/api/cliente/listar',
		actionMethods: {
		    read: 'POST'
		},
		reader: {
			type: 'json',
			//rootProperty: 'data'
		}
	},
	autoload: true*/
});