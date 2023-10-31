package linea;

import java.util.ArrayList;
import java.util.List;

public class Linea {
    private int base;
    private int altura;
    private char varianteTriunfo;
    private List<List<Player>> tablero;

    public Linea(int base, int altura, char varianteTriunfo) {
        this.base = base;
        this.altura = altura;
        this.varianteTriunfo = varianteTriunfo;
        this.tablero = new ArrayList<>();
        for (int i = 0; i < base; i++) {
            List<Player> columna = new ArrayList<>();
            for (int j = 0; j < altura; j++) {
                columna.add(null);
            }
            this.tablero.add(columna);
        }
    }

    public void playRedAt(int column) {
        for (int i = 0; i < altura; i++) {
            if (tablero.get(column).get(i) == null) {
                tablero.get(column).set(i, new PlayerRed());
                return;
            }
        }
        throw new IllegalArgumentException("Column is full.");
    }

    public void playBlueAt(int column) {
        for (int i = 0; i < altura; i++) {
            if (tablero.get(column).get(i) == null) {
                tablero.get(column).set(i, new PlayerBlue());
                return;
            }
        }
        throw new IllegalArgumentException("Column is full.");
    }



    public boolean finished() {
        // Verificar si hay 4 fichas en línea en cualquier dirección
        for (int i = 0; i < base; i++) {
            for (int j = 0; j < altura; j++) {
                Player player = tablero.get(i).get(j);
                if (player != null) {
                    String color = player.getColor();
                    if (checkLinea(i, j, 1, 0, color) || // horizontal
                            checkLinea(i, j, 0, 1, color) || // vertical
                            checkLinea(i, j, 1, 1, color) || // diagonal ascendente
                            checkLinea(i, j, 1, -1, color)) { // diagonal descendente
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private boolean checkLinea(int x, int y, int dx, int dy, String color) {
        for (int i = 0; i < 4; i++) {
            if (x < 0 || x >= base || y < 0 || y >= altura || tablero.get(x).get(y) == null || !tablero.get(x).get(y).getColor().equals(color)) {
                return false;
            }
            x += dx;
            y += dy;
        }
        return true;
    }




    public String show() {
        StringBuilder builder = new StringBuilder();
        for (int j = altura - 1; j >= 0; j--) {
            for (int i = 0; i < base; i++) {
                Player player = tablero.get(i).get(j);
                if (player == null) {
                    builder.append('.');
                } else if (player.getColor().equals("Rojo")) {
                    builder.append('R');
                } else if (player.getColor().equals("Azul")) {
                    builder.append('B');
                }
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    public List<List<Player>> getTablero() {
        return this.tablero;
    }

}
