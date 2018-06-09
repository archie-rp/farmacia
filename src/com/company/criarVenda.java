package com.company;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class criarVenda extends JDialog implements Variaveis{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private JTextField text_nome;
	private JTextField text_nr_contr;
	public int nrloja_pendente;

	/**
	 * Create the dialog.
	 */
	public criarVenda(Farmacia farmacia, int nrloja,JList list_1,JList list_3)  {
		setBounds(100, 100, 761, 507);
		getContentPane().setLayout(new BorderLayout());
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(57dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(65dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(59dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("left:max(18dlu;default)"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.MIN_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(69dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblCategoria = new JLabel("Categoria");
			lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblCategoria, "2, 4");
		}
		{
			JLabel lblNewLabel = new JLabel("Via de Administração");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblNewLabel, "4, 4");
		}
		{
			JLabel lblEstadoDaCompra = new JLabel("Estado da Compra");
			lblEstadoDaCompra.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblEstadoDaCompra, "8, 4, 5, 1");
		}
		Venda venda_temporaria = new Venda();
		JScrollPane scrollPane1 = new JScrollPane();
		
		{			
			{
				table = new JTable();
				try {
					DefaultTableModel model_d = new DefaultTableModel(new Object[]{"Nome", "Quantidade", "Preço", "Estado"}, 0);
					ArrayList<Medicamento> med = venda_temporaria.getMedicamentos();
					//Adiciona os medicamentos na tablela
					for (Medicamento meds : med) {
						model_d.addRow(new Object[]{meds.getNome(), meds.getDataValidade(), meds.getPreco(),estados[meds.getEstado()]});
					}
					scrollPane1.setViewportView(table);
					table.setModel(model_d);
					table.setBorder(new LineBorder(new Color(0, 0, 0)));
					contentPanel.add(scrollPane1, "8, 6, 5, 5, fill, fill");

				} catch (NullPointerException x) {
					DefaultTableModel ad = new DefaultTableModel(new Object[]{"Nome", "Quantidade", "Preço", "Estado"}, 0);
					scrollPane1.setViewportView(table);
					table.setModel(ad);
				}
				scrollPane1.setViewportView(table);
				table.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
		}

			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Procurar Medicamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, "2, 2, 8, 1, fill, top");
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormSpecs.DEFAULT_COLSPEC,
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("default:grow"),
					FormSpecs.RELATED_GAP_COLSPEC,
					FormSpecs.DEFAULT_COLSPEC,
					FormSpecs.RELATED_GAP_COLSPEC,
					FormSpecs.DEFAULT_COLSPEC,},
					new RowSpec[] {
							RowSpec.decode("default:grow"),}));
			{
				JLabel lblNome = new JLabel("Nome:");
				panel.add(lblNome, "1, 1");
			}

			JTextArea text_nome_procurar = new JTextArea();
			text_nome_procurar.setLineWrap(true);
			text_nome_procurar.setWrapStyleWord(true);
			text_nome_procurar.setTabSize(5);
			panel.add(text_nome_procurar, "3, 1, 3, 1, fill, default");


		JComboBox comboBox_cat = new JComboBox(categorias);
		
		JComboBox comboBox_via = new JComboBox(vias);
		JButton btnProcurar = new JButton("Procurar");
	
		panel.add(btnProcurar, "7, 1");

		btnProcurar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!text_nome_procurar.getText().isEmpty()){

					Medicamento m = new Medicamento();
					if(farmacia.armarios[nrloja].procurarMedicamento(text_nome_procurar.getText())!= null){
						m= farmacia.armarios[nrloja].procurarMedicamento(text_nome_procurar.getText());
						System.out.print( nrloja + m.toString());
						comboBox_cat.setSelectedIndex(m.getCategoria());
						comboBox_via.setSelectedIndex(m.getViaAdmin());
					}else {
						for (int i = 0; i < 2; i++) {
							m = farmacia.armarios[selecao[nrloja][i]].procurarMedicamento(text_nome_procurar.getText());
							Importar importar = new Importar(farmacia, nrloja, m, venda_temporaria, selecao[nrloja][i],table,scrollPane1);
							importar.setVisible(true);
							System.out.print("Medicamento encontrado noutra loja da mesma farmacia!" + 2 + m.toString());
							nrloja_pendente=selecao[nrloja][i];
							break;
						}
					}
				}
			}
		});
	
		contentPanel.add(comboBox_cat, "2, 6, fill, default");
		contentPanel.add(comboBox_via, "4, 6, fill, default");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, "2, 8, 3, 3, fill, fill");
		table_1 = new JTable();
		{

			//Adicionar Elementos caso exista medicamentos na gaveta, caso nao haja remove tudo
			try {
				DefaultTableModel model_d = new DefaultTableModel(new Object[]{"Nome", "Data", "Receita", "Preço"}, 0);

				//Recebe medicamentos da venda selecionada
				ArrayList<Medicamento> med = farmacia.armarios[nrloja].getMedicamentosGaveta(comboBox_cat.getSelectedIndex(), comboBox_via.getSelectedIndex());
				//Adiciona os medicamentos na tablela
				for (Medicamento meds : med) {
					model_d.addRow(new Object[]{meds.getNome(), meds.getDataValidade(),meds.isReceita(), meds.getPreco()});
				}
				scrollPane.setViewportView(table_1);
				table_1.setModel(model_d);
				table_1.setBorder(new LineBorder(new Color(0, 0, 0)));

			} catch (Exception e1) {
				//model_d;
			}

			comboBox_cat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						DefaultTableModel model_cat = new DefaultTableModel(new Object[]{"Nome", "Data","Receita", "Preço"}, 0);

						ArrayList<Medicamento> meds = farmacia.armarios[nrloja].getMedicamentosGaveta(comboBox_cat.getSelectedIndex(), comboBox_via.getSelectedIndex());
						//Adiciona os medicamentos na tablela
						for (Medicamento med : meds) {
							model_cat.addRow(new Object[]{med.getNome(), med.getDataValidade(),med.isReceita(), med.getPreco()});
						}
						scrollPane.setViewportView(table_1);
						table_1.setModel(model_cat);
					}catch (NullPointerException e){
						DefaultTableModel ad = new DefaultTableModel(new Object[]{"Nome", "Data","Receita", "Preço"}, 0);
						scrollPane.setViewportView(table_1);
						table_1.setModel(ad);
					}
				}
			});
			comboBox_via.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						DefaultTableModel model_cat = new DefaultTableModel(new Object[]{"Nome", "Data" ,"Receita", "Preço"}, 0);

						ArrayList<Medicamento> meds = farmacia.armarios[nrloja].getMedicamentosGaveta(comboBox_cat.getSelectedIndex(), comboBox_via.getSelectedIndex());
						//Adiciona os medicamentos na tablela
						for (Medicamento med : meds) {
							model_cat.addRow(new Object[]{med.getNome(), med.getDataValidade(),med.isReceita(), med.getPreco()});
						}
						scrollPane.setViewportView(table_1);
						table_1.setModel(model_cat);
					}catch (NullPointerException x){
						DefaultTableModel ad = new DefaultTableModel(new Object[]{"Nome", "Data","Receita", "Preço"}, 0);
						scrollPane.setViewportView(table_1);
						table_1.setModel(ad);
					}
				}
			});
		}

				JLabel lblModoPagamento = new JLabel("Modo Pagamento");
				contentPanel.add(lblModoPagamento, "6, 14, right, default");


				JComboBox comboBox_m_pagamento = new JComboBox(modoPagamento);
				contentPanel.add(comboBox_m_pagamento, "8, 14, fill, default");

		
			JLabel lblSubtotal = new JLabel("Sub-Total: ");
			contentPanel.add(lblSubtotal, "10, 14, right, default");
			JLabel lbl_valor_sub = new JLabel("");
			contentPanel.add(lbl_valor_sub, "11, 14");
			{
				JLabel lblDesconto = new JLabel("Desconto");
				contentPanel.add(lblDesconto, "6, 16, right, default");
			}
			
				JComboBox comboBox_desconto = new JComboBox(descontos);
				contentPanel.add(comboBox_desconto, "8, 16, fill, default");
			
			JLabel lblIva = new JLabel("Iva: ");
			contentPanel.add(lblIva, "10, 16, right, default");
			JLabel lbl_valor_iva = new JLabel("23");
			contentPanel.add(lbl_valor_iva, "11, 16");
			JLabel lblTotal = new JLabel("Total: ");
			contentPanel.add(lblTotal, "10, 18, right, default");
			JLabel lbl_valor_total = new JLabel("");
			contentPanel.add(lbl_valor_total, "11, 18");
		{
			JButton btnAdicionar = new JButton("Adicionar");
			btnAdicionar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (table_1.isRowSelected(table_1.getSelectedRow())){
						try{
							//Buscar Medicamento
							venda_temporaria.medicamentos.add(farmacia.armarios[nrloja].getMedicamentosGaveta(comboBox_cat.getSelectedIndex(),comboBox_via.getSelectedIndex()).get(table_1.getSelectedRow()));
							//remover do armario
							farmacia.armarios[nrloja].getMedicamentosGaveta(comboBox_cat.getSelectedIndex(),comboBox_via.getSelectedIndex()).remove(table_1.getSelectedRow());
							comboBox_cat.setSelectedIndex(0);
							DefaultTableModel cesto = new DefaultTableModel(new Object[]{"Nome", "Quantidade", "Preço","Estado"}, 0);
							ArrayList<Medicamento> venda_medicamentos = venda_temporaria.getMedicamentos();
							//Adiciona os medicamentos na tablela
							for (Medicamento med : venda_medicamentos) {
								cesto.addRow(new Object[]{med.getNome(), med.getDataValidade(), med.getPreco(),estados[med.getEstado()]});
							}
							scrollPane1.setViewportView(table);
							table.setModel(cesto);
							table.setBorder(new LineBorder(new Color(0, 0, 0)));
							contentPanel.add(scrollPane1, "8, 6, 4, 5, fill, fill");
							lbl_valor_iva.setText(""+ venda_temporaria.getIVA());
							lbl_valor_sub.setText("" + venda_temporaria.getPreco_sub());
							lbl_valor_total.setText(""+ venda_temporaria.getPreco_total());
						}catch (NullPointerException x){

						}
					}

				}
			});
			contentPanel.add(btnAdicionar, "6, 8");
		}
		{
			JButton btn_remover = new JButton("Remover");
			btn_remover.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (table.isRowSelected(table.getSelectedRow())){
						try{
							//Buscar Medicamento
							farmacia.armarios[nrloja].adicionarMedicamento(venda_temporaria.medicamentos.get(table.getSelectedRow()), 1);
							venda_temporaria.medicamentos.remove(table.getSelectedRow());
							//remover do armario
							//farmacia.armarios[nrloja].getMedicamentosGaveta(comboBox_cat.getSelectedIndex(),comboBox_via.getSelectedIndex()).remove(table_1.getSelectedRow());
							comboBox_cat.setSelectedIndex(0);
							DefaultTableModel cesto = new DefaultTableModel(new Object[]{"Nome", "Quantidade", "Preço","Estado"}, 0);
							ArrayList<Medicamento> venda_medicamentos = venda_temporaria.getMedicamentos();
							//Adiciona os medicamentos na tablela
							for (Medicamento med : venda_medicamentos) {
								cesto.addRow(new Object[]{med.getNome(), med.getDataValidade(), med.getPreco(),estados[med.getEstado()]});
							}
							scrollPane1.setViewportView(table);
							table.setModel(cesto);
							lbl_valor_iva.setText(""+ venda_temporaria.getIVA());
							lbl_valor_sub.setText("" + venda_temporaria.getPreco_sub());
							lbl_valor_total.setText(""+ venda_temporaria.getPreco_total());
							table.setBorder(new LineBorder(new Color(0, 0, 0)));
							contentPanel.add(scrollPane1, "8, 6, 4, 5, fill, fill");
						}catch (NullPointerException x){
							System.out.println("Erro a adicionar medicamento");
						}
					}
				}
			});
			contentPanel.add(btn_remover, "6, 10");
		}

		{
			JLabel lblDadosCliente = new JLabel("Dados Cliente");
			lblDadosCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblDadosCliente, "2, 12");
		}
		{
			JLabel lblDadpsDaCompra = new JLabel("Dados da Compra");
			lblDadpsDaCompra.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblDadpsDaCompra, "10, 12, right, default");
		}
		{
			JLabel lblNome_1 = new JLabel("Nome");
			contentPanel.add(lblNome_1, "2, 14, right, default");
		}
		{
			text_nome = new JTextField();
			contentPanel.add(text_nome, "4, 14, fill, default");
			text_nome.setColumns(10);
		}
		
		{
			JLabel lblNrContribuinte = new JLabel("Nrº Contribuinte");
			contentPanel.add(lblNrContribuinte, "2, 16, right, default");
		}
		{
			text_nr_contr = new JTextField();
			contentPanel.add(text_nr_contr, "4, 16, fill, default");
			text_nr_contr.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Concluir");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (venda_temporaria.medicamentos.size() > 0 && !text_nome.getText().isEmpty()&& !text_nr_contr.getText().isEmpty()){
							Cliente cliente1 = new Cliente(farmacia.gestorclientes.clientes.size() + 1, text_nome.getText(), Integer.parseInt(text_nr_contr.getText()), new Date());
							venda_temporaria.setCliente(cliente1);
							venda_temporaria.setCod_venda(farmacia.gestorvendas.vendas.size()+1);
							venda_temporaria.setData_compra(new Date());
							venda_temporaria.setFuncionario(new Funcionario(farmacia.getFuncionarioNome()));
							venda_temporaria.setFormaPagamento(comboBox_m_pagamento.getSelectedIndex());
							venda_temporaria.setDesconto(comboBox_desconto.getSelectedIndex());
							farmacia.gestorvendas.adicionarVenda(venda_temporaria);
							farmacia.gestorclientes.setCliente(cliente1);
							farmacia.adicionarMedicamentoHistorico(farmacia.armarios[nrloja].verificarStock(venda_temporaria));
							list_1.setListData(farmacia.gestorvendas.getVendas().toArray());
							list_3.setListData(farmacia.gestorvendas.getVendas().toArray());
							list_3.repaint();
							list_3.revalidate();
							JOptionPane optionPane = new JOptionPane("Venda concluida com sucesso!", JOptionPane.WARNING_MESSAGE);
							JDialog dialog = optionPane.createDialog("Progresso da Compra!");
							dialog.setAlwaysOnTop(true);
							dialog.setVisible(true);
							dispose();
						}else if (venda_temporaria.medicamentos.size() > 0 && !text_nome.getText().isEmpty()){
							Cliente cliente1 = new Cliente(farmacia.gestorclientes.clientes.size() + 1, text_nome.getText(), 999999999, new Date());
							venda_temporaria.setCliente(cliente1);
							venda_temporaria.setCod_venda(farmacia.gestorvendas.vendas.size()+1);
							venda_temporaria.setData_compra(new Date());
							venda_temporaria.setFuncionario(new Funcionario(farmacia.getFuncionarioNome()));
							venda_temporaria.setFormaPagamento(comboBox_m_pagamento.getSelectedIndex());
							venda_temporaria.setDesconto(comboBox_desconto.getSelectedIndex());						
							farmacia.gestorvendas.adicionarVenda(venda_temporaria);
							farmacia.gestorclientes.setCliente(cliente1);
							farmacia.adicionarMedicamentoHistorico(farmacia.armarios[nrloja].verificarStock(venda_temporaria));
							list_1.setListData(farmacia.gestorvendas.getVendas().toArray());
							list_3.setListData(farmacia.gestorvendas.getVendas().toArray());
							list_3.repaint();
							list_3.revalidate();
							JOptionPane optionPane = new JOptionPane("Venda concluida com sucesso(sem nr contribuinte)!", JOptionPane.WARNING_MESSAGE);
							JDialog dialog = optionPane.createDialog("Progresso da Compra!");
							dialog.setAlwaysOnTop(true);
							dialog.setVisible(true);
							dispose();
						}else{
							if (venda_temporaria.medicamentos.size() == 0){
								System.out.println("Sem medicamentos na compra");
							}
							if (text_nome.getText().isEmpty()){
								System.out.println("Sem Cliente!");
							}
						}
dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (venda_temporaria.medicamentos.size() > 0){
							for (Medicamento med:venda_temporaria.medicamentos){
								if (med.getEstado() != 0){
									farmacia.armarios[nrloja].adicionarMedicamento(med,1);
								}else{
									farmacia.armarios[nrloja_pendente].adicionarMedicamento(med,1);
								}
							}
						}
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}


	}

	
}