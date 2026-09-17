package br.com.fiapcarro.main;

// Importe TODAS as classes necessárias
import br.com.fiapcarro.model.Carro;
import br.com.fiapcarro.model.Motor;

public class SistemaPrincipal {

    public static void main(String[] args) {
        System.out.println("--- FiapCarro: Inicializando ---");

        // 1. Criamos primeiro o objeto associado (o "ator" independente)
        Motor motorFlex = new Motor(110, "Flex");

        // 2. Criamos o Carro, ASSOCIANDO o Motor a ele
        Carro meuCarro = new Carro("Volkswagen", "Gol", 2022, motorFlex);

        // 3. A mágica: navegamos do Carro -> Motor -> dados do Motor
        System.out.println("\n--- Ficha do carro ---");
        System.out.println("Modelo: " + meuCarro.getMarca() + " " + meuCarro.getModelo());
        System.out.println("Potência: " + meuCarro.getMotor().getPotencia() + " cv");
        System.out.println("Combustível: " + meuCarro.getMotor().getCombustivel());

        // 4. Também acessamos o COMPORTAMENTO do objeto associado
        meuCarro.getMotor().ligar();

        // Comportamentos do próprio Carro continuam funcionando
        System.out.println("\n[Comportamentos]");
        meuCarro.acelerar(60);
        meuCarro.frear(20);
    }
}
