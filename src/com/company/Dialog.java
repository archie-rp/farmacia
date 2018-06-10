package com.company;

import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.Font;

public class Dialog extends JDialog implements Variaveis {

    private final JPanel contentPanel = new JPanel();
    private JTable table;

    public Dialog(Relatorio relatorio,Farmacia farmacia) {


        setBounds(100, 100, 842, 464);
        getContentPane().setLayout(null);
        contentPanel.setBounds(0, 0, 826, 105);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 111, 101, 81, 101, 31, 50, 83, 87, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{20, 24, 26, 19, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);
        
        JLabel lblDetalhesDoRelatrio = new JLabel("Detalhes do Relatório");
        lblDetalhesDoRelatrio.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblDetalhesDoRelatrio = new GridBagConstraints();
        gbc_lblDetalhesDoRelatrio.fill = GridBagConstraints.VERTICAL;
        gbc_lblDetalhesDoRelatrio.insets = new Insets(0, 0, 5, 5);
        gbc_lblDetalhesDoRelatrio.gridx = 1;
        gbc_lblDetalhesDoRelatrio.gridy = 0;
        contentPanel.add(lblDetalhesDoRelatrio, gbc_lblDetalhesDoRelatrio);
        
        JLabel lblDetalhesDaLoja = new JLabel("Detalhes da loja");
        lblDetalhesDaLoja.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblDetalhesDaLoja = new GridBagConstraints();
        gbc_lblDetalhesDaLoja.fill = GridBagConstraints.VERTICAL;
        gbc_lblDetalhesDaLoja.insets = new Insets(0, 0, 5, 5);
        gbc_lblDetalhesDaLoja.gridx = 3;
        gbc_lblDetalhesDaLoja.gridy = 0;
        contentPanel.add(lblDetalhesDaLoja, gbc_lblDetalhesDaLoja);
        
        JLabel lblInformaes = new JLabel("Informações");
        lblInformaes.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblInformaes = new GridBagConstraints();
        gbc_lblInformaes.anchor = GridBagConstraints.EAST;
        gbc_lblInformaes.fill = GridBagConstraints.VERTICAL;
        gbc_lblInformaes.insets = new Insets(0, 0, 5, 5);
        gbc_lblInformaes.gridx = 6;
        gbc_lblInformaes.gridy = 0;
        contentPanel.add(lblInformaes, gbc_lblInformaes);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\Archierp\\IdeaProjects\\farmacia\\phamacy.png"));
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 0, 5);
        gbc_label.gridheight = 4;
        gbc_label.gridx = 8;
        gbc_label.gridy = 0;
        contentPanel.add(label, gbc_label);
        {
            JLabel lblNFuncionario = new JLabel("Nome Funcionário: ");
            lblNFuncionario.setFont(new Font("Tahoma", Font.BOLD, 11));
            GridBagConstraints gbc_lblNFuncionario = new GridBagConstraints();
            gbc_lblNFuncionario.insets = new Insets(0, 0, 5, 5);
            gbc_lblNFuncionario.anchor = GridBagConstraints.EAST;
            gbc_lblNFuncionario.gridx = 1;
            gbc_lblNFuncionario.gridy = 1;
            contentPanel.add(lblNFuncionario, gbc_lblNFuncionario);
        }
        {
            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setText(relatorio.getFuncionario());


            GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
            gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
            gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel.gridx = 2;
            gbc_lblNewLabel.gridy = 1;
            contentPanel.add(lblNewLabel, gbc_lblNewLabel);
        }

        JLabel lblLoja = new JLabel("Identificação da Loja:");
        lblLoja.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblLoja = new GridBagConstraints();
        gbc_lblLoja.anchor = GridBagConstraints.EAST;
        gbc_lblLoja.insets = new Insets(0, 0, 5, 5);
        gbc_lblLoja.gridx = 3;
        gbc_lblLoja.gridy = 1;
        contentPanel.add(lblLoja, gbc_lblLoja);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setText(relatorio.getNomeFarmacia());
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 4;
        gbc_lblNewLabel_4.gridy = 1;
        contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
        gbc_lblInformaes.gridheight = 4;
        gbc_lblInformaes.insets = new Insets(0, 0, 0, 5);
        gbc_lblInformaes.gridx = 8;
        gbc_lblInformaes.gridy = 0;
        
