### Farmacia Tarefas



##### Separador Relatorios

- [ ] Criar Classe Relatorio
    - [ ] Ver todas as compras 
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
    - [ ] Apresentar Quantidade de vendas
    - [ ] Apresentar Total de Novos Clientes
    - [ ] Apresentar Produto mais Vendido
- [ ] Calcular os medicamentos certos para apresentar nos Produtos Recentes
- [ ] Apresentar os medicamentos em armazem


##### Painel Vendas
- [ ] Colocar botão para procurar clientes
- [ ] Botão para criar um novo cliente -> pode ser um "link" para o form clientes
- [ ] Calcular e apresentar dados de compra
- [ ] Apresentar os detalhes para os dados que forem selecionados na JList 


##### Panel Gerir
- [x] Jlist com os medicamentos | Hugo
- [x] Painel Info com informação detalhada do medicamento selecionado na JList e já com stock | Hugo
- [ ] Botões Editar para editar um medicamento  
- [x] Scroll Panel para a listagem | Hugo Rafael
- [x] Adicionar Medicamento | Hugo Rafael
- [x] Remover Medicamento | Hugo Rafael
- [x] JList sempre atualizada adicionando ou removendo medicamentos | Hugo Rafael


##### Panel Adicionar Medicamento
- [ ] Painel para adicionar medicamentos


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
- [ ] Registar Clientes
- [ ] Remover Clientes
- [ ] Adicionar Exceptions
- etc..

##### Gestor de Vendas e Vendas
- [x] Criar Gestor de Vendas | Rafael
    - [x] nome,ArrayList<Vendas>,quantidade_vendas,quantidade_maxima | Rafael
- [x] Criar Classe Vendas | Rafael
    - [x] cod_venda,Cliente,ArrayList<Medicamentos>,data_venda | Rafael
- [x] Adicionar Venda
- [ ] Remover Venda 
- [ ] Guardar em ficheiro todas as compras
- [ ] Criar Relatórios
- [ ] Criar Secçao de relatorios para Vendas
- [ ] Adicionar Exceptions
- etc..


##### Gestor de Relatórios e Relatórios
- [ ] Criar o Gestor de Relatórios -> Enviamos um medicamento e um cliente e o gestor gera o relatorio
    - [ ] Criar um "layout" padrão para a criaçao dos relatório
    
    
##### Gestor de Alertas e Alertas
- [ ] Criar um gestor para tratar os alertas e apresenta-los
    - [ ] Metodo para guardar os alertas em ficheiro
    - [ ] Metodo para ler alertas


##### Save Data
- [X] Criar Serializaçao para (armario)
- [ ] Criar Serializaçao para (Gestor de clientes)
    - [ ] Criar pasta dedicada
- [ ] Fazer Carregamento de ficheiros ao arrancar o programa
- etc.. 

#####

##### Exemplo de registar a concluir cada tarefa é assim:
- [x] nome da tarefa 'Rafael|Hugo'
 