import javax.swing.*;

public class Botao extends JButton {

    private int[] valor = new int[2];

    public Botao(int[] array) {
        super();
        valor[0]=array[0];
        valor[1]=array[1];
    }

    public int[] getArray() {
        return valor;
    }

    public int[] setArray(int a, int b) {
        valor[0] = a;
        valor[1] = b;
        return valor;
    }
}