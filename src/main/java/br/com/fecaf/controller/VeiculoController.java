// Pacote onde a classe está localizada
package br.com.fecaf.controller;

// Importações de classes e bibliotecas necessárias
import br.com.fecaf.model.StatusVeiculo;
import br.com.fecaf.model.Veiculo; // Entidade Veiculo
import br.com.fecaf.services.VeiculoService; // Serviço que contém a lógica de negócio
import io.swagger.v3.oas.annotations.Operation; // Anotação para documentação Swagger
import org.springframework.http.ResponseEntity; // Classe para respostas HTTP
import org.springframework.web.bind.annotation.*; // Anotações para mapeamento de rotas

import java.math.BigDecimal; // Tipo para valores monetários
import java.util.List; // Lista de veículos

// Define que esta classe é um controlador REST
@RestController

// Define o prefixo das rotas deste controlador
@RequestMapping("/veiculos")
public class VeiculoController {

    // Injeção do serviço que contém as regras de negócio
    private final VeiculoService veiculoService;

    // Construtor com injeção de dependência
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    // Endpoint para listar todos os veículos
    @Operation(summary = "Lista todos os veículos", description = "Retorna todos os veículos cadastrados no sistema")
    @GetMapping
    public List<Veiculo> listarTodos() {
        return veiculoService.listarTodos();
    }

    // Endpoint para cadastrar um novo veículo
    @Operation(summary = "Cadastra um novo veículo", description = "Recebe os dados de um veículo e salva no banco")
    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return veiculoService.salvar(veiculo);
    }

    // Endpoint para buscar veículos por marca
    @Operation(summary = "Busca por marca", description = "Retorna veículos que correspondem à marca informada")
    @GetMapping("/marca")
    public List<Veiculo> buscarPorMarca(@RequestParam String marca) {
        return veiculoService.buscarPorMarca(marca);
    }

    // Endpoint para buscar veículos por tipo
    @Operation(summary = "Busca por tipo", description = "Retorna veículos que correspondem ao tipo informado")
    @GetMapping("/tipo")
    public List<Veiculo> buscarPorTipo(@RequestParam String tipo) {
        return veiculoService.buscarPorTipo(tipo);
    }

    // Endpoint para buscar veículos por faixa de preço
    @Operation(summary = "Busca por faixa de preço", description = "Retorna veículos dentro da faixa de preço informada")
    @GetMapping("/preco")
    public List<Veiculo> buscarPorFaixaDePreco(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return veiculoService.buscarPorFaixaDePreco(min, max);
    }

    // Endpoint comentado para buscar veículos por ano exato (opcional)
    /*
    @Operation(summary = "Busca por ano de fabricação", description = "Retorna veículos fabricados no ano informado")
    @GetMapping("/ano")
    public List<Veiculo> buscarPorAno(@RequestParam Integer ano) {
        return veiculoService.buscarPorAno(ano);
    }
    */

    // Endpoint para deletar um veículo pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        veiculoService.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

    // Endpoint para buscar um veículo pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        Veiculo veiculo = veiculoService.buscarPorId(id);
        return ResponseEntity.ok(veiculo); // Retorna 200 OK com o veículo
    }

    // Endpoint para atualizar um veículo pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        Veiculo veiculo = veiculoService.atualizar(id, veiculoAtualizado);
        return ResponseEntity.ok(veiculo); // Retorna 200 OK com o veículo atualizado
    }

    // Endpoint para buscar veículos por faixa de ano
    @Operation(summary = "Busca por faixa de ano", description = "Retorna veículos dentro da faixa de ano informada")
    @GetMapping("/ano")
    public List<Veiculo> buscarPorFaixaAno(@RequestParam Integer anoMin, @RequestParam Integer anoMax) {
        return veiculoService.buscarPorFaixaAno(anoMin, anoMax);
    }

    // Endpoint para buscar veículos por faixa de quilometragem
    @Operation(summary = "Busca por faixa de KM", description = "Retorna veiculos dentro da faixa de KM informada")
    @GetMapping("/quilometragem")
    public List<Veiculo> buscarPorFaixaKm(@RequestParam Integer kmMin, @RequestParam Integer kmMax) {
        return veiculoService.buscarPorFaixaKm(kmMin, kmMax);
    }

    // Endpoint para buscar veículos por status
    @Operation(summary = "Busca por Status", description = "Retorna veiculos com o Status informado")
    @GetMapping("/status")
    public List<Veiculo> buscarPorStatus(@RequestParam StatusVeiculo status) {
        return veiculoService.buscarPorStatus(status);
    }
}