        JLabel lblBi = new JLabel("BI:");
        lblBi.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblBi = new GridBagConstraints();
        gbc_lblBi.anchor = GridBagConstraints.EAST;
        gbc_lblBi.insets = new Insets(0, 0, 5, 5);
        gbc_lblBi.gridx = 6;
        gbc_lblBi.gridy = 1;
        contentPanel.add(lblBi, gbc_lblBi);
        
        JLabel label_1_bi = new JLabel(""+ farmacia.getBi());
        GridBagConstraints gbc_label_1_bi = new GridBagConstraints();
        gbc_label_1_bi.insets = new Insets(0, 0, 5, 5);
        gbc_label_1_bi.gridx = 7;
        gbc_label_1_bi.gridy = 1;
        contentPanel.add(label_1_bi, gbc_label_1_bi);
        {
            JLabel lblNCliente = new JLabel("Nome Cliente:");
            lblNCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
            GridBagConstraints gbc_lblNCliente = new GridBagConstraints();
            gbc_lblNCliente.anchor = GridBagConstraints.EAST;
            gbc_lblNCliente.insets = new Insets(0, 0, 5, 5);
            gbc_lblNCliente.gridx = 1;
            gbc_lblNCliente.gridy = 2;
            contentPanel.add(lblNCliente, gbc_lblNCliente);
        }
        {
            JLabel lblNewLabel_1 = new JLabel();
            lblNewLabel_1.setText(relatorio.getCliente());

            GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
            gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
            gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_1.gridx = 2;
            gbc_lblNewLabel_1.gridy = 2;
            contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
        }
        
        JLabel lblModoPagamento = new JLabel("Modo Pagamento:");
        lblModoPagamento.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblModoPagamento = new GridBagConstraints();
        gbc_lblModoPagamento.anchor = GridBagConstraints.EAST;
        gbc_lblModoPagamento.insets = new Insets(0, 0, 5, 5);
        gbc_lblModoPagamento.gridx = 3;
        gbc_lblModoPagamento.gridy = 2;
        contentPanel.add(lblModoPagamento, gbc_lblModoPagamento);
        
        JLabel lblNewLabel_modo_pagamento = new JLabel(modoPagamento[relatorio.getVenda().getFormaPagamento()]);
        GridBagConstraints gbc_lblNewLabel_modo_pagamento = new GridBagConstraints();
        gbc_lblNewLabel_modo_pagamento.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_modo_pagamento.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_modo_pagamento.gridx = 4;
        gbc_lblNewLabel_modo_pagamento.gridy = 2;
        contentPanel.add(lblNewLabel_modo_pagamento, gbc_lblNewLabel_modo_pagamento);
        
        JLabel lblNib = new JLabel("NIB:");
        lblNib.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblNib = new GridBagConstraints();
        gbc_lblNib.anchor = GridBagConstraints.EAST;
        gbc_lblNib.insets = new Insets(0, 0, 5, 5);
        gbc_lblNib.gridx = 6;
        gbc_lblNib.gridy = 2;
        contentPanel.add(lblNib, gbc_lblNib);
        
        JLabel lblNewLabel_2_nib = new JLabel("" + farmacia.getNib());
        GridBagConstraints gbc_lblNewLabel_2_nib = new GridBagConstraints();
        gbc_lblNewLabel_2_nib.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2_nib.gridx = 7;
        gbc_lblNewLabel_2_nib.gridy = 2;
        contentPanel.add(lblNewLabel_2_nib, gbc_lblNewLabel_2_nib);
        {
            JLabel lblDataCompra = new JLabel("Data Compra:");
            lblDataCompra.setFont(new Font("Tahoma", Font.BOLD, 11));
            GridBagConstraints gbc_lblDataCompra = new GridBagConstraints();
            gbc_lblDataCompra.anchor = GridBagConstraints.EAST;
            gbc_lblDataCompra.insets = new Insets(0, 0, 0, 5);
            gbc_lblDataCompra.gridx = 1;
            gbc_lblDataCompra.gridy = 3;
            contentPanel.add(lblDataCompra, gbc_lblDataCompra);
            
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
            String formattedDate = df.format(relatorio.getVenda().getDataCompra());

            JLabel lblNewLabel_3 = new JLabel();
lblNewLabel_3.setText(formattedDate);

            GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
            gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
            gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
            gbc_lblNewLabel_3.gridx = 2;
            gbc_lblNewLabel_3.gridy = 3;
            contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
            }
        
