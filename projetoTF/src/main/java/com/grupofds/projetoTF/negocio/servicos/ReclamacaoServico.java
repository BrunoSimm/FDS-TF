package com.grupofds.projetoTF.negocio.servicos;

import java.time.LocalDateTime;
import java.util.List;

import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;

public class ReclamacaoServico {

    private IRepositorioReclamacoes repositorioReclamacoes;
    
    public Reclamacao updateReclamacao(long usuarioId, long reclamacaoId, Reclamacao novosDadosReclamacao) {
        // TODO: Validar solicitação do usuário 
        repositorioReclamacoes.atualizaReclamacao(novosDadosReclamacao);
        return null;
    }

    public Reclamacao createReclamacao(Reclamacao reclamacao) {
        return null;
    }

    public Reclamacao encerraReclamacao(long usuarioOficialId, long reclmacaoId) {
        // TODO: Validar solicitação do usuário
        
        Reclamacao reclamacao = repositorioReclamacoes.getById(reclmacaoId);
        reclamacao.setStatus(StatusReclamacoes.ENCERRADA);
        repositorioReclamacoes.atualizaReclamacao(reclamacao);
        return null;
    }

    public Reclamacao getReclamacaoById(long reclamacaoId) {
        repositorioReclamacoes.getById(reclamacaoId);
        return null;
    }

    public List<Reclamacao> getReclamacoesByCategoria(String categoria) {
        return null;
    }
    
    public List<Reclamacao> getReclamacoesByUsuario(long idUsuario) {
        return null;
    }

    public List<Reclamacao> getRelclamacoesByPeriodo(LocalDateTime periodo) {
        return null;
    }

    public List<Reclamacao> getReclamacoesByBairro(String bairro) {
        return null;
    }
}
