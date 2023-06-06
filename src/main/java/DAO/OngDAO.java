
package DAO;

import database.ConnectionFactory;
import entities.Ong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OngDAO {
    
    
    public boolean verificarOng(Ong ong) throws Exception{
        
        String sql = "select * from tb_ongs WHERE cnpj = ?";
           
        try(Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){ 
            
            ps.setString(1, ong.getCnpj());
            
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
        
    }
    
    
    /*public List<Ong> buscarOngs() throws Exception {
        String sql = "SELECT * FROM tb_ongs"; //consulta no Banco de dados
        try (Connection conn = LoginConnectionFactory.obtemConexao(); PreparedStatement ps = conn.prepareStatement(
                sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); */
    
    
    public List<Ong> buscarOngs() throws Exception {
        String sql = "SELECT * FROM tb_ongs"; //consulta no Banco de dados
        List<Ong> ongs = new ArrayList<>();
        try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){

            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    String cidade = rs.getString("cidade");
                    String uf = rs.getString("UF");
                    String telefone = rs.getString("telefone");
                    String causa = rs.getString("causa");
                    String cnpj = rs.getString("cnpj");
                    String site = rs.getString("site");
                    String descricao = rs.getString("descricao");
                    ongs.add(new Ong(id, nome, email, cidade, uf, telefone, causa, cnpj, site, descricao));
                }
            }
        }
        return ongs;
    }
    
    
    public void addOng(Ong ong) throws Exception{
        String sql = "INSERT INTO tb_ongs (nome, email, cidade, UF, telefone, causa, cnpj, site) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            
            ps.setString(1, ong.getNome());
            ps.setString(2, ong.getEmail());
            ps.setString(3, ong.getCidade());
            ps.setString(4, ong.getUf());
            ps.setString(5, ong.getTelefone());
            ps.setString(6, ong.getCausa());
            ps.setString(7, ong.getCnpj());
            ps.setString(8, ong.getSite());
                        
            ps.execute();
            ps.close();
        }
                
    }
    
    public void removeOng(Ong ong) throws Exception{
        String sql = "DELETE FROM tb_ongs WHERE id = ?";
        try (Connection c = ConnectionFactory.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setInt(1, ong.getId());
            ps.execute();
            ps.close();
        }
    }
    
    public void attOngs(Ong ong)throws Exception{
        String sql = "UPDATE tb_ongs SET nome = ?, email = ?, cidade = ?, uf = ?, telefone = ?, causa = ?, cnpj = ?, site = ? WHERE id = ?";
        
        try (Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, ong.getNome());
            ps.setString(2, ong.getEmail());
            ps.setString(3, ong.getCidade());
            ps.setString(4, ong.getUf());
            ps.setString(5, ong.getTelefone());
            ps.setString(6, ong.getCausa());
            ps.setString(7, ong.getCnpj());
            ps.setString(8, ong.getSite());
            ps.setInt(9, ong.getId());
            ps.execute();
            ps.close();
             
         }
    }
    
    public void attIdColuna() throws Exception {
        String sql = "ALTER TABLE tb_ongs DROP id";
        String sqlatt = "ALTER TABLE tb_ongs ADD id INT NOT NULL AUTO_INCREMENT FIRST, ADD PRIMARY KEY (id)";
        
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
    
    public void attDescricao(Ong ong)throws Exception{
        
        String sql = "UPDATE tb_ongs SET descricao = ? WHERE id = ?";
        
        try (Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, ong.getDescricao());
            ps.setInt(2, ong.getId());
            ps.execute();
            ps.close();
        }
        
        
    }
            
        
 
    
}
