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

public class Layout extends JFrame implements CatVia {
    private JPanel main;
    private JPanel venda;
    private JPanel cliente;
    private JTextField txtNome;
    private JTextField textProcurarCliente;
    private JTextField textPesquisarStock;

    public static void main(String[] args) {

        try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
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
        getContentPane().setLayout(new CardLayout(0, 0));
        setBounds(100, 100, 1150, 800);

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

        btnVendas.setBounds(318, 36, 99, 39);
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
        button_10.setBounds(683, 36, 120, 39);
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
        btnStockRelatorio.setBounds(557, 36, 108, 39);
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

        btnRelatorioRelatorio.setBounds(438, 36, 99, 39);
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
        button_13.setBounds(318, 36, 99, 39);
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
        button_14.setBounds(197, 36, 99, 39);
        relatorio.add(button_14);

        JLabel lblUltimosRelatrios = new JLabel("Ultimos relatórios");
        lblUltimosRelatrios.setBounds(72, 114, 135, 16);
        relatorio.add(lblUltimosRelatrios);

        JTextPane textRelatorio = new JTextPane();
        textRelatorio.setBounds(72, 143, 556, 218);
        relatorio.add(textRelatorio);

        JLabel lblAlertas = new JLabel("Total alertas: ");
        lblAlertas.setBounds(712, 147, 108, 16);
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
        btnHome.setBounds(197, 36, 99, 39);
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
        btnRelatorio.setBounds(438, 36, 99, 39);
        main.add(btnRelatorio);

        JLabel label = new JLabel("09/05/2018");
        label.setBounds(869, 11, 99, 23);
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
        btnStock.setBounds(557, 36, 108, 39);
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
        btnClientes.setBounds(683, 36, 120, 39);
        main.add(btnClientes);

        JLabel lblVendasMes = new JLabel("Vendas este mês:");
        lblVendasMes.setBounds(31, 133, 133, 14);
        main.add(lblVendasMes);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(57, 167, 107, 14);
        main.add(lblQuantidade);

        JLabel lblNovosClientes = new JLabel("Novos Clientes");
        lblNovosClientes.setBounds(57, 192, 127, 14);
        main.add(lblNovosClientes);

        JLabel lblProdutoMaisVendido = new JLabel("Produto mais vendido:");
        lblProdutoMaisVendido.setBounds(57, 217, 149, 14);
        main.add(lblProdutoMaisVendido);

        JLabel lblProdutosEmCaminho = new JLabel("Produtos em caminho:");
        lblProdutosEmCaminho.setBounds(31, 305, 153, 14);
        main.add(lblProdutosEmCaminho);

        JTextPane textProdutosCaminho = new JTextPane();
        textProdutosCaminho.setBounds(42, 364, 416, 180);
        main.add(textProdutosCaminho);

        JLabel lblArmazem = new JLabel("Armazem:");
        lblArmazem.setBounds(612, 137, 85, 14);
        main.add(lblArmazem);

        JLabel lblProdutosForaDe = new JLabel("Produtos fora de stock");
        lblProdutosForaDe.setBounds(622, 167, 149, 14);
        main.add(lblProdutosForaDe);

        JTextPane textProdutosForaStock = new JTextPane();
        textProdutosForaStock.setBounds(585, 211, 450, 192);
        main.add(textProdutosForaStock);

        JLabel lblProdutosAdicionadosRecentemente = new JLabel("Produtos adicionados recentemente:");
        lblProdutosAdicionadosRecentemente.setBounds(595, 414, 250, 14);
        main.add(lblProdutosAdicionadosRecentemente);

        JTextPane textProdutosRecentes = new JTextPane();
        textProdutosRecentes.setBounds(585, 453, 450, 147);
        main.add(textProdutosRecentes);


        JLabel lblEscolhaProduto = new JLabel("Escolha produto:");
        lblEscolhaProduto.setBounds(64, 92, 113, 25);
        venda.add(lblEscolhaProduto);

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setBounds(64, 140, 85, 20);
        venda.add(lblCategoria);

        JLabel lblViaAdmin = new JLabel("Via Administração:");
        lblViaAdmin.setBounds(346, 142, 124, 17);
        venda.add(lblViaAdmin);

        JComboBox comboBoxCategoria = new JComboBox();
        comboBoxCategoria.setBounds(164, 140, 172, 20);
        venda.add(comboBoxCategoria);
        for (int i = 0; i < categorias.length; i++) {
            comboBoxCategoria.addItem(categorias[i]);
        }

        JComboBox comboBoxViaAdmin = new JComboBox();
        comboBoxViaAdmin.setBounds(466, 140, 158, 20);
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
        button.setBounds(683, 36, 120, 39);
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
        button_1.setBounds(557, 36, 108, 39);
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
        button_2.setBounds(438, 36, 99, 39);
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
        button_3.setBounds(318, 36, 99, 39);
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
        button_4.setBounds(197, 36, 99, 39);
        venda.add(button_4);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(663, 108, 46, 14);
        venda.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(661, 140, 199, 20);
        venda.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(900, 108, 70, 14);
        venda.add(lblCliente);

        JLabel lblNome_1 = new JLabel("Nome:");
        lblNome_1.setBounds(910, 131, 46, 14);
        venda.add(lblNome_1);

        JLabel lblBi = new JLabel("BI:");
        lblBi.setBounds(910, 154, 46, 14);
        venda.add(lblBi);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(900, 219, 95, 30);
        venda.add(btnAdicionar);

        JTextPane textPesquisaProduto = new JTextPane();
        textPesquisaProduto.setBounds(64, 186, 810, 207);
        venda.add(textPesquisaProduto);

        JLabel lblDadosCompra = new JLabel("Dados Compra");
        lblDadosCompra.setBounds(64, 420, 120, 14);
        venda.add(lblDadosCompra);

        JTextPane textDadosCompra = new JTextPane();
        textDadosCompra.setBounds(64, 445, 810, 244);
        venda.add(textDadosCompra);

        JLabel lblEstadoCompra = new JLabel("Estado Compra");
        lblEstadoCompra.setBounds(900, 457, 113, 16);
        venda.add(lblEstadoCompra);

        JLabel lblSubtotal = new JLabel("Sub-Total:");
        lblSubtotal.setBounds(920, 485, 85, 16);
        venda.add(lblSubtotal);

        JLabel lblIva = new JLabel("IVA:");
        lblIva.setBounds(920, 510, 55, 16);
        venda.add(lblIva);

        JLabel lblDesconto = new JLabel("Desconto:");
        lblDesconto.setBounds(920, 538, 75, 16);
        venda.add(lblDesconto);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(920, 566, 55, 16);
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
        button_15.setBounds(683, 36, 120, 39);
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
        btnVendasClientes.setBounds(318, 36, 99, 39);
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
        btnRelatorioClientes.setBounds(438, 36, 99, 39);
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
        btnStockClientes.setBounds(557, 36, 108, 39);
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
        btnHomeClientes.setBounds(197, 36, 99, 39);
        clientes.add(btnHomeClientes);

        JLabel lblProcurarCliente = new JLabel("Procurar Cliente:");
        lblProcurarCliente.setBounds(43, 152, 108, 16);
        clientes.add(lblProcurarCliente);

        textProcurarCliente = new JTextField();
        textProcurarCliente.setBounds(152, 150, 161, 20);
        clientes.add(textProcurarCliente);
        textProcurarCliente.setColumns(10);

        JButton btnAdicionarCliente = new JButton("Adicionar");
        btnAdicionarCliente.setBounds(354, 147, 120, 26);
        clientes.add(btnAdicionarCliente);

        JTextPane textListarClientes = new JTextPane();
        textListarClientes.setBounds(42, 180, 527, 214);
        clientes.add(textListarClientes);

        JButton btnAdicionar_2 = new JButton("Adicionar");
        btnAdicionar_2.setBounds(624, 180, 120, 26);
        clientes.add(btnAdicionar_2);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(624, 234, 118, 26);
        clientes.add(btnEditar);

        JButton btnRemover = new JButton("Remover");
        btnRemover.setBounds(624, 286, 120, 26);
        clientes.add(btnRemover);

        JLabel lblTodosOsClientes = new JLabel("Todos os clientes");
        lblTodosOsClientes.setBounds(43, 442, 148, 16);
        clientes.add(lblTodosOsClientes);

        JTextPane textTodosClientes = new JTextPane();
        textTodosClientes.setBounds(43, 470, 527, 214);
        clientes.add(textTodosClientes);

        JLabel lblRegistos = new JLabel("Registos");
        lblRegistos.setBounds(660, 493, 78, 16);
        clientes.add(lblRegistos);

        JLabel lblTotalClientes = new JLabel("Total Clientes: ");
        lblTotalClientes.setBounds(683, 521, 99, 16);
        clientes.add(lblTotalClientes);

        JLabel lblEsteMs = new JLabel("Este Mês:");
        lblEsteMs.setBounds(683, 549, 78, 16);
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
        btnHomeStock.setBounds(197, 36, 99, 39);
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
        btnVendasStock.setBounds(318, 36, 99, 39);
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
        btnRelatorioStock.setBounds(438, 36, 99, 39);
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
        btnStockStock.setBounds(557, 36, 108, 39);
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
        btnClientesStock.setBounds(683, 36, 120, 39);
        stock.add(btnClientesStock);

        JLabel lblProcurarProduto = new JLabel("Procurar Produto:");
        lblProcurarProduto.setBounds(51, 104, 141, 16);
        stock.add(lblProcurarProduto);

        textPesquisarStock = new JTextField();
        textPesquisarStock.setBounds(162, 102, 192, 20);
        stock.add(textPesquisarStock);
        textPesquisarStock.setColumns(10);

        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBounds(366, 99, 98, 26);
        stock.add(btnPesquisar);

        JTextPane textProdutosStock = new JTextPane();
        textProdutosStock.setBounds(51, 150, 637, 232);
        stock.add(textProdutosStock);

        JLabel lblProdutosSemStock = new JLabel("Produtos sem Stock: ");
        lblProdutosSemStock.setBounds(744, 150, 156, 16);
        stock.add(lblProdutosSemStock);


    }
}
