### Farmacia Tarefas


##### Separador Relatorios

- [x] Criar Classe Relatorio | Rafael
    - [x] Ver todas as compras | Rafael
    - [x] Ver todos os medicamentos do mes inseridos| Hugo
    - [x] Ver produtos fora de stock| Hugo
- [x] Remover Relatório| Hugo
- [x] Apresentar ultimos relatórios| Hugo
- [x] Apresentar alertas| Hugo Rafael
- [x] Melhorar o layout | Hugo Rafael
- etc..


##### Layout 
- [x] Criar layout | Hugo
- [x] Painel Vendas já com combobox a inicializar com dados corretos | hugo
- [x] Main layout | Rafael
- [x] Botao terminar Sessao | Rafael
- [x] Identificação (Loja, Funcionario,Data) | Rafael
##### Login
- [x] Implementação de Login | Rafael
- [x] Apresentar dados de login | Rafael
- [x] Selecionar loja da farmacia | Rafael
- [x] Botoes Sair e iniciar sessao | Rafael
- [x] Carregar farmacia | Hugo Rafael

##### Logout
- [x] Implementação | Rafael
- [x] Guardar Farmacia ao sair | Hugo

##### Painel Home
    - [x] Detalhes da Farmacia
    - [x] Produtos adicionados recentemente
    - [x] Vendas mais recentes
    - [x] Produtos a caminho
        - [x] Botao dar baixa ao medicamentos (pendentes de outra loja)
- [x] Calcular o valores para apresentar
    - [x] Apresetar total vendas | Rafael
    - [x] Apresentar Quantidade de vendas | Rafael
    - [x] Apresentar Total de Novos Clientes | Rafael
    - [x] Apresentar Produto mais Vendido | Rafael
- [x] Calcular os medicamentos certos para apresentar nos Produtos Recentes


##### Painel Vendas
- [x] Botao "Executar Compra" | Rafael
    - [x] Formulário "CriarVendas" | Rafael
    - [x] Procurar Medicamento | Rafael
        - [x] Na lista de baixo | Rafael
        - [x] Caso exista noutra loja importar | Rafael
    - [x] Criar Formulario "Importar" | Rafael
        - [x] Detalhes de medicamento | Rafael
        - [x] Definir quantidade a importar | Rafael
        - [x] Alertas! | Rafael
    - [x] Definir estado de medicamento | Rafael
- [x] Apresentar medicamentos na loja em que estiver com sessão | Rafael
- [x] Adicionar botoes "Adicionar" e "Remover" | Rafael
- [x] Apresentar carrinho de compra | Rafael
- [x] Apresentar formulário "Dados Cliente" | Rafael
- [x] Modo de Pagamento | Rafael
- [x] Detalhes finais da compra (iva, sub-total,total) | Rafael
- [X] Calcular e apresentar dados de compra | Rafael
- [X] Criar botao concluir com os alertas!

- [x] Colocar botão para procurar clientes | Rafael
- [ ] Botão para criar um novo cliente -> pode ser um "link" para o form clientes
- [ ] Apresentar os detalhes para os dados que forem selecionados na JList


##### Panel Gerir
- [x] Jlist com os medicamentos | Hugo
- [x] Painel Info com informação detalhada do medicamento selecionado na JList e já com stock | Hugo
- [x] Botões Editar para editar um medicamento | Hugo
- [x] Scroll Panel para a listagem | Hugo Rafael
- [x] Adicionar Medicamento | Hugo Rafael
    - [x] Verificar Campos | Hugo
    - [x] Verificar Data Validade | Hugo
    - [x] Campo Receita  | Hugo
- [x] Remover Medicamento | Hugo Rafael
- [x] JList sempre atualizada adicionando ou removendo medicamentos | Hugo Rafael
- [x] Botão pesquisar por nome e apresentar na JList | Hugo
- [x] Inserir os itens | Hugo

..Concluir...

##### Encomenda
- [x] Definição de Design | Rafael
- [x] Todos os medicamentos | Hugo
- [x] Produtos de Ruptura | Hugo
- [x] Produtos Encomendados | hugo
...

##### Medicamentos
- [x] Criar Classe Medicamento | Rafael Hugo
- [x] Fiz update em vez de Medicamentos[] para ArrayList, tirando assim a quantidade; | Rafael
    - [x] id,ArrayList ,data_validade | Hugo
- [x] Adicionar funcao para verificar validade (boolean) | Hugo
- [x] Adicionar Exceptions | Rafael Hugo
- [x] Adicionar estado de medicamento | Rafael

##### Armario
- [x] Criar Classe Armario | Rafael Hugo
- [x] Adicionar medicamento | Rafael Hugo
- [x] Remover medicamento (todos)| Rafael Hugo
- [x] Editar medicamento (todos)| Hugo
- [x] Adicionar Exceptions | Rafael Hugo
- [x] Adicionar metodo para contagem de stock de determinado medicamento | Rafael
- [x] Melhorar o metodo getMedicamentos() para validar se os valores são nulos | Rafael

##### Gaveta
- [x] Criar Classe Gaveta | Rafael Hugo
- [x] Adicionar medicamento | Rafael
- [x] Remover medicamento (nome) <- o primeiro que encontrar! | Rafael
- [x] Editar medicamento (nome) <- Editar mas só se houver engano ao adicionar individualmente! | Hugo
- [x] Adicionar Exceptions | Rafael Hugo
- [x] Adicionar metodo para contagem de stock de determinado medicamento | Rafael

##### Gestor de Clientes e Clientes 
- [x] Criar Gestor de Clientes | Rafael
- [x] Criar Classe Clientes | Hugo
    - [x] id,nome,bi,data_inscriçao | Hugo
- [x] Registar Clientes | Hugo
- [x] Remover Clientes | Hugo
- [x] Adicionar Exceptions | Rafael Hugo
- etc..

##### Gestor de Vendas e Vendas
- [x] Criar Gestor de Vendas | Rafael
    - [x] nome,ArrayList<Vendas>,quantidade_vendas,quantidade_maxima | Rafael
- [x] Criar Classe Vendas | Rafael
    - [x] cod_venda,Cliente,ArrayList<Medicamentos>,data_venda | Rafael
- [x] Adicionar Venda | Rafael
- [x] Remover Venda | Rafael
- [x] Guardar em ficheiro todas as compras | Rafael Hugo
- [x] Criar Secçao de relatorios para Vendas | Rafael Hugo
- [x] Adicionar Exceptions | Rafael Hugo
- etc..


##### Gestor de Relatórios e Relatórios
- [x] Criar o Gestor de Relatórios -> Enviamos uma venda Hugo|Rafael
    - [x] Dialog para apresentar os relatorios Hugo|Rafael
    - [x] Gerar relatório por venda | Rafael Hugo
    
    
##### Gestor de Alertas e Alertas
- [ ] Criar um gestor para tratar os alertas e apresenta-los
    - [ ] Metodo para guardar os alertas em ficheiro
    - [ ] Metodo para ler alertas


##### Save Data
- [x] Criar Serializaçao para (Farmacia) Rafael|Hugo
    - [x] Todos os dados são gravado ao fechar o programa e são lidos ao abrir o programa Rafael|Hugo
- [x] Implementaçao de 3 Armarios na mesma Farmacia | Rafael Hugo


##### Exemplo de registar a concluir cada tarefa é assim:
- [x] nome da tarefa 'Rafael|Hugo'
 