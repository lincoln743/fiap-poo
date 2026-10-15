package br.com.fiapcarro.main;

// Importe TODAS as classes necessárias
import br.com.fiapcarro.model.Carro;
import br.com.fiapcarro.model.CarroEletrico;
import br.com.fiapcarro.model.CarroCombustao;
import br.com.fiapcarro.model.Motor;

import java.util.ArrayList;
import java.util.List;

public class SistemaPrincipal {

    public static void main(String[] args) {
        System.out.println("--- FiapCarro: Classes Abstratas ---");

        // TESTE DE COMPILAÇÃO: Carro agora é abstract.
        // Descomente a linha abaixo para ver o erro: "Carro is abstract; cannot be instantiated".
        // Carro carroGenerico = new Carro("Marca", "Modelo", 2024, new Motor(100, "Flex"));

        // 1. Lista do tipo da SUPERCLASSE abstrata. Ela aceita qualquer filha concreta.
        List<Carro> frota = new ArrayList<>();

        // 2. Os OBJETOS reais são sempre das filhas concretas (nunca da mãe abstrata).
        frota.add(new CarroEletrico("Tesla", "Model 3", 2024, new Motor(150, "Elétrico"), 500));
        frota.add(new CarroCombustao("Volkswagen", "Gol", 2022, new Motor(110, "Flex"), 55));

        // 3. A MÁGICA: o MESMO comando produz resultados diferentes para cada carro.
        System.out.println("\n--- RELATÓRIO DA FROTA ---");
        for (Carro carro : frota) {
            System.out.println("Carro: " + carro.getMarca() + " " + carro.getModelo());
            carro.exibirTipo();                        // método abstrato implementado em cada filha
            System.out.println(carro.calcularAutonomia()); // idem
            System.out.println("----------------------------------------");
        }
    }
}
