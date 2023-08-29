/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Clientes;
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
public class Clientes_DAO extends DAO_Abstract {

    public void Clientes_DAO() {

    }

    @Override
    public void insert(Object object) {
        Clientes clientes = (Clientes) object;
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

            String sql = "insert into clientes values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, clientes.getIdcliente());
            pstm.setString(2, clientes.getNome());
            pstm.setString(3, clientes.getEmail());
            pstm.setString(4, clientes.getCpf());
            pstm.setDate(5, new java.sql.Date(clientes.getDatanascimento().getTime()));
            pstm.setInt(6, clientes.getSexo());
            pstm.setString(7, clientes.getCelular());
            pstm.setString(8, clientes.getEmailreserva());
            pstm.setString(9, clientes.getEndereco());
            pstm.setString(10, clientes.getBairro());
            pstm.setString(11, clientes.getCidade());
            pstm.setString(12, clientes.getPais());
            pstm.setString(13, clientes.getCartaofidelidade());
            pstm.setString(14, clientes.getCep());
            pstm.setString(15, clientes.getAtivo());
            pstm.setString(16, clientes.getTelefone());
            pstm.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clientes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Clientes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Clientes clientes = (Clientes) object;
        String url, user, password;

        url = "jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "julia_almada";
        password = "julia_almada";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            // Statement stm;
            // stm = cnt.createStatement;
            String sql = "update clientes set nome=?, email=?, cpf=?, datanascimento=?, sexo=?, celular=?, emailreserva=?, endereco=?, bairro=?, cidade=?, pais=?, cartaofidelidade=?, cep=?, ativo=?, telefone=? where idcliente=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(16, clientes.getIdcliente());
            pstm.setString(1, clientes.getNome());
            pstm.setString(2, clientes.getEmail());
            pstm.setString(3, clientes.getCpf());
            pstm.setDate(4, new java.sql.Date(clientes.getDatanascimento().getTime()));
            pstm.setInt(5, clientes.getSexo());
            pstm.setString(6, clientes.getCelular());
            pstm.setString(7, clientes.getEmailreserva());
            pstm.setString(8, clientes.getEndereco());
            pstm.setString(9, clientes.getBairro());
            pstm.setString(10, clientes.getCidade());
            pstm.setString(11, clientes.getPais());
            pstm.setString(12, clientes.getCartaofidelidade());
            pstm.setString(13, clientes.getCep());
            pstm.setString(14, clientes.getAtivo());
            pstm.setString(15, clientes.getTelefone());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso o insert
            //  stm.executeUpdate(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clientes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Clientes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Clientes clientes = (Clientes) object;
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

            String sql = "delete from clientes where idcliente=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, clientes.getIdcliente());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso a delete
            // stm.executeUpdate(sql);            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clientes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Clientes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Clientes clientes = new Clientes();
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

            String sql = "select * from clientes where idcliente=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                clientes.setIdcliente(rs.getInt("idcliente"));
                clientes.setNome(rs.getString("nome"));
                clientes.setEmail(rs.getString("email"));
                clientes.setCpf(rs.getString("cpf"));
                clientes.setDatanascimento(rs.getDate("datanascimento"));
                clientes.setSexo(rs.getInt("sexo"));
                clientes.setCelular(rs.getString("celular"));
                clientes.setEmailreserva(rs.getString("emailreserva"));
                clientes.setEndereco(rs.getString("endereco"));
                clientes.setBairro(rs.getString("bairro"));
                clientes.setCidade(rs.getString("cidade"));
                clientes.setPais(rs.getString("pais"));
                clientes.setCartaofidelidade(rs.getString("cartaofidelidade"));
                clientes.setCep(rs.getString("cep"));
                clientes.setAtivo(rs.getString("ativo"));
                clientes.setTelefone(rs.getString("telefone"));
            }
            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clientes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Clientes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    @Override
    public List listAll() {

        String url, user, password;

        url =  "jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "julia_almada";
        password = "julia_almada";


        List lista = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            // Statement stm;
            //  stm = cnt.createStatement;

            String sql = "select * from clientes ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next() == true) {
                Clientes clientes = new Clientes();
                clientes.setIdcliente(rs.getInt("idcliente"));
                clientes.setNome(rs.getString("nome"));
                clientes.setEmail(rs.getString("email"));
                clientes.setCpf(rs.getString("cpf"));
                clientes.setDatanascimento(rs.getDate("datanascimento"));
                clientes.setSexo(rs.getInt("sexo"));
                clientes.setCelular(rs.getString("celular"));
                clientes.setEmailreserva(rs.getString("emailreserva"));
                clientes.setEndereco(rs.getString("endereco"));
                clientes.setBairro(rs.getString("bairro"));
                clientes.setCidade(rs.getString("cidade"));
                clientes.setPais(rs.getString("pais"));
                clientes.setCartaofidelidade(rs.getString("cartaofidelidade"));
                clientes.setCep(rs.getString("cep"));
                clientes.setAtivo(rs.getString("ativo"));
                clientes.setTelefone(rs.getString("telefone"));
                lista.add(clientes);
            }
            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clientes_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Clientes_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lista;
    }

    /*   public static void main(String[] args) {
        Clientes clientes = new Clientes();
        clientes.setIdcliente(12);
        clientes.setNome("E");
        clientes.setEmail("e@gmail.com");
        clientes.setCpf("4353534534");
        //   clientes.setDatanascimento(12/2021);
        clientes.setSexo("F");
        clientes.setCelular("6757567567");
        clientes.setEmailreserva("e@gmail.com");
        clientes.setEndereco("esquina");
        clientes.setBairro("cohab");
        clientes.setCidade("Carlos");
        clientes.setPais("Africa do Sul");
        clientes.setCartaofidelidade("6576758");
        clientes.setCep("78679900");
        clientes.setAtivo("S");
        clientes.setTelefone("473634534sss");
        Clientes_DAO clientes_DAO = new Clientes_DAO();
        clientes_DAO.insert(clientes);
        System.out.println("deu certo");
    }*/
}
