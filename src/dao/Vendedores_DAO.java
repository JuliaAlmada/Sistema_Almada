/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Vendedores;
import java.sql.Connection;
import java.util.Date;
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
public class Vendedores_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Vendedores vendedores = (Vendedores) object;
        String url, user, password;

        url = "jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "julia_almada";
        password = "julia_almada";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            // Statement stm;
            //  stm = cnt.createStatement;

            String sql = "insert into vendedores values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendedores.getIdvendedor());
            pstm.setString(2, vendedores.getNome());
            pstm.setString(3, vendedores.getEmail());
            pstm.setString(4, vendedores.getEmailreserva());
            pstm.setString(5, vendedores.getCpf());
            pstm.setDate(6, new java.sql.Date(vendedores.getDatanascimento().getTime()));
            pstm.setString(7, vendedores.getCelular());
            pstm.setString(8, vendedores.getTelefone());
            pstm.setString(9, vendedores.getCarteiratrabalho());
            pstm.setString(10, vendedores.getBairro());
            pstm.setString(11, vendedores.getCidade());
            pstm.setString(12, vendedores.getPais());
            pstm.setString(13, vendedores.getEndereco());
            pstm.setString(14, vendedores.getCep());
            pstm.setInt(15, vendedores.getSexo());
            pstm.setString(16, vendedores.getAtivo());

            pstm.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Object object) {
        Vendedores vendedores = (Vendedores) object;
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
            String sql = "update vendedores set nome=?, email=?, emailreserva=?, cpf=?, datanascimento=?, celular=?, telefone=?,"
                    + " carteiratrabalho=?, bairro=?, cidade=?, pais=?, endereco=?,cep=?,sexo=?,ativo=? where idvendedor=? ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setString(1, vendedores.getNome());
            pstm.setString(2, vendedores.getEmail());
            pstm.setString(3, vendedores.getEmailreserva());
            pstm.setString(4, vendedores.getCpf());
            pstm.setDate(5, new java.sql.Date(vendedores.getDatanascimento().getTime()));
            pstm.setString(6, vendedores.getCelular());
            pstm.setString(7, vendedores.getTelefone());
            pstm.setString(8, vendedores.getCarteiratrabalho());
            pstm.setString(9, vendedores.getBairro());
            pstm.setString(10, vendedores.getCidade());
            pstm.setString(11, vendedores.getPais());
            pstm.setString(12, vendedores.getEndereco());
            pstm.setString(13, vendedores.getCep());
            pstm.setInt(14, vendedores.getSexo());
            pstm.setString(15, vendedores.getAtivo());
            pstm.setInt(16, vendedores.getIdvendedor());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso o update
            // contanto que as linhas estejam seguindo a numeração do String sql,
            //tanto faz a sua posisão depois do PreparedStatement pstm = cnt.prepareStatement(sql);

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Vendedores vendedores = (Vendedores) object;
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
            String sql = "delete from vendedores where idvendedor=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendedores.getIdvendedor());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso a delete

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Object list(int id) {
        Vendedores vendedores = new Vendedores();
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
            String sql = "select * from vendedores where idvendedor=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                vendedores.setIdvendedor(rs.getInt("idvendedor"));
                vendedores.setNome(rs.getString("nome"));
                vendedores.setEmail(rs.getString("email"));
                vendedores.setEmailreserva(rs.getString("emailreserva"));
                vendedores.setCpf(rs.getString("cpf"));
                vendedores.setDatanascimento(rs.getDate("datanascimento"));
                vendedores.setCelular(rs.getString("celular"));
                vendedores.setTelefone(rs.getString("telefone"));
                vendedores.setCarteiratrabalho(rs.getString("carteiratrabalho"));
                vendedores.setBairro(rs.getString("bairro"));
                vendedores.setCidade(rs.getString("cidade"));
                vendedores.setPais(rs.getString("pais"));
                vendedores.setEndereco(rs.getString("endereco"));
                vendedores.setCep(rs.getString("cep"));
                vendedores.setSexo(rs.getInt("sexo"));
                vendedores.setAtivo(rs.getString("ativo"));
            }

            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendedores;
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

            String sql = "select * from vendedores ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next() == true) {
                Vendedores vendedores = new Vendedores();
                vendedores.setIdvendedor(rs.getInt("idvendedor"));
                vendedores.setNome(rs.getString("nome"));
                vendedores.setEmail(rs.getString("email"));
                vendedores.setEmailreserva(rs.getString("emailreserva"));
                vendedores.setCpf(rs.getString("cpf"));
                vendedores.setDatanascimento(rs.getDate("datanascimento"));
                vendedores.setCelular(rs.getString("celular"));
                vendedores.setTelefone(rs.getString("telefone"));
                vendedores.setCarteiratrabalho(rs.getString("carteiratrabalho"));
                vendedores.setBairro(rs.getString("bairro"));
                vendedores.setCidade(rs.getString("cidade"));
                vendedores.setPais(rs.getString("pais"));
                vendedores.setEndereco(rs.getString("endereco"));
                vendedores.setCep(rs.getString("cep"));
                vendedores.setSexo(rs.getInt("sexo"));
                vendedores.setAtivo(rs.getString("ativo"));

                lista.add(vendedores);
            }
            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendedores_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lista;
    }

    /*public static void main(String[] args) {
        Vendedores vendedores = new Vendedores();
        vendedores.setIdvendedor(5);
        vendedores.setNome("Robert");
        vendedores.setEmail("robertinha@gmail.com");
        vendedores.setEmailreserva("paulateijando@gmail.com");
        vendedores.setCpf("14566668");
        // vendedores.setDatanascimento("12/12/2012");
        vendedores.setCelular("12345467");
        vendedores.setTelefone("29420822");
        vendedores.setCarteiratrabalho("0101010013");
        vendedores.setBairro("jardim cu");
        vendedores.setCidade("SimCity");
        vendedores.setPais("Ali do lado");
        vendedores.setEndereco("do lado da casa do jorge");
        vendedores.setCep("123");
        vendedores.setSexo(1);
        vendedores.setAtivo("S");
        Vendedores_DAO vendedores_DAO = new Vendedores_DAO();
        vendedores_DAO.insert(vendedores);
        System.out.println("DEU CERTO");

    }*/
}
