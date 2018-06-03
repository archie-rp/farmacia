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
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;

public class criarVenda extends JDialog {

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
			criarVenda dialog = new criarVenda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public criarVenda() {
		setBounds(100, 100, 548, 507);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(72dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(43dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.MIN_ROWSPEC,
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
			contentPanel.add(panel, "2, 2, 10, 1, fill, top");
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
			contentPanel.add(lblEstadoDaCompra, "6, 4, 11, 1");
		}
		{
			JComboBox comboBox = new JComboBox();
			contentPanel.add(comboBox, "2, 6, fill, default");
		}
		{
			JComboBox comboBox = new JComboBox();
			contentPanel.add(comboBox, "4, 6, fill, default");
		}
		{
			table = new JTable();
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(table, "6, 6, 11, 3, fill, fill");
		}
		{
			table_1 = new JTable();
			table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(table_1, "2, 8, 3, 1, fill, fill");
		}
		{
			JLabel lblDadosCliente = new JLabel("Dados Cliente");
			lblDadosCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblDadosCliente, "2, 10");
		}
		{
			JLabel lblDadpsDaCompra = new JLabel("Dados da Compra");
			lblDadpsDaCompra.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(lblDadpsDaCompra, "12, 10");
		}
		{
			JLabel lblNome_1 = new JLabel("Nome");
			contentPanel.add(lblNome_1, "2, 12, right, default");
		}
		{
			textField = new JTextField();
			contentPanel.add(textField, "4, 12, fill, default");
			textField.setColumns(10);
		}
		{
			JLabel lblSubtotal = new JLabel("Sub-Total");
			contentPanel.add(lblSubtotal, "12, 12");
		}
		{
			JLabel lbl_valor_sub = new JLabel("");
			contentPanel.add(lbl_valor_sub, "16, 12");
		}
		{
			JLabel lblNrContribuinte = new JLabel("Nrº Contribuinte");
			contentPanel.add(lblNrContribuinte, "2, 14, right, default");
		}
		{
			textField_1 = new JTextField();
			contentPanel.add(textField_1, "4, 14, fill, default");
			textField_1.setColumns(10);
		}
		{
			JLabel lblIva = new JLabel("Iva");
			contentPanel.add(lblIva, "12, 14");
		}
		{
			JLabel lbl_valor_iva = new JLabel("");
			contentPanel.add(lbl_valor_iva, "16, 14");
		}
		{
			JLabel lblTotal = new JLabel("Total");
			contentPanel.add(lblTotal, "12, 16");
		}
		{
			JLabel lbl_valor_total = new JLabel("");
			contentPanel.add(lbl_valor_total, "16, 16");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Concluir");
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
