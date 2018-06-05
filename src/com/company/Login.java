package com.company;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

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
		lblBemvindoPharmacell.setBounds(10, 22, 133, 14);
		contentPanel.add(lblBemvindoPharmacell);
		
		JLabel lblUtilizador = new JLabel("Utilizador");
		lblUtilizador.setBounds(10, 47, 60, 14);
		contentPanel.add(lblUtilizador);
		
		JLabel lblPalavrapasse = new JLabel("Palavra-passe");
		lblPalavrapasse.setBounds(10, 97, 99, 14);
		contentPanel.add(lblPalavrapasse);
		
		textPassword = new JTextField();
		textPassword.setBounds(10, 122, 110, 20);
		contentPanel.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblSelecioneUmaDas = new JLabel("Selecione uma das Lojas");
		lblSelecioneUmaDas.setBounds(10, 153, 187, 14);
		contentPanel.add(lblSelecioneUmaDas);
		
		JComboBox comboLoja = new JComboBox(farmacias);
		comboLoja.setBounds(10, 180, 168, 20);
		contentPanel.add(comboLoja);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("phamacy.png"));
		label.setBounds(266, 22, 99, 182);
		contentPanel.add(label);
		
		JLabel lblFeitoPorRafael = new JLabel("Feito por: Rafael e Hugo");
		lblFeitoPorRafael.setBounds(276, 203, 148, 14);
		contentPanel.add(lblFeitoPorRafael);
		
		JComboBox comboBox = new JComboBox(funcionarios);
		comboBox.setBounds(10, 73, 153, 22);
		contentPanel.add(comboBox);
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
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
