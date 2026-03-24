

DOCUMENTAÇÃO: NAVEGAÇÃO ENTRE TELAS COM JETPACK COMPOSE


1. DESCRIÇÃO DO PROJETO
------------------------------------------------------------
Este projeto mostra como criar a navegação entre várias telas em um aplicativo Android usando Jetpack Compose e Navigation Compose.

2. OBJETIVO DA PROVA
------------------------------------------------------------
* Entender o papel do NavController como responsável por gerenciar a navegação.
* Explicar como as rotas são definidas dentro do NavHost.
* Aplicar a navegação entre telas usando navController.navigate().
* Compreender e implementar a passagem de parâmetros (via rota e query).
* Reconhecer a estrutura básica de um app com múltiplas telas em Compose.
* Aplicar boas práticas, como uso de innerPadding.
* Ler e interpretar código Kotlin com Compose.
* Modificar ou completar trechos de código.
* Criar novas rotas ou telas com base no padrão apresentado.
* Entender o fluxo de navegação entre as telas (Login -> Menu -> outras telas -> voltar).

3. O QUE FOI IMPLEMENTADO
------------------------------------------------------------
Foi implementado um app de exemplo com múltiplas telas, navegação entre elas, passagem de parâmetros e organização, servindo como base para entender como funciona a navegação no Compose.

4. FLUXO DE NAVEGAÇÃO
------------------------------------------------------------
* Login -> Menu
* Menu -> Perfil
* Menu -> Pedidos
* Menu -> Login (logout)
* Perfil -> Menu
* Pedidos -> Menu

5. ENVIO E RECEBIMENTO DE PARÂMETROS
------------------------------------------------------------
Os parâmetros como nome, idade e cliente foram passados direto na rota.
Exemplo de Envio: 
   onClick = { navController.navigate("perfil/Enzo Biloschycki/20") }

Exemplo de Recebimento (via arguments):
   val nome: String? = it.arguments?.getString("nome", "Usuário não cadastrado")

6. EXPLICAÇÃO DAS EVOLUÇÕES IMPLEMENTADAS
------------------------------------------------------------

A) PASSAGEM DE PARÂMETROS OBRIGATÓRIOS (TELA DE PERFIL)
   - MainActivity: Implementada a alteração da rota para aceitar um argumento dinâmico ({nome}).
     Rota: route = "perfil/{nome}"
     Captura: Valida o valor e atribui "Usuário não cadastrado" caso seja nulo.
   - Tela MenuScreen: O botão agora envia o nome durante a navegação.
     onClick = { navController.navigate("perfil/Enzo Biloschycki") }
   - Tela PerfilScreen: A função passou a receber e exibir o nome.
     fun PerfilScreen(..., nome: String) { Text(text = "PERFIL - $nome") }

B) PASSAGEM DE PARÂMETROS OPCIONAIS (TELA DE PEDIDOS)
   - MainActivity: A rota utiliza query parameter (?cliente={cliente}) com valor padrão.
     navArgument("cliente") { defaultValue = "Cliente não cadastrado" }
   - Tela MenuScreen: Insere o valor opcional no clique do botão.
     onClick = { navController.navigate("pedidos?cliente=Primeiro Cliente do dia") }

C) PASSAGEM DE MÚLTIPLOS PARÂMETROS (TIPAGEM)
   - MainActivity: Exige nome (String) e idade (Int) usando NavType. Os dados são recuperados e passados para a PerfilScreen com garantia de não serem nulos (!!).
     Arguments: navArgument("nome"){type = NavType.StringType}, navArgument("idade"){type = NavType.IntType}

============================================================
