import javax.swing.*;

class AlgoritmosDeNumeros {
    private int num1, num2, num3;

    public void iniciar() {
        // Mensaje de bienvenida
        JOptionPane.showMessageDialog(null, "----------------------------------------------------------------------------------------\n" +
                "---------------------------------------Bienvenido---------------------------------------\n" +
                "------------Este Algoritmo está diseñado para indicar el orden de los números-----------\n" +
                "-----------------que sean ingresados por usted es decir le indicará---------------------\n" +
                "--------------------que número es mayor, medio, menor de los tres------------------------\n" +
                "----------------------------------------------------------------------------------------\n");

        // Leer números
        num1 = Integer.parseInt(JOptionPane.showInputDialog("Digita el primer número: "));
        num2 = Integer.parseInt(JOptionPane.showInputDialog("Digita el segundo número: "));
        num3 = Integer.parseInt(JOptionPane.showInputDialog("Digita el tercer número: "));

        // Comparar los números
        compararNumeros();
    }

    private void compararNumeros() {
        if (num1 == num2 && num1 == num3) {
            JOptionPane.showMessageDialog(null, "Los tres números son iguales y son: " +
                    "\nNúmero 1: " + num1 +
                    "\nNúmero 2: " + num2 +
                    "\nNúmero 3: " + num3);
        } else if (num1 == num2) {
            if (num1 > num3) {
                JOptionPane.showMessageDialog(null, "El primer y segundo número son iguales y mayores: " + num2 +
                        "\nEl tercer número es menor: " + num3);
            } else {
                JOptionPane.showMessageDialog(null, "El primer y segundo número son iguales y menores: " + num1 +
                        "\nEl tercer número es mayor: " + num3);
            }
        } else if (num1 == num3) {
            if (num1 > num2) {
                JOptionPane.showMessageDialog(null, "El primer y tercer número son iguales y mayores: " + num1 +
                        "\nEl segundo número es menor: " + num2);
            } else {
                JOptionPane.showMessageDialog(null, "El primer y tercer número son iguales y menores: " + num1 +
                        "\nEl segundo número es mayor: " + num2);
            }
        } else if (num2 == num3) {
            if (num2 > num1) {
                JOptionPane.showMessageDialog(null, "El segundo y tercer número son iguales y mayores: " + num3 +
                        "\nEl primer número es menor: " + num1);
            } else {
                JOptionPane.showMessageDialog(null, "El segundo y tercer número son iguales y menores: " + num2 +
                        "\nEl primer número es mayor: " + num1);
            }
        } else {
            if (num1 > num2 && num1 > num3) {
                JOptionPane.showMessageDialog(null, "El primer número es el mayor: " + num1);
                if (num2 > num3) {
                    JOptionPane.showMessageDialog(null, "El segundo número es el medio: " + num2 +
                            "\nEl tercer número es el menor: " + num3);
                } else {
                    JOptionPane.showMessageDialog(null, "El tercer número es el medio: " + num3 +
                            "\nEl segundo número es el menor: " + num2);
                }
            } else if (num2 > num1 && num2 > num3) {
                JOptionPane.showMessageDialog(null, "El segundo número es el mayor: " + num2);
                if (num1 > num3) {
                    JOptionPane.showMessageDialog(null, "El primer número es el medio: " + num1 +
                            "\nEl tercer número es el menor: " + num3);
                } else {
                    JOptionPane.showMessageDialog(null, "El tercer número es el medio: " + num3 +
                            "\nEl primer número es el menor: " + num1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El tercer número es el mayor: " + num3);
                if (num1 > num2) {
                    JOptionPane.showMessageDialog(null, "El primer número es el medio: " + num1 +
                            "\nEl segundo número es el menor: " + num2);
                } else {
                    JOptionPane.showMessageDialog(null, "El segundo número es el medio: " + num2 +
                            "\nEl primer número es el menor: " + num1);
                }
            }
        }
    }
}
