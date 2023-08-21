import java.util.ArrayList;

public class Animal {
    private String id;
    private ArrayList<Patologia> patologias;
    
    public Animal(String id, ArrayList<Patologia> patologias){
        this.id = id;
        this.patologias = patologias;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", patologias=" + patologias + "]";
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Patologia> getPatologias() {
        return patologias;
    }

    public void setPatologias(ArrayList<Patologia> patologias) {
        this.patologias = patologias;
    }
    
}
