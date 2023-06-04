
package entities;

public class Cidades {
    private int id;
    private int ufid;
    private String nome;
    
    public Cidades(){
        
    }

    public Cidades(int id, int ufid, String nome) {
        this.id = id;
        this.ufid = ufid;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUfid() {
        return ufid;
    }

    public void setUfid(int ufid) {
        this.ufid = ufid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    @Override
    public String toString(){
        return nome;
    }
    
    
    
    
    
}
