
package entities;


public class Administradores {
    
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
