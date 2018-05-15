package com.company;


import com.toedter.calendar.JCalendar;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

public class Layout extends JFrame implements CatVia {
    private JPanel main;
    private JPanel venda;
    private JPanel cliente;
    private JTextField txtNome;
    private JTextField textProcurarCliente;
    private JTextField textPesquisarStock;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textNome;
    private JTextField textQuantidade;
    private JTextField textPreco;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.Nimbus.LookAndFeel");
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
        ArrayList<Medicamento> compra1 = new ArrayList<Medicamento>();
        //Criar Medicamento para inserir na compra
        Medicamento medicamento1 = new Medicamento();
        Medicamento medicamento2 = new Medicamento();

        //Definir medicamento
        medicamento1.setNome("Benuron");
        medicamento1.setCategoria(0);
        medicamento1.setViaAdmin(0);
        //medicamento 2
        medicamento2.setNome("Aspirina");
        medicamento2.setCategoria(1);
        medicamento2.setViaAdmin(0);
        //Defenir a venda
        venda1.setCod_venda(102);
        venda1.setData_compra(new Date());
        venda1.setCliente(new Cliente(2, "Nome Cliente", 1222, new Date()));
        //Adicionar medicamento na compra
        compra1.add(medicamento1);
        //Adicionar o arraylist dos medicamentos
        venda1.setMedicamentos(compra1);
        //Adicionar Vendas ao gestor de vendas
        gestorvendas.adicionarVenda(venda1);
        //Imprimir a Vendas
        //System.out.println(gestorvendas.getVendas());
        for (int i = 0; i < 10; i++) {
            armario.adicionarMedicamento(medicamento1);
            armario.adicionarMedicamento(medicamento2);
        }
        for (int i = 0; i < 10; i++) {
            armario.adicionarMedicamento(medicamento1);

        }
        getContentPane().setLayout(new CardLayout(0, 0));
        setBounds(100, 100, 980, 691);

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

        JButton btnStockRelatorio = new JButton("Gerir");
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

        JButton btnStock = new JButton("Gerir");
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

        JList list = new JList(armario.getArmarioGaveta(0, 0).getMedicamentos().toArray());
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


        JLabel lblEscolhaProduto = new JLabel("Escolha produto:");
        lblEscolhaProduto.setBounds(31, 92, 113, 25);
        venda.add(lblEscolhaProduto);

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setBounds(31, 128, 85, 20);
        venda.add(lblCategoria);

        JLabel lblViaAdmin = new JLabel("Via Administração:");
        lblViaAdmin.setBounds(212, 130, 124, 17);
        venda.add(lblViaAdmin);

        JComboBox comboBoxCategoria = new JComboBox(categorias);
        comboBoxCategoria.setBounds(31, 155, 172, 20);
        venda.add(comboBoxCategoria);

        JComboBox comboBoxViaAdmin = new JComboBox(vias);
        comboBoxViaAdmin.setBounds(212, 155, 158, 20);
        venda.add(comboBoxViaAdmin);

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

