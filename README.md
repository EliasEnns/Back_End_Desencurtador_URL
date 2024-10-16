Requisitos:

Java, Maven e Docker.

Antes de começar:

Obtenha uma chave API, criando uma conta gratuita em: https://unshorten.me/api

Copie o arquivo Secret.txt para outro nomeado Secret.java no mesmo diretório em:

desencurtador\src\main\java\com\desencurtador\desencurtador\Secrets

e substitua ```"SUA_CHAVE_API"``` pela sua chave.

você terá um limite de 10 requisições por hora.

Compilando o código:

execute o comando para compilar o código:
mvn clean package

execute o comando para criar a instância no docker
docker-compose up --build

Utilizando a API:

Rotas GET:

http://localhost:8080/api/sobre

Deve retornar:
{
	"projeto": "Desencurtador de Links",
	"estudante": "Elias Enns e Michel Almeida da Rosa"
}

http://localhost:8080/api/consulta
Deve retornar um array com todas as URLs desencurtadas.

Rotas POST

http://localhost:8080/api/desencurtar

Recebe (Json):
{
	"shortUrl":"https://encurtador.com.br/RZS8r"
}

Retorna (string) URL desencurtada
https://www.reddit.com
