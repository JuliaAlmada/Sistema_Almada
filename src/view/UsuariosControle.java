/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Usuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u49558987859
 */
public class UsuariosControle extends AbstractTableModel{
    private List lista;
    public void setList(List lista){
    this.lista = lista;
    }

    public Usuarios getBean (int row){
    return (Usuarios) lista.get(row);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuarios usuarios =(Usuarios) lista.get(rowIndex);
         if (columnIndex == 0 ) {
            return usuarios.getIdUsuario();
        }
        if (columnIndex == 1 ) {
            return usuarios.getNome();
        }
        if (columnIndex == 2 ) {
            return usuarios.getApelido();
        }
        if (columnIndex == 3 ) {
            return usuarios.getCpf();
        }
        if (columnIndex == 4 ) {
            return usuarios.getSenha();
        }
        if (columnIndex == 5 ) {
            return usuarios.getNivel();
        }
        if (columnIndex == 6 ) {
            return usuarios.getAtivo();
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
            return "apelido";
        }
        if (column == 3 ) {
            return "cpf";
        }
        if (column == 4 ) {
            return "senha";
        }
        if (column == 5 ) {
            return "nivel";
        }
        if (column == 6 ) {
            return "ativo";
        }
        return "";
    }
}
