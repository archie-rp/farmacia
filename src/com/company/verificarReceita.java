package com.company;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class verificarReceita extends JDialog implements Variaveis {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private boolean estado;

	

	/**
	 * Create the dialog.
	 */
	public verificarReceita(Medicamento medicamento) {
		this.textCodigo = null;
		this.estado=false;

		setBounds(100, 100, 296, 255);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(67dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblDetalhesDoMedicamento = new JLabel("Detalhes do Medicamento");
			lblDetalhesDoMedicamento.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblDetalhesDoMedicamento, "2, 2, 3, 1");
		}
		{
			JLabel lblNome = new JLabel("Nome");
			lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblNome, "2, 4, right, default");
		}
		{
			JLabel lblNome = new JLabel(medicamento.getNome());
			contentPanel.add(lblNome, "4, 4");
		}
		{
			JLabel lblCategoria = new JLabel("Categoria");
			lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblCategoria, "2, 6, right, default");
		}
		{
			JLabel lblCategoria = new JLabel(categorias[medicamento.getCategoria()]);
			contentPanel.add(lblCategoria, "4, 6");
		}
		{
			JLabel lblViaDeAdministrao = new JLabel("Via de Administração");
			lblViaDeAdministrao.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblViaDeAdministrao, "2, 8, right, default");
		}
		{
			JLabel lblVia = new JLabel(vias[medicamento.getViaAdmin()]);
			contentPanel.add(lblVia, "4, 8");
		}
		{
			JLabel lblDataValidade = new JLabel("Data Validade");
			lblDataValidade.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblDataValidade, "2, 10, right, default");
		}
		{
			JLabel lblDataValidade = new JLabel("" + medicamento.getDataValidade());
			contentPanel.add(lblDataValidade, "4, 10");
		}
		{
			JLabel lblCodigoDaReceita = new JLabel("Codigo da Receita");
			lblCodigoDaReceita.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblCodigoDaReceita, "2, 14");
		}
		{
			textCodigo = new JTextField();
			contentPanel.add(textCodigo, "4, 14, fill, default");
			textCodigo.setColumns(10);
		}
		{


			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (!textCodigo.getText().isEmpty() && Integer.parseInt(textCodigo.getText()) == codigo_receita){
							System.out.println("Codigo Correcto");
							dispose();
							estado= true;
						}else{
							JOptionPane.showMessageDialog(null, "Código incorrecto ou sem valor introduzido!");
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
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public boolean isEstado() {
		return estado;
	}
}
