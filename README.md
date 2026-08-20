# Pokédex — Checkpoint 1 (Cross-Platform Application Development)

App em **React Native (Expo)** que exibe um catálogo de Pokémon em grade,
cumprindo os requisitos do checkpoint: uso de `View`, `Text`, `Image`,
`StyleSheet`, `FlatList` **e componentes criados por mim**.

Opção escolhida da lista do enunciado: **card games (Pokémon)**.

---

## Como rodar

Não precisa instalar dependência estranha — o app só usa React Native + Expo.
A forma mais segura (pega as versões certas pra sua máquina) é criar um
projeto Expo em branco e jogar meus arquivos dentro.

```bash
# 1) Cria um projeto Expo em branco
npx create-expo-app@latest CheckpointPokedex --template blank
cd CheckpointPokedex

# 2) Copie para DENTRO dessa pasta (substituindo o App.js):
#    - App.js
#    - a pasta src/
#    (os arquivos que vieram no .zip entregue)

# 3) Roda
npx expo start
```

Depois: aperte `a` (Android), `i` (iOS/Mac) ou leia o QR Code com o app
**Expo Go** no celular. As imagens vêm da internet, então precisa de rede.

---

## Estrutura dos arquivos

```
CheckpointPokedex/
├── App.js                      # Tela principal — monta a FlatList
└── src/
    ├── components/             # >>> COMPONENTES CRIADOS POR MIM <<<
    │   ├── Cabecalho.js        # título + Pokébola desenhada só com View
    │   ├── CartaPokemon.js     # a carta de cada Pokémon (View+Image+Text)
    │   └── TipoBadge.js        # etiqueta colorida de tipo (Fogo, Água...)
    ├── data/
    │   └── pokemons.js         # "banco" mockado: array de Pokémon
    └── theme/
        └── cores.js            # paleta central + cor de cada tipo
```

---

## Onde cada requisito aparece

| Requisito       | Onde está                                                            |
|-----------------|---------------------------------------------------------------------|
| `View`          | Em todos os componentes (estrutura/agrupamento)                     |
| `Text`          | Nome, número, tipos, título                                         |
| `Image`         | `CartaPokemon.js` — arte oficial do Pokémon via URL                |
| `StyleSheet`    | `StyleSheet.create(...)` em todos os arquivos                       |
| `FlatList`      | `App.js` — lista os dados em grade de 2 colunas                    |
| Componentes meus| `Cabecalho`, `CartaPokemon`, `TipoBadge`                            |

---

## Roteiro de apresentação (2–3 min)

Fala isso mostrando o código na tela, nesta ordem:

1. **Dado → tela.** "Comecei separando os dados em `data/pokemons.js`:
   é só um array de objetos. Assim o código que desenha fica limpo e, se
   eu quiser trocar por filmes ou produtos, mudo só esse arquivo."

2. **A FlatList (`App.js`).** "A `FlatList` recebe três coisas: `data`
   (os Pokémon), `keyExtractor` (uma chave única por item pra performance)
   e `renderItem` (como desenhar cada item). Usei `numColumns={2}` pra
   virar uma grade em vez de lista vertical simples. Usei FlatList e não
   `map` porque ela **só renderiza o que está na tela** — rola liso mesmo
   com muitos itens."

3. **Componentes criados.** "Cada item chama minha `CartaPokemon`, que por
   dentro usa outro componente meu, o `TipoBadge`. Isso é composição:
   componente dentro de componente. Cada um recebe dados por **props**."

4. **StyleSheet dinâmico.** "Repara que a cor do badge e o brilho de fundo
   da carta **não estão fixos no estilo** — eles vêm do tipo do Pokémon.
   Em `cores.js` tenho um mapa tipo→cor, e no componente eu combino o
   estilo base com a cor calculada: `style={[base, { backgroundColor: cor }]}`."

5. **Detalhe da Pokébola.** "O cabeçalho tem uma Pokébola que **não é
   imagem** — desenhei com `View` e `border-radius`, sobrepondo círculos.
   É pra mostrar que dá pra construir formas só com estilo."

6. **Estado (bônus).** "Na carta uso `useState` pra mostrar um spinner
   enquanto a imagem baixa da internet — quando termina (`onLoadEnd`),
   o spinner some."

---

## Perguntas que o professor pode fazer (e a resposta)

- **"Por que FlatList e não ScrollView com map?"**
  FlatList é *virtualizada*: renderiza só os itens visíveis e recicla o
  resto. Com muitos itens, gasta bem menos memória e rola sem travar.

- **"Pra que serve o keyExtractor?"**
  Dá uma identidade única pra cada item. O React usa isso pra saber o que
  mudou e re-renderizar só o necessário (evita bugs e melhora performance).

- **"O que são props?"**
  São os "parâmetros" que passo de um componente pai pro filho. Ex.:
  `<CartaPokemon pokemon={item} />` — o `item` chega dentro do componente
  como `props.pokemon`.

- **"Diferença de View pra Text?"**
  `View` é um contêiner/caixa (organiza o layout, tipo uma `div`). `Text`
  é o único lugar onde texto pode aparecer — todo texto tem que estar
  dentro de um `Text`.

- **"Por que StyleSheet.create e não estilo inline direto?"**
  `StyleSheet.create` valida os estilos, deixa o código mais organizado e
  é otimizado internamente. Uso inline só quando a cor/valor é dinâmico.

- **"Como funciona o resizeMode='contain' na imagem?"**
  Encaixa a imagem inteira dentro do espaço sem cortar nem distorcer
  (sobra espaço nas bordas em vez de esticar).

---

## Como trocar o tema (se quiser outra opção do enunciado)

O app foi feito genérico: pra virar "lista de filmes" ou "produtos", basta
mudar `src/data/pokemons.js` (os dados) e renomear os campos usados em
`CartaPokemon.js`. A estrutura (FlatList + carta + badge) continua igual.
