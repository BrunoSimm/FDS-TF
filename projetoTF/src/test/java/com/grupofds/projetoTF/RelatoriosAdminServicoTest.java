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
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioUsuarios;

import org.junit.jupiter.api.Test;

public class RelatoriosAdminServicoTest {
    
    private RelatoriosAdminServico relatoriosAdminServico;
    
    public RelatoriosAdminServicoTest() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(0, new Usuario(1L, "UsuarioAdmin1", "admin1@teste.com", CategoriaDeUsuario.ADMINISTRADOR));
        usuarios.add(1, new Usuario(2L, "UsuarioOficial1", "oficial1@teste.com", CategoriaDeUsuario.USUARIO_OFICIAL));
        usuarios.add(2, new Usuario(3L, "UsuarioCidadao1", "cidadao1@teste.com", CategoriaDeUsuario.CIDADAO));
        usuarios.add(3, new Usuario(3L, "UsuarioCidadao1", "cidadao2@teste.com", CategoriaDeUsuario.CIDADAO));
        usuarios.add(4, new Usuario(3L, "UsuarioCidadao1", "cidadao3@teste.com", CategoriaDeUsuario.CIDADAO));

        IRepositorioUsuarios repositorioUsuarios = mock(IRepositorioUsuarios.class);
        when(repositorioUsuarios.getById(1L)).thenReturn(usuarios.get(0));
        when(repositorioUsuarios.getById(2L)).thenReturn(usuarios.get(1));
        when(repositorioUsuarios.getById(3L)).thenReturn(usuarios.get(2));
        when(repositorioUsuarios.getById(4L)).thenReturn(usuarios.get(3));
        when(repositorioUsuarios.getById(5L)).thenReturn(usuarios.get(4));
        
        List<Comentario> comentariosR1 = new ArrayList<>();
        comentariosR1.add(0, new Comentario(1L, repositorioUsuarios.getById(4L), "Comentario1", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 1L));
        comentariosR1.add(1, new Comentario(2L, repositorioUsuarios.getById(3L), "Comentario2", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 1L));
        comentariosR1.add(2, new Comentario(3L, repositorioUsuarios.getById(5L), "Comentario3", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 1L));
        comentariosR1.add(3, new Comentario(4L, repositorioUsuarios.getById(5L), "Comentario4", LocalDateTime.parse("2021-04-16T12:00:00"), "/image.jpeg", 1L));
        
        List<Comentario> comentariosR2 = new ArrayList<>();
        comentariosR2.add(0, new Comentario(5L, repositorioUsuarios.getById(5L), "Comentario5", LocalDateTime.parse("2021-03-16T12:00:00"), "/image.jpeg", 2L));
        comentariosR2.add(1, new Comentario(6L, repositorioUsuarios.getById(2L), "Comentario6", LocalDateTime.parse("2021-03-16T12:00:00"), "/image.jpeg", 2L));
        comentariosR2.add(2, new Comentario(7L, repositorioUsuarios.getById(4L), "Comentario7", LocalDateTime.parse("2021-03-16T12:00:00"), "/image.jpeg", 2L));
        comentariosR2.add(3, new Comentario(8L, repositorioUsuarios.getById(3L), "Comentario8", LocalDateTime.parse("2021-03-16T12:00:00"), "/image.jpeg", 2L));
        
        List<Comentario> comentariosR3 = new ArrayList<>();
        comentariosR3.add(0, new Comentario(9L, repositorioUsuarios.getById(2L), "Comentario9", LocalDateTime.parse("2021-02-16T12:00:00"), "/image.jpeg", 3L));
        comentariosR3.add(1, new Comentario(10L, repositorioUsuarios.getById(4L), "Comentario10", LocalDateTime.parse("2021-04-16T12:00:00"), "/image.jpeg", 3L));
        comentariosR3.add(2, new Comentario(11L, repositorioUsuarios.getById(3L), "Comentario11", LocalDateTime.parse("2021-04-16T12:00:00"), "/image.jpeg", 3L));
        comentariosR3.add(3, new Comentario(12L, repositorioUsuarios.getById(5L), "Comentario12", LocalDateTime.parse("2021-05-16T12:00:00"), "/image.jpeg", 3L));

        List<Comentario> comentarios = new ArrayList<>();
        comentarios.addAll(comentariosR1);
        comentarios.addAll(comentariosR2);
        comentarios.addAll(comentariosR3);
        
