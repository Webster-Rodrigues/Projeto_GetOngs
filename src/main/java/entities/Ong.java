
package entities;

import java.util.ArrayList;
import java.util.List;

public class Ong {
    
    private int id;
    private String nome;
    private String email;
    private String cidade;
    private String uf;
    private String telefone;
    private String causa;
    private String cnpj;
    private String site;
    private String descricao;
    
    
    public Ong(){
        
    }

    public Ong(int id, String nome, String email, String cidade, String uf, String telefone, String causa, String cnpj, String site) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.causa = causa;
        this.cnpj = cnpj;
        this.site = site;
    }

    public Ong(String nome, String email, String cidade, String uf, String telefone, String causa, String cnpj, String site) {
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.causa = causa;
        this.cnpj = cnpj;
        this.site = site;
    }

    public Ong(int id, String nome, String email, String telefone, String causa, String cnpj, String site) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.causa = causa;
        this.cnpj = cnpj;
        this.site = site;
    }

    public Ong(int id, String nome, String email, String cidade, String uf, String telefone, String causa, String cnpj, String site, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.causa = causa;
        this.cnpj = cnpj;
        this.site = site;
        this.descricao = descricao;
    }
    

    public Ong(String cnpj) {
        this.cnpj = cnpj;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    @Override
    public String toString(){
        return nome;
    }
    
    

    
       
    
    
    
    
}
