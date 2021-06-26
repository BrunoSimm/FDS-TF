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
	
	default Reclamacao createReclamacao(Reclamacao reclamacao) {
		return this.save(reclamacao);
	}
	
    default Reclamacao updateReclamacao(Reclamacao reclamacao) {
    	return this.save(reclamacao);
    }
    
    Reclamacao getById(Long id);
    
    @Query("select r from reclamacoes where r.usuario_id = :userId")
    List<Reclamacao> getByUsuario(@Param("userId") Long id);
    
    @Query("select r from reclamacoes where r.status = :status")
    List<Reclamacao> getReclamacoesByStatus(@Param("status") StatusReclamacoes status);
    
    @Query("select r from reclamacoes where r.categoria = :categoria")
    List<Reclamacao> getByCategoria(@Param("categoria") String categoria);
    
    @Query(value = "select * from reclamacoes join enderecos on reclamacoes.endereco_id = enderecos.id where enderecos.bairro = :bairro", nativeQuery = true)
    List<Reclamacao> getByBairro(@Param("bairro") String bairro);
    
    @Query("select r from reclamacoes where r.data between :inicio and :final")
    List<Reclamacao> getByPeriodo(@Param("inicio") LocalDateTime periodoInicial, @Param("final") LocalDateTime periodoFinal);
    
    @Query(value = "select * from reclamacoes", nativeQuery = true)
    List<Reclamacao> getReclamacoes();
}
