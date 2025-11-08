package br.com.ifsc.model;

public class Cliente {
	
	public String nome;
	public String telefone;
	public String rua;
	public String bairro;
	public String numero;
	public String complemento;
	
	public String getRua() {
		return this.rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", telefone=" + telefone + ", rua=" + rua + ", bairro=" + bairro + ", numero="
				+ numero + ", complemento=" + complemento + "]";
	}
}
