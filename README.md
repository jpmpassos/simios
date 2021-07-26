## Projeto Simios

Projeto que disponibilisa um backend com dois serviços: um POST `simian` e um GET `stats`.

### Executar na máquina local

Devemos agora criar uma rede para a aplicação e o container do banco se conectem. 
```markdown
docker network create medinapassos-net
```

Para rodar esse projeto, é necessário ter uma instância de um banco Postgresql com o nome simios.

Para criar o banco usando o docker basta utilizar os comandos abaixo.
```markdown
docker run -p 5432:5432 --network medinapassos-net --name simiosdb -e POSTGRES_USER=simiosuser -e POSTGRES_PASSWORD=admin123 -e POSTGRES_DB=simios -d postgres:10.5-alpine
```

Agora basta executar a aplcação.
