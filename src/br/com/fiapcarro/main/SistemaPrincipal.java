package br.com.fiapcarro.main;

import br.com.fiapcarro.model.Carro;
import br.com.fiapcarro.model.CarroEletrico;
import br.com.fiapcarro.model.Celular;
import br.com.fiapcarro.model.Motor;
import br.com.fiapcarro.model.Recarregavel;

public class SistemaPrincipal {

    public static void main(String[] args) {
        System.out.println("=== FiapCarro: Teste de Interfaces ===\n");

        // Objetos de classes de HIERARQUIAS DIFERENTES
        CarroEletrico tesla = new CarroEletrico("Tesla", "Model 3", 2024, new Motor(150, "Elétrico"), 500);
        Celular iphone = new Celular("iPhone 15");

        // POLIMORFISMO DE INTERFACE: ambos podem ser tratados como 'Recarregavel',
        // mesmo não tendo nenhum parentesco entre si.
        Recarregavel[] recarregaveis = { tesla, iphone };

        System.out.println("\n=== Recarregando tudo ===");
        for (Recarregavel r : recarregaveis) {
            r.recarregar(85); // mesmo método, comportamentos diferentes
            System.out.println("---");
        }

        // MÚLTIPLOS TIPOS: o CarroEletrico É UM Carro E TAMBÉM é Recarregavel.
        System.out.println("\n=== Múltiplos tipos ===");
        System.out.println("Tesla é um Carro? " + (tesla instanceof Carro));
        System.out.println("Tesla é Recarregavel? " + (tesla instanceof Recarregavel));
        // O Celular NÃO é um Carro, mas é Recarregavel.
        // Obs.: 'iphone instanceof Carro' nem compila (tipos incompatíveis),
        // então checamos em tempo de execução com Carro.class.isInstance(...).
        System.out.println("iPhone é um Carro? " + Carro.class.isInstance(iphone));
        System.out.println("iPhone é Recarregavel? " + (iphone instanceof Recarregavel));
    }
}
