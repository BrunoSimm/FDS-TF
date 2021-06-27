package com.grupofds.projetoTF.adaptadores.repositorios;

import com.grupofds.projetoTF.negocio.entidades.Endereco;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioEnderecos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEnderecos extends IRepositorioEnderecos, JpaRepository<Endereco, Long> {
	
	default Endereco createEndereco(Endereco endereco) {
		return this.save(endereco);
	}
	
    default Endereco updateEndereco(Endereco endereco) {
    	return this.save(endereco);
    }
    
    Endereco getById(Long id);
    
    @Query(value = "select * from enderecos where enderecos.reclamacao_id = :reclamacaoId", nativeQuery = true)
    Endereco getByReclamacaoId(@Param("reclamacaoId") Long id);

}