        IRepositorioComentarios repositorioComentarios = mock(IRepositorioComentarios.class);
        when(repositorioComentarios.getById(1L)).thenReturn(comentarios.get(0));
        when(repositorioComentarios.getById(2L)).thenReturn(comentarios.get(1));
        when(repositorioComentarios.getById(3L)).thenReturn(comentarios.get(2));
        when(repositorioComentarios.getById(4L)).thenReturn(comentarios.get(3));
        when(repositorioComentarios.getById(5L)).thenReturn(comentarios.get(4));
        when(repositorioComentarios.getById(6L)).thenReturn(comentarios.get(5));
        when(repositorioComentarios.getById(7L)).thenReturn(comentarios.get(6));
        when(repositorioComentarios.getById(8L)).thenReturn(comentarios.get(7));
        when(repositorioComentarios.getById(9L)).thenReturn(comentarios.get(8));
        when(repositorioComentarios.getById(10L)).thenReturn(comentarios.get(9));
        when(repositorioComentarios.getById(11L)).thenReturn(comentarios.get(10));
        when(repositorioComentarios.getById(12L)).thenReturn(comentarios.get(11));
        when(repositorioComentarios.getByReclamacao(1L)).thenReturn(comentarios.stream().filter(c -> c.getReclamacaoId().equals(1L)).collect(Collectors.toList()));
        when(repositorioComentarios.getByReclamacao(2L)).thenReturn(comentarios.stream().filter(c -> c.getReclamacaoId().equals(2L)).collect(Collectors.toList()));
        when(repositorioComentarios.getByReclamacao(3L)).thenReturn(comentarios.stream().filter(c -> c.getReclamacaoId().equals(3L)).collect(Collectors.toList()));
        when(repositorioComentarios.getByPeriodo(LocalDateTime.parse("2021-03-10T00:00:00"), LocalDateTime.parse("2021-04-10T00:00:00"))).thenReturn(comentarios.stream().filter(r -> !r.getData().isBefore(LocalDateTime.parse("2021-03-10T00:00:00")) && !r.getData().isAfter(LocalDateTime.parse("2021-04-10T00:00:00"))).collect(Collectors.toList()));
        
        List<Reclamacao> reclamacoes = new ArrayList<>();
        reclamacoes.add(0, new Reclamacao(1L, repositorioUsuarios.getById(3L), "Poste caído", "Maldito poste caiu após acidente da motoca e ninguém vem consertar.", LocalDateTime.parse("2020-08-01T00:00:00"),
            new Endereco(1L, "Centro", "Rua Julio de Castilhos", 458, "Encantado", "RS", 1L),
            "/image.jpeg", "Saneamento", StatusReclamacoes.ABERTA, comentariosR1));
        
        reclamacoes.add(1, new Reclamacao(2L, repositorioUsuarios.getById(4L), "Titulo Teste", "Descrição Teste", LocalDateTime.parse("2021-01-10T00:00:00"),
            new Endereco(2L, "Bairro Teste", "Rua Teste", 404, "Cidade Teste", "Estado Teste", 2L),
            "/image.jpeg", "Risco COVID-19", StatusReclamacoes.ENCERRADA, comentariosR2));

        reclamacoes.add(2, new Reclamacao(3L, repositorioUsuarios.getById(5L), "Boca de lobo perigosa", "Crianças da vizinhança alegam terem visto um palhaço dentro da calçada. Testemunhas notaram estranhos balões nos arredores.", LocalDateTime.parse("2021-03-11T00:00:00"),
            new Endereco(3L, "Porto XV", "Estrada Porto XV", 404, "Encantado", "RS", 3L),
            "/image.jpeg", "Praças Públicas", StatusReclamacoes.RESOLVIDA, comentariosR3));

