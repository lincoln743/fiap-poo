package br.com.fiapcarro.main;

// Importamos a classe Carro para que o sistema a reconheça
import br.com.fiapcarro.model.Carro;

public class SistemaPrincipal {

    public static void main(String[] args) {
        // INSTANCIAÇÃO
        // O comando 'new' aloca memória para um novo objeto.

        // Fabriquei o primeiro (Instância 1)
        Carro meuCarro = new Carro();
        meuCarro.marca = "Volkswagen";
        meuCarro.modelo = "Gol";
        meuCarro.ano = 2022;

        // Fabriquei o segundo (Instância 2)
        Carro carroDoProfessor = new Carro();
        carroDoProfessor.marca = "Fiat";
        carroDoProfessor.modelo = "Uno";
        carroDoProfessor.ano = 2018;

        // Exibindo os dados no Console
        System.out.println("Meu carro é: " + meuCarro.marca + " " + meuCarro.modelo);
        System.out.println("O do professor é: " + carroDoProfessor.marca + " " + carroDoProfessor.modelo);
    }
}
