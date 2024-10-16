# 🚀 Desencurtador de Links - API

Este projeto é uma API desenvolvida em Java que permite desencurtar URLs, retornando o link original de URLs encurtadas. Ele utiliza a API do Unshorten.me para realizar o processo de desencurtamento de forma simples e eficiente.

## 🛠️ Requisitos

- **Java** (versão 8 ou superior)
- **Maven** (para gerenciamento de dependências)
- **Docker** (para execução em container)

## ⚙️ Preparação

Antes de iniciar o uso da API, siga os passos abaixo:

1. **🔑 Obtenha uma chave API**: Crie uma conta gratuita em [Unshorten.me](https://unshorten.me/api) e obtenha sua chave API.
2. **📁 Configuração do arquivo de segredo**: 
   - Copie o arquivo `Secret.txt` para outro arquivo nomeado `Secret.java`, localizado no diretório:  
     `desencurtador/src/main/java/com/desencurtador/desencurtador/Secrets/`.
   - Substitua a string `"SUA_CHAVE_API"` pela chave API obtida no passo anterior.
3. **⏳ Limitações**: A API gratuita possui um limite de 10 requisições por hora.

## 🧑‍💻 Compilando e Executando o Projeto

### 📦 Compilação

Para compilar o código, execute o seguinte comando no diretório raiz do projeto:

```bash
mvn clean package
```
### 🐳 Execução com Docker

Para criar e iniciar o container Docker:

```bash
docker-compose up --build
```

## 🔗 Endpoints da API

**`GET`** /api/sobre

Retorna informações sobre o projeto.

Exemplo de resposta:

```json
{
  "projeto": "Desencurtador de Links",
  "estudante": "Elias Enns e Michel Almeida da Rosa"
}
```

**`GET`** /api/consulta

Retorna um array com todas as URLs desencurtadas até o momento.

Exemplo de resposta:

```plaintext
[
  "https://www.reddit.com",
  "https://www.example.com"
]
```

**`POST`** /api/desencurtar

Envia uma URL encurtada para ser desencurtada.

Corpo da requisição (JSON):
```json
{
  "projeto": "Desencurtador de Links",
  "estudante": "Elias Enns e Michel Almeida da Rosa"
}
```

Exemplo de resposta:

```plaintext
https://www.reddit.com
```

## ℹ️ Observações

O limite de requisições por hora depende do plano gratuito da Unshorten.me.

Esta API foi desenvolvida como parte de um projeto acadêmico por Elias Enns e Michel Almeida da Rosa.

