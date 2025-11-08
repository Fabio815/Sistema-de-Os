package br.com.ifsc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.ifsc.config.DatabaseConfig;
import br.com.ifsc.dao.ClienteDAO;
import br.com.ifsc.model.Cliente;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public class ClienteController {
	
	@POST
	@Path("/cadastrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adicionarCliente(Cliente cliente) {
		Connection connection = null;
		if (cliente == null) { 
			//TODO Futuramente colocar log, mensagens melhores não sei...
			return Response.status(500).entity("Cliente dados invalidos ").build();
		}
		try {
			connection = DatabaseConfig.connection();
			ClienteDAO.adicionarCliente(cliente, connection);
		} catch (Exception ex) {
			return Response.status(500).entity("Erro ao conectar no banco " + ex).build();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				return Response.status(500).entity("Erro ao fechar a conexão " + ex).build();
			}
		}
        return Response.ok().entity("Cadastro feito com sucesso.").build();
	}
	
	@POST
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarCliente() {
		Connection connection = null;
		List<Cliente> clientes = null;
		try {
			connection = DatabaseConfig.connection();
			clientes = ClienteDAO.listarClientes(connection);
		} catch (Exception ex) {
			return Response.status(500).entity("Erro ao conectar no banco " + ex).build();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				return Response.status(500).entity("Erro ao fechar a conexão " + ex).build();
			}
		}
        return Response.ok().entity(clientes).build();
	}
	
	@POST
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarCliente(@QueryParam("id") Long id) {
		Connection connection = null;
		Cliente cliente = null;
		if (id == null) {
			return Response.status(500).entity("Id do cliente inválido").build();
		}
		try {
			connection = DatabaseConfig.connection();
			cliente = ClienteDAO.buscarCliente(connection, id);
		} catch (Exception ex) {
			return Response.status(500).entity("Erro ao buscar cliente " + ex).build();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				return Response.status(500).entity("Erro ao fechar a conexão" + ex).build();
			}
		}
        return Response.ok().entity(cliente).build();
	}
	
	@POST
	@Path("/deletar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarCliente(@QueryParam("id") Long id) {
		Connection connection = null;
		if (id == null) {
			return Response.status(500).entity("Id do cliente inválido").build();
		}
		try {
			connection = DatabaseConfig.connection();
			ClienteDAO.deletarCliente(connection, id);
		} catch (Exception ex) {
			return Response.status(500).entity("Erro ao buscar cliente " + ex).build();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception ex) {
				return Response.status(500).entity("Erro ao fechar a conexão" + ex).build();
			}
		}
        return Response.ok().entity("Cliente deletado com secesso").build();
	}
	
}
