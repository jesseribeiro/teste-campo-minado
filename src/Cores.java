import java.awt.*;

public class Cores {

    public Color verificaCor (int numeroBombas) {
        switch (numeroBombas) {
            case 1:
                Color roxo = new Color(153,51,153);
                return roxo;
            case 2:
                Color azul = new Color(0,0,205);
                return azul;
            case 3:
                Color verde = new Color(0,100,0);
                return verde;
            case 4:
                Color amarelo = new Color(255,215,0);
                return amarelo;
            case 5:
                Color laranja = new Color(255,140,0);
                return laranja;
            case 6:
                Color vermelho = new Color(255,36,0);
                return vermelho;
            case 7:
                Color bordo = new Color(128,0,0);
                return bordo;
            case 8:
                Color rosa = new Color(255,20,147);
                return rosa;
        }
        return null;
    }
}
