package com.company;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class Layout extends JFrame {
	private JTextField textFieldProcurarCliente;
	private JPanel main;
	private JPanel venda;
	private JPanel cliente;

	public static void main(String[] args) {
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
		setBounds(100, 100, 1150, 665);

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

		JPanel cliente = new JPanel();
		getContentPane().add(cliente, "name_2352463975599");
		cliente.setLayout(null);
		cliente.setVisible(false);

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
		lblVendasMes.setBounds(31, 133, 85, 14);
		main.add(lblVendasMes);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(57, 167, 60, 14);
		main.add(lblQuantidade);

		JLabel lblNovosClientes = new JLabel("Novos Clientes");
		lblNovosClientes.setBounds(57, 192, 71, 14);
		main.add(lblNovosClientes);

		JLabel lblProdutoMaisVendido = new JLabel("Produto mais vendido:");
		lblProdutoMaisVendido.setBounds(57, 217, 107, 14);
		main.add(lblProdutoMaisVendido);

		JLabel lblProdutosEmCaminho = new JLabel("Produtos em caminho:");
		lblProdutosEmCaminho.setBounds(31, 305, 106, 14);
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
		lblProdutosAdicionadosRecentemente.setBounds(595, 414, 216, 14);
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
		lblViaAdmin.setBounds(456, 140, 105, 17);
		venda.add(lblViaAdmin);

		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBounds(164, 140, 226, 20);
		venda.add(comboBoxCategoria);

		JComboBox comboBoxViaAdmin = new JComboBox();
		comboBoxViaAdmin.setBounds(589, 140, 268, 20);
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



		JLabel lblProcurarCliente = new JLabel("Procurar Cliente:");
		lblProcurarCliente.setBounds(78, 90, 95, 20);
		cliente.add(lblProcurarCliente);

		textFieldProcurarCliente = new JTextField();
		textFieldProcurarCliente.setBounds(183, 90, 213, 20);
		cliente.add(textFieldProcurarCliente);
		textFieldProcurarCliente.setColumns(10);

		JButton button_5 = new JButton("Clientes");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				venda.setVisible(false);
				main.setVisible(false);
				relatorio.setVisible(false);
				clientes.setVisible(true);
				stock.setVisible(false);
			}
		});
		button_5.setBounds(683, 36, 120, 39);
		cliente.add(button_5);

		JButton button_6 = new JButton("Stock");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				venda.setVisible(false);
				main.setVisible(false);
				relatorio.setVisible(false);
				clientes.setVisible(false);
				stock.setVisible(true);
			}
		});
		button_6.setBounds(557, 36, 108, 39);
		cliente.add(button_6);

		JButton button_7 = new JButton("Relatório");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				venda.setVisible(false);
				main.setVisible(false);
				relatorio.setVisible(true);
				clientes.setVisible(false);
				stock.setVisible(false);
			}
		});
		button_7.setBounds(438, 36, 99, 39);
		cliente.add(button_7);

		JButton button_8 = new JButton("Vendas");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				venda.setVisible(true);
				main.setVisible(false);
				relatorio.setVisible(false);
				clientes.setVisible(false);
				stock.setVisible(false);
			}
		});
		button_8.setBounds(318, 36, 99, 39);
		cliente.add(button_8);

		JButton btnHomeCliente = new JButton("Home");
		btnHomeCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				venda.setVisible(false);
				main.setVisible(true);
				relatorio.setVisible(false);
				clientes.setVisible(false);
				stock.setVisible(false);
			}
		});
		btnHomeCliente.setBounds(197, 36, 99, 39);
		cliente.add(btnHomeCliente);



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


	}
}
