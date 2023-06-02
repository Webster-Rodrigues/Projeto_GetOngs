
package entities;


public class Administradores {
    private int id;
    public String nome;
    private String login;
    private String senha;
    
    public Administradores(){
    }

    public Administradores(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public Administradores(String nome){
        this.nome = nome;

    }

    public Administradores(String login, String senha, String nome) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
    }


    public Administradores(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Administradores(int id) {
        this.id = id;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
    
    @Override
    public String toString(){
        return nome;
    }


    
    
    
    

    

    
    
    
    
    
    
}
