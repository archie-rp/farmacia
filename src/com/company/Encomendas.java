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
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;


public class Encomendas extends JDialog implements Variaveis {

    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private JTable table_1;
    private JTable table_2;
    private JTable table_3;
    DefaultTableModel model_d = new DefaultTableModel(new Object[]{"Medicamento", "Categoria", "Via Administração", "Receita", "Data Validade", "Preço"}, 0);
    DefaultTableModel model_ruptura = new DefaultTableModel(new Object[]{"Medicamento", "Categoria", "Via Administração", "Receita", "Data Validade", "Preço"}, 0);
    DefaultTableModel carrinho = new DefaultTableModel(new Object[]{"Medicamento", "Categoria", "Via Administração", "Receita", "Data Validade", "Estado", "Quantidade","Preço"}, 0);
    private JTextField textField;
    private JTextField textField_1;


    /**
     * Create the dialog.
     */
    public Encomendas(Farmacia farmacia, int nrloja) {


        setBounds(100, 100, 841, 623);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblEncomendarProdutos = new JLabel("Encomendar Produtos");
        lblEncomendarProdutos.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEncomendarProdutos.setBounds(28, 11, 143, 14);
        contentPanel.add(lblEncomendarProdutos);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Todos os medicamentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(16, 36, 394, 296);
        contentPanel.add(panel);
        panel.setLayout(new FormLayout(new ColumnSpec[] {
        		FormSpecs.RELATED_GAP_COLSPEC,
        		FormSpecs.DEFAULT_COLSPEC,
        		FormSpecs.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("max(27dlu;default)"),
        		FormSpecs.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("257px"),},
        	new RowSpec[] {
        		FormSpecs.PARAGRAPH_GAP_ROWSPEC,
        		RowSpec.decode("bottom:max(146dlu;default):grow"),
        		FormSpecs.RELATED_GAP_ROWSPEC,
        		RowSpec.decode("top:25px"),}));
        
                JScrollPane scrollPane = new JScrollPane();
                panel.add(scrollPane, "2, 2, 5, 1, fill, fill");
                
                        table = new JTable();
                        scrollPane.setViewportView(table);
                                
                                        JLabel lblNewLabel_1 = new JLabel("Quantidade");
                                        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
                                        panel.add(lblNewLabel_1, "2, 4");
                                        
                                                textField = new JTextField();
                                                panel.add(textField, "4, 4");
                                                textField.setColumns(10);
                                                
                                                        JButton btnEncomendar = new JButton("Encomendar");
                                                        panel.add(btnEncomendar, "6, 4, center, default");
                                                        btnEncomendar.addMouseListener(new MouseAdapter() {
                                                            @Override
                                                            public void mouseClicked(MouseEvent arg0) {
                                                                int total = 0;
                                                                Medicamento medicamento = new Medicamento();
                                                                String medic;
                                                                try {
                                                                    medic = (String) model_d.getValueAt(table.getSelectedRow(), 0);
                                                                    medicamento = farmacia.armarios[nrloja].procurarMedicamento(medic);
                                                                    Medicamento temp = (Medicamento) medicamento.clone();
                                                                    temp.setEstado(2);
                                                                    temp.setQuantidadeEncomenda(Integer.parseInt(textField.getText()));
                                                                    total = farmacia.armarios[nrloja].getQuantidadGaveta(temp.getCategoria(), temp.getViaAdmin());
                                                                    System.out.print(total);
                                                                    if (Integer.parseInt(textField.getText()) < (10 - total)) {
                                                                    
                                                                    	  try {
                                                                              farmacia.medicamentosEncomendados.add(temp);
                                                                          } catch (Exception e) {
                                                                        	  farmacia.medicamentosEncomendados = new ArrayList<Medicamento>();
                                                                        	  farmacia.medicamentosEncomendados.add(temp);
                                                                          }
                                                                    //  System.out.println(farmacia.medicamentosHistorico.get(0).toString());
                                                                        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
                                                                        String formattedDate = df.format(temp.getDataValidade());
                                                                       
                                                                        carrinho.addRow(new Object[]{temp.getNome(), categorias[temp.getCategoria()], vias[temp.getViaAdmin()], receitas[temp.isReceita() ? 1 : 0], formattedDate, estados[temp.getEstado()], temp.getPreco()});
                                                                        table_2.setModel(carrinho);
                                                                    }
                                                                } catch (CloneNotSupportedException e) {
                                                                    System.out.println(e.getMessage());
                                                                    e.printStackTrace();
                                                                }

                                                            }
                                                        });
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

        } catch (Exception e) {
            System.out.print("Sem Medicamentos inseridos");
        }

        table_1 = new JTable();

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(28, 368, 766, 146);
        contentPanel.add(scrollPane_2);

        table_2 = new JTable();
        scrollPane_2.setViewportView(table_2);

