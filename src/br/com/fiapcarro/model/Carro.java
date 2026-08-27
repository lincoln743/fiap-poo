package br.com.fiapcarro.model;

// Aula 3: Encapsulamento.
// Os atributos agora são 'private'. Ninguém de fora acessa direto:
// só através dos métodos get (ler) e set (alterar, com regras).
public class Carro {
    // Atributos (agora protegidos com 'private')
    private String marca;
    private String modelo;
    private int ano;
    private int velocidade; // Estado atual em km/h

    // Velocidade máxima permitida para este carro (km/h)
    public static final int VELOCIDADE_MAXIMA = 200;

    // Construtor: todo carro nasce parado (velocidade = 0)
    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velocidade = 0;
    }

    // ---------- Comportamentos (Aula 2) ----------

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

    // ---------- Getters e Setters (Aula 3) ----------

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getVelocidade() {
        return velocidade;
    }

    // REGRA ESPECIAL: a velocidade só aceita valores entre 0 e a máxima.
    // Qualquer valor fora do intervalo é recusado e o estado não muda.
    public void setVelocidade(int velocidade) {
        if (velocidade < 0 || velocidade > VELOCIDADE_MAXIMA) {
            System.out.println("Erro: velocidade deve estar entre 0 e " + VELOCIDADE_MAXIMA
                    + " km/h. Valor recusado: " + velocidade + ".");
            return; // não altera o estado -> objeto protegido
        }
        this.velocidade = velocidade;
        System.out.println("Velocidade ajustada para " + this.velocidade + " km/h.");
    }
}
