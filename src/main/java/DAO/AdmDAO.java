
package DAO;

import database.ConnectionFactory;
import entities.Administradores;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdmDAO {
    
    public boolean verificaAdm(Administradores administradores) throws Exception{
        String sql = "select * from tb_administradores where login = ? and senha = ?";
        
        try(Connection conn = ConnectionFactory.obtemConexao();
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
        
        try(Connection conn = ConnectionFactory.obtemConexao();
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
    
    
    public List<Administradores> buscarAdms() throws Exception{
        String sql = "SELECT * FROM tb_administradores";
        List<Administradores> adms = new ArrayList<>();
        
        try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    String login = rs.getString("login");
                    String senha = rs.getString("senha");
                    String nome = rs.getString("nome");
                    
                    adms.add(new Administradores(id, nome, login, senha));
                    
                }
            }
        }
        return adms; 
    }
    
    
    public void addAdms(Administradores adm)throws Exception{
        String sql = "insert into tb_administradores (login, senha, nome) values (?, ?, ?)";
        
        try(Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, adm.getLogin());
            ps.setString(2, adm.getSenha());
            ps.setString(3, adm.getNome());
            
            ps.execute();
            ps.close();
        }
        
        //DELETE FROM `db_getong`.`tb_administradores` WHERE (`id` = '2');
    }
    
    public void excluirAdm(Administradores administrador) throws Exception {
        String sql = "DELETE FROM tb_administradores WHERE id = ?";
        try (Connection c = ConnectionFactory.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, administrador.getId());
            ps.execute();
            ps.close();
        }
    }
    
    //possível verificação de adms por ID p/ exclusão
    /*public boolean verificarIdAdm(Administradores administradores) throws Exception{
        String sql = "SELECT id FROM tb_administradores  where id = ?";
        
        try(Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){ 

            try(ResultSet rs = ps.executeQuery()){
                int id = rs.getInt("id");
                return rs.next();
            }
        }
        
    }*/
    
    
    // tentativa combobox NÃO DEU CERTO 
    public Administradores[] obterIdAdm() throws Exception {
        String sql = "SELECT id FROM tb_administradores";
        try (Connection conn = ConnectionFactory.obtemConexao();
        PreparedStatement ps = conn.prepareStatement(sql,
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = ps.executeQuery()){
            int totalDeAdms = rs.last()? rs.getRow() : 0;
            Administradores [] adms = new Administradores [totalDeAdms];
            rs.beforeFirst();
            int contador = 0;
            
            while (rs.next()) {
                int id = rs.getInt("id");
                adms[contador++] = new Administradores(id); 
                
            } 
            return adms;
        }
    }
    
    public void attIdColuna() throws Exception {
        String sql = "ALTER TABLE tb_administradores  DROP id";
        String sqlatt = "ALTER TABLE tb_administradores ADD id INT NOT NULL AUTO_INCREMENT FIRST, ADD PRIMARY KEY (id)";
        
        try (Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.execute();
            ps.close();
        }
        
        try (Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sqlatt)) {
            ps.execute();
            ps.close();
        }
        
    }
    
    
    
    
    
    
    
    
}
