// Pacote onde a classe está localizada
package br.com.fecaf.services;

// Importa a entidade Veiculo
import br.com.fecaf.model.StatusVeiculo;
import br.com.fecaf.model.Veiculo;

// Importa o repositório que acessa o banco de dados
import br.com.fecaf.repository.VeiculoRepository;

// Importa exceção para casos em que o veículo não é encontrado
import jakarta.persistence.EntityNotFoundException;

// Indica que esta classe é um serviço gerenciado pelo Spring
import org.springframework.stereotype.Service;

// Importa tipos utilizados nos métodos
import java.math.BigDecimal;
import java.util.List;

// Define que esta classe é um serviço do Spring
@Service
public class VeiculoService {

    // Repositório usado para acessar os dados dos veículos
    private final VeiculoRepository veiculoRepository;

    // Construtor com injeção de dependência do repositório
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    // 🔍 Lista todos os veículos cadastrados
    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    // 💾 Salva um novo veículo no banco de dados
    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    // 🔍 Busca veículos por marca (ignora maiúsculas/minúsculas)
    public List<Veiculo> buscarPorMarca(String marca) {
        return veiculoRepository.findByMarcaContainingIgnoreCase(marca);
    }

    // 🔍 Busca veículos por nome do tipo (relacionamento com TipoVeiculo)
    public List<Veiculo> buscarPorTipo(String tipoNome) {
        return veiculoRepository.findByTipo_Nome(tipoNome);
    }

    // 🔍 Busca veículos dentro de uma faixa de preço
    public List<Veiculo> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max) {
        return veiculoRepository.findByPrecoBetween(min, max);
    }

    // ❌ Deleta um veículo pelo ID, se existir
    public void deletar(Long id) {
        if (!veiculoRepository.existsById(id)) {
            throw new EntityNotFoundException("Veículo não encontrado com ID: " + id);
        }
        veiculoRepository.deleteById(id);
    }

    // 🔍 Busca um veículo pelo ID, lança exceção se não encontrar
    public Veiculo buscarPorId(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado"));
    }

    // 🔄 Atualiza os dados de um veículo existente
    public Veiculo atualizar(Long id, Veiculo novo) {
        Veiculo existente = veiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado"));

        // Atualiza os campos do veículo existente com os dados do novo
        existente.setMarca(novo.getMarca());
        existente.setModelo(novo.getModelo());
        existente.setCor(novo.getCor());
        existente.setQuilometragem(novo.getQuilometragem());
        existente.setAnoFabricacao(novo.getAnoFabricacao());
        existente.setPreco(novo.getPreco());
        existente.setImagemUrl(novo.getImagemUrl());
        existente.setTipo(novo.getTipo());
        existente.setStatus(novo.getStatus());

        // Salva as alterações no banco
        return veiculoRepository.save(existente);
    }

    // 🔍 Busca veículos dentro de uma faixa de ano de fabricação
    public List<Veiculo> buscarPorFaixaAno(Integer anoMin, Integer anoMax) {
        return veiculoRepository.findByAnoFabricacaoBetween(anoMin, anoMax);
    }

    // 🔍 Busca veículos dentro de uma faixa de quilometragem
    public List<Veiculo> buscarPorFaixaKm(Integer kmMin, Integer kmMax) {
        return veiculoRepository.findByQuilometragemBetween(kmMin, kmMax);
    }

    // 🔍 Busca veículos com status específico (ex: DISPONIVEL, VENDIDO)
    public List<Veiculo> buscarPorStatus(StatusVeiculo status) {
        return veiculoRepository.findByStatus(status);
    }

    // 🔍 Busca veículos com modelo que contenha o nome informado (ignora maiúsculas/minúsculas)
    public List<Veiculo> buscarPorModelo(String nome) {
        return veiculoRepository.findByModeloContainingIgnoreCase(nome);
    }
}