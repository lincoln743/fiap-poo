package br.com.fiapcarro.model;

// A Classe define a estrutura. Ela não é o carro real, é apenas o modelo.
public class Carro {
    // Atributos (Características)
    public String marca;
    public String modelo;
    public int ano;
    public int velocidade; // Estado que muda com o tempo (km/h)

    // Velocidade máxima permitida para este carro (km/h)
    public static final int VELOCIDADE_MAXIMA = 200;

    // Construtor: todo carro nasce parado (velocidade = 0)
    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velocidade = 0;
    }

    // Comportamento: aumentar a velocidade
    public void acelerar(int incremento) {
        // Regra de negócio: o incremento precisa ser positivo
        if (incremento <= 0) {
            System.out.println("Erro: o valor para acelerar deve ser maior que zero.");
            return; // Interrompe a execução do método
        }
        // Regra de negócio: não pode ultrapassar a velocidade máxima
        if (this.velocidade + incremento > VELOCIDADE_MAXIMA) {
            this.velocidade = VELOCIDADE_MAXIMA;
            System.out.println("Limite atingido. Velocidade travada em " + this.velocidade + " km/h.");
            return;
        }
        this.velocidade += incremento;
        System.out.println("Acelerando. Velocidade atual: " + this.velocidade + " km/h.");
    }

    // Comportamento: reduzir a velocidade
    public void frear(int reducao) {
        // Regra de negócio: a redução precisa ser positiva
        if (reducao <= 0) {
            System.out.println("Erro: o valor para frear deve ser maior que zero.");
            return;
        }
        this.velocidade -= reducao;
        // Regra de negócio: a velocidade nunca fica negativa
        if (this.velocidade < 0) {
            this.velocidade = 0;
        }
        System.out.println("Freando. Velocidade atual: " + this.velocidade + " km/h.");
    }
}
