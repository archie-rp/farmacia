package com.company;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.border.LineBorder;


import com.toedter.calendar.JDateChooser;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Layout extends JFrame implements Variaveis {
    private JPanel main;
    private JPanel venda;
    private JPanel cliente;
    private JTextField txtNome;
    private JTextField textProcurarClienteNome;
    private JTextField textPesquisarStock;
    private JTextField textNome;
    private JTextField textQuantidade;
    private JTextField textPreco;
    private JTextField nomeStock;
    private JTextField validadeStock;
    private JTextField precoStock;
    private boolean editar = false;
    private JTable table;
    private JTextField textSub_total;
    private JTextField textIVA;
    private JTextField textDesconto;
    private JTextField textTotal;
    private JTable table_1;
    private JTextField textProcurarClienteBI;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField biCliente;
    private JTextField nomeCliente;


    //Criar Armario
    Armario armario = new Armario();
    //Defenir farmacia
    Farmacia farmacia = new Farmacia();

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.windows.Windows.LookAndFeel");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Layout frame = new Layout();
                    //  frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Layout(Funcionario funcionario, int nrloja, Farmacia farmacia_serializada) {
        //Gestor de Vendas
        GestorVendas gestorvendas = new GestorVendas();
        //Gestor de Clientes
        GestorClientes gestorClientes = new GestorClientes();
        //Criar uma venda
        Venda venda1 = new Venda("Tánia");
        Venda venda2 = new Venda("Jéssica");
        Venda venda3 = new Venda("Cátia");
        Venda venda4 = new Venda("Tánia");
        //Criar uma compra que é uma arraylist de Medicamentos
        ArrayList<Medicamento> compra1 = new ArrayList<>();
        ArrayList<Medicamento> compra2 = new ArrayList<>();
        ArrayList<Medicamento> compra3 = new ArrayList<>();
        ArrayList<Medicamento> compra4 = new ArrayList<>();
        //Criar Medicamento para inserir na compra
        Medicamento medicamento1 = new Medicamento();
        Medicamento medicamento2 = new Medicamento();
        //Definir medicamento
        medicamento1.setNome("Benuron");
        medicamento1.setCategoria(0);
        medicamento1.setViaAdmin(0);
        medicamento1.setPreco(13.2f);
        medicamento1.setDataValidade(new Date());
        //medicamento 2
        medicamento2.setNome("Aspirina");
        medicamento2.setCategoria(1);
        medicamento2.setViaAdmin(0);
        medicamento2.setPreco(15.0f);
        medicamento2.setDataValidade(new Date());
        //Adicionar clientes ao Gestor de Clientes
        Cliente cliente1 = new Cliente(1, "Paulo", 121222, new Date());
        Cliente cliente2 = new Cliente(2, "José", 1212322, new Date());
        Cliente cliente3 = new Cliente(3, "Manel", 1344562, new Date());

        //Defenir a venda
        venda1.setCod_venda(102);
        venda1.setData_compra(new Date());
        venda1.setCliente(cliente1);
        venda2.setCod_venda(103);
        venda2.setData_compra(new Date());
        venda2.setCliente(cliente2);
        venda3.setCod_venda(104);
        venda3.setData_compra(new Date());
        venda3.setCliente(cliente3);
        venda4.setCod_venda(105);
        venda4.setData_compra(new Date());
        venda4.setCliente(cliente3);
        //Adicionar medicamento na compra
        compra1.add(medicamento1);
        compra1.add(medicamento2);
        compra2.add(medicamento1);
        compra2.add(medicamento1);
        compra3.add(medicamento1);
        compra3.add(medicamento2);
        compra3.add(medicamento2);
        compra3.add(medicamento1);
        compra4.add(medicamento1);
        compra4.add(medicamento1);
        compra4.add(medicamento1);
        compra4.add(medicamento1);
        //Adicionar o arraylist dos medicamentos
        venda1.setMedicamentos(compra1);
        venda2.setMedicamentos(compra2);
        venda3.setMedicamentos(compra3);
        venda4.setMedicamentos(compra4);
        //Adicionar Vendas ao gestor de vendas
        gestorvendas.adicionarVenda(venda1);
        gestorvendas.adicionarVenda(venda2);
        gestorvendas.adicionarVenda(venda3);
        gestorvendas.adicionarVenda(venda4);
        //Adicionar clientes
        gestorClientes.setCliente(cliente1);
        gestorClientes.setCliente(cliente2);
        gestorClientes.setCliente(cliente3);


        // Serializaçao
        if (farmacia_serializada.getNome().isEmpty()) {
            try {
                farmacia = new Farmacia("Médis", gestorvendas, new Armario[3], gestorClientes);
                farmacia.armarios[0] = new Armario();
                farmacia.armarios[1] = new Armario();
                farmacia.armarios[2] = new Armario();
                FileOutputStream fileOut = new FileOutputStream("Farmacia.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(farmacia);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data foi guardada em Farmacia.ser");
            } catch (IOException i) {
                i.printStackTrace();
            }
        } else {
            farmacia = farmacia_serializada;
            System.out.println("a carregar Armario existente em ficheiro...");
        }

        //Gravar farmacia ao fechar programa
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {

                try {
                    FileOutputStream fileOut = new FileOutputStream("Farmacia.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(farmacia);
                    out.close();
                    fileOut.close();
                    System.out.printf("Serialized data foi guardada em Farmacia.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                    farmacia = farmacia_serializada;
                }
            }

        });

        getContentPane().setLayout(new CardLayout(0, 0));
        setBounds(100, 100, 1138, 684);

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
        btnRelatorioRelatorio.setEnabled(false);
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

        JLabel lblUltimosRelatrios = new JLabel("Relatórios do Dia");
        lblUltimosRelatrios.setBounds(31, 100, 135, 16);
        relatorio.add(lblUltimosRelatrios);

        JLabel lblAlertas = new JLabel("Relatorios da Semana");
        lblAlertas.setBounds(338, 100, 108, 16);
        relatorio.add(lblAlertas);

        JList list_3 = new JList();

        list_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Relatorio relat = new Relatorio(farmacia.gestorvendas.getVendas().get(list_3.getSelectedIndex()), "Costa-Prozelo");

                    Dialog dialog = new Dialog(relat);
                    dialog.setVisible(true);
                }
            }
        });

        list_3.setBorder(new LineBorder(new Color(0, 0, 0)));
        list_3.setBounds(31, 123, 291, 185);
        relatorio.add(list_3);

        try {
            list_3.setListData(farmacia.gestorvendas.getVendas().toArray());

            JList list = new JList();
            list.setBorder(new LineBorder(new Color(0, 0, 0)));
            list.setBounds(338, 123, 300, 185);
            relatorio.add(list);

            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(null, "Estatiticas dos Medicamentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            panel.setBounds(31, 330, 402, 311);
            relatorio.add(panel);
            panel.setLayout(null);

            JLabel lblViaDeAdministrao_1 = new JLabel("Via de Administração");
            lblViaDeAdministrao_1.setBounds(10, 27, 104, 14);
            panel.add(lblViaDeAdministrao_1);

            JComboBox comboBox_1 = new JComboBox(vias);

            comboBox_1.setBounds(10, 52, 159, 20);
            panel.add(comboBox_1);

            JScrollPane scrollPane_Estatisticas = new JScrollPane();
            scrollPane_Estatisticas.setBounds(10, 83, 382, 217);
            panel.add(scrollPane_Estatisticas);

            table_1 = new JTable();

            //Default
            DefaultTableModel model_d = new DefaultTableModel(new Object[]{"Nome Categoria", "Quantidade", "Preço Total"}, 0);
            //Adiciona os medicamentos na tablela
            try {
                for (int i = 0; i < 20; i++) {
                    model_d.addRow(new Object[]{categorias[i], farmacia.armarios[nrloja].getQuantidadGaveta(i, 0), farmacia.armarios[nrloja].getPrecoGaveta(i, 0)});
                }
                table_1.setModel(model_d);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Sem medicamentos..");
            }
            comboBox_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    DefaultTableModel model = new DefaultTableModel(new Object[]{"Nome Categoria", "Quantidade", "Preço Total"}, 0);
                    //Adiciona os medicamentos na tablela
                    for (int i = 0; i < 20; i++) {
                        model.addRow(new Object[]{categorias[i], farmacia.armarios[nrloja].getQuantidadGaveta(i, comboBox_1.getSelectedIndex()), farmacia.armarios[nrloja].getPrecoGaveta(i, comboBox_1.getSelectedIndex())});
                    }
                    table_1.setModel(model);
                }
            });
            //Cria a tabela
            //Cria a estrutura e campos representados em cada celula
            scrollPane_Estatisticas.setViewportView(table_1);

        } catch (NullPointerException e) {
            //se o objecto for nulo não fazer nada :)
        }

        //Botao home
        JButton btnHome = new JButton("Home");
        btnHome.setEnabled(false);
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

        try {
            JList list = new JList(farmacia.armarios[nrloja].getArmarioGaveta(0, 0).getMedicamentos().toArray());
            list.setBounds(31, 261, 386, 244);
            main.add(list);

        } catch (Exception e) {

        }

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

        JLabel lblNewLabel_1 = new JLabel("Loja:");
        lblNewLabel_1.setBounds(10, 15, 46, 14);
        main.add(lblNewLabel_1);

        JLabel textLoja = new JLabel();
        textLoja.setBounds(57, 15, 46, 14);
        textLoja.setText(farmacias[nrloja]);
        main.add(textLoja);


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
        button_3.setEnabled(false);
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

        JPanel panel_9 = new JPanel();
        panel_9.setBorder(new TitledBorder(null, "Detalhes Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_9.setBounds(555, 205, 211, 188);
        venda.add(panel_9);
        panel_9.setLayout(null);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(6, 22, 46, 14);
        panel_9.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(6, 40, 199, 20);
        panel_9.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblBi = new JLabel("Nrº Contribuinte");
        lblBi.setBounds(6, 71, 199, 14);
        panel_9.add(lblBi);

        textField = new JTextField();
        textField.setBounds(6, 98, 199, 20);
        panel_9.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Data Criacao Conta");
        lblNewLabel_4.setBounds(6, 129, 199, 14);
        panel_9.add(lblNewLabel_4);

        textField_1 = new JTextField();
        textField_1.setBounds(6, 154, 195, 20);
        panel_9.add(textField_1);
        textField_1.setColumns(10);

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, "Detalhes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5.setBounds(17, 447, 525, 190);
        venda.add(panel_5);
        panel_5.setLayout(null);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 20, 505, 153);
        panel_5.add(scrollPane_2);

        JPanel panel_10 = new JPanel();
        panel_10.setBorder(new TitledBorder(null, "Estado Compra", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_10.setBounds(562, 447, 204, 187);
        venda.add(panel_10);
        panel_10.setLayout(null);

        JLabel lblSubtotal = new JLabel("Sub-Total:");
        lblSubtotal.setBounds(6, 18, 55, 16);
        panel_10.add(lblSubtotal);

        JLabel lblIva = new JLabel("IVA:");
        lblIva.setBounds(6, 43, 55, 16);
        panel_10.add(lblIva);

        JLabel lblDesconto = new JLabel("Desconto:");
        lblDesconto.setBounds(6, 71, 55, 16);
        panel_10.add(lblDesconto);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(6, 99, 55, 16);
        panel_10.add(lblTotal);

        textSub_total = new JTextField();
        textSub_total.setBounds(71, 16, 86, 20);
        panel_10.add(textSub_total);
        textSub_total.setColumns(10);

        textIVA = new JTextField();
        textIVA.setBounds(71, 41, 86, 20);
        panel_10.add(textIVA);
        textIVA.setColumns(10);

        textDesconto = new JTextField();
        textDesconto.setBounds(71, 69, 86, 20);
        panel_10.add(textDesconto);
        textDesconto.setColumns(10);

        textTotal = new JTextField();
        textTotal.setBounds(71, 97, 86, 20);
        panel_10.add(textTotal);
        textTotal.setColumns(10);


        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new TitledBorder(null, "Vendas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_4.setBounds(17, 205, 525, 188);
        venda.add(panel_4);
        panel_4.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 18, 500, 156);
        panel_4.add(scrollPane);
        //Define qual a Model vai estar a representar na jList
        JList list_1 = new JList(farmacia.gestorvendas.getVendas().toArray());

        list_1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                DefaultListModel model1 = new DefaultListModel();
                //Adicionar Elementos caso exista medicamentos na gaveta, caso nao haja remove tudo
                try {
                    //Tabela
                    //Recebe medicamentos da venda selecionada
                    ArrayList<Medicamento> med = farmacia.gestorvendas.getVendas().get(list_1.getSelectedIndex()).getMedicamentos();
                    //Cria a tabela
                    table = new JTable();
                    //Cria a estrutura e campos representados em cada celula
                    DefaultTableModel model = new DefaultTableModel(new Object[]{"Nome", "Categoria", "Via de Administração", "Data Validade", "Preço"}, 0);
                    //Adiciona os medicamentos na tablela
                    for (Medicamento meds : med) {
                        model.addRow(new Object[]{meds.getNome(), categorias[meds.getCategoria()], vias[meds.getViaAdmin()], meds.getDataValidade(), meds.getPreco()});
                    }
                    table.setModel(model);
                    scrollPane_2.setViewportView(table);
                    //Alterar Valores de preco,desconto, etc.. de cada Venda
                    textTotal.setText(String.valueOf(farmacia.gestorvendas.getVendas().get(list_1.getSelectedIndex()).getPreco_total()));
                    textIVA.setText(String.valueOf(farmacia.gestorvendas.getVendas().get(list_1.getSelectedIndex()).getIVA()));
                    textDesconto.setText(String.valueOf(farmacia.gestorvendas.getVendas().get(list_1.getSelectedIndex()).getDesconto()));
                    textSub_total.setText(String.valueOf(farmacia.gestorvendas.getVendas().get(list_1.getSelectedIndex()).getPreco_sub()));
                } catch (Exception e1) {
                    model1.removeAllElements();
                }

            }
        });
        scrollPane.setViewportView(list_1);
        //Criar evento caso a Categoria seja Alterada!
        comboBoxCategoria.addActionListener(e -> {
            try {
                ArrayList<Medicamento> med = farmacia.armarios[nrloja].getArmarioGaveta(comboBoxCategoria.getSelectedIndex(), comboBoxViaAdmin.getSelectedIndex()).getMedicamentos();
                DefaultListModel model1 = (DefaultListModel) list_1.getModel();
                model1.removeAllElements();
                for (Medicamento medicamento : med) {
                    model1.addElement(medicamento.toString());
                }
            } catch (Exception e1) {
                //model1.removeAllElements();
            }
        });
        //Criar evento caso a Via de Administraçao seja Alterada!
        comboBoxViaAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Medicamento> med = farmacia.armarios[nrloja].getArmarioGaveta(comboBoxCategoria.getSelectedIndex(), comboBoxViaAdmin.getSelectedIndex()).getMedicamentos();
                    DefaultListModel model = (DefaultListModel) list_1.getModel();
                    model.removeAllElements();
                    for (Medicamento medicamento : med) {
                        model.addElement(medicamento.toString());
                    }
                } catch (Exception e1) {
                    //model.removeAllElements();
                }
            }
        });

        JButton button_15 = new JButton("Clientes");
        button_15.setEnabled(false);
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

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new TitledBorder(null, "Formulário Procurar Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_6.setBounds(31, 272, 468, 87);
        clientes.add(panel_6);
        panel_6.setLayout(null);

        textProcurarClienteNome = new JTextField();
        textProcurarClienteNome.setBounds(26, 53, 124, 20);
        panel_6.add(textProcurarClienteNome);
        textProcurarClienteNome.setColumns(10);

        JButton btnAdicionarCliente = new JButton("Procurar");
        btnAdicionarCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                farmacia.gestorclientes.procurarCliente(textProcurarClienteNome.getText(), farmacia);
            }
        });
        btnAdicionarCliente.setBounds(304, 50, 120, 26);
        panel_6.add(btnAdicionarCliente);

        JLabel lblNewLabel_2 = new JLabel("Nome");
        lblNewLabel_2.setBounds(26, 28, 46, 14);
        panel_6.add(lblNewLabel_2);

        JLabel lblBi_1 = new JLabel("Nº Contribuinte");
        lblBi_1.setBounds(170, 28, 120, 14);
        panel_6.add(lblBi_1);

        textProcurarClienteBI = new JTextField();
        textProcurarClienteBI.setBounds(170, 53, 124, 20);
        panel_6.add(textProcurarClienteBI);
        textProcurarClienteBI.setColumns(10);

        JPanel panel_11 = new JPanel();
        panel_11.setBorder(new TitledBorder(null, "Adicionar Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_11.setBounds(31, 91, 468, 119);
        clientes.add(panel_11);
        GridBagLayout gbl_panel_11 = new GridBagLayout();
        gbl_panel_11.columnWidths = new int[]{28, 101, 172, 0, 0, 0, 0};
        gbl_panel_11.rowHeights = new int[]{26, 26, 26};
        gbl_panel_11.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_11.rowWeights = new double[]{0.0, 0.0, 0.0};
        panel_11.setLayout(gbl_panel_11);

        JLabel lblBi_2 = new JLabel("BI:");
        GridBagConstraints gbc_lblBi_2 = new GridBagConstraints();
        gbc_lblBi_2.anchor = GridBagConstraints.WEST;
        gbc_lblBi_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblBi_2.gridx = 1;
        gbc_lblBi_2.gridy = 0;
        panel_11.add(lblBi_2, gbc_lblBi_2);

        biCliente = new JTextField();
        GridBagConstraints gbc_biCliente = new GridBagConstraints();
        gbc_biCliente.insets = new Insets(0, 0, 5, 5);
        gbc_biCliente.fill = GridBagConstraints.HORIZONTAL;
        gbc_biCliente.gridx = 2;
        gbc_biCliente.gridy = 0;
        panel_11.add(biCliente, gbc_biCliente);
        biCliente.setColumns(10);

        JLabel lblDatainscrio = new JLabel("DataInscrição");
        GridBagConstraints gbc_lblDatainscrio = new GridBagConstraints();
        gbc_lblDatainscrio.anchor = GridBagConstraints.WEST;
        gbc_lblDatainscrio.insets = new Insets(0, 0, 5, 5);
        gbc_lblDatainscrio.gridx = 1;
        gbc_lblDatainscrio.gridy = 1;
        panel_11.add(lblDatainscrio, gbc_lblDatainscrio);

        JDateChooser dateChooser = new JDateChooser();
        GridBagConstraints gbc_dateChooser = new GridBagConstraints();
        gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
        gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
        gbc_dateChooser.gridx = 2;
        gbc_dateChooser.gridy = 1;
        panel_11.add(dateChooser, gbc_dateChooser);

        JLabel lblNome_1 = new JLabel("Nome:");
        GridBagConstraints gbc_lblNome_1 = new GridBagConstraints();
        gbc_lblNome_1.anchor = GridBagConstraints.WEST;
        gbc_lblNome_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblNome_1.gridx = 1;
        gbc_lblNome_1.gridy = 2;
        panel_11.add(lblNome_1, gbc_lblNome_1);

        nomeCliente = new JTextField();
        GridBagConstraints gbc_nomeCliente = new GridBagConstraints();
        gbc_nomeCliente.insets = new Insets(0, 0, 0, 5);
        gbc_nomeCliente.fill = GridBagConstraints.HORIZONTAL;
        gbc_nomeCliente.gridx = 2;
        gbc_nomeCliente.gridy = 2;
        panel_11.add(nomeCliente, gbc_nomeCliente);
        nomeCliente.setColumns(10);

        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new TitledBorder(null, "Detalhes sobre Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_7.setBounds(517, 91, 468, 144);
        clientes.add(panel_7);
        panel_7.setLayout(null);

        JLabel lblTotalClientes = new JLabel("Total Clientes: ");
        lblTotalClientes.setBounds(271, 40, 78, 16);
        panel_7.add(lblTotalClientes);

        JLabel lblEsteMs = new JLabel("Nº Clientes este Mês:");
        lblEsteMs.setBounds(10, 40, 141, 16);
        panel_7.add(lblEsteMs);

        JLabel lblNewLabel_3 = new JLabel("Nº de Clientes esta semana:");
        lblNewLabel_3.setBounds(10, 17, 141, 14);
        panel_7.add(lblNewLabel_3);

        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_8.setBounds(31, 368, 460, 211);
        clientes.add(panel_8);
        panel_8.setLayout(null);

        JList listClientes = new JList(farmacia.gestorclientes.getClientes().toArray());
        listClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Cliente cliente = new Cliente();
                    cliente = (Cliente) listClientes.getSelectedValue();
                    if (farmacia.gestorvendas.getVendas(cliente).size()>0) {
                        Relatorio relat = new Relatorio(farmacia.gestorvendas.getVendas(cliente), "Costa-Prozelo");
                        Dialog dialog = new Dialog(relat);
                        dialog.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "O cliente: "+ cliente.getNome()+" ainda não efectuou compras!");
                    }
                }
            }
        });
        listClientes.setBounds(6, 16, 448, 188);
        panel_8.add(listClientes);
        listClientes.setBorder(new LineBorder(new Color(0, 0, 0)));

        JButton btnRemover = new JButton("Remover Cliente");
        btnRemover.setBounds(715, 524, 120, 26);
        clientes.add(btnRemover);

        JButton btnAdicionar_2 = new JButton("Adicionar Cliente");
        btnAdicionar_2.setBounds(196, 221, 162, 26);
        clientes.add(btnAdicionar_2);
        btnAdicionar_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnAdicionar_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.out.println(farmacia.gestorclientes.clientes.size());
                Cliente cliente = new Cliente(farmacia.gestorclientes.clientes.size() + 1, nomeCliente.getText(), Integer.parseInt(biCliente.getText()), dateChooser.getDate());
                farmacia.gestorclientes.clientes.add(cliente);


                listClientes.setListData(farmacia.gestorclientes.getClientes().toArray());
            }
        });


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
        btnStockStock.setEnabled(false);
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
                System.out.print(textPesquisarStock.getText());
                Medicamento m = new Medicamento(farmacia.armarios[nrloja].procurarMedicamento(textPesquisarStock.getText()));
                System.out.print(m.getNome());

            }
        });
        btnPesquisar.setBounds(346, 306, 98, 26);
        stock.add(btnPesquisar);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Informação detalhada: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(477, 345, 358, 270);
        stock.add(panel_1);

        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{8, 156, 210, 0};
        gbl_panel_1.rowHeights = new int[]{0, 32, 30, 34, 22, 10, 65, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);

        JLabel lblNome_3 = new JLabel("Nome:");
        GridBagConstraints gbc_lblNome_3 = new GridBagConstraints();
        gbc_lblNome_3.anchor = GridBagConstraints.WEST;
        gbc_lblNome_3.fill = GridBagConstraints.VERTICAL;
        gbc_lblNome_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNome_3.gridx = 1;
        gbc_lblNome_3.gridy = 1;
        panel_1.add(lblNome_3, gbc_lblNome_3);

        nomeStock = new JTextField();
        nomeStock.setEditable(false);
        GridBagConstraints gbc_nomeStock = new GridBagConstraints();
        gbc_nomeStock.insets = new Insets(0, 0, 5, 0);
        gbc_nomeStock.fill = GridBagConstraints.HORIZONTAL;
        gbc_nomeStock.gridx = 2;
        gbc_nomeStock.gridy = 1;
        panel_1.add(nomeStock, gbc_nomeStock);
        nomeStock.setColumns(10);

        JLabel lblCategoria_2 = new JLabel("Categoria:");
        GridBagConstraints gbc_lblCategoria_2 = new GridBagConstraints();
        gbc_lblCategoria_2.anchor = GridBagConstraints.WEST;
        gbc_lblCategoria_2.fill = GridBagConstraints.VERTICAL;
        gbc_lblCategoria_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblCategoria_2.gridx = 1;
        gbc_lblCategoria_2.gridy = 2;
        panel_1.add(lblCategoria_2, gbc_lblCategoria_2);

        JComboBox comboBox = new JComboBox(categorias);
        comboBox.setEnabled(false);
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 2;
        gbc_comboBox.gridy = 2;
        panel_1.add(comboBox, gbc_comboBox);

        JLabel lblViaDeAdministrao = new JLabel("Via de Administração:");
        GridBagConstraints gbc_lblViaDeAdministrao = new GridBagConstraints();
        gbc_lblViaDeAdministrao.anchor = GridBagConstraints.WEST;
        gbc_lblViaDeAdministrao.fill = GridBagConstraints.VERTICAL;
        gbc_lblViaDeAdministrao.insets = new Insets(0, 0, 5, 5);
        gbc_lblViaDeAdministrao.gridx = 1;
        gbc_lblViaDeAdministrao.gridy = 3;
        panel_1.add(lblViaDeAdministrao, gbc_lblViaDeAdministrao);

        JComboBox comboBox_1 = new JComboBox(vias);
        comboBox_1.setEnabled(false);
        GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
        gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
        gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_1.gridx = 2;
        gbc_comboBox_1.gridy = 3;
        panel_1.add(comboBox_1, gbc_comboBox_1);

        JLabel lblDataValidade_1 = new JLabel("Data Validade");
        GridBagConstraints gbc_lblDataValidade_1 = new GridBagConstraints();
        gbc_lblDataValidade_1.anchor = GridBagConstraints.WEST;
        gbc_lblDataValidade_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblDataValidade_1.fill = GridBagConstraints.VERTICAL;
        gbc_lblDataValidade_1.gridx = 1;
        gbc_lblDataValidade_1.gridy = 4;
        panel_1.add(lblDataValidade_1, gbc_lblDataValidade_1);

        validadeStock = new JTextField();
        validadeStock.setEditable(false);
        GridBagConstraints gbc_validadeStock = new GridBagConstraints();
        gbc_validadeStock.insets = new Insets(0, 0, 5, 0);
        gbc_validadeStock.fill = GridBagConstraints.HORIZONTAL;
        gbc_validadeStock.gridx = 2;
        gbc_validadeStock.gridy = 4;
        panel_1.add(validadeStock, gbc_validadeStock);
        validadeStock.setColumns(10);

        JLabel lblPreo_1 = new JLabel("Preço:");
        GridBagConstraints gbc_lblPreo_1 = new GridBagConstraints();
        gbc_lblPreo_1.anchor = GridBagConstraints.WEST;
        gbc_lblPreo_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblPreo_1.gridx = 1;
        gbc_lblPreo_1.gridy = 5;
        panel_1.add(lblPreo_1, gbc_lblPreo_1);

        JList list_2 = new JList();

        try {
            list_2.setListData(farmacia.armarios[nrloja].getTodos().toArray());

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Sem medicamentos1");
        }

        JButton btnNewButton = new JButton("Editar");


        precoStock = new JTextField();
        precoStock.setEditable(false);
        GridBagConstraints gbc_precoStock = new GridBagConstraints();
        gbc_precoStock.insets = new Insets(0, 0, 5, 0);
        gbc_precoStock.fill = GridBagConstraints.HORIZONTAL;
        gbc_precoStock.gridx = 2;
        gbc_precoStock.gridy = 5;
        panel_1.add(precoStock, gbc_precoStock);
        precoStock.setColumns(10);
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 6;
        panel_1.add(btnNewButton, gbc_btnNewButton);

        JButton btnApagar = new JButton("Apagar");

        GridBagConstraints gbc_btnApagar = new GridBagConstraints();
        gbc_btnApagar.gridx = 2;
        gbc_btnApagar.gridy = 6;
        panel_1.add(btnApagar, gbc_btnApagar);


        list_2.setBounds(61, 131, 423, 255);
        //Inicializar o Scroll Pane para termos barra de scroll
        JScrollPane scrollPane_1 = new JScrollPane();

        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (editar == false) {
                    btnNewButton.setText("Gravar");
                    Medicamento medic = new Medicamento();
                    medic = (Medicamento) list_2.getSelectedValue();

                    nomeStock.setEditable(true);
                    comboBox.setEnabled(true);
                    comboBox_1.setEnabled(true);

                    validadeStock.setEditable(true);
                    precoStock.setEditable(true);

                    editar = !editar;


                } else {
                    Medicamento medic = new Medicamento();
                    medic = (Medicamento) list_2.getSelectedValue();
                    medic.setNome(nomeStock.getText());
                    medic.setPreco(Float.parseFloat(precoStock.getText()));
                    medic.setCategoria(comboBox.getSelectedIndex());
                    medic.setViaAdmin(comboBox_1.getSelectedIndex());

                    farmacia.armarios[nrloja].atualizarMedicamento(medic);

                    nomeStock.setEditable(false);
                    comboBox.setEnabled(false);
                    comboBox_1.setEnabled(false);

                    validadeStock.setEditable(false);
                    precoStock.setEditable(false);

                    scrollPane_1.revalidate();
                    scrollPane_1.repaint();

                    //variavel para controlar botao editar
                    editar = !editar;
                    btnNewButton.setText("Editar");
                }
            }
        });
        scrollPane_1.setViewportView(list_2);
        scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_1.setBounds(31, 343, 436, 276);
        //Adicona o scroll pane ao painel Stock
        stock.add(scrollPane_1);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(null, "Adicionar Medicamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_3.setBounds(25, 87, 998, 212);
        stock.add(panel_3);
        panel_3.setLayout(null);

        Panel panel_2 = new Panel();
        panel_2.setBounds(6, 16, 441, 188);
        panel_3.add(panel_2);
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[]{19, 176, 225, 0};
        gbl_panel_2.rowHeights = new int[]{20, -2, 0, 0, 0, 0, 0, 0};
        gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
        gbc_label_1.insets = new Insets(0, 0, 5, 0);
        gbc_label_1.gridx = 2;
        gbc_label_1.gridy = 0;
        panel_2.add(label_1, gbc_label_1);

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
        gbc_comboVia.insets = new Insets(0, 0, 5, 0);
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
        gbc_textNome.insets = new Insets(0, 0, 5, 0);
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
        gbc_textQuantidade.insets = new Insets(0, 0, 5, 0);
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
        gbc_textPreco.insets = new Insets(0, 0, 5, 0);
        gbc_textPreco.fill = GridBagConstraints.HORIZONTAL;
        gbc_textPreco.gridx = 2;
        gbc_textPreco.gridy = 4;
        panel_2.add(textPreco, gbc_textPreco);
        textPreco.setColumns(10);

        JLabel lblDataValidade_2 = new JLabel("Data Validade");
        GridBagConstraints gbc_lblDataValidade_2 = new GridBagConstraints();
        gbc_lblDataValidade_2.anchor = GridBagConstraints.WEST;
        gbc_lblDataValidade_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblDataValidade_2.gridx = 1;
        gbc_lblDataValidade_2.gridy = 5;
        panel_2.add(lblDataValidade_2, gbc_lblDataValidade_2);

        JDateChooser dateChooser_1 = new JDateChooser();
        GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
        gbc_dateChooser_1.insets = new Insets(0, 0, 5, 0);
        gbc_dateChooser_1.fill = GridBagConstraints.BOTH;
        gbc_dateChooser_1.gridx = 2;
        gbc_dateChooser_1.gridy = 5;
        panel_2.add(dateChooser_1, gbc_dateChooser_1);

        //Botao Adicionar Medicamento
        JButton btnAdicionarGerir = new JButton("Adicionar");
        GridBagConstraints gbc_btnAdicionarGerir = new GridBagConstraints();
        gbc_btnAdicionarGerir.gridx = 2;
        gbc_btnAdicionarGerir.gridy = 6;
        panel_2.add(btnAdicionarGerir, gbc_btnAdicionarGerir);
        btnAdicionarGerir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (textNome.getText() != null && textQuantidade.getText() != null) {
                    try {
                        Medicamento medic = new Medicamento(textNome.getText(), Integer.valueOf(textPreco.getText()), comboCat.getSelectedIndex(), comboVia.getSelectedIndex(), dateChooser_1.getDate());
                        farmacia.armarios[nrloja].adicionarMedicamento(medic, Integer.valueOf(textQuantidade.getText()));
                        Object[] modelMedic = farmacia.armarios[nrloja].getTodos().toArray();

                        list_2.setListData(modelMedic);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao introduzir medicamento");
                    }
                }
            }
        });

        //Evento Selection change e mostra os valores detalhados no form ao lado
        list_2.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                Medicamento s = (Medicamento) list_2.getSelectedValue();
                nomeStock.setText(s.getNome());
                comboBox.setSelectedIndex(s.getCategoria());
                comboBox_1.setSelectedIndex(s.getViaAdmin());

                validadeStock.setText(s.getDataValidade().toString());
                precoStock.setText(String.valueOf(s.getPreco()));

                //Coloca as texbox BLOQUEADAS
                nomeStock.setEditable(false);
                comboBox.setEnabled(false);
                comboBox_1.setEnabled(false);

                validadeStock.setEditable(false);
                precoStock.setEditable(false);
                //variavel para controlar botao editar
                editar = false;
                btnNewButton.setText("Editar");
            }
        });
        //botao apagar medicamento
        btnApagar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    Medicamento s = (Medicamento) list_2.getSelectedValue();
                    farmacia.armarios[nrloja].removerMedicamento(s);
                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e);
                }
                try {
                    list_2.setListData(farmacia.armarios[nrloja].getTodos().toArray());
                    scrollPane_1.revalidate();
                    scrollPane_1.repaint();
                } catch (NullPointerException e) {
                    //se o objecto for nulo não fazer nada :)

                }
            }
        });

    }
}
