
package DAO;

import database.ConnectionFactory;
import entities.Ong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OngDAO {
    
    
    /*public boolean verificarOng(Ong ong)  throws Exceptiodfnhgsh-n {
        
        String sql = "select * from tb_ongs";
           
        try(Connection conn = LoginConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){ 
            
            ps.setInt(0,ong.getId());
            ps.setString(0, ong.getNome());
            ps.setString(0, ong.getEmail());
            ps.setString(0, ong.getEstado());
            ps.setString(0, ong.getTelefone());
            ps.setString(0, ong.getCausa());
            ps.setString(0, ong.getSite());
            
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
        
    }*/
    
    
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
                    String estado = rs.getString("estado");
                    String uf = rs.getString("UF");
                    String telefone = rs.getString("telefone");
                    String causa = rs.getString("causa");
                    String cnpj = rs.getString("cnpj");
                    String site = rs.getString("site");
                    ongs.add(new Ong (id, nome, email, estado, uf, telefone, causa, cnpj, site));
                }
            }
        }
        return ongs;
    }
            
        
    
    
    
    
    
}
