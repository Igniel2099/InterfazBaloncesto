/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazbaloncesto;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;

import org.jfree.chart.ChartUtils;



/**
 *
 * @author walth
 */
public class CreateGraphics {
  
    public static void main(String[] args) {
        // Crear el dataset para el gráfico
        CreateGraphics cg = new CreateGraphics();
        DefaultPieDataset<String> dataset = cg.createDataset(100.0,45.5);

        // Crear el gráfico de dona
        JFreeChart chart = cg.createChart(dataset,new Color(0xB21B1B),new java.awt.Color(0x8C1919));

        // Guardar el gráfico como PNG en un directorio específico
        cg.saveChartAsPNG(chart, "C:\\Users\\walth\\Documents\\NetBeansProjects\\InterfazBaloncesto\\src\\main\\resources\\images\\ciclos.png");
    }
    
    
    
    public void saveChartAsPNG(JFreeChart chart, String filePath) {
        try {
            File file = new File(filePath);
            ChartUtils.saveChartAsPNG(file, chart, 80, 60); // Especifica el tamaño del gráfico
            System.out.println("Gráfico guardado como PNG en: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al guardar el gráfico.");
            e.printStackTrace();
        }
    }
   
    

    /**
     * Nose muy bien lo que hace
     * @param valor este es el valor que quiero que tome la primera sección y la segunda sección
     *              tomara el valor que reste hasta llegar a 100.
     * @param maxValue 
     * @return me retorna un dataset.
     */
    public DefaultPieDataset<String> createDataset(Double maxValue, Double valor) {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.setValue("Categoría A", valor);
        dataset.setValue("Categoría B", maxValue - valor);


        return dataset;
    }

    // Crear el gráfico de dona
    public JFreeChart createChart(DefaultPieDataset<String> dataset, Color color, Color backgroundColor) {
        // Crear el gráfico de anillo usando la función de fábrica
        JFreeChart chart = ChartFactory.createRingChart(
                "",  // Título
                dataset,               // Dataset
                false,                  // Mostrar leyenda
                false,                  // Mostrar tooltips
                false                  // No usar enlaces URL
        );

        // Obtener el plot del gráfico
        RingPlot plot = getRingPlot(chart);
        plot.setSectionPaint("Categoría A", color);      // Color especifico
        plot.setSectionPaint("Categoría B", Color.GRAY);
        plot.setOutlineVisible(false); // quitar el borde negro
        
        chart.setBackgroundPaint(backgroundColor); // color de fondo
        chart.getPlot().setBackgroundPaint(backgroundColor); // color de fondo
        
        
        return chart;
    }


    private RingPlot getRingPlot(JFreeChart chart) {
        RingPlot plot = (RingPlot) chart.getPlot();

        // Establecer la profundidad del anillo (agujero en el centro)
        plot.setSectionDepth(0.30);  // Esto define el tamaño del agujero

        // Cambiar el color del fondo del agujero (blanco)
        plot.setBackgroundPaint(Color.WHITE);

        // Hacer que los contornos de las secciones no sean visibles
        plot.setSectionOutlinesVisible(false);


        // Desactivar las etiquetas de las secciones
        plot.setLabelGenerator(null);  // No mostrar etiquetas
        
        // Quitar la sombra
        plot.setShadowPaint(null);
        
        return plot;
    }
}
