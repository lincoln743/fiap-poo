package br.com.fiapcarro.model;

import java.time.Year;

// Aula 4: Construtores.
// O construtor é o "cartório": obriga o carro a nascer com os dados
// essenciais e válidos. Os atributos são private (encapsulamento) e, como
// marca/modelo/ano NÃO mudam na vida real (um Gol não vira Corolla), não
// expomos setters públicos para eles — a validação fica em setters privados,
// usados apenas no momento do nascimento.
public class Carro {
    // Atributos (sempre privados)
    private String marca;
    private String modelo;
    private int ano;
    private int velocidade; // Estado atual em km/h

    // Velocidade máxima permitida para este carro (km/h)
    public static final int VELOCIDADE_MAXIMA = 200;

    // CONSTRUTOR (o cartório): sem marca, modelo e ano, o carro não nasce.
    public Carro(String marca, String modelo, int ano) {
        // Validamos cada dado essencial no nascimento, via setters privados.
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setAno(ano);
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

    // ---------- Setters PRIVADOS (engrenagem interna de validação) ----------
    // São private porque marca, modelo e ano não mudam depois do nascimento.
    // Só o construtor os usa, para garantir que o carro nasça consistente.

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
