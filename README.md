# 🚗👩 GoLady - Backend

<br />

<div align="center">
   <img src="https://i.imgur.com/w8tTOuT.png" title="source: imgur.com" /> 
</div>

<div align="center">
<img src="https://img.shields.io/github/languages/top/Projetos-Grupo-01/go_lady?style=flat-square" />
<img src="https://img.shields.io/github/repo-size/Projetos-Grupo-01/go_lady?style=flat-square" />
<img src="https://img.shields.io/github/languages/count/Projetos-Grupo-01/go_lady?style=flat-square" />
<img src="https://img.shields.io/github/last-commit/Projetos-Grupo-01/go_lady?style=flat-square" />
<img src="https://img.shields.io/github/issues/Projetos-Grupo-01/go_lady?style=flat-square" />
<img src="https://img.shields.io/github/issues-pr/Projetos-Grupo-01/go_lady?style=flat-square" />
<img src="https://img.shields.io/badge/status-Em%20andamento-yellow" alt="Status: Em andamento">
 
</div>

<br /><br />

## 1. 📄 Descrição

Este projeto tem como objetivo implementar um aplicativo de carona compartilhada exclusivo para mulheres, permitindo o gerenciamento eficiente das viagens oferecidas e realizadas. O sistema será responsável por realizar operações de CRUD (Create, Read, Update, Delete) sobre as principais entidades do aplicativo: usuários, viagens e veículos cadastrados.

### 1.1. 🛠️ Funcionalidades:

Usuário 👤
1. Criar Usuário (Create): Permite o cadastro de um novo usuário no sistema, informando todos os atributos necessários.

2. Consultar Usuário(s) (Read): Consultar um usuário específico através do seu id. Listar todos os usuários cadastrados, com possibilidade de filtragem por nome ou email.

3. Atualizar Usuário (Update): Permite a modificação dos dados de um usuário já existente, identificando-o pelo id.

Viagem 🛣️
1. Criar Viagem (Create): Permite o cadastro de uma nova viagem no sistema, informando todos os atributos necessários

2. Consultar Viagem(s) (Read): Consultar uma viagem específica através do seu id. Listar todas as viagens cadastradas, com possibilidade de filtragem por origem, destino, data ou motorista

3. Atualizar Viagem (Update): Permite a modificação dos dados de uma viagem já existente, identificando-a pelo id

4. Excluir Viagem (Delete): Remove uma viagem do sistema, utilizando seu id como referência

Veículo 🚗
1. Criar Veículo (Create): Permite o cadastro de um novo veículo no sistema, informando todos os atributos necessários

2. Consultar Veículo(s) (Read): Consultar um veículo específico através do seu id. Listar todos os veículos cadastrados, com possibilidade de filtragem por modelo, placa ou proprietária

3. Atualizar Veículo (Update): Permite a modificação dos dados de um veículo já existente, identificando-o pelo id

4. Excluir Veículo (Delete): Remove um veículo do sistema, utilizando seu id como referência

------

## 2. 🖥️ Sobre esta API

A API do GoLady foi desenvolvida utilizando Java e o framework Spring, seguindo os princípios da Arquitetura MVC e REST. Ela oferece endpoints para o gerenciamento dos recursos **Usuário**, **Viagem** e **Veículo**, permitindo a interação entre as usuárias com os dados cadastrados nessas entidades.

### 2.1. 🚀 Principais Funcionalidades

1. Consulta, criação e edição de usuários
2. Consulta, criação, edição e exclusao de veículos
3. Consulta, criação, edição e exclusao de viagens
4. Consulta de tempo estimado da viagem

------

## 3. 📊 Diagrama de Classes

O DER (Diagrama Entidade-Relacionamento) do projeto GoLady representa de forma visual como os dados estão organizados no banco de dados relacional e como as entidades se relacionam entre si.

```mermaid
classDiagram
class Viagem {

id : Long
distancia : float,
preco : BigDecimal,
horarioSaida : LocalDateTime,
horarioChegada : LocalDateTime,
veiculo : Veiculo,
usuario : Usuario

}

class Veiculo {
  
id : Long
modelo : String,
placa : String,
categoria: String,
velocidadeMedia : float,
viagem : List<Viagem>

}

class Usuario {
  
id : Long
avaliacao : float,
nome : String,
usuario : String,
telefone : String,
senha : String,
foto : String,
viagem : List<Viagem>

}
Veiculo "1" --> "0.." Viagem : é usado em
Usuario "1" --> "0.." Viagem : solicita

```

------

## 4. 🗺️ Diagrama Entidade-Relacionamento (DER)


```mermaid
erDiagram
tb_usuarios {
    bigint id PK
    float avaliacao
    varchar(255) nome
    varchar(255) usuario
    varchar(255) telefone
    varchar(5000) foto
    varchar(255) senha
}

tb_veiculos {
    bigint id PK 
    varchar(255) modelo
    varchar(255) placa
    varchar(255) categoria
    float velocidade_media 
}

tb_viagens {
    bigint id PK 
    float distancia
    float preco
    datetime horario_saida
    datetime horario_chegada
    bigint veiculo_id FK
    bigint usuario_id FK
}

tb_usuarios ||--o{ tb_viagens : "solicita"
tb_veiculos ||--o{ tb_viagens : "é usado em"

```

------

## 5. 🧰 Tecnologias utilizadas

| Item                          | Descrição      |
| ----------------------------- | -------------- |
| **Servidor**                  | Tomcat         |
| **Linguagem de programação**  | Java           |
| **Framework**                 | SpringBoot     |
| **ORM**                       | JPA + Hibernate|
| **Banco de dados Relacional** | MySQL          |

------

## 6. ▶️ Configuração e Execução

### 6.1 📦 Importando o Projeto

1. Clone o repositório do Projeto [GoLady](https://github.com/Projetos-Grupo-01/go_lady) dentro da pasta do *Workspace* do STS

```bash
https://github.com/Projetos-Grupo-01/go_lady
```

2. **Abra o STS** e selecione a pasta do *Workspace* onde você clonou o repositório do projeto
3. No menu superior do STS, clique na opção: **File 🡲 Import...**
4. Na janela **Import**, selecione a opção: **General 🡲 Existing Projects into Workspace** e clique no botão **Next**
5. Na janela **Import Projects**, no item **Select root directory**, clique no botão **Browse...** e selecione a pasta do Workspace onde você clonou o repositório do projeto
6. O STS reconhecerá o projeto automaticamente
7. Marque o Projeto GoLady no item **Projects** e clique no botão **Finish** para concluir a importação

<br />

### 6.2. ▶️ Executando o projeto

1. Na Guia **Boot Dashboard**, localize o  **Projeto GoLady**
2. Selecione o **Projeto GoLady**
3. Clique no botão **Start or Restart** <img src="https://i.imgur.com/wdoZqWP.png" title="source: imgur.com" width="4%"/> para iniciar a aplicação
4. Caso seja perguntado se você deseja autorizar o acesso ao projeto via rede, clique no botão **Permitir Acesso**
5. Acompanhe a inicialização do projeto no console do STS
6. Verifique se o banco de dados `db_golady` foi criado corretamente e se as tabelas foram geradas automaticamente.
7. Utilize o [Insomnia](https://insomnia.rest/) ou o [Postman](https://www.postman.com/) para testar os endpoints.
