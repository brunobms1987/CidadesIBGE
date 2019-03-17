package br.com.senior.DesafioSenior.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.senior.DesafioSenior.model.Cidade;
import br.com.senior.DesafioSenior.model.Estado;
import br.com.senior.DesafioSenior.repository.CidadeRepository;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @PersistenceContext
    private EntityManager entity;

    public List<Cidade> listarCidades() {
        try {
            return cidadeRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public void inserir(List<Cidade> cidades) {
        cidadeRepository.saveAll(cidades);
    }

    public List<Cidade> buscarCapitais() {
        try {
            return cidadeRepository.buscarCapitais();
        } catch (Exception e) {
            return null;
        }
    }

    public Cidade buscarCidadePorID(long id) {
        try {
            return cidadeRepository.buscarCidadePorID(id);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Cidade> buscarCidadePorUF(String uf) {
        try {
            return cidadeRepository.buscarCidadePorUF(uf);
        } catch (Exception e) {
            return null;
        }
    }

    public long totalRegistrosPorColuna(String coluna) {
        return cidadeRepository.totalRegistrosPorColuna(coluna, entity);
    }

    public long totalRegistros() {
        return cidadeRepository.totalRegistros();
    }

    public List<Cidade> buscarPorColunaEValor(String coluna, String valor) {
        return cidadeRepository.buscarPorColunaEValor(coluna, valor, entity);
    }

    public List<Estado> totalCidadesPorEstado() {
        return cidadeRepository.totalCidadesPorEstado();
    }

    public List<Estado> minCidadesPorEstado() {
        return cidadeRepository.minCidadesPorEstado(new PageRequest(0, 1));
    }

    public List<Estado> maxCidadesPorEstado() {
        return cidadeRepository.maxCidadesPorEstado(new PageRequest(0, 1));
    }

    public void deletarPorId(long id) {
        cidadeRepository.deleteById(id);
    }

    public void incluirCidade(Cidade cidade) {
        cidadeRepository.save(cidade);
        cidadeRepository.flush();
    }
}
