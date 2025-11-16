Exercício 01.
-
Contexto: Você está desenvolvendo um sistema de processamento de dados para uma empresa financeira que lida com diferentes tipos de análise de risco. O sistema precisa calcular métricas de risco usando diferentes algoritmos (Value at Risk, Expected Shortfall, Stress Testing) que podem mudar dinamicamente durante a execução.
Problema:
- Cada algoritmo de risco deve ser intercambiável em tempo de execução
- Os algoritmos devem ser capazes de compartilhar um contexto complexo com múltiplos parâmetros financeiros
- Deve ser possível trocar de algoritmo de acordo com a necessidade de negócios
  Restrições:
- O cliente deve poder mudar de algoritmo sem conhecer os detalhes de implementação
- Implemente pelo menos 3 algoritmos diferentes com cálculos dummy (podem ser mensagens de texto) distintos


- MOTIVOS DA ESCOLHA DO PATTERN **STRATEGY:**
  - 
  - Permite trocar algoritmos de risco em tempo de execução.
  - O cliente não vai conhecer os detalhes de implementação.

- Motivos técnicos:
  -
  - Permite que eu crie um contrato entre estruturas de funcionamento similares.
  - Evita bagunça de código.