package com.grupofds.projetoTF;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import com.grupofds.projetoTF.aplicacao.servicos.RelatoriosAdminServico;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RelatoriosAdminServicoTest {
    
    @Autowired
    private RelatoriosAdminServico relatoriosAdminServico;
    
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
