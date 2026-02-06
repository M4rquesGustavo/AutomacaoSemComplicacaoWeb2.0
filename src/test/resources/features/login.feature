# language: pt

Funcionalidade: Login do usuario
  Como um usuario do sistema
  Quero realizar login
  Para acessar minha conta

  Contexto:
    Dado que o usuario esteja na pagina principal

  # -------------------------------
  # Login - Cenario Positivo
  # -------------------------------

  Cenario: Realizar login com credenciais validas
    Quando os campos de login forem preenchidos com dados validos:
      | email    | gustavomarques@gmail.com |
      | password | gustavo |
    E for realizado um clique no botao Login
    Entao o usuario deve ser autenticado com sucesso

  # -------------------------------
  # Login - Cenario Negativo
  # -------------------------------

  Cenario: Login com email e senha invalidos
    Quando os campos de login forem preenchidos com dados invalidos:
      | email    | invalido@teste.com |
      | password | invalido123 |
    E for realizado um clique no botao Login
    Entao o sistema deve exibir uma mensagem de erro de autenticacao

  Cenario: Login com senha em branco
    Quando os campos de login forem preenchidos com dados invalidos:
      | email    | invalido@teste.com |
      | password |                    |
    E for realizado um clique no botao Login
    Entao o sistema deve exibir uma mensagem de erro de autenticacao