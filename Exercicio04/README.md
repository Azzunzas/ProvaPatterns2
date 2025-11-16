Exercicio 04

Contexto: Desenvolva um sistema de validação de documentos fiscais eletrônicos (NF-e) que precisa aplicar múltiplas regras de validação em cadeia.
Problema:
- Cada validador especializado verifica um aspecto específico do documento
- A cadeia deve suportar validações condicionais (se validador X falhar, pule Y)
- Implemente um mecanismo de "circuit breaker" que interrompa a cadeia após 3 validações falharem
- Adicione capacidade de rollback para validadores que modificam o documento
  Validadores Requeridos:
1. handler.Validador de Schema XML contra XSD
2. handler.Validador de Certificado Digital (expiração e revogação)
3. handler.Validador de Regras Fiscais (cálculo de impostos)
4. handler.Validador de Banco de dados (duplicidade de número)
5. handler.Validador de Serviço SEFAZ (consulta online)
   Restrições:
- Os validadores 3 e 5 devem ser executados apenas se os anteriores passarem
- O validador 4 deve fazer rollback da inserção se validações subsequentes falharem
- Implemente timeout individual para cada validador


MOTIVO DA ESCOLHA DO PATTERN **CHAIN OF RESPONSIBILITY:**
-
- FORNECER OPORTUNIDADE DE VARIOS OBJETOS PROCESSAREM UMA SOLICITAÇÃO.
- CADA VALIDADOR DECIDE SE PASSA PARA O PRÓXIMO OU INTERROMPE
- HÁ UM SEQUENCIA DE NÍVEIS DE TRATAMENTO
- O CLIENTE NÃO PODE SABER A LÓGICA POR TRÁS.