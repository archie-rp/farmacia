package com.company;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog dialog = new Dialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog(Relatorio relatorio) {


		setBounds(100, 100, 948, 602);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 932, 92);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 111, 130, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNFuncionario = new JLabel("Nº Funcionário: ");
			GridBagConstraints gbc_lblNFuncionario = new GridBagConstraints();
			gbc_lblNFuncionario.insets = new Insets(0, 0, 5, 5);
			gbc_lblNFuncionario.anchor = GridBagConstraints.WEST;
			gbc_lblNFuncionario.gridx = 2;
			gbc_lblNFuncionario.gridy = 1;
			contentPanel.add(lblNFuncionario, gbc_lblNFuncionario);
		}
		{
			JLabel lblNewLabel = new JLabel(relatorio.getNomeFarmacia());
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.gridx = 3;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblNCliente = new JLabel("Nº Cliente:");
			GridBagConstraints gbc_lblNCliente = new GridBagConstraints();
			gbc_lblNCliente.anchor = GridBagConstraints.WEST;
			gbc_lblNCliente.insets = new Insets(0, 0, 5, 5);
			gbc_lblNCliente.gridx = 2;
			gbc_lblNCliente.gridy = 2;
			contentPanel.add(lblNCliente, gbc_lblNCliente);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_1.gridx = 3;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel lblDataCompra = new JLabel("Data Compra:");
			GridBagConstraints gbc_lblDataCompra = new GridBagConstraints();
			gbc_lblDataCompra.anchor = GridBagConstraints.WEST;
			gbc_lblDataCompra.insets = new Insets(0, 0, 0, 5);
			gbc_lblDataCompra.gridx = 2;
			gbc_lblDataCompra.gridy = 3;
			contentPanel.add(lblDataCompra, gbc_lblDataCompra);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.gridx = 3;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 529, 932, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
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
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Medicamentos Adquiridos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(73, 149, 700, 258);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(6, 16, 688, 235);
				panel.add(scrollPane);
				{
					table = new JTable();
					table.setModel(new DefaultTableModel(
						new Object[][] {
							{"asdas<", null, null, null, null},
						},
						new String[] {
							"New column", "New column", "New column", "New column", "New column"
						}
					));
					scrollPane.setViewportView(table);
				}
			}
		}
	}

	public Dialog() {
		// TODO Auto-generated constructor stub
	}


}
