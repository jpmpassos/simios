## Projeto Simios

Projeto que disponibilisa um backend com dois serviços: um POST `simian` e um GET `stats`.

### Para criar uma imagem com o projeto e enviar par o DockerHub

Para realizar um build da imabem e enviar para o dockerho é preciso realizar os seguintes passos:

Primeiro deve realizar build do jar:

```markdown
mvn clean intall
```

Realizar um build da nossa imagem:

```markdown
docker build -t jpmpassos/simios:0.1 .
```

Logar no seu dockerhub:

```markdown
docker login --username <nome de usuário> --password <senha>
```

E por fim subir a imagem para o DockerHub:

```markdown
docker push jpmpassos/simios:0.1
```

### Para rodar essa imagem do projeto

Depois de configurar o arquivo `application.properties` com as informações de usuário senha e host do banco de dados.

```markdown
docker run -p 8080:8080 --rm --network medinapassos-net -e APP_OPTIONS='--spring.datasource.password=admin123
--spring.datasource.username=simiosuser --spring.datasource.url=jdbc:postgresql://simiosdb:5432/simios'
jpmpassos/simios:0.1
```

Obs: Deve-se lembrar que o --rm deve ser usado apenas para desenvolvimento, pois o mesmo remove o container após
finalizar. Também deve adicionar o -d para não finalizar o container quando sair do shell.