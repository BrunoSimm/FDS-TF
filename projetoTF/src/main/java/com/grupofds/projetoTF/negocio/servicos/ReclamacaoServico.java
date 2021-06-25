package com.grupofds.projetoTF.negocio.servicos;

import java.time.LocalDateTime;
import java.util.List;

import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;

public class ReclamacaoServico {

    private IRepositorioReclamacoes repositorioReclamacoes;
    
    public Reclamacao updateReclamacao(Long usuarioId, Long reclamacaoId, Reclamacao novosDadosReclamacao) {
        // TODO: Validar solicitação do usuário 
        repositorioReclamacoes.updateReclamacao(novosDadosReclamacao);
        return null;
    }

    public Reclamacao createReclamacao(Reclamacao reclamacao) {
        return repositorioReclamacoes.createReclamacao(reclamacao);
    }

    public Reclamacao encerraReclamacao(Long usuarioOficialId, Long reclamacaoId) {
        // TODO: Validar solicitação do usuário
        
        Reclamacao reclamacao = repositorioReclamacoes.getById(reclamacaoId);
        reclamacao.setStatus(StatusReclamacoes.ENCERRADA);
        return repositorioReclamacoes.updateReclamacao(reclamacao);
    }

    public Reclamacao getReclamacaoById(Long reclamacaoId) {
        return repositorioReclamacoes.getById(reclamacaoId);
    }

    public List<Reclamacao> getReclamacoesByCategoria(String categoria) {
        return repositorioReclamacoes.getByCategoria(categoria);
    }
    
    public List<Reclamacao> getReclamacoesByUsuario(Long idUsuario) {
        return repositorioReclamacoes.getByUsuario(idUsuario);
    }

    public List<Reclamacao> getRelclamacoesByPeriodo(LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
        return repositorioReclamacoes.getByPeriodo(periodoInicial, periodoFinal);
    }

    public List<Reclamacao> getReclamacoesByBairro(String bairro) {
        return repositorioReclamacoes.getByBairro(bairro);
    }
}
