<h1 align="center">
  :scissors::link: Encurtador de URL
</h1>
<p align="center">
  <a href="#rocket-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#arrow_forward-como-rodar">Como usar</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</p>

<br>


## :rocket: Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:
- [Java] (https://docs.oracle.com/en/java/)
- [Spring Framework](https://spring.io/)
- [Postgresql] (https://www.postgresql.org/)

## 💻 Projeto

Esse projeto é uma API REST desenvolvida, utilizando [Spring Framework](https://spring.io/) e [Postgresql] (https://www.postgresql.org/) . Com objetivo de prover um serviço de encurtamento de Urls. O serviço inicialmente recebe como parâmetro uma URL e devolve uma Url menor que dará acesso ao destino da URL original.



## :arrow_forward: Como Usar

- Para efeito de testes o projeto foi implantado na nuvem utilizando a plataforma Railway.
e pode ser acessado por meio do link (urlencurtador-production.up.railway.app)

### Endpoints
# :arrow_forward: Listar todas
Por meio da URL (urlencurtador-production.up.railway.app) é possível visualizar uma lista com todas as urls encurtadas e suas respectivas chaves aleatorias geradas.
# :arrow_forward: Encurtar url
Por meio de uma requisição POST para a URL (urlencurtador-production.up.railway.app/encurtar) é possível gerar uma URL encurtada.
obs: O corpo da requisição deve estar em formato JSON, seguindo a seguinte estrutura:
        {
            "fullurl":"www.google.com"
        }
# :arrow_forward: Encurtar url
Para acessar uma URL apartir de uma Url encurtada, deve se acessar (urlencurtador-production.up.railway.app/s/"chave aleatoria") 

Ex: urlencurtador-production.up.railway.app/s/rjpKM
                                                                                                        


