
package DAO;

import database.LoginConnectionFactory;
import entities.Administradores;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    
    public boolean verificaAdm(Administradores administradores) throws Exception{
        String sql = "select * from tb_administradores where login = ? and senha = ?";
        
        try(Connection conn = LoginConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){ 
            
            ps.setString(1, administradores.getLogin());
            ps.setString(2, administradores.getSenha());
            
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }
    
    public Administradores exibirAdm(String login) throws Exception{
        String sql = "select nome from tb_administradores where login = ? ";
        
        try(Connection conn = LoginConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)){
            
            ps.setString(1, login);
            //TSI limita a busca em relação ao banco de dados, qualquer alteração no bd não será afetado a busca no app
            //CUP
            ResultSet rs = ps.executeQuery();//le a querry
            Administradores adm = new Administradores();
            rs.first();//passa toda a lista do banco de dados
            adm.setLogin(login);
            adm.setNome(rs.getString("nome"));
            return adm;
            
            
        }
    }
    
    
}
