# FiapCarro

Projeto incremental de Programação Orientada a Objetos — paralelo ao **FiapRide**, aplicando os conceitos das aulas ao objeto **Carro**.

## O que o objeto representa

A classe `Carro` modela um carro no mundo real: nasce com dados obrigatórios (marca, modelo e ano), mantém o estado protegido e só muda de velocidade através de comportamentos controlados.

## Estrutura da classe

Atributos — todos `private` (encapsulamento):

| Atributo     | Tipo     | Descrição                                    | Muda depois do nascimento? |
|--------------|----------|----------------------------------------------|----------------------------|
| `marca`      | `String` | Fabricante do carro (ex.: Volkswagen)        | Não (imutável)             |
| `modelo`     | `String` | Modelo do carro (ex.: Gol)                   | Não (imutável)             |
| `ano`        | `int`    | Ano de fabricação                            | Não (imutável)             |
| `velocidade` | `int`    | Estado atual em km/h (nasce em 0)            | Sim, via `acelerar`/`frear`|

## Construtor (o "cartório")

`Carro(String marca, String modelo, int ano)` — executado uma única vez, no `new`. Obriga o carro a nascer com os três dados essenciais e válidos. A validação de cada um acontece em **setters privados** chamados dentro do construtor.

```java
Carro meuCarro = new Carro("Volkswagen", "Gol", 2022); // correto

// Carro fantasma = new Carro();  // NÃO COMPILA: o construtor vazio deixa de existir
```

Regras de nascimento:
- `marca` e `modelo` não podem ser nulos nem vazios.
- `ano` deve estar entre 1886 (primeiro automóvel) e o ano seguinte ao atual.

## Métodos

Comportamentos (mudam a velocidade, com regra de negócio):
- `acelerar(int incremento)` — aumenta a velocidade, sem passar do limite (`VELOCIDADE_MAXIMA = 200`).
- `frear(int reducao)` — reduz a velocidade, sem ficar negativa.

Getters (apenas leitura): `getMarca()`, `getModelo()`, `getAno()`, `getVelocidade()`.

## Por que não há setters públicos para marca, modelo e ano?

Porque, no mundo real, esses dados não mudam: um Gol não vira Corolla, e o ano de fabricação é fixo. Gerar "getters e setters para tudo" automaticamente abriria brechas para deixar o objeto inconsistente. Aqui, os setters de validação são `private` e só o construtor os usa — a única forma de mudar o estado depois do nascimento é a velocidade, e só pelos comportamentos `acelerar`/`frear`.

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
        └── main/SistemaPrincipal.java
```
