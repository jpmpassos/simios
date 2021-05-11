## Chave assimetrica

Será necessário uma chave assimétrica para acessar as intâncias 

Abaixo segue o comando para gerar essa chave:
```markdown
ssh-keygen -t rsa -b 4096 -o -a 100 -f key/simios_key
```

OBS: O comando deve ser dentro do diretório terraform.