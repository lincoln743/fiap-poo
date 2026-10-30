package br.com.fiapcarro.model;

// Aula 9: Celular NÃO herda de Carro (é outra hierarquia), mas TAMBÉM é
// Recarregavel. É isso que a interface permite: compartilhar um comportamento
// entre classes sem relação de parentesco.
public class Celular implements Recarregavel {
    private String marca;
    private int nivelBateria; // 0 a 100

    public Celular(String marca) {
        this.marca = marca;
        this.nivelBateria = 0;
    }

    // OBRIGATÓRIO: implementar o método do contrato Recarregavel.
    @Override
    public void recarregar(int percentual) {
        if (percentual < Recarregavel.CARGA_MINIMA || percentual > Recarregavel.CARGA_MAXIMA) {
            System.out.println("Erro: percentual inválido (0 a 100).");
            return;
        }
        this.nivelBateria = percentual;
        System.out.println("Celular " + this.marca + " carregado para " + percentual + "%.");
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    public String getMarca() {
        return marca;
    }
}
