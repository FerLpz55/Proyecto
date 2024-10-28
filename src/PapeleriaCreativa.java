import javax.swing.*;

public class PapeleriaCreativa {

    public void iniciar() {
        String nombreCliente = obtenerNombreCliente();
        double descuento = seleccionarPromocion();

        // Inicializar cantidades y totales
        int cantidadLapices = 0, cantidadTemperas = 0, cantidadPinceles = 0, cantidadIcop = 0, cantidadEsferos = 0;
        double totalLapices = 0, totalTemperas = 0, totalPinceles = 0, totalIcop = 0, totalEsferos = 0;

        String continuar;

        do {
            int opcion = mostrarCatalogo();
            int cantidad = obtenerCantidad(); // Solicitar cantidad una sola vez

            switch (opcion) {
                case 1:
                    totalLapices += manejarLapices(cantidad);
                    cantidadLapices += cantidad;
                    break;
                case 2:
                    totalTemperas += manejarTemperas(cantidad);
                    cantidadTemperas += cantidad;
                    break;
                case 3:
                    totalPinceles += manejarPinceles(cantidad);
                    cantidadPinceles += cantidad;
                    break;
                case 4:
                    totalIcop += manejarIcop(cantidad);
                    cantidadIcop += cantidad;
                    break;
                case 5:
                    totalEsferos += manejarEsferos(cantidad);
                    cantidadEsferos += cantidad;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    break;
            }

            continuar = JOptionPane.showInputDialog("¿Quieres agregar algo más a tu carrito? (S/N)");
        } while (continuar.equalsIgnoreCase("S"));

        // Calcular totales
        double totalGeneral = totalLapices + totalTemperas + totalPinceles + totalIcop + totalEsferos;
        double totalIva = calcularIVA(cantidadLapices, cantidadTemperas, cantidadPinceles, cantidadIcop, cantidadEsferos);
        double totalConDescuento = totalGeneral * (1 - descuento);

        mostrarFactura(nombreCliente, cantidadLapices, cantidadTemperas, cantidadPinceles, cantidadIcop, cantidadEsferos,
                totalLapices, totalTemperas, totalPinceles, totalIcop, totalEsferos,
                totalGeneral, totalIva, descuento, totalConDescuento);

        seleccionarMetodoPago(totalConDescuento, totalIva);
    }

    private String obtenerNombreCliente() {
        return JOptionPane.showInputDialog("Por favor, ingresa tu nombre:");
    }

    private double seleccionarPromocion() {
        String[] opciones = {"Vuelta a Clases - 15% descuento", "Navidad Creativa - 20% descuento", "Verano - 10% descuento"};
        int temporada = JOptionPane.showOptionDialog(null, "Elige tu promoción por temporada:", "Promociones",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        switch (temporada) {
            case 0: return 0.15;
            case 1: return 0.20;
            case 2: return 0.10;
            default: return 0.0;
        }
    }

    private int mostrarCatalogo() {
        String menu = "***** CATÁLOGO DE PRODUCTOS *****\n" +
                "1. LAPICES\n" +
                "2. TEMPERAS\n" +
                "3. PINCELES\n" +
                "4. ICOP\n" +
                "5. ESFEROS\n" +
                "¿Qué te gustaría agregar a tu carrito hoy?";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    private double manejarLapices(int cantidad) {
        String menu = "***** LAPICES *****\n" +
                "1. HB2 - $2,500 COP\n" +
                "2. CARBONCILLO - $3,000 COP\n" +
                "3. MIRADO ROJO - $3,500 COP\n" +
                "DIGITE OPCIÓN:";
        int subopcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

        switch (subopcion) {
            case 1: return cantidad * 2500;
            case 2: return cantidad * 3000;
            case 3: return cantidad * 3500;
            default: return 0;
        }
    }

    private double manejarTemperas (int cantidad) {
        String menu = "***** TEMPERAS *****\n " +
                "1. VINILOS - $5,000 COP\n" +
                "2. ACRÍLICOS - $10,000 COP\n" +
                "3. ACUARELAS - $15,000 COP\n" +
                "DIGITE OPCIÓN:";
        int subopcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

        switch (subopcion) {
            case 1: return cantidad * 5000;
            case 2: return cantidad * 10000;
            case 3: return cantidad * 15000;
            default: return 0;
        }
    }

    private double manejarPinceles(int cantidad) {
        String menu = "***** PINCELES *****\n" +
                "1. PEQUEÑO - $3,000 COP\n" +
                "2. MEDIANO - $7,500 COP\n" +
                "3. GRANDE - $10,500 COP\n" +
                "DIGITE OPCIÓN:";
        int subopcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

        switch (subopcion) {
            case 1: return cantidad * 3000;
            case 2: return cantidad * 7500;
            case 3: return cantidad * 10500;
            default: return 0;
        }
    }

    private double manejarIcop(int cantidad) {
        return cantidad * 15000;
    }

    private double manejarEsferos(int cantidad) {
        String menu = "***** ESFEROS *****\n" +
                "1. AZUL - $2,000 COP\n" +
                "2. NEGRO - $2,500 COP\n" +
                "3. ROJO - $3,000 COP\n" +
                "DIGITE OPCIÓN:";
        int subopcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

        switch (subopcion) {
            case 1: return cantidad * 2000;
            case 2: return cantidad * 2500;
            case 3: return cantidad * 3000;
            default: return 0;
        }
    }

    private int obtenerCantidad() {
        return Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));
    }

