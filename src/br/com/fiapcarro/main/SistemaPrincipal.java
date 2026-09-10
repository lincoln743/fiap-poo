package br.com.fiapcarro.main;

import br.com.fiapcarro.model.Carro;

public class SistemaPrincipal {

    public static void main(String[] args) {
        // TESTE 1: A forma correta (nascimento legalizado)
        Carro meuCarro = new Carro("Volkswagen", "Gol", 2022);

        // TESTE 2: Tentando burlar o sistema (descomente a linha abaixo)
        // Carro carroFantasma = new Carro();
        // ERRO DE COMPILAÇÃO: "The constructor Carro() is undefined".
        // Ao definir um construtor com regras, o Java remove o construtor vazio
        // padrão. Você é OBRIGADO a informar marca, modelo e ano.

        System.out.println("\nDados do carro:");
        System.out.println("Marca: " + meuCarro.getMarca());
        System.out.println("Modelo: " + meuCarro.getModelo());
        System.out.println("Ano: " + meuCarro.getAno());
        System.out.println("Velocidade: " + meuCarro.getVelocidade() + " km/h");

        // Comportamentos continuam funcionando normalmente
        System.out.println("\n[Comportamentos]");
        meuCarro.acelerar(60);
        meuCarro.frear(20);
    }
}
