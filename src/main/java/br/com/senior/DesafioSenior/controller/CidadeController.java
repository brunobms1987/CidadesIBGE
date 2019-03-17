package br.com.senior.DesafioSenior.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.DesafioSenior.model.Cidade;
import br.com.senior.DesafioSenior.model.Estado;
import br.com.senior.DesafioSenior.service.CidadeService;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Cidade>> listarCidades() {
        return ResponseEntity.ok(cidadeService.listarCidades());
    }

    @GetMapping("/inserir")
    @Produces(MediaType.APPLICATION_JSON)
    public String inserirCvs() {
        ImportarPlanilha csv = new ImportarPlanilha();
        String nomeArquivo = "D:\\Bruno Martins\\Sistemas Diversos\\Senior\\DesafioSenior\\planilha\\CSV_Cidades_Senior.csv";
        List<Cidade> listCidades = csv.csvParaList(nomeArquivo);
        if (null == listCidades) {
            return "Arquivo não carregado.";
        } else {
            cidadeService.inserir(listCidades);
            return "Municipios inseridos com sucesso";
        }
    }

    @GetMapping("/buscarCapitais")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] buscaCapitais() {
        List<Cidade> municipio = cidadeService.buscarCapitais();
        return municipio.toArray();
    }

    @GetMapping("/buscarCidadePorID/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cidade buscarCidadePorID(@PathVariable("id") long id) {
        return cidadeService.buscarCidadePorID(id);
    }

    @GetMapping("/totalRegistros")
    @Produces(MediaType.APPLICATION_JSON)
    public long totalRegistros() {
        return cidadeService.totalRegistros();
    }

    @GetMapping("/buscarCidadePorUF/{uf}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cidade> municipiosPorEstado(@PathVariable("uf") String uf) {
        return cidadeService.buscarCidadePorUF(uf.toUpperCase());
    }

    @GetMapping("/totalRegistrosPorColuna/{coluna}")
    @Produces(MediaType.APPLICATION_JSON)
    public long totalRegistrosPorColuna(@PathVariable("coluna") String coluna) {
        return cidadeService.totalRegistrosPorColuna(coluna);
    }

    @GetMapping("/buscarPorColunaEValor/{coluna}/{valor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cidade> buscarPorColunaEValor(@PathVariable("coluna") String coluna, @PathVariable("valor") String valor) {
        return cidadeService.buscarPorColunaEValor(coluna, valor);
    }

    @GetMapping("/totalCidadesPorEstado")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> totalCidadesPorEstado() {
        return cidadeService.totalCidadesPorEstado();
    }

    @GetMapping("/minMaxPorEstado")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> minMaxPorEstado() {
        List<Estado> estados = new ArrayList<Estado>();
        estados.add(cidadeService.minCidadesPorEstado().get(0));
        estados.add(cidadeService.maxCidadesPorEstado().get(0));
        return estados;
    }

    @GetMapping("/deletarPorId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deletarPorId(@PathVariable("id") long id) {
        cidadeService.deletarPorId(id);
        return "Cidade excluída com  sucesso";
    }

    @GetMapping("/incluirCidade/{id}/{uf}/{nome}/{capital}/{lon}/{lat}/{noAccents}/{alternativeNames}/{microregion}/{mesoregion}")
    @Produces(MediaType.APPLICATION_JSON)
    public String incluirCidade(@PathVariable("id") long id, @PathVariable("uf") String uf,
            @PathVariable("nome") String nome, @PathVariable("capital") String capital,
            @PathVariable("lon") Double lon, @PathVariable("lat") Double lat,
            @PathVariable("noAccents") String noAccents, @PathVariable("alternativeNames") String alternativeNames,
            @PathVariable("microregion") String microregion, @PathVariable("mesoregion") String mesoregion) {

        Cidade cidade = new Cidade();
        cidade.setIbge_id(id);
        cidade.setUf(uf);
        cidade.setName(nome);
        cidade.setCapital(Util.stringToBoolean(capital));
        cidade.setLon(lon);
        cidade.setLat(lat);
        cidade.setNo_accents(noAccents);
        cidade.setAlternative_names(alternativeNames);
        cidade.setMicroregion(microregion);
        cidade.setMesoregion(mesoregion);
        cidadeService.incluirCidade(cidade);
        return "Nova cidade cadastrada.";
    }

    @GetMapping("/municipiosMaisDistantes")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] municipiosMaisDistantes() {
        LatitudeLongitude calc = new LatitudeLongitude();
        Object[] array = calc.maiorDistancia(cidadeService.listarCidades()).toArray();
        return array;
    }

}
