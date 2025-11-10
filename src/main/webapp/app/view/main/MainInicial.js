Ext.define('SistemaOs.view.main.MainInicial', {
	extend: 'Ext.container.Container',
    xtype: 'tela-inicial-panel',
	
	controller: {
		opcaoSelecionada: function(tree, node) {
			var me = this, vw = me.getView();
			if (node) {
				var panelCentral = me.lookupReference('painelCentral');
				panelCentral.removeAll();
				var n = node.get('id');
				switch(n) {
					case 'clientes':
						panelCentral.add({xtype: 'cadastro-cliente'});
						break;
					case 'ordemServico':
						panelCentral.add({xtype: 'listagem-os'});
						break;
					case 'estoque':
						panelCentral.add({xtype: 'listagem-estoque'});
						break;
				}
			}
		}
	},
	
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
                        text: "Clientes",
                        iconCls: 'fa fa-users',
                        leaf: true,
                        id: 'clientes',
                    }, {
						text: 'OS',
						iconCls: 'fa fa-clipboard-list',
						leaf: true,
						id: 'ordemServico'
					}, {
						text: 'Estoque',
						iconCls: 'fa fa-box',
						leaf: true,
						id: 'estoque'
					}]
                }
            }),
			listeners: {
				selectionchange: 'opcaoSelecionada'
			}
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
	    html: 'Principal',
		reference: 'painelCentral'
	}]
});