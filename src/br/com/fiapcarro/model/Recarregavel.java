package br.com.fiapcarro.model;

// Aula 9: Interface (contrato de comportamento).
// Diz O QUE a classe deve fazer, não COMO. Qualquer classe que ASSINE este
// contrato é obrigada a ter o método recarregar() — mesmo que sejam de
// hierarquias totalmente diferentes (um carro e um celular, por exemplo).
public interface Recarregavel {

    // Constantes: em interface são public static final por padrão.
    int CARGA_MINIMA = 0;
    int CARGA_MAXIMA = 100;

    // Método sem corpo (apenas a assinatura).
    // Em interface, todo método é public abstract por padrão.
    void recarregar(int percentual);
}
