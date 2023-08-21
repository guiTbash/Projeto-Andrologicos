import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class DataBase {
    public static void writeData() throws IOException{
        String filename = "defeitos_maiores.dat";
        ObjectOutputStream output1 = new ObjectOutputStream(new FileOutputStream(filename));
        ArrayList<Patologia> defeitosMaiores = new ArrayList<>();
        defeitosMaiores.add(new Patologia("Knobbed Sperm (1)", '1'));
        defeitosMaiores.add(new Patologia("Rugoso(Q)",'q'));
        defeitosMaiores.add(new Patologia("Vesiculoso (4)",'2'));
        defeitosMaiores.add(new Patologia("Ausente (W)",'w'));
        defeitosMaiores.add(new Patologia("Gota Protoplasmática Proximal (2)", '2'));
        defeitosMaiores.add(new Patologia("Subdesenvolvido (E)",'e'));
        defeitosMaiores.add(new Patologia("Cauda enrolada na cabeça (9)",'9'));
        defeitosMaiores.add(new Patologia("Cabeça isolada patológica (0)",'0'));
        defeitosMaiores.add(new Patologia("Estreito na base (R)",'r'));
        defeitosMaiores.add(new Patologia("Piriforme (T)", 't'));
        defeitosMaiores.add(new Patologia("Pequeno anormal (Y)", 'y'));
        defeitosMaiores.add(new Patologia("Coloração anormal (U)",'u'));
        defeitosMaiores.add(new Patologia("Contorno anormal (I)",'i'));
        defeitosMaiores.add(new Patologia("Pouch Formation (O)",'o'));
        defeitosMaiores.add(new Patologia("Ulceração de cabeça (P)",'p'));
        defeitosMaiores.add(new Patologia("Outros defeitos (\\)",'\\'));
        defeitosMaiores.add(new Patologia("Dupla implantação de cauda (A)",'a'));
        defeitosMaiores.add(new Patologia("Dupla implantação de PI (S)",'s'));
        defeitosMaiores.add(new Patologia("Dupla implantação de cabeça (D)",'d'));
        defeitosMaiores.add(new Patologia("Fibrilação (F)",'f'));
        defeitosMaiores.add(new Patologia("Fraturada (G)",'g'));
        defeitosMaiores.add(new Patologia("Dag Defect (7)", '7'));
        defeitosMaiores.add(new Patologia("Stamp Defect (-)",'-'));
        defeitosMaiores.add(new Patologia("Crista Nuclear (H)", 'h'));
        defeitosMaiores.add(new Patologia("Edema (J)",'j'));
        defeitosMaiores.add(new Patologia("Pseudo Gota (=)",'='));
        defeitosMaiores.add(new Patologia("Desnuda (K)",'k'));
        defeitosMaiores.add(new Patologia("Outros Defeitos (L)",'l'));
        defeitosMaiores.add(new Patologia("Cauda Fortemente Dobrada (5)", '5'));
        defeitosMaiores.add(new Patologia("Dobrada com gota prot. distal (Z)",'z'));

        output1.writeObject(defeitosMaiores);
        output1.flush();
        output1.close();
        
        filename = "defeitos_menores.dat";
        ObjectOutputStream output2 = new ObjectOutputStream(new FileOutputStream(filename));
        ArrayList<Patologia> defeitosMenores = new ArrayList<>();
        defeitosMenores.add(new Patologia("Delgado (X)",'x'));
        defeitosMenores.add(new Patologia("Gigante,curto,long,peq normal (C)",'c'));
        defeitosMenores.add(new Patologia("Cabeça Isolada Normal (6)", '6'));
        defeitosMenores.add(new Patologia("Abaxial (V)",'v'));
        defeitosMenores.add(new Patologia("Retroaxial (B)",'b'));
        defeitosMenores.add(new Patologia("Oblíquo (N)",'n'));
        defeitosMenores.add(new Patologia("Cauda dobrada ou enrolada (M)",'m'));
        defeitosMenores.add(new Patologia("Gota Protoplasmática Distal (3)",'3'));
        defeitosMenores.add(new Patologia("Oblíquo (,)",','));
        
        output2.writeObject(defeitosMenores);
        output2.flush();
        output2.close();
    }
    
    public static ArrayList<Patologia> readData1() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Patologia> p  = null;
        String filename = "defeitos_maiores.dat";
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        p = (ArrayList<Patologia>) input.readObject();
        input.close();
        return p;
    }
    public static ArrayList<Patologia> readData2() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Patologia> p  = null;
        String filename = "defeitos_menores.dat";
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
        p = (ArrayList<Patologia>) input.readObject();
        input.close();
        return p;
    }
}
