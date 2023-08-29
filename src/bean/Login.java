/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.Usuarios_DAO;

/**
 *
 * @author User
 */
public class Login {

    private int idUsuario;
    private String apelido;
    private String senha;

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean Login() {

        Usuarios_DAO usuarios_DAO = new Usuarios_DAO();
        Usuarios usuarios = usuarios_DAO.Login(apelido, senha);

        if (usuarios != null) {

            return true;
        } else {

            return false;
        }
    }
}