    private double calcularIVA(int cantidadLapices, int cantidadTemperas, int cantidadPinceles, int cantidadIcop, int cantidadEsferos) {
        return cantidadLapices * 1100 + cantidadTemperas * 1000 + cantidadPinceles * 900 + cantidadIcop * 900 + cantidadEsferos * 500;
    }

    private void mostrarFactura(String nombreCliente, int cantidadLapices, int cantidadTemperas, int cantidadPinceles, int cantidadIcop, int cantidadEsferos,
                                double totalLapices, double totalTemperas, double totalPinceles, double totalIcop, double totalEsferos,
                                double totalGeneral, double totalIva, double descuento, double totalConDescuento) {
        String factura = "**************************************************\n" +
                "**                FACTURA FINAL                   **\n" +
                "**************************************************\n" +
                " PRODUCTO           VALOR/u         CANTIDAD     VALOR TOTAL\n" +
                "--------------------------------------------------\n" +
                "Lápices             $2,500 COP        " + cantidadLapices + "        $" + totalLapices + "\n" +
                "Témperas            $5,000 COP        " + cantidadTemperas + "        $" + totalTemperas + "\n" +
                "Pinceles            $3,000 COP        " + cantidadPinceles + "        $" + totalPinceles + "\n" +
                "ICOP                $15,000 COP       " + cantidadIcop + "        $" + totalIcop + "\n" +
                "Esferos             $2,000 COP        " + cantidadEsferos + "        $" + totalEsferos + "\n" +
                "--------------------------------------------------\n" +
                "Total general:                          $" + totalGeneral + "\n" +
                "IVA total:                             $" + totalIva + "\n" +
                "Descuento aplicado:                    $" + totalGeneral * descuento + "\n" +
                "Total con descuento:                   $" + totalConDescuento + "\n" +
                "**************************************************";
        JOptionPane.showMessageDialog(null, factura);
    }

    private void seleccionarMetodoPago(double totalConDescuento, double totalIva) {
        String[] opciones = {"Efectivo", "Tarjeta de Crédito/Débito", "Transferencia"};
        int opcionPago = JOptionPane.showOptionDialog(null, "Elige tu método de pago :", "Métodos de Pago",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        switch (opcionPago) {
            case 0:
                double montoIngresado = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el monto con el que deseas pagar:"));
                if (montoIngresado < totalConDescuento + totalIva) {
                    JOptionPane.showMessageDialog(null, "El monto ingresado es insuficiente. Por favor, intenta de nuevo.");
                } else {
                    double cambio = montoIngresado - (totalConDescuento + totalIva);
                    JOptionPane.showMessageDialog(null, "Tu cambio es: $" + cambio);
                }
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Has elegido pagar con tarjeta de crédito/débito.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Has elegido pagar por transferencia.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Método de pago no válido.");
                break;
        }
    }
}
