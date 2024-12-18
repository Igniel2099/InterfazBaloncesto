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
import java.awt.*;

public class TxtComponent extends JLabel {

    public TxtComponent(String texto) {
        super(texto); // Llamamos al constructor de JLabel con el texto inicial
    }

    public TxtComponent() {}
    
    

    // Método para cambiar el tamaño de la fuente
    public void cambiarTamañoFuente(int tamaño) {
        // Usar la fuente Segoe UI en diferentes tamaños
        Font nuevaFuente;
        switch (tamaño) {
            case 1: // Tamaño pequeño
                nuevaFuente = new Font("Segoe UI", Font.BOLD, 12); // Tamaño pequeño
                break;
            case 2: // Tamaño mediano
                nuevaFuente = new Font("Segoe UI", Font.BOLD, 16); // Tamaño mediano
                break;
            case 3: // Tamaño grande
                nuevaFuente = new Font("Segoe UI", Font.BOLD, 24); // Tamaño grande y negrita
                break;
            default:
                nuevaFuente = getFont(); // Si no es 1, 2 o 3, mantenemos la fuente actual
                break;
        }

        // Establecer la nueva fuente al JLabel
        setFont(nuevaFuente);
    }

    
}
