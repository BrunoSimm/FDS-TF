package com.grupofds.projetoTF;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import com.grupofds.projetoTF.adaptadores.repositorios.RepositorioReclamacoes;
import com.grupofds.projetoTF.negocio.entidades.Endereco;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.entidades.usuarios.CategoriaDeUsuario;
import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.TransactionSystemException;

@ExtendWith(SpringExtension.class)
@DataJpaTest
//@SpringBootTest
public class RepositorioReclamacoesTest {

    @Autowired
    private RepositorioReclamacoes repositorioReclamacoes;
    
    @Test
    public void insertReclamacaoCompleta() {
        Integer qtdReclamacoesInicial = repositorioReclamacoes.findAll().size();
        Reclamacao reclamacao = new Reclamacao(null, 
            new Usuario(null, "Tester", "tester@testando.com", 
            CategoriaDeUsuario.CIDADAO),
            "Testando Reclamações", "Testando Reclamações",
            LocalDateTime.now(), 
            new Endereco(null, "Teste","Teste", 404, "Teste",
            "Teste", null),
            "/teste.jpeg", "Teste", StatusReclamacoes.ABERTA, null);
        repositorioReclamacoes.createReclamacao(reclamacao);
        Integer qtdReclamacoesFinal = repositorioReclamacoes.findAll().size();
        qtdReclamacoesInicial += 1;
        assertEquals(qtdReclamacoesInicial, qtdReclamacoesFinal);
    }

    @Test
    public void insertReclamacaoIncompleta() {
        Reclamacao reclamacao = new Reclamacao();
        assertThrows(ConstraintViolationException.class, () -> repositorioReclamacoes.createReclamacao(reclamacao));
    }

    @Test
    public void editReclamacaoCompleta() {
        Reclamacao reclamacao = repositorioReclamacoes.getById(1L);
        reclamacao.setCategoria("Teste");
        reclamacao.setTitulo("TituloTeste");
        reclamacao.setData(LocalDateTime.now());
        repositorioReclamacoes.updateReclamacao(reclamacao);

        assertEquals(reclamacao, repositorioReclamacoes.getById(1L));
    }
    
    @Test
    public void editReclamacaoIncompleta() {
        Reclamacao reclamacao = repositorioReclamacoes.getById(1L);
        reclamacao.setCategoria("");
        reclamacao.setTitulo("");
        reclamacao.setData(LocalDateTime.now());

        assertThrows(ConstraintViolationException.class, () -> repositorioReclamacoes.getById(1L));
    }

}
