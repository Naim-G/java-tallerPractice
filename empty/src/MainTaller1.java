import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;
import java.util.Random;

/**
 * Taller 1 protector de pantalla Mystify
 *
 * @author Naim - Godoy Valdivia.
 */
public class MainTaller1 {

    /**
     * The Main.
     */

    public static void main(String[] args) {

        // Rango del protector
        double min = 0;
        double max = 600;

        // Definicion de la escala del protector
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        // Para evitar el parpadeo de la pantalla
        StdDraw.enableDoubleBuffering();

        // Declaraciones de las lineas del protector
        Color[] colores = {Color.BLACK, Color.BLUE, Color.MAGENTA, Color.GREEN, Color.RED, Color.CYAN};

        // Para limpiar la pantalla
        StdDraw.clear();

        // Para almacenar posiciones y velocidades
        double[][] x = new double[16][8];
        double[][] y = new double[12][6];

        // Generar posiciones y velocidades al azar para cada línea
        Random ramdom = new Random();
        for (int i = 0; i < 6; i++) {
            x[i][0] = ramdom.nextDouble() * 600;
            x[i][1] = ramdom.nextDouble() * 600;
            y[i][0] = ramdom.nextDouble() * 20 - 10;
            y[i][1] = ramdom.nextDouble() * 15 - 8;
        }

        while (true) {
            // Dibujar las líneas
            for (int i = 0; i < 6; i++) {
                // Para almacenar la posicion de la linea
                double[] pos = (i == 0) ? x[5] : x[i-1];
                x[i][0] += y[i][0];
                x[i][1] += y[i][1];

                // Que reboten si tocan un borde
                if (x[i][0] < 0 || x[i][0] > 800) {
                    y[i][0] = -y[i][0];
                }
                if (x[i][1] < 0 || x[i][1] > 600) {
                    y[i][1] = -y[i][1];
                }
                // Para establecer el color de las lineas
                StdDraw.setPenColor(colores[i]);
                StdDraw.line(x[i][0], x[i][1], pos[0], pos[1]);
            }
            // Me muestra las lineas
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}










