package br.com.fecaf.repository;

import br.com.fecaf.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    // Buscar por marca
    List<Veiculo> findByMarcaContainingIgnoreCase(String marca);

    // Buscar por tipo
    List<Veiculo> findByTipo_Nome(String tipoNome);

    // Buscar por faixa de preço
    List<Veiculo> findByPrecoBetween(BigDecimal min, BigDecimal max);

    // Buscar por ano de fabricação
    List<Veiculo> findByAnoFabricacao(Integer ano);
}
