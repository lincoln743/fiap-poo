package br.com.fiapcarro.main;

import br.com.fiapcarro.model.Carro;

public class SistemaPrincipal {

    public static void main(String[] args) {
        Carro meuCarro = new Carro("Volkswagen", "Gol", 2022);

        System.out.println("--- Sistema FiapCarro (Aula 3: Encapsulamento) ---");
        // Atributos agora são private: o acesso é só via get/set
        System.out.println("Carro: " + meuCarro.getMarca() + " " + meuCarro.getModelo()
                + " | Ano: " + meuCarro.getAno()
                + " | Velocidade: " + meuCarro.getVelocidade() + " km/h");

        // PROVA DO ENCAPSULAMENTO (proteção em tempo de compilação):
        // a linha abaixo NÃO compila mais, porque 'velocidade' é private.
        // meuCarro.velocidade = 300;

        // Tentando BURLAR o sistema pelo setter protegido
        System.out.println("\n[Tentando burlar a regra do setVelocidade]");
        meuCarro.setVelocidade(300);   // acima da máxima -> recusado
        meuCarro.setVelocidade(-50);   // negativo -> recusado
        System.out.println("Velocidade após tentativas inválidas: "
                + meuCarro.getVelocidade() + " km/h (continua 0 -> protegido)");

        // Valor válido pelo setter
        System.out.println("\n[Valor válido]");
        meuCarro.setVelocidade(80);    // dentro do intervalo -> aceito

        // Comportamentos continuam funcionando
        System.out.println("\n[Comportamentos]");
        meuCarro.acelerar(50);         // 80 -> 130
        meuCarro.frear(200);           // trava em 0, não fica negativo
    }
}
