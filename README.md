# 🍔 CodeBurger

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk" alt="Java 21">
  <img src="https://img.shields.io/badge/Maven-3.9+-blue?style=for-the-badge&logo=apachemaven" alt="Maven">
  <img src="https://img.shields.io/badge/JUnit-5.10.2-green?style=for-the-badge&logo=junit5" alt="JUnit 5">
</p>

**CodeBurger** é um sistema de gerenciamento de pedidos para restaurantes, desenvolvido em Java como projeto avaliativo do programa **ElasTech**, iniciativa da SoulCode em parceria com o PagBank.

A aplicação simula o fluxo operacional de uma hamburgueria, desde o atendimento ao cliente e a personalização dos pedidos até o gerenciamento das vendas e o fechamento do caixa.

O projeto foi desenvolvido com foco na aplicação prática da Programação Orientada a Objetos (POO), dos princípios SOLID e dos padrões de projeto (*Design Patterns*), buscando construir uma solução organizada, modular e de fácil manutenção.

---

## 📋 Sumário

- [Funcionalidades](#-funcionalidades)
- [Tecnologias utilizadas](#-tecnologias-utilizadas)
- [Arquitetura e padrões de projeto](#-arquitetura-e-padrões-de-projeto)
- [Estrutura do projeto](#-estrutura-do-projeto)
- [Testes automatizados](#-testes-automatizados)
- [Como executar](#-como-executar-o-projeto)
- [Demonstração](#-demonstração)
- [Aprendizados](#-aprendizados)

---

## ✨ Funcionalidades

### 🍔 Cardápio e gerenciamento de pedidos

- **Cardápio dinâmico:** exibição dos lanches disponíveis, com formatação colorida diretamente no terminal.
- **Criação de pedidos:** abertura de comandas vinculadas ao nome do cliente.
- **Personalização de lanches:** remoção de ingredientes sem alteração do preço original e inclusão de adicionais pagos.
- **Gerenciamento de pedidos:** possibilidade de adicionar novos lanches, remover itens específicos ou cancelar uma comanda inteira.

### 💰 Gestão financeira e fechamento de caixa

- Registro e controle das gorjetas recebidas.
- Cálculo do faturamento diário, considerando pedidos e gorjetas.
- Relatório das diferentes combinações de lanches comercializadas.
- Relatório dos diferentes tipos de lanches-base vendidos.

### 🛡️ Validações e tratamento de erros

- Validação das entradas fornecidas pelo usuário.
- Tratamento de entradas inválidas, como caracteres não numéricos em campos que exigem números.
- Prevenção de interrupções inesperadas e loops infinitos durante a utilização do sistema.

---

## 🛠️ Tecnologias utilizadas

| Tecnologia | Aplicação |
|---|---|
| Java 21 | Linguagem de programação |
| Apache Maven 3.9+ | Gerenciamento de dependências e build |
| JUnit 5.10.2 | Testes automatizados |
| Git e GitHub | Versionamento e hospedagem do código |

---

## 🏗️ Arquitetura e padrões de projeto

O CodeBurger foi desenvolvido utilizando os conceitos de Programação Orientada a Objetos e os princípios **SOLID**, priorizando a separação de responsabilidades, o baixo acoplamento e a facilidade de manutenção.

Para estruturar a aplicação, foram utilizados os seguintes padrões de projeto:

### 1. Facade — `RestauranteFacade`

Centraliza a comunicação entre a interface de usuário (`MenuConsole`) e as regras de negócio.

Simplifica o acesso às funcionalidades do sistema, evitando que a camada de apresentação precise conhecer diretamente os detalhes internos da implementação.

### 2. Factory — `LancheFactory`

Responsável pela criação dos lanches padrão disponíveis no cardápio.

Encapsula a lógica de instanciação dos objetos, permitindo que outras classes solicitem a criação de um lanche sem conhecer os detalhes de sua construção.

### 3. Decorator — `ComCheddar`, `ComBaconExtra`, `ComBanana`, entre outros

Permite adicionar ingredientes extras aos lanches de maneira dinâmica, sem modificar suas classes originais.

Cada adicional envolve o lanche anterior, acrescentando novas descrições e valores ao produto. Dessa forma, diferentes combinações podem ser criadas de maneira flexível e extensível.

### 4. Singleton — `Caixa`

Garante uma única instância da classe responsável pelo controle financeiro do restaurante durante a execução da aplicação.

Centraliza o registro das transações, das gorjetas e das informações necessárias para o fechamento diário do caixa.

### 5. Single Responsibility Principle (SRP)

Aplicado na separação das responsabilidades entre as classes.

Por exemplo:

- `Pedido`: gerencia os itens e as operações de uma comanda específica.
- `GerenciadorPedidos`: administra a coleção de pedidos do restaurante.

Essa divisão facilita a manutenção e permite que cada classe tenha um propósito bem definido.

---

## 📂 Estrutura do projeto

A aplicação está organizada em pacotes, separando as responsabilidades de cada parte do sistema.

```text
codeBurger/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── app/
│   │       │   ├── Main.java
│   │       │   ├── MenuConsole.java
│   │       │   └── RestauranteFacade.java
│   │       │
│   │       ├── cardapio/
│   │       │   ├── ComBaconExtra.java
│   │       │   ├── ComBanana.java
│   │       │   ├── ComCarneExtra.java
│   │       │   ├── ComCebolaCaramelizada.java
│   │       │   ├── ComCheddar.java
│   │       │   ├── ComMussarela.java
│   │       │   ├── ComPicles.java
│   │       │   ├── ItemCardapio.java
│   │       │   ├── Lanche.java
│   │       │   └── LancheFactory.java
│   │       │
│   │       ├── financeiro/
│   │       │   ├── Caixa.java
│   │       │   └── Transacao.java
│   │       │
│   │       ├── pedido/
│   │       │   ├── GerenciadorPedidos.java
│   │       │   └── Pedido.java
│   │       │
│   │       └── util/
│   │           └── Cores.java
│   │
│   └── test/
│       └── java/
│           ├── cardapio/
│           │   ├── AdicionaisTest.java
│           │   └── LancheTest.java
│           │
│           ├── financeiro/
│           │   └── BonusTest.java
│           │
│           └── pedido/
│               ├── GerenciadorPedidosTest.java
│               └── PedidoTest.java
│
├── .gitignore
├── LICENSE
├── pom.xml
└── README.md
```

---

## 🧪 Testes automatizados

O projeto utiliza **JUnit 5** para a execução de testes unitários, permitindo verificar o comportamento das funcionalidades e identificar possíveis falhas durante o desenvolvimento.

Para executar os testes, utilize:

```bash
mvn test
```

---

## 🚀 Como executar o projeto

### Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- [Java JDK 21](https://www.oracle.com/java/technologies/downloads/) ou superior
- [Apache Maven 3.9+](https://maven.apache.org/download.cgi)
- Git

### 1. Clone o repositório

```bash
git clone https://github.com/mellyssamnds/codeBurger.git
```

### 2. Acesse a pasta do projeto

```bash
cd codeBurger
```

### 3. Execute os testes

```bash
mvn test
```

### 4. Gere o arquivo JAR

```bash
mvn clean package
```

Após a execução, o arquivo executável será gerado no diretório `target/`.

### 5. Execute a aplicação

**Linux ou macOS:**

```bash
java -jar target/codeburger-1.0-SNAPSHOT.jar
```

**Windows:**

```bash
java -Dfile.encoding=UTF-8 -jar target/codeburger-1.0-SNAPSHOT.jar
```

> **Dica:** Para garantir a exibição correta dos acentos e das cores ANSI, utilize um terminal compatível com UTF-8 e sequências de escape ANSI.

---

## 🎥 Demonstração

Confira a demonstração do CodeBurger e conheça na prática as principais funcionalidades desenvolvidas.

<p align="center">
  <a href="https://youtu.be/EjwjCV_-mW4">
    <img src="https://img.youtube.com/vi/EjwjCV_-mW4/0.jpg" alt="Demonstração do CodeBurger" width="640" height="360">
  </a>
</p>

<p align="center">
  <i>▶ Clique na imagem para assistir à demonstração.</i>
</p>

---

## 📚 Aprendizados

O desenvolvimento do CodeBurger proporcionou a aplicação prática de conceitos fundamentais para a construção de software, incluindo:

- Programação Orientada a Objetos com Java.
- Aplicação dos princípios SOLID.
- Implementação de padrões de projeto (*Design Patterns*).
- Organização e separação de responsabilidades.
- Desenvolvimento de testes unitários com JUnit 5.
- Tratamento de exceções e validação de entradas.
- Gerenciamento de dependências e construção de projetos com Maven.
- Desenvolvimento de aplicações interativas executadas via terminal.

---

## 👩‍💻 Autora

Projeto desenvolvido como parte da formação **ElasTech**, da SoulCode em parceria com o PagBank.

