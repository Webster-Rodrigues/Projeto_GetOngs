
package entities;

public class Cidades {
    private int id;
    private UFs uf; //TÁ ERRADO AQUI PRECISA SER private UFs ufid; por causa da associação c/ banco
    private String nome;
    
    public Cidades(){
        
    }

    public Cidades(int id, UFs uf, String nome) {
        this.id = id;
        this.uf = uf;
        this.nome = nome;
    }
    
    public Cidades(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UFs getUf() {
        return uf;
    }

    public void setUf(UFs uf) {
        this.uf = uf;
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
