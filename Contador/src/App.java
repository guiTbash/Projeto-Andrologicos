import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataBase.writeData();
        ArrayList<Patologia> defeitosMaiores = DataBase.readData1();
        ArrayList<Patologia> defeitosMenores = DataBase.readData2();
        ArrayList<Animal> listaAnimais = new ArrayList<Animal>();
        InterfaceGrafica ig = new InterfaceGrafica();
        ig.criaJanela(defeitosMaiores,defeitosMenores,listaAnimais);
    }
}