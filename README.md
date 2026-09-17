## Estrutura da classe

Atributos — todos `private` (encapsulamento):

| Atributo     | Tipo     | Descrição                                         |
|--------------|----------|---------------------------------------------------|
| `marca`      | `String` | Fabricante (imutável)                             |
| `modelo`     | `String` | Modelo (imutável)                                 |
| `ano`        | `int`    | Ano de fabricação (imutável)                      |
| `velocidade` | `int`    | Estado atual em km/h (nasce em 0)                 |
| `motor`      | `Motor`  | Associação: o Carro **TEM UM** Motor              |

## Associação: o Carro TEM UM Motor (Aula 5)

Em vez de guardar só tipos simples, o `Carro` guarda outro objeto — um `Motor`, que tem seus próprios dados (`potencia`, `combustivel`) e comportamento (`ligar()`). O nome do atributo (`motor`) indica o papel que o objeto desempenha dentro do carro.

```java
Motor motorFlex = new Motor(110, "Flex");
Carro meuCarro = new Carro("Volkswagen", "Gol", 2022, motorFlex);

// Navegando do Carro até o Motor:
meuCarro.getMotor().getPotencia();   // 110
meuCarro.getMotor().ligar();          // Motor Flex de 110 cv ligado.
```

## Por que passar o objeto inteiro (e não só uma String)?

Se o `Carro` guardasse apenas `"110 cv Flex"` como texto, ele teria a informação, mas não conseguiria **agir** sobre o motor (ligar, no futuro consultar consumo, trocar estado). Passando o objeto `Motor` inteiro, o carro acessa tanto os dados quanto os comportamentos — e qualquer mudança no motor é enxergada pelo carro, porque ambos apontam para o mesmo objeto na memória (passagem por referência).

## Construtor

`Carro(String marca, String modelo, int ano, Motor motor)` — o carro só nasce com os quatro dados. (Isso passa do limite ideal de 3 parâmetros do Clean Code; num projeto maior, o padrão Builder resolveria isso — assunto de aulas futuras.)

## Como executar

Abra o projeto no Eclipse e rode `SistemaPrincipal` (`Run As` → `Java Application`).

## Estrutura de pastas

```
FiapCarro/
├── Carro.asta                (modelo UML — feito no Astah)
└── src/
    ├── module-info.java
    └── br/com/fiapcarro/
        ├── model/Carro.java
        ├── model/Motor.java
        └── main/SistemaPrincipal.java
```
