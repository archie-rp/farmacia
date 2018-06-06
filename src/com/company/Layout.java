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
    DefaultListModel model = new DefaultListModel<>();

    //Criar Armario
    Armario armario = new Armario();
    //Defenir farmacia
    Farmacia farmacia = new Farmacia();
    private JTable table_2;
    private JTable table_3;
    private JTextField textField;
    private JTextField textField_1;
    private JTable table_4;


    public DefaultListModel verificarMedicamentos(int nrloja) {

        model.removeAllElements();
        for (Medicamento m_ : farmacia.armarios[nrloja].getTodos()) {

            if (m_.getDataValidade().compareTo(Calendar.getInstance().getTime()) < 0) {

                model.addElement(m_);
            }
        }
        return model;

    }


    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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

    public Layout(int nrloja, Farmacia farmacia_serializada) {
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
        setBounds(100, 100, 830, 624);

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
        label_13.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_label_13 = new GridBagConstraints();
        gbc_label_13.anchor = GridBagConstraints.EAST;
        gbc_label_13.insets = new Insets(0, 0, 0, 5);
        gbc_label_13.gridx = 0;
        gbc_label_13.gridy = 0;
        panel_16.add(label_13, gbc_label_13);

        JLabel label_14 = new JLabel();
        label_14.setText(farmacias[nrloja]);
        GridBagConstraints gbc_label_14 = new GridBagConstraints();
        gbc_label_14.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_14.insets = new Insets(0, 0, 0, 5);
        gbc_label_14.gridx = 1;
        gbc_label_14.gridy = 0;
        panel_16.add(label_14, gbc_label_14);

        JLabel label_15 = new JLabel("Funcionário:");
        label_15.setFont(new Font("Tahoma", Font.BOLD, 11));
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

        JButton button_6 = new JButton("Terminar Sessão");
        button_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                Login login = new Login();
                dispose();
                login.setVisible(true);
            }
        });
        GridBagConstraints gbc_button_6 = new GridBagConstraints();
        gbc_button_6.insets = new Insets(0, 0, 0, 5);
        gbc_button_6.gridx = 4;
        gbc_button_6.gridy = 0;
        panel_16.add(button_6, gbc_button_6);

        JLabel label_17 = new JLabel("Tue Jun 05 19:49:43 BST 2018");
        label_17.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_label_17 = new GridBagConstraints();
        gbc_label_17.fill = GridBagConstraints.BOTH;
        gbc_label_17.gridx = 5;
        gbc_label_17.gridy = 0;
        panel_16.add(label_17, gbc_label_17);
        button_10.setBounds(517, 35, 120, 39);
        relatorio.add(button_10);


        JLabel lblUltimosRelatrios = new JLabel("Relatórios do Dia");
        lblUltimosRelatrios.setFont(new Font("SansSerif", Font.BOLD, 11));
        lblUltimosRelatrios.setBounds(30, 85, 135, 16);
        relatorio.add(lblUltimosRelatrios);

        JLabel lblAlertas = new JLabel("Relatórios da Semana");
        lblAlertas.setFont(new Font("SansSerif", Font.BOLD, 11));
        lblAlertas.setBounds(457, 85, 167, 16);
        relatorio.add(lblAlertas);

        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(30, 123, 400, 150);
        relatorio.add(scrollPane_3);

        JList list_3 = new JList();
        scrollPane_3.setViewportView(list_3);

        list_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Relatorio relat = new Relatorio(farmacia.gestorvendas.getVendas().get(list_3.getSelectedIndex()), farmacias[nrloja], "Costa-Prozelo");

                    Dialog dialog = new Dialog(relat);
                    dialog.setVisible(true);
                }
            }
        });


        list_3.setBorder(new LineBorder(new Color(0, 0, 0)));
        list_3.setListData(farmacia.gestorvendas.getVendasDia().toArray());


        try {

            JList list = new JList();
            list.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        Relatorio relat = new Relatorio(farmacia.gestorvendas.getVendas().get(list_3.getSelectedIndex()), farmacias[nrloja], "Costa-Prozelo");

                        Dialog dialog = new Dialog(relat);
                        dialog.setVisible(true);
                    }
                }
            });

            list.setListData(farmacia.gestorvendas.getVendasSemana().toArray());
            list.setBorder(new LineBorder(new Color(0, 0, 0)));
            list.setBounds(457, 123, 307, 150);
            relatorio.add(list);

            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(null, "Estatiticas dos Medicamentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            panel.setBounds(30, 284, 402, 260);
            relatorio.add(panel);
            panel.setLayout(null);

            JLabel lblViaDeAdministrao_1 = new JLabel("Via de Administração");
            lblViaDeAdministrao_1.setFont(new Font("Tahoma", Font.BOLD, 11));
            lblViaDeAdministrao_1.setBounds(10, 27, 142, 16);
            panel.add(lblViaDeAdministrao_1);

            JComboBox comboBox_1 = new JComboBox(vias);


            comboBox_1.setBounds(10, 52, 159, 20);
            panel.add(comboBox_1);

            JScrollPane scrollPane_Estatisticas = new JScrollPane();
            scrollPane_Estatisticas.setBounds(10, 83, 382, 170);
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


            JLabel lblRelatoriosDoMs = new JLabel("Relatórios total");
            lblRelatoriosDoMs.setFont(new Font("SansSerif", Font.BOLD, 11));
            lblRelatoriosDoMs.setBounds(455, 284, 182, 16);
            relatorio.add(lblRelatoriosDoMs);


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
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
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
        lblFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 11));
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

        JButton btnNewButton_5 = new JButton("Terminar Sessão");
        btnNewButton_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                Login login = new Login();
                dispose();
                login.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
        gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton_5.gridx = 4;
        gbc_btnNewButton_5.gridy = 0;
        informacao_geral.add(btnNewButton_5, gbc_btnNewButton_5);

        JLabel label = new JLabel("" + new Date());
        label.setFont(new Font("Tahoma", Font.BOLD, 11));
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
        lblVendasMes.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panel_12.add(lblVendasMes, "2, 2, fill, default");

        JLabel label_t_vendas = new JLabel("" + farmacia.gestorvendas.getVendas().size());
        panel_12.add(label_t_vendas, "4, 2");

        JLabel lblProdutoMaisVendido = new JLabel("Produto mais vendido:");
        lblProdutoMaisVendido.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panel_12.add(lblProdutoMaisVendido, "8, 2");

        JLabel label_p_m_vendido = new JLabel("Benuron");
        panel_12.add(label_p_m_vendido, "10, 2");

        JLabel lblQuantidade = new JLabel("Total de Medicamentos:");
        lblQuantidade.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panel_12.add(lblQuantidade, "2, 4, fill, default");

        JLabel label_t_meds = new JLabel("" + farmacia.armarios[nrloja].getTodos().size());
        panel_12.add(label_t_meds, "4, 4");

        JLabel lblNovosClientes = new JLabel("Total de Clientes:");
        lblNovosClientes.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panel_12.add(lblNovosClientes, "2, 6, fill, default");

        JLabel label_t_clientes = new JLabel("" + farmacia.gestorclientes.getClientes().size());
        panel_12.add(label_t_clientes, "4, 6");

        JLabel lblProdutosEmCaminho = new JLabel("Produtos em caminho:");
        lblProdutosEmCaminho.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panel_12.add(lblProdutosEmCaminho, "2, 8, fill, default");

        JPanel panel_13 = new JPanel();
        panel_13.setBorder(new TitledBorder(null, "Vendas mais recentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_13.setBounds(430, 89, 365, 170);
        main.add(panel_13);
        panel_13.setLayout(null);

        table_3 = new JTable();
        table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
        table_3.setBounds(10, 22, 345, 137);
        panel_13.add(table_3);

        JPanel panel_14 = new JPanel();
        panel_14.setBorder(new TitledBorder(null, "Produtos a caminho", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_14.setBounds(430, 270, 365, 244);
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
        scrollPane_4.setBounds(10, 23, 345, 183);
        panel_14.add(scrollPane_4);
        table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        JButton btnDar_baixa = new JButton("Dar Baixa");
        btnDar_baixa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    Venda venda_ = farmacia.gestorvendas.procurarCod_venda(farmacia.medicamentos_pendentes.get(table_2.getSelectedRow()).getCod_compra());
                    venda_.darBaixa(farmacia.medicamentos_pendentes.get(table_2.getSelectedRow()));
                    System.out.println("Baixa de medicamentos com sucesso!");
                } catch (NullPointerException a) {
                    System.out.println("Sem medicamentos selecionados!");
                }
            }
        });
        btnDar_baixa.setBounds(266, 210, 89, 23);
        panel_14.add(btnDar_baixa);

        try {

        } catch (Exception e) {

        }

        JPanel panel = new JPanel();
        panel.setToolTipText("");
        panel.setBorder(new TitledBorder(null, "Produtos Adicionados Recentemente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(20, 222, 408, 292);
        main.add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane_6 = new JScrollPane();
        scrollPane_6.setEnabled(false);
        scrollPane_6.setBounds(10, 24, 388, 255);
        panel.add(scrollPane_6);

        table_4 = new JTable();
        DefaultTableModel model_meds = new DefaultTableModel(new Object[]{"Nome", "Data", "Receita", "Preço"}, 0);

        //Recebe medicamentos da venda selecionada
        ArrayList<Medicamento> medds = farmacia.armarios[nrloja].getTodos();
        //Adiciona os medicamentos na tablela
        for (Medicamento meds : medds) {
            model_meds.addRow(new Object[]{meds.getNome(), meds.getDataValidade(), meds.isReceita(), meds.getPreco()});
        }

        table_4.setModel(model_meds);
        table_4.setBorder(new LineBorder(new Color(0, 0, 0)));
        scrollPane_6.setViewportView(table_4);
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
        label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_label_8 = new GridBagConstraints();
        gbc_label_8.anchor = GridBagConstraints.EAST;
        gbc_label_8.insets = new Insets(0, 0, 0, 5);
        gbc_label_8.gridx = 0;
        gbc_label_8.gridy = 0;
        panel_15.add(label_8, gbc_label_8);

        JLabel label_9 = new JLabel();
        label_9.setText(farmacias[nrloja]);
        GridBagConstraints gbc_label_9 = new GridBagConstraints();
        gbc_label_9.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_9.insets = new Insets(0, 0, 0, 5);
        gbc_label_9.gridx = 1;
        gbc_label_9.gridy = 0;
        panel_15.add(label_9, gbc_label_9);

        JLabel label_10 = new JLabel("Funcionário:");
        label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
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

        JButton button_5 = new JButton("Terminar Sessão");
        button_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                Login login = new Login();
                dispose();
                login.setVisible(true);
            }
        });
        GridBagConstraints gbc_button_5 = new GridBagConstraints();
        gbc_button_5.insets = new Insets(0, 0, 0, 5);
        gbc_button_5.gridx = 4;
        gbc_button_5.gridy = 0;
        panel_15.add(button_5, gbc_button_5);

        JLabel label_12 = new JLabel("Tue Jun 05 19:49:43 BST 2018");
        label_12.setFont(new Font("Tahoma", Font.BOLD, 11));
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
        panel_5.setBorder(new TitledBorder(null, "Detalhes da compra selecionada na lista em cima", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
        GridBagLayout gbl_panel_10 = new GridBagLayout();
        gbl_panel_10.columnWidths = new int[]{0, 0, 0, 0};
        gbl_panel_10.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_panel_10.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_10.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_10.setLayout(gbl_panel_10);

        JLabel lblSubtotal = new JLabel("Sub-Total:");
        lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblSubtotal = new GridBagConstraints();
        gbc_lblSubtotal.anchor = GridBagConstraints.EAST;
        gbc_lblSubtotal.insets = new Insets(0, 0, 5, 5);
        gbc_lblSubtotal.gridx = 1;
        gbc_lblSubtotal.gridy = 1;
        panel_10.add(lblSubtotal, gbc_lblSubtotal);

        textSub_total = new JTextField();
        GridBagConstraints gbc_textSub_total = new GridBagConstraints();
        gbc_textSub_total.insets = new Insets(0, 0, 5, 0);
        gbc_textSub_total.gridx = 2;
        gbc_textSub_total.gridy = 1;
        panel_10.add(textSub_total, gbc_textSub_total);
        textSub_total.setColumns(10);

        JLabel lblIva = new JLabel("IVA:");
        lblIva.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblIva = new GridBagConstraints();
        gbc_lblIva.anchor = GridBagConstraints.EAST;
        gbc_lblIva.insets = new Insets(0, 0, 5, 5);
        gbc_lblIva.gridx = 1;
        gbc_lblIva.gridy = 2;
        panel_10.add(lblIva, gbc_lblIva);

        textIVA = new JTextField();
        GridBagConstraints gbc_textIVA = new GridBagConstraints();
        gbc_textIVA.insets = new Insets(0, 0, 5, 0);
        gbc_textIVA.gridx = 2;
        gbc_textIVA.gridy = 2;
        panel_10.add(textIVA, gbc_textIVA);
        textIVA.setColumns(10);

        JLabel lblDesconto = new JLabel("Desconto:");
        lblDesconto.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblDesconto = new GridBagConstraints();
        gbc_lblDesconto.anchor = GridBagConstraints.EAST;
        gbc_lblDesconto.insets = new Insets(0, 0, 5, 5);
        gbc_lblDesconto.gridx = 1;
        gbc_lblDesconto.gridy = 3;
        panel_10.add(lblDesconto, gbc_lblDesconto);

        textDesconto = new JTextField();
        GridBagConstraints gbc_textDesconto = new GridBagConstraints();
        gbc_textDesconto.insets = new Insets(0, 0, 5, 0);
        gbc_textDesconto.gridx = 2;
        gbc_textDesconto.gridy = 3;
        panel_10.add(textDesconto, gbc_textDesconto);
        textDesconto.setColumns(10);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblTotal = new GridBagConstraints();
        gbc_lblTotal.anchor = GridBagConstraints.EAST;
        gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
        gbc_lblTotal.gridx = 1;
        gbc_lblTotal.gridy = 4;
        panel_10.add(lblTotal, gbc_lblTotal);

        textTotal = new JTextField();
        GridBagConstraints gbc_textTotal = new GridBagConstraints();
        gbc_textTotal.gridx = 2;
        gbc_textTotal.gridy = 4;
        panel_10.add(textTotal, gbc_textTotal);
        textTotal.setColumns(10);


        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new TitledBorder(null, "Todas as Vendas Elaboradas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_4.setBounds(20, 126, 525, 188);
        venda.add(panel_4);
        panel_4.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 18, 500, 156);
        panel_4.add(scrollPane);
        //Define qual a Model vai estar a representar na jList

        JList list_1 = new JList();

        try {
            DefaultListModel listModels = new DefaultListModel();
            for (Venda vend : farmacia.gestorvendas.getVendas()) {
                listModels.addElement(vend.getCliente());
            }
            list_1.setModel(listModels);
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
                        model.addRow(new Object[]{meds.getNome(), categorias[meds.getCategoria()], vias[meds.getViaAdmin()], meds.getDataValidade(), meds.getPreco(), estados[meds.getEstado()]});
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
        label_18.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_label_18 = new GridBagConstraints();
        gbc_label_18.anchor = GridBagConstraints.EAST;
        gbc_label_18.insets = new Insets(0, 0, 0, 5);
        gbc_label_18.gridx = 0;
        gbc_label_18.gridy = 0;
        panel_17.add(label_18, gbc_label_18);

        JLabel label_19 = new JLabel();
        label_19.setText(farmacias[nrloja]);
        GridBagConstraints gbc_label_19 = new GridBagConstraints();
        gbc_label_19.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_19.insets = new Insets(0, 0, 0, 5);
        gbc_label_19.gridx = 1;
        gbc_label_19.gridy = 0;
        panel_17.add(label_19, gbc_label_19);

        JLabel label_20 = new JLabel("Funcionário:");
        label_20.setFont(new Font("Tahoma", Font.BOLD, 11));
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

        JButton button_7 = new JButton("Terminar Sessão");
        button_7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                Login login = new Login();
                dispose();
                login.setVisible(true);
            }
        });
        GridBagConstraints gbc_button_7 = new GridBagConstraints();
        gbc_button_7.insets = new Insets(0, 0, 0, 5);
        gbc_button_7.gridx = 4;
        gbc_button_7.gridy = 0;
        panel_17.add(button_7, gbc_button_7);

        JLabel label_22 = new JLabel("Tue Jun 05 19:49:43 BST 2018");
        label_22.setFont(new Font("Tahoma", Font.BOLD, 11));
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
        panel_6.setBounds(31, 221, 468, 87);
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
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2.setBounds(26, 28, 46, 14);
        panel_6.add(lblNewLabel_2);

        JLabel lblBi_1 = new JLabel("Nº Contribuinte");
        lblBi_1.setFont(new Font("Tahoma", Font.BOLD, 11));
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
        lblNome_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblNome_1 = new GridBagConstraints();
        gbc_lblNome_1.anchor = GridBagConstraints.EAST;
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
        lblBi_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblBi_2 = new GridBagConstraints();
        gbc_lblBi_2.anchor = GridBagConstraints.EAST;
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


        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new TitledBorder(null, "Detalhes sobre Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_7.setBounds(509, 91, 249, 144);
        clientes.add(panel_7);
        GridBagLayout gbl_panel_7 = new GridBagLayout();
        gbl_panel_7.columnWidths = new int[]{0, 47, 0};
        gbl_panel_7.rowHeights = new int[]{0, 0, 0, 0};
        gbl_panel_7.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_7.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_7.setLayout(gbl_panel_7);

        JLabel lblNewLabel_3 = new JLabel("Nº de Clientes esta semana:");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 0;
        panel_7.add(lblNewLabel_3, gbc_lblNewLabel_3);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));

        JLabel lblNewLabel_10 = new JLabel("");
        GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
        gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_10.gridx = 1;
        gbc_lblNewLabel_10.gridy = 0;
        panel_7.add(lblNewLabel_10, gbc_lblNewLabel_10);

        lblNewLabel_10.setText(String.valueOf(farmacia.gestorclientes.totalClientesSemana()));

        JLabel lblEsteMs = new JLabel("Nº Clientes este Mês:");
        GridBagConstraints gbc_lblEsteMs = new GridBagConstraints();
        gbc_lblEsteMs.insets = new Insets(0, 0, 5, 5);
        gbc_lblEsteMs.gridx = 0;
        gbc_lblEsteMs.gridy = 1;
        panel_7.add(lblEsteMs, gbc_lblEsteMs);
        lblEsteMs.setFont(new Font("Tahoma", Font.BOLD, 11));

        JLabel lblNewLabel_11 = new JLabel("");
        GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
        lblNewLabel_11.setText(String.valueOf(farmacia.gestorclientes.totalClientesMes()));

        gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_11.gridx = 1;
        gbc_lblNewLabel_11.gridy = 1;
        panel_7.add(lblNewLabel_11, gbc_lblNewLabel_11);

        JLabel lblTotalClientes = new JLabel("Total Clientes: ");
        GridBagConstraints gbc_lblTotalClientes = new GridBagConstraints();
        gbc_lblTotalClientes.insets = new Insets(0, 0, 0, 5);
        gbc_lblTotalClientes.gridx = 0;
        gbc_lblTotalClientes.gridy = 2;
        panel_7.add(lblTotalClientes, gbc_lblTotalClientes);
        lblTotalClientes.setFont(new Font("Tahoma", Font.BOLD, 11));

        JLabel lblNewLabel_8 = new JLabel("");
        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
        gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_8.gridx = 1;
        gbc_lblNewLabel_8.gridy = 2;
        panel_7.add(lblNewLabel_8, gbc_lblNewLabel_8);
        lblNewLabel_8.setText(String.valueOf(farmacia.gestorclientes.totalClientes()));

        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new TitledBorder(null, "Todos os Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_8.setBounds(31, 323, 460, 211);
        clientes.add(panel_8);
        panel_8.setLayout(null);


        btnAdicionar_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.out.println(farmacia.gestorclientes.clientes.size());

                Cliente cliente = new Cliente(farmacia.gestorclientes.clientes.size() + 1, nomeCliente.getText(), Integer.parseInt(biCliente.getText()), Calendar.getInstance().getTime());
                farmacia.gestorclientes.clientes.add(cliente);

                listClientes.setListData(farmacia.gestorclientes.getClientes().toArray());

                lblNewLabel_10.setText(String.valueOf(farmacia.gestorclientes.totalClientesSemana()));
                lblNewLabel_11.setText(String.valueOf(farmacia.gestorclientes.totalClientesMes()));
                lblNewLabel_8.setText(String.valueOf(farmacia.gestorclientes.totalClientes()));
            }
        });

        JScrollPane scrollPane_5 = new JScrollPane();
        scrollPane_5.setBounds(6, 19, 448, 186);
        panel_8.add(scrollPane_5);


        listClientes.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {


                Cliente cli = new Cliente();
                if (listClientes.getSelectedValue() != null) {
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

        JPanel panel_19 = new JPanel();
        panel_19.setBorder(new TitledBorder(null, "Editar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_19.setBounds(509, 312, 272, 211);
        clientes.add(panel_19);
        panel_19.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(6, 16, 247, 174);
        panel_19.add(panel_2);
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[]{0, 110, 132, 0, 0};
        gbl_panel_2.rowHeights = new int[]{5, 0, 0, 0, 0, 0, 0};
        gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_2.setLayout(gbl_panel_2);

        JLabel lblNome_5 = new JLabel("Nome:");
        lblNome_5.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblNome_5 = new GridBagConstraints();
        gbc_lblNome_5.anchor = GridBagConstraints.EAST;
        gbc_lblNome_5.insets = new Insets(0, 0, 5, 5);
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
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.BELOW_BASELINE_TRAILING;
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
        gbc_btnNewButton_2.anchor = GridBagConstraints.EAST;
        gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_2.gridx = 1;
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

                    lblNewLabel_10.setText(String.valueOf(farmacia.gestorclientes.totalClientesSemana()));
                    lblNewLabel_11.setText(String.valueOf(farmacia.gestorclientes.totalClientesMes()));
                    lblNewLabel_8.setText(String.valueOf(farmacia.gestorclientes.totalClientes()));

                } catch (Exception e1) {
                    // TODO: handle exception
                }
            }
        });
        GridBagConstraints gbc_btnRemover = new GridBagConstraints();
        gbc_btnRemover.anchor = GridBagConstraints.EAST;
        gbc_btnRemover.insets = new Insets(0, 0, 5, 5);
        gbc_btnRemover.gridx = 2;
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
        label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_label_3 = new GridBagConstraints();
        gbc_label_3.anchor = GridBagConstraints.EAST;
        gbc_label_3.insets = new Insets(0, 0, 0, 5);
        gbc_label_3.gridx = 0;
        gbc_label_3.gridy = 0;
        panel_3.add(label_3, gbc_label_3);

        JLabel label_4 = new JLabel();
        label_4.setText(farmacias[nrloja]);
        GridBagConstraints gbc_label_4 = new GridBagConstraints();
        gbc_label_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_label_4.insets = new Insets(0, 0, 0, 5);
        gbc_label_4.gridx = 1;
        gbc_label_4.gridy = 0;
        panel_3.add(label_4, gbc_label_4);

        JLabel label_5 = new JLabel("Funcionário:");
        label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
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

        JButton button_1 = new JButton("Terminar Sessão");
        button_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                Login login = new Login();
                dispose();
                login.setVisible(true);
            }
        });
        GridBagConstraints gbc_button_1 = new GridBagConstraints();
        gbc_button_1.insets = new Insets(0, 0, 0, 5);
        gbc_button_1.gridx = 4;
        gbc_button_1.gridy = 0;
        panel_3.add(button_1, gbc_button_1);

        JLabel label_7 = new JLabel("Tue Jun 05 19:49:43 BST 2018");
        label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
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
        lblProcurarProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblProcurarProduto.setBounds(31, 316, 141, 16);
        stock.add(lblProcurarProduto);

        textPesquisarStock = new JTextField();
        textPesquisarStock.setBounds(31, 339, 192, 20);
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
                    DefaultListModel model = new DefaultListModel<>();
                    model.addElement(m);

                    list_2.setModel(model);

                } else {


                    JOptionPane.showMessageDialog(null, "O Medicamento: " + textPesquisarStock.getText() + ", não existe na loja!");
                }
            }
        });
        btnPesquisar.setBounds(233, 336, 98, 26);
        stock.add(btnPesquisar);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Editar: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(471, 342, 303, 236);
        stock.add(panel_1);

        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{8, 130, 210, 0};
        gbl_panel_1.rowHeights = new int[]{0, 32, 30, 34, 22, 10, 34, 65, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);

        JLabel lblNome_3 = new JLabel("Nome:");
        lblNome_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblNome_3 = new GridBagConstraints();
        gbc_lblNome_3.anchor = GridBagConstraints.EAST;
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
        lblCategoria_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblCategoria_2 = new GridBagConstraints();
        gbc_lblCategoria_2.anchor = GridBagConstraints.EAST;
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
        lblViaDeAdministrao.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblViaDeAdministrao = new GridBagConstraints();
        gbc_lblViaDeAdministrao.anchor = GridBagConstraints.EAST;
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
        lblDataValidade_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblDataValidade_1 = new GridBagConstraints();
        gbc_lblDataValidade_1.anchor = GridBagConstraints.EAST;
        gbc_lblDataValidade_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblDataValidade_1.fill = GridBagConstraints.VERTICAL;
        gbc_lblDataValidade_1.gridx = 1;
        gbc_lblDataValidade_1.gridy = 4;
        panel_1.add(lblDataValidade_1, gbc_lblDataValidade_1);

        JDateChooser dateChooser = new JDateChooser();
        GridBagConstraints gbc_dateChooser = new GridBagConstraints();
        gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
        gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
        gbc_dateChooser.gridx = 2;
        gbc_dateChooser.gridy = 4;
        panel_1.add(dateChooser, gbc_dateChooser);

        JLabel lblPreo_1 = new JLabel("Preço:");
        lblPreo_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblPreo_1 = new GridBagConstraints();
        gbc_lblPreo_1.anchor = GridBagConstraints.EAST;
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
        lblNecessitaReceita.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblNecessitaReceita = new GridBagConstraints();
        gbc_lblNecessitaReceita.anchor = GridBagConstraints.EAST;
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
        gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 7;
        panel_1.add(btnNewButton, gbc_btnNewButton);

        JButton btnApagar = new JButton("Apagar");

        GridBagConstraints gbc_btnApagar = new GridBagConstraints();
        gbc_btnApagar.anchor = GridBagConstraints.NORTH;
        gbc_btnApagar.gridx = 2;
        gbc_btnApagar.gridy = 7;
        panel_1.add(btnApagar, gbc_btnApagar);


        list_2.setBounds(61, 131, 423, 255);
        //Inicializar o Scroll Pane para termos barra de scroll
        JScrollPane scrollPane_1 = new JScrollPane();

        JList list = new JList();
        list.setBorder(new LineBorder(new Color(0, 0, 0)));
        list.setBounds(458, 115, 316, 178);


        list.setModel(verificarMedicamentos(nrloja));
        stock.add(list);

        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (!editarMedic) {
                    
                        Medicamento medic = new Medicamento();
                     
                        medic = (Medicamento) list_2.getSelectedValue();                     
                   
                        if(medic!=null) {
                        	   btnNewButton.setText("Gravar");
                        //Ativar os componentes para editar
                        nomeStock.setEditable(true);
                        comboBox.setEnabled(true);
                        comboBox_1.setEnabled(true);
                        dateChooser.setEnabled(true);
                        precoStock.setEditable(true);
                        rdbtnNewRadioButton_1.setEnabled(true);



                        //variavel para controlar botao editar
                        editarMedic = !editarMedic;
                        }else {
                        	JOptionPane.showMessageDialog(null, "Não selecionou um medicamento");
                        }

                } else {
                	
                    boolean receita = rdbtnNewRadioButton_1.isSelected();

                    try {
                       

                        Medicamento medic = new Medicamento();
                        medic = (Medicamento) list_2.getSelectedValue();
                        if(medic!=null) {
                        medic.setNome(nomeStock.getText());
                        medic.setPreco(Float.parseFloat(precoStock.getText()));
                        medic.setDataValidade(dateChooser.getDate());
                        medic.setCategoria(comboBox.getSelectedIndex());
                        medic.setViaAdmin(comboBox_1.getSelectedIndex());
                        medic.setReceita(receita);

                        farmacia.armarios[nrloja].atualizarMedicamento(medic);

                        //Desativar os componentes de edição
                        nomeStock.setEditable(false);
                        comboBox.setEnabled(false);
                        comboBox_1.setEnabled(false);
                        dateChooser.setEnabled(false);
                        precoStock.setEditable(false);
                        rdbtnNewRadioButton_1.setEnabled(false);

                        scrollPane_1.revalidate();
                        scrollPane_1.repaint();

                        //variavel para controlar botao editar
                        editarMedic = !editarMedic;
                        btnNewButton.setText("Editar");
                        }else {
                        	JOptionPane.showMessageDialog(null, "Não selecionou um medicamento");
                        }
                     
                    } catch (Exception e) {
                    	System.out.println(e.getMessage());

                    }
                    list_2.setListData(farmacia.armarios[nrloja].getTodos().toArray());
                    list.setListData(verificarMedicamentos(nrloja).toArray());
                }
            }
        });


        scrollPane_1.setViewportView(list_2);
        scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_1.setBounds(32, 373, 429, 171);
        //Adicona o scroll pane ao painel Stock
        stock.add(scrollPane_1);

        JLabel label_2 = new JLabel("Categoria:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_2.setBounds(31, 116, 77, 16);
        stock.add(label_2);

        JLabel label_1 = new JLabel("Via Administração:");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_1.setBounds(207, 116, 141, 16);
        stock.add(label_1);

        JPanel panel_18 = new JPanel();
        panel_18.setBounds(31, 164, 166, 141);
        stock.add(panel_18);
        GridBagLayout gbl_panel_18 = new GridBagLayout();
        gbl_panel_18.columnWidths = new int[]{0, 0, 0, 0};
        gbl_panel_18.rowHeights = new int[]{29, 28, 28, 0, 26, 0, 0};
        gbl_panel_18.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel_18.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_18.setLayout(gbl_panel_18);


        JLabel lblNome_4 = new JLabel("Nome:");
        lblNome_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblNome_4 = new GridBagConstraints();
        gbc_lblNome_4.anchor = GridBagConstraints.EAST;
        gbc_lblNome_4.insets = new Insets(0, 0, 5, 0);
        gbc_lblNome_4.gridx = 2;
        gbc_lblNome_4.gridy = 0;
        panel_18.add(lblNome_4, gbc_lblNome_4);

        JLabel lblNewLabel = new JLabel("Quantidade:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 2;
        gbc_lblNewLabel.gridy = 1;
        panel_18.add(lblNewLabel, gbc_lblNewLabel);

        JLabel lblPreo_2 = new JLabel("Preço:");
        lblPreo_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblPreo_2 = new GridBagConstraints();
        gbc_lblPreo_2.anchor = GridBagConstraints.EAST;
        gbc_lblPreo_2.insets = new Insets(0, 0, 5, 0);
        gbc_lblPreo_2.gridx = 2;
        gbc_lblPreo_2.gridy = 2;
        panel_18.add(lblPreo_2, gbc_lblPreo_2);

        JLabel lblDataValidade_2 = new JLabel("Data Validade");
        lblDataValidade_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblDataValidade_2 = new GridBagConstraints();
        gbc_lblDataValidade_2.anchor = GridBagConstraints.EAST;
        gbc_lblDataValidade_2.insets = new Insets(0, 0, 5, 0);
        gbc_lblDataValidade_2.gridx = 2;
        gbc_lblDataValidade_2.gridy = 3;
        panel_18.add(lblDataValidade_2, gbc_lblDataValidade_2);


        JLabel lblNewLabel_5 = new JLabel("Necessita Receita:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_5.gridx = 2;
        gbc_lblNewLabel_5.gridy = 4;
        panel_18.add(lblNewLabel_5, gbc_lblNewLabel_5);

        textNome = new JTextField();
        textNome.setBounds(207, 161, 225, 20);
        stock.add(textNome);
        textNome.setColumns(10);

        textQuantidade = new JTextField();
        textQuantidade.setBounds(207, 186, 225, 20);
        stock.add(textQuantidade);
        textQuantidade.setColumns(10);

        textPreco = new JTextField();
        textPreco.setBounds(207, 211, 225, 20);
        stock.add(textPreco);
        textPreco.setColumns(10);

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
        btnAdicionarGerir.setBounds(324, 281, 108, 23);
        stock.add(btnAdicionarGerir);

        JLabel lblAdicionarMedicamento = new JLabel("Adicionar Medicamento:");
        lblAdicionarMedicamento.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblAdicionarMedicamento.setBounds(31, 89, 158, 16);
        stock.add(lblAdicionarMedicamento);

        JButton btnNewButton_3 = new JButton("Mostrar Todos");
        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                list_2.setListData(farmacia.armarios[nrloja].getTodos().toArray());

            }
        });
        btnNewButton_3.setBounds(341, 335, 120, 28);
        stock.add(btnNewButton_3);


        JLabel lblNewLabel_9 = new JLabel("Medicamentos fora de validade:");
        lblNewLabel_9.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblNewLabel_9.setBounds(458, 88, 244, 16);
        stock.add(lblNewLabel_9);

        JButton btnNewButton_4 = new JButton("Remover todos");
        btnNewButton_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    Medicamento medic = new Medicamento();
                    for (int i = 0; i < model.size(); i++) {
                        medic = (Medicamento) model.get(i);
                        farmacia.armarios[nrloja].getArmarioGaveta(medic.getCategoria(), medic.getViaAdmin()).removerTodosMedicamento(medic.getNome());


                    }
                    list_2.setListData(farmacia.armarios[nrloja].getTodos().toArray());
                    list.setListData(verificarMedicamentos(nrloja).toArray());
                    model.removeAllElements();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        });

        btnNewButton_4.setBounds(644, 304, 120, 28);
        stock.add(btnNewButton_4);
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
                        verificarMedicamentos(nrloja);

                        DefaultListModel model = new DefaultListModel<>();
                        for (Medicamento m_ : farmacia.armarios[nrloja].getTodos()) {
                            if (m_.getDataValidade().compareTo(Calendar.getInstance().getTime()) < 0) {
                                if (model.contains(m_)) {

                                } else {
                                    model.addElement(m_);
                                }
                            }
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao introduzir medicamento");
                    }
                }
            }
        });


        //Evento Selection change e mostra os valores detalhados no form ao lado
        list_2.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                if (list_2.getSelectedValue() != null) {
                    Medicamento s = (Medicamento) list_2.getSelectedValue();
                    nomeStock.setText(s.getNome());
                    comboBox.setSelectedIndex(s.getCategoria());
                    comboBox_1.setSelectedIndex(s.getViaAdmin());
                    rdbtnNewRadioButton_1.setSelected(s.isReceita());


                    dateChooser.setDate(s.getDataValidade());


                    precoStock.setText(String.valueOf(s.getPreco()));

                    //Coloca as texbox BLOQUEADAS
                    nomeStock.setEditable(false);
                    comboBox.setEnabled(false);
                    comboBox_1.setEnabled(false);

                    dateChooser.setEnabled(false);
                    precoStock.setEditable(false);
                    //variavel para controlar botao editar
                    editarMedic = false;
                    btnNewButton.setText("Editar");
                } else {
                    //JOptionPane.showMessageDialog(null, "Não selecionou um medicamento!");
                }
            }

        });
        //botao apagar medicamento
        btnApagar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    if (list_2.getSelectedValue() != null) {
                        Medicamento s = (Medicamento) list_2.getSelectedValue();
                        farmacia.armarios[nrloja].removerMedicamento(s);
                    } else {
                        JOptionPane.showMessageDialog(null, "Não selecionou nenhum medicamento");
                    }
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

        JList list_1_1 = new JList(farmacia.gestorvendas.getVendas().toArray());
        list_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    Relatorio relat = new Relatorio(farmacia.gestorvendas.getVendas().get(list_3.getSelectedIndex()), farmacias[nrloja], "Costa-Prozelo");

                    Dialog dialog = new Dialog(relat);
                    dialog.setVisible(true);
                }
            }
        });
        list_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        list_1_1.setBounds(457, 311, 307, 233);
        relatorio.add(list_1_1);

    }
}
