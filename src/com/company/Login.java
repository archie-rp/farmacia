package com.company;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

public class Login extends JDialog implements Variaveis {

	private final JPanel contentPanel = new JPanel();
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblBemvindoPharmacell = new JLabel("Bem-Vindo a PharmaCell");
		lblBemvindoPharmacell.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblBemvindoPharmacell.setBounds(10, 11, 194, 14);
		contentPanel.add(lblBemvindoPharmacell);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.BLACK);
		label.setIcon(new ImageIcon("phamacy.png"));
		label.setBounds(266, 22, 99, 182);
		contentPanel.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 47, 219, 181);
		contentPanel.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{1, 144, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblUtilizador = new JLabel("Utilizador");
		lblUtilizador.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblUtilizador = new GridBagConstraints();
		gbc_lblUtilizador.anchor = GridBagConstraints.WEST;
		gbc_lblUtilizador.insets = new Insets(0, 0, 5, 5);
		gbc_lblUtilizador.gridx = 1;
		gbc_lblUtilizador.gridy = 0;
		panel.add(lblUtilizador, gbc_lblUtilizador);
		
		JComboBox comboBox = new JComboBox(funcionarios);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
		
		JLabel lblSelecioneUmaDas = new JLabel("Selecione uma das Lojas");
		lblSelecioneUmaDas.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblSelecioneUmaDas = new GridBagConstraints();
		gbc_lblSelecioneUmaDas.anchor = GridBagConstraints.WEST;
		gbc_lblSelecioneUmaDas.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelecioneUmaDas.gridx = 1;
		gbc_lblSelecioneUmaDas.gridy = 2;
		panel.add(lblSelecioneUmaDas, gbc_lblSelecioneUmaDas);
		
		JComboBox comboLoja = new JComboBox(farmacias);
		GridBagConstraints gbc_comboLoja = new GridBagConstraints();
		gbc_comboLoja.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboLoja.insets = new Insets(0, 0, 5, 5);
		gbc_comboLoja.gridx = 1;
		gbc_comboLoja.gridy = 3;
		panel.add(comboLoja, gbc_comboLoja);
		
		JLabel lblPalavrapasse = new JLabel("Palavra-passe");
		lblPalavrapasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPalavrapasse = new GridBagConstraints();
		gbc_lblPalavrapasse.anchor = GridBagConstraints.WEST;
		gbc_lblPalavrapasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblPalavrapasse.gridx = 1;
		gbc_lblPalavrapasse.gridy = 4;
		panel.add(lblPalavrapasse, gbc_lblPalavrapasse);
		
		textPassword = new JTextField();
		GridBagConstraints gbc_textPassword = new GridBagConstraints();
		gbc_textPassword.insets = new Insets(0, 0, 5, 5);
		gbc_textPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPassword.gridx = 1;
		gbc_textPassword.gridy = 5;
		panel.add(textPassword, gbc_textPassword);
		textPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Feito por:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(249, 215, 59, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblRafaelEHugo = new JLabel("Rafael e Hugo");
		lblRafaelEHugo.setBounds(307, 214, 105, 14);
		contentPanel.add(lblRafaelEHugo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						Funcionario funcionario = new Funcionario(funcionarios[comboBox.getSelectedIndex()].getNome());
						int nrloja = comboLoja.getSelectedIndex();
						Farmacia farmacia_serializada = new Farmacia();
						try {
							File f = new File("Farmacia.ser");
							if (f.exists()){
								FileInputStream fileIn = new FileInputStream(f);
								ObjectInputStream in = new ObjectInputStream(fileIn);
								farmacia_serializada = (Farmacia) in.readObject();
								farmacia_serializada.setNumero_funcionario(comboBox.getSelectedIndex());
								in.close();
								fileIn.close();
								System.out.println("Farmacia existe.. a carregar..");
							}else {
								farmacia_serializada = new Farmacia();
								System.out.println("Farmacia nao existe a criar um novo");
							}
						} catch (IOException i) {
							System.out.println(i);
							return;
						} catch (ClassNotFoundException c) {
							System.out.println("Farmacia.ser nao encontrado!");
							farmacia_serializada = new Farmacia();
							c.printStackTrace();
							return;
						}
						Layout frame = new Layout(nrloja,farmacia_serializada);
						dispose();
						frame.setVisible(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Sair");
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