        JButton btnGerir = new JButton("Gerir");
        btnGerir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                venda.setVisible(false);
                main.setVisible(false);
                relatorio.setVisible(false);
                clientes.setVisible(false);
                stock.setVisible(true);
            }
        });
        btnGerir.setBounds(391, 42, 108, 39);
        venda.add(btnGerir);

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
        //Pre-inicializaçao de valores
        //Criar a model <- vai armazenar a arraylist, mas usando um Model que é uma especia de Array Próprio do Jlist para ser actualizado! 
        DefaultListModel model = new DefaultListModel();
        //Adicionar Elementos caso exista medicamentos na gaveta, caso nao haja remove tudo
        try {
            ArrayList<Medicamento> med = armario.getArmarioGaveta(comboBoxCategoria.getSelectedIndex(), comboBoxViaAdmin.getSelectedIndex()).getMedicamentos();
            for (Medicamento medicamento : med) {
                //Adiciona os elemetos ao Model
                model.addElement(medicamento.toString());
            }
        } catch (Exception e1) {
            model.removeAllElements();
        }
        //Define qual a Model vai estar a representar na jList
        JList list_1 = new JList(model);
        list_1.setBounds(31, 186, 339, 157);
        venda.add(list_1);
        //Criar evento caso a Categoria seja Alterada!
        comboBoxCategoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Medicamento> med = armario.getArmarioGaveta(comboBoxCategoria.getSelectedIndex(), comboBoxViaAdmin.getSelectedIndex()).getMedicamentos();
                    DefaultListModel model = (DefaultListModel) list_1.getModel();
                    model.removeAllElements();
                    for (Medicamento medicamento : med) {
                        model.addElement(medicamento.toString());
                    }
                } catch (Exception e1) {
                    model.removeAllElements();
                }
            }
        });
        //Criar evento caso a Via de Administraçao seja Alterada!
        comboBoxViaAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Medicamento> med = armario.getArmarioGaveta(comboBoxCategoria.getSelectedIndex(), comboBoxViaAdmin.getSelectedIndex()).getMedicamentos();
                    DefaultListModel model = (DefaultListModel) list_1.getModel();
                    model.removeAllElements();
                    for (Medicamento medicamento : med) {
                        model.addElement(medicamento.toString());
                    }
                } catch (Exception e1) {
                    model.removeAllElements();
                }
            }
        });

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

        JButton btnStockClientes = new JButton("Gerir");
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

        JButton btnStockStock = new JButton("Gerir");
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
        lblProcurarProduto.setBounds(31, 311, 141, 16);
        stock.add(lblProcurarProduto);

        textPesquisarStock = new JTextField();
        textPesquisarStock.setBounds(142, 309, 192, 20);
        stock.add(textPesquisarStock);
        textPesquisarStock.setColumns(10);

        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {


            }
        });
        btnPesquisar.setBounds(346, 306, 98, 26);
        stock.add(btnPesquisar);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Informação detalhada: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(523, 345, 429, 255);
        stock.add(panel_1);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{59, 138, 288, 0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 32, 30, 34, 30, 30, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);

        JLabel lblNome_3 = new JLabel("Nome:");
        GridBagConstraints gbc_lblNome_3 = new GridBagConstraints();
        gbc_lblNome_3.fill = GridBagConstraints.BOTH;
        gbc_lblNome_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNome_3.gridx = 1;
        gbc_lblNome_3.gridy = 1;
        panel_1.add(lblNome_3, gbc_lblNome_3);

        JLabel lblNomeShow = new JLabel("");
        GridBagConstraints gbc_lblNomeShow = new GridBagConstraints();
        gbc_lblNomeShow.anchor = GridBagConstraints.WEST;
        gbc_lblNomeShow.insets = new Insets(0, 0, 5, 5);
        gbc_lblNomeShow.gridx = 2;
        gbc_lblNomeShow.gridy = 1;
        panel_1.add(lblNomeShow, gbc_lblNomeShow);

        JLabel lblCategoria_2 = new JLabel("Categoria:");
        GridBagConstraints gbc_lblCategoria_2 = new GridBagConstraints();
        gbc_lblCategoria_2.fill = GridBagConstraints.BOTH;
        gbc_lblCategoria_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblCategoria_2.gridx = 1;
        gbc_lblCategoria_2.gridy = 2;
        panel_1.add(lblCategoria_2, gbc_lblCategoria_2);

        JLabel lbCategoriaShow = new JLabel("");
        GridBagConstraints gbc_lbCategoriaShow = new GridBagConstraints();
        gbc_lbCategoriaShow.anchor = GridBagConstraints.WEST;
        gbc_lbCategoriaShow.insets = new Insets(0, 0, 5, 5);
        gbc_lbCategoriaShow.gridx = 2;
        gbc_lbCategoriaShow.gridy = 2;
        panel_1.add(lbCategoriaShow, gbc_lbCategoriaShow);

        JLabel lblViaDeAdministrao = new JLabel("Via de Administração:");
        GridBagConstraints gbc_lblViaDeAdministrao = new GridBagConstraints();
        gbc_lblViaDeAdministrao.fill = GridBagConstraints.BOTH;
        gbc_lblViaDeAdministrao.insets = new Insets(0, 0, 5, 5);
        gbc_lblViaDeAdministrao.gridx = 1;
        gbc_lblViaDeAdministrao.gridy = 3;
        panel_1.add(lblViaDeAdministrao, gbc_lblViaDeAdministrao);

        JLabel lblViaShow = new JLabel("");
        GridBagConstraints gbc_lblViaShow = new GridBagConstraints();
        gbc_lblViaShow.anchor = GridBagConstraints.WEST;
        gbc_lblViaShow.insets = new Insets(0, 0, 5, 5);
        gbc_lblViaShow.gridx = 2;
        gbc_lblViaShow.gridy = 3;
        panel_1.add(lblViaShow, gbc_lblViaShow);

        JLabel lblStock = new JLabel("Stock:");
        GridBagConstraints gbc_lblStock = new GridBagConstraints();
        gbc_lblStock.fill = GridBagConstraints.BOTH;
        gbc_lblStock.insets = new Insets(0, 0, 5, 5);
        gbc_lblStock.gridx = 1;
        gbc_lblStock.gridy = 4;
        panel_1.add(lblStock, gbc_lblStock);

        JLabel lblStockShow = new JLabel("");
        GridBagConstraints gbc_lblStockShow = new GridBagConstraints();
        gbc_lblStockShow.anchor = GridBagConstraints.WEST;
        gbc_lblStockShow.insets = new Insets(0, 0, 5, 5);
        gbc_lblStockShow.gridx = 2;
        gbc_lblStockShow.gridy = 4;
        panel_1.add(lblStockShow, gbc_lblStockShow);

        JLabel lblDataValidade_1 = new JLabel("Data Validade");
        GridBagConstraints gbc_lblDataValidade_1 = new GridBagConstraints();
        gbc_lblDataValidade_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblDataValidade_1.fill = GridBagConstraints.BOTH;
        gbc_lblDataValidade_1.gridx = 1;
        gbc_lblDataValidade_1.gridy = 5;
        panel_1.add(lblDataValidade_1, gbc_lblDataValidade_1);

        JLabel lblValidadeShow = new JLabel("");
        GridBagConstraints gbc_lblValidadeShow = new GridBagConstraints();
        gbc_lblValidadeShow.anchor = GridBagConstraints.WEST;
        gbc_lblValidadeShow.insets = new Insets(0, 0, 5, 5);
        gbc_lblValidadeShow.gridx = 2;
        gbc_lblValidadeShow.gridy = 5;
        panel_1.add(lblValidadeShow, gbc_lblValidadeShow);

        JLabel lblPreo_1 = new JLabel("Preço:");
        GridBagConstraints gbc_lblPreo_1 = new GridBagConstraints();
        gbc_lblPreo_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblPreo_1.gridx = 1;
        gbc_lblPreo_1.gridy = 6;
        panel_1.add(lblPreo_1, gbc_lblPreo_1);

        JLabel lblPrecoShow = new JLabel("");
        GridBagConstraints gbc_lblPrecoShow = new GridBagConstraints();
        gbc_lblPrecoShow.insets = new Insets(0, 0, 5, 5);
        gbc_lblPrecoShow.gridx = 2;
        gbc_lblPrecoShow.gridy = 6;
        panel_1.add(lblPrecoShow, gbc_lblPrecoShow);

        JButton btnNewButton = new JButton("Editar");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.anchor = GridBagConstraints.EAST;
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 7;
        panel_1.add(btnNewButton, gbc_btnNewButton);

        JButton btnApagar = new JButton("Apagar");
        GridBagConstraints gbc_btnApagar = new GridBagConstraints();
        gbc_btnApagar.insets = new Insets(0, 0, 0, 5);
        gbc_btnApagar.gridx = 2;
        gbc_btnApagar.gridy = 7;
        panel_1.add(btnApagar, gbc_btnApagar);


        //Inicializar Jlist
        JList<Medicamento> list_2 = new JList(armario.getTodos().toArray());
        list_2.setBounds(61, 131, 423, 255);
        //Inicializar o Scroll Pane para termos barra de scroll
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setViewportView(list_2);
        scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_1.setBounds(31, 343, 472, 276);
        //Adicona o scroll pane ao painel Stock
        stock.add(scrollPane_1);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(null, "Adicionar Medicamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_3.setBounds(25, 102, 635, 182);
        stock.add(panel_3);
        panel_3.setLayout(null);

        Panel panel_2 = new Panel();
        panel_2.setBounds(6, 16, 434, 188);
        panel_3.add(panel_2);
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[]{19, 176, 135, 93, 0};
        gbl_panel_2.rowHeights = new int[]{20, -2, 0, 0, 0, 0, 0};
        gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_2.setLayout(gbl_panel_2);

        JLabel label_2 = new JLabel("Categoria:");
        GridBagConstraints gbc_label_2 = new GridBagConstraints();
        gbc_label_2.insets = new Insets(0, 0, 5, 5);
        gbc_label_2.anchor = GridBagConstraints.WEST;
        gbc_label_2.gridx = 1;
        gbc_label_2.gridy = 0;
        panel_2.add(label_2, gbc_label_2);

        JLabel label_1 = new JLabel("Via Administração:");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.WEST;
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 2;
        gbc_label_1.gridy = 0;
        panel_2.add(label_1, gbc_label_1);

        JLabel lblDataValidade_2 = new JLabel("Data Validade");
        GridBagConstraints gbc_lblDataValidade_2 = new GridBagConstraints();
        gbc_lblDataValidade_2.anchor = GridBagConstraints.WEST;
        gbc_lblDataValidade_2.insets = new Insets(0, 0, 5, 0);
        gbc_lblDataValidade_2.gridx = 3;
        gbc_lblDataValidade_2.gridy = 0;
        panel_2.add(lblDataValidade_2, gbc_lblDataValidade_2);

        JComboBox comboCat = new JComboBox(categorias);
        GridBagConstraints gbc_comboCat = new GridBagConstraints();
        gbc_comboCat.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboCat.anchor = GridBagConstraints.NORTH;
        gbc_comboCat.insets = new Insets(0, 0, 5, 5);
        gbc_comboCat.gridx = 1;
        gbc_comboCat.gridy = 1;
        panel_2.add(comboCat, gbc_comboCat);

        JComboBox comboVia = new JComboBox(vias);
        GridBagConstraints gbc_comboVia = new GridBagConstraints();
        gbc_comboVia.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboVia.anchor = GridBagConstraints.NORTH;
        gbc_comboVia.insets = new Insets(0, 0, 5, 5);
        gbc_comboVia.gridx = 2;
        gbc_comboVia.gridy = 1;
        panel_2.add(comboVia, gbc_comboVia);

        JLabel lblNome_4 = new JLabel("Nome");
        GridBagConstraints gbc_lblNome_4 = new GridBagConstraints();
        gbc_lblNome_4.anchor = GridBagConstraints.WEST;
        gbc_lblNome_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNome_4.gridx = 1;
        gbc_lblNome_4.gridy = 2;
        panel_2.add(lblNome_4, gbc_lblNome_4);

        textNome = new JTextField();
        GridBagConstraints gbc_textNome = new GridBagConstraints();
        gbc_textNome.insets = new Insets(0, 0, 5, 5);
        gbc_textNome.fill = GridBagConstraints.HORIZONTAL;
        gbc_textNome.gridx = 2;
        gbc_textNome.gridy = 2;
        panel_2.add(textNome, gbc_textNome);
        textNome.setColumns(10);

        JLabel lblNewLabel = new JLabel("Quantidade");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 3;
        panel_2.add(lblNewLabel, gbc_lblNewLabel);

        textQuantidade = new JTextField();
        GridBagConstraints gbc_textQuantidade = new GridBagConstraints();
        gbc_textQuantidade.insets = new Insets(0, 0, 5, 5);
        gbc_textQuantidade.fill = GridBagConstraints.HORIZONTAL;
        gbc_textQuantidade.gridx = 2;
        gbc_textQuantidade.gridy = 3;
        panel_2.add(textQuantidade, gbc_textQuantidade);
        textQuantidade.setColumns(10);

        JLabel lblPreo_2 = new JLabel("Preço:");
        GridBagConstraints gbc_lblPreo_2 = new GridBagConstraints();
        gbc_lblPreo_2.anchor = GridBagConstraints.WEST;
        gbc_lblPreo_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblPreo_2.gridx = 1;
        gbc_lblPreo_2.gridy = 4;
        panel_2.add(lblPreo_2, gbc_lblPreo_2);

        textPreco = new JTextField();
        GridBagConstraints gbc_textPreco = new GridBagConstraints();
        gbc_textPreco.insets = new Insets(0, 0, 5, 5);
        gbc_textPreco.fill = GridBagConstraints.HORIZONTAL;
        gbc_textPreco.gridx = 2;
        gbc_textPreco.gridy = 4;
        panel_2.add(textPreco, gbc_textPreco);
        textPreco.setColumns(10);

        JCalendar dataValidade = new JCalendar();
        dataValidade.setBounds(446, 16, 167, 157);
        panel_3.add(dataValidade);

        JButton btnAdicionarGerir = new JButton("Adicionar");
        btnAdicionarGerir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

                if (textNome.getText() != null && textQuantidade.getText() != null) {
                    Medicamento medic = new Medicamento(textNome.getText(), Integer.valueOf(textPreco.getText()), comboCat.getSelectedIndex(), comboVia.getSelectedIndex(), dataValidade.getCalendar().getTime());
                    armario.adicionarMedicamento(medic);
                    list_2.removeAll();
                    JList<Medicamento> list_2 = new JList(armario.getTodos().toArray());
                    stock.remove(list_2);
                    stock.add(list_2);
                }


            }
        });
        GridBagConstraints gbc_btnAdicionarGerir = new GridBagConstraints();
        gbc_btnAdicionarGerir.gridx = 3;
        gbc_btnAdicionarGerir.gridy = 5;
        panel_2.add(btnAdicionarGerir, gbc_btnAdicionarGerir);


        //Evento Selection change e mostra os valores detalhados no form ao lado
        list_2.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                Medicamento s = (Medicamento) list_2.getSelectedValue();
                lblNomeShow.setText(s.getNome());
                lbCategoriaShow.setText(categorias[s.getCategoria()]);
                lblViaShow.setText(vias[s.getViaAdmin()]);
                lblStockShow.setText(String.valueOf(armario.getMedicamentoQuantidade(s)));
                lblValidadeShow.setText(s.getDataValidade().toString());
                lblPrecoShow.setText(String.valueOf(s.getPreco()));
            }
        });


    }
}
