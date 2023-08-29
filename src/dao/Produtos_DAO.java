/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Produtos;
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
public class Produtos_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Produtos produtos = (Produtos) object;
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

            String sql = "insert into produtos values(?,?,?,?,?,?)  ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, produtos.getIdproduto());
            pstm.setString(2, produtos.getNome());
            pstm.setString(3, produtos.getDescricao());
            pstm.setDouble(4, produtos.getValorCompra());
            pstm.setDouble(5, produtos.getValorVenda());
            pstm.setInt(6, produtos.getCategoria());
            pstm.executeUpdate();
            // stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Produtos produtos = (Produtos) object;
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
            String sql = "update produtos set nome=?, descricao=?, valorCompra=?, valorVenda=?, categoria=? where idproduto=? ";
            PreparedStatement pstm = cnt.prepareStatement(sql);

            pstm.setString(1, produtos.getNome());
            pstm.setString(2, produtos.getDescricao());
            pstm.setDouble(3, produtos.getValorCompra());
            pstm.setDouble(4, produtos.getValorVenda());
            pstm.setInt(5, produtos.getCategoria());
            pstm.setInt(6, produtos.getIdproduto());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso o update
            // contanto que as linhas estejam seguindo a numeração do String sql,
            //tanto faz a sua posisão depois do PreparedStatement pstm = cnt.prepareStatement(sql);

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Produtos produtos = (Produtos) object;
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
            String sql = "delete from produtos where idproduto=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, produtos.getIdproduto());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso a delete

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Object list(int id) {
        Produtos produtos = new Produtos();
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
            String sql = "select * from produtos where idproduto=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                produtos.setIdproduto(rs.getInt("idproduto"));
                produtos.setNome(rs.getString("nome"));
                produtos.setDescricao(rs.getString("descricao"));
                produtos.setValorCompra(rs.getDouble("valorCompra"));
                produtos.setValorVenda(rs.getDouble("valorVenda"));
                produtos.setCategoria(rs.getInt("categoria"));

            }

            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
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

            String sql = "select * from produtos ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next() == true) {
                Produtos produtos = new Produtos();
                produtos.setIdproduto(rs.getInt("idproduto"));
                produtos.setNome(rs.getString("nome"));
                produtos.setDescricao(rs.getString("descricao"));
                produtos.setValorCompra(rs.getDouble("valorCompra"));
                produtos.setValorVenda(rs.getDouble("valorVenda"));
                produtos.setCategoria(rs.getInt("categoria"));

                lista.add(produtos);
            }
            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lista;
    }
    /* public static void main(String[] args) {
      
        Produtos produtos = new Produtos();
        produtos.setIdproduto(2);
        produtos.setNome("ps4");
        produtos.setDescricao("O PlayStation 4, ou simplesmente PS 4, é o tão aguardado console da quarta geração da Sony, trazendo uma arquitetura semi-customizada da AMD com 8 GB de memória RAM GDDR5 compartilhada entre CPU e GPU (placa de vídeo).");
        produtos.setValorCompra(1000.00);
        produtos.setValorVenda(2000.00);
        produtos.setCategoria(1);
        Produtos_DAO produtos_DAO = new Produtos_DAO();
        produtos_DAO.insert(produtos);
        System.out.println("deu certo");
    }  */
}
