// InterfazCalculadora.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCalculadora {
    private JFrame frame;
    private JTextField numeroField;
    private JLabel resultadoLabel;

    public InterfazCalculadora() {
        frame = new JFrame("Calculadora de Números");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel labelNumero = new JLabel("Ingrese un número:");
        numeroField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        resultadoLabel = new JLabel("");

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(numeroField.getText());

                    double raizCuadrada = CalculadoraNumeros.calcularRaizCuadrada(numero);
                    int cuadrado = CalculadoraNumeros.calcularCuadrado(numero);
                    int cubo = CalculadoraNumeros.calcularCubo(numero);

                    resultadoLabel.setText("Raíz cuadrada: " + raizCuadrada +
                            " | Cuadrado: " + cuadrado +
                            " | Cubo: " + cubo);
                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("Ingresa un número válido.");
                }
            }
        });

        frame.add(labelNumero);
        frame.add(numeroField);
        frame.add(calcularButton);
        frame.add(resultadoLabel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazCalculadora());
    }
}

