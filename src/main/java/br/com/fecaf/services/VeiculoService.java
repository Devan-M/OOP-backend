package br.com.fecaf.services;

import br.com.fecaf.model.Veiculo;
import br.com.fecaf.repository.VeiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> buscarPorMarca(String marca) {
        return veiculoRepository.findByMarcaContainingIgnoreCase(marca);
    }

    public List<Veiculo> buscarPorTipo(String tipoNome) {
        return veiculoRepository.findByTipo_Nome(tipoNome);
    }

    public List<Veiculo> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max) {
        return veiculoRepository.findByPrecoBetween(min, max);
    }

    public List<Veiculo> buscarPorAno(Integer ano) {
        return veiculoRepository.findByAnoFabricacao(ano);
    }

    public void deletar(Long id) {
        if (!veiculoRepository.existsById(id)) {
            throw new EntityNotFoundException("Veículo não encontrado com ID: " + id);
        }
        veiculoRepository.deleteById(id);
    }

    public Veiculo buscarPorId(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado"));
    }

    public Veiculo atualizar(Long id, Veiculo novo) {
        Veiculo existente = veiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado"));

        existente.setMarca(novo.getMarca());
        existente.setModelo(novo.getModelo());
        existente.setCor(novo.getCor());
        existente.setQuilometragem(novo.getQuilometragem());
        existente.setAnoFabricacao(novo.getAnoFabricacao());
        existente.setPreco(novo.getPreco());
        existente.setImagemUrl(novo.getImagemUrl());
        existente.setTipo(novo.getTipo());

        return veiculoRepository.save(existente);
    }


}

