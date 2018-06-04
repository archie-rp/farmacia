package com.company;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class criarVenda extends JDialog implements Variaveis{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			//criarVenda dialog = new criarVenda();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * Create the dialog.
	 */
	public criarVenda(Farmacia farmacia,int nrloja)  {
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
				FormSpecs.DEFAULT_COLSPEC,
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
			{
				JTextArea textArea = new JTextArea();
				textArea.setTabSize(5);
				panel.add(textArea, "3, 1, 3, 1, fill, default");
			}
			{
				JButton btnProcurar = new JButton("Procurar");
				panel.add(btnProcurar, "7, 1");
			}
		}
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
					DefaultTableModel model_d = new DefaultTableModel(new Object[]{"Nome", "Quantidade", "Preço"}, 0);
					ArrayList<Medicamento> med = venda_temporaria.getMedicamentos();
					//Adiciona os medicamentos na tablela
					for (Medicamento meds : med) {
						model_d.addRow(new Object[]{meds.getNome(), meds.getDataValidade(), meds.getPreco()});
					}
					scrollPane1.setViewportView(table);
					table.setModel(model_d);
					table.setBorder(new LineBorder(new Color(0, 0, 0)));
					contentPanel.add(scrollPane1, "8, 6, 5, 5, fill, fill");

				} catch (NullPointerException x) {
					System.out.println("tasdsa");
					DefaultTableModel ad = new DefaultTableModel(new Object[]{"Nome", "Quantidade", "Preço"}, 0);
					scrollPane1.setViewportView(table);
					table.setModel(ad);
				}
				scrollPane1.setViewportView(table);
				table.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
		}
		JComboBox comboBox_cat = new JComboBox(categorias);
		
		JComboBox comboBox_via = new JComboBox(vias);
		
		contentPanel.add(comboBox_cat, "2, 6, fill, default");
		contentPanel.add(comboBox_via, "4, 6, fill, default");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, "2, 8, 3, 3, fill, fill");
		table_1 = new JTable();
		{

			//Adicionar Elementos caso exista medicamentos na gaveta, caso nao haja remove tudo
			try {
				DefaultTableModel model_d = new DefaultTableModel(new Object[]{"Nome", "Data", "Preço"}, 0);

				//Recebe medicamentos da venda selecionada
				ArrayList<Medicamento> med = farmacia.armarios[nrloja].getMedicamentosGaveta(comboBox_cat.getSelectedIndex(), comboBox_via.getSelectedIndex());
				//Adiciona os medicamentos na tablela
				for (Medicamento meds : med) {
					model_d.addRow(new Object[]{meds.getNome(), meds.getDataValidade(), meds.getPreco()});
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
						DefaultTableModel model_cat = new DefaultTableModel(new Object[]{"Nome", "Data", "Preço"}, 0);

						ArrayList<Medicamento> meds = farmacia.armarios[nrloja].getMedicamentosGaveta(comboBox_cat.getSelectedIndex(), comboBox_via.getSelectedIndex());
						//Adiciona os medicamentos na tablela
						for (Medicamento med : meds) {
							model_cat.addRow(new Object[]{med.getNome(), med.getDataValidade(), med.getPreco()});
						}
						scrollPane.setViewportView(table_1);
						table_1.setModel(model_cat);
					}catch (NullPointerException e){
						DefaultTableModel ad = new DefaultTableModel(new Object[]{"Nome", "Data", "Preço"}, 0);
						scrollPane.setViewportView(table_1);
						table_1.setModel(ad);
					}
				}
			});
			comboBox_via.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						DefaultTableModel model_cat = new DefaultTableModel(new Object[]{"Nome", "Data", "Preço"}, 0);

						ArrayList<Medicamento> meds = farmacia.armarios[nrloja].getMedicamentosGaveta(comboBox_cat.getSelectedIndex(), comboBox_via.getSelectedIndex());
						//Adiciona os medicamentos na tablela
						for (Medicamento med : meds) {
							model_cat.addRow(new Object[]{med.getNome(), med.getDataValidade(), med.getPreco()});
						}
						scrollPane.setViewportView(table_1);
						table_1.setModel(model_cat);
					}catch (NullPointerException x){
						DefaultTableModel ad = new DefaultTableModel(new Object[]{"Nome", "Data", "Preço"}, 0);
						scrollPane.setViewportView(table_1);
						table_1.setModel(ad);
					}
				}
			});
		}
		
			JLabel lblSubtotal = new JLabel("Sub-Total: ");
			contentPanel.add(lblSubtotal, "10, 14, right, default");
			JLabel lbl_valor_sub = new JLabel("");
			contentPanel.add(lbl_valor_sub, "11, 14");
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
							DefaultTableModel cesto = new DefaultTableModel(new Object[]{"Nome", "Quantidade", "Preço"}, 0);
							ArrayList<Medicamento> venda_medicamentos = venda_temporaria.getMedicamentos();
							//Adiciona os medicamentos na tablela
							for (Medicamento med : venda_medicamentos) {
								cesto.addRow(new Object[]{med.getNome(), med.getDataValidade(), med.getPreco()});
							}
							scrollPane1.setViewportView(table);
							table.setModel(cesto);
							table.setBorder(new LineBorder(new Color(0, 0, 0)));
							contentPanel.add(scrollPane1, "8, 6, 4, 5, fill, fill");
							lbl_valor_iva.setText(""+ venda_temporaria.getIVA());
							lbl_valor_sub.setText("" + venda_temporaria.getPreco_sub());
							lbl_valor_total.setText(""+ venda_temporaria.getPreco_total());
						}catch (NullPointerException x){
							System.out.println("Erro a adicionar medicamento");
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
							DefaultTableModel cesto = new DefaultTableModel(new Object[]{"Nome", "Quantidade", "Preço"}, 0);
							ArrayList<Medicamento> venda_medicamentos = venda_temporaria.getMedicamentos();
							//Adiciona os medicamentos na tablela
							for (Medicamento med : venda_medicamentos) {
								cesto.addRow(new Object[]{med.getNome(), med.getDataValidade(), med.getPreco()});
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
			textField = new JTextField();
			contentPanel.add(textField, "4, 14, fill, default");
			textField.setColumns(10);
		}
		
		{
			JLabel lblNrContribuinte = new JLabel("Nrº Contribuinte");
			contentPanel.add(lblNrContribuinte, "2, 16, right, default");
		}
		{
			textField_1 = new JTextField();
			contentPanel.add(textField_1, "4, 16, fill, default");
			textField_1.setColumns(10);
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
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (venda_temporaria.medicamentos.size() > 0){
							for (Medicamento med:venda_temporaria.medicamentos){
								farmacia.armarios[nrloja].adicionarMedicamento(med,1);
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