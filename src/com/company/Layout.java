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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;

import javax.swing.border.LineBorder;


import com.toedter.calendar.JDateChooser;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class Layout extends JFrame implements Variaveis {
    private JPanel main;
    private JPanel venda;
    private JPanel cliente;
    private JTextField txtNome_;
    private JTextField textProcurarClienteNome;
    private JTextField textPesquisarStock;
    private JTextField textNome;
    private JTextField textQuantidade;
    private JTextField textPreco;
    private JTextField nomeStock;
    private JTextField validadeStock;
    private JTextField precoStock;
    private boolean editarMedic = false;
    private boolean editarCli = false;
    private JTable table;
    private JTextField textSub_total;
    private JTextField textIVA;
    private JTextField textDesconto;
    private JTextField textTotal;
    private JTable table_1;
    private JTextField textProcurarClienteBI;
    private JTextField textNR;
    private JTextField textData_c;
    private JTextField biCliente;
    private JTextField nomeCliente;


    //Criar Armario
    Armario armario = new Armario();
    //Defenir farmacia
    Farmacia farmacia = new Farmacia();
    private JTable table_2;
    private JTable table_3;
    private JTextField textField;
    private JTextField textField_1;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //Layout frame = new Layout();
                    // frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Layout( int nrloja, Farmacia farmacia_serializada) {
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
        setBounds(100, 100, 1138, 725);

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


        //   System.out.println(formattedDate);

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
        
        JPanel panel_16 = new JPanel();
        panel_16.setBounds(0, 0, 764, 23);
        relatorio.add(panel_16);
        GridBagLayout gbl_panel_16 = new GridBagLayout();
        gbl_panel_16.columnWidths = new int[]{87, 46, 143, 113, 234, 206, 0};
        gbl_panel_16.rowHeights = new int[]{23, 0};
        gbl_panel_16.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_16.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panel_16.setLayout(gbl_panel_16);
        
        JLabel label_13 = new JLabel("Loja:");
        GridBagConstraints gbc_label_13 = new GridBagConstraints();
        gbc_label_13.anchor = GridBagConstraints.EAST;
        gbc_label_13.insets = new Insets(0, 0, 0, 5);
        gbc_label_13.gridx = 0;
        gbc_label_13.gridy = 0;
        panel_16.add(label_13, gbc_label_13);
        
        JLabel label_14 = new JLabel();
        label_14.setText("Loja 1");
        GridBagConstraints gbc_label_14 = new GridBagConstraints();
        gbc_label_14.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_14.insets = new Insets(0, 0, 0, 5);
        gbc_label_14.gridx = 1;
        gbc_label_14.gridy = 0;
        panel_16.add(label_14, gbc_label_14);
        
        JLabel label_15 = new JLabel("Funcionário:");
        GridBagConstraints gbc_label_15 = new GridBagConstraints();
        gbc_label_15.anchor = GridBagConstraints.EAST;
        gbc_label_15.insets = new Insets(0, 0, 0, 5);
        gbc_label_15.gridx = 2;
        gbc_label_15.gridy = 0;
        panel_16.add(label_15, gbc_label_15);
        
        JLabel label_16 = new JLabel(farmacia.getFuncionarioNome());
        GridBagConstraints gbc_label_16 = new GridBagConstraints();
        gbc_label_16.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_16.insets = new Insets(0, 0, 0, 5);
        gbc_label_16.gridx = 3;
        gbc_label_16.gridy = 0;
        panel_16.add(label_16, gbc_label_16);
        
        JLabel label_17 = new JLabel("Tue Jun 05 19:49:43 BST 2018");
        GridBagConstraints gbc_label_17 = new GridBagConstraints();
        gbc_label_17.fill = GridBagConstraints.BOTH;
        gbc_label_17.gridx = 5;
        gbc_label_17.gridy = 0;
        panel_16.add(label_17, gbc_label_17);
        button_10.setBounds(517, 35, 120, 39);
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
        btnStockRelatorio.setBounds(391, 35, 108, 39);
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

        btnRelatorioRelatorio.setBounds(272, 35, 99, 39);
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
        button_13.setBounds(152, 35, 99, 39);
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
        button_14.setBounds(31, 35, 99, 39);
        relatorio.add(button_14);

        JLabel lblUltimosRelatrios = new JLabel("Relatórios do Dia");
        lblUltimosRelatrios.setBounds(31, 100, 135, 16);
        relatorio.add(lblUltimosRelatrios);

        JLabel lblAlertas = new JLabel("Relatorios da Semana");
        lblAlertas.setBounds(572, 100, 167, 16);
        relatorio.add(lblAlertas);

        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(30, 123, 530, 185);
        relatorio.add(scrollPane_3);

        JList list_3 = new JList();
        scrollPane_3.setViewportView(list_3);

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
        list_3.setListData(farmacia.gestorvendas.getVendasDia().toArray());


        try {

            JList list = new JList();
            list.setBorder(new LineBorder(new Color(0, 0, 0)));
            list.setBounds(572, 123, 527, 185);
            relatorio.add(list);

            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(null, "Estatiticas dos Medicamentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            panel.setBounds(31, 330, 402, 311);
            relatorio.add(panel);
            panel.setLayout(null);

            JLabel lblViaDeAdministrao_1 = new JLabel("Via de Administração");
            lblViaDeAdministrao_1.setBounds(10, 27, 142, 16);
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
        
        JPanel informacao_geral = new JPanel();
        informacao_geral.setBounds(0, 0, 764, 23);
        main.add(informacao_geral);
        GridBagLayout gbl_informacao_geral = new GridBagLayout();
        gbl_informacao_geral.columnWidths = new int[]{87, 46, 143, 113, 234, 206, 0};
        gbl_informacao_geral.rowHeights = new int[]{23, 0};
        gbl_informacao_geral.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_informacao_geral.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        informacao_geral.setLayout(gbl_informacao_geral);
                
                        JLabel lblNewLabel_1 = new JLabel("Loja:");
                        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
                        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
                        gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
                        gbc_lblNewLabel_1.gridx = 0;
                        gbc_lblNewLabel_1.gridy = 0;
                        informacao_geral.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
                JLabel textLoja = new JLabel();
                GridBagConstraints gbc_textLoja = new GridBagConstraints();
                gbc_textLoja.fill = GridBagConstraints.HORIZONTAL;
                gbc_textLoja.insets = new Insets(0, 0, 0, 5);
                gbc_textLoja.gridx = 1;
                gbc_textLoja.gridy = 0;
                informacao_geral.add(textLoja, gbc_textLoja);
                textLoja.setText(farmacias[nrloja]);
        
        JLabel lblFuncionrio = new JLabel("Funcionário:");
        GridBagConstraints gbc_lblFuncionrio = new GridBagConstraints();
        gbc_lblFuncionrio.anchor = GridBagConstraints.EAST;
        gbc_lblFuncionrio.insets = new Insets(0, 0, 0, 5);
        gbc_lblFuncionrio.gridx = 2;
        gbc_lblFuncionrio.gridy = 0;
        informacao_geral.add(lblFuncionrio, gbc_lblFuncionrio);
        
        JLabel lblNewLabel_7 = new JLabel("");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_7.gridx = 3;
        gbc_lblNewLabel_7.gridy = 0;
        informacao_geral.add(lblNewLabel_7, gbc_lblNewLabel_7);
        lblNewLabel_7.setText(farmacia.getFuncionarioNome());
                
                        JLabel label = new JLabel("" + new Date());
                        GridBagConstraints gbc_label = new GridBagConstraints();
                        gbc_label.fill = GridBagConstraints.BOTH;
                        gbc_label.gridx = 5;
                        gbc_label.gridy = 0;
                        informacao_geral.add(label, gbc_label);

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

        JPanel panel_12 = new JPanel();
        panel_12.setBorder(new TitledBorder(null, "Detalhes Farmacia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_12.setBounds(20, 89, 408, 129);
        main.add(panel_12);
        panel_12.setLayout(new FormLayout(new ColumnSpec[]{
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,},
                new RowSpec[]{
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,}));

        JLabel lblVendasMes = new JLabel("Total de Vendas:");
        panel_12.add(lblVendasMes, "2, 2, fill, default");

        JLabel label_t_vendas = new JLabel("" + farmacia.gestorvendas.getVendas().size());
        panel_12.add(label_t_vendas, "4, 2");

        JLabel lblProdutoMaisVendido = new JLabel("Produto mais vendido:");
        panel_12.add(lblProdutoMaisVendido, "8, 2");

        JLabel label_p_m_vendido = new JLabel("Benuron");
        panel_12.add(label_p_m_vendido, "10, 2");

        JLabel lblQuantidade = new JLabel("Total de Medicamentos:");
        panel_12.add(lblQuantidade, "2, 4, fill, default");

        JLabel label_t_meds = new JLabel("" + farmacia.armarios[nrloja].getTodos().size());
        panel_12.add(label_t_meds, "4, 4");

        JLabel lblNovosClientes = new JLabel("Total de Clientes:");
        panel_12.add(lblNovosClientes, "2, 6, fill, default");

        JLabel label_t_clientes = new JLabel("" + farmacia.gestorclientes.getClientes().size());
        panel_12.add(label_t_clientes, "4, 6");

        JLabel lblProdutosEmCaminho = new JLabel("Produtos em caminho:");
        panel_12.add(lblProdutosEmCaminho, "2, 8, fill, default");

        JPanel panel_13 = new JPanel();
        panel_13.setBorder(new TitledBorder(null, "Vendas mais recentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_13.setBounds(438, 89, 365, 170);
        main.add(panel_13);
        panel_13.setLayout(null);

        table_3 = new JTable();
        table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
        table_3.setBounds(10, 22, 345, 137);
        panel_13.add(table_3);

        JPanel panel_14 = new JPanel();
        panel_14.setBorder(new TitledBorder(null, "Produtos a caminho", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_14.setBounds(438, 270, 365, 244);
        main.add(panel_14);
        panel_14.setLayout(null);

        JScrollPane scrollPane_4 = new JScrollPane();
        table_2 = new JTable();
        scrollPane_4.setViewportView(table_2);
        try {
            DefaultTableModel model_dependentes = new DefaultTableModel(new Object[]{"Nome", "Data", "Receita", "Preço", "Estado"}, 0);

            //Recebe medicamentos da venda selecionada
            ArrayList<Medicamento> med = farmacia.getMedicamentos_pendentes();
            //Adiciona os medicamentos na tablela
            for (Medicamento meds : med) {
                model_dependentes.addRow(new Object[]{meds.getNome(), meds.getDataValidade(), meds.isReceita(), meds.getPreco(), estados[meds.getEstado()]});
            }
            scrollPane_4.setViewportView(table_2);
            table_2.setModel(model_dependentes);
            table_2.setBorder(new LineBorder(new Color(0, 0, 0)));

        } catch (Exception e1) {
            //model_d;
        }
        scrollPane_4.setBounds(10, 23, 345, 210);
        panel_14.add(scrollPane_4);


        table_2.setBorder(new LineBorder(new Color(0, 0, 0)));

        try {
            JList list = new JList(farmacia.armarios[nrloja].getArmarioGaveta(0, 0).getMedicamentos().toArray());
            list.setBorder(new LineBorder(new Color(0, 0, 0)));
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
        
        JPanel panel_15 = new JPanel();
        panel_15.setBounds(0, 0, 764, 23);
        venda.add(panel_15);
        GridBagLayout gbl_panel_15 = new GridBagLayout();
        gbl_panel_15.columnWidths = new int[]{87, 46, 143, 113, 234, 206, 0};
        gbl_panel_15.rowHeights = new int[]{23, 0};
        gbl_panel_15.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_15.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panel_15.setLayout(gbl_panel_15);
        
        JLabel label_8 = new JLabel("Loja:");
        GridBagConstraints gbc_label_8 = new GridBagConstraints();
        gbc_label_8.anchor = GridBagConstraints.EAST;
        gbc_label_8.insets = new Insets(0, 0, 0, 5);
        gbc_label_8.gridx = 0;
        gbc_label_8.gridy = 0;
        panel_15.add(label_8, gbc_label_8);
        
        JLabel label_9 = new JLabel();
        label_9.setText("Loja 1");
        GridBagConstraints gbc_label_9 = new GridBagConstraints();
        gbc_label_9.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_9.insets = new Insets(0, 0, 0, 5);
        gbc_label_9.gridx = 1;
        gbc_label_9.gridy = 0;
        panel_15.add(label_9, gbc_label_9);
        
        JLabel label_10 = new JLabel("Funcionário:");
        GridBagConstraints gbc_label_10 = new GridBagConstraints();
        gbc_label_10.anchor = GridBagConstraints.EAST;
        gbc_label_10.insets = new Insets(0, 0, 0, 5);
        gbc_label_10.gridx = 2;
        gbc_label_10.gridy = 0;
        panel_15.add(label_10, gbc_label_10);
        
        JLabel label_11 = new JLabel(farmacia.getFuncionarioNome());
        GridBagConstraints gbc_label_11 = new GridBagConstraints();
        gbc_label_11.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_11.insets = new Insets(0, 0, 0, 5);
        gbc_label_11.gridx = 3;
        gbc_label_11.gridy = 0;
        panel_15.add(label_11, gbc_label_11);
        
        JLabel label_12 = new JLabel("Tue Jun 05 19:49:43 BST 2018");
        GridBagConstraints gbc_label_12 = new GridBagConstraints();
        gbc_label_12.fill = GridBagConstraints.BOTH;
        gbc_label_12.gridx = 5;
        gbc_label_12.gridy = 0;
        panel_15.add(label_12, gbc_label_12);
        button.setBounds(517, 35, 120, 39);
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
        btnGerir.setBounds(391, 35, 108, 39);
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
        button_2.setBounds(272, 35, 99, 39);
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
        button_3.setBounds(152, 35, 99, 39);
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
        button_4.setBounds(31, 35, 99, 39);
        venda.add(button_4);

        JPanel panel_9 = new JPanel();
        panel_9.setBorder(new TitledBorder(null, "Detalhes Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_9.setBounds(558, 126, 211, 188);
        venda.add(panel_9);
        panel_9.setLayout(null);


        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, "Detalhes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5.setBounds(20, 325, 525, 190);
        venda.add(panel_5);
        panel_5.setLayout(null);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 20, 505, 153);
        panel_5.add(scrollPane_2);

        JPanel panel_10 = new JPanel();
        panel_10.setBorder(new TitledBorder(null, "Estado Compra", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_10.setBounds(558, 325, 211, 187);
        venda.add(panel_10);
        panel_10.setLayout(null);

        JLabel lblSubtotal = new JLabel("Sub-Total:");
        lblSubtotal.setBounds(6, 18, 86, 16);
        panel_10.add(lblSubtotal);

        JLabel lblIva = new JLabel("IVA:");
        lblIva.setBounds(6, 43, 55, 16);
        panel_10.add(lblIva);

        JLabel lblDesconto = new JLabel("Desconto:");
        lblDesconto.setBounds(6, 71, 86, 16);
        panel_10.add(lblDesconto);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(6, 99, 55, 16);
        panel_10.add(lblTotal);

        textSub_total = new JTextField();
        textSub_total.setBounds(84, 16, 114, 20);
        panel_10.add(textSub_total);
        textSub_total.setColumns(10);

        textIVA = new JTextField();
        textIVA.setBounds(84, 41, 114, 20);
        panel_10.add(textIVA);
        textIVA.setColumns(10);

        textDesconto = new JTextField();
        textDesconto.setBounds(84, 69, 114, 20);
        panel_10.add(textDesconto);
        textDesconto.setColumns(10);

        textTotal = new JTextField();
        textTotal.setBounds(84, 99, 114, 20);
        panel_10.add(textTotal);
        textTotal.setColumns(10);


        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new TitledBorder(null, "Vendas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_4.setBounds(20, 126, 525, 188);
        venda.add(panel_4);
        panel_4.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 18, 500, 156);
        panel_4.add(scrollPane);
        //Define qual a Model vai estar a representar na jList
        JList list_1 = new JList();

        try {
            list_1.setListData(farmacia.gestorvendas.getVendas().toArray());

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Sem vendas");
        }
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(6, 22, 46, 14);
        panel_9.add(lblNome);

        txtNome_ = new JTextField();
        txtNome_.setBounds(6, 40, 199, 20);
        panel_9.add(txtNome_);
        txtNome_.setColumns(10);

        JLabel lblBi = new JLabel("Nrº Contribuinte");
        lblBi.setBounds(6, 71, 199, 14);
        panel_9.add(lblBi);

        textNR = new JTextField();
        textNR.setBounds(6, 98, 199, 20);
        panel_9.add(textNR);
        textNR.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Data Criacao Conta");
        lblNewLabel_4.setBounds(6, 129, 199, 14);
        panel_9.add(lblNewLabel_4);

        textData_c = new JTextField();
        textData_c.setBounds(6, 154, 195, 20);
        panel_9.add(textData_c);
        textData_c.setColumns(10);

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
                    DefaultTableModel model = new DefaultTableModel(new Object[]{"Nome", "Categoria", "Via de Administração", "Data Validade", "Preço", "Estado"}, 0);
                    //Adiciona os medicamentos na tablela
                    for (Medicamento meds : med) {
                        model.addRow(new Object[]{meds.getNome(), categorias[meds.getCategoria()], vias[meds.getViaAdmin()], meds.getDataValidade(), meds.getPreco(),estados[meds.getEstado()] });
                    }
                    table.setModel(model);
                    scrollPane_2.setViewportView(table);
                    //Alterar Valores de preco,desconto, etc.. de cada Venda
                    txtNome_.setText("" + farmacia.gestorvendas.getVendas().get(list_1.getSelectedIndex()).getCliente().getNome());
                    textNR.setText("" + farmacia.gestorvendas.getVendas().get(list_1.getSelectedIndex()).getCliente().getBi());
                    textData_c.setText("" + farmacia.gestorvendas.getVendas().get(list_1.getSelectedIndex()).getCliente().getDataInscricao());

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

        JButton btnNewButton_1 = new JButton("Executar Compra");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                criarVenda venda = new criarVenda(farmacia, nrloja, list_1, list_3);
                venda.setVisible(true);
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_1.setForeground(Color.BLACK);
        btnNewButton_1.setBackground(Color.WHITE);
        btnNewButton_1.setBounds(31, 85, 156, 30);
        venda.add(btnNewButton_1);

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
        
        JPanel panel_17 = new JPanel();
        panel_17.setBounds(0, 0, 764, 23);
        clientes.add(panel_17);
        GridBagLayout gbl_panel_17 = new GridBagLayout();
        gbl_panel_17.columnWidths = new int[]{87, 46, 143, 113, 234, 206, 0};
        gbl_panel_17.rowHeights = new int[]{23, 0};
        gbl_panel_17.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_17.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panel_17.setLayout(gbl_panel_17);
        
        JLabel label_18 = new JLabel("Loja:");
        GridBagConstraints gbc_label_18 = new GridBagConstraints();
        gbc_label_18.anchor = GridBagConstraints.EAST;
        gbc_label_18.insets = new Insets(0, 0, 0, 5);
        gbc_label_18.gridx = 0;
        gbc_label_18.gridy = 0;
        panel_17.add(label_18, gbc_label_18);
        
        JLabel label_19 = new JLabel();
        label_19.setText("Loja 1");
        GridBagConstraints gbc_label_19 = new GridBagConstraints();
        gbc_label_19.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_19.insets = new Insets(0, 0, 0, 5);
        gbc_label_19.gridx = 1;
        gbc_label_19.gridy = 0;
        panel_17.add(label_19, gbc_label_19);
        
        JLabel label_20 = new JLabel("Funcionário:");
        GridBagConstraints gbc_label_20 = new GridBagConstraints();
        gbc_label_20.anchor = GridBagConstraints.EAST;
        gbc_label_20.insets = new Insets(0, 0, 0, 5);
        gbc_label_20.gridx = 2;
        gbc_label_20.gridy = 0;
        panel_17.add(label_20, gbc_label_20);
        
        JLabel label_21 = new JLabel(farmacia.getFuncionarioNome());
        GridBagConstraints gbc_label_21 = new GridBagConstraints();
        gbc_label_21.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_21.insets = new Insets(0, 0, 0, 5);
        gbc_label_21.gridx = 3;
        gbc_label_21.gridy = 0;
        panel_17.add(label_21, gbc_label_21);
        
        JLabel label_22 = new JLabel("Tue Jun 05 19:49:43 BST 2018");
        GridBagConstraints gbc_label_22 = new GridBagConstraints();
        gbc_label_22.fill = GridBagConstraints.BOTH;
        gbc_label_22.gridx = 5;
        gbc_label_22.gridy = 0;
        panel_17.add(label_22, gbc_label_22);
        button_15.setBounds(517, 35, 120, 39);
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
        btnVendasClientes.setBounds(152, 35, 99, 39);
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
        btnRelatorioClientes.setBounds(272, 35, 99, 39);
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
        btnStockClientes.setBounds(391, 35, 108, 39);
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
        btnHomeClientes.setBounds(31, 35, 99, 39);
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

        JLabel lblNome_1 = new JLabel("Nome:");
        GridBagConstraints gbc_lblNome_1 = new GridBagConstraints();
        gbc_lblNome_1.anchor = GridBagConstraints.WEST;
        gbc_lblNome_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNome_1.gridx = 1;
        gbc_lblNome_1.gridy = 0;
        panel_11.add(lblNome_1, gbc_lblNome_1);

        nomeCliente = new JTextField();
        GridBagConstraints gbc_nomeCliente = new GridBagConstraints();
        gbc_nomeCliente.insets = new Insets(0, 0, 5, 5);
        gbc_nomeCliente.fill = GridBagConstraints.HORIZONTAL;
        gbc_nomeCliente.gridx = 2;
        gbc_nomeCliente.gridy = 0;
        panel_11.add(nomeCliente, gbc_nomeCliente);
        nomeCliente.setColumns(10);

        JLabel lblBi_2 = new JLabel("Contribuinte:");
        GridBagConstraints gbc_lblBi_2 = new GridBagConstraints();
        gbc_lblBi_2.anchor = GridBagConstraints.WEST;
        gbc_lblBi_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblBi_2.gridx = 1;
        gbc_lblBi_2.gridy = 1;
        panel_11.add(lblBi_2, gbc_lblBi_2);
        
        JList listClientes = new JList(farmacia.gestorclientes.getClientes().toArray());

        biCliente = new JTextField();
        GridBagConstraints gbc_biCliente = new GridBagConstraints();
        gbc_biCliente.fill = GridBagConstraints.HORIZONTAL;
        gbc_biCliente.insets = new Insets(0, 0, 5, 5);
        gbc_biCliente.gridx = 2;
        gbc_biCliente.gridy = 1;
        panel_11.add(biCliente, gbc_biCliente);
        biCliente.setColumns(10);
        
                JButton btnAdicionar_2 = new JButton("Adicionar Cliente");
                GridBagConstraints gbc_btnAdicionar_2 = new GridBagConstraints();
                gbc_btnAdicionar_2.insets = new Insets(0, 0, 0, 5);
                gbc_btnAdicionar_2.gridx = 2;
                gbc_btnAdicionar_2.gridy = 2;
                panel_11.add(btnAdicionar_2, gbc_btnAdicionar_2);
                
                        btnAdicionar_2.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent arg0) {
                                System.out.println(farmacia.gestorclientes.clientes.size());
                
                                Cliente cliente = new Cliente(farmacia.gestorclientes.clientes.size() + 1, nomeCliente.getText(), Integer.parseInt(biCliente.getText()), Calendar.getInstance().getTime());
                                farmacia.gestorclientes.clientes.add(cliente);
                
                                listClientes.setListData(farmacia.gestorclientes.getClientes().toArray());
                            }
                        });

        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new TitledBorder(null, "Detalhes sobre Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_7.setBounds(517, 91, 468, 144);
        clientes.add(panel_7);
        panel_7.setLayout(null);

        JLabel lblTotalClientes = new JLabel("Total Clientes: ");
        lblTotalClientes.setBounds(271, 40, 92, 16);
        panel_7.add(lblTotalClientes);

        JLabel lblEsteMs = new JLabel("Nº Clientes este Mês:");
        lblEsteMs.setBounds(10, 40, 141, 16);
        panel_7.add(lblEsteMs);

        JLabel lblNewLabel_3 = new JLabel("Nº de Clientes esta semana:");
        lblNewLabel_3.setBounds(10, 17, 158, 16);
        panel_7.add(lblNewLabel_3);
        
        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setText(String.valueOf(farmacia.gestorclientes.totalClientes()));
        
        lblNewLabel_8.setBounds(365, 40, 55, 16);
        panel_7.add(lblNewLabel_8);

        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_8.setBounds(31, 368, 460, 211);
        clientes.add(panel_8);
        panel_8.setLayout(null);

        JScrollPane scrollPane_5 = new JScrollPane();
        scrollPane_5.setBounds(6, 19, 448, 186);
        panel_8.add(scrollPane_5);

      
        listClientes.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
            	
            	
                Cliente cli = new Cliente();
                if(listClientes.getSelectedValue()!=null) {
                cli = (Cliente) listClientes.getSelectedValue();

                textField.setText(cli.getNome());
                textField_1.setText(String.valueOf(cli.getBi()));
                }
            }
        });
        scrollPane_5.setViewportView(listClientes);
        listClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Cliente cliente = new Cliente();
                    cliente = (Cliente) listClientes.getSelectedValue();
                    if (farmacia.gestorvendas.getVendas(cliente).size() > 0) {
                        Relatorio relat = new Relatorio(farmacia.gestorvendas.getVendas(cliente), "Costa-Prozelo");
                        Dialog dialog = new Dialog(relat);
                        dialog.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "O cliente: " + cliente.getNome() + " ainda não efectuou compras!");
                    }
                }
            }
        });
        listClientes.setBorder(new LineBorder(new Color(0, 0, 0)));

        JLabel lblInformao = new JLabel("Editar");
        lblInformao.setBounds(553, 368, 72, 14);
        clientes.add(lblInformao);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(545, 394, 498, 174);
        clientes.add(panel_2);
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[]{0, 61, 174, 0, 0};
        gbl_panel_2.rowHeights = new int[]{5, 0, 0, 0, 0, 0, 0};
        gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_2.setLayout(gbl_panel_2);

        JLabel lblNome_5 = new JLabel("Nome:");
        GridBagConstraints gbc_lblNome_5 = new GridBagConstraints();
        gbc_lblNome_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNome_5.anchor = GridBagConstraints.WEST;
        gbc_lblNome_5.gridx = 1;
        gbc_lblNome_5.gridy = 1;
        panel_2.add(lblNome_5, gbc_lblNome_5);

        textField = new JTextField();
        textField.setEditable(false);
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 1;
        panel_2.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Contribuinte:");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.BELOW_BASELINE_LEADING;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 1;
        gbc_lblNewLabel_6.gridy = 2;
        panel_2.add(lblNewLabel_6, gbc_lblNewLabel_6);

        textField_1 = new JTextField();
        textField_1.setEditable(false);
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 2;
        gbc_textField_1.gridy = 2;
        panel_2.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton_2 = new JButton("Editar");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

                if (!editarCli) {
                    btnNewButton_2.setText("Gravar");
                    Cliente cli = new Cliente();
                    cli = (Cliente) listClientes.getSelectedValue();

                    //Ativar os componentes para editar
                    textField.setEditable(true);
                    textField_1.setEditable(true);
                    //variavel para controlar botao editar
                    editarCli = !editarCli;


                } else {

                    Cliente cli = new Cliente();
                    cli = (Cliente) listClientes.getSelectedValue();
                    cli.setNome(textField.getText());
                    cli.setBi(Integer.parseInt(textField_1.getText()));


                    farmacia.gestorclientes.setCliente(cli);

                    //Desativar os componentes de edição
                    textField.setEditable(false);
                    textField_1.setEditable(false);

                    //scrollPane_5.revalidate();
                   // scrollPane_5.repaint();

                    //variavel para controlar botao editar
                    editarCli = !editarCli;
                    btnNewButton_2.setText("Editar");
                }

            }
        });
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.anchor = GridBagConstraints.WEST;
        gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_2.gridx = 2;
        gbc_btnNewButton_2.gridy = 4;
        panel_2.add(btnNewButton_2, gbc_btnNewButton_2);

        JButton btnRemover = new JButton("Remover Cliente");
        btnRemover.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            	try {
                Cliente cliente = new Cliente();
                cliente = (Cliente) listClientes.getSelectedValue();
                
                
                farmacia.gestorclientes.removerCliente(cliente);

               listClientes.setListData(farmacia.gestorclientes.getClientes().toArray());

            	}catch (Exception e1) {
					// TODO: handle exception
				}
            }
        });
        GridBagConstraints gbc_btnRemover = new GridBagConstraints();
        gbc_btnRemover.anchor = GridBagConstraints.EAST;
        gbc_btnRemover.insets = new Insets(0, 0, 5, 0);
        gbc_btnRemover.gridx = 3;
        gbc_btnRemover.gridy = 4;
        panel_2.add(btnRemover, gbc_btnRemover);


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
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(0, 0, 764, 23);
        stock.add(panel_3);
        GridBagLayout gbl_panel_3 = new GridBagLayout();
        gbl_panel_3.columnWidths = new int[]{87, 46, 143, 113, 234, 206, 0};
        gbl_panel_3.rowHeights = new int[]{23, 0};
        gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panel_3.setLayout(gbl_panel_3);
        
        JLabel label_3 = new JLabel("Loja:");
        GridBagConstraints gbc_label_3 = new GridBagConstraints();
        gbc_label_3.anchor = GridBagConstraints.EAST;
        gbc_label_3.insets = new Insets(0, 0, 0, 5);
        gbc_label_3.gridx = 0;
        gbc_label_3.gridy = 0;
        panel_3.add(label_3, gbc_label_3);
        
        JLabel label_4 = new JLabel();
        label_4.setText("Loja 1");
        GridBagConstraints gbc_label_4 = new GridBagConstraints();
        gbc_label_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_4.insets = new Insets(0, 0, 0, 5);
        gbc_label_4.gridx = 1;
        gbc_label_4.gridy = 0;
        panel_3.add(label_4, gbc_label_4);
        
        JLabel label_5 = new JLabel("Funcionário:");
        GridBagConstraints gbc_label_5 = new GridBagConstraints();
        gbc_label_5.anchor = GridBagConstraints.EAST;
        gbc_label_5.insets = new Insets(0, 0, 0, 5);
        gbc_label_5.gridx = 2;
        gbc_label_5.gridy = 0;
        panel_3.add(label_5, gbc_label_5);
        
        JLabel label_6 = new JLabel(farmacia.getFuncionarioNome());
        GridBagConstraints gbc_label_6 = new GridBagConstraints();
        gbc_label_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_6.insets = new Insets(0, 0, 0, 5);
        gbc_label_6.gridx = 3;
        gbc_label_6.gridy = 0;
        panel_3.add(label_6, gbc_label_6);
        
        JLabel label_7 = new JLabel("Tue Jun 05 19:49:43 BST 2018");
        GridBagConstraints gbc_label_7 = new GridBagConstraints();
        gbc_label_7.fill = GridBagConstraints.BOTH;
        gbc_label_7.gridx = 5;
        gbc_label_7.gridy = 0;
        panel_3.add(label_7, gbc_label_7);
        btnHomeStock.setBounds(31, 35, 99, 39);
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
        btnVendasStock.setBounds(152, 35, 99, 39);
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
        btnRelatorioStock.setBounds(272, 35, 99, 39);
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
        btnStockStock.setBounds(391, 35, 108, 39);
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
        btnClientesStock.setBounds(517, 35, 120, 39);
        stock.add(btnClientesStock);

        JLabel lblProcurarProduto = new JLabel("Procurar Produto:");
        lblProcurarProduto.setBounds(32, 341, 141, 16);
        stock.add(lblProcurarProduto);

        textPesquisarStock = new JTextField();
        textPesquisarStock.setBounds(143, 339, 192, 20);
        stock.add(textPesquisarStock);
        textPesquisarStock.setColumns(10);
        JList list_2 = new JList();

        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                // System.out.print(textPesquisarStock.getText());
                Medicamento m = new Medicamento();
                if (farmacia.armarios[nrloja].procurarMedicamento(textPesquisarStock.getText()) != null) {
                    m = farmacia.armarios[nrloja].procurarMedicamento(textPesquisarStock.getText());
                    System.out.print(m.toString());
                    DefaultListModel model=new DefaultListModel<>();
                    model.addElement(m);
                    
                     list_2.setModel(model);

                } else {
                    System.out.print("Não existe!");
                }
            }
        });
        btnPesquisar.setBounds(347, 336, 98, 26);
        stock.add(btnPesquisar);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Editar: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(641, 355, 358, 270);
        stock.add(panel_1);

        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{8, 156, 210, 0};
        gbl_panel_1.rowHeights = new int[]{0, 32, 30, 34, 22, 10, 0, 65, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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

        JLabel lblNecessitaReceita = new JLabel("Necessita receita:");
        GridBagConstraints gbc_lblNecessitaReceita = new GridBagConstraints();
        gbc_lblNecessitaReceita.anchor = GridBagConstraints.WEST;
        gbc_lblNecessitaReceita.insets = new Insets(0, 0, 5, 5);
        gbc_lblNecessitaReceita.gridx = 1;
        gbc_lblNecessitaReceita.gridy = 6;
        panel_1.add(lblNecessitaReceita, gbc_lblNecessitaReceita);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
        rdbtnNewRadioButton_1.setEnabled(false);
        GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
        gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.WEST;
        gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnNewRadioButton_1.gridx = 2;
        gbc_rdbtnNewRadioButton_1.gridy = 6;
        panel_1.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 7;
        panel_1.add(btnNewButton, gbc_btnNewButton);

        JButton btnApagar = new JButton("Apagar");

        GridBagConstraints gbc_btnApagar = new GridBagConstraints();
        gbc_btnApagar.gridx = 2;
        gbc_btnApagar.gridy = 7;
        panel_1.add(btnApagar, gbc_btnApagar);


        list_2.setBounds(61, 131, 423, 255);
        //Inicializar o Scroll Pane para termos barra de scroll
        JScrollPane scrollPane_1 = new JScrollPane();

        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (!editarMedic) {
                    btnNewButton.setText("Gravar");
                    Medicamento medic = new Medicamento();
                    medic = (Medicamento) list_2.getSelectedValue();

                    //Ativar os componentes para editar
                    nomeStock.setEditable(true);
                    comboBox.setEnabled(true);
                    comboBox_1.setEnabled(true);
                    validadeStock.setEditable(true);
                    precoStock.setEditable(true);
                    rdbtnNewRadioButton_1.setEnabled(true);

                    //variavel para controlar botao editar
                    editarMedic = !editarMedic;


                } else {
                    boolean receita = rdbtnNewRadioButton_1.isSelected();

                    Medicamento medic = new Medicamento();
                    medic = (Medicamento) list_2.getSelectedValue();
                    medic.setNome(nomeStock.getText());
                    medic.setPreco(Float.parseFloat(precoStock.getText()));
                    medic.setCategoria(comboBox.getSelectedIndex());
                    medic.setViaAdmin(comboBox_1.getSelectedIndex());
                    medic.setReceita(receita);

                    farmacia.armarios[nrloja].atualizarMedicamento(medic);

                    //Desativar os componentes de edição
                    nomeStock.setEditable(false);
                    comboBox.setEnabled(false);
                    comboBox_1.setEnabled(false);
                    validadeStock.setEditable(false);
                    precoStock.setEditable(false);
                    rdbtnNewRadioButton_1.setEnabled(false);

                    scrollPane_1.revalidate();
                    scrollPane_1.repaint();

                    //variavel para controlar botao editar
                    editarMedic = !editarMedic;
                    btnNewButton.setText("Editar");
                }
            }
        });
        scrollPane_1.setViewportView(list_2);
        scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_1.setBounds(32, 373, 588, 276);
        //Adicona o scroll pane ao painel Stock
        stock.add(scrollPane_1);

        JLabel label_2 = new JLabel("Categoria:");
        label_2.setBounds(31, 116, 77, 16);
        stock.add(label_2);

        JLabel label_1 = new JLabel("Via Administração:");
        label_1.setBounds(207, 116, 141, 16);
        stock.add(label_1);


        JLabel lblNome_4 = new JLabel("Nome");
        lblNome_4.setBounds(31, 164, 158, 14);
        stock.add(lblNome_4);

        textNome = new JTextField();
        textNome.setBounds(207, 161, 225, 20);
        stock.add(textNome);
        textNome.setColumns(10);

        JLabel lblNewLabel = new JLabel("Quantidade");
        lblNewLabel.setBounds(31, 189, 142, 14);
        stock.add(lblNewLabel);

        textQuantidade = new JTextField();
        textQuantidade.setBounds(207, 186, 225, 20);
        stock.add(textQuantidade);
        textQuantidade.setColumns(10);

        JLabel lblPreo_2 = new JLabel("Preço:");
        lblPreo_2.setBounds(31, 214, 142, 14);
        stock.add(lblPreo_2);

        textPreco = new JTextField();
        textPreco.setBounds(207, 211, 225, 20);
        stock.add(textPreco);
        textPreco.setColumns(10);

        JLabel lblDataValidade_2 = new JLabel("Data Validade");
        lblDataValidade_2.setBounds(31, 239, 151, 14);
        stock.add(lblDataValidade_2);


        JLabel lblNewLabel_5 = new JLabel("Necessita Receita:");
        lblNewLabel_5.setBounds(31, 265, 158, 14);
        stock.add(lblNewLabel_5);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("");
        rdbtnNewRadioButton.setBounds(207, 261, 21, 21);
        stock.add(rdbtnNewRadioButton);

        JComboBox comboCat = new JComboBox(categorias);
        comboCat.setBounds(31, 136, 171, 20);
        stock.add(comboCat);

        JComboBox comboVia = new JComboBox(vias);
        comboVia.setBounds(207, 136, 225, 20);
        stock.add(comboVia);

        JDateChooser dateChooser_1 = new JDateChooser();
        dateChooser_1.setDateFormatString("dd-MM-yyyy");
        dateChooser_1.setBounds(207, 236, 225, 20);
        stock.add(dateChooser_1);

        //Botao Adicionar Medicamento
        JButton btnAdicionarGerir = new JButton("Adicionar");
        btnAdicionarGerir.setBounds(281, 288, 108, 23);
        stock.add(btnAdicionarGerir);

        JLabel lblAdicionarMedicamento = new JLabel("Adicionar Medicamento:");
        lblAdicionarMedicamento.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblAdicionarMedicamento.setBounds(31, 88, 158, 16);
        stock.add(lblAdicionarMedicamento);
        
        JButton btnNewButton_3 = new JButton("Mostrar Todos");
        btnNewButton_3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		list_2.setListData(farmacia.armarios[nrloja].getTodos().toArray());
        		
        	}
        });
        btnNewButton_3.setBounds(465, 335, 120, 28);
        stock.add(btnNewButton_3);
        btnAdicionarGerir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (textNome.getText() != null && textQuantidade.getText() != null) {
                    boolean receita = rdbtnNewRadioButton.isSelected();

                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");


                        Medicamento medic = new Medicamento(textNome.getText(), Integer.valueOf(textPreco.getText()), comboCat.getSelectedIndex(), comboVia.getSelectedIndex(), dateChooser_1.getDate(), receita);
                        System.out.println(sdf.format(dateChooser_1.getDate()));
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
                rdbtnNewRadioButton_1.setSelected(s.isReceita());


                validadeStock.setText(s.getDataValidade().toString());
                precoStock.setText(String.valueOf(s.getPreco()));

                //Coloca as texbox BLOQUEADAS
                nomeStock.setEditable(false);
                comboBox.setEnabled(false);
                comboBox_1.setEnabled(false);

                validadeStock.setEditable(false);
                precoStock.setEditable(false);
                //variavel para controlar botao editar
                editarMedic = false;
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
