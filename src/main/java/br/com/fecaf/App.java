// Pacote principal da aplicação
package br.com.fecaf;

// Importações necessárias para iniciar a aplicação Spring Boot
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// Anotação que marca esta classe como a principal da aplicação Spring Boot
@SpringBootApplication
public class App {

    // Método principal que inicia a aplicação
    public static void main(String[] args) {
        SpringApplication.run(App.class, args); // Inicializa o contexto Spring e sobe o servidor
    }

    // Bean que será executado assim que a aplicação iniciar
    @Bean
    CommandLineRunner initialization() {
        // Expressão lambda que imprime uma mensagem no console ao iniciar
        return args -> {
            System.out.println("O Servidor está rodando!");
        };
    }
}