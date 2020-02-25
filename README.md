# springboot-base-oauth-server

##padrão grant_type=password precisa informar usuário e senha
curl -X POST \
  http://localhost:8080/oauth/token \
  -H 'Authorization: Basic Y2xpZW50OiQyYSQxMCROMGVxTml1aWtXQ3k5RVRRMXJkYXUuWEVFTGN5RU83a3Vra2ZvaU5JU2svOUY3Z3c2ZUIwVw==' \
  -d 'grant_type=password&username=test@test.com&password=Teste@1$2#vc'
  
  ### para usar no postman, aba Authorization > Basic Auth > Username = clientId / Password = clientSecret

<hr></hr>

##padrão grant_type=cliente_credentials não precisa informar usuário e senha
curl -X POST \
  http://localhost:8080/oauth/token \
  -H 'Authorization: Basic Y2xpZW50OiQyYSQxMCROMGVxTml1aWtXQ3k5RVRRMXJkYXUuWEVFTGN5RU83a3Vra2ZvaU5JU2svOUY3Z3c2ZUIwVw==' \
  -d 'grant_type=client_credentials'
  
  ### para usar no postman, aba Authorization > Basic Auth > Username = clientId / Password = clientSecret