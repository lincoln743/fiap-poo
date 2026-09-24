package br.com.fiapcarro.main;

// Importe TODAS as classes necessárias
import br.com.fiapcarro.model.CarroEletrico;
import br.com.fiapcarro.model.CarroCombustao;
import br.com.fiapcarro.model.Motor;

public class SistemaPrincipal {

    public static void main(String[] args) {
        System.out.println("--- FiapCarro: Herança ---");

        // Um carro ELÉTRICO (é UM Carro, com atributo exclusivo)
        Motor motorEletrico = new Motor(150, "Elétrico");
        CarroEletrico tesla = new CarroEletrico("Tesla", "Model 3", 2024, motorEletrico, 500);

        // Um carro a COMBUSTÃO
        Motor motorFlex = new Motor(110, "Flex");
        CarroCombustao gol = new CarroCombustao("Volkswagen", "Gol", 2022, motorFlex, 55);

        // --- Elétrico: usa atributo próprio + métodos HERDADOS da mãe Carro ---
        System.out.println("\n--- Elétrico ---");
        System.out.println(tesla.getMarca() + " " + tesla.getModelo()
                + " | Autonomia: " + tesla.getAutonomiaKm() + " km");
        tesla.acelerar(80);        // método herdado de Carro
        tesla.getMotor().ligar();  // associação herdada de Carro

        // --- Combustão: mesmo esquema ---
        System.out.println("\n--- Combustão ---");
        System.out.println(gol.getMarca() + " " + gol.getModelo()
                + " | Tanque: " + gol.getTanqueLitros() + " L");
        gol.acelerar(50);          // método herdado de Carro
    }
}
