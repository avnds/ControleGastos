# ControleGastos

## Informações do aluno

**Nome:** André Valder Nobre de Sousa
**Matrícula:** (cpf) =00307833305
**Email:** andre.valder@gmail.com
**Data:** 02/10/2026

---

## 1. Justificativa

Escolhi desenvolver um aplicativo de **Controle de Gastos Pessoais** porque é um sistema simples e útil para registrar e acompanhar despesas do dia a dia.

A ideia é permitir que o usuário cadastre seus gastos, informe o valor e a categoria da despesa, podendo visualizar os registros posteriormente.

O projeto também me permite aplicar os conceitos estudados: arquitetura MVVM, banco de dados local e navegação entre telas.

A idéia é evoluir o app e publicar na playstore com funcionalidades que talvez gere interesse de outras pessoas. 

---

## 2. Descrição do aplicativo

O **ControleGastos** é um aplicativo Android desenvolvido para realizar o controle básico de gastos pessoais.

O usuário pode:

* Cadastrar um novo gasto;
* Informar a descrição da despesa;
* Informar o valor;
* Informar a categoria;
* Visualizar os gastos cadastrados;
* Visualizar o valor total dos gastos;
* Excluir um gasto cadastrado.

Os dados são armazenados localmente no dispositivo utilizando o banco de dados **Room**, permitindo que os gastos continuem disponíveis mesmo depois de fechar e abrir o aplicativo novamente.

---

## 3. Tecnologias utilizadas

O projeto foi desenvolvido utilizando:

* **Kotlin**
* **Android Studio**
* **Jetpack Compose**
* **Navigation Compose**
* **Room Database**
* **SQLite**
* **MVVM**
* **Kotlin Coroutines**
* **Git e GitHub**

---

## 4. Estrutura do projeto

O projeto foi dividido em camadas para separar as responsabilidades de cada parte do aplicativo.

```text
com.andre.controlegastos
│
├── data
│   ├── Gasto.kt
│   ├── GastoDao.kt
│   ├── AppDatabase.kt
│   └── GastoRepository.kt
│
├── viewmodel
│   └── GastoViewModel.kt
│
├── ui
│   ├── ListaGastosScreen.kt
│   └── CadastroGastoScreen.kt
│
└── MainActivity.kt
```

### Camada Data

A camada `data` é responsável pelos dados do aplicativo.

A classe `Gasto` representa a entidade que será armazenada no banco de dados.

O `GastoDao` possui as operações para inserir, listar e excluir gastos.

O `AppDatabase` cria e gerencia o banco de dados Room.

O `GastoRepository` faz a comunicação entre o banco de dados e o ViewModel.

### Camada ViewModel

A classe `GastoViewModel` concentra a lógica relacionada aos gastos.

Ela recebe as informações da interface e solicita ao Repository que realize as operações no banco de dados.

Também utiliza `viewModelScope` para executar as operações de forma assíncrona.

### Camada UI

A camada `ui` contém as telas do aplicativo.

A `ListaGastosScreen` apresenta os gastos cadastrados e o valor total.

A `CadastroGastoScreen` permite inserir um novo gasto.

---

## 5. Banco de dados

Foi utilizado o **Room Database**, que utiliza o SQLite internamente para armazenar os dados.

A tabela principal do projeto é:

### gastos

| Campo     | Tipo   | Descrição              |
| --------- | ------ | ---------------------- |
| id        | Int    | Identificador do gasto |
| descricao | String | Descrição da despesa   |
| valor     | Double | Valor do gasto         |
| categoria | String | Categoria da despesa   |

O campo `id` é gerado automaticamente pelo banco de dados.

---

## 6. Arquitetura MVVM

O projeto utiliza o padrão arquitetural **MVVM (Model-View-ViewModel)**.

A divisão funciona da seguinte maneira:

```text
Usuário
   ↓
Interface (Compose)
   ↓
ViewModel
   ↓
Repository
   ↓
DAO
   ↓
Room / SQLite
```

A interface é responsável pela apresentação dos dados.

O ViewModel controla a lógica da tela.

O Repository organiza o acesso aos dados.

O DAO realiza as operações no banco.

O Room é responsável pela persistência dos dados.

---

## 7. Telas do aplicativo

### Tela principal

A tela principal apresenta:

* Título do aplicativo;
* Total dos gastos;
* Botão para adicionar um gasto;
* Lista dos gastos cadastrados;
* Botão para excluir cada gasto.

### Tela de cadastro

A tela de cadastro possui campos para:

* Descrição;
* Valor;
* Categoria.

Depois de preencher os campos, o usuário pode selecionar **Salvar** para cadastrar o gasto.

---

## 8. Navegação

Foi utilizado o **Navigation Compose** para realizar a navegação entre as telas.

As principais rotas utilizadas são:

```text
lista
cadastro
```

A tela `lista` é a tela inicial do aplicativo.

Ao selecionar **Adicionar gasto**, o aplicativo navega para a tela `cadastro`.

Depois de salvar ou selecionar voltar, o usuário retorna para a tela principal.

---

## 9. Persistência dos dados

Os gastos cadastrados são armazenados no banco de dados local:

```text
controle_gastos.db
```

Dessa forma, os dados não ficam apenas na memória da aplicação.

Ao fechar e abrir novamente o aplicativo, os gastos continuam armazenados no dispositivo.

---

## 10. Observações

O projeto foi desenvolvido com foco em uma aplicação simples, utilizando os conceitos solicitados na atividade.

Durante o desenvolvimento foram utilizados:

* Jetpack Compose para construção das interfaces;
* Navigation Compose para navegação;
* Room para persistência dos dados;
* MVVM para organização do código;
* Kotlin Coroutines para operações assíncronas;
* Git e GitHub para controle de versão.

O projeto foi desenvolvido com o objetivo de demonstrar na prática a utilização dessas tecnologias em uma aplicação Android.

---

## 11. Repositório

O código-fonte do projeto está disponível no GitHub:

**https://github.com/avnds/ControleGastos**
