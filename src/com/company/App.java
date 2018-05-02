package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 973, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nome");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Preço");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		
		JComboBox comboBox = new JComboBox();
		
		 for (int i = 0; i < categorias.length; i++) {
			 comboBox.addItem(categorias[i]);
	        }
		
		
		JLabel lblViaDeAdministrao = new JLabel("Via de Administração");
		
		JComboBox comboBox_1 = new JComboBox();
		for (int i = 0; i < vias.length; i++) {
			 comboBox_1.addItem(vias[i]);
	        }
		
		
		JButton btnNewButton = new JButton("Inserir");
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
			        armario.adicionarMedicamento(medic);
			        
			        textField_2.setText(armario.toString());
			}
		});
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Guardar Objecto");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e1) {
				try {
				/*FileOutputStream f = new FileOutputStream(new File("Armario.bin"));
					ObjectOutputStream o = new ObjectOutputStream(f);

				// Write objects to file
					o.writeObject(armario);
					

					o.close();
					f.close();*/
					
					FileInputStream fi = new FileInputStream(new File("Armario.bin"));
					ObjectInputStream oi = new ObjectInputStream(fi);

					// Read objects
					Armario arm =  (Armario) oi.readObject();
					
System.out.println("Fuck");
					System.out.println(arm.getNome());
					

					oi.close();
					fi.close();

				} catch (FileNotFoundException e) {
					System.out.println("File not found");
				} catch (IOException e) {
					System.out.println("Error initializing stream");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(244)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(146)
							.addComponent(btnNewButton)
							.addGap(59)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblCategoria)
								.addComponent(lblViaDeAdministrao))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(344, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(141)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(11)
							.addComponent(lblNewLabel_1)
							.addGap(11)
							.addComponent(lblCategoria)
							.addGap(11)
							.addComponent(lblViaDeAdministrao))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(41)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
