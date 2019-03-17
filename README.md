# springboot-base-oauth-server

curl -X POST \
  http://localhost:8080/oauth/token \
  -H 'Authorization: Basic Y2xpZW50OiQyYSQxMCROMGVxTml1aWtXQ3k5RVRRMXJkYXUuWEVFTGN5RU83a3Vra2ZvaU5JU2svOUY3Z3c2ZUIwVw==' \
  -d 'grant_type=password&username=test@test.com&password=Teste@1$2#vc'