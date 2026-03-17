# Atividade-kotlin

Este projeto demonstra como implementar a navegação entre múltiplas telas em um aplicativo Android utilizando **Jetpack Compose** e **Navigation Compose**.

## ✨ Funcionalidades
- Tela de **Login**
- Tela de **Menu** com navegação para outras telas
- Tela de **Perfil** (recebe parâmetros via rota)
- Tela de **Pedidos** (recebe parâmetros via query)
- Navegação controlada por **NavController**
- Layouts modernos e responsivos com Compose


## 📱 Estrutura das Telas
- **LoginScreen**: Tela inicial, com botão para acessar o menu.
- **MenuScreen**: Exibe opções para navegar para Perfil, Pedidos ou sair.
- **PerfilScreen**: Mostra informações do perfil, recebendo parâmetros pela rota.
- **PedidosScreen**: Exibe pedidos, recebendo parâmetros via query string.

## 🧭 Como funciona a navegação?
- O **NavController** é criado na `MainActivity` e passado para cada tela.
- As rotas são definidas no `NavHost`.
- Cada tela pode navegar para outra usando o `navController.navigate()`.

## 🔄 Fluxo de Navegação entre Telas

A navegação entre as telas do aplicativo segue o fluxo ilustrado abaixo:

![Fluxo de navegação entre telas]

- **Login → Menu:** Ao clicar em "ENTRAR" na tela de Login, o usuário é direcionado para a tela de Menu.
- **Menu → Perfil:** O botão "Perfil" leva o usuário para a tela de Perfil.
- **Menu → Pedidos:** O botão "Pedidos" leva o usuário para a tela de Pedidos.
- **Menu → Sair:** O botão "Sair" retorna o usuário para a tela de Login.
- **Perfil → Menu:** O botão "Voltar" na tela de Perfil retorna para o Menu.
- **Pedidos → Menu:** O botão "Voltar" na tela de Pedidos retorna para o Menu.

As setas amarelas representam a navegação principal (avanço), enquanto as setas roxas representam o retorno para a tela anterior.

Esse fluxo garante uma navegação simples e intuitiva, permitindo que o usuário acesse facilmente as principais funcionalidades do app e retorne ao menu sempre que desejar.

> **Observação:** Para visualizar a imagem do fluxo, salve o diagrama acima como `docs/navigation-flow.png` no seu projeto.

## 📂 Estrutura de Pastas
```
app/
 └── src/
      └── main/
           └── java/
                └── biloschycki/com/TrabalhoPedidos/
                     ├── MainActivity.kt
                     └── screens/
                          ├── LoginScreen.kt
                          ├── MenuScreen.kt
                          ├── PerfilScreen.kt
                          └── PedidosScreen.kt
```

## 📱Imagens da Aplicação
![image alt](https://github.com/Biloschycki/atividade-kotlin/blob/main/Captura%20de%20tela%202026-03-17%20203330.png)
![image alt](https://github.com/Biloschycki/atividade-kotlin/blob/main/Captura%20de%20tela%202026-03-17%20203346.png)
![image alt](https://github.com/Biloschycki/atividade-kotlin/blob/main/Captura%20de%20tela%202026-03-17%20203356.png)
![image alt](https://github.com/Biloschycki/atividade-kotlin/blob/main/Captura%20de%20tela%202026-03-17%20203405.png)
```

