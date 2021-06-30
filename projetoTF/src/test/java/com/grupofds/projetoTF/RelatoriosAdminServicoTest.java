package com.grupofds.projetoTF;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.grupofds.projetoTF.aplicacao.servicos.RelatoriosAdminServico;
import com.grupofds.projetoTF.negocio.entidades.Comentario;
import com.grupofds.projetoTF.negocio.entidades.Endereco;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.entidades.usuarios.CategoriaDeUsuario;
import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioComentarios;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioEnderecos;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioUsuarios;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
public class RelatoriosAdminServicoTest {
    
    private RelatoriosAdminServico relatoriosAdminServico;
    
    public RelatoriosAdminServicoTest() {
        IRepositorioUsuarios repositorioUsuarios = mock(IRepositorioUsuarios.class);
        when(repositorioUsuarios.getById(1L)).thenReturn(new Usuario(1L, "Tester", "tester@testando.com", CategoriaDeUsuario.ADMINISTRADOR));
        when(repositorioUsuarios.getById(2L)).thenReturn(new Usuario(2L, "Tester", "tester@testando.com", CategoriaDeUsuario.USUARIO_OFICIAL));
        when(repositorioUsuarios.getById(3L)).thenReturn(new Usuario(3L, "Tester", "tester@testando.com", CategoriaDeUsuario.CIDADAO));
        when(repositorioUsuarios.getById(4L)).thenReturn(new Usuario(4L, "Tester", "tester@testando.com", CategoriaDeUsuario.CIDADAO));
        when(repositorioUsuarios.getById(5L)).thenReturn(new Usuario(5L, "Tester", "tester@testando.com", CategoriaDeUsuario.CIDADAO));

        IRepositorioComentarios repositorioComentarios = mock(IRepositorioComentarios.class);
        Usuario user;
        
        user = repositorioUsuarios.getById(2L);
        when(repositorioComentarios.getById(9L)).thenReturn(new Comentario(9L, user, "1", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 3L));
        when(repositorioComentarios.getById(6L)).thenReturn(new Comentario(6L, user, "2", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 2L));
        
        user = repositorioUsuarios.getById(4L);
        when(repositorioComentarios.getById(1L)).thenReturn(new Comentario(1L, user, "1", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 1L));
        when(repositorioComentarios.getById(7L)).thenReturn(new Comentario(7L, user, "3", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 2L));
        when(repositorioComentarios.getById(10L)).thenReturn(new Comentario(10L, user, "2", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 3L));
        
        user = repositorioUsuarios.getById(3L);
        when(repositorioComentarios.getById(2L)).thenReturn(new Comentario(2L, user, "2", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 1L));
        when(repositorioComentarios.getById(8L)).thenReturn(new Comentario(8L, user, "4", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 2L));
        when(repositorioComentarios.getById(11L)).thenReturn(new Comentario(11L, user, "3", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 3L));

        user = repositorioUsuarios.getById(5L);
        when(repositorioComentarios.getById(3L)).thenReturn(new Comentario(3L, user, "3", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 1L));
        when(repositorioComentarios.getById(4L)).thenReturn(new Comentario(4L, user, "4", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 2L));
        when(repositorioComentarios.getById(5L)).thenReturn(new Comentario(4L, user, "4", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 1L));
        when(repositorioComentarios.getById(12L)).thenReturn(new Comentario(12L, user, "4", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 3L));

        IRepositorioReclamacoes repositorioReclamacoes = mock(IRepositorioReclamacoes.class);

        List<Comentario> comentarios1 = new ArrayList<>();
        comentarios1.add(repositorioComentarios.getById(1L));
        comentarios1.add(repositorioComentarios.getById(2L));
        comentarios1.add(repositorioComentarios.getById(3L));
        comentarios1.add(repositorioComentarios.getById(4L));


        List<Comentario> comentarios2 = new ArrayList<>();
        comentarios2.add(repositorioComentarios.getById(5L));
        comentarios2.add(repositorioComentarios.getById(6L));
        comentarios2.add(repositorioComentarios.getById(7L));
        comentarios2.add(repositorioComentarios.getById(8L));

        List<Comentario> comentarios3 = new ArrayList<>();
        comentarios3.add(repositorioComentarios.getById(9L));
        comentarios3.add(repositorioComentarios.getById(10L));
        comentarios3.add(repositorioComentarios.getById(11L));
        comentarios3.add(repositorioComentarios.getById(12L));

        List<Reclamacao> reclamacoes = new ArrayList<>();
        reclamacoes.add(new Reclamacao(1L, repositorioUsuarios.getById(3L), "Poste caído", "Maldito poste caiu após acidente da motoca e ninguém vem consertar.", LocalDateTime.parse("2020-03-01T00:00:00"),
            new Endereco(1L, "Centro", "Rua Julio de Castilhos", 458, "Encantado", "RS", 1L),
            "/image.jpeg", "Saneamento", StatusReclamacoes.ABERTA, comentarios1));
        
        reclamacoes.add(new Reclamacao(2L, repositorioUsuarios.getById(4L), "Teste", "Teste", LocalDateTime.parse("2021-02-15T00:00:00"),
            new Endereco(2L, "Teste", "Teste", 404, "Teste", "Teste", 2L),
            "/image.jpeg", "Risco COVID-19", StatusReclamacoes.ENCERRADA, comentarios2));

        reclamacoes.add(new Reclamacao(3L, repositorioUsuarios.getById(5L), "Boca de lobo perigosa", "Crianças da vizinhança alegam terem visto um palhaço dentro da calçada. Testemunhas notaram estranhos balões nos arredores.	", LocalDateTime.parse("2021-02-15T00:00:00"),
            new Endereco(3L, "Porto XV", "Estrada Porto XV", 404, "Encantado", "RS", 3L),
            "/image.jpeg", "Praças Públicas", StatusReclamacoes.RESOLVIDA, comentarios3));

        when(repositorioReclamacoes.getReclamacoes()).thenReturn(reclamacoes);
        when(repositorioReclamacoes.getByCategoria("Saneamento")).thenReturn(reclamacoes.stream().filter(r -> r.getCategoria().equals("Saneamento")).collect(Collectors.toList()));

        relatoriosAdminServico = new RelatoriosAdminServico(repositorioReclamacoes, repositorioComentarios, repositorioUsuarios);
    }

