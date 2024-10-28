import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static JFrame frame;
    private static JPanel mainPanel;
    private static CardLayout cardLayout;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new JFrame("Sistema Multifuncional");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        createMainMenu();
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private static void createMainMenu() {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        menuPanel.setBackground(new Color(240, 248, 255)); // Alice Blue

        JLabel titleLabel = new JLabel("Menú Principal");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 51, 102)); // Dark Blue
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuPanel.add(titleLabel);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        String[] options = {
            "Calculadora numérica",
            "Algoritmo de números",
            "Multiplicaciones",
            "Papelería creativa",
            "Otra Opción",
            "Salir"
        };

        for (String option : options) {
            JButton button = createStyledButton(option);
            button.addActionListener(new MenuActionListener());
            menuPanel.add(button);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        mainPanel.add(menuPanel, "Menu");
        cardLayout.show(mainPanel, "Menu");
    }

    private static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 40));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBackground(new Color(230, 230, 250)); // Lavender
        button.setForeground(new Color(25, 25, 112)); // Midnight Blue
        button.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2)); // Steel Blue border
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Efecto hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(176, 196, 222)); // Light Steel Blue
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(230, 230, 250)); // Lavender
            }
        });

        return button;
    }

    private static class MenuActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Calculadora numérica":
                    new CalculadoraNumero().iniciar();
                    break;
                case "Algoritmo de números":
                    new AlgoritmosDeNumeros().iniciar();
                    break;
                case "Multiplicaciones":
                    new EjercicioMultiplicaciones().iniciar();
                    break;
                case "Papelería creativa":
                    new PapeleriaCreativa().iniciar();
                    break;
                case "Otra Opción":
                    JOptionPane.showMessageDialog(frame, "Esta opción aún no está implementada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Salir":
                    int response = JOptionPane.showConfirmDialog(frame, "¿Está seguro que desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                    break;
            }
        }
    }
}

