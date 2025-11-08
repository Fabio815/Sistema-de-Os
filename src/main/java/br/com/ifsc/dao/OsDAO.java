package br.com.ifsc.dao;

import java.time.LocalTime;

public class OsDAO {
	public LocalTime dataEmissao;
	public boolean Status;
	public Long idCliente;
	
	public LocalTime getDataEmissao() {
		return dataEmissao;
	}
	
	public void setDataEmissao(LocalTime dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	
	public boolean isStatus() {
		return Status;
	}
	
	public void setStatus(boolean status) {
		Status = status;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "OsDAO [dataEmissao=" + dataEmissao + ", Status=" + Status + ", idCliente=" + idCliente + "]";
	}
}
