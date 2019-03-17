package br.com.senior.DesafioSenior.controller;

public enum EstadoEnum {

    ACRE("Acre", "AC"),
    ALAGOAS("Alagoas", "AL"),
    AMAPA("Amapá", "AP"),
    AMAZONAS("Amazonas", "AM"),
    BAHIA("Bahia", "BA"),
    CEARA("Ceará", "CE"),
    DISTRITOFEDERAL("Distrito Federal", "DF"),
    ESPIRITOSANTO("Espírito Santo", "ES"),
    GOIAS("Goiás", "GO"),
    MARANHAO("Maranhão", "MA"),
    MATOGROSSO("Mato Grosso", "MT"),
    MATOGROSSODOSUL("Mato Grosso do Sul", "MS"),
    MINASGERAIS("Minas Gerais", "MG"),
    PARA("Pará", "PA"),
    PARAIBA("Paraíba", "PB"),
    PARANA("Paraná", "PR"),
    PERNAMBUCO("Pernambuco", "PE"),
    PIAUI("Piauí", "PI"),
    RIODEJANEIRO("Rio de Janeiro", "RJ"),
    RIOGRANDEDONORTE("Rio Grande do Norte", "RN"),
    RIOGRANDEDOSUL("Rio Grande do Sul", "RS"),
    RONDONIA("Rondônia", "RO"),
    RORAIMA("Roraima", "RR"),
    SANTACATARINA("Santa Catarina", "SC"),
    SAOPAULO("São Paulo", "SP"),
    SERGIPE("Sergipe", "SE"),
    TOCANTINS("Tocantins", "TO");

    private String nome;
    private String uf;

    private EstadoEnum(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public static String getByUf(String uf) {
        for (EstadoEnum e : values()) {
            if (e.uf.equals(uf)) {
                return e.getNome();
            }
        }
        return "";
    }
}
