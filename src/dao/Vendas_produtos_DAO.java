/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Vendas_produtos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Vendas_produtos_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Vendas_produtos vendas_produtos = (Vendas_produtos) object;
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

            String sql = "insert into vendas_produtos values(?,?,?,?,?)  ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendas_produtos.getIdvenda_produto());
            pstm.setInt(2, vendas_produtos.getVenda());
            pstm.setInt(3, vendas_produtos.getProduto());
            pstm.setString(4, vendas_produtos.getQuantidade());
            pstm.setDouble(5, vendas_produtos.getValorUnitario());
            pstm.executeUpdate();
            // stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendas_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendas_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Vendas_produtos vendas_produtos = (Vendas_produtos) object;
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
            String sql = "update vendas_produtos set venda=?, produto=?, quantidade=?, valorUnitario=? where idvenda_produto=? ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setDouble(2, vendas_produtos.getVenda());
            pstm.setInt(3, vendas_produtos.getProduto());
            pstm.setString(4, vendas_produtos.getQuantidade());
            pstm.setDouble(5, vendas_produtos.getValorUnitario());
            pstm.setInt(6, vendas_produtos.getIdvenda_produto());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso o update
            // contanto que as linhas estejam seguindo a numeração do String sql,
            //tanto faz a sua posisão depois do PreparedStatement pstm = cnt.prepareStatement(sql);

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendas_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendas_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Vendas_produtos vendas_produtos = (Vendas_produtos) object;
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
            String sql = "delete from vendas_produtos where idvenda_produto=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendas_produtos.getIdvenda_produto());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso a delete

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendas_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendas_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Vendas_produtos vendas_produtos = new Vendas_produtos();
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
            String sql = "select * from vendas_produtos where idvenda_produto=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                vendas_produtos.setIdvenda_produto(rs.getInt("idvenda_produto"));
                vendas_produtos.setVenda(rs.getInt("venda"));
                vendas_produtos.setProduto(rs.getInt("produto"));
                vendas_produtos.setQuantidade(rs.getString("quantidade"));
                vendas_produtos.setValorUnitario(rs.getDouble("valorUnitario"));

            }

            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendas_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendas_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas_produtos;
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

            String sql = "select * from vendas_produtos ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next() == true) {
                Vendas_produtos vendas_produtos = new Vendas_produtos();
                vendas_produtos.setIdvenda_produto(rs.getInt("idvenda_produto"));
                vendas_produtos.setVenda(rs.getInt("venda"));
                vendas_produtos.setProduto(rs.getInt("produto"));
                vendas_produtos.setQuantidade(rs.getString("quantidade"));
                vendas_produtos.setValorUnitario(rs.getDouble("valorUnitario"));
            }
            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendas_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendas_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lista;
    }

    /*  public static void main(String[] args) {

        Vendas_produtos vendas_produtos = new Vendas_produtos();
        vendas_produtos.setIdvenda_produto(5);
        vendas_produtos.setVenda(1);
        vendas_produtos.setProduto(1);
        vendas_produtos.setQuantidade("15");
        vendas_produtos.setValorUnitario(20.00);
        Vendas_produtos_DAO vendas_produtos_DAO = new Vendas_produtos_DAO();
        vendas_produtos_DAO.insert(vendas_produtos);
        System.out.println("deu certo");
    }*/
}
