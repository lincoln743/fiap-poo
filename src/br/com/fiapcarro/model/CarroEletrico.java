package br.com.fiapcarro.model;

// Aula 6: Herança (extends Carro). Aula 9: múltiplos tipos — além de HERDAR de
// Carro, CarroEletrico ASSINA o contrato Recarregavel (implements). Ou seja,
// ele É UM Carro E TAMBÉM é um Recarregavel.
public class CarroEletrico extends Carro implements Recarregavel {
    // Atributo EXCLUSIVO do carro elétrico (um carro a combustão não tem)
    private int autonomiaKm; // quilômetros que roda com uma carga
    private int nivelBateria; // 0 a 100

    public CarroEletrico(String marca, String modelo, int ano, Motor motor, int autonomiaKm) {
        // super() chama o construtor da mãe (Carro) para inicializar o que é dela
        super(marca, modelo, ano, motor);
        // aqui inicializamos o que é exclusivo da filha
        this.autonomiaKm = autonomiaKm;
        this.nivelBateria = 0;
        System.out.println("Tipo: Elétrico | Autonomia: " + this.autonomiaKm + " km");
    }

    public int getAutonomiaKm() {
        return autonomiaKm;
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    // Aula 9: implementação OBRIGATÓRIA do contrato Recarregavel.
    @Override
    public void recarregar(int percentual) {
        if (percentual < Recarregavel.CARGA_MINIMA || percentual > Recarregavel.CARGA_MAXIMA) {
            System.out.println("Erro: percentual inválido (0 a 100).");
            return;
        }
        this.nivelBateria = percentual;
        System.out.println("Carro " + this.getModelo() + " recarregado para " + percentual + "%.");
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