        IRepositorioReclamacoes repositorioReclamacoes = mock(IRepositorioReclamacoes.class);
        when(repositorioReclamacoes.getReclamacoes()).thenReturn(reclamacoes);
        when(repositorioReclamacoes.getByCategoria("Saneamento")).thenReturn(reclamacoes.stream().filter(r -> r.getCategoria().equals("Saneamento")).collect(Collectors.toList()));
        when(repositorioReclamacoes.getByCategoria("Risco COVID-19")).thenReturn(reclamacoes.stream().filter(r -> r.getCategoria().equals("Risco COVID-19")).collect(Collectors.toList()));
        when(repositorioReclamacoes.getByCategoria("Praças Públicas")).thenReturn(reclamacoes.stream().filter(r -> r.getCategoria().equals("Praças Públicas")).collect(Collectors.toList()));
        when(repositorioReclamacoes.getByBairro("Centro")).thenReturn(reclamacoes.stream().filter(r -> r.getEndereco().getBairro().equals("Centro")).collect(Collectors.toList()));
        when(repositorioReclamacoes.getByBairro("Bairro Teste")).thenReturn(reclamacoes.stream().filter(r -> r.getEndereco().getBairro().equals("Bairro Teste")).collect(Collectors.toList()));
        when(repositorioReclamacoes.getByBairro("Porto XV")).thenReturn(reclamacoes.stream().filter(r -> r.getEndereco().getBairro().equals("Porto XV")).collect(Collectors.toList()));
        when(repositorioReclamacoes.getByPeriodo(LocalDateTime.parse("2021-03-10T00:00:00"), LocalDateTime.parse("2021-04-10T00:00:00"))).thenReturn(reclamacoes.stream().filter(r -> !r.getData().isBefore(LocalDateTime.parse("2021-03-10T00:00:00")) && !r.getData().isAfter(LocalDateTime.parse("2021-04-10T00:00:00"))).collect(Collectors.toList()));

        relatoriosAdminServico = new RelatoriosAdminServico(repositorioReclamacoes, repositorioComentarios, repositorioUsuarios);
    }

    @Test
    public void testaUsuarioSemPrivilegio() {
        assertThrows(IllegalArgumentException.class, () -> relatoriosAdminServico.getPercentualEncerradas((long) 2));
    }

    @Test
    public void testaCalculoMediaComentariosByBairro() {
        assertEquals(4.0, relatoriosAdminServico.getNumeroMedioComentariosByBairro((long) 1, "Centro"));
    }

    @Test
    public void testaCalculoMediaComentariosByCategoria() {
        assertEquals(4.0, relatoriosAdminServico.getNumeroMedioComentariosByCategoria((long) 1, "Saneamento"));
    }

    @Test
    public void testaCalculoMediaComentariosByPeriodo() {
        assertEquals(4.0, relatoriosAdminServico.getNumeroMedioComentariosByPeriodo((long) 1, 
            LocalDateTime.parse("2021-03-10T00:00:00"), LocalDateTime.parse("2021-04-10T00:00:00")));
    }

    @Test
    public void testaCalculoPercentualEncerradoByBairro() {
        assertEquals(100.0 * 1/1, relatoriosAdminServico.getPercentualEncerradoByBairro((long) 1, "Bairro Teste"));
    }

    @Test
    public void testaCalculoPercentualEncerradoByCategoria() {
        assertEquals(100.0 * 0/1, relatoriosAdminServico.getPercentualEncerradoByCategoria((long) 1, "Saneamento"));
    }

    @Test
    public void testaCalculoPercentualEncerradas() {
        assertEquals(100.0 * 1/3, relatoriosAdminServico.getPercentualEncerradas((long) 1));
    }

    @Test
    public void testaCalculoPercentualResolvidoByBairro() {
        assertEquals(100.0 * 1/1, relatoriosAdminServico.getPercentualResolvidoByBairro((long) 1, "Porto XV"));
    }

    @Test
    public void testaCalculoPercentualRespondidoByUserOficial() {
        assertEquals(100.0 * 2/3, relatoriosAdminServico.getPercentualRespondidoByUserOficial((long) 1, (long) 2).getPercentualRespondido());
    }

    @Test
    public void testaCalculoPercentualRespondidoByUsersOficial() {
        assertEquals(100.0 * 2/3, relatoriosAdminServico.getPercentualRespondidoByUsersOficiais((long) 1));
    }

    @Test
    public void testaCalculoTotalReclamacoesByBairroAndPeriodo() {
        assertEquals(1, relatoriosAdminServico.getTotalReclamacoesByBairroAndPeriodo((long) 1, "Porto XV", 
            LocalDateTime.parse("2021-03-10T00:00:00"), LocalDateTime.parse("2021-04-10T00:00:00")));
    }

    @Test
    public void testaCalculoTotalReclamacoesByCategoriaAndPeriodo() {
        assertEquals(0, relatoriosAdminServico.getTotalReclamacoesByCategoriaAndPeriodo((long) 1, "Saneamento", 
            LocalDateTime.parse("2021-03-10T00:00:00"), LocalDateTime.parse("2021-04-10T00:00:00")));
    }
    
}
