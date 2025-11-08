// Define o pacote onde esta interface está localizada
package br.com.fecaf.repository;

// Importa a entidade Veiculo que será manipulada pelo repositório
import br.com.fecaf.model.StatusVeiculo;
import br.com.fecaf.model.Veiculo;

// Importa a interface base do Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

// Indica que esta interface é um componente de repositório gerenciado pelo Spring
import org.springframework.stereotype.Repository;

// Importa tipos utilizados nos métodos de busca
import java.math.BigDecimal;
import java.util.List;

// Anotação que marca esta interface como um repositório Spring
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    // 🔍 Busca veículos cuja marca contenha o texto informado (ignorando maiúsculas/minúsculas)
    List<Veiculo> findByMarcaContainingIgnoreCase(String marca);

    // 🔍 Busca veículos pelo nome do tipo (relacionamento com TipoVeiculo)
    List<Veiculo> findByTipo_Nome(String tipoNome);

    // 🔍 Busca veículos com preço dentro de uma faixa (mínimo e máximo)
    List<Veiculo> findByPrecoBetween(BigDecimal min, BigDecimal max);

    // 🔍 Busca veículos com ano de fabricação dentro de uma faixa
    List<Veiculo> findByAnoFabricacaoBetween(Integer anoMin, Integer anoMax);

    // 🔍 Busca veículos com quilometragem dentro de uma faixa
    List<Veiculo> findByQuilometragemBetween(Integer kmMin, Integer kmMax);

    // 🔍 Busca veículos com status exato (ex: DISPONIVEL, VENDIDO ou RESERVADO)
    List<Veiculo> findByStatus(StatusVeiculo status);
}