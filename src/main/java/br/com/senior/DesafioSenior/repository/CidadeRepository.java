package br.com.senior.DesafioSenior.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.senior.DesafioSenior.controller.Util;
import br.com.senior.DesafioSenior.model.Cidade;
import br.com.senior.DesafioSenior.model.Estado;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("select c from Cidade c where c.capital is true order by c.name asc")
    public List<Cidade> buscarCapitais();

    @Query("select c from Cidade c where c.ibge_id =:id")
    public Cidade buscarCidadePorID(@Param("id") long id);

    @Query("select count(c) from Cidade c")
    public long totalRegistros();

    @Query("select c.name from Cidade c where UPPER(c.uf) =:uf")
    public List<Cidade> buscarCidadePorUF(@Param("uf") String uf);

    public default long totalRegistrosPorColuna(String coluna, EntityManager entity) {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(distinct c.");
        sql.append(coluna);
        sql.append(") as total from Cidade c");
        return Long.parseLong(entity.createNativeQuery(sql.toString()).getSingleResult().toString());
    }

    public default List<Cidade> buscarPorColunaEValor(String coluna, String valor, EntityManager entity) {
        StringBuilder sql = new StringBuilder();
        sql.append("select c.* from Cidade c where ");
        if (Util.isDouble(valor) || Util.isInt(valor)) {
            sql.append("c.");
            sql.append(coluna);
            sql.append(" = ");
            sql.append(valor);
        } else {
            sql.append("UPPER(c.");
            sql.append(coluna);
            sql.append(")");
            sql.append(" like '%");
            sql.append(valor.toUpperCase());
            sql.append("%'");
        }

        return (List<Cidade>) entity.createNativeQuery(sql.toString(), Cidade.class).getResultList();
    }

    @Query("select new br.com.senior.DesafioSenior.model.Estado(uf, count(uf) as total) from Cidade m group by uf")
    public List<Estado> totalCidadesPorEstado();

    @Query("select new br.com.senior.DesafioSenior.model.Estado(uf, count(uf) as total) from Cidade c group by uf order by total desc")
    public List<Estado> maxCidadesPorEstado(Pageable pageable);

    @Query("select new br.com.senior.DesafioSenior.model.Estado(uf, count(uf) as total) from Cidade c group by uf order by total asc")
    public List<Estado> minCidadesPorEstado(Pageable pageable);
}
