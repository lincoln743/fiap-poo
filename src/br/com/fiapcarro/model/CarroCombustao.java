package br.com.fiapcarro.model;

// Aula 6: Herança. CarroCombustao É UM Carro (herda tudo dele via 'extends').
public class CarroCombustao extends Carro {
    // Atributo EXCLUSIVO do carro a combustão (um elétrico não tem tanque)
    private int tanqueLitros; // capacidade do tanque de combustível

    public CarroCombustao(String marca, String modelo, int ano, Motor motor, int tanqueLitros) {
        // super() chama o construtor da mãe (Carro)
        super(marca, modelo, ano, motor);
        // inicializa o que é exclusivo da filha
        this.tanqueLitros = tanqueLitros;
        System.out.println("Tipo: Combustão | Tanque: " + this.tanqueLitros + " L");
    }

    public int getTanqueLitros() {
        return tanqueLitros;
    }
}
