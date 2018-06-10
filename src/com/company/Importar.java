package com.company;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Font;
import java.lang.reflect.Array;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Importar extends JDialog implements Variaveis {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public Importar(Farmacia farmacia,int nrloja, Medicamento m, Venda venda_temporaria, int loja_m,JTable table,JScrollPane scrollPane1) {
		setBounds(100, 100, 383, 325);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(63dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

		{
			JLabel lblDadosMedicamento = new JLabel("Dados Medicamento");
			lblDadosMedicamento.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblDadosMedicamento, "4, 4");
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Archierp\\IdeaProjects\\farmacia\\phamacy.png"));
			contentPanel.add(lblNewLabel, "8, 4, 1, 9");
		}
		{
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
			contentPanel.add(lblNome, "4, 6");
		}
		{
			JLabel lblNewLabel_nome = new JLabel(m.getNome());
			contentPanel.add(lblNewLabel_nome, "6, 6");
		}
		{
			JLabel lblCategoria = new JLabel("Categoria:");
			lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
			contentPanel.add(lblCategoria, "4, 8");
		}
		{
			JLabel lblNewLabel_categoria = new JLabel(categorias[m.getCategoria()]);
			contentPanel.add(lblNewLabel_categoria, "6, 8");
		}
		{
			JLabel lblViaDeAdministrao = new JLabel("Via de Administração:");
			lblViaDeAdministrao.setFont(new Font("Tahoma", Font.PLAIN, 11));
			contentPanel.add(lblViaDeAdministrao, "4, 10");
		}
		{
			JLabel lblNewLabel_via = new JLabel(vias[m.getViaAdmin()]);
			contentPanel.add(lblNewLabel_via, "6, 10");
		}
		{
			JLabel lblQuantidade = new JLabel("Quantidade:");
			lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
			contentPanel.add(lblQuantidade, "4, 12");
		}

			JLabel lblNewLabel_quantidade = new JLabel( "" + farmacia.armarios[loja_m].getMedicamentoQuantidade(m));
			contentPanel.add(lblNewLabel_quantidade, "6, 12");
		{
			JLabel lblAImportarDe = new JLabel("A Importar");
			lblAImportarDe.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblAImportarDe, "8, 14, center, default");
		}
		{
			JLabel lblDadosFuncionrio = new JLabel("Dados Funcionário");
			lblDadosFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblDadosFuncionrio, "4, 16");
		}

					JLabel label_nr_loja = new JLabel(farmacias[loja_m]);
					contentPanel.add(label_nr_loja, "8, 16, center, default");
		{
			JLabel lblNewLabel_funcionario = new JLabel("");
			contentPanel.add(lblNewLabel_funcionario, "6, 18");
		}

						{
							JLabel lblNome_1 = new JLabel("Nome:");
							lblNome_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
							contentPanel.add(lblNome_1, "4, 18");
						}
				{
					JLabel lblDefinirQuantidade = new JLabel("Definir quantidade");
					lblDefinirQuantidade.setFont(new Font("Tahoma", Font.BOLD, 11));
					contentPanel.add(lblDefinirQuantidade, "4, 20");
				}

				{
					JLabel lblQuantidade_1 = new JLabel("Quantidade:");
					contentPanel.add(lblQuantidade_1, "4, 22, right, default");
				}
							
								String[] items = new String[50];
								for (int i = 1; i <= farmacia.armarios[loja_m].getMedicamentoQuantidade(m); i++) {
									items[i] = "" + i;
								}
								// Change the current max visible rows
								  int maxVisibleRows = farmacia.armarios[loja_m].getMedicamentoQuantidade(m);
							
							JComboBox comboBox = new JComboBox(items);
							comboBox.setSelectedIndex(1);
							comboBox.setMaximumRowCount(maxVisibleRows);
							contentPanel.add(comboBox, "6, 22, fill, default");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Importar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
                        int nr_quantidade =comboBox.getSelectedIndex();
						if(nr_quantidade < farmacia.armarios[loja_m].getMedicamentoQuantidade(m)){
							m.setEstado(0);
							m.setCod_compra(farmacia.gestorvendas.vendas.size()+1);
							System.out.println("Nr_quantidade a importar:" + nr_quantidade);

							for(int i =0;i <nr_quantidade;i++){
						        if (m.getEstado() !=0) {
									try {
										farmacia.adicionarMedicamento_pendente((Medicamento) m.clone());
										venda_temporaria.setMedicamento((Medicamento) m.clone());
									}catch (CloneNotSupportedException x){
										System.out.println(x);
									}
									farmacia.armarios[nrloja].removerMedicamento(m);
								}else{
									try {
										farmacia.adicionarMedicamento_pendente((Medicamento) m.clone());
										venda_temporaria.setMedicamento((Medicamento) m.clone());

									}catch (CloneNotSupportedException x){
										System.out.println(x);
									}
									farmacia.armarios[loja_m].removerMedicamento(m);
								}
						    }
							DefaultTableModel model_d = new DefaultTableModel(new Object[]{"Nome", "Quantidade", "Preço", "Estado"}, 0);
							ArrayList<Medicamento> med = venda_temporaria.getMedicamentos();
							//Adiciona os medicamentos na tablela
							for (Medicamento meds : med) {
								model_d.addRow(new Object[]{meds.getNome(), meds.getDataValidade(), meds.getPreco(),estados[meds.getEstado()]});
							}
							scrollPane1.setViewportView(table);
							table.setModel(model_d);
						    DefaultTableModel dm = (DefaultTableModel)table.getModel();
						    dm.fireTableDataChanged();
						    dispose();
                        }
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
					dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
