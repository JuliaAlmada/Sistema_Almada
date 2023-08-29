/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Clientes;
import dao.Clientes_DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Acer
 */
public class JDlgClientes extends javax.swing.JDialog {

    private boolean incluindo;
    MaskFormatter mascaraCPF, mascaraDataNascimento, mascaraCelular, mascaraTelefone, mascaraCep;

    /**
     * Creates new form JDlgCliente
     */
    public JDlgClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        desabilitar();
        setTitle("Cadastro de Clientes");
        setLocationRelativeTo(null);
        try {
            mascaraCPF = new MaskFormatter("###.###.###-##");
            mascaraDataNascimento = new MaskFormatter("##/##/####");
            mascaraCelular = new MaskFormatter("(##)#####-####");
            mascaraTelefone = new MaskFormatter("(##)#####-####");
            mascaraCep = new MaskFormatter("#####-###");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtCpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCPF));
        jFmtDataN.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNascimento));
        jFmtCelular.setFormatterFactory(new DefaultFormatterFactory(mascaraCelular));
        jFmtTelefone.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
        jFmtCep.setFormatterFactory(new DefaultFormatterFactory(mascaraCep));

    }

    public void habilitar() {
        jTxtCodigo1.setEnabled(true);
        jTxtNome.setEnabled(true);
        jTxtEmail.setEnabled(true);
        jTxtEmailRes.setEnabled(true);
        jTxtCidade.setEnabled(true);
        jTxtBairro.setEnabled(true);
        jTxtPais.setEnabled(true);
        jTxtEndereco.setEnabled(true);
        jFmtCelular.setEnabled(true);
        jFmtCep.setEnabled(true);
        jFmtCpf.setEnabled(true);
        jFmtCartaoFidelidade.setEnabled(true);
        jFmtDataN.setEnabled(true);
        jFmtTelefone.setEnabled(true);
        jCboSexo.setEnabled(true);
        jChbAtivo.setEnabled(true);
        jBtnIncluir.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jBtnAlterar.setEnabled(false);
        jBtnPesquisar.setEnabled(false);
        jBtnConfirmar.setEnabled(true);
        jBtnCancelar.setEnabled(true);
    }

    public void desabilitar() {
        jTxtCodigo1.setEnabled(false);
        jTxtNome.setEnabled(false);
        jTxtEmail.setEnabled(false);
        jTxtEmailRes.setEnabled(false);
        jTxtCidade.setEnabled(false);
        jTxtBairro.setEnabled(false);
        jTxtPais.setEnabled(false);
        jTxtEndereco.setEnabled(false);
        jFmtCelular.setEnabled(false);
        jFmtCep.setEnabled(false);
        jFmtCpf.setEnabled(false);
        jFmtCartaoFidelidade.setEnabled(false);
        jFmtDataN.setEnabled(false);
        jFmtTelefone.setEnabled(false);
        jCboSexo.setEnabled(false);
        jChbAtivo.setEnabled(false);
        jBtnIncluir.setEnabled(true);
        jBtnExcluir.setEnabled(true);
        jBtnAlterar.setEnabled(true);
        jBtnPesquisar.setEnabled(true);
        jBtnConfirmar.setEnabled(false);
        jBtnCancelar.setEnabled(false);

    }

    public void limparCampos() {
        jTxtNome.setText("");
        jTxtEmail.setText("");
        jTxtEmailRes.setText("");
        jTxtEndereco.setText("");
        jTxtPais.setText("");
        jTxtBairro.setText("");
        jTxtCidade.setText("");
        jTxtCodigo1.setText("");
        jFmtTelefone.setText("");
        jFmtDataN.setText("");
        jFmtCpf.setText("");
        jFmtCep.setText("");
        jFmtCelular.setText("");
        jFmtCartaoFidelidade.setText("");
        jCboSexo.setSelectedIndex(-1);
        jChbAtivo.setSelected(false);
    }

    public Clientes ViewBean() {
        Clientes clientes = new Clientes();
        int id = Integer.parseInt(jTxtCodigo1.getText());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            clientes.setDatanascimento(formato.parse(jFmtDataN.getText()));
        } catch (ParseException ex) {
            System.out.println("Erro, burro:" + ex.getMessage());
        }
        //transforma string para inteiro
        clientes.setIdcliente(id);
        clientes.setNome(jTxtNome.getText());
        clientes.setEmail(jTxtEmail.getText());
        clientes.setCpf(jFmtCpf.getText());
        clientes.setSexo(jCboSexo.getSelectedIndex());
        clientes.setCelular(jFmtCelular.getText());
        clientes.setEmailreserva(jTxtEmailRes.getText());
        clientes.setEndereco(jTxtEndereco.getText());
        clientes.setBairro(jTxtBairro.getText());
        clientes.setCidade(jTxtCidade.getText());
        clientes.setPais(jTxtPais.getText());
        clientes.setCartaofidelidade(jFmtCartaoFidelidade.getText());
        clientes.setCep(jFmtCep.getText());
        clientes.setTelefone(jFmtTelefone.getText());
        clientes.setSexo(jCboSexo.getSelectedIndex());

        if (jChbAtivo.isSelected() == true) {
            clientes.setAtivo("S");
        } else {
            clientes.setAtivo("N");
        }
        return clientes;
    }

    public void beanView(Clientes clientes) {
        String id = String.valueOf(clientes.getIdcliente());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

       
        //transforma inteiro para string
        jTxtCodigo1.setText(id);
        jFmtDataN.setText(formato.format(clientes.getDatanascimento()));
        jTxtNome.setText(clientes.getNome());
        jTxtEmail.setText(clientes.getEmail());
        jFmtCpf.setText(clientes.getCpf());
        jCboSexo.setSelectedIndex(clientes.getSexo());
        jFmtCelular.setText(clientes.getCelular());
        jTxtEmailRes.setText(clientes.getEmailreserva());
        jTxtEndereco.setText(clientes.getEndereco());
        jTxtBairro.setText(clientes.getBairro());
        jTxtCidade.setText(clientes.getCidade());
        jTxtPais.setText(clientes.getPais());
        jFmtCartaoFidelidade.setText(clientes.getCartaofidelidade());
        jFmtCep.setText(clientes.getCep());
        jFmtTelefone.setText(clientes.getTelefone());

        if (clientes.getAtivo().equals("S") == true) {
            jChbAtivo.setSelected(true);
        } else {
            jChbAtivo.setSelected(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFntCelular1 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTxtCodigo = new javax.swing.JTextField();
        jTxtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtEmailRes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jFmtCpf = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFmtDataN = new javax.swing.JFormattedTextField();
        jCboSexo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFmtCelular = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jFmtTelefone = new javax.swing.JFormattedTextField();
        jTxtEndereco = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTxtBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTxtCidade = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTxtPais = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jFmtCep = new javax.swing.JFormattedTextField();
        jChbAtivo = new javax.swing.JCheckBox();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jFmtCartaoFidelidade = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jTxtCodigo1 = new javax.swing.JTextField();

        jLabel8.setText("Celular");

        jLabel16.setText("Código");

        jTxtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtCodigoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtCodigoFocusLost(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Email");

        jLabel3.setText("CPF");

        jLabel4.setText("Email Reserva ");

        jLabel5.setText("Data de Nascimento");

        jCboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino", "Outro" }));

        jLabel6.setText("Sexo");

        jLabel7.setText("Celular");

        jLabel9.setText("Telefone");

        jLabel10.setText("Endereço");

        jLabel11.setText("Bairro");

        jLabel12.setText("Cidade");

        jLabel13.setText("País");

        jLabel14.setText("CEP");

        jChbAtivo.setText("Ativo");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar_1.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gravar.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jLabel15.setText("Cartão fidelidade");

        jFmtCartaoFidelidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtCartaoFidelidadeActionPerformed(evt);
            }
        });

        jLabel17.setText("Código");

        jTxtCodigo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtCodigo1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtCodigo1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnPesquisar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jFmtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTxtEmailRes)
                            .addComponent(jTxtEmail)
                            .addComponent(jFmtDataN)
                            .addComponent(jTxtNome))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jFmtTelefone)
                            .addComponent(jFmtCelular)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(jChbAtivo))
                            .addComponent(jLabel15)
                            .addComponent(jFmtCartaoFidelidade)
                            .addComponent(jLabel17)
                            .addComponent(jTxtCodigo1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jTxtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(jTxtPais)
                            .addComponent(jLabel14)
                            .addComponent(jFmtCep)
                            .addComponent(jLabel10)
                            .addComponent(jTxtEndereco)
                            .addComponent(jLabel11)
                            .addComponent(jTxtBairro))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(11, 11, 11)
                                .addComponent(jTxtEmailRes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFmtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFmtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFmtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFmtCartaoFidelidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFmtDataN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jChbAtivo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar)
                    .addComponent(jBtnConfirmar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        incluindo = true;
        habilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        incluindo = false;
        habilitar();
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here
        int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?",
                "Exlusão", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_NO_OPTION) {
            Clientes clientes = ViewBean();
            Clientes_DAO clientes_DAO = new Clientes_DAO();
            clientes_DAO.delete(clientes);
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada");
        }
        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        Clientes clientes = ViewBean();
        Clientes_DAO clientes_DAO = new Clientes_DAO();
        if (incluindo == true) {
            clientes_DAO.insert(clientes);
        } else {
            clientes_DAO.update(clientes);
        }

        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Cancelamento concluído");
        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        /*String resp = JOptionPane.showInputDialog(null, "Entre com o código (PK)", "Pesquisar", 2);
        int id = Integer.parseInt(resp);
        //transformou string em inteiro

        Clientes_DAO clientes_DAO = new Clientes_DAO();
        Clientes clientes = (Clientes) clientes_DAO.list(id);
        //retorna um bean e mostra na tela
        beanView(clientes);*/
        JDlgClientesPesquisa jDlgClientesPesquisa = new JDlgClientesPesquisa(null, true);
        jDlgClientesPesquisa.setTelaAnterior(this);
        jDlgClientesPesquisa.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jFmtCartaoFidelidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtCartaoFidelidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtCartaoFidelidadeActionPerformed

    private void jTxtCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCodigoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigoFocusGained

    private void jTxtCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCodigoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigoFocusLost

    private void jTxtCodigo1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCodigo1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigo1FocusGained

    private void jTxtCodigo1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCodigo1FocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jTxtCodigo1FocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgClientes dialog = new JDlgClientes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<String> jCboSexo;
    private javax.swing.JCheckBox jChbAtivo;
    private javax.swing.JFormattedTextField jFmtCartaoFidelidade;
    private javax.swing.JFormattedTextField jFmtCelular;
    private javax.swing.JFormattedTextField jFmtCep;
    private javax.swing.JFormattedTextField jFmtCpf;
    private javax.swing.JFormattedTextField jFmtDataN;
    private javax.swing.JFormattedTextField jFmtTelefone;
    private javax.swing.JFormattedTextField jFntCelular1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTxtBairro;
    private javax.swing.JTextField jTxtCidade;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtCodigo1;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtEmailRes;
    private javax.swing.JTextField jTxtEndereco;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtPais;
    // End of variables declaration//GEN-END:variables
}
