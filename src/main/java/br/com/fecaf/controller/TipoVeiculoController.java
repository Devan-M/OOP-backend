package br.com.fecaf.controller;

import br.com.fecaf.model.TipoVeiculo;
import br.com.fecaf.services.TipoVeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoVeiculoController {

    private final TipoVeiculoService tipoVeiculoService;

    public TipoVeiculoController(TipoVeiculoService tipoVeiculoService) {
        this.tipoVeiculoService = tipoVeiculoService;
    }

    @GetMapping
    public List<TipoVeiculo> listarTodos() {
        return tipoVeiculoService.listarTodos();
    }
}
