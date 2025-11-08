Ext.define('SistemaOs.view.main.MainInicial', {
	extend: 'Ext.container.Container',
    xtype: 'tela-inicial-panel',

	layout: 'border',
	bodyBorder: false,
	defaults: {
	    collapsible: true,
	    split: true,
	    bodyPadding: 15
	},
	items: [{
		xtype: 'panel',
	    title: 'Menu',
	    region:'west',
	    floatable: false,
	    margins: '5 0 0 0',
	    width: 189,
	    minWidth: 100,
	    maxWidth: 250,
		items: [{
			xtype: 'treelist',
            store: Ext.create('Ext.data.TreeStore', {
                root: {
                    expanded: true,
                    children: [{
                        text: "Dashboard",
                        iconCls: 'fa fa-home',
                        leaf: true,
                        id: 'dashboard'
                    }, {
                        text: "Ordem de Serviço",
                        iconCls: 'fa fa-file-text',
                        leaf: true,
                        id: 'os'
                    }, {
                        text: "Clientes",
                        iconCls: 'fa fa-users',
                        leaf: true,
                        id: 'clientes'
                    }]
                }
            })
		}]
	}, {
		xtype: 'toolbar',
		style: {
			marginBottom: '10px',
			backgroundColor: '#686b6e',
			color: 'white'
		},
		html: 'Minha Toolbar',
		region: 'north',
		collapsible: false,
		split: false,
		height: 65,
		border: false,
	}, {
	    title: 'Componente principal',
	    collapsible: false,
	    region: 'center',
	    margins: '5 0 0 0',
	    html: 'Principal'
	}]
});