package br.com.senior.DesafioSenior.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.senior.DesafioSenior.model.Cidade;

public class ImportarPlanilha {

    public List<Cidade> csvParaList(String arquivo) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo)));
            String linha = null;
            List<Cidade> cidades = new ArrayList<>();
            int i = 0;
            while ((linha = reader.readLine()) != null) {
                if (i > 0) {
                    String[] dados = linha.split(",");
                    cidades.add(novoCidade(dados));
                } else {
                    i++;
                }
            }

            reader.close();

            return cidades;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Cidade novoCidade(String[] dados) {

        Cidade cidade = new Cidade();
        cidade.setIbge_id(Long.parseLong(dados[0]));
        cidade.setUf(dados[1]);
        cidade.setName(dados[2]);
        cidade.setCapital(Util.stringToBoolean(dados[3]));
        cidade.setLon(Double.parseDouble(dados[4]));
        cidade.setLat(Double.parseDouble(dados[5]));
        cidade.setNo_accents(dados[6]);
        cidade.setAlternative_names(dados[7]);
        cidade.setMesoregion(dados[9].trim());

        return cidade;
    }
}
