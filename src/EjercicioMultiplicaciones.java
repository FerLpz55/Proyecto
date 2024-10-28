import javax.swing.*;

public class EjercicioMultiplicaciones {

    public void iniciar() {
        String op2;

        do {
            int op = Integer.parseInt(JOptionPane.showInputDialog("****------------------------------****"
                    + "\n** Tablas de Multiplicar         **"
                    + "\n**                              **"
                    + "\n** 1. Tablas en Orden Descendente  **"
                    + "\n** 2. Tablas en Orden Ascendente   **"
                    + "\n** 3. Salir                     **"
                    + "\n**                              **"
                    + "\n**--- Digita tu Opción: ---     **"));

            switch (op) {
                case 1:
                    // Opción 1: Tablas en orden descendente
                    realizarTablasDescendentes();
                    break;
                case 2:
                    // Opción 2: Tablas en orden ascendente
                    realizarTablasAscendentes();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa. ¡Hasta luego!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija otra opción.");
            }

            op2 = JOptionPane.showInputDialog("¿Desea continuar (s/n)?");
        } while (op2.equalsIgnoreCase("s"));
    }

    private void realizarTablasDescendentes() {
        int vi = obtenerValorInicio();
        int vf = obtenerValorFinal(vi);
        int vit = obtenerValorTabla("inicial");
        int vft = obtenerValorTabla("final");

        StringBuilder resultado = new StringBuilder();
        for (int ct = vit; ct <= vft; ct++) {
            for (int c = vf; c >= 1; c--) {
                int tab = ct * c;
                resultado.append(ct).append(" * ").append(c).append(" = ").append(tab).append("\n");
            }
            resultado.append("\n"); // Para agregar una línea en blanco
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    private void realizarTablasAscendentes() {
        int vi = obtenerValorInicio();
        int vf = obtenerValorFinal(vi);
        int vit = obtenerValorTabla("inicial");
        int vft = obtenerValorTabla("final");

        StringBuilder resultado = new StringBuilder();
        for (int ct = vit; ct <= vft; ct++) {
            for (int c = vi; c <= vf; c++) {
                int tab = ct * c;
                resultado.append(ct).append(" * ").append(c).append(" = ").append(tab).append("\n");
            }
            resultado.append("\n"); // Para agregar una línea en blanco
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    private int obtenerValorInicio() {
        int vi;
        do {
            vi = Integer.parseInt(JOptionPane.showInputDialog("Digita valor inicio entre 5 y 8: "));
            if (vi < 5 || vi > 8) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor válido entre 5 y 8.");
            }
        } while (vi < 5 || vi > 8);
        return vi;
    }

    private int obtenerValorFinal(int vi) {
        int vf;
        do {
            vf = Integer.parseInt(JOptionPane.showInputDialog("Digita valor final entre 1 y 20: "));
            if (vf < 1 || vf > 20) {
                JOptionPane.showMessageDialog(null, "Digite número entero entre 1 y 20.");
            } else if (vi > vf) {
                JOptionPane.showMessageDialog(null, "El valor inicial debe ser menor que el valor final.");
            }
        } while (vf < 1 || vf > 20 || vi > vf);
        return vf;
    }

    private int obtenerValorTabla(String tipo) {
        int valor;
        do {
            valor = Integer.parseInt(JOptionPane.showInputDialog("Digita valor " + tipo + " tabla entre 1 y 20: "));
            if (valor < 1 || valor > 20) {
                JOptionPane.showMessageDialog(null, "Digite número entero entre 1 y 20.");
            }
        } while (valor < 1 || valor > 20);
        return valor;
    }
}
