import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame implements ActionListener {

    private Tabuleiro tab = new Tabuleiro();
    private Botao botao[];

    public Janela() {
        super("Campo Minado");

        Container container = getContentPane();
        container.setLayout(new GridLayout(15,15));

        tab.preencheMatriz();
        tab.imprimeMatriz();

        botao = new Botao[totalBotoes(tab)];

        int i=0;
        int array[] = new int[2];
        for (int x=1; x<(tab.getLinhas()-1);x++) {
            for (int j=1; j<(tab.getColunas()-1);j++) {
                array[0]=x;
                array[1]=j;
                botao[i] = new Botao(array);
                botao[i].addActionListener(this);
                container.add(botao[i]);
                i++;
            }
        }
        setSize(700,700);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int totalBotoes(Tabuleiro t) {
        return (t.getLinhas() -1) * (t.getColunas() -1);
    }

    public void actionPerformed(ActionEvent ae) {
        Botao b = (Botao)ae.getSource();
        Icon bomba = new ImageIcon("bomba.png","bomba");

        int[] vetor = b.getArray();

        b.setText("");
        tab.insereMina(vetor[0],vetor[1]);
        b.setIcon(bomba);

        setaTotalBombas(vetor[0], vetor[1]);

        tab.imprimeMatriz();
    }

    public void setaTotalBombas (int x, int y) {
        if (!tab.retornaValor(x-1,y-1).equalsIgnoreCase("X")) {
            printVizinho(x-1, y-1);
        }
        if (!tab.retornaValor(x-1, y).equalsIgnoreCase("X")) {
            printVizinho(x-1, y);
        }
        if (!tab.retornaValor(x-1, y+1).equalsIgnoreCase("X")) {
            printVizinho(x-1, y+1);
        }
        if (!tab.retornaValor(x, y-1).equalsIgnoreCase("X")) {
            printVizinho(x, y-1);
        }
        if (!tab.retornaValor(x, y+1).equalsIgnoreCase("X")) {
            printVizinho(x, y+1);
        }
        if (!tab.retornaValor(x+1, y-1).equalsIgnoreCase("X")) {
            printVizinho(x+1, y-1);
        }
        if (!tab.retornaValor(x+1, y).equalsIgnoreCase("X")) {
            printVizinho(x+1, y);
        }
        if (!tab.retornaValor(x+1, y+1).equalsIgnoreCase("X")) {
            printVizinho(x+1, y+1);
        }
    }

    private void printVizinho(int x, int y) {
        Cores cores = new Cores();
        int numeroBombas;
        Botao b = findBotao(x, y);
        if (b != null) {
            numeroBombas = tab.verificaVizinho(x, y);
            if (numeroBombas > 0) {
                b.setText(String.valueOf(numeroBombas));
                b.setForeground(cores.verificaCor(numeroBombas));
                b.setFont(new Font("Tahoma", Font.BOLD, 18));
            }
        }
    }

    public Botao findBotao(int x, int y) {
        for (Botao botao1 : botao) {
            if (botao1.getArray()[0] == x && botao1.getArray()[1] == y) {
                return botao1;
            }
        }
        return null;
    }

    public static void main(String args[]) {
        Janela janela = new Janela();
    }
}