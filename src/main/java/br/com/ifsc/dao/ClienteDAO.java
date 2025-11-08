package br.com.ifsc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ifsc.model.Cliente;

public class ClienteDAO {

    public static void adicionarCliente(Cliente cliente, Connection connection) throws Exception {
        if (cliente != null && connection != null) {
            PreparedStatement stmtEndereco = null;
            PreparedStatement stmtCliente = null;
            ResultSet rs = null;

            try {
                stmtCliente = connection.prepareStatement("insert into bf_cliente(nome, telefone) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
                stmtCliente.setString(1, cliente.getNome());
                stmtCliente.setString(2, cliente.getTelefone());
                stmtCliente.executeUpdate();
                
                rs = stmtCliente.getGeneratedKeys();
                long ultimoEndereco = 0;
                if (rs.next()) {
                    ultimoEndereco = rs.getLong(1);
                }
                
                stmtEndereco = connection.prepareStatement("insert into bf_endereco(rua, bairro, numero, complemento, id_cliente) values(?, ?, ?, ?, ?)");
                stmtEndereco.setString(1, cliente.getRua());
                stmtEndereco.setString(2, cliente.getBairro());
                stmtEndereco.setString(3, cliente.getNumero());
                stmtEndereco.setString(4, cliente.getComplemento());
                stmtEndereco.setLong(5, ultimoEndereco);
                stmtEndereco.executeUpdate();
                
            } finally {
                if (rs != null) {
                	rs.close();
                }
                if (stmtEndereco != null) {
                	stmtEndereco.close();
                }
                if (stmtCliente != null) {
                	stmtCliente.close();
                }
            }
        }
    }
    
    public static List<Cliente> listarClientes(Connection connection) throws Exception {
    	List <Cliente> lista = null;
		PreparedStatement stmt = connection.prepareStatement("""
					select c.nome, c.telefone, e.rua, e.bairro, e.numero, e.complemento from bf_cliente as c
					left join bf_endereco as e on c.id=e.id_cliente
				""");
		ResultSet rs = stmt.executeQuery();

		Cliente cliente = null;
		if (rs != null) {
			lista = new ArrayList<Cliente>();
			while(rs.next()) {
				cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
	            cliente.setTelefone(rs.getString("telefone"));
	            cliente.setRua(rs.getString("rua"));         
	            cliente.setBairro(rs.getString("bairro"));    
	            cliente.setNumero(rs.getString("numero"));
	            cliente.setComplemento(rs.getString("complemento")); 
				lista.add(cliente);
			}
		}
    	return lista;
    }
    
    public static Cliente buscarCliente(Connection connection, Long id) throws Exception {
    	Cliente cliente = null;
    	if (id != null) {
        	PreparedStatement stmt = null;
        	ResultSet rs = null;
    		stmt = connection.prepareStatement("""
						select c.nome, c.telefone, e.rua, e.bairro, e.numero, e.complemento from bf_cliente as c
						left join bf_endereco as e on c.id=e.id_cliente where c.id=?
    				""");
    		stmt.setLong(1, id);
    		rs = stmt.executeQuery(); 
    		if (rs.next()) {
				cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setRua(rs.getString("rua"));         
				cliente.setBairro(rs.getString("bairro"));    
				cliente.setNumero(rs.getString("numero"));
				cliente.setComplemento(rs.getString("complemento")); 
    		}
        	if (stmt != null) {
        		stmt.close();
        	}
        	if (rs != null) {
        		rs.close();
        	}
    	}
    	return cliente;
    }
    
    public static void deletarCliente(Connection connection, Long id) throws Exception {
    	if (id != null && connection != null) {
    		PreparedStatement stmt = null;
    		stmt = connection.prepareStatement("delete from bf_cliente as c where c.id=?");
    		stmt.setLong(1, id);
    		stmt.executeUpdate();
    		
    		if (stmt != null) {
    			stmt.close();
    		}
    	}
    }
}








