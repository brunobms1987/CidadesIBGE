package br.com.senior.DesafioSenior.model;

import br.com.senior.DesafioSenior.controller.EstadoEnum;

public class Estado {

    private String uf;
    private String nome;
    private long total;

    public Estado(String uf, long total) {
        super();
        this.uf = uf;
        this.total = total;
        this.nome = EstadoEnum.getByUf(uf);
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
