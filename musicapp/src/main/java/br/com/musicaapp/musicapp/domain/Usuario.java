package br.com.musicaapp.musicapp.domain;

import java.util.Date;

public class Usuario {
    private Integer idUsuario;
    private String nomeUsuario;
    private Date dtNascimento;
    private String email;
    private String senha;

    public Usuario(){
    }

    public Usuario(Integer idUsuario, String nomeUsuario, Date dtNascimento, String email, String senha){
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.dtNascimento = dtNascimento;
        this.email = email;
        this.senha = senha;
    }
    
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public Date getDtNascimento() {
        return dtNascimento;
    }
    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
