package com.company;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Encomendas extends JDialog implements Variaveis {

    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private JTable table_1;
    private JTable table_2;
    private JTable table_3;
    DefaultTableModel model_d = new DefaultTableModel(new Object[]{"Medicamento", "Categoria", "Via Administração", "Receita", "Data Validade", "Preço"}, 0);
    DefaultTableModel model_ruptura = new DefaultTableModel(new Object[]{"Medicamento", "Categoria", "Via Administração", "Receita", "Data Validade", "Preço"}, 0);
    DefaultTableModel carrinho = new DefaultTableModel(new Object[]{"Medicamento", "Categoria", "Via Administração", "Receita", "Data Validade", "Estado", "Preço"}, 0);
    private JTextField textField;
    private JTextField textField_1;


    /**
     * Create the dialog.
     */
    public Encomendas(Farmacia farmacia, int nrloja) {


        setBounds(100, 100, 841, 699);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblEncomendarProdutos = new JLabel("Encomendar Produtos");
        lblEncomendarProdutos.setBounds(28, 11, 143, 14);
        contentPanel.add(lblEncomendarProdutos);

        JLabel lblTodos = new JLabel("Todos");
        lblTodos.setBounds(31, 46, 46, 14);
        contentPanel.add(lblTodos);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 69, 376, 239);
        contentPanel.add(scrollPane);

        table = new JTable();
        try {

            ArrayList<Object> array = new ArrayList(farmacia.mostrarTodosMedicamentos());
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) != null) {
                    Medicamento m = new Medicamento();
                    m = (Medicamento) array.get(i);
                    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
                    String formattedDate = df.format(m.getDataValidade());
                    model_d.addRow(new Object[]{m.getNome(), categorias[m.getCategoria()], vias[m.getViaAdmin()], receitas[m.isReceita() ? 1 : 0], formattedDate, m.getPreco()});
                    table.setModel(model_d);
                } else {
                    JOptionPane.showMessageDialog(null, "O cliente ainda não efectuou compras!");
                }
            }
            scrollPane.setViewportView(table);

        } catch (Exception e) {
            System.out.print("Sem Medicamentos inseridos");
        }


        JLabel lblNewLabel = new JLabel("Produtos em RUPTURA de stock");
        lblNewLabel.setBounds(453, 46, 190, 14);
        contentPanel.add(lblNewLabel);

        table_1 = new JTable();


        JLabel lblCarrinhoEncomenda = new JLabel("Carrinho Encomenda");
        lblCarrinhoEncomenda.setBounds(28, 343, 217, 14);
        contentPanel.add(lblCarrinhoEncomenda);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(28, 368, 766, 203);
        contentPanel.add(scrollPane_2);

        table_2 = new JTable();
        scrollPane_2.setViewportView(table_2);

        JButton btnNewButton = new JButton("Remover Linha");
        btnNewButton.setBounds(571, 592, 125, 23);
        contentPanel.add(btnNewButton);

        JButton btnEncomendar = new JButton("Encomendar");
        btnEncomendar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int total = 0;
                Medicamento medicamento = new Medicamento();
                String medic;
                medic = (String) model_d.getValueAt(table.getSelectedRow(), 0);
                medicamento = farmacia.armarios[nrloja].procurarMedicamento(medic);
                medicamento.setEstado(2);
                total = farmacia.armarios[nrloja].getQuantidadGaveta(medicamento.getCategoria(), medicamento.getViaAdmin());

                if (Integer.parseInt(textField.getText()) < (10 - total)) {
                    //farmacia.armarios[nrloja].adicionarMedicamento(medicamento, Integer.parseInt(textField.getText()));
                    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
                    String formattedDate = df.format(medicamento.getDataValidade());
                    carrinho.addRow(new Object[]{medicamento.getNome(), categorias[medicamento.getCategoria()], vias[medicamento.getViaAdmin()], receitas[medicamento.isReceita() ? 1 : 0], formattedDate, estados[medicamento.getEstado()], medicamento.getPreco()});
                    table_2.setModel(carrinho);
                }


            }
        });
        btnEncomendar.setBounds(280, 319, 112, 23);
        contentPanel.add(btnEncomendar);

        JButton button = new JButton("Encomendar");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Medicamento medicamento = new Medicamento(farmacia.getMedicamentosHistorico().get(table_3.getSelectedRow()));
                medicamento.setEstado(2);
                if (Integer.parseInt(textField_1.getText()) < 10) {

                    //farmacia.armarios[nrloja].adicionarMedicamento(medicamento, Integer.parseInt(textField.getText()));
                    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
                    String formattedDate = df.format(medicamento.getDataValidade());
                    carrinho.addRow(new Object[]{medicamento.getNome(), categorias[medicamento.getCategoria()], vias[medicamento.getViaAdmin()], receitas[medicamento.isReceita() ? 1 : 0], formattedDate, estados[medicamento.getEstado()], medicamento.getPreco()});
                    table_2.setModel(carrinho);
                }
            }
        });
        button.setBounds(670, 319, 112, 23);
        contentPanel.add(button);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(439, 70, 355, 239);
        contentPanel.add(scrollPane_1);

        table_3 = new JTable();


        try {
            ArrayList<Object> array1 = new ArrayList(farmacia.getMedicamentosHistorico());
            //	ArrayList<Object> array1 = new ArrayList(farmacia.mostrarTodosMedicamentos());
            for (int i = 0; i < array1.size(); i++) {
                if (array1.get(i) != null) {
                    Medicamento m = new Medicamento();
                    m = (Medicamento) array1.get(i);

                    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
                    String formattedDate = df.format(m.getDataValidade());
                    model_ruptura.addRow(new Object[]{m.getNome(), categorias[m.getCategoria()], vias[m.getViaAdmin()], receitas[m.isReceita() ? 1 : 0], formattedDate, m.getPreco()});
                    table_3.setModel(model_ruptura);
                    scrollPane_1.setViewportView(table_3);
                } else {
                    JOptionPane.showMessageDialog(null, "O cliente ainda não efectuou compras!");
                }
            }
        } catch (Exception e) {
            System.out.print("Sem Medicamentos em ruptura");
        }

        scrollPane_1.setViewportView(table_3);

        textField = new JTextField();
        textField.setBounds(183, 320, 86, 20);
        contentPanel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Quantidade");
        lblNewLabel_1.setBounds(109, 323, 75, 14);
        contentPanel.add(lblNewLabel_1);

        JLabel label = new JLabel("Quantidade");
        label.setBounds(494, 323, 75, 14);
        contentPanel.add(label);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(571, 320, 86, 20);
        contentPanel.add(textField_1);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
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

