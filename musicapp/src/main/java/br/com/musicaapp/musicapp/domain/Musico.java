package br.com.musicaapp.musicapp.domain;

public class Musico {
    private Integer idMusico;
    private String nomeMusico;
    private String genero;

    public Musico(){
    }

    public Musico(Integer idMusico, String nomeMusico, String genero){
        this.idMusico = idMusico;
        this.nomeMusico = nomeMusico;
        this.genero = genero;
    }

    public Integer getIdMusico() {
        return idMusico;
    }

    public void setIdMusico(Integer idMusico) {
        this.idMusico = idMusico;
    }

    public String getNomeMusico() {
        return nomeMusico;
    }

    public void setNomeMusico(String nomeMusico) {
        this.nomeMusico = nomeMusico;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
