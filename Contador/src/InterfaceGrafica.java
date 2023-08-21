import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class InterfaceGrafica extends JFrame{
    
    int amostra = 1;
    int count = 0;
    int adder = 0;

    JFrame frame;
    JPanel painelEntrada;
    JPanel painelPlanilha;
    JPanel painelContador;

    DefaultTableModel modelo;
    JTable tabela;
    JScrollPane barraRolagem;
    
    JLabel labelID;
    JTextField entrada;
    JButton addButton;
    JButton startButton;


    Border borda;

    public InterfaceGrafica() {
        super();
    }

    public void criaPainelEntrada(){
        labelID = new  JLabel("Novo Animal:");
        entrada = new JTextField(20);
        addButton = new JButton("Adicionar");
        startButton = new JButton("Iniciar Análise");
        painelEntrada = new JPanel();
        painelEntrada.setLayout(new FlowLayout());
        painelEntrada.add(labelID);
        painelEntrada.add(entrada);
        painelEntrada.add(addButton);
        painelEntrada.add(startButton);
        
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

            }  
        });
    }

    public void criaTabela(ArrayList<Patologia> maiores,ArrayList<Patologia> menores, ArrayList<Animal> listaAnimais){
        modelo = new DefaultTableModel();
        tabela = new JTable(modelo); 
        modelo.addColumn("TOURO");

        Object [] dM = {"              DEFEITOS MAIORES"};
        modelo.addRow(dM);
        for(int i = 0; i < maiores.size();i++){
            Object [] linha = {maiores.get(i).getNome()};
            modelo.addRow(linha);  
        }
        
        Object [] dm = {"              DEFEITOS MENORES"};
        modelo.addRow(dm);
        for(int i = 0; i < menores.size();i++){
            Object [] linha = {menores.get(i).getNome()};
            modelo.addRow(linha);  
        }
        Object [] tp = {"TOTAL DE PATOLOGIAS"};
        Object [] cn = {"CÉLULAS NORMAIS"};
        Object [] tg = {"TOTAL GERAL"};
        modelo.addRow(tp);
        modelo.addRow(cn);
        modelo.addRow(tg);

        tabela.setRowHeight(14);
        
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn coluna1 = tabela.getColumnModel().getColumn(0);
        coluna1.setPreferredWidth(200);
        
        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        painelPlanilha.add(barraRolagem);
        
        entrada.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e){
                
            }
            
            @Override
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addButton.doClick();
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e){
                
            }
        });
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String coluna = entrada.getText();
                Animal animal = new Animal(coluna, new ArrayList<Patologia>());
                listaAnimais.add(animal);
                modelo.addColumn(coluna);
                entrada.setText("");
                
                tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                TableColumn coluna1 = tabela.getColumnModel().getColumn(0);
                coluna1.setPreferredWidth(200);
                
                int numCol = modelo.getColumnCount() - 1;
                
                tabela.setValueAt("---",0, numCol);
                for(int i = 1; i < 31; i++){
                    tabela.setValueAt("-",i, numCol);
                }
                tabela.setValueAt("---",31, numCol);
                for(int i = 32; i < 43; i++){
                    tabela.setValueAt("-",i, numCol);
                }               
                tabela.setValueAt("100",43, numCol);
                
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                for(int i = 1; i <= numCol; i++){
                    tabela.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
            }
        });
        
        
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tabela.requestFocus();
                
                count = 0;
                
                tabela.addKeyListener(new KeyListener() {
                    int numCol = tabela.getColumnModel().getColumnCount();
                    
                    @Override
                    public void keyTyped(KeyEvent e){}
                    
                    @Override
                    public void keyPressed(KeyEvent e){
                        System.out.println(e.getKeyCode());
                        if (e.getKeyCode() == KeyEvent.VK_8) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(42, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(42,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,42,amostra);
                                count++;
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_1) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(1, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(1,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,1,amostra);
                                count++;
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_2) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(5, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(5,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,5,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_3) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(39, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(39,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,39,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_4) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(3, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(3,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,3,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_5) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(29, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(29,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,29,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_6) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(34, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(34,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,34,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_7) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(22, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(22,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,22,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_9) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(7, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(7,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,7,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_0) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(8, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(8,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,8,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_MINUS) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(23, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(23,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,23,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_EQUALS) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(26, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(26,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,26,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_Q) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(2, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(2,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,2,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_W) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(4, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(4,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,4,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_E) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(6, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(6,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,6,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_R) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(9, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(9,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,9,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_T) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(10, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(10,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,10,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_Y) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(11, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(11,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,11,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_U) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(12, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(12,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,12,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_I) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(13, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(13,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,13,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_O) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(14, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(14,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,14,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_P) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(15, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(15,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,15,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(16, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(16,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,16,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_A) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(17, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(17,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,17,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_S) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(18, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(18,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,18,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_D) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(19, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(19,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,19,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_F) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(20, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(20,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,20,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_G) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(21, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(21,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,21,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_H) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(24, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(24,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,24,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_J) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(25, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(25,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,25,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_K) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(27, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(27,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,27,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_L) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(28, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(28,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,28,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_Z) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(30, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(30,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,30,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_X) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(32, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(32,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,32,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_C) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(33, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(33,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,33,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_V) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(35, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(35,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,35,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_B) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(36, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(36,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,36,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_N) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(37, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(37,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,37,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_M) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(38, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(38,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,38,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_COMMA) {
                            if(amostra < numCol){
                                if(tabela.getValueAt(40, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(40,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,40,amostra);
                                count++; 
                                
                                if(tabela.getValueAt(41, amostra).equals("-")){
                                    adder = 0;
                                }else{
                                    adder = (int)tabela.getValueAt(41,amostra);
                                }
                                adder++;
                                tabela.setValueAt(adder,41,amostra);
                            }
                        }
                        if (count >= 100){
                            count = 0;
                            amostra++;
                            Toolkit.getDefaultToolkit().beep();
                        } 
                    }
                    
                    @Override
                    public void keyReleased(KeyEvent e){}
                });
                
            }
        });
    }

    public void criaRodape(){
        
    }
    
    public void criaJanela(ArrayList<Patologia> maiores,ArrayList<Patologia> menores, ArrayList<Animal> listaAnimais){
        frame = new JFrame();
        
        //Criando aba da Planilha//
        painelPlanilha = new JPanel();
        painelPlanilha.setLayout(new BorderLayout());
        
        criaPainelEntrada();
        criaTabela(maiores, menores, listaAnimais);
        
        painelPlanilha.add(painelEntrada,BorderLayout.NORTH);
        painelPlanilha.add(barraRolagem,BorderLayout.CENTER);
        
        frame.add(painelPlanilha);
        //Criando aba Contador//
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(1766,768);
        frame.setVisible(true);
    }
}
