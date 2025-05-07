# Template de Projeto Java com Maven
[![en](https://img.shields.io/badge/lang-en-blue.svg)](https://github.com/nathanassis/java-maven-project-template/blob/main/README.md)
[![pt-br](https://img.shields.io/badge/lang-pt--br-green.svg)](https://github.com/nathanassis/java-maven-project-template/blob/main/README.pt-br.md)

Este é um repositório de template para projetos Java com Maven com as seguintes ferramentas de desenvolvimento:

* `Checkstyle`: Linter
* `google-java-format`: Formatador
* `JUnit`: Testes unitários
* `GitHub Actions`: Executa testes e verificações em cada pull request e push para a branch `main`

## Instruções de Desenvolvimento

### Requisitos

Verifique se você possui instalados:

- Java 17+
- Maven 3.8+
  (Recomendado: Use o wrapper `./mvnw` para builds consistentes)

### Executando Testes

Para rodar os testes:

```sh
./mvnw test
```

### Executando Linter

Para rodar o linter:

```sh
./mvnw checkstyle:check
```

### Executando Formatter

Para verificar a formatação do código:

```sh
./mvnw fmt:check
```

Para formatar o código:

```sh
./mvnw fmt:format
```

### Build e Verificações

Para rodar o build com testes, verificação de formatação e lint:

```sh
./mvnw verify
```

## Estrutura do Repositório

* `.github/workflows/ci.yml`: GitHub Actions para rodar testes e verificações
* `.gitignore`: Arquivos ignorados pelo Git
* `README.md`: Descrição do projeto
* `README.pt-br.md`: Descrição do projeto em português
* `pom.xml`: Configuração do Maven
* `src/main/java`: Código da aplicação
* `src/test/java`: Testes unitários

## 🔎 Encontrou um Problema ou Tem uma Sugestão?

Ajude a melhorar este template abrindo uma issue ou criando um pull request!