package com.company;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class Importar extends JDialog implements Variaveis {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_quantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			//Importar dialog = new Importar();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Importar(Farmacia farmacia,int nrloja,Medicamento m) {
		setBounds(100, 100, 495, 325);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(10dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblLoja = new JLabel("Loja:");
			contentPanel.add(lblLoja, "4, 2");
		}

			JLabel label_nr_loja = new JLabel("" + nrloja);
			contentPanel.add(label_nr_loja, "6, 2");

		{
			JLabel lblDadosMedicamento = new JLabel("Dados Medicamento");
			lblDadosMedicamento.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblDadosMedicamento, "4, 4");
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Archierp\\IdeaProjects\\farmacia\\phamacy.png"));
			contentPanel.add(lblNewLabel, "16, 4, 1, 9");
		}
		{
			JLabel lblNome = new JLabel("Nome:");
			contentPanel.add(lblNome, "4, 6");
		}
		{
			JLabel lblNewLabel_nome = new JLabel(m.getNome());
			contentPanel.add(lblNewLabel_nome, "6, 6");
		}
		{
			JLabel lblCategoria = new JLabel("Categoria:");
			contentPanel.add(lblCategoria, "4, 8");
		}
		{
			JLabel lblNewLabel_categoria = new JLabel(categorias[m.getCategoria()]);
			contentPanel.add(lblNewLabel_categoria, "6, 8");
		}
		{
			JLabel lblViaDeAdministrao = new JLabel("Via de Administração:");
			contentPanel.add(lblViaDeAdministrao, "4, 10");
		}
		{
			JLabel lblNewLabel_via = new JLabel(vias[m.getViaAdmin()]);
			contentPanel.add(lblNewLabel_via, "6, 10");
		}
		{
			JLabel lblQuantidade = new JLabel("Quantidade:");
			contentPanel.add(lblQuantidade, "4, 12");
		}

			JLabel lblNewLabel_quantidade = new JLabel( "" + farmacia.armarios[nrloja].getMedicamentoQuantidade(m));
			contentPanel.add(lblNewLabel_quantidade, "6, 12");

		{
			JLabel lblQuantidade_1 = new JLabel("Quantidade:");
			contentPanel.add(lblQuantidade_1, "4, 16, right, default");
		}
		{
			JLabel lblDadosFuncionrio = new JLabel("Dados Funcionário");
			lblDadosFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblDadosFuncionrio, "4, 18");
		}

			textField_quantidade = new JTextField();
			contentPanel.add(textField_quantidade, "8, 18, fill, default");
			textField_quantidade.setColumns(10);

		{
			JLabel lblNome_1 = new JLabel("Nome:");
			contentPanel.add(lblNome_1, "4, 20");
		}
		{
			JLabel lblNewLabel_funcionario = new JLabel("");
			contentPanel.add(lblNewLabel_funcionario, "6, 20");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Importar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
                        int nr_quantidade = Integer.parseInt(textField_quantidade.getText());
						if(nr_quantidade < farmacia.armarios[nrloja].getMedicamentoQuantidade(m)){
						    System.out.println("Encomenda Realizada com sucesso!!");
						    dispose();
                        }
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
