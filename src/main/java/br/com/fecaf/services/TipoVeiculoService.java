package br.com.fecaf.services;

import br.com.fecaf.model.TipoVeiculo;
import br.com.fecaf.repository.TipoVeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoVeiculoService {

    private final TipoVeiculoRepository repository;

    public TipoVeiculoService(TipoVeiculoRepository repository) {
        this.repository = repository;
    }

    public List<TipoVeiculo> listarTodos() {
        return repository.findAll();
    }
}
