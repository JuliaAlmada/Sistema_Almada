/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Vendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u49558987859
 */
public class VendasControle extends AbstractTableModel{
    private List lista;
    public void setList(List lista){
    this.lista = lista;
    }

    public Vendas getBean (int row){
    return (Vendas) lista.get(row);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vendas vendas =(Vendas) lista.get(rowIndex);
         if (columnIndex == 0 ) {
            return vendas.getIdvenda();
        }
        if (columnIndex == 1 ) {
            return vendas.getData();
        }
        if (columnIndex == 2 ) {
            return vendas.getValor();
        }
        if (columnIndex == 3 ) {
            return vendas.getCliente();
        }
        if (columnIndex == 4 ) {
            return vendas.getVendedores();
        }
         return "";
    }
    @Override
    public String getColumnName(int column){
        if (column == 0 ) {
            return "id";
        }
        if (column == 1 ) {
            return "data";
        }
        if (column == 2 ) {
            return "valor";
        }
        if (column == 3 ) {
            return "cliente";
        }
        if (column == 4 ) {
            return "vendedores";
        }
        return "";
    }
}