        JLabel lblCapital = new JLabel("Capital:");
        lblCapital.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_lblCapital = new GridBagConstraints();
        gbc_lblCapital.anchor = GridBagConstraints.EAST;
        gbc_lblCapital.insets = new Insets(0, 0, 0, 5);
        gbc_lblCapital.gridx = 6;
        gbc_lblCapital.gridy = 3;
        contentPanel.add(lblCapital, gbc_lblCapital);
        
        JLabel lblNewLabel_2_capital = new JLabel("" + farmacia.getCapital());
        GridBagConstraints gbc_lblNewLabel_2_capital = new GridBagConstraints();
        gbc_lblNewLabel_2_capital.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_2_capital.gridx = 7;
        gbc_lblNewLabel_2_capital.gridy = 3;
        contentPanel.add(lblNewLabel_2_capital, gbc_lblNewLabel_2_capital);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBounds(0, 391, 826, 34);
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane);
            {
                JButton okButton = new JButton("OK");
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

        JButton btnNewButton = new JButton("Detalhes");
        btnNewButton.setVisible(false);
        btnNewButton.setBounds(727, 357, 89, 23);
        getContentPane().add(btnNewButton);
        {
            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(null, "Medicamentos Adquiridos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            panel.setBounds(31, 102, 785, 255);
            getContentPane().add(panel);
            panel.setLayout(null);
            {
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(6, 16, 769, 231);
                panel.add(scrollPane);
                {
                    if (relatorio.getVendas().size() < 2) {
                        table = new JTable();
                        DefaultTableModel model_d = new DefaultTableModel(new Object[]{"Medicamento", "Categoria", "Via Administração", "Preço", "Estado", "Receita", "Data Validade" }, 0);
                        ArrayList<Object> array = new ArrayList(relatorio.getVenda().getMedicamentos());
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) != null) {
                                Medicamento m = new Medicamento();
                                m = (Medicamento) array.get(i);
                                String receita;

                                if (m.isReceita()) {
                                    receita = "Têm receita";
                                } else {
                                    receita = "Não tem receita";
                                }

                                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
                                String formattedDate = df.format(m.getDataValidade());
                                model_d.addRow(new Object[]{m.getNome(), categorias[m.getCategoria()], vias[m.getViaAdmin()], m.getPreco(), estados[m.getEstado()], receita, formattedDate });
                                table.setModel(model_d);
                            } else {
                                JOptionPane.showMessageDialog(null, "O cliente ainda não efectuou compras!");
                            }
                        }
                    } else {
                        table = new JTable();
                        DefaultTableModel model_d = new DefaultTableModel(new Object[]{"Venda ", "Data", "Funcionario", "Preço"}, 0);
                        ArrayList<Object> array = new ArrayList(relatorio.getVendas());
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) != null) {
                                Venda m = new Venda();
                                m = (Venda) array.get(i);
                                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
                                String formattedDate = df.format(m.getDataCompra());
                                model_d.addRow(new Object[]{m.getCod_venda(), formattedDate, m.getFuncionario().getNome(), m.getPreco_total()});
                                table.setModel(model_d);
                                btnNewButton.setVisible(true);
                            }
                        }
                    }

                    scrollPane.setViewportView(table);
                }
            }
        }


        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Relatorio relat = new Relatorio(relatorio.getVendas().get(table.getSelectedRow()), "Costa-Prozelo");
                Dialog dialog = new Dialog(relat,farmacia);
                dialog.setVisible(true);
            }
        });

    }
}
