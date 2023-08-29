/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import bean.Vendas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Vendas_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Vendas vendas = (Vendas) object;
        String url, user, password;

        url = "jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "julia_almada";
        password = "julia_almada";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //   Statement stm;
            //stm = cnt.createStatement();

            String sql = "insert into vendas values(?,?,?,?,?)  ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendas.getIdvenda());
            pstm.setDate(2, new java.sql.Date(vendas.getData().getTime()));
            pstm.setDouble(3, vendas.getValor());
            pstm.setInt(4, vendas.getCliente());
            pstm.setInt(5, vendas.getVendedores());

            pstm.executeUpdate();
            // stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendas_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendas_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Vendas vendas = (Vendas) object;
        String url, user, password;
        url = "jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "julia_almada";
        password = "julia_almada";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //  Statement stm;
            // stm = cnt.createStatement();
            String sql = "update vendas set data=?, valor=?, cliente=?, vendedores=? where idvenda=? ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setDate(1, new java.sql.Date(vendas.getData().getTime()));
            pstm.setDouble(2, vendas.getValor());
            pstm.setInt(3, vendas.getCliente());
            pstm.setInt(4, vendas.getVendedores());
            pstm.setInt(5, vendas.getIdvenda());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso o update
            // contanto que as linhas estejam seguindo a numeração do String sql,
            //tanto faz a sua posisão depois do PreparedStatement pstm = cnt.prepareStatement(sql);

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendas_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendas_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Vendas vendas = (Vendas) object;
        String url, user, password;
        url = "jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "julia_almada";
        password = "julia_almada";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //  Statement stm;
            // stm = cnt.createStatement();
            String sql = "delete from vendas where idvenda=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendas.getIdvenda());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso a delete

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendas_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendas_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Vendas vendas = new Vendas();
        String url, user, password;
        url = "jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "julia_almada";
        password = "julia_almada";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //  Statement stm;
            // stm = cnt.createStatement();
            String sql = "select * from vendas where idvenda=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                vendas.setIdvenda(rs.getInt("idvenda"));
                vendas.setData(rs.getDate("data"));
                vendas.setValor(rs.getDouble("valor"));
                vendas.setCliente(rs.getInt("cliente"));
                vendas.setVendedores(rs.getInt("vendedores"));

            }

            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendas_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendas_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }

    @Override
    public List listAll() {
        String url, user, password;
        url = "jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "julia_almada";
        password = "julia_almada";
        List lista = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            // Statement stm;
            //  stm = cnt.createStatement;

            String sql = "select * from vendas ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next() == true) {
                Vendas vendas = new Vendas();
                vendas.setIdvenda(rs.getInt("idvenda"));
                vendas.setData(rs.getDate("data"));
                vendas.setValor(rs.getDouble("valor"));
                vendas.setCliente(rs.getInt("cliente"));
                vendas.setVendedores(rs.getInt("vendedores"));
                lista.add(vendas);
            }
            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendas_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendas_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lista;
    }

    /* public static void main(String[] args) {

        Vendas vendas = new Vendas();
        vendas.setIdvenda(2);
        // vendas.setDate("18/01/06");
        vendas.setValor(2000.00);
        vendas.setCliente(1);
        vendas.setVendedores(1);
        Vendas_DAO vendas_DAO = new Vendas_DAO();
        vendas_DAO.insert(vendas);
        System.out.println("deu certo");
    }*/
}
