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
		
		JPanel venda = new JPanel();
		getContentPane().add(venda, "name_2350788731094");
		venda.setLayout(null);
		
		JPanel cliente = new JPanel();
		getContentPane().add(cliente, "name_2352463975599");
		cliente.setLayout(null);
		cliente.setVisible(true);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(67, 37, 99, 39);
		main.add(btnHome);
		
		JButton btnVendas = new JButton("Vendas");
		btnVendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				venda.setVisible(true);
				main.setVisible(false);
				
			}
		});
		btnVendas.setBounds(188, 37, 99, 39);
		main.add(btnVendas);
		
		JButton btnRelatorio = new JButton("Relatório");
		btnRelatorio.setBounds(308, 37, 99, 39);
		main.add(btnRelatorio);
		
		JLabel label = new JLabel("09/05/2018");
		label.setBounds(869, 11, 99, 23);
		main.add(label);
		
		JButton btnStock = new JButton("Stock");
		btnStock.setBounds(427, 37, 108, 39);
		main.add(btnStock);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(553, 37, 120, 39);
		main.add(btnClientes);
		
		JLabel lblVendasMes = new JLabel("Vendas este mês:");
		lblVendasMes.setBounds(31, 133, 135, 23);
		main.add(lblVendasMes);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(57, 167, 85, 14);
		main.add(lblQuantidade);
		
		JLabel lblNovosClientes = new JLabel("Novos Clientes");
		lblNovosClientes.setBounds(57, 192, 73, 14);
		main.add(lblNovosClientes);
		
		JLabel lblProdutoMaisVendido = new JLabel("Produto mais vendido:");
		lblProdutoMaisVendido.setBounds(57, 217, 120, 14);
		main.add(lblProdutoMaisVendido);
		
		JLabel lblProdutosEmCaminho = new JLabel("Produtos em caminho:");
		lblProdutosEmCaminho.setBounds(31, 305, 135, 14);
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
		lblEscolhaProduto.setBounds(63, 36, 113, 25);
		venda.add(lblEscolhaProduto);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(63, 84, 85, 20);
		venda.add(lblCategoria);
		
		JLabel lblViaAdmin = new JLabel("Via Administração:");
		lblViaAdmin.setBounds(455, 84, 105, 17);
		venda.add(lblViaAdmin);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBounds(163, 84, 226, 20);
		venda.add(comboBoxCategoria);
		
		JComboBox comboBoxViaAdmin = new JComboBox();
		comboBoxViaAdmin.setBounds(588, 84, 268, 20);
		venda.add(comboBoxViaAdmin);
		
	
		
		JLabel lblProcurarCliente = new JLabel("Procurar Cliente:");
		lblProcurarCliente.setBounds(55, 44, 95, 20);
		cliente.add(lblProcurarCliente);
		
		textFieldProcurarCliente = new JTextField();
		textFieldProcurarCliente.setBounds(160, 44, 213, 20);
		cliente.add(textFieldProcurarCliente);
		textFieldProcurarCliente.setColumns(10);
	}
}