    @Test
    public void testaPrivilegioUsuario() {
        assertThrows(IllegalArgumentException.class, () -> relatoriosAdminServico.getPercentualEncerradas((long) 2));
    }

    @Test
    public void testaCalculoMediaComentariosByBairro() {
        assertEquals(4, relatoriosAdminServico.getNumeroMedioComentariosByBairro((long) 1, "Centro"));
    }

    @Test
    public void testaCalculoMediaComentariosByCategoria() {
        assertEquals(1 + 1.0/3, relatoriosAdminServico.getNumeroMedioComentariosByCategoria((long) 1, "Saneamento"));
    }

    @Test
    public void testaCalculoMediaComentariosByPeriodo() {
        assertEquals(3.5, relatoriosAdminServico.getNumeroMedioComentariosByPeriodo((long) 1, 
            LocalDateTime.parse("2021-03-10T00:00:00"), LocalDateTime.parse("2021-03-16T00:00:00")));
    }

    @Test
    public void testaCalculoPercentualEncerradoByBairro() {
        assertEquals(20.0, relatoriosAdminServico.getPercentualEncerradoByBairro((long) 1, "Planalto"));
    }

    @Test
    public void testaCalculoPercentualEncerradoByCategoria() {
        assertEquals(100.0/3, relatoriosAdminServico.getPercentualEncerradoByCategoria((long) 1, "Saneamento"));
    }

    @Test
    public void testaCalculoPercentualEncerradas() {
        assertEquals(100.0/14, relatoriosAdminServico.getPercentualEncerradas((long) 1));
    }

    @Test
    public void testaCalculoPercentualResolvidoByBairro() {
        assertEquals(100.0, relatoriosAdminServico.getPercentualResolvidoByBairro((long) 1, "Lambari"));
    }

    @Test
    public void testaCalculoPercentualRespondidoByUserOficial() {
        assertEquals(400.0/14, relatoriosAdminServico.getPercentualRespondidoByUserOficial((long) 1, (long) 2).getPercentualRespondido());
    }

    @Test
    public void testaCalculoPercentualRespondidoByUsersOficial() {
        assertEquals(400.0/14, relatoriosAdminServico.getPercentualRespondidoByUsersOficiais((long) 1));
    }

    @Test
    public void testaCalculoTotalReclamacoesByBairroAndPeriodo() {
        assertEquals(2, relatoriosAdminServico.getTotalReclamacoesByBairroAndPeriodo((long) 1, "Porto XV", 
            LocalDateTime.parse("2007-12-03T00:00:00"), LocalDateTime.parse("2021-12-03T10:15:30")));
    }

    @Test
    public void testaCalculoTotalReclamacoesByCategoriaAndPeriodo() {
        assertEquals(3, relatoriosAdminServico.getTotalReclamacoesByCategoriaAndPeriodo((long) 1, "Saneamento", 
            LocalDateTime.parse("2007-12-03T00:00:00"), LocalDateTime.parse("2021-12-03T10:15:30")));
    }
    
}
