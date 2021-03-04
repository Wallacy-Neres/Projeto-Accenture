# Projeto-Accenture | Bankline
Projeto de cadastro e Login de usuário, para criação de conta bancária e lançamentos.

Sumário
=================
<!--ts-->
   * [Equipe de desenvolvedores](#Time-Oak)
   * [Estrutura do Projeto](#Estrutura-do-Projeto)
   * [Principais Funcionalidades](#Principais-Funcionalidades)
   * [Usuário](#Usuário)
   * [Conta](#Conta)
   * [Lancamento](#Lancamento)
   * [Plano Conta](#Plano-Conta)
   * [Dashboard](#Dashboard)
   * [Enums](#Enums)
   * [Spring Boot](#Spring-Boot)
   * [Implementações de Segurança](#Implementações-de-Segurança)
<!--te-->


 #  Time Oak
 
 Integrantes da equipe e suas contribuições:
 
 - Lucas: Cadastro de Plano de Contas padrão e de Lancamentos; e documentação da api no git
 - Murilo: Cadastro de Lançamento
 - Rafael: Cadastro de Usuário, Conta e Plano de Contas, extrato e listagem dos Planos de Contas
 - Wallacy: Login, autenticação com Token (JWT), extrato e listagem dos Planos de Contas
 - Wendell: Implementação da classe Conta, validação e autenticação com o Token (JWT)
 
 # Estrutura do Projeto
 
 O projeto foi estruturado dividindo as classes de acordo com as camadas ou categorias: <b>Package by Layer</b> 
 
 * <b>aplicattion:</b> <i> Main da aplicação</i>
 * <b>model:</b> <i> Package que contém as classes e mapeamento destas no banco</i>
 * <b>controller:</b> <i> Package contendo os controllers da aplicação</i>
 * <b>service:</b> <i> Package contendo os service da aplicação, intermediando a comunicação do controller com o repository</i>
 * <b>repository:</b> <i> Package contendo as classes que realizam as operações no banco</i>
 * <b>enums:</b> <i> Package contendo os Enum da aplicação</i>
 * <b>security:</b> <i> Package contendo a implementação e configurações de segurança e autenticação com Token (JWT)</i>
 
 
 # Funcionalidades
 - Cadastrar Usuário
 - Criação de Contas
 - Login
 - Cadastro de Plano de Conta
 - Realizar Lançamentos:
   - Receita
   - Despesa
   - Transferência entre contas
   - Transferência entre usuários
 - Vizualizar extrato
   - Vizualizar extrato por período
 - Vizualizar dados das conta
 
# Usuário
## model
O model tem os atributos:

codigo
Nome
CPF
Login
Senha

E anotações para mapeamento no banco.
Tem os getters e setter dos atributos.

## service
O service realiza as operações:
- Cadasrtrar Usuário
- Logar

Não pode cadastrar um usuário com um login ou CPF já existentes no sistema.
No cadastro de um novo usuário são criadas duas contas (Corrente e Crédito) além de um planos de contas (categoria) padrões:
- Receitas
- Despesas
- Trasnferência entre contas
- Transferência entre usuários

## controller
O Controller mapeia as rotas da API, que podem ser vistas com mais detalhes na documentação feita com o Swagger

## UsuarioLogin

### model
Essa classe é utilizada pelo controller para requisitar o Login
O model contem os seguintes atributos:
Codigo
Nome
Login
Senha
Token
Tem os gettes e setters

### UsuarioLoginDTO
Essa classe é utilizada para se comunicar com o cliente

Possui os seguintes atributos:
Nome
Login
Token


## UsuarioDTO
Classe modelo responsável por se comunicar com o o cliente

Possui os seguinte atributos:
Codigo
cpf
login
nome
senha
token

# Conta
## model

O model tem os atributos:

Id
Número (é igual ao login do usuário)
TipoConta (TipoConta Enum)
Saldo
usuario

E anotações para mapeamento no banco.
getters e setter dos atributos.

## controller
O Controller mapeia as rotas da API, que podem ser vistas com mais detalhes na documentação feita com o Swagger

## ContaDTO
Classe modelo responsável por se comunicar com o o cliente
Possui os seguintes atributos:

Id
Lista de Lancamentos
Saldo

# Lançamento

## model
O model tem os atributos:

Id
Id da Conta do Usuário
Número da conta do usuário
Data
Valor
Descrição
Tipo (TipoLancamento Enum)
Número da conta de destino (para o caso de transferência)

As anotações para mapeamento com o banco de dados. Essas anotações também servem para validar o lancamento impedindo valor.

Tem os getters e setter dos atributos.

## service
O service faz as validações para criação do lançamento.

O Id da conta do Usuário, número da conta, valor, descricao, tipo e plano de conta (categoria) não podem ser nulos.

Se for transferência a conta de destino não pode ser nula.
O número da conta do usuário e de destino devem ser de contas já cadastradas no sistema.

Caso seja um débito ou uma transferência o valor não deve deixar o saldo negativo.
No caso de um crédtio, o valor passado será adicionado ao saldo da conta.

No caso de um débito, o valor passado será subtraido do saldo da conta.

No caso de uma transferência, o valor passado será subtraido do saldo da conta do usuário e adicionado no saldo da conta do destinatário

## controller
O Controller mapeia as rotas da API, que podem ser vistas com mais detalhes na documentação feita com o Swagger

# Plano Conta

## model
O model tem os atributos:

Id
Tipo (Tipoovimento Enum)
Descrição
Id Usuário
Padrão
Tem os getters e setter dos atributos.

## service
O service é responsável por:
- Cadastrar Plano de Conta
- Listar todos os planos de contas
- Listar planos de contas de um usuário

## controller
O Controller mapeia as rotas da API, que podem ser vistas com mais detalhes na documentação feita com o Swagger


## PlanoContaDTO
Classe modelo responsável por se comunicar com o o cliente
possui os seguintes atributos:

# Dashboard
O service faz a busca dos dados necessário no dashboard do stema. Também faz a busca dos lançamentos para o extrato por data de início e fim.

O Controller mapeia as rotas da API, que podem ser vistas com mais detalhes na documentação feita com o Swagger

## ExtratoDTO
Essa classe é responsável por modelar a resposta do dashboard para o cliente

O model possui os seguintes atributos:
ContaDebitoId
ContaDebitoSaldo
ContaDebitoLancamentos
DataInicio
DataFim
ContaCreditoId
ContaCreditoSaldo
ContaCreditoLancamentos

#Enums 
## TipoConta Enum
- CORRENTE
- CREDITO
- 
## TipoPlanoConta Enum
R: Receita
D: Despesa
TC: Transferência entre Contas
TU: Transferência entre Usuários

# SPRING BOOT
A API será um Bankline com funcionalidades específicas, hospedada no Swagger para apresentação do projeto final e posteriores checagens realizadas por terceiros.

# Implementações de segurança
A api faz uso de Jason Web Token (JWT) para autenticação de endpoints durante o uso da mesma além do Spring Security para configurações internas de BackEnd.

## Como funciona?
Ao criar o usuário, o sistema de login fica disponível, habilitando o acesso pelo endpoint

Após o login o endpoint retornará uma resposta contendo os dados de autenticação, contendo um token bearer que será filtrado pela implemetação do JWT no Java, o que permitirá o acesso as demais funcionalidades.
