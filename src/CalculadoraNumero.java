
import javax.swing.JOptionPane;

public class CalculadoraNumero {
    public void iniciar() {
        int opcion;
        String menu;
        do {
            menu = "********** CALCULADORA NUMÉRICA **********\n" +
                    "1. Múltiplos\n" +
                    "2. Impares\n" +
                    "3. Fibonacci\n" +
                    "4. Factorial\n" +
                    "5. A Español\n" +
                    "6. A Romanos\n" +
                    "7. A Inglés\n" +
                    "8. Primos\n" +
                    "9. Pares\n" +
                    "10. Salir\n" +
                    "*****************************************\n" +
                    "Seleccione una opción (1-10):";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Calculadora Numérica", JOptionPane.PLAIN_MESSAGE));
            switch (opcion) {
                case 1:
                    calcularMultiplos();
                    break;
                case 2:
                    calcularImpares();
                    break;
                case 3:
                    calcularFibonacci();
                    break;
                case 4:
                    calcularFactorial();
                    break;
                case 5:
                    convertirAEspanol();
                    break;
                case 6:
                    convertirARomanos();
                    break;
                case 7:
                    convertirAIngles();
                    break;
                case 8:
                    calcularPrimos();
                    break;
                case 9:
                    calcularPares();
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!", "Despedida", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese un número entre 1 y 10.",
                            "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 10);
    }

    private void calcularMultiplos() {
        int numeroMultiplo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número entre 1 y 20:"));
        StringBuilder resultado = new StringBuilder("Los múltiplos de " + numeroMultiplo + " hasta 200 son:\n");
        int sumaMultiplo = 0;
        for (int i = numeroMultiplo; i <= 200; i += numeroMultiplo) {
            resultado.append(i).append(" ");
            sumaMultiplo += i;
        }
        resultado.append("\nLa suma de los múltiplos es: ").append(sumaMultiplo);
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    private void calcularImpares() {
        StringBuilder resultado = new StringBuilder("Los números impares del 1 al 199 son:\n");
        int sumaImpar = 0;
        for (int i = 1; i < 200; i += 2) {
            resultado.append(i).append(" ");
            sumaImpar += i;
        }
        resultado.append("\nLa suma de los impares es: ").append(sumaImpar);
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    private void calcularFibonacci() {
        StringBuilder resultado = new StringBuilder("La secuencia de Fibonacci es:\n");
        int a = 0, b = 1;
        for (int i = 0; i < 15; i++) {
            resultado.append(a).append(" ");
            int suma = a + b;
            a = b;
            b = suma;
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    private void calcularFactorial() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número no negativo:"));
        long factorial = 1;
        StringBuilder resultado = new StringBuilder("El factorial de " + numero + " es:\n");
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
            resultado.append(i);
            if (i < numero) resultado.append(" * ");
        }
        resultado.append(" = ").append(factorial);
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    private void convertirAEspanol() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número entre 1 y 9999:"));
        String resultado = convertirNumeroAEspanol(numero);
        JOptionPane.showMessageDialog(null, "El número en español es: " + resultado);
    }

    private String convertirNumeroAEspanol(int numero) {
        // Aquí va la lógica de conversión a español
        // Esta lógica debe ser implementada correctamente
        // Ejemplo simple para números hasta 20
        String[] numeros = {
                "", "uno", "dos", "tres", "cuatro", "cinco",
                "seis", "siete", "ocho", "nueve", "diez",
                "once", "doce", "trece", "catorce", "quince",
                "dieciséis", "diecisiete", "dieciocho", "diecinueve", "veinte"
        };

        if (numero < 1 || numero > 20) {
            return "Número fuera de rango (1-20)";
        }
        return numeros[numero];
    }

    private void convertirARomanos() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número entre 1 y 3999:"));
        String resultado = convertirNumeroARomanos(numero);
        JOptionPane.showMessageDialog(null, "El número en romano es: " + resultado);
    }

    private String convertirNumeroARomanos(int numero) {
        if (numero < 1 || numero > 3999) {
            return "Número fuera de rango (1-3999)";
        }
        String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                resultado.append(romanos[i]);
                numero -= valores[i];
            }
        }
        return resultado.toString();
    }

    private void convertirAIngles() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número entre 1 y 9999:"));
        String resultado = convertirNumeroAIngles(numero);
        JOptionPane.showMessageDialog(null, "El número en inglés es: " + resultado);
    }

    private String convertirNumeroAIngles(int numero) {
        // Aquí va la lógica de conversión a inglés
        // Implementar la lógica similar a la de español
        // Este es un ejemplo simple para números hasta 20
        String[] numeros = {
                "", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen", "twenty"
        };

        if (numero < 1 || numero > 20) {
            return "Number out of range (1-20)";
        }
        return numeros[numero];
    }

    private void calcularPrimos() {
        StringBuilder resultado = new StringBuilder("Los números primos del 1 al 199 son:\n");
        int sumaPrimo = 0;
        for (int i = 1; i < 200; i++) {
            if (esPrimo(i)) {
                resultado.append(i).append(" ");
                sumaPrimo += i;
            }
        }
        resultado.append("\nLa suma de los primos es: ").append(sumaPrimo);
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    private boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    private void calcularPares() {
        StringBuilder resultado = new StringBuilder("Los números pares del 1 al 199 son:\n");
        int sumaPar = 0;
        for (int i = 2; i < 200; i += 2) {
            resultado.append(i).append(" ");
            sumaPar += i;
        }
        resultado.append("\nLa suma de los pares es: ").append(sumaPar);
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}