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
        System.out.println("--- FiapCarro: Polimorfismo ---");

        // 1. Criamos uma lista da SUPERCLASSE. Ela aceita qualquer herdeiro!
        List<Carro> frota = new ArrayList<>();

        // 2. Colocamos carros de tipos diferentes na mesma frota
        frota.add(new CarroEletrico("Tesla", "Model 3", 2024, new Motor(150, "Elétrico"), 500));
        frota.add(new CarroCombustao("Volkswagen", "Gol", 2022, new Motor(110, "Flex"), 55));

        // 3. A MÁGICA: o MESMO comando produz resultados diferentes para cada carro.
        System.out.println("\n--- RELATÓRIO DE AUTONOMIA DA FROTA ---");
        for (Carro carro : frota) {
            System.out.println("Carro: " + carro.getMarca() + " " + carro.getModelo());
            // O Java escolhe sozinho a conta certa: se for elétrico, usa a do elétrico;
            // se for combustão, usa a do combustão. Sem nenhum 'if' de tipo.
            System.out.println(carro.calcularAutonomia());
            System.out.println("----------------------------------------");
        }
    }
}
