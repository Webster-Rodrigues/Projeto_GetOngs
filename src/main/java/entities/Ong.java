
package entities;

import java.util.ArrayList;
import java.util.List;

public class Ong {
    
    private int id;
    private String nome;
    private String email;
    private String estado;
    private String uf;
    private String telefone;
    private String causa;
    private String cnpj;
    private String site;
    
    
    public Ong(){
        
    }

    public Ong(int id, String nome, String email, String estado, String uf, String telefone, String causa, String cnpj, String site) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.estado = estado;
        this.uf = uf;
        this.telefone = telefone;
        this.causa = causa;
        this.cnpj = cnpj;
        this.site = site;
    }

    public Ong(String nome, String email, String estado, String telefone, String causa, String cnpj, String site) {
        this.nome = nome;
        this.email = email;
        this.estado = estado;
        this.telefone = telefone;
        this.causa = causa;
        this.cnpj = cnpj;
        this.site = site;
    }

    public Ong(int id) {
        this.id = id;
    } 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    

    
       
    
    
    
    
}
