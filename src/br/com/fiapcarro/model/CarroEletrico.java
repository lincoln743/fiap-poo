package br.com.fiapcarro.model;

// Aula 6: Herança. CarroEletrico É UM Carro (herda tudo dele via 'extends').
public class CarroEletrico extends Carro {
    // Atributo EXCLUSIVO do carro elétrico (um carro a combustão não tem)
    private int autonomiaKm; // quilômetros que roda com uma carga

    public CarroEletrico(String marca, String modelo, int ano, Motor motor, int autonomiaKm) {
        // super() chama o construtor da mãe (Carro) para inicializar o que é dela
        super(marca, modelo, ano, motor);
        // aqui inicializamos o que é exclusivo da filha
        this.autonomiaKm = autonomiaKm;
        System.out.println("Tipo: Elétrico | Autonomia: " + this.autonomiaKm + " km");
    }

    public int getAutonomiaKm() {
        return autonomiaKm;
    }

    // Aula 7: Sobrescrita. O elétrico calcula a autonomia do jeito dele:
    // a carga da bateria já é dada em km.
    @Override
    public String calcularAutonomia() {
        return "Autonomia: " + this.autonomiaKm + " km com uma carga da bateria.";
    }

    // Aula 8: implementação OBRIGATÓRIA do método abstrato da mãe.
    @Override
    public void exibirTipo() {
        System.out.println("Sou um Carro Elétrico.");
    }
}
