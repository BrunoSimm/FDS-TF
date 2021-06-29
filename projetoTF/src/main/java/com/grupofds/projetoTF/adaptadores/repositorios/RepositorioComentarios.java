package com.grupofds.projetoTF.adaptadores.repositorios;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioComentarios;


@Repository
public interface RepositorioComentarios extends IRepositorioComentarios, JpaRepository<Comentario,Long> {
		
		 
	 	default Comentario addComentario(Comentario comentario){
		 	return this.save(comentario);
		}
	 	 
	 	default Comentario editComentario(Comentario comentario) {
	 		return this.save(comentario);
	 	}
	 	
	 	default boolean deleteComentario(Long idComentario) {
	 		this.deleteById(idComentario);
	 		return true;
	 	}
	 	
	    Comentario getById(Long id);
	    
	    @Query(value = "select * from comentarios where comentarios.reclamacao_id = :idReclamacao", nativeQuery = true)
	    List<Comentario> getByReclamacao(@Param("idReclamacao") Long idReclamacao);
	    
	    @Query(value = "select * from comentarios where comentarios.id_usuario_fk = :idUsuario", nativeQuery = true)
	    List<Comentario> getByUsuario(@Param("idUsuario") Long idUsuario);
	    
	    @Query(value = "select * from reclamacoes where status = :status", nativeQuery = true)
	    List<Comentario> getByStatus(@Param("status")StatusReclamacoes status);
	   
	    @Query(value = "select * from comentarios where comentarios.data BETWEEN :inicio AND :final", nativeQuery = true)
	    List<Comentario> getByPeriodo(@Param("inicio") LocalDateTime periodoInicial, @Param("final") LocalDateTime periodoFinal);
	  
}
