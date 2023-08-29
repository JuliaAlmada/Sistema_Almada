/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import bean.Vendedores;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u49558987859
 */
public class VendedoresControle extends AbstractTableModel{
    private List lista;
    public void setList(List lista){
    this.lista = lista;
    }

    public Vendedores getBean (int row){
    return (Vendedores) lista.get(row);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 16;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vendedores vendedores =(Vendedores) lista.get(rowIndex);
         if (columnIndex == 0 ) {
            return vendedores.getIdvendedor();
        }
        if (columnIndex == 1 ) {
            return vendedores.getNome();
        }
        if (columnIndex == 2 ) {
            return vendedores.getEmail();
        }
        if (columnIndex == 3 ) {
            return vendedores.getEmailreserva();
        }
        if (columnIndex == 4 ) {
            return vendedores.getCpf();  
        }
        if (columnIndex == 5 ) {
            return vendedores.getDatanascimento();
        }
        if (columnIndex == 6 ) {
            return vendedores.getCelular();
        }
        if (columnIndex == 7 ) {
            return vendedores.getTelefone();
        }
        if (columnIndex == 8) {
            return vendedores.getCarteiratrabalho();
        }
        if (columnIndex == 9 ) {
            return vendedores.getBairro();
        }
        if (columnIndex == 10 ) {
            return vendedores.getCidade();
        }
        if (columnIndex == 11 ) {
            return vendedores.getPais();
        }
        if (columnIndex == 12) {
            return vendedores.getEndereco();
        }
         if (columnIndex == 13 ) {
            return vendedores.getCep();
        }
        if (columnIndex == 14 ) {
            return vendedores.getSexo();
        }
        if (columnIndex == 15) {
            return vendedores.getAtivo();
        }
         return "";
    }
    @Override
    public String getColumnName(int column){
        if (column == 0 ) {
            return "id";
        }
        if (column == 1 ) {
            return "nome";
        }
        if (column == 2 ) {
            return "email";
        }
        if (column == 3 ) {
            return "emailreserva";
        }
        if (column == 4 ) {
            return "cpf";
        }
        if (column == 5 ) {
            return "datanascimento";
        }
        if (column == 6 ) {
            return "celular";
        }
        if (column == 7 ) {
            return "telefone";
        }
        if (column == 8 ) {
            return "carteiratrabalho";
        }
        if (column == 9 ) {
            return "bairro";
        }
        if (column == 10 ) {
            return "cidade";
        }
        if (column == 11 ) {
            return "pais";
        }
        if (column == 12 ) {
            return "endereco";
        }
        if (column == 13 ) {
            return "cep";
        }
        if (column == 14 ) {
            return "sexo";
        }
         if (column == 15 ) {
            return "ativo";
        }
        return "";
    }
}
