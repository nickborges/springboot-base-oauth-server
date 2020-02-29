## springboot-base-oauth-server

### padrão grant_type=password precisa informar usuário e senha
###### para usar no postman, aba Authorization > Basic Auth > Username = valorDoClientId / Password = valorDoClientSecret
```curl -X POST \
  http://localhost:8080/oauth/token \
  -H 'Authorization: Basic Y2xpZW50OiQyYSQxMCROMGVxTml1aWtXQ3k5RVRRMXJkYXUuWEVFTGN5RU83a3Vra2ZvaU5JU2svOUY3Z3c2ZUIwVw==' \
  -d 'grant_type=password&username=test@test.com&password=Teste@1$2#vc'
```

<hr></hr>

### padrão grant_type=cliente_credentials não precisa informar usuário e senha
###### para usar no postman, aba Authorization > Basic Auth > Username = valorDoClientId / Password = valorDoClientSecret
```curl -X POST \
  http://localhost:8080/oauth/token \
  -H 'Authorization: Basic Y2xpZW50OiQyYSQxMCROMGVxTml1aWtXQ3k5RVRRMXJkYXUuWEVFTGN5RU83a3Vra2ZvaU5JU2svOUY3Z3c2ZUIwVw==' \
  -d 'grant_type=client_credentials'
```


###### para chamar o enpoint deve primeiro recuperar o token na chamada acima e depois passar o Bearer Token como no exemplo abaixo:
```curl --location --request GET 'http://localhost:8080/teste' \
--header 'Authorization: Bearer 2252a9c4-f659-4350-a8ca-0dce28e85a0b'
```