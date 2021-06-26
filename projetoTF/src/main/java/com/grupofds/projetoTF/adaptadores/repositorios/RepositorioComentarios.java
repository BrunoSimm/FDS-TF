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
	
	 	Comentario addComentario(Long usuarioId, Long idReclamacao, String mensagem, String imagem, StatusReclamacoes status);
	 	Comentario editComentario(Long idComentario, String mensagem , String imagem, StatusReclamacoes status);
	 	boolean deleteComentario(Long idComentario);
	 	
	    Comentario getById(Long id);
	    
	    List<Comentario> getByReclamacao(Long idReclamacao);
	    
	   
	    List<Comentario> getByUsuario(Long idUsuario);
	    
	    //@Query(value = "select * from reclamacoes where status = ?1", nativeQuery = true)
	    @Query("select r from reclamacoes r where r.status = :status")
	    List<Comentario> getByStatus(@Param("status")StatusReclamacoes status);
	    
	   //List<Comentario> getByPeriodo(LocalDateTime periodoInicial, LocalDateTime periodoFinal);
	
	
}
