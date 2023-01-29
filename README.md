# Api de produtos para estudos

## Projeto desenvolvido com as sequintes tecnologias;
- Java
- Spring Boot
- Banco de dados MongoDB
- Spock para os testes

## Com a seguinte representação de produto:
```json
{
  "codigo": 43264,
  "nome": "CDB Banco XPTO",
  "classesInvestimento": [
    {
      "codigo": 1234,
      "nome": "Pos Fixado",
      "risco": 2
    },
    {
      "codigo": 4567,
      "nome": "CDB",
      "risco": 1
    }
  ],
  "risco": 1.5
}
```

## Crie endpoints para as seguintes ações:

- [x] Criação de produto onde o payload será o json informado acima (exceto a propriedade risco do produto - produto.risco)

- [x] Edição de produto por codigo

- [x] Recuperação de produto por codigo

- [x] Deleção de produto por codigo


## Requisitos

- [x] Toda vez que um produto for recuperado por codigo deverá ser calculado a propriedade: produto.risco

- [x] A propriedade produto.risco é a médica dos riscos das classes de investimento do produto

- [x] Não deve permitir a criação de produtos iguais
  - Dois produtos são considerados iguais se os seus codigos forem iguais

- [x] Ao atualizar um produto, o antigo deve ser sobrescrito com o que está sendo enviado na requisição

- [x] A requisição deve receber o codigo e atualizar com o produto que tbm está vindo na requisição

## Pontos importantes que foram vistos nesse pequeno projeto.

        - Consolidar e evoluir conceitos de orientação a objetos.

        - Consolidar conceitos e utilização do Spring.

        - Consolidar conceitos e boas práticas de APIs REST.

        - Consolidar conceitos e utilização de testes (unitários e integrados) automatizados com Spock (Groovy).

        - Melhorar/familiarizar com infra montando ambiente local.