        JButton btnNewButton = new JButton("Remover Linha");
        btnNewButton.setBounds(669, 525, 125, 23);
        contentPanel.add(btnNewButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Produtos em ruptura de Stock", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(420, 36, 374, 296);
        contentPanel.add(panel_1);
        panel_1.setLayout(new FormLayout(new ColumnSpec[] {
        		FormSpecs.RELATED_GAP_COLSPEC,
        		FormSpecs.DEFAULT_COLSPEC,
        		FormSpecs.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("max(35dlu;default)"),
        		FormSpecs.RELATED_GAP_COLSPEC,
        		ColumnSpec.decode("center:223px"),},
        	new RowSpec[] {
        		FormSpecs.PARAGRAPH_GAP_ROWSPEC,
        		RowSpec.decode("227px"),
        		FormSpecs.RELATED_GAP_ROWSPEC,
        		FormSpecs.DEFAULT_ROWSPEC,}));

        JScrollPane scrollPane_1 = new JScrollPane();
        panel_1.add(scrollPane_1, "1, 2, 6, 1, fill, fill");

        table_3 = new JTable();
        
                scrollPane_1.setViewportView(table_3);
                        
                                JLabel label = new JLabel("Quantidade");
                                label.setFont(new Font("Tahoma", Font.BOLD, 11));
                                panel_1.add(label, "2, 4");
                                
                                        textField_1 = new JTextField();
                                        panel_1.add(textField_1, "4, 4");
                                        textField_1.setColumns(10);
                                        
                                                JButton button = new JButton("Encomendar");
                                                panel_1.add(button, "6, 4");
                                                button.addMouseListener(new MouseAdapter() {
                                                    @Override
                                                    public void mouseClicked(MouseEvent arg0) {
                                                    	
                                                    	int total = 0;
                                                        Medicamento medicamento = new Medicamento(farmacia.getMedicamentosHistorico().get(table_3.getSelectedRow()));
                                                      
                                                        try {
                                                          
                                                         
                                                            Medicamento temp = (Medicamento) medicamento.clone();
                                                            temp.setEstado(2);
                                                            temp.setQuantidadeEncomenda(Integer.parseInt(textField_1.getText()));
                                                            total = farmacia.armarios[nrloja].getQuantidadGaveta(temp.getCategoria(), temp.getViaAdmin());
                                                            System.out.print(total);
                                                            if (Integer.parseInt(textField_1.getText()) < (10 - total)) {
                                                            
                                                            	  try {
                                                                      farmacia.medicamentosEncomendados.add(temp);
                                                                  } catch (Exception e) {
                                                                	  farmacia.medicamentosEncomendados = new ArrayList<Medicamento>();
                                                                	  farmacia.medicamentosEncomendados.add(temp);
                                                                  }
                                                            //  System.out.println(farmacia.medicamentosHistorico.get(0).toString());
                                                                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
                                                                String formattedDate = df.format(temp.getDataValidade());
                                                               
                                                                carrinho.addRow(new Object[]{temp.getNome(), categorias[temp.getCategoria()], vias[temp.getViaAdmin()], receitas[temp.isReceita() ? 1 : 0], formattedDate, estados[temp.getEstado()], temp.getPreco()});
                                                                table_2.setModel(carrinho);
                                                            }
                                                        } catch (CloneNotSupportedException e) {
                                                            System.out.println(e.getMessage());
                                                            e.printStackTrace();
                                                        }

                                                    	
                                                    
                                                    }
                                                });


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
        
        
        try {
            ArrayList<Object> array1 = new ArrayList(farmacia.getMedicamentosEncomendados());
          
            //	ArrayList<Object> array1 = new ArrayList(farmacia.mostrarTodosMedicamentos());
            for (int i = 0; i < array1.size(); i++) {
                if (array1.get(i) != null) {
                    Medicamento m = new Medicamento();
                    m = (Medicamento) array1.get(i);

                    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
                    String formattedDate = df.format(m.getDataValidade());
                    carrinho.addRow(new Object[]{m.getNome(), categorias[m.getCategoria()], vias[m.getViaAdmin()], receitas[m.isReceita() ? 1 : 0], formattedDate, estados[m.getEstado()],m.getQuantidadeEncomenda(),m.getPreco()});
                    table_2.setModel(carrinho);
                    scrollPane_1.setViewportView(table_3);
                } else {
                    JOptionPane.showMessageDialog(null, "O cliente ainda não efectuou compras!");
                }
            }
        } catch (Exception e) {
            System.out.print("Sem Medicamentos em ruptura");
        }
                                
                                
                                        JLabel lblCarrinhoEncomenda = new JLabel("Produtos encomendados");
                                        lblCarrinhoEncomenda.setFont(new Font("Tahoma", Font.BOLD, 11));
                                        lblCarrinhoEncomenda.setBounds(28, 343, 360, 14);
                                        contentPanel.add(lblCarrinhoEncomenda);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("Confirmar Encomenda");
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
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
}

