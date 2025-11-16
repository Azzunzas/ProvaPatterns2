**Exercicio 02**
-

Contexto: Sua empresa está integrando com um legado bancário que possui uma interface complexa para processamento de transações. A interface legada `SistemaBancarioLegado` possui métodos com assinaturas incompatíveis e usa tipos de dados obsoletos.
Problema:
- Converter a interface atualizada ProcessadorTransacoes (com métodos autorizar(String cartao, double valor, String moeda)) para a interface legada
- O sistema legado usa: processarTransacao(HashMap<String, Object> parametros)
- Implemente de forma que o funcionamento seja bidirecional, ou seja, que também permita converter respostas do legado para o formato atualizado
- Adicione tratamento para campos obrigatórios do legado que não existem na interface moderna (ao menos um)
  Restrições:
- O legado exige codificação específica para moedas (USD=1, EUR=2, BRL=3)


**Motivos da escolha do Pattern Adapter:**
-
- usamos esse pattern para "juntar"/"fazer funcionar" dois tipos diferentes de 
estrutura. 
- necessidade de não refazer código.
- 