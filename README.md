### Farmacia Tarefas


##### Separador Relatorios

- [x] Criar Classe Relatorio | Rafael
    - [x] Ver todas as compras | Rafael
    - [ ] Ver todos os medicamentos do mes inseridos
    - [ ] Ver produtos fora de stock
- [ ] Remover Relatório
- [ ] Apresentar ultimos relatórios
- [ ] Apresentar alertas
- [ ] Melhorar o layout 
- etc..


##### Layout 
- [x] Criar layout | Hugo
- [x] Painel Vendas já com combobox a inicializar com dados corretos | hugo

##### Painel Home
- [ ] Calcular o valores para apresentar
    - [ ] Apresetar vendas mensais
    - [x] Apresentar Quantidade de vendas | Rafel
    - [x] Apresentar Total de Novos Clientes | Rafael
    - [x] Apresentar Produto mais Vendido | Rafael
- [ ] Calcular os medicamentos certos para apresentar nos Produtos Recentes
- [ ] Apresentar os medicamentos em armazem


##### Painel Vendas
- [x] Colocar botão para procurar clientes | Rafael
- [ ] Botão para criar um novo cliente -> pode ser um "link" para o form clientes
- [X] Calcular e apresentar dados de compra | Rafael
- [ ] Apresentar os detalhes para os dados que forem selecionados na JList 


##### Panel Gerir
- [x] Jlist com os medicamentos | Hugo
- [x] Painel Info com informação detalhada do medicamento selecionado na JList e já com stock | Hugo
- [x] Botões Editar para editar um medicamento  Hugo
- [x] Scroll Panel para a listagem | Hugo Rafael
- [x] Adicionar Medicamento | Hugo Rafael
- [x] Remover Medicamento | Hugo Rafael
- [x] JList sempre atualizada adicionando ou removendo medicamentos | Hugo Rafael
- [ ] Botão pesquisar por nome e apresentar na JList

##### Cat Via Admin 
- [x] Inserir os itens | Hugo


##### Medicamentos
- [x] Criar Classe Medicamento 
- [x] Fiz update em vez de Medicamentos[] para ArrayList, tirando assim a quantidade;
    - [x] id,ArrayList ,data_validade | Hugo
- [x] Adicionar funcao para verificar validade (boolean)
- [ ] Adicionar Exceptions

##### Armario
- [x] Criar Classe Armario
- [x] Adicionar medicamento
- [x] Remover medicamento (todos)
- [x] Editar medicamento (todos)
- [ ] Adicionar Exceptions
- [x] Adicionar metodo para contagem de stock de determinado medicamento | Rafael
- [ ] Melhorar o metodo getMedicamentos() para validar se os valores são nulos

##### Gaveta
- [x] Criar Classe Gaveta
- [x] Adicionar medicamento
- [x] Remover medicamento (nome) <- o primeiro que encontrar!
- [x] Editar medicamento (nome) <- Editar mas só se houver engano ao adicionar individualmente! 
- [ ] Adicionar Exceptions
- [x] Adicionar metodo para contagem de stock de determinado medicamento | Rafael

##### Gestor de Clientes e Clientes 
- [ ] Criar Gestor de Clientes
- [x] Criar Classe Clientes | Hugo
    - [x] id,nome,bi,data_inscriçao | Hugo
- [x] Registar Clientes Hugo
- [ ] Remover Clientes
- [ ] Adicionar Exceptions
- etc..

##### Gestor de Vendas e Vendas
- [x] Criar Gestor de Vendas | Rafael
    - [x] nome,ArrayList<Vendas>,quantidade_vendas,quantidade_maxima | Rafael
- [x] Criar Classe Vendas | Rafael
    - [x] cod_venda,Cliente,ArrayList<Medicamentos>,data_venda | Rafael
- [x] Adicionar Venda Rafael
- [ ] Remover Venda 
- [x] Guardar em ficheiro todas as compras Rafael|Hugo
- [x] Criar Secçao de relatorios para Vendas Rafael|Hugo
- [ ] Adicionar Exceptions
- etc..


##### Gestor de Relatórios e Relatórios
- [x] Criar o Gestor de Relatórios -> Enviamos uma venda Hugo|Rafael
    - [x] Dialog para apresentar os relatorios Hugo|Rafael
    - [x] Gerar relatório por venda
    
    
##### Gestor de Alertas e Alertas
- [ ] Criar um gestor para tratar os alertas e apresenta-los
    - [ ] Metodo para guardar os alertas em ficheiro
    - [ ] Metodo para ler alertas


##### Save Data
- [x] Criar Serializaçao para (Farmacia) Rafael|Hugo
    - [x] Todos os dados são gravado ao fechar o programa e são lidos ao abrir o programa Rafael|Hugo

#####

##### Exemplo de registar a concluir cada tarefa é assim:
- [x] nome da tarefa 'Rafael|Hugo'
 