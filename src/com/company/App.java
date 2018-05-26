package com.company;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App extends JFrame implements CatVia{
	static Armario armario = new Armario();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}


			}			
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1047, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 991, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		
			
			JPanel panel = new JPanel();
			tabbedPane.addTab("Inserir", null, panel, null);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 139, 271, 16, 0, 0, 269, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 262, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			JLabel lblNewLabel = new JLabel("Nome");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 8;
			gbc_lblNewLabel.gridy = 2;
			panel.add(lblNewLabel, gbc_lblNewLabel);
			
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.BOTH;
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.gridx = 9;
			gbc_textField.gridy = 2;
			panel.add(textField, gbc_textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Preço");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 8;
			gbc_lblNewLabel_1.gridy = 3;
			panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			textField_1 = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.fill = GridBagConstraints.BOTH;
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.gridx = 9;
			gbc_textField_1.gridy = 3;
			panel.add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
			
			JLabel lblCategoria = new JLabel("Categoria");
			GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
			gbc_lblCategoria.anchor = GridBagConstraints.WEST;
			gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
			gbc_lblCategoria.gridx = 8;
			gbc_lblCategoria.gridy = 4;
			panel.add(lblCategoria, gbc_lblCategoria);
			
			JComboBox comboBox = new JComboBox();
			
			 for (int i = 0; i < categorias.length; i++) {
				 comboBox.addItem(categorias[i]);
		        }
			
			
			 
				
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.BOTH;
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.gridx = 9;
			gbc_comboBox.gridy = 4;
			panel.add(comboBox, gbc_comboBox);
			
			
			
			JLabel lblViaDeAdministrao = new JLabel("Via de Administração");
			GridBagConstraints gbc_lblViaDeAdministrao = new GridBagConstraints();
			gbc_lblViaDeAdministrao.anchor = GridBagConstraints.WEST;
			gbc_lblViaDeAdministrao.insets = new Insets(0, 0, 5, 5);
			gbc_lblViaDeAdministrao.gridx = 8;
			gbc_lblViaDeAdministrao.gridy = 5;
			panel.add(lblViaDeAdministrao, gbc_lblViaDeAdministrao);
			
			JComboBox comboBox_1 = new JComboBox();
			for (int i = 0; i < vias.length; i++) {
				 comboBox_1.addItem(vias[i]);
		        }
			
			GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
			gbc_comboBox_1.fill = GridBagConstraints.BOTH;
			gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox_1.gridx = 9;
			gbc_comboBox_1.gridy = 5;
			panel.add(comboBox_1, gbc_comboBox_1);
			
				
				
				JButton btnNewButton = new JButton("Inserir");
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton.gridx = 9;
				gbc_btnNewButton.gridy = 6;
				panel.add(btnNewButton, gbc_btnNewButton);
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						 String preco=textField_1.getText();
					        float f = Float.parseFloat(preco);
						
						    //Inserir Medicamento
						 Medicamento medic = new Medicamento();
					        medic.setNome(textField.getText());

					       medic.setPreco(f);
					        medic.setCategoria(comboBox.getSelectedIndex());
					        medic.setViaAdmin(comboBox_1.getSelectedIndex());
					        armario.adicionarMedicamento(medic,1);
					        
					        textField_2.setText(medic.toString());
					}
				});
				
				textField_2 = new JTextField();
				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
				gbc_textField_2.insets = new Insets(0, 0, 5, 5);
				gbc_textField_2.gridwidth = 13;
				gbc_textField_2.fill = GridBagConstraints.BOTH;
				gbc_textField_2.gridx = 1;
				gbc_textField_2.gridy = 8;
				panel.add(textField_2, gbc_textField_2);
				textField_2.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			tabbedPane.addTab("Listar", null, panel_1, null);
		contentPane.setLayout(gl_contentPane);
	}
}
