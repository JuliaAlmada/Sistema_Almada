/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Clientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u49558987859
 */
public class ClientesControle extends AbstractTableModel{
    private List lista;
    public void setList(List lista){
    this.lista = lista;
    }

    public Clientes getBean (int row){
    return (Clientes) lista.get(row);
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
        Clientes clientes =(Clientes) lista.get(rowIndex);
         if (columnIndex == 0 ) {
            return clientes.getIdcliente();
        }
        if (columnIndex == 1 ) {
            return clientes.getNome();
        }
        if (columnIndex == 2 ) {
            return clientes.getEmail();
        }
        if (columnIndex == 3 ) {
            return clientes.getCpf();
        }
        if (columnIndex == 4 ) {
            return clientes.getDatanascimento();  
        }
        if (columnIndex == 5 ) {
            return clientes.getSexo();
        }
        if (columnIndex == 6 ) {
            return clientes.getCelular();
        }
        if (columnIndex == 7 ) {
            return clientes.getEmailreserva();
        }
        if (columnIndex == 8) {
            return clientes.getEndereco();
        }
        if (columnIndex == 9 ) {
            return clientes.getBairro();
        }
        if (columnIndex == 10 ) {
            return clientes.getCidade();
        }
        if (columnIndex == 11 ) {
            return clientes.getPais();
        }
        if (columnIndex == 12) {
            return clientes.getCartaofidelidade();
        }
         if (columnIndex == 13 ) {
            return clientes.getCep();
        }
        if (columnIndex == 14 ) {
            return clientes.getAtivo();
        }
        if (columnIndex == 15) {
            return clientes.getTelefone();
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
            return "cpf";
        }
        if (column == 4 ) {
            return "datanascimento";
        }
        if (column == 5 ) {
            return "sexo";
        }
        if (column == 6 ) {
            return "celular";
        }
        if (column == 7 ) {
            return "emailreserva";
        }
        if (column == 8 ) {
            return "endereco";
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
            return "cartaofidelidade";
        }
        if (column == 13 ) {
            return "cep";
        }
        if (column == 14 ) {
            return "ativo";
        }
         if (column == 15 ) {
            return "telefone";
        }
        return "";
    }
}
