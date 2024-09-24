package br.gov.sp.fatec.projeto_spring20242.security;

import java.util.List;

// Classe de Comunicação com o Front
public class Login {
    private String nome;
    private String senha;
    private String token;
    private List<String> autorizações;

    public List<String> getAutorizações() {
        return autorizações;
    }

    public void setAutorizações(List<String> autorizações) {
        this.autorizações = autorizações;
    }

    public Login(){};

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Login(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }
}
