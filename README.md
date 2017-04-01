# prova-java

- Recursos necessários: Java 7+, Maven e servidor de preferência (ex. Tomcat);
- Para gerar pacote dos Ex. 1 e 2: mvn install

## Exercício 1

- Utilizando Spring MVC
- Dados de retorno do CEP estão mockados. Os dois CEPS válidos retornados pelo mock são:
  - 11770000 (ou 1177 + 4 dígitos quaisquer)
  - 11718000 (ou 1177 + 4 dígitos quaisquer)
<br/>

### GET /address/get/zipcode/{zipcode}

- Onde zipcode = CEP<br/>
- Exemplo de retorno: 

```javascript
{
"street": "Rua 2",
"district": "Bairro 2",
"city": "Cidade 3",
"state": "SP",
"country": "Brasil",
"zipcode": "11718000"
}
```

## Exercício 2

- Utilizando Spring MVC
- Utilizado H2 para salvar dados em memória e Hibernate para persistência. As configurações de tipo de BD e conexão podem ser modificadas no arquivo persistence-context.xml.
- A url do serviço de CEP pode ser alterada em application.properties

### /address POST

Descrição: Insere endereço.
Opcionais: District e complement. Demais obrigatórios.

```javascript
{
    "street": "Rua Josefa Alves de Siqueira",
    "streetNumber": "174",
    "district": "Bairro",
    "city": "Cidade",
    "complement": "Complemento", 
    "state": "SP",
    "country": "BR",
    "zipcode": "11718000"
}
```

Response Status:<br/>
201: Created<br/>
400: Invalid Address or Invalid Zipcode.<br/>

### /address/{id} PUT

Descrição: Atualiza endereço.

```javascript
{
    "street": "Rua Josefa Alves de Siqueira",
    "streetNumber": "174",
    "district": "Bairro",
    "city": "Cidade",
    "complement": "Complemento", 
    "state": "SP",
    "country": "BR",
    "zipcode": "11718000"
}
```

Response Status:<br/>
200: Ok<br/>
400: Invalid Address or Invalid Zipcode.<br/>
404: Address not found for this code.<br/>

### /address GET

Descrição: Lista todos endereços. Exemplo response body:

```javascript
[
  {
    "id": 2,
    "street": "Rua Josefa Alves de Siqueira",
    "streetNumber": 174,
    "district": null,
    "complement": null,
    "city": "Praia Grande",
    "state": "SP",
    "country": "BR",
    "zipcode": "11770000"
  }
]
```
Response Status:<br/>
200: Ok<br/>

### /address/{id} GET

Descrição: Busca endereço por id. Exemplo response body:

```javascript
  {
    "id": 2,
    "street": "Rua Josefa Alves de Siqueira",
    "streetNumber": 174,
    "district": null,
    "complement": null,
    "city": "Praia Grande",
    "state": "SP",
    "country": "BR",
    "zipcode": "11770000"
  }
  ```

Response Status:<br/>
200: Ok<br/>
404: Address not found for this code.<br/>

### /address/{id} DELETE

Descrição: Apaga endereço por id.

Response Status:<br/>
200: Ok<br/>
404: Address not found for this code.<br/>

## Exercício 3

- Maven install gera um jar
- Pela classe Main é possível rodar a aplicação e alterar a string de verificação.
- No caso de String vazia, ou caractere não encontrado nas condições, é printado Element not found.
