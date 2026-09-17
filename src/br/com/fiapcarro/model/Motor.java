package br.com.fiapcarro.model;

// Aula 5: Associação. O Carro TEM UM Motor.
// O Motor é, por si só, um objeto complexo: tem seus próprios dados e ações.
public class Motor {
    // Atributos (sempre privados)
    private int potencia;        // em cavalos (cv)
    private String combustivel;  // ex.: Flex, Gasolina, Diesel, Elétrico

    // Construtor: um motor não nasce sem potência e combustível
    public Motor(int potencia, String combustivel) {
        this.potencia = potencia;
        this.combustivel = combustivel;
    }

    // Getters (apenas leitura)
    public int getPotencia() {
        return potencia;
    }

    public String getCombustivel() {
        return combustivel;
    }

    // Comportamento do próprio motor
    public void ligar() {
        System.out.println("Motor " + combustivel + " de " + potencia + " cv ligado.");
    }
}
