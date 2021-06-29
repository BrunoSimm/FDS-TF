package com.grupofds.projetoTF.adaptadores.controllers;

import java.time.LocalDateTime;

import com.grupofds.projetoTF.aplicacao.casosDeUso.administrador.ConsultaNumeroMedioComentariosByBairroUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.administrador.ConsultaNumeroMedioComentariosByCategoriaUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.administrador.ConsultaNumeroMedioComentariosByPeriodoUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.administrador.ConsultaPercentualEncerradoByBairroUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.administrador.ConsultaPercentualEncerradoByCategoriaUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.administrador.ConsultaPercentualEncerradoUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.administrador.ConsultaPercentualResolvidoByBairroUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.administrador.ConsultaPercentualResolvidoByCategoriaUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.administrador.ConsultaPercentualRespondidoByUserOficialUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.administrador.ConsultaPercentualRespondidoByUsersOficialUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.administrador.ConsultaTotalReclamacoesByBairroUC;
import com.grupofds.projetoTF.aplicacao.casosDeUso.administrador.ConsultaTotalReclamacoesByCategoriaUC;
import com.grupofds.projetoTF.aplicacao.dtos.NumeroMedioComentariosByBairroDTO;
import com.grupofds.projetoTF.aplicacao.dtos.NumeroMedioComentariosByCategoriaDTO;
import com.grupofds.projetoTF.aplicacao.dtos.NumeroMedioComentariosByPeriodoDTO;
import com.grupofds.projetoTF.aplicacao.dtos.PercentualEncerradoByBairroDTO;
import com.grupofds.projetoTF.aplicacao.dtos.PercentualEncerradoByCategoriaDTO;
import com.grupofds.projetoTF.aplicacao.dtos.PercentualEncerradoDTO;
import com.grupofds.projetoTF.aplicacao.dtos.PercentualResolvidoByBairroDTO;
import com.grupofds.projetoTF.aplicacao.dtos.PercentualResolvidoByCategoriaDTO;
import com.grupofds.projetoTF.aplicacao.dtos.PercentualRespondidoByUserOficialDTO;
import com.grupofds.projetoTF.aplicacao.dtos.PercentualRespondidoByUsersOficialDTO;
import com.grupofds.projetoTF.aplicacao.dtos.TotalReclamacoesByBairroDTO;
import com.grupofds.projetoTF.aplicacao.dtos.TotalReclamacoesByCategoriaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    private ConsultaNumeroMedioComentariosByBairroUC consultaNumeroMedioComentariosByBairroUC;
    private ConsultaNumeroMedioComentariosByCategoriaUC consultaNumeroMedioComentariosByCategoriaUC;
    private ConsultaNumeroMedioComentariosByPeriodoUC consultaNumeroMedioComentariosByPeriodoUC;
    private ConsultaPercentualEncerradoByBairroUC consultaPercentualEncerradoByBairroUC;
    private ConsultaPercentualEncerradoByCategoriaUC consultaPercentualEncerradoByCategoriaUC;
    private ConsultaPercentualEncerradoUC consultaPercentualEncerradoUC;
    private ConsultaPercentualResolvidoByBairroUC consultaPercentualResolvidoByBairroUC;
    private ConsultaPercentualResolvidoByCategoriaUC consultaPercentualResolvidoByCategoriaUC;
    private ConsultaPercentualRespondidoByUserOficialUC consultaPercentualRespondidoByUserOficialUC;
    private ConsultaPercentualRespondidoByUsersOficialUC consultaPercentualRespondidoByUsersOficialUC;
    private ConsultaTotalReclamacoesByBairroUC consultaTotalReclamacoesByBairroUC;
    private ConsultaTotalReclamacoesByCategoriaUC consultaTotalReclamacoesByCategoriaUC;

    @Autowired
    public AdministradorController(ConsultaNumeroMedioComentariosByBairroUC consultaNumeroMedioComentariosByBairroUC,
            ConsultaNumeroMedioComentariosByCategoriaUC consultaNumeroMedioComentariosByCategoriaUC,
            ConsultaNumeroMedioComentariosByPeriodoUC consultaNumeroMedioComentariosByPeriodoUC,
            ConsultaPercentualEncerradoByBairroUC consultaPercentualEncerradoByBairroUC,
            ConsultaPercentualEncerradoByCategoriaUC consultaPercentualEncerradoByCategoriaUC,
            ConsultaPercentualEncerradoUC consultaPercentualEncerradoUC,
            ConsultaPercentualResolvidoByBairroUC consultaPercentualResolvidoByBairroUC,
            ConsultaPercentualResolvidoByCategoriaUC consultaPercentualResolvidoByCategoriaUC,
            ConsultaPercentualRespondidoByUserOficialUC consultaPercentualRespondidoByUserOficialUC,
            ConsultaPercentualRespondidoByUsersOficialUC consultaPercentualRespondidoByUsersOficialUC,
            ConsultaTotalReclamacoesByBairroUC consultaTotalReclamacoesByBairroUC,
            ConsultaTotalReclamacoesByCategoriaUC consultaTotalReclamacoesByCategoriaUC) {
        this.consultaNumeroMedioComentariosByBairroUC = consultaNumeroMedioComentariosByBairroUC;
        this.consultaNumeroMedioComentariosByCategoriaUC = consultaNumeroMedioComentariosByCategoriaUC;
        this.consultaNumeroMedioComentariosByPeriodoUC = consultaNumeroMedioComentariosByPeriodoUC;
        this.consultaPercentualEncerradoByBairroUC = consultaPercentualEncerradoByBairroUC;
        this.consultaPercentualEncerradoByCategoriaUC = consultaPercentualEncerradoByCategoriaUC;
        this.consultaPercentualEncerradoUC = consultaPercentualEncerradoUC;
        this.consultaPercentualResolvidoByBairroUC = consultaPercentualResolvidoByBairroUC;
        this.consultaPercentualResolvidoByCategoriaUC = consultaPercentualResolvidoByCategoriaUC;
        this.consultaPercentualRespondidoByUserOficialUC = consultaPercentualRespondidoByUserOficialUC;
        this.consultaPercentualRespondidoByUsersOficialUC = consultaPercentualRespondidoByUsersOficialUC;
        this.consultaTotalReclamacoesByBairroUC = consultaTotalReclamacoesByBairroUC;
        this.consultaTotalReclamacoesByCategoriaUC = consultaTotalReclamacoesByCategoriaUC;
    }

    @GetMapping(value = "/numeroMedioComentariosByBairro")
    public NumeroMedioComentariosByBairroDTO getConsultaNumeroMedioComentariosByBairroUC(@RequestParam Long usuarioId,
            @RequestParam String bairro) {
        Double mediaComentarios = consultaNumeroMedioComentariosByBairroUC.run(usuarioId, bairro);
        return new NumeroMedioComentariosByBairroDTO(bairro, mediaComentarios);
    }

    @GetMapping(value = "/numeroMedioComentariosByCategoria")
    public NumeroMedioComentariosByCategoriaDTO getConsultaNumeroMedioComentariosByCategoriaUC(
            @RequestParam Long usuarioId, @RequestParam String categoria) {
        Double mediaComentarios = consultaNumeroMedioComentariosByCategoriaUC.run(usuarioId, categoria);
        return new NumeroMedioComentariosByCategoriaDTO(categoria, mediaComentarios);
    }

    @GetMapping(value = "/numeroMedioComentariosByPeriodo")
    public NumeroMedioComentariosByPeriodoDTO getConsultaNumeroMedioComentariosByPeriodoUC(@RequestParam Long usuarioId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodoInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodoFinal) {
        Double mediaComentarios = consultaNumeroMedioComentariosByPeriodoUC.run(usuarioId, periodoInicial,
                periodoFinal);
        return new NumeroMedioComentariosByPeriodoDTO(periodoInicial, periodoFinal, mediaComentarios);
    }

    @GetMapping(value = "/percentualEncerradoByBairro")
    public PercentualEncerradoByBairroDTO getConsultaPercentualEncerradoByBairroUC(@RequestParam Long usuarioId,
            @RequestParam String bairro) {
        Double percentualEncerrado = consultaPercentualEncerradoByBairroUC.run(usuarioId, bairro);
        return new PercentualEncerradoByBairroDTO(bairro, percentualEncerrado);
    }

    @GetMapping(value = "/percentualEncerradoByCategoria")
    public PercentualEncerradoByCategoriaDTO getConsultaPercentualEncerradoByCategoriaUC(@RequestParam Long usuarioId,
            @RequestParam String categoria) {
        Double percentualEncerrado = consultaPercentualEncerradoByCategoriaUC.run(usuarioId, categoria);
        return new PercentualEncerradoByCategoriaDTO(categoria, percentualEncerrado);
    }

    @GetMapping(value = "/percentualEncerrado")
    public PercentualEncerradoDTO getConsultaPercentualEncerradoUC(@RequestParam Long usuarioId) {
        Double percentualEncerrado = consultaPercentualEncerradoUC.run(usuarioId);
        return new PercentualEncerradoDTO(percentualEncerrado);
    }

    @GetMapping(value = "/percentualResolvidoByBairro")
    public PercentualResolvidoByBairroDTO getConsultaPercentualResolvidoByBairroUC(@RequestParam Long usuarioId,
            @RequestParam String bairro) {
        Double percentualResolvido = consultaPercentualResolvidoByBairroUC.run(usuarioId, bairro);
        return new PercentualResolvidoByBairroDTO(bairro, percentualResolvido);
    }

    @GetMapping(value = "/percentualResolvidoByCategoria")
    public PercentualResolvidoByCategoriaDTO getConsultaPercentualResolvidoByCategoriaUC(@RequestParam Long usuarioId,
            @RequestParam String categoria) {
        Double percentualResolvido = consultaPercentualResolvidoByCategoriaUC.run(usuarioId, categoria);
        return new PercentualResolvidoByCategoriaDTO(categoria, percentualResolvido);
    }

    @GetMapping(value = "/percentualRespondidoByUserOficial")
    public PercentualRespondidoByUserOficialDTO getConsultaPercentualRespondidoByUserOficialUC(
            @RequestParam Long usuarioId, @RequestParam Long idUsuarioOficial) {
        return consultaPercentualRespondidoByUserOficialUC.run(usuarioId, idUsuarioOficial);
    }

    @GetMapping(value = "/percentualRespondidoByUsersOficial")
    public PercentualRespondidoByUsersOficialDTO getConsultaPercentualRespondidoByUsersOficialUC(
            @RequestParam Long usuarioId) {
        Double percentualRespondido = consultaPercentualRespondidoByUsersOficialUC.run(usuarioId);
        return new PercentualRespondidoByUsersOficialDTO(usuarioId, percentualRespondido);
    }

    @GetMapping(value = "/totalReclamacoesByBairro")
    public TotalReclamacoesByBairroDTO getConsultaTotalReclamacoesByBairroUC(@RequestParam Long usuarioId,
            @RequestParam String bairro,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodoInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodoFinal) {
        Long totalReclamacoes = consultaTotalReclamacoesByBairroUC.run(usuarioId, bairro, periodoInicial, periodoFinal);
        return new TotalReclamacoesByBairroDTO(bairro, totalReclamacoes);
    }

    @GetMapping(value = "/totalReclamacoesByCategoria")
    public TotalReclamacoesByCategoriaDTO getConsultaTotalReclamacoesByCategoriaUC(@RequestParam long usuarioId,
            @RequestParam String categoria,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodoInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime periodoFinal) {
        Long totalReclamacoes = consultaTotalReclamacoesByCategoriaUC.run(usuarioId, categoria, periodoInicial,
                periodoFinal);
        return new TotalReclamacoesByCategoriaDTO(categoria, totalReclamacoes);
    }

}
