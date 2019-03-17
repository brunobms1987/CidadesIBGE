package br.com.senior.DesafioSenior.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.senior.DesafioSenior.model.Cidade;

public class LatitudeLongitude {

    private final static int raioTerra = 6371;

    public static double distancia(double startLat, double startLong,
            double endLat, double endLong) {

        double dLat = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return raioTerra * c;
    }

    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }

    public List<Cidade> maiorDistancia(List<Cidade> cidades) {

        List<Cidade> maiorDistancia = new ArrayList<Cidade>();

        double distancia = 0;
        for (Cidade cidade : cidades) {

            for (int i = 0; i < cidades.size(); i++) {

                double distanciaCidades = distancia(cidade.getLat(), cidade.getLon(), cidades.get(i).getLat(), cidades.get(i).getLon());
                if (distanciaCidades > distancia) {
                    distancia = distanciaCidades;
                    maiorDistancia.clear();
                    maiorDistancia.add(cidade);
                    maiorDistancia.add(cidades.get(i));
                }
            }
        }
        return maiorDistancia;
    }
}
