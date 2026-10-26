
## Compilar

Na pasta `trabalho-paa`:

```bash
javac -d out src/*.java
```

## Executar o menu

```bash
java -cp out Main
```

Opções do menu:

- `1` — Questão 2 (Karatsuba)
- `2` — Questão 4 (vetor bitônico)
- `3` — Rodar testes
- `0` — Sair

## Executar só os testes

```bash
java -cp out Testes
```

## Tudo de uma vez

```bash
cd trabalho-paa
javac -d out src/*.java && java -cp out Testes
```
