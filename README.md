# FiapCarro

Projeto incremental de Programação Orientada a Objetos — paralelo ao **FiapRide**, aplicando os conceitos das aulas ao objeto **Carro**.

## O que o objeto representa

A classe `Carro` modela um carro no mundo real: guarda suas características (o que ele **é** e **tem**) e define comportamentos que alteram o seu estado (o que ele **faz**), sempre protegendo esse estado contra valores inválidos.

## Estrutura da classe

Atributos — todos `private` (encapsulamento, Aula 3):

| Atributo     | Tipo     | Descrição                                    |
|--------------|----------|----------------------------------------------|
| `marca`      | `String` | Fabricante do carro (ex.: Volkswagen)        |
| `modelo`     | `String` | Modelo do carro (ex.: Gol)                   |
| `ano`        | `int`    | Ano de fabricação                            |
| `velocidade` | `int`    | Estado atual em km/h (todo carro nasce em 0) |

Como os atributos são privados, o acesso de fora só acontece pelos métodos `get` (ler) e `set` (alterar).

## Métodos

Comportamentos (Aula 2):

- `acelerar(int incremento)` — aumenta a velocidade (respeita o limite máximo).
- `frear(int reducao)` — reduz a velocidade (nunca fica negativa).

Getters e setters (Aula 3):

- `getMarca()` / `setMarca(String)`
- `getModelo()` / `setModelo(String)`
- `getAno()` / `setAno(int)`
- `getVelocidade()` / `setVelocidade(int)`

## Regra especial de proteção

`setVelocidade(int velocidade)` só aceita valores entre `0` e `VELOCIDADE_MAXIMA` (200 km/h). Qualquer valor fora desse intervalo é recusado e o estado **não muda** — o objeto se mantém sempre válido.

```java
Carro meuCarro = new Carro("Volkswagen", "Gol", 2022);

meuCarro.setVelocidade(300); // Recusado: fora do intervalo (0..200)
meuCarro.setVelocidade(-50); // Recusado: negativo
meuCarro.setVelocidade(80);  // Aceito

// meuCarro.velocidade = 300; // NÃO COMPILA: 'velocidade' é private
```

## Por que encapsular?

Com os atributos `private`, ninguém consegue fazer `carro.velocidade = 300` direto e deixar o objeto num estado impossível. Toda alteração passa obrigatoriamente pelos setters, onde a regra de negócio mora — a validação fica em um único lugar e o objeto nunca fica inconsistente.

## Como executar

Abra o projeto no Eclipse e rode `SistemaPrincipal` (`Run As` → `Java Application`).

## Estrutura de pastas

```
FiapCarro/
├── Carro.asta                (modelo UML — salvo pelo Astah)
├── Carro.xmi                 (modelo UML para importar no Astah)
└── src/
    ├── module-info.java
    └── br/com/fiapcarro/
        ├── model/Carro.java
        └── main/SistemaPrincipal.java
```
