package com.grupofds.projetoTF.negocio.servicos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupofds.projetoTF.negocio.entidades.Endereco;
import com.grupofds.projetoTF.negocio.entidades.Reclamacao;
import com.grupofds.projetoTF.negocio.entidades.StatusReclamacoes;
import com.grupofds.projetoTF.negocio.entidades.usuarios.CategoriaDeUsuario;
import com.grupofds.projetoTF.negocio.entidades.usuarios.Usuario;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioComentarios;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioEnderecos;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioReclamacoes;
import com.grupofds.projetoTF.negocio.repositorios.IRepositorioUsuarios;

@Service
public class ReclamacaoServico {

	private IRepositorioReclamacoes repositorioReclamacoes;
    private IRepositorioUsuarios repositorioUsuarios;
    private IRepositorioComentarios repositorioComentarios;
    private IRepositorioEnderecos repositorioEnderecos;
    
    @Autowired
    public ReclamacaoServico(IRepositorioReclamacoes repositorioReclamacoes, IRepositorioUsuarios repositorioUsuarios,
			IRepositorioComentarios repositorioCOmentarios, IRepositorioEnderecos repositorioEnderecos) {
		this.repositorioReclamacoes = repositorioReclamacoes;
		this.repositorioUsuarios = repositorioUsuarios;
		this.repositorioComentarios = repositorioCOmentarios;
		this.repositorioEnderecos = repositorioEnderecos;
	}

	public Reclamacao createReclamacao(Long usuario_id,String titulo, String descricao, Endereco endereco, String imagem, String categoria) { //Refatorar para atributos
    	if (usuario_id == null) {
			throw new IllegalArgumentException("ERRO! Usuário Id não pode ser null.");
		}

		Usuario usuario = repositorioUsuarios.getById(usuario_id);
		if((usuario.getId() == null)) {
			throw new IllegalArgumentException("ERRO! Usuário não encontrado. Indique um Id válido.");
		}
		if (usuario.getCategoriaDeUsuario() != CategoriaDeUsuario.CIDADAO) {
			throw new IllegalArgumentException("ERRO! Usuário não possui permissão para criar nova Reclamação.");
		}

		Reclamacao reclamacao = new Reclamacao(null, usuario, titulo, descricao, LocalDateTime.now(), 
				endereco , imagem, categoria, StatusReclamacoes.ABERTA, null);
		return repositorioReclamacoes.createReclamacao(reclamacao);
    }

	public Reclamacao updateReclamacao(Long usuarioId, Long reclamacaoId, 
			String titulo, String descricao, Endereco endereco, String imagem, String categoria) { //
		Usuario user = repositorioUsuarios.getById(usuarioId);
    	if (user == null) {
			throw new IllegalArgumentException("ERRO! Usuário não encontrado. Indique um Id válido.");
		}

		Reclamacao reclamacao = repositorioReclamacoes.getById(reclamacaoId);
		
		if (reclamacao == null) {
			throw new IllegalArgumentException("ERRO! Reclamação não encontrada. Indique um Id válido.");
		}
		if (!user.equals(reclamacao.getUsuario())) {
			throw new IllegalArgumentException("Usuário de Id " + user.getId() +" não possui permissão para atualizar esta Reclamação.");
		}

		//Valida novos dados da Reclamacao.
		String novoTitulo = titulo;
		if (novoTitulo != null && !novoTitulo.isBlank() && !novoTitulo.isEmpty()) {
			reclamacao.setTitulo(novoTitulo);
		}

		String novaDescricao = descricao;
		if (novaDescricao != null && !novaDescricao.isBlank() && !novaDescricao.isEmpty()) {
			reclamacao.setDescricao(novaDescricao);
		}

		Endereco novoEndereco = endereco;
		if (novoEndereco != null) {
			//TODO: verificar persistencia no banco de dados.
			reclamacao.setEndereco(repositorioEnderecos.updateEndereco(novoEndereco));
		}

		String novaImagem = imagem;
		reclamacao.setImagem(novaImagem);
		
		String novaCategoria = categoria;
		if (novaCategoria != null && !novaCategoria.isBlank() && !novaCategoria.isEmpty()) {
			reclamacao.setCategoria(novaCategoria);
		}
		
		return repositorioReclamacoes.updateReclamacao(reclamacao);
    }

    public Reclamacao getReclamacaoById(Long reclamacaoId) {
    	Reclamacao reclamacao = repositorioReclamacoes.getById(reclamacaoId);
    	
    	reclamacao.setComentarios(repositorioComentarios.getByReclamacao(reclamacao.getId()));
        return reclamacao; 
    }

    public List<Reclamacao> getReclamacoesByCategoria(String categoria) {
    	List<Reclamacao> reclamacoes = repositorioReclamacoes.getByCategoria(categoria);
    	
    	reclamacoes.forEach(reclamacao -> {
			reclamacao.setComentarios(repositorioComentarios.getByReclamacao(reclamacao.getId()));
		});
    	
        return reclamacoes;
    }
    
    public List<Reclamacao> getReclamacoesByUsuario(Long idUsuario) {
    	
    	List<Reclamacao> reclamacoes = repositorioReclamacoes.getByUsuario(idUsuario);
    	
    	reclamacoes.forEach(reclamacao -> {
			reclamacao.setComentarios(repositorioComentarios.getByReclamacao(reclamacao.getId()));
		});
    	
        return reclamacoes;
    }

    public List<Reclamacao> getReclamacoesByPeriodo(LocalDateTime periodoInicial, LocalDateTime periodoFinal) {
    	List<Reclamacao> reclamacoes = repositorioReclamacoes.getByPeriodo(periodoInicial, periodoFinal);
    	
    	reclamacoes.forEach(reclamacao -> {
			reclamacao.setComentarios(repositorioComentarios.getByReclamacao(reclamacao.getId()));
		});
    	
        return reclamacoes;
    }

    public List<Reclamacao> getReclamacoesByBairro(String bairro) {
    	
    	List<Reclamacao> reclamacoes = repositorioReclamacoes.getByBairro(bairro);
    	
    	reclamacoes.forEach(reclamacao -> {
			reclamacao.setComentarios(repositorioComentarios.getByReclamacao(reclamacao.getId()));
		});
    	
        return reclamacoes;
    }

	public List<Reclamacao> getReclamacoes() {
		List<Reclamacao> reclamacoes = repositorioReclamacoes.getReclamacoes();
    	
		reclamacoes.forEach(reclamacao -> {
			reclamacao.setComentarios(repositorioComentarios.getByReclamacao(reclamacao.getId()));
		});
    	
        return reclamacoes;
	}
}
