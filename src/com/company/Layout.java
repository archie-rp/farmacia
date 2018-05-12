package com.company;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.border.TitledBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Layout extends JFrame implements CatVia {
    private JPanel main;
    private JPanel venda;
    private JPanel cliente;
    private JTextField txtNome;
    private JTextField textProcurarCliente;
    private JTextField textPesquisarStock;
    private JTextField textField;
    private JTextField textField_1;

    public static void main(String[] args) {

        try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
        	System.out.println(e.getMessage());
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Layout frame = new Layout();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        });


    }

    public Layout() {
        //Criar Armario
        Armario armario = new Armario();
        //Gestor de Vendas
        GestorVendas gestorvendas = new GestorVendas();
        //Criar uma venda
        Venda venda1 = new Venda();
        //Criar uma compra que é uma arraylist de Medicamentos
        ArrayList<Medicamento> compra1= new ArrayList<Medicamento>();
        //Criar Medicamento para inserir na compra
        Medicamento medicamento1 = new Medicamento();
        //Definir medicamento
        medicamento1.setNome("Benuron");
        medicamento1.setCategoria(1);
        medicamento1.setViaAdmin(1);
        //Defenir a venda
        venda1.setCod_venda(102);
        venda1.setData_compra(new Date());
        venda1.setCliente(new Cliente(2,"Nome Cliente",1222, new Date()));
        //Adicionar medicamento na compra
        compra1.add(medicamento1);
        //Adicionar o arraylist dos medicamentos
        venda1.setMedicamentos(compra1);
        //Adicionar Vendas ao gestor de vendas
        gestorvendas.adicionarVenda(venda1);
        //Imprimir a Vendas
        //System.out.println(gestorvendas.getVendas());
        for (int i=0;i<10;i++) {
            armario.adicionarMedicamento(medicamento1);
        }getContentPane().setLayout(new CardLayout(0, 0));
        setBounds(100, 100, 842, 580);
        
        JPanel login = new JPanel();
        getContentPane().add(login, "name_4164308832893");
        login.setLayout(null);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(42, 101, 60, 14);
        login.add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(42, 144, 46, 14);
        login.add(lblPassword);
        
        textField = new JTextField();
        textField.setBounds(117, 98, 86, 20);
        login.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(117, 141, 86, 20);
        login.add(textField_1);
        textField_1.setColumns(10);
        
        
        JLabel lblBemVindoA = new JLabel("Bem Vindo a Farmacia!");
        lblBemVindoA.setBounds(26, 36, 165, 14);
        login.add(lblBemVindoA);

        JPanel main = new JPanel();
        getContentPane().add(main, "name_2347007504240");

        main.setLayout(null);


        //Paineis e a iniciliação
        JPanel stock = new JPanel();
        getContentPane().add(stock, "name_14847299319921");
        stock.setLayout(null);
        stock.setVisible(false);

        JPanel venda = new JPanel();
        getContentPane().add(venda, "name_2350788731094");
        venda.setLayout(null);
        venda.setVisible(false);

        JPanel relatorio = new JPanel();
        getContentPane().add(relatorio, "name_14016104555020");
        relatorio.setLayout(null);
        relatorio.setVisible(false);

        JPanel clientes = new JPanel();
        getContentPane().add(clientes, "name_14223925552743");
        clientes.setLayout(null);
        clientes.setVisible(false);


        JButton btnLogin = new JButton("Login");
        btnLogin.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		login.setVisible(false);
                main.setVisible(true);
        	}
        });
        btnLogin.setBounds(114, 191, 89, 23);
        login.add(btnLogin);
        
        //Botao Vendas
        JButton btnVendas = new JButton("Vendas");
        btnVendas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                venda.setVisible(true);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(false);

            }
        });

        btnVendas.setBounds(152, 35, 99, 39);
        main.add(btnVendas);

        JButton button_10 = new JButton("Clientes");
        button_10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(true);
                stock.setVisible(false);
            }
        });
        button_10.setBounds(517, 37, 120, 39);
        relatorio.add(button_10);

        JButton btnStockRelatorio = new JButton("Stock");
        btnStockRelatorio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(true);
            }
        });
        btnStockRelatorio.setBounds(391, 37, 108, 39);
        relatorio.add(btnStockRelatorio);

        JButton btnRelatorioRelatorio = new JButton("Relatório");
        btnRelatorioRelatorio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(true);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });

        btnRelatorioRelatorio.setBounds(272, 37, 99, 39);
        relatorio.add(btnRelatorioRelatorio);

        JButton button_13 = new JButton("Vendas");
        button_13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(true);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });
        button_13.setBounds(152, 37, 99, 39);
        relatorio.add(button_13);

        JButton button_14 = new JButton("Home");
        button_14.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(true);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });
        button_14.setBounds(31, 37, 99, 39);
        relatorio.add(button_14);

        JLabel lblUltimosRelatrios = new JLabel("Ultimos relatórios");
        lblUltimosRelatrios.setBounds(31, 100, 135, 16);
        relatorio.add(lblUltimosRelatrios);

        JTextPane textRelatorio = new JTextPane();
        textRelatorio.setBounds(31, 127, 366, 218);
        relatorio.add(textRelatorio);

        JLabel lblAlertas = new JLabel("Total alertas: ");
        lblAlertas.setBounds(418, 125, 108, 16);
        relatorio.add(lblAlertas);

        //Botao home
        JButton btnHome = new JButton("Home");
        btnHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(true);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });
        btnHome.setBounds(31, 35, 99, 39);
        main.add(btnHome);

        //Botao Relatorio
        JButton btnRelatorio = new JButton("Relatório");
        btnRelatorio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(true);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });
        btnRelatorio.setBounds(272, 35, 99, 39);
        main.add(btnRelatorio);

        JLabel label = new JLabel("09/05/2018");
        label.setBounds(675, 11, 99, 23);
        main.add(label);

        JButton btnStock = new JButton("Stock");
        btnStock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(true);
            }
        });
        btnStock.setBounds(391, 35, 108, 39);
        main.add(btnStock);

        JButton btnClientes = new JButton("Clientes");
        btnClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(true);
                stock.setVisible(false);
            }
        });
        btnClientes.setBounds(517, 35, 120, 39);
        main.add(btnClientes);

        JLabel lblVendasMes = new JLabel("Vendas este mês:");
        lblVendasMes.setBounds(31, 96, 133, 14);
        main.add(lblVendasMes);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(57, 130, 107, 14);
        main.add(lblQuantidade);

        JLabel lblNovosClientes = new JLabel("Novos Clientes");
        lblNovosClientes.setBounds(57, 155, 127, 14);
        main.add(lblNovosClientes);

        JLabel lblProdutoMaisVendido = new JLabel("Produto mais vendido:");
        lblProdutoMaisVendido.setBounds(57, 183, 149, 14);
        main.add(lblProdutoMaisVendido);

        JLabel lblProdutosEmCaminho = new JLabel("Produtos em caminho:");
        lblProdutosEmCaminho.setBounds(31, 197, 153, 14);
        main.add(lblProdutosEmCaminho);

        JLabel lblArmazem = new JLabel("Armazem:");
        lblArmazem.setBounds(425, 107, 85, 14);
        main.add(lblArmazem);

        JTextPane textProdutosForaStock = new JTextPane();
        textProdutosForaStock.setBounds(448, 155, 353, 147);
        main.add(textProdutosForaStock);

        JLabel lblProdutosAdicionadosRecentemente = new JLabel("Produtos adicionados recentemente:");
        lblProdutosAdicionadosRecentemente.setBounds(438, 313, 250, 14);
        main.add(lblProdutosAdicionadosRecentemente);

        JTextPane textProdutosRecentes = new JTextPane();
        textProdutosRecentes.setBounds(448, 338, 353, 147);
        main.add(textProdutosRecentes);
        
        JList list = new JList(armario.getArmarioGaveta(1,1).getMedicamentos().toArray());
        list.setBounds(31, 261, 386, 244);
        main.add(list);
        
        JPanel panel = new JPanel();
        panel.setToolTipText("");
        panel.setBorder(new TitledBorder(null, "Produtos Adicionados Recentemente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(20, 222, 408, 292);
        main.add(panel);
        panel.setLayout(null);
        
        JLabel lblNome_2 = new JLabel("Nome");
        lblNome_2.setBounds(6, 16, 46, 14);
        panel.add(lblNome_2);
        
        JLabel lblCategoria_1 = new JLabel("Categoria");
        lblCategoria_1.setBounds(76, 16, 64, 14);
        panel.add(lblCategoria_1);
        
        JLabel lblViaDeAdm = new JLabel("Via de Admin");
        lblViaDeAdm.setBounds(149, 16, 77, 14);
        panel.add(lblViaDeAdm);
        
        JLabel lblDataValidade = new JLabel("Data Validade");
        lblDataValidade.setBounds(247, 16, 77, 14);
        panel.add(lblDataValidade);
        
        JLabel lblPreo = new JLabel("Preço");
        lblPreo.setBounds(334, 16, 46, 14);
        panel.add(lblPreo);
        panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNome_2, lblCategoria_1, lblViaDeAdm, lblDataValidade, lblPreo}));


        JLabel lblEscolhaProduto = new JLabel("Escolha produto:");
        lblEscolhaProduto.setBounds(31, 92, 113, 25);
        venda.add(lblEscolhaProduto);

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setBounds(31, 128, 85, 20);
        venda.add(lblCategoria);

        JLabel lblViaAdmin = new JLabel("Via Administração:");
        lblViaAdmin.setBounds(212, 130, 124, 17);
        venda.add(lblViaAdmin);

        JComboBox comboBoxCategoria = new JComboBox();
        comboBoxCategoria.setBounds(31, 155, 172, 20);
        venda.add(comboBoxCategoria);
        for (int i = 0; i < categorias.length; i++) {
            comboBoxCategoria.addItem(categorias[i]);
        }

        JComboBox comboBoxViaAdmin = new JComboBox();
        comboBoxViaAdmin.setBounds(212, 155, 158, 20);
        venda.add(comboBoxViaAdmin);
        for (int i = 0; i < vias.length; i++) {
            comboBoxViaAdmin.addItem(vias[i]);
        }

        JButton button = new JButton("Clientes");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(true);
                stock.setVisible(false);
            }
        });
        button.setBounds(517, 42, 120, 39);
        venda.add(button);

        JButton button_1 = new JButton("Stock");
        button_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(true);
            }
        });
        button_1.setBounds(391, 42, 108, 39);
        venda.add(button_1);

        JButton button_2 = new JButton("Relatório");
        button_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(true);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });
        button_2.setBounds(272, 42, 99, 39);
        venda.add(button_2);

        JButton button_3 = new JButton("Vendas");
        button_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(true);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });
        button_3.setBounds(152, 42, 99, 39);
        venda.add(button_3);

        JButton button_4 = new JButton("Home");
        button_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(true);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });
        button_4.setBounds(31, 42, 99, 39);
        venda.add(button_4);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(391, 131, 46, 14);
        venda.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(391, 155, 199, 20);
        venda.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(415, 206, 70, 14);
        venda.add(lblCliente);

        JLabel lblNome_1 = new JLabel("Nome:");
        lblNome_1.setBounds(425, 229, 46, 14);
        venda.add(lblNome_1);

        JLabel lblBi = new JLabel("BI:");
        lblBi.setBounds(425, 252, 46, 14);
        venda.add(lblBi);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(415, 313, 95, 30);
        venda.add(btnAdicionar);

        JTextPane textPesquisaProduto = new JTextPane();
        textPesquisaProduto.setBounds(31, 186, 340, 157);
        venda.add(textPesquisaProduto);

        JLabel lblDadosCompra = new JLabel("Dados Compra");
        lblDadosCompra.setBounds(31, 365, 120, 14);
        venda.add(lblDadosCompra);

        JTextPane textDadosCompra = new JTextPane();
        textDadosCompra.setBounds(31, 390, 407, 158);
        venda.add(textDadosCompra);

        JLabel lblEstadoCompra = new JLabel("Estado Compra");
        lblEstadoCompra.setBounds(462, 390, 113, 16);
        venda.add(lblEstadoCompra);

        JLabel lblSubtotal = new JLabel("Sub-Total:");
        lblSubtotal.setBounds(482, 418, 85, 16);
        venda.add(lblSubtotal);

        JLabel lblIva = new JLabel("IVA:");
        lblIva.setBounds(482, 443, 55, 16);
        venda.add(lblIva);

        JLabel lblDesconto = new JLabel("Desconto:");
        lblDesconto.setBounds(482, 471, 75, 16);
        venda.add(lblDesconto);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(482, 499, 55, 16);
        venda.add(lblTotal);


        JButton button_15 = new JButton("Clientes");
        button_15.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(true);
                stock.setVisible(false);
            }
        });
        button_15.setBounds(517, 37, 120, 39);
        clientes.add(button_15);

        JButton btnVendasClientes = new JButton("Vendas");
        btnVendasClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(true);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });
        btnVendasClientes.setBounds(152, 37, 99, 39);
        clientes.add(btnVendasClientes);

        JButton btnRelatorioClientes = new JButton("Relatório");
        btnRelatorioClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(true);
                clientes.setVisible(false);
                stock.setVisible(false);

            }
        });
        btnRelatorioClientes.setBounds(272, 37, 99, 39);
        clientes.add(btnRelatorioClientes);

        JButton btnStockClientes = new JButton("Stock");
        btnStockClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(true);
            }
        });
        btnStockClientes.setBounds(391, 37, 108, 39);
        clientes.add(btnStockClientes);

        JButton btnHomeClientes = new JButton("Home");
        btnHomeClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(true);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });
        btnHomeClientes.setBounds(31, 37, 99, 39);
        clientes.add(btnHomeClientes);

        JLabel lblProcurarCliente = new JLabel("Procurar Cliente:");
        lblProcurarCliente.setBounds(31, 96, 108, 16);
        clientes.add(lblProcurarCliente);

        textProcurarCliente = new JTextField();
        textProcurarCliente.setBounds(140, 94, 161, 20);
        clientes.add(textProcurarCliente);
        textProcurarCliente.setColumns(10);

        JButton btnAdicionarCliente = new JButton("Adicionar");
        btnAdicionarCliente.setBounds(342, 91, 120, 26);
        clientes.add(btnAdicionarCliente);

        JButton btnAdicionar_2 = new JButton("Adicionar");
        btnAdicionar_2.setBounds(517, 108, 120, 26);
        clientes.add(btnAdicionar_2);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(517, 162, 118, 26);
        clientes.add(btnEditar);

        JButton btnRemover = new JButton("Remover");
        btnRemover.setBounds(517, 214, 120, 26);
        clientes.add(btnRemover);

        JLabel lblTodosOsClientes = new JLabel("Todos os clientes");
        lblTodosOsClientes.setBounds(10, 214, 148, 16);
        clientes.add(lblTodosOsClientes);

        JTextPane textTodosClientes = new JTextPane();
        textTodosClientes.setBounds(10, 242, 527, 214);
        clientes.add(textTodosClientes);

        JLabel lblRegistos = new JLabel("Registos");
        lblRegistos.setBounds(557, 266, 78, 16);
        clientes.add(lblRegistos);

        JLabel lblTotalClientes = new JLabel("Total Clientes: ");
        lblTotalClientes.setBounds(580, 294, 99, 16);
        clientes.add(lblTotalClientes);

        JLabel lblEsteMs = new JLabel("Este Mês:");
        lblEsteMs.setBounds(580, 322, 78, 16);
        clientes.add(lblEsteMs);


        JButton btnHomeStock = new JButton("Home");
        btnHomeStock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(true);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });
        btnHomeStock.setBounds(31, 36, 99, 39);
        stock.add(btnHomeStock);

        JButton btnVendasStock = new JButton("Vendas");
        btnVendasStock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(true);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });
        btnVendasStock.setBounds(152, 36, 99, 39);
        stock.add(btnVendasStock);

        JButton btnRelatorioStock = new JButton("Relatório");
        btnRelatorioStock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(true);
                clientes.setVisible(false);
                stock.setVisible(false);
            }
        });
        btnRelatorioStock.setBounds(272, 36, 99, 39);
        stock.add(btnRelatorioStock);

        JButton btnStockStock = new JButton("Stock");
        btnStockStock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(true);
            }
        });
        btnStockStock.setBounds(391, 36, 108, 39);
        stock.add(btnStockStock);

        JButton btnClientesStock = new JButton("Clientes");
        btnClientesStock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(true);
                stock.setVisible(false);
            }
        });
        btnClientesStock.setBounds(517, 36, 120, 39);
        stock.add(btnClientesStock);

        JLabel lblProcurarProduto = new JLabel("Procurar Produto:");
        lblProcurarProduto.setBounds(51, 102, 141, 16);
        stock.add(lblProcurarProduto);

        textPesquisarStock = new JTextField();
        textPesquisarStock.setBounds(162, 100, 192, 20);
        stock.add(textPesquisarStock);
        textPesquisarStock.setColumns(10);

        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBounds(366, 97, 98, 26);
        stock.add(btnPesquisar);

        JTextPane textProdutosStock = new JTextPane();
        textProdutosStock.setBounds(51, 148, 413, 232);
        stock.add(textProdutosStock);

        JLabel lblProdutosSemStock = new JLabel("Produtos sem Stock: ");
        lblProdutosSemStock.setBounds(474, 102, 156, 16);
        stock.add(lblProdutosSemStock);


    }
}
