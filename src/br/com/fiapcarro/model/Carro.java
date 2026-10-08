package br.com.fiapcarro.model;

import java.time.Year;

// Aula 5: Associação ("Tem-Um" / HAS-A).
// Além dos dados simples, o Carro TEM UM Motor: guarda outro objeto dentro dele.
public class Carro {
    // Atributos simples (sempre privados)
    private String marca;
    private String modelo;
    private int ano;
    private int velocidade; // Estado atual em km/h

    // Atributo de ASSOCIAÇÃO (objeto complexo).
    // Clean Code: o nome da variável indica o PAPEL do objeto dentro do Carro.
    private Motor motor;

    // Velocidade máxima permitida para este carro (km/h)
    public static final int VELOCIDADE_MAXIMA = 200;

    // CONSTRUTOR: o carro só nasce com marca, modelo, ano e um Motor.
    public Carro(String marca, String modelo, int ano, Motor motor) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setAno(ano);
        this.motor = motor; // recebe o objeto inteiro (passagem por referência)
        this.velocidade = 0; // todo carro nasce parado
        System.out.println("Registro inicial: " + this.marca + " " + this.modelo
                + " (" + this.ano + ") nasceu no sistema.");
    }

    // ---------- Comportamentos (alteram o estado 'velocidade') ----------

    public void acelerar(int incremento) {
        if (incremento <= 0) {
            System.out.println("Erro: o valor para acelerar deve ser maior que zero.");
            return;
        }
        if (this.velocidade + incremento > VELOCIDADE_MAXIMA) {
            this.velocidade = VELOCIDADE_MAXIMA;
            System.out.println("Limite atingido. Velocidade travada em " + this.velocidade + " km/h.");
            return;
        }
        this.velocidade += incremento;
        System.out.println("Acelerando. Velocidade atual: " + this.velocidade + " km/h.");
    }

    public void frear(int reducao) {
        if (reducao <= 0) {
            System.out.println("Erro: o valor para frear deve ser maior que zero.");
            return;
        }
        this.velocidade -= reducao;
        if (this.velocidade < 0) {
            this.velocidade = 0;
        }
        System.out.println("Freando. Velocidade atual: " + this.velocidade + " km/h.");
    }

    // ---------- Getters (apenas leitura) ----------

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public int getVelocidade() {
        return velocidade;
    }

    // Getter do objeto associado: permite navegar do Carro até o Motor.
    public Motor getMotor() {
        return motor;
    }

    // ---------- Polimorfismo (Aula 7): o CONTRATO ----------
    // A mãe define o método. A resposta aqui é genérica; cada filha sobrescreve
    // com a sua própria conta usando @Override.
    public String calcularAutonomia() {
        return "Autonomia não definida para um carro genérico.";
    }

    // ---------- Setters PRIVADOS (engrenagem interna de validação) ----------

    private void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            System.out.println("Erro de validação: a marca é obrigatória.");
            return;
        }
        this.marca = marca;
    }

    private void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            System.out.println("Erro de validação: o modelo é obrigatório.");
            return;
        }
        this.modelo = modelo;
    }

    private void setAno(int ano) {
        int anoMaximo = Year.now().getValue() + 1;
        if (ano < 1886 || ano > anoMaximo) {
            System.out.println("Erro de validação: ano deve estar entre 1886 e " + anoMaximo + ".");
            return;
        }
        this.ano = ano;
    }
}
