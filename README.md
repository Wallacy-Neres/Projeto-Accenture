# Projeto-Accenture | Bankline
Projeto de cadastro e Login de usuário, para criação de conta bancária e lançamentos.

Sumário
=================
<!--ts-->
   * [Equipe de desenvolvedores](#Time-Oak)
   * [Estrutura do Projeto](#Estrutura-do-Projeto)
   * [Principais Funcionalidades](#Principais-Funcionalidades)
<!--te-->


 #  Time Oak
 
 Integrantes da equipe e suas contribuições:
 
 - Lucas: Implementou o cadastro de Plano de Contas padrão
 - Murilo: 
 - Rafael: 
 - Wallacy: 
 - Wendell: 
 
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
 
