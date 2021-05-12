## Ansible

Após criar a infra com o Terraform, devemos rodar o comando './run-ansible.sh' para adicionar docker, docker swarn e o Portainer nas instancias EC2.

Abaixo segue os comandos:
```markdown
./run-ansible.sh
```

Assim podemos entrar ssh da EC2 para conferir:
```markdown
ssh -i key/simios_key ec2-user@<ip_do_ec2_manager>
```

Também podemos acessar o portainer para visualizar:
```markdown
http://<ip_do_ec2_manager>:9000
```

Agora dentro do EC2 devemos rodar o comando para criar nosso container da aplicação no docker swarn.
```markdown
sudo docker service create --name simios -e APP_OPTIONS='jdbc:postgresql://URL_DO_RDS_DA_SUA_CONTA:5432/simios' 
     -p 8080:8080 --network service <NOME_IMAGEM>:<VERSAO>
```

Para executar o container sem usar o docker swarn deve rodar o seguinte comando:

```markdown
sudo docker run -d -p 8080:8080 
    -e APP_OPTIONS='--spring.datasource.password=admin123 
                    --spring.datasource.username=simiosuser 
                    --spring.datasource.url=jdbc:postgresql://URL_BANCO_DE_DADOS:5432/simios' 
    jpmpassos/simios:0.1
```


OBS: Os comandos devem ser executados em uma única linha.
