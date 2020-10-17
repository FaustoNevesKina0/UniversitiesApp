package br.usjt.ads20.appfilmes.model;

import java.io.Serializable;
/**
 * Fausto Neves Kina
 * RA 81820328
 */
public class Universidade implements Serializable, Comparable<Universidade> {
    private String nome;
    private String country;
    private String alphaTwoCode;

    public String getWebPages() {
        return webPages;
    }

    public void setWebPages(String webPages) {
        this.webPages = webPages;
    }

    private String webPages;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

    public void setAlphaTwoCode(String alphaTwoCode) {
        this.alphaTwoCode = alphaTwoCode;
    }


    @Override
    public int compareTo(Universidade universidade) {
        return getNome().compareTo(universidade.getNome());
    }
}
