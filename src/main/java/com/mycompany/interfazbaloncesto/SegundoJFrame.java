/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazbaloncesto;

/**
 *
 * @author walth
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SegundoJFrame extends JFrame {

    public SegundoJFrame() {
        System.out.println("Entro por aqui");
        
        // Configuración del Segundo JFrame
        setTitle("Segundo JFrame");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Inicia con DO_NOTHING_ON_CLOSE
        setLocationRelativeTo(null);
        
        // Añadir el texto largo en un JLabel
        String texto = """
                        Al utilizar nuestra aplicación de baloncesto, usted acepta que los datos ingresados,
                         tales como estadísticas de partidos, información de jugadores y equipos, serán almacenados en nuestra
                         base de datos para su posterior análisis y visualización. Estos datos son confidenciales y solo se
                         utilizarán dentro de la aplicación para mejorar su experiencia. Nos reservamos el derecho de modificar
                         las funcionalidades de la app o de suspender el acceso en caso de uso indebido o infracción de los
                         términos. Además, usted acepta que no se realizará ningún uso comercial de los datos sin su
                         consentimiento explícito. Cualquier actualización o cambio en las condiciones de uso será notificado
                         a través de la app.
                        """;
        
        // Crear un JLabel con el texto largo
        JLabel label = new JLabel("<html>" + texto.replace("\n", "<br>") + "</html>", SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Añadir un margen al JLabel
        label.setBorder(new EmptyBorder(20, 20, 20, 20)); // Margen de 20 píxeles en todos los lados
        
        add(label); // Añadimos el label en la parte superior
        
        // Crear un cuadro de verificación
        JCheckBox checkBox = new JCheckBox("Aceptar términos y condiciones");
        add(checkBox, "South"); // Colocamos el JCheckBox en la parte inferior

        // Acción del JCheckBox para cambiar el comportamiento del cierre
        checkBox.addActionListener(e -> {
            if (checkBox.isSelected()) {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cambiar a DISPOSE_ON_CLOSE si está marcado
            } else {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Mantener DO_NOTHING_ON_CLOSE si no está marcado
            }
        });
        
        // Hacer el JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear y mostrar el SegundoJFrame
        SegundoJFrame segundoFrame = new SegundoJFrame();
    }
}
