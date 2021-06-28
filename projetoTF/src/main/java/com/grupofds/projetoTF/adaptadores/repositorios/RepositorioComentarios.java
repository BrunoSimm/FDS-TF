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
		
		 @Query(value = "INSERT INTO comentarios(id_usuario_fk,descricao,data,imagem,id_reclamacao_fk) "
		 		+ "VALUES(:#{#c.usuario}, :#{#c.descricao}, :#{#c.data}, :#{#c.imagem}, :#{#c.reclamacao});", nativeQuery = true) //TODO
	 	 Comentario addComentario(@Param("c")Comentario comentario);
	 	 
	 	default Comentario editComentario(Comentario comentario) {
	 		return this.save(comentario);
	 	}
	 	
	 	default boolean deleteComentario(Long idComentario) {
	 		this.deleteById(idComentario);
	 		return true;
	 	}
	 	
	    Comentario getById(Long id);
	    
	    @Query(value = "select * from comentarios where comentarios.id_reclamacao_fk = :idReclamacao", nativeQuery = true)
	    List<Comentario> getByReclamacao(@Param("idReclamacao") Long idReclamacao);
	    
	    @Query(value = "select * from comentarios where comentarios.id_usuario_fk = :idUsuario", nativeQuery = true)
	    List<Comentario> getByUsuario(@Param("idUsuario") Long idUsuario);
	    
	    @Query(value = "select * from reclamacoes where status = :status", nativeQuery = true)
	    List<Comentario> getByStatus(@Param("status")StatusReclamacoes status);
	   
	    @Query(value = "select * from comentarios where comentarios.data BETWEEN :inicio AND :final", nativeQuery = true)
	    List<Comentario> getByPeriodo(@Param("inicio") LocalDateTime periodoInicial, @Param("final") LocalDateTime periodoFinal);
	    
	
}
