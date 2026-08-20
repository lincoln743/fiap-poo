package br.com.fiapcarro.main;

// Importamos a classe Carro para que o sistema a reconheça
import br.com.fiapcarro.model.Carro;

public class SistemaPrincipal {

    public static void main(String[] args) {
        // INSTANCIAÇÃO
        // O comando 'new' aloca memória para um novo objeto.
        Carro meuCarro = new Carro("Volkswagen", "Gol", 2022);

        System.out.println("--- Sistema FiapCarro ---");
        System.out.println("Carro: " + meuCarro.marca + " " + meuCarro.modelo
                + " | Ano: " + meuCarro.ano
                + " | Velocidade inicial: " + meuCarro.velocidade + " km/h");

        // Testes com valores VÁLIDOS
        System.out.println("\n[Testes válidos]");
        meuCarro.acelerar(40);   // 0  -> 40
        meuCarro.acelerar(30);   // 40 -> 70
        meuCarro.frear(20);      // 70 -> 50

        // Testes com valores INVÁLIDOS (regras de negócio devem barrar)
        System.out.println("\n[Testes inválidos]");
        meuCarro.acelerar(-10);  // valor negativo -> erro
        meuCarro.frear(0);       // zero -> erro
        meuCarro.frear(999);     // reduz demais -> trava em 0, não fica negativo
        meuCarro.acelerar(500);  // ultrapassaria o limite -> trava em 200
    }
}
