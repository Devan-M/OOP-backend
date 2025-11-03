package br.com.fecaf.controller;

import br.com.fecaf.model.Veiculo;
import br.com.fecaf.services.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @Operation(summary = "Lista todos os veículos", description = "Retorna todos os veículos cadastrados no sistema")
    @GetMapping
    public List<Veiculo> listarTodos() {
        return veiculoService.listarTodos();
    }

    @Operation(summary = "Cadastra um novo veículo", description = "Recebe os dados de um veículo e salva no banco")
    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return veiculoService.salvar(veiculo);
    }

    @Operation(summary = "Busca por marca", description = "Retorna veículos que correspondem à marca informada")
    @GetMapping("/marca")
    public List<Veiculo> buscarPorMarca(@RequestParam String marca) {
        return veiculoService.buscarPorMarca(marca);
    }

    @Operation(summary = "Busca por tipo", description = "Retorna veículos que correspondem ao tipo informado")
    @GetMapping("/tipo")
    public List<Veiculo> buscarPorTipo(@RequestParam String tipo) {
        return veiculoService.buscarPorTipo(tipo);
    }

    @Operation(summary = "Busca por faixa de preço", description = "Retorna veículos dentro da faixa de preço informada")
    @GetMapping("/preco")
    public List<Veiculo> buscarPorFaixaDePreco(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return veiculoService.buscarPorFaixaDePreco(min, max);
    }

    @Operation(summary = "Busca por ano de fabricação", description = "Retorna veículos fabricados no ano informado")
    @GetMapping("/ano")
    public List<Veiculo> buscarPorAno(@RequestParam Integer ano) {
        return veiculoService.buscarPorAno(ano);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        veiculoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        Veiculo veiculo = veiculoService.buscarPorId(id);
        return ResponseEntity.ok(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado) {
        Veiculo veiculo = veiculoService.atualizar(id, veiculoAtualizado);
        return ResponseEntity.ok(veiculo);
    }


    @Operation(summary = "Endpoint de teste", description = "Verifica se a API está funcionando")
    @GetMapping("/teste")
    public String teste() {
        return "Funcionando!";
    }
}