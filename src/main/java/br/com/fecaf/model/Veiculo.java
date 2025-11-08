// Pacote onde a classe está localizada
package br.com.fecaf.model;

// Importações necessárias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

// Declaração da entidade JPA que representa a tabela "veiculo"
@Entity
@Table(name = "veiculo")
public class Veiculo {

    // Chave primária com geração automática (auto-incremento)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Marca do veículo (obrigatória)
    @Column(name = "marca", nullable = false)
    private String marca;

    // Modelo do veículo (obrigatório)
    @Column(name = "modelo", nullable = false)
    private String modelo;

    // Ano de fabricação (obrigatório)
    @Column(name = "ano_fabricacao", nullable = false)
    private Integer anoFabricacao;

    // Cor do veículo (opcional)
    @Column(name = "cor")
    private String cor;

    // Quilometragem do veículo (opcional)
    @Column(name = "quilometragem")
    private Integer quilometragem;

    // Preço do veículo (obrigatório)
    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    // Status do veículo (DISPONIVEL, VENDIDO, etc.), armazenado como texto
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusVeiculo status = StatusVeiculo.DISPONIVEL;

    // Data de cadastro do veículo (preenchida automaticamente com a data atual)
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    // Relacionamento muitos-para-um com a entidade TipoVeiculo
    @ManyToOne
    @JoinColumn(name = "tipo_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoVeiculo tipo;

    // URL da imagem do veículo (opcional)
    @Column(name = "imagem_url")
    private String imagemUrl;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }
}