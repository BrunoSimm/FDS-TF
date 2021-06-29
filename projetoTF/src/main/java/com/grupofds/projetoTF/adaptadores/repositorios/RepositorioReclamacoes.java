package com.grupofds.projetoTF.adaptadores.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioReclamacoes extends IRepositorioReclamacoes, JpaRepository<Reclamacao, Long> {
	
	default Reclamacao createReclamacao(Reclamacao reclamacao) {
		return this.save(reclamacao);
	}
	
    default Reclamacao updateReclamacao(Reclamacao reclamacao) {
    	return this.save(reclamacao);
    }
    
    @Query(value = "select * from reclamacoes where reclamacoes.id = :id", nativeQuery = true)
    Reclamacao getById(@Param("id") Long id);
    
    @Query(value = "select * from reclamacoes where reclamacoes.usuario_id = :userId", nativeQuery = true)
    List<Reclamacao> getByUsuario(@Param("userId") Long id);
    
    @Query(value = "select * from reclamacoes where reclamacoes.status = :status", nativeQuery = true)
    List<Reclamacao> getReclamacoesByStatus(@Param("status") StatusReclamacoes status);
    
    @Query(value = "select * from reclamacoes where reclamacoes.categoria = :categoria", nativeQuery = true)
    List<Reclamacao> getByCategoria(@Param("categoria") String categoria);
    
    @Query(value = "select * from reclamacoes join enderecos on reclamacoes.endereco_id = enderecos.id where enderecos.bairro = :bairro", nativeQuery = true)
    List<Reclamacao> getByBairro(@Param("bairro") String bairro);
    
    @Query(value = "select * from reclamacoes where reclamacoes.data BETWEEN :inicio AND :final ", nativeQuery = true)
    List<Reclamacao> getByPeriodo(@Param("inicio") LocalDateTime periodoInicial, @Param("final") LocalDateTime periodoFinal);
    
    @Query(value = "select * from reclamacoes", nativeQuery = true)
    List<Reclamacao> getReclamacoes();
}
