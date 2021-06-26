package com.grupofds.projetoTF.adaptadores.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;

@Repository
public interface RepositorioReclamacoes extends IRepositorioReclamacoes, JpaRepository<Reclamacao, Long> {
	
	Reclamacao createReclamacao(Reclamacao reclamacao);
    Reclamacao updateReclamacao(Reclamacao reclamacao);
    Reclamacao getById(Long id);
    List<Reclamacao> getByUsuario(Long id);
    List<Reclamacao> getReclamacoesByStatus(StatusReclamacoes status);
    List<Reclamacao> getByCategoria(String categoria);
    
    @Query(value = "select * from reclamacoes join enderecos on reclamacoes.endereco = ")
    List<Reclamacao> getByBairro(String bairro);
    
    
    @Query("select r from reclamacoes where r.data between :inicio and :final")
    List<Reclamacao> getByPeriodo(@Param("inicio") LocalDateTime periodoInicial, @Param("final") LocalDateTime periodoFinal);
    
    @Query(value = "select * from reclamacoes", nativeQuery = true)
    List<Reclamacao> getReclamacoes();
    
    
    List<Comentario> getAllComentarios(Reclamacao reclamacao);
}
