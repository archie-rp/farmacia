package com.company;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
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
		
		textField = new JTextField();
		textField.setBounds(10, 66, 110, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPalavrapasse = new JLabel("Palavra-passe");
		lblPalavrapasse.setBounds(10, 97, 99, 14);
		contentPanel.add(lblPalavrapasse);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 122, 110, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSelecioneUmaDas = new JLabel("Selecione uma das Lojas");
		lblSelecioneUmaDas.setBounds(10, 153, 187, 14);
		contentPanel.add(lblSelecioneUmaDas);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 180, 168, 20);
		contentPanel.add(comboBox);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Archierp\\Pictures\\phamacy.png"));
		label.setBounds(266, 22, 99, 182);
		contentPanel.add(label);
		
		JLabel lblFeitoPorRafael = new JLabel("Feito por: Rafael e Hugo");
		lblFeitoPorRafael.setBounds(276, 203, 148, 14);
		contentPanel.add(lblFeitoPorRafael);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						Layout frame = new Layout();
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
