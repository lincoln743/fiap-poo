## Herança: Carro como superclasse (Aula 6)

O `Carro` virou a **superclasse** (mãe). Dois subtipos herdam dele com `extends`, ganham tudo o que o `Carro` tem (marca, modelo, ano, velocidade, motor, `acelerar`/`frear`) e acrescentam o que é exclusivo:

| Subclasse         | Herda de | Atributo exclusivo      |
|-------------------|----------|-------------------------|
| `CarroEletrico`   | `Carro`  | `autonomiaKm` (int, km) |
| `CarroCombustao`  | `Carro`  | `tanqueLitros` (int, L) |

O construtor de cada filha chama `super(marca, modelo, ano, motor)` para inicializar a parte que é da mãe, e depois inicializa o seu próprio atributo.

```java
Motor motorEletrico = new Motor(150, "Elétrico");
CarroEletrico tesla = new CarroEletrico("Tesla", "Model 3", 2024, motorEletrico, 500);

tesla.acelerar(80);        // método herdado de Carro
tesla.getAutonomiaKm();    // atributo exclusivo da filha
```

## Por que a filha não altera os atributos private da mãe diretamente?

Porque `private` significa "só esta classe". Nem a subclasse escapa disso — é o **encapsulamento** (Aula 3) sendo respeitado. A filha só chega aos dados da mãe pelo `super()` (no nascimento) ou pelos getters/setters públicos. Assim, toda validação que mora na mãe continua valendo: se a filha pudesse escrever `this.marca` direto, ela poderia burlar as regras do construtor da mãe e deixar o objeto inconsistente. (Se quiséssemos dar acesso direto à filha, usaríamos `protected` — mas isso amplia a exposição, então só quando fizer sentido.)

## Estrutura de pastas

```
FiapCarro/
├── Carro.asta                (modelo UML — feito no Astah)
└── src/
    ├── module-info.java
    └── br/com/fiapcarro/
        ├── model/Carro.java            (superclasse)
        ├── model/CarroEletrico.java    (subclasse)
        ├── model/CarroCombustao.java   (subclasse)
        ├── model/Motor.java
        └── main/SistemaPrincipal.java
```
