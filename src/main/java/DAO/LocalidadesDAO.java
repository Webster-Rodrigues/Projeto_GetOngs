
package DAO;

import database.ConnectionFactory;
import entities.Cidades;
import entities.UFs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class LocalidadesDAO {
    
    public List<Cidades> buscarCidades() throws Exception {
        String sql = "SELECT * FROM municipio ORDER BY nome ASC"; //consulta no Banco de dados
        List<Cidades> cidades = new ArrayList<>();
        try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                 while (rs.next()){
                    int id = rs.getInt("id");
                    int ufid = rs.getInt("ufid");
                    String nome = rs.getString("nome");
                    
                    cidades.add(new Cidades(id, nome));
                 }
            }
            
        }
        return cidades;
        
        //String SQL para buscar municipios de acordo com UFs 
        /*SELECT municipio.*, uf.nome as ufNome
          FROM municipio INNER JOIN  uf
          ON municipio.ufid = uf.id
          where ufid = ?*/
        
        //LEMBRANDO que precisa ter objetos associados AULA 281 Java completo
    }
    
    public List<Cidades> buscaPorUf (UFs ufcbx) throws Exception {
        
        String sql = "SELECT municipio.*, uf.nome as ufNome FROM municipio INNER JOIN  uf "
                + "ON municipio.ufid = uf.id "
                + "where ufid = ? ORDER BY nome"; 
        try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, ufcbx.getId());
            ResultSet rs = ps.executeQuery();
            List<Cidades> list = new ArrayList<>();
            Map<Integer, UFs> map = new HashMap<>();
            
            while(rs.next()){
            
                UFs uf = map.get(rs.getInt("ufid"));
                if(uf == null){
                    uf = instantiateUf(rs);
                    map.put(rs.getInt("ufid"), uf);
                }
                
                Cidades cid = instantiateCidade(rs, uf);
                list.add(cid);
            }
            return list;
        }
    }
    
    private UFs instantiateUf(ResultSet rs) throws SQLException {
		UFs uf = new UFs();
		new UFs();
		uf.setId(rs.getInt("ufid"));
		uf.setNome(rs.getString("ufNome"));
		return uf;
    }
    
    private Cidades instantiateCidade(ResultSet rs , UFs uf) throws SQLException {
		Cidades cid = new Cidades();
		new Cidades();
		cid.setId(rs.getInt("id"));
                cid.setNome(rs.getString("nome"));
                cid.setUf(uf);
                return cid;
    }
    
    
    public List<UFs> buscarUfs() throws Exception {
        String sql = "SELECT * FROM uf"; //consulta no Banco de dados
        List<UFs> ufs = new ArrayList<>();
        try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                 while (rs.next()){
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String sigla = rs.getString("sigla");
                    
                    ufs.add(new UFs(id, nome, sigla));
                 }
            }
            
        }
        return ufs;
    }
 
    
}
