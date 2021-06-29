package com.grupofds.projetoTF;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.validation.ConstraintViolationException;

import com.grupofds.projetoTF.adaptadores.repositorios.RepositorioReclamacoes;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositorioReclamacoesTest {

    @Autowired
    private RepositorioReclamacoes repositorioReclamacoes;
    
    @Test
    public void insertReclamacao() {
        
    }

}
