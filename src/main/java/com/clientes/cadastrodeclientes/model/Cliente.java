package com.clientes.cadastrodeclientes.model;

import java.util.Calendar;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "clientes")
public class Cliente {
	@Id
	@ApiModelProperty(notes = "CPF do cliente, identificador.")
    private String cpf;
	@ApiModelProperty(notes = "Nome do cliente.")
    private String nome;
	@ApiModelProperty(notes = "Data de cadastro do cliente.")
    private  Date dataCadastro;
	@ApiModelProperty(notes = "Idade  do cliente.")
    private  int idade;
	@ApiModelProperty(notes = "Email do cliente.")
    private String email;

    public Cliente(String cpf, String name,  int idade, String email) {
		this.cpf = cpf;
		this.nome = name;
		this.dataCadastro =   Calendar.getInstance().getTime();
		this.idade = idade;
		this.email = email;
	}


	public Cliente() {}
    

	public Cliente(String cpf, String name) {
		this.cpf = cpf;
		this.nome = name;
	}


	public String getCPF() {
		return this. cpf;
	}

	public void setICPF(String cpf) {
		this.cpf= cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}


	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public String getEmail() {
		return email;
	}

	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Cliente [CPF=" + cpf + ", nome=" + nome + ", dataCadastro=" + dataCadastro + ", idade=" + idade
				+ ", email=" + email + "]";
	}


}
