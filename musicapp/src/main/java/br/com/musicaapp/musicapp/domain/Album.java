package br.com.musicaapp.musicapp.domain;

import java.util.Date;

public class Album {
    private Integer idAlbum;
    private String nomeAlbum;
    private Date dtLancamento;
    private String editora;
    private String descricao;
    private Musico musico;


    public Album(){
    }
    
    public Album(Integer idAlbum, String nomeAlbum, Date dtLancamento, String editora, String descricao, Musico musico){
        this.idAlbum = idAlbum;
        this.nomeAlbum = nomeAlbum;
        this.dtLancamento = dtLancamento;
        this.editora = editora;
        this.descricao = descricao;
        this.musico = musico;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Musico getMusico() {
        return musico;
    }

    public void setMusico(Musico musico) {
        this.musico = musico;
    }
}
