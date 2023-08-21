import java.io.Serializable;

public class Patologia implements Serializable{
    private final String nome; //Nome da Patologia
    private Integer quantidade;//Quantidade de células patológicas
    private Character atalho;//Tecla do teclado a ser digitada para a patologia correspondente

    public Patologia(String nome, Character atalho){
        this.nome = nome;
        this.atalho = atalho;
        this.quantidade = 0;
    }

    //Getters//
    public String getNome(){
        return this.nome;
    }

    public Integer getQuantidade(){
        return this.quantidade;
    }

    public Character getAtalho(){
        return this.atalho;
    }

    //Setters//
    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    public void setAtalho(Character atalho){
        this.atalho = atalho;
    }
    
    //Métodos da classe Patologia//
    public void incrementaQuantidade(){
        this.quantidade++;
    }

    public void decrementaQuantidade(){
        this.quantidade--;
    }

    @Override
    public String toString() {
        return "Patologia [nome=" + nome + ", quantidade=" + quantidade + ", atalho=" + atalho + "]";
    }
    
}
