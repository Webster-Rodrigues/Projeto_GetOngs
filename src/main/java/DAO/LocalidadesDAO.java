
package DAO;

import database.ConnectionFactory;
import entities.Cidades;
import entities.UFs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class LocalidadesDAO {
    
    public List<Cidades> buscarCidades() throws Exception {
        String sql = "SELECT * FROM municipio"; //consulta no Banco de dados
        List<Cidades> cidades = new ArrayList<>();
        try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                 while (rs.next()){
                    int id = rs.getInt("id");
                    int ufid = rs.getInt("ufid");
                    String nome = rs.getString("nome");
                    
                    cidades.add(new Cidades(id, ufid, nome));
                 }
            }
            
        }
        return cidades;
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
