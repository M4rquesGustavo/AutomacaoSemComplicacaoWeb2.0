# language: pt
# login.feature

Funcionalidade: Login via Modal de Autenticação
  Como um usuário do sistema
  Quero interagir com a modal de login
  Para acessar o sistema ou navegar para criação de conta

  Contexto:
    Dado que a modal de login esteja sendo exibida

  # -------------------------------
  # Comportamento da Modal
  # -------------------------------

  Cenário: Fechar a modal ao clicar fora da mesma
    Quando for realizado o clique fora da modal
    Então a janela modal deve ser fechada

  Cenário: Fechar a modal ao clicar no ícone de fechar
    Quando for realizado o clique no ícone de fechar
    Então a janela modal deve ser fechada

  # -------------------------------
  # Navegação
  # -------------------------------

  Cenário: Acessar o link Create New Account
    Quando for realizado um clique no link Create New Account
    Então a página de criação de conta deve ser exibida

  # -------------------------------
  # Login - Cenários Positivos
  # -------------------------------

  Cenário: Realizar login com campos obrigatórios válidos
    Quando os campos de login forem preenchidos com dados válidos:
      | campo    | valor  |
      | login    | valido |
      | password | valido |
      | remember | true   |
    E for realizado um clique no botão Sign In
    Então o usuário deve ser autenticado com sucesso

  # -------------------------------
  # Login - Cenários Negativos
  # -------------------------------

  Cenário: Tentar realizar login com credenciais inválidas
    Quando os campos de login forem preenchidos com dados inválidos:
      | campo    | valor    |
      | login    | invalido |
      | password | invalido |
      | remember | false    |
    E for realizado um clique no botão Sign In
    Então o sistema deve exibir uma mensagem de erro de autenticação

  Cenário: Tentar realizar login sem preencher campos obrigatórios
    Quando nenhum campo obrigatório for preenchido
    Então o botão Sign In deve permanecer desabilitado
