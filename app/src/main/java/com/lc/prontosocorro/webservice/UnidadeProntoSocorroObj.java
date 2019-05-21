package com.lc.prontosocorro.webservice;

public class UnidadeProntoSocorroObj {

    private String nome;
    private String endereco;
    private String tipoPatrimonio;
    private String tipoUnidade;
    private String geoLocalizacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoPatrimonio() {
        return tipoPatrimonio;
    }

    public void setTipoPatrimonio(String tipoPatrimonio) {
        this.tipoPatrimonio = tipoPatrimonio;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public String getGeoLocalizacao() {
        return geoLocalizacao;
    }

    public void setGeoLocalizacao(String geoLocalizacao) {
        this.geoLocalizacao = geoLocalizacao;
    }


    @Override
    public String toString() {

        return    " Nome: "     + this.nome
                + " Tipo: "     + this.tipoUnidade;
    }
}
